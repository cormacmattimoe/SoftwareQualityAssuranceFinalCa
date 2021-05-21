package Test;


import java.util.ArrayList;

import Driver.Controller;
import Entities.Rubric;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ResourceBundle.Control;

public class SQATest {

//    testing first commit to test suite
Controller controller = new Controller();
ArrayList<Rubric> listOfRubrics = new ArrayList<>();
 

    @Test
    public void creatingRubric()
    {
        controller.createRubric("Dan");
        assertTrue("Rubric Dan created", r instanceof Rubric);
    }

    @Test
    public void notEmptyRubric()
    {
        Rubric r = controller.createRubric();
        assertTrue("Should be an object of rubric", r instanceof Rubric);
    }

    @Test
    public void duplicateRubric()
    {
        Rubric r = controller.createRubric();
        assertTrue("Should be unique", r instanceof Rubric);
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
