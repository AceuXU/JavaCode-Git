public class Main {
    public static void main(String[] args) {

        // GUI
        Gui gui = new Gui();

        Student student1 = new Student("Ratan", 1001,5);
        Student student2 = new Student("Anushka", 1002,4);

        // set Grades for students
        student1.setGrade(0,95);
        student1.setGrade(1,87);
        student1.setGrade(2,92);
        student1.setGrade(3,75);
        student1.setGrade(4, 88);

        student2.setGrade(0, 88);
        student2.setGrade(1, 76);
        student2.setGrade(2, 90);
        student2.setGrade(3, 82);

        System.out.println("Student 1 Information:");
        student1.displayStudentInfo();

        System.out.println("\nStudent 2 Information:");
        student2.displayStudentInfo();

    }
}
