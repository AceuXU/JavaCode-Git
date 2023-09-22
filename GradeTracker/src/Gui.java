import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Set;

public class Gui extends JFrame {
    private JTextField nameTextField;
    private JTextField idTextField;
    private JTextField gradeTextField;
    private JTextArea textArea;
    private Student student;

    public Gui() {
        super("Student Information"); // Set the window title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setResizable(true);

        // Create a JPanel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        Color darkColor = new Color(25, 25, 25); // RGB value for dark color

        // Create JLabels and JTextFields for student information
        JLabel nameLabel = new JLabel("Name:");
        nameTextField = new JTextField(20);
        nameLabel.setForeground(Color.white);
        nameTextField.setBackground(Color.darkGray);
        nameTextField.setForeground(Color.white);


        JLabel idLabel = new JLabel("ID:");
        idTextField = new JTextField(10);
        idLabel.setForeground(Color.white);
        idTextField.setBackground(Color.darkGray);
        idTextField.setForeground(Color.white);

        JLabel gradeLabel = new JLabel("Grade:");
        gradeTextField = new JTextField(5);
        gradeLabel.setForeground(Color.white);
        gradeTextField.setBackground(Color.darkGray);
        gradeTextField.setForeground(Color.white);

        // Create a JTextArea for displaying student information
        textArea = new JTextArea(15, 30);
        textArea.setBackground(darkColor);
        textArea.setForeground(Color.white);
        textArea.setEditable(false);

        // changing of fonts
        Font font = new Font("Montserrat", Font.PLAIN, 15);
        nameTextField.setFont(font);
        idTextField.setFont(font);
        gradeTextField.setFont(font);
        textArea.setFont(font);

        JButton addButton = new JButton("Add Student");
        JButton saveButton = new JButton("Save Data");
        JButton loadButton = new JButton("Load Data");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");

        // background color for buttons
        addButton.setBackground(Color.WHITE);
        saveButton.setBackground(Color.WHITE);
        loadButton.setBackground(Color.WHITE);
        editButton.setBackground(Color.WHITE);
        deleteButton.setBackground(Color.WHITE);

        // foreground (text) color for buttons
        addButton.setForeground(Color.darkGray);
        saveButton.setForeground(Color.darkGray);
        loadButton.setForeground(Color.darkGray);
        editButton.setForeground(Color.darkGray);
        deleteButton.setForeground(Color.darkGray);

        // Action lister for buttons -----
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadData();
            }
        });
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editStudent();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });


        // empty panels for spacing
//        JPanel space1 = new JPanel();
//        JPanel space2 = new JPanel();
//        space1.setPreferredSize(new Dimension(2, 2)); // Adjust the size as needed
//        space2.setPreferredSize(new Dimension(4, 4));

        // Add components to the panel
        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(idLabel);
        panel.add(idTextField);
        panel.add(gradeLabel);
        panel.add(gradeTextField);
        panel.add(addButton);
        panel.add(saveButton);
        panel.add(loadButton);
        panel.add(editButton);
        panel.add(deleteButton);
        panel.setBackground(darkColor);

        // Add the panel and text area to the frame
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);


        setKeyboardShortcuts(); // for keyboard shortcuts
        setVisible(true); // to make frame visible

    }

    // Method to set up keyboard shortcuts
    private void setKeyboardShortcuts() {
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getRootPane().getActionMap();

        // Ctrl+A keyboard shortcut for Add
        KeyStroke addKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK);
        inputMap.put(addKeyStroke, "addStudentAction");
        actionMap.put("addStudentAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        // Ctrl+S for Save
        KeyStroke saveKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK);
        inputMap.put(saveKeyStroke, "performSaveAction");
        actionMap.put("performSaveAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });

        // Ctrl+E for Edit
        KeyStroke editKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK);
        inputMap.put(editKeyStroke, "performEditAction");
        actionMap.put("performEditAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editStudent();
            }
        });

        // Ctrl+D for Delete
        KeyStroke deleteKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK);
        inputMap.put(deleteKeyStroke, "performDeleteAction");
        actionMap.put("performDeleteAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });
    }

    // method for adding student
    private void addStudent() {
        String name = nameTextField.getText();
        int id;
        double grade;

        try {
            id = Integer.parseInt(idTextField.getText());
            grade = Double.parseDouble(gradeTextField.getText());
        } catch (NumberFormatException e) {
            // added try and catch block to handle the error when user enters wrong data.
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numeric values for ID and Grade.");
            return; // Exit the method
        }

        // Create and display the student information
        student = new Student(name, id);
        student.setGrade("Course 1", grade); // Use a course name here

        textArea.append("Name: " + student.getName() + "\n");
        textArea.append("ID: " + student.getId() + "\n");
        textArea.append("Course 1 Grade: " + student.getGrade("Course 1") + "\n");

        // Clear input fields
        nameTextField.setText("");
        idTextField.setText("");
        gradeTextField.setText("");
    }

    // method for saving information
    private void saveData() {
        if (student != null) {
            String fileName = JOptionPane.showInputDialog(this, "Enter a filename to save data:");
            if (fileName != null) {
                if (Student.saveToFile(student, fileName)) {
                    JOptionPane.showMessageDialog(this, "Data saved to " + fileName);
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to save data.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No student data to save.");
        }
    }

    // method for loading saved data/info
    private void loadData() {
        String fileName = JOptionPane.showInputDialog(this, "Enter a filename to load data:");
        if (fileName != null) {
            student = Student.loadFromFile(fileName);
            if (student != null) {
                textArea.setText("Name: " + student.getName() + "\n");
                textArea.append("ID: " + student.getId() + "\n");
                // Display individual course grades here
                for (String course : student.getCourseNames()) {
                    textArea.append(course + " Grade: " + student.getGrade(course) + "\n");
                }
                JOptionPane.showMessageDialog(this, "Data loaded from " + fileName);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to load data.");
            }
        }
    }

    // method for editing student information
    private void editStudent() {
        String name = nameTextField.getText();
        int id;
        double grade;

        try {
            id = Integer.parseInt(idTextField.getText());
            grade = Double.parseDouble(gradeTextField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numeric values for ID and Grade.");
            return;
        }

        if (student != null) {
            student.setName(name);
            student.setId(id);
            student.setGrade("Course 1", grade);

            textArea.setText("Name: " + student.getName() + "\n");
            textArea.append("ID: " + student.getId() + "\n");
            textArea.append("Course 1 Grade: " + student.getGrade("Course 1") + "\n");

            nameTextField.setText("");
            idTextField.setText("");
            gradeTextField.setText("");

            JOptionPane.showMessageDialog(this, "Student data updated.");
        } else {
            JOptionPane.showMessageDialog(this, "No student data to edit.");
        }
    }

    // method for deleting student information/data
    private void deleteStudent() {
        if (student != null) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this student?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                student = null; // Delete the student record
                textArea.setText(""); // Clear the text area
                JOptionPane.showMessageDialog(this, "Student data deleted.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No student data to delete.");
        }
    }
}