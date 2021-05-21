package Test;


import java.util.ArrayList;

import Driver.Controller;
import Entities.Rubric;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ResourceBundle.Control;

public class SQATest {

//    testing first commit to test suite
Controller controller = new Controller();
ArrayList<Rubric> listOfRubrics = new ArrayList<>();
 

    @Test
    public void creatingRubricTest()
    {
        assertTrue(controller.createRubric("Class1"));
        assertTrue(controller.createRubric("Class2"));
        assertTrue(controller.createRubric("Class3"));
        assertTrue(controller.createRubric("D67"));
        assertTrue(controller.createRubric("D68"));  
    }
    
    @Test
    public void viewARubricTest()
    {
        assertTrue(controller.createRubric("Class1"));
        assertTrue(controller.createRubric("Class2"));
        assertTrue(controller.createRubric("Class3"));
        assertTrue(controller.createRubric("D67"));
        assertTrue(controller.createRubric("D68"));  
        Rubric r = new Rubric();
        r = controller.getARubric("D68");
        assertTrue(r.getRubricName().equals("D68"));
    }
    @Test
    public void createDuplicateTest()
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
    public void createCrierionTest()
    {
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
        assertTrue(controller.createCriterion("Class1", "C1"));
        assertTrue(controller.createCriterion("Class1", "C2"));
        assertTrue(controller.createCriterion("Class1", "C3"));
        assertTrue(controller.createCriterion("Class1", "C4"));
        assertTrue(controller.createCriterion("Class1", "C5"));
        assertTrue(controller.createCriterion("Class1", "C6"));
        assertTrue(controller.createCriterion("Class1", "C7"));
        assertTrue(controller.createCriterion("Class1", "C1"));
        assertTrue(controller.createCriterion("Class1", "C1"));
        assertFalse(controller.createCriterion("Class1", "C1"));  
    }

    

/*
    @Test
    public void getRubricByName(){
    ArrayList<Rubric> listORubrics = new ArrayList<>();
    listORubrics.add(testRubric());
    assertEquals(controller.getARubric("Accounting", listORubrics), testRubric().toString());
    }


    @Test
    public void getAllRubricsTest(){
       ArrayList<Rubric> emptyRubricList = new ArrayList<>();
       assertEquals(emptyRubricList, controller.getAllRubrics());
   }
   */


}
