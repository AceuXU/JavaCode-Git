import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DiaryApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new DiaryFrame("My Personal Diary");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setVisible(true);
        });
    }
}

class DiaryFrame extends JFrame {
    private JTextArea diaryTextArea;
    private List<String> diaryEntries;
    private int currentEntryIndex;

    public DiaryFrame(String diaryApp) {
        super(diaryApp);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        diaryTextArea = new JTextArea();
        diaryTextArea.setLineWrap(true);
        diaryTextArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(diaryTextArea);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton saveButton = new JButton("Save Entry");
        saveButton.addActionListener(new SaveButtonListener());

        JButton prevButton = new JButton("Previous Entry");
        prevButton.addActionListener(new PrevButtonListener());

        JButton nextButton = new JButton("Next Entry");
        nextButton.addActionListener(new NextButtonListener());

        buttonPanel.add(saveButton);
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        diaryEntries = new ArrayList<>();
        currentEntryIndex = -1;

        this.add(panel);
    }

    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            saveDiaryEntry();
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

    private void saveDiaryEntry() {
        String entry = diaryTextArea.getText();
        if (!entry.trim().isEmpty()) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            diaryEntries.add("Date/Time: " + timestamp + "\n" + entry);
            currentEntryIndex = diaryEntries.size() - 1;
            diaryTextArea.setText("");
            JOptionPane.showMessageDialog(this, "Entry saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please enter an entry before saving.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void navigateToPreviousEntry() {
        if (currentEntryIndex > 0) {
            currentEntryIndex--;
            diaryTextArea.setText(diaryEntries.get(currentEntryIndex));
        }
    }

    private void navigateToNextEntry() {
        if (currentEntryIndex < diaryEntries.size() - 1) {
            currentEntryIndex++;
            diaryTextArea.setText(diaryEntries.get(currentEntryIndex));
        }
    }
}
