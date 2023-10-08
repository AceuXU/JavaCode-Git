import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DiaryApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new DiaryFrame("My Personal Diary");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 500);
            frame.setVisible(true);
        });
    }
}

class DiaryFrame extends JFrame {
    private JTextArea diaryTextArea;

    public DiaryFrame(String title) {
        super(title);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        diaryTextArea = new JTextArea();
        diaryTextArea.setLineWrap(true);
        diaryTextArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(diaryTextArea);

        JButton saveButton = new JButton("Save Entry");
        saveButton.addActionListener(new SaveButtonListener());

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(saveButton, BorderLayout.SOUTH);

        this.add(panel);
    }

    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            saveDiaryEntry();
        }
    }

    private void saveDiaryEntry() {
        String entry = diaryTextArea.getText();
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        try (FileWriter writer = new FileWriter("diary.txt", true)) {
            writer.write("Date/Time: " + timestamp + "\n");
            writer.write(entry + "\n");
            writer.write("---------------------------------\n");
            writer.close();
            JOptionPane.showMessageDialog(this, "Entry saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            diaryTextArea.setText("");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving entry!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}