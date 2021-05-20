package Entities;

import java.util.ArrayList;
import java.util.HashMap;

// Student is been described as having a name and list of modules 
// related to them

public class StudentGrade {

    private String studentName;
    private int grade;
    ArrayList<Criterion> criteria = new ArrayList<Criterion>();
    HashMap<String, Integer> listOfAllMarks = new HashMap<String, Integer>();

    

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

    //ADDS SCORE TO THE SPECIFIED CRITERION
	public void addMark(String criterion, int score) {
		if(score<6 && score >0) {
		listOfAllMarks.put(criterion,score);
		}else {
			throw new IllegalArgumentException("Score must be between 1 and 5");
		}
	}

	//RETURNS SCORE OF CRITERION SPECIFIED CRITERION
	public int getScore(String criterion) {
		return listOfAllMarks.get(criterion);
	}
	
	//This is returning criterions marks
	public HashMap<String, Integer> getMarks(){
		return listOfAllMarks;
	}




    @Override
    public String toString() {
        return 
        "Student{" +
                "StudentName ='" + studentName + '\'' +
                ", Modules =" + grade +
                '}';
    }
}