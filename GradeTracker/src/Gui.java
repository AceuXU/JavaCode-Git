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
        setSize(400, 300);

        // Create a JPanel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        // Create JLabels and JTextFields for student information
        JLabel nameLabel = new JLabel("Name:");
        nameTextField = new JTextField(20);
        JLabel idLabel = new JLabel("ID:");
        idTextField = new JTextField(10);
        JLabel gradeLabel = new JLabel("Grade:");
        gradeTextField = new JTextField(5);

        // Create a JTextArea for displaying student information
        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);

        // Create a JButton to add students and display information
        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        // Create JButton to save data
        JButton saveButton = new JButton("Save Data");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });

        // Create JButton to load data
        JButton loadButton = new JButton("Load Data");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadData();
            }
        });

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

        // Add the panel and text area to the frame
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }

    private void addStudent() {
        String name = nameTextField.getText();
        int id = Integer.parseInt(idTextField.getText());
        double grade = Double.parseDouble(gradeTextField.getText());

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