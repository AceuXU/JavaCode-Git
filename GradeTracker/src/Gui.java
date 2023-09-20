import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        setSize(600, 500);
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


        JLabel idLabel = new JLabel("ID:");
        idTextField = new JTextField(10);
        idLabel.setForeground(Color.white);
        idTextField.setBackground(Color.darkGray);

        JLabel gradeLabel = new JLabel("Grade:");
        gradeTextField = new JTextField(5);
        gradeLabel.setForeground(Color.white);
        gradeTextField.setBackground(Color.darkGray);

        // Create a JTextArea for displaying student information
        textArea = new JTextArea(10, 30);
        textArea.setBackground(darkColor);
        textArea.setEditable(false);

        JButton addButton = new JButton("Add Student");
        JButton saveButton = new JButton("Save Data");
        JButton loadButton = new JButton("Load Data");

        // background color for buttons
        addButton.setBackground(Color.WHITE);
        saveButton.setBackground(Color.WHITE);
        loadButton.setBackground(Color.WHITE);

        // foreground (text) color for buttons
        addButton.setForeground(Color.darkGray);
        saveButton.setForeground(Color.darkGray);
        loadButton.setForeground(Color.darkGray);

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

        // empty panels for spacing
        JPanel space1 = new JPanel();
        JPanel space2 = new JPanel();
        space1.setPreferredSize(new Dimension(10, 10)); // Adjust the size as needed
        space2.setPreferredSize(new Dimension(10, 10));

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
        panel.add(space1);
        panel.add(space2);
        panel.setBackground(darkColor);

        // Add the panel and text area to the frame
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }

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
}