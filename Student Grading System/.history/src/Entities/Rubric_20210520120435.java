package Entities;




import java.util.ArrayList;
import java.util.Collections;

// Rubric is been described as having a student name 
// with an list of different criterias
public class Rubric {

    private String rubricName;

    //Collection to represent Criterions
    private ArrayList<Criterion> criteria = new ArrayList<>();
	//Collection to represent StudentGrades 
	private ArrayList<StudentGrade> studentGrades = new ArrayList<StudentGrade>();

    public Rubric() {
    }

    public Rubric(String rubricName, ArrayList<Criterion> criteria) {
        this.rubricName = rubricName;
        this.criteria = criteria;
    }

    public String getRubricName() {
        return rubricName;
    }

    public void setRubricName(String rubricName) {
        this.rubricName = rubricName;
    }


	

    public ArrayList<Criterion> getCriteria() {
        return criteria;
    }

    public void setCriteria(ArrayList<Criterion> criteria) {
        this.criteria = criteria;
    }

	



    public void addCriteria(Criterion criteria) {
        this.criteria.add(criteria);
    }

	//ADDS STUDENT GRADE TO RUBRIC
	public void addStudentGrade(StudentGrade grade) {
		.add(grade);
	}
	
	//Returns list 
	public List<StudentGrade> getGrades(){
		return listOfGrades;
	}



    //Method to return each studentGrades
	public ArrayList<StudentGrade> getGrades()
	{
		return this.studentGrades;
	}

	public int getMinValue()
	{
		int minValue = 0;
		ArrayList<Integer> valueList = new ArrayList<Integer>();
            //iterating
		for(StudentGrade stu : this.studentGrades) 
		{
			valueList.add(stu.getGrade()); 
		}
		minValue = Collections.min(valueList); 
		return minValue; 
	}

/*
    public int getMaxValue()
	{
		int maxValue = 0;
		ArrayList<Integer> valueList = new ArrayList<Integer>(); 
            //iterating 
		for(StudentGrade quest : this.questions)
		{
			valueList.add(quest.getAns()); 
        }
        //returning max
		maxValue = Collections.max(valueList); 
		return maxValue; 
    }

    public double getAverage()
	{
    //The sum of all question values - the starting value must be 0
		int total = 0;
		for(Questions quest:this.questions)
		{
            //value
			total+= quest.getAns();
		}

		//Calculate the mean
        double mean = (float)total/this.questions.size();
        return mean;  
    }
	*/

    @Override
    public String toString() {
        return
                "Rubric name from rubric class = " + rubricName;
    }
}