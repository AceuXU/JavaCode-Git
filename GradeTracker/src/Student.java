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
    public void setGrade(int index, double grade) {
        if (index >= 0 && index < grades.length) {
            grades[index] = grade;
        } else {
            System.out.println("Invalid Grade");
        }
    }
    // Getter for grades at a specific index
    public double getGrade(int index) {
        if (index >= 0 && index < grades.length) {
            return grades[index];
        } else {
            System.out.println("Invalid Grade Index");
            return -1; // or some default value
        }
    }

    // Getter for the entire grades array
    public double[] getGrades() {
        return grades;
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
