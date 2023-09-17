import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame {
    private JTextField nameTextField;
    private JTextField idTextField;
    private JTextField gradeTextField;
    private JTextArea textArea;

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

        // Add components to the panel
        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(idLabel);
        panel.add(idTextField);
        panel.add(gradeLabel);
        panel.add(gradeTextField);
        panel.add(addButton);

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
        Student student = new Student(name, id, 1); // numGrades set to 1 for simplicity
        student.setGrade(0, grade);

        textArea.append("Name: " + student.getName());
        textArea.append("ID: " + student.getId());
        textArea.append("Grade: " + student.getGrade(0));

        // Clear input fields
        nameTextField.setText("");
        idTextField.setText("");
        gradeTextField.setText("");
    }

}
