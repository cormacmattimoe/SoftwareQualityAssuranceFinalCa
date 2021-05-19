package src;

import java.util.ArrayList;

import org.junit.*;
import 
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
        Survey s = test.createSurveyEmpty();

        assertTrue("Should be an object of type survey", s instanceof Survey);
    }


    @Test
    public void getRubricByName(){
    ArrayList<Rubric> listORubrics = new ArrayList<>();
    rubrics.add(testRubric());
    assertEquals(controller.getARubric("Accounting", listORubrics), testRubric().toString());


    @Test
    public void getAllRubricsTest(){
       ArrayList<Rubric> emptyRubricList = new ArrayList<>();
       assertEquals(emptyRubricList, controller.getAllRubrics());
   }


}
