package Test;

import java.util.ArrayList;

import Entities.Rubric;

public class SQATest {

//    testing first commit to test suite
Controller controller = new Controller();


@Test
public void getAllRubricsTest(){
   ArrayList<Rubric> emptyRubricList = new ArrayList<>();
   assertEquals(emptyRubricList, controller.getAllRubrics());
}
    
}
