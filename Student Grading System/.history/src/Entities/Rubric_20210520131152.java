package Entities;




import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Rubric is been described as having a student name 
// with an list of different criterias
public class Rubric {

    private String rubricName;

    //Collection to represent Criterions
    private ArrayList<Criterion> criteria = new ArrayList<>();
	List<String> criteriaList=new ArrayList<String>();
	//Collection to represent StudentGrades 
	private ArrayList<StudentGrade> studentGrades = new ArrayList<StudentGrade>();

    public Rubric() {
    }

	public Rubric(String name) {
		this.rubricName = name;
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

	//Add a criterion to a rubric
	public void addCriterion(String criterion) {
		if(criteria.size()<10) {
		criteriaList.add(criterion);
		}else {
			System.out.println("The rubric is full");
		}
	}


    public void addCriteria(Criterion criteria) {
        this.criteria.add(criteria);
    }

	//This returns a list of criterias in a list
	public List<String> getCriteriasString() {
		return criteriaList;
	}

	//ADDS STUDENT GRADE TO RUBRIC
	public void addStudentGrade(StudentGrade grade) {
		studentGrades.add(grade);
	}
	
	//Returns list 
	public List<StudentGrade> getGrades(){
		return studentGrades;
	}



    @Override
    public String toString() {
        return
                "Rubric name from rubric class = " + rubricName;
    }
}