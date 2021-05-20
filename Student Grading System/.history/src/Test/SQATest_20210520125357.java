package Test;


import java.util.ArrayList;

import Driver.Controller;
import Entities.Rubric;
import Entities.StudentGrade;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ResourceBundle.Control;

public class SQATest {

//    testing first commit to test suite
Controller controller = new Controller();
ArrayList<Rubric> listOfRubrics = new ArrayList<>();
 

    @Test
    public void testCreatingRubric()
    {
        assertTrue(controller.createRubric("Class1"));
        assertTrue(controller.createRubric("Class2"));
        assertTrue(controller.createRubric("Class3"));
        assertTrue(controller.createRubric("D67"));
        assertTrue(controller.createRubric("D68"));  
    }
    
    @Test
    public void testViewARubric()
    {
        assertTrue(controller.createRubric("Class1"));
        assertTrue(controller.createRubric("Class2"));
        assertTrue(controller.createRubric("Class3"));
        assertTrue(controller.createRubric("D67"));
        assertTrue(controller.createRubric("D68"));  
        Rubric r = new Rubric();
        r = controller.getARubric("Dan");
        assertFalse(r.getRubricName().equals("Dan"));
    }
    @Test
    public void testCreateDuplicate()
    {
        assertTrue(controller.createRubric("Paul"));
        assertFalse(controller.createRubric("Paul"));
        assertFalse(controller.createRubric("Paul"));
    }

    /*
    @Test
    public void notEmptyRubric()
    {
        Rubric r = controller.createRubric();
        assertTrue("Should be an object of rubric", r instanceof Rubric);
    }
    */

    @Test
    public void testCreateCrierion()
    {
        assertTrue(controller.createRubric("Class1"));
        assertTrue(controller.createCriterion("Class1", "C1"));
        assertTrue(controller.createCriterion("Class1", "C2"));
        assertTrue(controller.createCriterion("Class1", "C3"));
        assertTrue(controller.createCriterion("Class1", "C4"));
        assertTrue(controller.createCriterion("Class1", "C5"));
        assertTrue(controller.createCriterion("Class1", "C6"));
        assertTrue(controller.createCriterion("Class1", "C7"));
       
    }

    @Test
    public void duplicateCriteriaTest()
    {
        assertTrue(controller.createCriterion("Class1", "C1"));
        assertFalse(controller.createCriterion("Class1", "C1"));  
    }

    @Test
    public void criterionMoreThan9Test()
    {
        assertTrue(controller.createRubric("Class1"));
        assertTrue(controller.createCriterion("Class1", "C1"));
        assertTrue(controller.createCriterion("Class1", "C2"));
        assertTrue(controller.createCriterion("Class1", "C3"));
        assertTrue(controller.createCriterion("Class1", "C4"));
        assertTrue(controller.createCriterion("Class1", "C5"));
        assertTrue(controller.createCriterion("Class1", "C6"));
        assertTrue(controller.createCriterion("Class1", "C7"));
        assertTrue(controller.createCriterion("Class1", "C8"));
        assertTrue(controller.createCriterion("Class1", "C9"));
        assertFalse(controller.createCriterion("Class1", "C10"));  
    }

/*
	// 3. Test if Criterion can be added to Rubric
	@Test
	public void testAddingACriterionToRubric() {


		ArrayList<String> criterion = new ArrayList<>();

		criterion.add(new String("Design"));
		criterion.add(new String("Implementation"));
		criterion.add(new String("Testing"));
		criterion.add(new String("Documentation"));

		Rubric rubric = controller.createRubric("Software Quality Assurance"  );

		ArrayList<String> criterionList = controller.createCriterion("Extra", "rubric");

		assertEquals("Extra", criterionList.get(criterionList.size() - 1));

	}
    */

    // Test for creating a student grade in a rubric
   @Test	
   public void testCreateStudentGrade() {
	   Rubric rubric= controller.createNewRubric("DT354");
	   String sQACriterion="SQA";
	   String madCrierion="MAD";
	   controller.addCriterionToRubric(rubric, sQACriterion);
	   controller.addCriterionToRubric(rubric, madCrierion);
	   StudentGrade grade=controller.createStudentGrade(rubric,"Cormac",3);
	   HashMap<String, Integer> topicMarks=rubric.getGrades().get(0).getMarks();
	   assertEquals(new Integer(3),topicMarks.get(sQACriterion));
	   assertEquals(new Integer(3),topicMarks.get(madCrierion));
	   assertEquals("Cormac",grade.getStudentName());
   }
  
   //Test for students grades added successfully
   @Test	
   public void testGetGradesOfARubric() {
	   Rubric rubric=controller.createNewRubric("DT354");
       String sQACriterion="SQA";
	   String madCriterion="MAD";
	   controller.addCriterionToRubric(rubric, sQACriterion);
	   controller.addCriterionToRubric(rubric, madCriterion);
	   StudentGrade gStudentGrade = controller.createStudentGrade(rubric,"Tom",2);
       StudentGrade stGrade = controller.createStudentGrade(rubric,"Paul",1);
	   assertEquals(2,rubric.getGrades().size());
	   assertEquals("Tom",rubric.getGrades().get(0).getStudentName());
	   assertEquals("Paul",rubric.getGrades().get(1).getStudentName());
   }
   
   //Testing if average in rubric is correct
   @Test	
   public void testAverageOfARubric() {
	   Rubric rubric=controller.createNewRubric("DT354");
       String sQACriterion="SQA";
	   String madCriterion="MAD";
	   controller.addCriterionToRubric(rubric, sQACriterion);
	   controller.addCriterionToRubric(rubric, madCriterion);
	   StudentGrade grade=controller.createStudentGrade(rubric,"Tom",2);
	   StudentGrade grade2=controller.createStudentGrade(rubric,"Paul",3);
	   assertEquals(3.5,controller.getAverageForRubric(rubric),0.001);
   }

     //TESTS IF MINIMUM OF EVERY SCORE IN RUBRIC IS CALCULATED CORRECTLY
     @Test	
     public void testMinForRubric() {
        Rubric rubric=controller.createNewRubric("DT354");
         String designCriterion="Design";
         String testingCriterion="Testing";
         controller.addCriterionToRubric(rubric, designCriterion);
         controller.addCriterionToRubric(rubric, testingCriterion);
         StudentGrade grade=controller.createStudentGrade(rubric,"dave",4);
         StudentGrade grade2=controller.createStudentGrade(rubric,"adam",3);
         assertEquals(3,controller.getMinForRubric(rubric),0.001);
     }
   
   //TESTS IF MAXIMUM OF EVERY SCORE IN RUBRIC IS CALCULATED CORRECTLY
   @Test	
   public void testMaxForRubric() {
	   Rubric rubric=controller.createNewRubric("DT354");
       String sQACriterion="SQA";
	   String madCriterion="MAD";
	   controller.addCriterionToRubric(rubric, sQACriterion);
	   controller.addCriterionToRubric(rubric, madCriterion);
       StudentGrade grade =controller.createStudentGrade(rubric,"Tom",2);
	   StudentGrade grade2 =controller.createStudentGrade(rubric,"Paul",3);
	   assertEquals(4,controller.getMaxForRubric(rubric),0.001);
   }
   
   //TESTS IF STANDARD DEVIATION OF EVERY SCORE IN RUBRIC IS CALCULATED CORRECTLY
   @Test	
   public void testStandardDeviationForRubric() {
	   Rubric rubric=controller.createRubric("Construction");
	   String designCriterion="Design";
	   String testingCriterion="Testing";
	   controller.addCriterionToRubric(rubric, designCriterion);
	   controller.addCriterionToRubric(rubric, testingCriterion);
	   StudentGrade grade=controller.createStudentGrade(rubric,"dave",4);
	   StudentGrade grade2=controller.createStudentGrade(rubric,"adam",3);
	   assertEquals(0.5,controller.getStandardDeviationForRubric(rubric),0.001);
   }
   
   //TESTS IF AVERAGE OF EVERY SCORE IN CRITERION IS CALCULATED CORRECTLY
   @Test	
   public void testAverageForCriterion() {
	   Rubric rubric=controller.createRubric("Construction");
	   String designCriterion="Design";
	   String testingCriterion="Testing";
	   controller.addCriterionToRubric(rubric, designCriterion);
	   controller.addCriterionToRubric(rubric, testingCriterion);
	   StudentGrade grade=controller.createStudentGrade(rubric,"dave",4);
	   StudentGrade grade2=controller.createStudentGrade(rubric,"adam",3);
	   grade2.addMark(designCriterion,2);
	   StudentGrade grade3=controller.createStudentGrade(rubric,"paddy",5);
	   assertEquals(3.66,controller.getAverageForCriterion(rubric,designCriterion),0.01);
   }
   
   //TESTS IF MAXIMUM OF EVERY SCORE IN CRITERION IS CALCULATED CORRECTLY
   @Test	
   public void testMaxForCriterion() {
	   Rubric rubric=controller.createRubric("Construction");
	   String designCriterion="Design";
	   String testingCriterion="Testing";
	   controller.addCriterionToRubric(rubric, designCriterion);
	   controller.addCriterionToRubric(rubric, testingCriterion);
	   StudentGrade grade=controller.createStudentGrade(rubric,"dave",4);
	   StudentGrade grade2=controller.createStudentGrade(rubric,"adam",3);
	   grade2.addMark(designCriterion,2);
	   StudentGrade grade3=controller.createStudentGrade(rubric,"paddy",5);
	   assertEquals(5,controller.getMaxForCriterion(rubric,designCriterion),0.01);
   }
   
   //TESTS IF MINIMUM OF EVERY SCORE IN CRITERION IS CALCULATED CORRECTLY
   @Test	
   public void testMinForCriterion() {
	   Rubric rubric=controller.createRubric("Construction");
	   String designCriterion="Design";
	   String testingCriterion="Testing";
	   controller.addCriterionToRubric(rubric, designCriterion);
	   controller.addCriterionToRubric(rubric, testingCriterion);
	   StudentGrade grade=controller.createStudentGrade(rubric,"dave",4);
	   StudentGrade grade2=controller.createStudentGrade(rubric,"adam",3);
	   grade2.addMark(designCriterion,2);
	   StudentGrade grade3=controller.createStudentGrade(rubric,"paddy",5);
	   assertEquals(2,controller.getMinForCriterion(rubric,designCriterion),0.01);
   }
   
   //TESTS IF STANDARD DEVIATION OF EVERY SCORE IN CRITERION IS CALCULATED CORRECTLY
   @Test	
   public void testStandardDeviationForCriterion() {
	   Rubric rubric=controller.createRubric("Construction");
	   String designCriterion="Design";
	   String testingCriterion="Testing";
	   controller.addCriterionToRubric(rubric, designCriterion);
	   controller.addCriterionToRubric(rubric, testingCriterion);
	   StudentGrade grade=controller.createStudentGrade(rubric,"dave",4);
	   StudentGrade grade2=controller.createStudentGrade(rubric,"adam",3);
	   grade2.addMark(designCriterion,2);
	   StudentGrade grade3=controller.createStudentGrade(rubric,"paddy",5);
	   assertEquals(1.24,controller.getStandardDeviationForCriterion(rubric,designCriterion),0.01);
   }
   
   //TESTS IF CONTROLLER ADDS MARK TO CRITERION
   @Test	
   public void testControllerAddScoreToCriterion() {
	   String designCriterion="Design";
	   StudentGrade grade=new StudentGrade("dave");
	   controller.addMark(grade,designCriterion,3);
	   assertEquals(1,grade.getMarks().size());
	   assertEquals(3,grade.getScore(designCriterion));
   }
   
   //TESTS IF CONTROLLER RETRIEVES ALL GRADES FOR A SPECIFIC RUBRIC
   @Test	
   public void testControllerGetGradesInRubric() {
	   Rubric rubric=controller.createRubric("Construction");
	   String designCriterion="Design";
	   String testingCriterion="Testing";
	   controller.addCriterionToRubric(rubric, designCriterion);
	   controller.addCriterionToRubric(rubric, testingCriterion);
	   StudentGrade grade=controller.createStudentGrade(rubric,"dave",4);
	   StudentGrade grade2=controller.createStudentGrade(rubric,"adam",3);
	   assertEquals(2,controller.getAllGradesInRubric(rubric).size());
	   assertEquals("dave",controller.getAllGradesInRubric(rubric).get(0).getName());
	   assertEquals("adam",controller.getAllGradesInRubric(rubric).get(1).getName());
   }


    @Test
    public void getAllRubricsTest(){
       ArrayList<Rubric> emptyRubricList = new ArrayList<>();
       assertEquals(emptyRubricList, controller.getAllRubrics());

    }
   


}
