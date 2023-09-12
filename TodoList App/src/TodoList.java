import javax.swing.*;
import java.awt.*;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class TodoList extends JFrame {
    JFrame frame = new JFrame();
    TodoLogic logic = new TodoLogic();
    DefaultListModel<String> listModel;
    JList<String> taskList;
    JTextField taskField;
    JButton addButton;
    JButton editButton;
    JButton deleteButton;

    TodoList() {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // Handle the exception if Nimbus is not available
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setTitle("TodoApp");
        setResizable(true);
        setFocusable(false);
        getContentPane().setBackground(new Color(45, 45, 45));

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        taskField = new JTextField(30);
        taskField.setHorizontalAlignment(JTextField.CENTER);
        taskField.setFont(new Font("Times new Roman", Font.BOLD, 25));
        taskField.setForeground(new Color(233, 42, 19));
        taskField.setBackground(new Color(25, 25, 25));


        addButton = new JButton("Add Your Task");
        addButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        addButton.setForeground(Color.white);
        addButton.setBackground(Color.GRAY);

        editButton = new JButton("Edit");
        editButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        editButton.setForeground(Color.white);
        editButton.setBackground(Color.BLUE);

        deleteButton = new JButton("Delete");
        deleteButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        deleteButton.setForeground(Color.white);
        deleteButton.setBackground(Color.red);

        JPanel panel = new JPanel(new GridBagLayout()); // Use GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        // Center the text field within the frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 10, 0); // Add some vertical spacing
        panel.add(taskField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH; // Reset fill to both for other components
        gbc.insets = new Insets(0, 0, 0, 5); // Add spacing between components
        panel.add(addButton, gbc);

        gbc.gridx = 1; // Change this to 1 to position the "Edit" button to the right
        panel.add(editButton, gbc);

        // Create a new panel for the "Delete" button
        JPanel deletePanel = new JPanel();
        deletePanel.setLayout(new BorderLayout());
        deletePanel.add(deleteButton, BorderLayout.EAST);
        gbc.gridx = 0; // Change this to 0 to position the "Delete" button to the left
        gbc.gridy = 2;
        panel.add(deletePanel, gbc);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText().trim();
                if (!task.isEmpty()) {
                    logic.addTask(task);
                    listModel.addElement(task);

                    taskField.setText("");

                }
            }
        });
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    // Set the selected task in the text field for editing
                    taskField.setText(listModel.getElementAt(selectedIndex));
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    logic.deleteTask(selectedIndex);
                    listModel.remove(selectedIndex);
                    deleteSelectedTask();
                }
            }
        });
        // added code to add task by pressing enter button
        taskField.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "addTask");
        taskField.getActionMap().put("addTask", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTaskFromTextField();
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        mainPanel.add(taskField, BorderLayout.BEFORE_FIRST_LINE);
        mainPanel.add(panel, BorderLayout.PAGE_END);

        for (String task : logic.getTasks()) {
            listModel.addElement(task);
        }

        add(mainPanel);
    }

    private void addTaskFromTextField() {
        String task = taskField.getText().trim();
        if (!task.isEmpty()) {
            logic.addTask(task);
            listModel.addElement(task);
            taskField.setText("");
        }
    }

    private void editSelectedTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0) {
            String newTask = taskField.getText().trim();
            if (!newTask.isEmpty()) {
                logic.editTask(selectedIndex, newTask);
                listModel.setElementAt(newTask, selectedIndex);
                taskField.setText("");
            }
        }
    }
    private void deleteSelectedTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0) {
            logic.deleteTask(selectedIndex);
            listModel.remove(selectedIndex);
        }
    }

}