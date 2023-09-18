import java.io.*;
import java.util.*;

public class Student implements Serializable {
    private String name;
    private int id;
    private Map<String, Double> courseGrades;

    // Constructor
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.courseGrades = new HashMap<>();
    }

    // Setter and Getter for name
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Setter and Getter for id
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Setter for grades
    public void setGrade(String course, double grade) {
        courseGrades.put(course, grade);
    }

    // Get a grade for a specific course
    public double getGrade(String course) {
        if (courseGrades.containsKey(course)) {
            return courseGrades.get(course);
        } else {
            System.out.println("Course not found");
            return -1; // or some default value
        }
    }

    public Set<String> getCourseNames() {
        return courseGrades.keySet();
    }

    public double getAverageGrade() {
        if (courseGrades.isEmpty()) {
            return 0;
        }

        double sum = 0;
        for (double grade : courseGrades.values()) {
            sum += grade;
        }
        return sum / courseGrades.size();
    }

    // Save student data to a file
    public static boolean saveToFile(Student student, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(student);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Load student data from a file
    public static Student loadFromFile(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Student) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Display student information
    public void displayStudentInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Average Grade: " + getAverageGrade());
        System.out.println("Course Grades:");
        for (Map.Entry<String, Double> entry : courseGrades.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}