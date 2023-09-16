public class Student {
    private String name;
    private int id;
    private double[] grades;

    // constructor
    public Student(String name, int id, int numGrades) {
        this.name = name;
        this.id = id;
        this.grades = new double[numGrades];
    }

    // Setter for grades
    public void setGrade(int index, double grade) {
        if (index >= 0 && index < grades.length) {
            grades[index] = grade;
        } else {
            System.out.println("Invalid Grade");
        }
    }
    public double getAverageGrade(){
        double sum = 0;
        for(double grade : grades){
            sum += grade;
        }
        return sum / grades.length;
    }
    public void displayStudentInfo(){
        System.out.println("Name " + name);
        System.out.println("ID: " + id);
        System.out.println("Average Grade " + getAverageGrade());
    }
}
