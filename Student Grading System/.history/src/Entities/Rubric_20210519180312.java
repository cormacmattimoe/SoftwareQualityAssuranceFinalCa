package Entities;


import java.util.ArrayList;

// Rubric is been described as having a student name 
// with an list of different criterias
public class Rubric {

    private String rubricName;
    private ArrayList<Criterion> criteria = new ArrayList<>();

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

    @Override
    public String toString() {
        return
                "Rubric name = " + rubricName 
    }
}