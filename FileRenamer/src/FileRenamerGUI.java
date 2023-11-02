import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class FileRenamerGUI extends JFrame {
    private JTextField directoryField;
    private JTextField searchField;
    private JTextField replaceField;

    public FileRenamerGUI() {
        setTitle("File Renamer");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Directory Path: "));
        directoryField = new JTextField();
        add(directoryField);

        add(new JLabel("Search Text:"));
        searchField = new JTextField();
        add(searchField);

        add(new JLabel("Replace Text :"));
        replaceField = new JTextField();
        add(replaceField);

        JButton renameButton = new JButton("Rename Files");
        add(renameButton);

        renameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                renameFiles();
            }
        });
    }

    private void renameFiles() {
        String directoryPath = directoryField.getText();
        String search = searchField.getText();
        String replace = replaceField.getText();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            for (File file : files) {
                String oldName = file.getName();
                String newName = oldName.replace(search, replace);

                File newFile = new File(directory, newName);

                if (file.renameTo(newFile)) {
                    System.out.println("Renamed: " + oldName + " to " + newName);
                } else {
                    System.out.println("Error renaming: " + oldName);
                }
            }
        } else {
            System.err.println("Directory not found.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FileRenamerGUI renamerGUI = new FileRenamerGUI();
            renamerGUI.setVisible(true);
        });
    }
}
