package Driver;
import java.util.ArrayList;
import java.util.Scanner;

import Entities.Criterion;
import Entities.Rubric;
import Entities.StudentGrade;

//This is main class that controls of the user inputs and data.
//This class allows the user to choose options from the menu.
// class that handles user input and data
// inside this class should cover all the various parts of grading system 
// Tasks
// 1. newStudentGrade 
// 2. addScoreToGrade
// 3. getAllStudentGradesForRubric
// 4. getAverageGrade 
// 5. getStandardDeviation Grade
// 6. getMinimumGrade
// 7. getMaximumGrade
//--------------------------
// Create  a new rubric
// Add a criterion to a rubric
// Get a list of all rubrics
//Get a specific rubric by name 
// Create a new student grade
// Add a score to particular criterion to a grade 
// Getting all studentGrades associated with a specific rubric
// Summary calculation across all graded students
// Including average, standard deviation min and max 
// score for a specific criterion of a Rubric. 



public class Controller {

    Scanner scan = new Scanner(System.in);
    ArrayList<Rubric> listOfRubrics = new ArrayList<>();
    ArrayList<Criterion> listOfCriteria = new ArrayList<>();
    ArrayList<StudentGrade> listOfGrades = new ArrayList<>();
 
    StudentGrade tempStudentGrade;

    public void showMenu(){

        System.out.println("Welcome");
        System.out.println("-----------------------");
        System.out.println("1. Create a rubric");
        System.out.println("2. View a rubric");
        System.out.println("3. View all rubrics");
        System.out.println("4. Add a Criteria to  a rubric");
        System.out.println("5. Add a studentGrade to  a criteria");
        System.out.println("6. View min and max standard dev and average across all grades");
        System.out.println("7. View min and max standard dev and average across specific criteria");
        System.out.println("8. View average, standard deviation,  minimum and maximum score for a Rubric");

    

    scan = new Scanner(System.in);

    switch (scan.next()){
        case("1"):
            scan = new Scanner(System.in);
            System.out.println("Please enter a rubric name:");
            String rubricName = scan.nextLine();
            if(createRubric(rubricName))
            {
                System.out.println("Rubric successfully created"); 
            }
            showMenu();
            break;
        case("2"):
            System.out.println("Please enter a rubric name:");
            String rubricReturned = scan.nextLine();
            Rubric r = new Rubric();
            getARubric(rubricReturned,r);
            if(r != null){
                System.out.println("Rubric found"); 
            }
            showMenu();
            break;
        case("3"):
            getAllRubrics();
            break;
        case("4"):
            System.out.println("What rubric would you like?");
            String rubicre = scan.nextLine();
           // getARubric()
            showMenu();
            break;
        default:
            System.out.println("That is not a reponse!\n\n");
            showMenu();
            break;
        }
    }


    

// Create a new rubric
    public Boolean createRubric(String rubricTobeCreated){
        //1. Check to see if the rubric name exists
        Rubric tempRubric = new Rubric();
        for (Rubric r : listOfRubrics)
        {
            if(r.getRubricName() == rubricTobeCreated)
            {
            System.out.println("Failed");
            return false;
            }
        }
        
        tempRubric.setRubricName(rubricTobeCreated);
        listOfRubrics.add(tempRubric);
        return true;

        }

        //Create a criterion 
        public Boolean createCriterion(String criterionToBeCreated, Rubric rubricname)

        {
            Criterion tempCriteria = new Criterion();
            //1. Check to see if the there is already 10 criteria
            //2. Check to see iof the name exists
            //3. Else add it
            if(rubricname.getCriteria().size() > 9)
            {
                System.out.println("To many criteria already exist");
                return false;
            }
            listOfCriteria = rubricname.getCriteria();
            for (Criterion c : listOfCriteria)
            {
                if(c.getCriteriaName() == criterionToBeCreated)
                {
                System.out.println("Name already exists");
                return false;
                }
    
            }
            tempCriteria.setCriteriaName(criterionToBeCreated);
            rubricname.addCriteria(tempCriteria);
            return true;
    
        }
//
    public void getARubric(String nameOfRubric, Rubric rubricReturned)
    {
        rubricReturned = null;
    
        for (Rubric r : listOfRubrics)
        {
            if(r.getRubricName() == nameOfRubric)
            {
            rubricReturned = r;
            }  
        }

    }

 


    public Boolean addStudentGrade(Criterion criteria, Rubric rubricname, String nameOfStudent,int gradeOfStudent)
    {
        StudentGrade tempStudentGrade = new StudentGrade();
        //1. Check to see if the rubric exists
        //2. Check to see if the criteria exists
        //3. Check to see if the grade is between 1-5
        //4. Check to see if the student name already exists.
        //5. Else create populate studentGrade class 
        //6. Add that to the array for the criterion
        if(gradeOfStudent < 1 || gradeOfStudent > 5)
        {
            System.out.println("Grade is out of range");
            return false;
        }
        for (Rubric r : listOfRubrics)
        {
            if(r.getRubricName() == rubricname.getRubricName())
            {
                listOfCriteria = rubricname.getCriteria();

                for (Criterion c : listOfCriteria)
                {
                    if(c.getCriteriaName() == criteria.getCriteriaName())
                    {
                        tempStudentGrade.setStudentName(nameOfStudent);
                        tempStudentGrade.setGrade(gradeOfStudent);
                        c.addStudentGrade(tempStudentGrade);  
                        return true;      
                    }
                }
                System.out.println("Criteria not found");
                return false;
            }
        }
        System.out.println("Rubric not found");
        return false;   
    }

    public ArrayList<Rubric> getAllRubrics(){

        ArrayList<Rubric> allOfRubrics = new ArrayList<>();

        for(Rubric rubric: listOfRubrics){1

            System.out.println(rubric.toString());
        }

        return allOfRubrics;
    }
     	// Get average of Rubric
/*	public double getAverageOfRubric(Rubric rubric) {

		ArrayList<Rubric> rubricList = getAllRubrics();
		Rubric rub = null;

		if (rubricList != null) {
			for (Rubric r : rubricList) {
				rub = rub + r;
			}
			double average = (Double.valueOf(total)) / (Double.valueOf(rubricList.size()));
			return average;
		} else
			return 0;
	}
    */



    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.showMenu();

    }
}

