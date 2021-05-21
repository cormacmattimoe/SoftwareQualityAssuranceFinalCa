package Driver;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

        System.out.println("Welcome to the student Grading System");
        System.out.println("---------------------------------");
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
            scan = new Scanner(System.in);
            Rubric r = new Rubric();
            System.out.println("Please enter a rubric name:");
            String rubricWanted = scan.nextLine();
            r = getARubric(rubricWanted);
            showMenu();
            break;
        case("3"):
            getAllRubrics();
            showMenu();
            break;
        case("4"):
            scan = new Scanner(System.in);
            System.out.println("What rubric would you like?");
            String rubicres = scan.nextLine();
            System.out.println("What crieria would you like to add to?");
            String cru = scan.nextLine();
            createCriterion(cru, rubicres);
            showMenu();
            break;
        case("5"):
            System.out.println("What rubric would you like?");
            String rubicre = scan.nextLine();
            System.out.println("What crieria would you like to add to?");
            String c = scan.nextLine();
            System.out.println("What is name of student?");
            String nameOfStudent = scan.nextLine();
            System.out.println("What is the grade of this student?");
            int grade = scan.nextInt();
            addStudentGrade(c, rubicre, nameOfStudent, grade);
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
            System.out.println("Rubric name = " + r.getRubricName());
            if(r.getRubricName().equals(rubricTobeCreated))
            {
                System.out.println("Failed");
                return false;
            }
        }
        tempRubric.setRubricName(rubricTobeCreated);
        listOfRubrics.add(tempRubric);
        return true;

        }

        //Create a criterion to a rubric 
        public Boolean createCriterion(String criterionToBeCreated, String rubricname)
        {
            Criterion tempCriteria = new Criterion();
            //1. Check to see if the there is already 10 criteria
            //2. Check to see if the name exists
            //3. Else add it
            Rubric r = getARubric(rubricname);
            if(r.getCriteria().size() > 9)
            {
                System.out.println("Too many criteria already exist");
                return false;
            }
            listOfCriteria = r.getCriteria();
            for (Criterion c : listOfCriteria)
            {
                if(c.getCriteriaName().equals(criterionToBeCreated))
                {
                System.out.println("Name already exists");
                return false;
                }
    
            }
            tempCriteria.setCriteriaName(criterionToBeCreated);
            r.addCriteria(tempCriteria);
            return true;
    
        }
       // returns Min number in ArrayList
        public int getMin(ArrayList<Integer> listOfIntegers) {
    
            Collections.sort(listOfIntegers);
    
            return listOfIntegers.get(0);
        }
    
        // returns Max number in ArrayList
        public int getMax(ArrayList<Integer> listOfIntegers) {
    
            Collections.sort(listOfIntegers, Collections.reverseOrder());
    
            return listOfIntegers.get(0);
        }

        	//Gets a rubric
	public Rubric getARubric(String nameOfRubric) {
		for (Rubric rubric : listOfRubrics) {
			if (rubric.getRubricName().equalsIgnoreCase(nameOfRubric)) {
                System.out.println("Rubric was found " + rubric.getRubricName());  
				return rubric;
			}
		}
        System.out.println("Rubric was not found in controller class");
		return null;
	}


    //CREATES STUDENT GRADE ADDING SCORE TO EACH CRITERION IN A RUBRIC
	public StudentGrade createStudentGrade(Rubric rubric, String name, int score) {
		StudentGrade grade=new StudentGrade();
		//for criterion in rubric
		List<String> criteria=rubric.getCriteriasString();
		for(String criterion:criteria) {
			//add mark to grade
			grade.add(criterion,score);
		}		
		//add grade to rubric
		rubric.addStudentGrade(grade);
		
		return grade;
	}
	
	//CALCULATES AVERAGE OF ALL SCORES IN RUBRIC
	public double getAverageForRubric(Rubric rubric) {
		List<StudentGrade> grades=rubric.getGrades();
		double sum=0;
		double count=0;
		for(StudentGrade grade:grades) {
			HashMap<String, Integer> marks=grade.getMarks();
			count+=marks.size();
			for(int i:marks.values()) {
				System.out.println("score: "+i);
				sum+=i;
			}
		}
		return sum/count;
	}
	
	//CALCULATES MAXIMIUM OF ALL SCORES IN RUBRIC
	public int getMaxForRubric(Rubric rubric) {
		List<StudentGrade> grades=rubric.getGrades();
		int max=0;
		for(StudentGrade grade:grades) {
			HashMap<String, Integer> marks=grade.getMarks();
			for(int i:marks.values()) {
				if(i>max) {
					max=i;
				}
			}
		}
		return max;
	}
	
	//CALCULATES MINIMUM OF ALL SCORES IN RUBRIC
	public int getMinForRubric(Rubric rubric) {
		List<StudentGrade> grades=rubric.getGrades();
		int min=6;
		for(StudentGrade grade:grades) {
			HashMap<String, Integer> marks=grade.getMarks();
			for(int i:marks.values()) {
				if(i<min) {
					min=i;
				}
			}
		}
		return min;
	}
	
	//CALCULATES STANDARD DEVIATION OF ALL SCORES IN RUBRIC
	public double getStandardDeviationForRubric(Rubric rubric) {
		List<StudentGrade> grades=rubric.getGrades();
		double mean=getAverageForRubric(rubric);
		double stdDeviation=0;
		int count=0;
		for(StudentGrade grade:grades) {
			HashMap<String, Integer> marks=grade.getMarks();
			count+=marks.size();
			for(int i:marks.values()) {
				stdDeviation+= Math.pow((i-mean),2);
			}
		}
		double sq=stdDeviation/count;
		return Math.sqrt(sq);
	}
	
	//CALCULATES AVERAGE OF ALL SCORES IN CRITERION
	public double getAverageForCriterion(Rubric rubric, String criterion) {
		List<StudentGrade> grades=rubric.getGrades();
		double sum=0;
		double count=grades.size();
		for(StudentGrade grade:grades) {
			sum+=grade.getScore(criterion);
		}
		return sum/count;
	}
	
	//CALCULATES MAXIMIUM OF ALL SCORES IN CRITERION
	public int getMaxForCriterion(Rubric rubric, String criterion) {
		List<StudentGrade> grades=rubric.getGrades();
		int max=0;
		for(StudentGrade grade:grades) {
			if(grade.getScore(criterion)>max) {
				max=grade.getScore(criterion);
			}
		}
		return max;
	}
	
	//CALCULATES MINIMUM OF ALL SCORES IN CRITERION
	public int getMinForCriterion(Rubric rubric, String criterion) {
		List<StudentGrade> grades=rubric.getGrades();
		int min=6;
		for(StudentGrade grade:grades) {
			if(grade.getScore(criterion)<min) {
				min=grade.getScore(criterion);
			}
		}
		return min;
	}
	
	//CALCULATES STANDARD DEVIATION OF ALL SCORES IN CRITERION
	public double getStandardDeviationForCriterion(Rubric rubric, String criterion) {
		List<StudentGrade> grades=rubric.getGrades();
		double mean=getAverageForCriterion(rubric,criterion);
		double stdDeviation=0;
		int count=grades.size();
		for(StudentGrade grade:grades) {
				stdDeviation+= Math.pow((grade.getScore(criterion)-mean),2);
			
		}
		double sq=stdDeviation/count;
		return Math.sqrt(sq);
	}
	
	//ADDS MARK FOR A SPECIFIC CRITERION TO A GRADE
	public void addMark(StudentGrade grade, String designCriterion, int score) {
		// TODO Auto-generated method stub
		grade.addMark(designCriterion, score);
	}
	
	//RETURNS ALL GRADES IN A RUBRIC
	public List<StudentGrade> getAllGradesInRubric(Rubric rubric) {
		// TODO Auto-generated method stub
		return rubric.getGrades();
	}

	
	






 /*
    public Rubric getARubric(String nameOfRubric)
    {
        Rubric rubricReturned = new Rubric();
    
        for (Rubric r : listOfRubrics)
        {
            if(r.getRubricName().equals(nameOfRubric))
            {
                System.out.println("Rubric was found " + r.getRubricName());    
                rubricReturned = r;
            }  
        }
        if(rubricReturned.equals(null))
        {
            System.out.println("Rubric not found "); 
        }
        System.out.println("This is rubric returned " + rubricReturned); 
        return rubricReturned;
    }
    */


 


    public Boolean addStudentGrade(String criteriaName, String rubricName, String nameOfStudent,int gradeOfStudent)
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
            if(r.getRubricName().equals(rubricName))
            {
                listOfCriteria = r.getCriteria();

                for (Criterion c : listOfCriteria)
                {
                    if(c.getCriteriaName().equals(criteriaName))
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

        for(Rubric rubric: listOfRubrics)
        {

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
    /*
    // Get all grades in a Rubric
	public ArrayList<Integer> getAllGradesinRubric(Rubric rubric) {

		ArrayList<StudentGrade> studentGrades = rubric.getGrades();
		ArrayList<Integer> gradeScores = new ArrayList<Integer>();

		if (studentGrades != null) {
			for (StudentGrade studentGrade : studentGrades) {
				for (Integer i : gradeScores))) {
					gradeScores.add(i);
				}
			}
		}

		if (gradeScores.isEmpty())
			return null;
		else
			return gradeScores;
	}
    

    // Get average of Rubric
	public double getAverageOfRubric(Rubric rubric) {

		ArrayList<Integer> interList = getAllGradesinRubric(rubric);
		int total = 0;

		if (interList != null) {
			for (int i : interList) {
				total = total + i;
			}
			double average = (Double.valueOf(total)) / (Double.valueOf(interList.size()));
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

