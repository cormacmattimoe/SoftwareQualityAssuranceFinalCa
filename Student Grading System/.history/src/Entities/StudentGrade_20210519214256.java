package Entities;

import java.util.ArrayList;

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

    //Method to create a list of the StudentGrdaes for each criterion in the rubic
	public ArrayList<Integer> getListOfGrades()
	{
		//List to represent the values of each studentgrade of criterion
		ArrayList<Integer> grades = new ArrayList<Integer>();

		//Loop to go through ecah question in the survey object
		for(Criterion q : this)
		{
			int value = q.getAnswer();
			responses.add(value);
		}

		//return the repsonse values
		return responses;
	}


	public int getGradesSum()
	{
		int sum = 0;
		for(int x : this.getListOfGrades())
		{
			sum+= x;
		}
		return sum;
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