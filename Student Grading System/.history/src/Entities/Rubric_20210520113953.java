package Entities;




import java.util.ArrayList;

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
		for(Criterion cri : this.criteria) 
		{
			valueList.add(cri.getCriteriaName()); 
		}
		minValue = Collections.min(valueList); 
		return minValue; 
	}

    @Override
    public String toString() {
        return
                "Rubric name from rubric class = " + rubricName;
    }
}