import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.BreakIterator;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class DiaryApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new DiaryFrame("My Personal Diary");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(720, 650);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

class DiaryFrame extends JFrame {
    private JTextArea diaryTextArea;
    private List<String> diaryEntries;
    private int currentEntryIndex;
    private boolean isDarkMode;
    private JPanel panel;
    private Font customFont;

    private Font buttonFont;

    private JButton searchButton;
    private JTextField searchField;
    private JLabel wordCountLabel;

    // Stack to store undo and redo operations
    private Stack<String> undoStack;
    private Stack<String> redoStack;

    private JButton undoButton;
    private JButton redoButton;

    private Highlighter highlighter;
    private Highlighter.HighlightPainter highlightPainter;


    public DiaryFrame(String diaryApp) {
        super(diaryApp);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        customFont = new Font("Times New Roman", Font.BOLD, 20);
        buttonFont = new Font("Times New Roman", Font.BOLD, 15);

        diaryTextArea = new JTextArea();
        diaryTextArea.setLineWrap(true);
        diaryTextArea.setWrapStyleWord(true);
        diaryTextArea.setFont(customFont);

        // Added a DocumentListener to update word count in real-time
        diaryTextArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateWordCount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateWordCount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateWordCount();
            }
        });

        // custom Highlighter
        highlighter = new DefaultHighlighter();
        diaryTextArea.setHighlighter(highlighter);

        highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.DARK_GRAY);

        // Action object for common actions
        Action saveAction = new AbstractAction("Save Entry") {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveDiaryEntry();
            }
        };

        Action undoAction = new AbstractAction("Undo") {
            @Override
            public void actionPerformed(ActionEvent e) {
                undo();
            }
        };
        Action redoAction = new AbstractAction("Redo") {
            @Override
            public void actionPerformed(ActionEvent e) {
                redo();
            }
        };

        // keyboard shortcuts for the actions
        saveAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_S);
        saveAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));

        undoAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_Z);
        undoAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));

        redoAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_Y);
        redoAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK));

        JMenuItem saveMenuItem = new JMenuItem(saveAction);
        JMenuItem undoMenuItem = new JMenuItem(undoAction);
        JMenuItem redoMenuItem = new JMenuItem(redoAction);

        // menu and add menu items
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");

        fileMenu.add(saveMenuItem);
        fileMenu.add(undoMenuItem);
        fileMenu.add(redoMenuItem);

        // some action menu and shortcuts below -
        JMenuItem newEntryMenuItem = new JMenuItem("New Entry");
        newEntryMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        newEntryMenuItem.addActionListener(e -> createNewEntry());
        fileMenu.add(newEntryMenuItem);

        JMenuItem cutMenuItem = new JMenuItem("Cut");
        cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        cutMenuItem.addActionListener(e -> diaryTextArea.cut());
        editMenu.add(cutMenuItem);

        JMenuItem copyMenuItem = new JMenuItem("Copy");
        copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        copyMenuItem.addActionListener(e -> diaryTextArea.copy());
        editMenu.add(copyMenuItem);

        JMenuItem pasteMenuItem = new JMenuItem("Paste");
        pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        pasteMenuItem.addActionListener(e -> diaryTextArea.paste());
        editMenu.add(pasteMenuItem);

        JMenuItem deleteEntryMenuItem = new JMenuItem("Delete Entry");
        deleteEntryMenuItem.addActionListener(e -> deleteDiaryEntry());
        editMenu.add(deleteEntryMenuItem);

        JMenuItem searchMenuItem = new JMenuItem("Search");
        searchMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        searchMenuItem.addActionListener(e -> performSearch());
        editMenu.add(searchMenuItem);

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
        exitMenuItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitMenuItem);

        // menu bar
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        setJMenuBar(menuBar);

        // ScrollPane and Buttons

        JScrollPane scrollPane = new JScrollPane(diaryTextArea);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton saveButton = new JButton("Save Entry");
        saveButton.addActionListener(new SaveButtonListener());
        saveButton.setForeground(Color.white);
        saveButton.setBackground(Color.darkGray);
        saveButton.setFont(buttonFont);

        JButton editButton = new JButton("Edit Entry");
        editButton.addActionListener(new EditButtonListener());
        editButton.setForeground(Color.white);
        editButton.setBackground(Color.darkGray);
        editButton.setFont(buttonFont);

        JButton deleteButton = new JButton("Delete Entry");
        deleteButton.addActionListener(new DeleteButtonListener());
        deleteButton.setForeground(Color.white);
        deleteButton.setBackground(Color.darkGray);
        deleteButton.setFont(buttonFont);

        JButton prevButton = new JButton("Previous Entry");
        prevButton.addActionListener(new PrevButtonListener());
        prevButton.setForeground(Color.white);
        prevButton.setBackground(Color.darkGray);
        prevButton.setFont(buttonFont);

        JButton nextButton = new JButton("Next Entry");
        nextButton.addActionListener(new NextButtonListener());
        nextButton.setForeground(Color.white);
        nextButton.setBackground(Color.darkGray);
        nextButton.setFont(buttonFont);

        JButton darkModeButton = new JButton("Dark Mode");
        darkModeButton.addActionListener(new DarkModeButtonListener());
        darkModeButton.setForeground(Color.white);
        darkModeButton.setBackground(Color.darkGray);
        darkModeButton.setFont(buttonFont);

        JButton attachImageButton = new JButton("Attach Image");
        attachImageButton.addActionListener(new AttachImageButtonListener());
        attachImageButton.setForeground(Color.white);
        attachImageButton.setBackground(Color.darkGray);
        attachImageButton.setFont(buttonFont);

        JButton emojiButton = new JButton("✔");
        emojiButton.setForeground(Color.white);
        emojiButton.setBackground(Color.darkGray);

        JButton tagButton = new JButton("Add Tag");
        tagButton.addActionListener(new AddTagButtonListener());
        tagButton.setForeground(Color.white);
        tagButton.setBackground(Color.darkGray);
        tagButton.setFont(buttonFont);

        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        searchButton.addActionListener(new SearchButtonListener());
        searchButton.setForeground(Color.white);
        searchButton.setBackground(Color.darkGray);
        searchButton.setFont(buttonFont);

        // Initialize the undo and redo stacks
        undoStack = new Stack<>();
        redoStack = new Stack<>();

        undoButton = new JButton("Undo");
        undoButton.addActionListener(new UndoButtonListener());
        undoButton.setEnabled(true);
        undoButton.setForeground(Color.white);
        undoButton.setBackground(Color.darkGray);
        undoButton.setFont(buttonFont);

        redoButton = new JButton("Redo");
        redoButton.addActionListener(new RedoButtonListener());
        redoButton.setEnabled(true);
        redoButton.setForeground(Color.white);
        redoButton.setBackground(Color.darkGray);
        redoButton.setFont(buttonFont);

        wordCountLabel = new JLabel("Word Count: 0");
        wordCountLabel.setBackground(Color.black);

        buttonPanel.add(saveButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(darkModeButton);
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(emojiButton);
        buttonPanel.add(attachImageButton);
        buttonPanel.add(tagButton);
        buttonPanel.add(undoButton);
        buttonPanel.add(redoButton);

        buttonPanel.add(searchField);
        buttonPanel.add(searchButton);
        buttonPanel.add(wordCountLabel);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        diaryEntries = new ArrayList<>();
        currentEntryIndex = -1;
        isDarkMode = false;

        this.add(panel);
    }

    private void createNewEntry() {
        // Check if there are unsaved changes before creating a new entry
        if (isDirty()) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to save the current entry?", "Save Entry", JOptionPane.YES_NO_CANCEL_OPTION);

            if (choice == JOptionPane.YES_OPTION) {
                saveDiaryEntry();
            } else if (choice == JOptionPane.CANCEL_OPTION) {
                return;
            }
        }
        // Clear the text area to create a new entry
        diaryTextArea.setText("");
    }

    // ActionListener -
    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            saveDiaryEntry();
        }
    }

    private class EditButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            editDiaryEntry();
        }
    }

    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            deleteDiaryEntry();
        }
    }

    private class PrevButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            navigateToPreviousEntry();
        }
    }

    private class NextButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            navigateToNextEntry();
        }
    }

    private class DarkModeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            toggleDarkMode();
        }
    }

    private class EmoticonButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            insertEmoji("😊");
        }
    }

    private class AddTagButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            addTag();
        }
    }

    private class SearchButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            performSearch();
        }
    }

    private class UndoButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            undo();
        }
    }

    private class RedoButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            redo();
        }
    }

    // Methods below -

    // method for adding image-
    class AttachImageButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION){
                File selectedFile = fileChooser.getSelectedFile();
                // Handle the selected image file (e.g., copy it to a folder and store the path in your diary entry)
                String imagePath = ((File) selectedFile).getAbsolutePath();
                diaryTextArea.append("\n[Image: " + imagePath + "]");
            }
        }
    }

    // Perform the search operation
    private void performSearch() {
        String searchText = searchField.getText();
        if (searchText.isEmpty()) {
            clearHighlights();
            return;
        }

        String text = diaryTextArea.getText().toLowerCase();
        searchText = searchText.toLowerCase();

        int index = text.indexOf(searchText);
        if (index >= 0) {
            clearHighlights();
        }

        while (index >= 0) {
            int endIndex = index + searchText.length();
            highlightText(index, endIndex);
            index = text.indexOf(searchText, endIndex);
        }
    }


    // Highlight text in the text area
    private void highlightText(int startIndex, int endIndex) {
        try {
            highlighter.addHighlight(startIndex, endIndex, highlightPainter);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    // Clear highlights in the text-
    private void clearHighlights() {
        highlighter.removeAllHighlights();
    }

    // method for saving entry-
    private void saveDiaryEntry() {
        String entry = diaryTextArea.getText();
        if (!entry.trim().isEmpty()) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            diaryEntries.add("Date/Time: " + timestamp + "\n" + entry);
            currentEntryIndex = diaryEntries.size() - 1;
            diaryTextArea.setText("");

            undoStack.clear(); // Clear undo stack when a new entry is saved
            redoStack.clear(); // Clear redo stack

            updateButtons(); // Disable undo and redo buttons
            JOptionPane.showMessageDialog(this, "Entry saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please enter an entry before saving.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    // method for editing entry-
    private void editDiaryEntry() {
        String entry = diaryTextArea.getText();
        if (!entry.trim().isEmpty() && currentEntryIndex >= 0 && currentEntryIndex < diaryEntries.size()) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            String editedEntry = "Date/Time: " + timestamp + "\n" + entry;
            String previousEntry = diaryEntries.get(currentEntryIndex);
            diaryEntries.set(currentEntryIndex, editedEntry);
            diaryTextArea.setText(editedEntry); // Update the displayed text
            undoStack.push(previousEntry); // Push the previous entry to the undo stack
            clearRedoStack(); // Clear redo stack
            updateButtons(); // Enable undo button, disable redo button

            JOptionPane.showMessageDialog(this, "Entry edited successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please select an entry to edit.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    // code for word count-
    private void updateWordCount() {
        String text = diaryTextArea.getText();
        int wordCount = countWords(text);
        wordCountLabel.setText("Word Count: " + wordCount);
    }

    private int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        BreakIterator breakIterator = BreakIterator.getWordInstance();
        breakIterator.setText(text);

        int wordCount = 0;
        int lastIndex = 0;

        while (breakIterator.next() != BreakIterator.DONE) {
            String word = text.substring(lastIndex, breakIterator.current());
            if (Character.isLetterOrDigit(word.charAt(0))) {
                wordCount++;
            }
            lastIndex = breakIterator.current();
        }

        return wordCount;
    }

    // method for deleting the entry-
    private void deleteDiaryEntry() {
        if (currentEntryIndex >= 0 && currentEntryIndex < diaryEntries.size()) {
            String deletedEntry = diaryEntries.get(currentEntryIndex);
            diaryEntries.remove(currentEntryIndex);
            clearHighlights(); // Clear highlights when an entry is deleted
            if (diaryEntries.isEmpty()) {
                diaryTextArea.setText("");
                undoStack.clear(); // Clear undo stack when all entries are deleted
                redoStack.clear(); // Clear redo stack
                updateButtons(); // Disable undo and redo buttons
            } else {
                if (currentEntryIndex >= diaryEntries.size()) {
                    currentEntryIndex = diaryEntries.size() - 1;
                }
                diaryTextArea.setText(diaryEntries.get(currentEntryIndex));
            }
            undoStack.push(deletedEntry); // Push the deleted entry to the undo stack
            clearRedoStack(); // Clear redo stack
            updateButtons(); // Enable undo button, disable redo button
            JOptionPane.showMessageDialog(this, "Entry deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please select an entry to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    // code for navigate to next and previous entry-
    private void navigateToPreviousEntry() {
        if (currentEntryIndex > 0) {
            if (isDirty()) {
                saveEntryToUndoStack();
            }
            currentEntryIndex--;
            diaryTextArea.setText(diaryEntries.get(currentEntryIndex));
            updateButtons();
        }
    }

    private void navigateToNextEntry() {
        if (currentEntryIndex < diaryEntries.size() - 1) {
            if (isDirty()) {
                saveEntryToUndoStack();
            }
            currentEntryIndex++;
            diaryTextArea.setText(diaryEntries.get(currentEntryIndex));
            updateButtons();
        }
    }

    private boolean isDirty() {
        String currentText = diaryTextArea.getText();
        String previousEntry = diaryEntries.get(currentEntryIndex);
        return !currentText.equals(previousEntry);
    }

    // code for dark mode -
    private void toggleDarkMode() {
        isDarkMode = !isDarkMode;

        if (isDarkMode) {
            // dark mode colors
            panel.setBackground(Color.BLACK);
            diaryTextArea.setBackground(Color.DARK_GRAY);
            diaryTextArea.setForeground(Color.WHITE);
        } else {
            // Revert to light mode colors
            panel.setBackground(Color.WHITE);
            diaryTextArea.setBackground(Color.WHITE);
            diaryTextArea.setForeground(Color.BLACK);
        }
    }

    // code for adding emoji-
    private void insertEmoji(String emoji) {
        int caretPosition = diaryTextArea.getCaretPosition();
        diaryTextArea.insert(emoji, caretPosition);
    }

    // code for attaching tag-
    private void addTag() {
        String tag = JOptionPane.showInputDialog("Enter a tag:");
        if (tag != null && !tag.trim().isEmpty()) {
            diaryTextArea.insert("[" + tag + "]", diaryTextArea.getCaretPosition());
        }
    }

    // Inner class to represent a diary entry with a tag and content-
    private class DiaryEntry {
        private String tag;
        private String content;

        public DiaryEntry(String tag, String content) {
            this.tag = tag;
            this.content = content;
        }

        public String getTag() {
            return tag;
        }

        public String getContent() {
            return content;
        }
    }

    // undo and redo methods-
    private void saveEntryToUndoStack() {
        undoStack.push(diaryEntries.get(currentEntryIndex));
    }

    private void undo() {
        if (!undoStack.isEmpty()) {
            String currentText = diaryTextArea.getText();
            redoStack.push(currentText); // Push the current text to the redo stack
            String previousEntry = undoStack.pop(); // Pop the previous entry from the undo stack
            diaryEntries.set(currentEntryIndex, previousEntry);
            diaryTextArea.setText(previousEntry);
            updateButtons();
        }
    }

    private void redo() {
        if (!redoStack.isEmpty()) {
            String currentText = diaryTextArea.getText();
            undoStack.push(currentText); // Push the current text to the undo stack
            String nextEntry = redoStack.pop(); // Pop the next entry from the redo stack
            diaryEntries.set(currentEntryIndex, nextEntry);
            diaryTextArea.setText(nextEntry);
            updateButtons();
        }
    }

    private void clearRedoStack() {
        redoStack.clear();
    }

    private void updateButtons() {
        // Enable or disable undo and redo buttons
        boolean canUndo = !undoStack.isEmpty();
        boolean canRedo = !redoStack.isEmpty();
        undoButton.setEnabled(canUndo);
        redoButton.setEnabled(canRedo);
    }
}

