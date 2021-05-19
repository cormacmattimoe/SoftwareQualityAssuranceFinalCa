package



import java.util.ArrayList;

import Entities.Controller;
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
    public void EmptysurveyCreationTest()
    {
        Rubric r = new Rubric();
    

        assertTrue("Should be an object of type survey", r instanceof Rubric);
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
