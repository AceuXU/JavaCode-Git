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
        setSize(750, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));
        setLocationRelativeTo(null);


        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 5, 10);

        // Create labels and text fields
        JLabel directoryLabel = new JLabel("Directory Path:");
        directoryField = new JTextField(20);
        JLabel searchLabel = new JLabel("Search Text:");
        searchField = new JTextField(20);
        JLabel replaceLabel = new JLabel("Replace Text:");
        replaceField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(directoryLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(directoryField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(searchLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(searchField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(replaceLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(replaceField, gbc);

        // Create button
        JButton renameButton = new JButton("Rename Files");

        // Create a panel for the button
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(renameButton);

        // Add components to the main panel
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        mainPanel.add(buttonPanel, gbc);

        // Add the main panel to the frame
        add(mainPanel, BorderLayout.CENTER);

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
