package Test;

public class SQATest {

//    testing first commit to test suite


@Test
public void getAllRubricsTest(){
   ArrayList<Rubric> emptyRubricList = new ArrayList<>();
   assertEquals(emptyRubricList, controller.getAllRubrics());
}
    
}
