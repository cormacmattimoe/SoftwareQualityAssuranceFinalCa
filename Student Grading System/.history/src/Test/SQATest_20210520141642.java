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
    public void  TestDuplicateCriteria()
    {
        assertTrue(controller.createCriterion("Class1", "C1"));
        assertTrue(controller.createCriterion("Class1", "C1"));  
    }

    @Test
    public void TestcriterionMoreThan9()
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
	   HashMap<String, Integer> criterionMarks=rubric.getGrades().get(0).getMarks();
	   assertEquals(new Integer(3),topicMarks.get(sQACriterion));
	   assertEquals(new Integer(3),topicMarks.get(madCrierion));
	   assertEquals("Cormac",grade.getStudentName());
   }
  
   //Testing if students grades added successfully
   @Test	
   public void testGetStudentGrades() {
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
   
      //Testing if average in rubric is calulated correctly
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

      //Testing if min in rubric is calulated correctly
     @Test	
     public void testMinForARubric() {
        Rubric rubric=controller.createNewRubric("DT354");
         String designCriterion="Design";
         String testingCriterion="Testing";
         controller.addCriterionToRubric(rubric, designCriterion);
         controller.addCriterionToRubric(rubric, testingCriterion);
         StudentGrade grade=controller.createStudentGrade(rubric,"dave",4);
         StudentGrade grade2=controller.createStudentGrade(rubric,"adam",3);
         assertEquals(3,controller.getMinForRubric(rubric),0.001);
     }
   
      //Testing if max in rubric is calulated correctly
   @Test	
   public void testMaxForARubric() {
	   Rubric rubric=controller.createNewRubric("DT354");
       String sQACriterion="SQA";
	   String madCriterion="MAD";
	   controller.addCriterionToRubric(rubric, sQACriterion);
	   controller.addCriterionToRubric(rubric, madCriterion);
       StudentGrade grade =controller.createStudentGrade(rubric,"Tom",2);
	   StudentGrade grade2 =controller.createStudentGrade(rubric,"Paul",3);
	   assertEquals(4,controller.getMaxForRubric(rubric),0.001);
   }
   
     //Testing if standardDeviation in rubric is calulated correctly
   @Test	
   public void testStandardDeviationForARubric() {
        Rubric rubric=controller.createNewRubric("DT354");
        String sQACriterion="SQA";
        String madCriterion="MAD";
        controller.addCriterionToRubric(rubric, sQACriterion);
        controller.addCriterionToRubric(rubric, madCriterion);
        StudentGrade grade =controller.createStudentGrade(rubric,"Tom",2);
        StudentGrade grade2 =controller.createStudentGrade(rubric,"Paul",3);
	    assertEquals(0.5,controller.getStandardDeviationForRubric(rubric),0.001);
   }
   

    @Test
    public void getAllRubricsTest(){
       ArrayList<Rubric> emptyRubricList = new ArrayList<>();
       assertEquals(emptyRubricList, controller.getAllRubrics());

    }
   


}
