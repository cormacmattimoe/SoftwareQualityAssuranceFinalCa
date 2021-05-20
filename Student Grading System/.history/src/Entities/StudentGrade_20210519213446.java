package Entities;





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

    //Method used to get the sum of graf to questions in a response
	public int getResponsesSum()
	{
		int sum = 0;
		for(int x : this.getResponses())
		{
			sum+= x;
		}
		return sum;
		


    @Override
    public String toString() {
        return 
        "Student{" +
                "studentName ='" + studentName + '\'' +
                ", Modules =" + grade +
                '}';
    }
}