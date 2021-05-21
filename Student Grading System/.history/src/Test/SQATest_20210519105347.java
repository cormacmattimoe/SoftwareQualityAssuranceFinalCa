package Test;

import java.util.ArrayList;

import Driver.Controller;
import Entities.Rubric;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SQATest {

//    testing first commit to test suite
Controller controller = new Controller();
ArrayList<Rubric> listOfRubrics = new ArrayList<>();

Rubric testRubric(){
    ArrayList<Student> testStudents = new ArrayList<>();
    ArrayList<String> criteria = new ArrayList<>();
    criteria.add("Account Check");
    criteria.add("Balance Sheet");
    criteria.add("COA");
    criteria.add("Endowment");

    ArrayList<StudentGrade> exampleGrades = new ArrayList<>();
    StudentGrade exampleGrade1 = new StudentGrade("Account Check", 5);
    StudentGrade exampleGrade2 = new StudentGrade("Balance Sheet", 3);
    StudentGrade exampleGrade3 = new StudentGrade("COA", 4);
    StudentGrade exampleGrade4 = new StudentGrade("Endowment", 5);

    exampleGrades.add(exampleGrade1);
    exampleGrades.add(exampleGrade2);
    exampleGrades.add(exampleGrade3);
    exampleGrades.add(exampleGrade4);

    Student testStudent = new Student("Chelsea Blakemore", exampleGrades);

    testStudents.add(testStudent);

    return new Rubric("Accounting", testStudents, criteria);

}



    @Test
    public void getAllRubricsTest(){
    ArrayList<Rubric> emptyRubricList = new ArrayList<>();
    ssertEquals(emptyRricList, controller.getAllRubrics());
}

    @Test
    public void getRubricByName(){
    ArrayList<Rubric> listORubrics = new ArrayList<>();
    rubrics.add(testRubric());
    assertEquals(controller.getRubricByName("Accounting", rubrics), testRubric().toString());

}


    
}
