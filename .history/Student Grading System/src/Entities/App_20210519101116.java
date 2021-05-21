import java.util.ArrayList;

// This class includes criteria name and studentgrades
public class Criterion {

    private String criteriaName;
    private ArrayList<StudentGrade> studentGrades = new ArrayList<>();

    public Criterion() {
    }

    

    
    public String getCriteriaName() {
        return criteriaName;
    }




    public void setCriteriaName(String criteriaName) {
        this.criteriaName = criteriaName;
    }




    public ArrayList<StudentGrade> getStudentGrades() {
        return studentGrades;
    }




    public void setStudentGrades(ArrayList<StudentGrade> studentGrades) {
        this.studentGrades = studentGrades;
    }


    public void addStudentGrade(StudentGrade studentGrade){
        this.studentGrades.add(studentGrade);
    }





    @Override
    public String toString() {
        return
                "Critertion name ='" + criteriaName + '\''
                 + ", Score=" + studentGrades;
    }
}
