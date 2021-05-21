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
        assertTrue(controller.createRubric("Rubric1"));
        assertTrue(controller.createRubric("Class2"));
        assertTrue(controller.createRubric("Class3"));
        assertTrue(controller.createRubric("D67"));
        assertTrue(controller.createRubric("D68"));  
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
    public void  testDuplicateCriteria()

    {
        Rubric rubric = controller.createNewRubric("DT354");
        controller.createCriterion("Class", "C1");
        controller.createCriterion("Class1", "C1");
        assertTrue(  
    }

   


     
    @Test
    public void TestCriterionMoreThan9()
    {
        Rubric rubric = controller.createRubric("DT354");
        String sQACriterion="SQA";
        String madCrierion="MAD";
        String spCriterion="SP";
        String smCriterion="Sm";
        String sisCriterion="SIS";
        String fypCriterion="FYP";
        String slCriterion="SL";
        String daCriterion="DA";
        String soCriterion="SO";
        String gaCriterion="GA";
        controller.addCriterionToRubric(rubric, sQACriterion);
        controller.addCriterionToRubric(rubric, madCrierion);
        controller.addCriterionToRubric(rubric, spCriterion);
        controller.addCriterionToRubric(rubric, smCriterion);
        controller.addCriterionToRubric(rubric, sisCriterion);
        controller.addCriterionToRubric(rubric, fypCriterion);
        controller.addCriterionToRubric(rubric, slCriterion);
        controller.addCriterionToRubric(rubric, daCriterion);
        controller.addCriterionToRubric(rubric, soCriterion);
        controller.addCriterionToRubric(rubric, gaCriterion);
        assertFalse(controller.createCriterion("Class1", "C10"));  
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
	   assertEquals(2,rubric.getStudentGrades().size());
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
    Rubric rubric=controller.createNewRubric("DT354");
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
           Rubric rubric=controller.createNewRubric("DT354");
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
        Rubric rubric=controller.createNewRubric("DT354");
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
    Rubric rubric=controller.createNewRubric("DT354");
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
   

   
    //Testing if Standard deviation in criterion is calulated correctly
   @Test	
   public void testStandardDeviationForCriterion() {
    Rubric rubric=controller.createNewRubric("DT354");
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
   

    @Test
    public void testGetAllRubrics(){
       ArrayList<Rubric> emptyRubricList = new ArrayList<>();
       Rubric rubric=controller.createNewRubric("DT354");
       String sQACriterion="SQA";
       String madCriterion="MAD";
       controller.addCriterionToRubric(rubric, sQACriterion);
       controller.addCriterionToRubric(rubric, madCriterion);
       StudentGrade grade1 =controller.addStudentGradeToCriterion(rubric,"Tom",2);
       StudentGrade grade2 =controller.addStudentGradeToCriterion(rubric,"Paul",3);
       StudentGrade grade3 =controller.addStudentGradeToCriterion(rubric,"Sean",4);
       assertEquals(rubric, controller.getAllRubrics());

    }

}
