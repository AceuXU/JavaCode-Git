import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class FileRenamerGUI extends JFrame {
    private JTextField directoryField;
    private JTextField searchField;
    private JTextField replaceField;

    public FileRenamerGUI() {
        setTitle("File Renamer");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setFocusable(false);

        Color darkMode = new Color(25, 25, 25);

        Color lightText = new Color(235, 245, 245);

        getContentPane().setBackground(darkMode);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Create labels and text fields
        JLabel directoryLabel = new JLabel("Directory Path:");
        directoryField = new JTextField(20);
        directoryLabel.setForeground(lightText);

        JLabel searchLabel = new JLabel("Search Text:");
        searchField = new JTextField(20);
        directoryLabel.setBackground(darkMode);
        searchLabel.setBackground(darkMode);
        searchLabel.setForeground(lightText);

        JLabel replaceLabel = new JLabel("Replace Text:");
        replaceField = new JTextField(20);
        directoryLabel.setForeground(lightText);
        replaceLabel.setBackground(darkMode);
        replaceLabel.setForeground(lightText);

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
        renameButton.setBackground(Color.BLACK);
        renameButton.setForeground(Color.WHITE);


        // Create a panel for the button
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(renameButton);

        // Add components to the main panel
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);

        mainPanel.add(buttonPanel, gbc);
        mainPanel.setBackground(darkMode);

        // Add the main panel to the frame
        add(mainPanel, BorderLayout.CENTER);

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
