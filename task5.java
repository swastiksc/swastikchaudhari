import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String rollNumber;
    private String grade;

    public Student(String name, String rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("Name: %s | Roll No: %s | Grade: %s", name, rollNumber, grade);
    }

    public String toCSV() {
        return name + "," + rollNumber + "," + grade;
    }

    public static Student fromCSV(String csv) {
        String[] parts = csv.split(",");
        if (parts.length == 3) {
            return new Student(parts[0], parts[1], parts[2]);
        }
        return null;
    }
}
