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
 

@Test
    public void testCreatingRubric()
    {
        Rubric rubric = controller.createRubric("Rubric1");
        assertTrue(controller.listOfRubrics.contains(rubric));
    }
    
    @Test
    public void testViewARubric()
    {
        controller.createRubric("Rubric1");
        controller.createRubric("Class2");
        controller.createRubric("Class3");
        controller.createRubric("D67");
        controller.createRubric("D68");  
        Rubric r = new Rubric();
        r = controller.getARubric("D68");
        assertTrue(r.getRubricName().equals("D68"));
    }
    @Test
    public void testCreatingDuplicateRubric()
    {
        controller.createRubric("Rubric1");
        controller.createRubric("Rubric1");
        assertTrue(controller.listOfRubrics.size()==1);
    }
    @Test
    public void testCreateCriterion()
    {
        Rubric rubric = controller.createRubric("DT354");
        controller.addCriterionToRubric(rubric,"C0");
        controller.addCriterionToRubric(rubric, "C1");
        controller.addCriterionToRubric(rubric, "C2");
        controller.addCriterionToRubric(rubric, "C3");
        controller.addCriterionToRubric(rubric, "C4");
        controller.addCriterionToRubric(rubric, "C5");
        controller.addCriterionToRubric(rubric, "C6");
        controller.addCriterionToRubric(rubric, "C7");
       
    }

    @Test
    public void testDuplicateCriteria()

    {
        Rubric rubric = controller.createRubric("DT354");
        controller.addCriterionToRubric(rubric, "C1");
        controller.addCriterionToRubric(rubric, "C1");
        assertTrue(controller.listOfRubrics.size()==1);
    }
        // Test for adding criterion to rubric
   @Test	
   public void testAddCriterionToARubric() {
	   Rubric rubric=controller.createRubric("DT354");
	   String sQACriterion ="SQA";
	   controller.addCriterionToRubric(rubric, sQACriterion);
	   assertEquals("SQA",rubric.getCriteriasString().get(0));
   }


    // Test for creating a student grade in a rubric
   @Test	
   public void testCreateStudentGrade() {
	   Rubric rubric = controller.createRubric("DT354");
	   String sQACriterion="SQA";
	   String madCriterion="MAD";
	   controller.addCriterionToRubric(rubric, sQACriterion);
	   controller.addCriterionToRubric(rubric, madCriterion);
       controller.addCriterionToRubric(rubric, madCriterion);
	   StudentGrade grade = controller.addStudentGradeToCriterion(rubric,"Cormac",3);
	   HashMap<String, Integer> criterionMarks = rubric.getStudentGrades().get(0).getCriterionMarks();
	   assertEquals(new Integer(3),criterionMarks.get(sQACriterion));
	   assertEquals(new Integer(3),criterionMarks.get(madCriterion));
	   assertEquals("Cormac",grade.getStudentName());
   }
  
   //Testing if students grades added successfully
   @Test	
   public void testGetStudentGrades() {
	   Rubric rubric = controller.createRubric("DT354");
       Rubric rubric2 = controller.createRubric("Dan");

       String sQACriterion="SQA";
	   String madCriterion="MAD";
	   controller.addCriterionToRubric(rubric, sQACriterion);
	   controller.addCriterionToRubric(rubric, madCriterion);
	   StudentGrade gStudentGrade = controller.addStudentGradeToCriterion(rubric,"Tom",4);
       StudentGrade stGrade = controller.addStudentGradeToCriterion(rubric,"Paul",3);
       StudentGrade gStudentGrades = controller.addStudentGradeToCriterion(rubric,"Mary",1);
       StudentGrade stGrades = controller.addStudentGradeToCriterion(rubric,"Dan",1);
       gStudentGrade.addMark(sQACriterion,1);
       stGrade.addMark(sQACriterion,1);
       gStudentGrades.addMark(sQACriterion,1);
       stGrades.addMark(sQACriterion,1);
	   assertEquals(4,rubric.getStudentGrades().size());
	   assertEquals("Tom",rubric.getStudentGrades().get(0).getStudentName());
	   assertEquals("Paul",rubric.getStudentGrades().get(1).getStudentName());
   }
   
    //Testing if average in rubric is calculated correctly
   @Test	
   public void testAverageOfARubric() {
	   Rubric rubric=controller.createRubric("DT354");
       String sQACriterion="SQA";
	   String madCriterion="MAD";
	   controller.addCriterionToRubric(rubric, sQACriterion);
	   controller.addCriterionToRubric(rubric, madCriterion);
	   StudentGrade grade=controller.addStudentGradeToCriterion(rubric,"Tom",2);
	   StudentGrade grade2=controller.addStudentGradeToCriterion(rubric,"Paul",3);

	   assertEquals(2.5,controller.getAverageForRubric(rubric),0.002);
   }

      //Testing if min in rubric is calulated correctly
     @Test	
     public void testMinForARubric() {
        Rubric rubric=controller.createRubric("DT354");
         String sQACriterion="SQA";
         String madCriterion="MAD";
         controller.addCriterionToRubric(rubric, sQACriterion);
         controller.addCriterionToRubric(rubric, madCriterion);
         StudentGrade grade =controller.addStudentGradeToCriterion(rubric,"Tom",2);
         StudentGrade grade2 =controller.addStudentGradeToCriterion(rubric,"Paul",3);
         StudentGrade grade3 =controller.addStudentGradeToCriterion(rubric,"Sean",4);
         assertEquals(2,controller.getMinForRubric(rubric),0.002);
     }
   
      //Testing if max in rubric is calulated correctly
   @Test	
   public void testMaxForARubric() {
	   Rubric rubric=controller.createRubric("DT354");
       String sQACriterion="SQA";
	   String madCriterion="MAD";
	   controller.addCriterionToRubric(rubric, sQACriterion);
	   controller.addCriterionToRubric(rubric, madCriterion);
       StudentGrade grade =controller.addStudentGradeToCriterion(rubric,"Tom",2);
	   StudentGrade grade2 =controller.addStudentGradeToCriterion(rubric,"Paul",3);
       StudentGrade grade3 =controller.addStudentGradeToCriterion(rubric,"Sean",4);
	   assertEquals(4,controller.getMaxForRubric(rubric),0.002);
   }
   
     //Testing if standardDeviation in rubric is calulated correctly
   @Test	
   public void testStandardDeviationForARubric() {
        Rubric rubric=controller.createRubric("DT354");
        String sQACriterion="SQA";
        String madCriterion="MAD";
        controller.addCriterionToRubric(rubric, sQACriterion);
        controller.addCriterionToRubric(rubric, madCriterion);
        StudentGrade grade =controller.addStudentGradeToCriterion(rubric,"Tom",2);
        StudentGrade grade2 =controller.addStudentGradeToCriterion(rubric,"Paul",3);
        StudentGrade grade3 =controller.addStudentGradeToCriterion(rubric,"Sean",1);
	    assertEquals(0.816,controller.getStandardDeviationForRubric(rubric),0.002);
   }


    //Testing if average in criterion is calulated correctly
   @Test	
   public void testAverageForCriterion() {
    Rubric rubric=controller.createRubric("DT354");
    String sQACriterion="SQA";
    String madCriterion="MAD";
    controller.addCriterionToRubric(rubric, sQACriterion);
    controller.addCriterionToRubric(rubric, madCriterion);
    StudentGrade gStudentGrade = controller.addStudentGradeToCriterion(rubric,"Tom",4);
    StudentGrade stGrade = controller.addStudentGradeToCriterion(rubric,"Paul",3);
    StudentGrade gStudentGrades = controller.addStudentGradeToCriterion(rubric,"Mary",1);
    StudentGrade stGrades = controller.addStudentGradeToCriterion(rubric,"Dan",1);
    StudentGrade gSt = controller.addStudentGradeToCriterion(rubric,"Gary",5);
    StudentGrade gstudent = controller.addStudentGradeToCriterion(rubric,"Mark",5);
    StudentGrade bStudent = controller.addStudentGradeToCriterion(rubric,"Fergal",5);
    StudentGrade stGlStudent = controller.addStudentGradeToCriterion(rubric,"Harry",5);
	assertEquals(3.625,controller.getAverageForCriterion(rubric,sQACriterion),0.01);
    
   }

       //Testing if min in criterion is calulated correctly
       @Test	
       public void testStudentGradeRule() {
           Rubric rubric=controller.createRubric("DT354");
           String sQACriterion="SQA";
           String madCriterion="MAD";
           controller.addCriterionToRubric(rubric, sQACriterion);
           controller.addCriterionToRubric(rubric, madCriterion);
           StudentGrade grade1 =controller.addStudentGradeToCriterion(rubric,"Tom",2);
           StudentGrade grade2 =controller.addStudentGradeToCriterion(rubric,"Paul",3);
           StudentGrade grade3 =controller.addStudentGradeToCriterion(rubric,"Sean",4);
           grade2.addMark(sQACriterion,2);
           StudentGrade grade4 =controller.addStudentGradeToCriterion(rubric,"Conor",5);
           grade3.addMark(madCriterion, 7);
           assertEquals(3.25,controller.getMinForCriterion(rubric,sQACriterion),0.01);
         }
   

    //Testing if min in criterion is calulated correctly
      @Test	
    public void testMinForCriterion() {
        Rubric rubric=controller.createRubric("DT354");
        String sQACriterion="SQA";
        String madCriterion="MAD";
        controller.addCriterionToRubric(rubric, sQACriterion);
        controller.addCriterionToRubric(rubric, madCriterion);
        StudentGrade grade1 =controller.addStudentGradeToCriterion(rubric,"Tom",2);
        StudentGrade grade2 =controller.addStudentGradeToCriterion(rubric,"Paul",3);
        StudentGrade grade3 =controller.addStudentGradeToCriterion(rubric,"Sean",4);
        grade2.addMark(sQACriterion,2);
        StudentGrade grade4 =controller.addStudentGradeToCriterion(rubric,"Conor",5);
        grade3.addMark(madCriterion, 2);
        assertEquals(3.25,controller.getAverageForCriterion(rubric,sQACriterion),0.01);
      }

    //Testing if Min in criterion is calulated correctly
   @Test	
   public void testMaxForCriterion() {
    Rubric rubric=controller.createRubric("DT354");
    String sQACriterion="SQA";
    String madCriterion="MAD";
    controller.addCriterionToRubric(rubric, sQACriterion);
    controller.addCriterionToRubric(rubric, madCriterion);
    StudentGrade grade1 =controller.addStudentGradeToCriterion(rubric,"Tom",2);
    StudentGrade grade2 =controller.addStudentGradeToCriterion(rubric,"Paul",3);
    StudentGrade grade3 =controller.addStudentGradeToCriterion(rubric,"Sean",4);
	grade2.addMark(sQACriterion,2);
	StudentGrade grade4 =controller.addStudentGradeToCriterion(rubric,"Conor",5);
	assertEquals(2,controller.getMinForCriterion(rubric,sQACriterion),0.01);
   }

     //Testing on exception thrown when defining a grade
     @Test(expected = IllegalArgumentException.class)	
     public void invalidGrade() {
        String sQACriterion="SQA";
         StudentGrade grade=new StudentGrade("dave");
         grade.addMark(sQACriterion,);
     }
   

   
    //Testing if Standard deviation in criterion is calulated correctly
   @Test	
   public void testStandardDeviationForCriterion() {
    Rubric rubric=controller.createRubric("DT354");
    String sQACriterion="SQA";
    String madCriterion="MAD";
    controller.addCriterionToRubric(rubric, sQACriterion);
    controller.addCriterionToRubric(rubric, madCriterion);
    StudentGrade grade1 =controller.addStudentGradeToCriterion(rubric,"Tom",2);
    StudentGrade grade2 =controller.addStudentGradeToCriterion(rubric,"Paul",3);
    StudentGrade grade3 =controller.addStudentGradeToCriterion(rubric,"Sean",4);
    grade2.addMark(sQACriterion,2);
    StudentGrade grade4 =controller.addStudentGradeToCriterion(rubric,"Conor",5);
    assertEquals(2.0,controller.getMinForCriterion(rubric,sQACriterion),0.01);
   }
   
    // Testing max numbers of crierions
    @Test	
    public void testMaxCriterionsInRubric() {
        Rubric rubric = controller.createRubric("DT354");
        String sQACriterion="SQA";
        for(int i=0;i<10;i++)
        {
        controller.addCriterionToRubric(rubric, sQACriterion);
        }
        assertEquals(10,rubric.getCriteriasString().size());
        controller.addCriterionToRubric(rubric, sQACriterion);
        controller.addCriterionToRubric(rubric, sQACriterion);
        controller.addCriterionToRubric(rubric, sQACriterion);
        controller.addCriterionToRubric(rubric, sQACriterion);
        assertEquals(14,rubric.getCriteriasString().size());
    }
    @Test
    public void testGetAllRubrics(){
       ArrayList<Rubric> emptyRubricList = new ArrayList<>();
       Rubric rubric=controller.createRubric("DT354");
       String sQACriterion="SQA";
       String madCriterion="MAD";
       controller.addCriterionToRubric(rubric, sQACriterion);
       controller.addCriterionToRubric(rubric, madCriterion);
       StudentGrade grade1 =controller.addStudentGradeToCriterion(rubric,"Tom",2);
       StudentGrade grade2 =controller.addStudentGradeToCriterion(rubric,"Paul",3);
       StudentGrade grade3 =controller.addStudentGradeToCriterion(rubric,"Sean",4);
       assertEquals(emptyRubricList, controller.getAllRubrics());

    }

}
