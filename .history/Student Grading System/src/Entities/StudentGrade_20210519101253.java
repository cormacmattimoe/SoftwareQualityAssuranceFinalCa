package Entitites;



// Student is been described as having a name and list of modules 
// related to them

public class StudentGrade {

    private String studentName;
    private int grade;

    

    public StudentGrade() {
    }

    

    public String getStudentName() {
        return studentName;
    }



    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }



    public int getGrade() {
        return grade;
    }



    public void setGrade(int grade) {
        this.grade = grade;
    }



    @Override
    public String toString() {
        return 
        "Student{" +
                "studentName ='" + studentName + '\'' +
                ", Modules =" + grade +
                '}';
    }
}