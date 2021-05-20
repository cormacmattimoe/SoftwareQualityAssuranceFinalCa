package Entities;




import java.util.ArrayList;

// Rubric is been described as having a student name 
// with an list of different criterias
public class Rubric {

    private String rubricName;

    //Collection to represent Criterions
    private ArrayList<Criterion> criteria = new ArrayList<>();
	//Collection to represent StudentGrades 
	private ArrayList<StudentGrade> studentGrades = new ArrayList<StudentGrade>();

    public Rubric() {
    }

    public Rubric(String rubricName, ArrayList<Criterion> criteria) {
        this.rubricName = rubricName;
        this.criteria = criteria;
    }

    public String getRubricName() {
        return rubricName;
    }

    public void setRubricName(String rubricName) {
        this.rubricName = rubricName;
    }

    public ArrayList<Criterion> getCriteria() {
        return criteria;
    }

    public void setCriteria(ArrayList<Criterion> criteria) {
        this.criteria = criteria;
    }



    public void addCriteria(Criterion criteria) {
        this.criteria.add(criteria);
    }
    //Method to return each studentGrades
	public ArrayList<StudentGrade> getGrades()
	{
		return this.studentGrades;
	}

    public double getAverageDeviation()
	{
		//sum of each sum from a studentGrade
		int total = 0;
		
		//iterates through each studentGrade in rubric
		for(StudentGrade stu : this.getGrades())
		{
			//total+=stu.getResponsesSum();
		}
		
		
		
		//mean calculation
		double mean = (float)total/this.studentGrades.size();
		
		//Gathering of absoulute deviations
		ArrayList<Double> absoultedev = new ArrayList<Double>();
		for(Stud sr : this.getResponses())
		{
			//must be absolute value
			double abs = Math.abs(sr.getResponsesSum() - mean);
			absoultedev.add(abs);
		}
		
		//absoulute devaiation
		double totalabs = 0;
		for(double d:absoultedev)
		{
			totalabs+=d;
		}
		
		double aveDev = Math.round((float)totalabs/this.responses.size() * 100.0)/100.0;

		
		return aveDev;
		
	}
	
	public double getStandardDeviation()
	{
		//sum of each sum from a surevy response
		int total = 0;

		//iterates through each survey response in survey
		for(surveyResponse sr : this.getResponses())
		{
			total+=sr.getResponsesSum();
		}

		//mean calculation
		double mean = (float)total/this.responses.size();

		//Gathering of the square of each value 
		ArrayList<Double> squares = new ArrayList<Double>();
		for(surveyResponse sr : this.getResponses())
		{
			//square the result of each sum minus the sum
			double square = (sr.getResponsesSum()-mean) *(sr.getResponsesSum()-mean);
			squares.add(square);
		}

		//Total of squares
		double totalsquaress = 0;
		for(double d:squares)
		{
			totalsquaress+=d;
		}
		totalsquaress = totalsquaress/this.responses.size(); 

		//Standard deviation by getting square root of the sum of  squares
		double stanDev = Math.sqrt(totalsquaress);
		//rounded and returned 
		return Math.round(stanDev* 100.0)/100.0;
	}
	
	public int getMaxium()
	{
		
		//value to represent max
		int max = 0;
		//list for all the values from each question
		ArrayList<Integer> values = new ArrayList<Integer>();

		//adding question answer to list
		for(surveyResponse sr : this.getResponses())
		{
			values.add(sr.getResponsesSum());
		}
		//getting the max value and retunring it
		max = Collections.max(values);
		return max;
	}
	
	public int getMinimum()
	{
		//value to represent max
		int max = 0;
		//list for all the values from each question
		ArrayList<Integer> values = new ArrayList<Integer>();

		//adding question answer to list
		for(surveyResponse sr : this.getResponses())
		{
			values.add(sr.getResponsesSum());
		}
		//getting the max value and retunring it
		max = Collections.min(values);
		return max;
	}
	
	public double averageDeviationQuestion(int index)
	{
		//sum of question values
		int total = 0;
		
		for(surveyResponse sr: this.responses)
		{
			//adds the values of the questions that have been selected
			total+= sr.questions.get(index).getAnswer();
		}

		//mean calculation
		double mean = (float)total/this.responses.size();
	
		//Gathering of absoulute deviations
		ArrayList<Double> absoultedev = new ArrayList<Double>();
		for(surveyResponse sr: this.responses)
		{
			double abs = Math.abs(sr.questions.get(index).getAnswer() - mean);
			absoultedev.add(abs);
		}

		//absoulute devaiation
		double totalabs = 0;
		for(double d:absoultedev)
		{
			totalabs+=d;
		}

		//average deviation
		double aveDev = Math.round((float)totalabs/this.responses.size() * 100.0)/100.0;

		return Double.valueOf(aveDev);
		
	}
	
	public double StandardDeviationQuestion(int index)
	{
		//sum of question values
		int total = 0;

		//Looping through the values to get sum
		for(surveyResponse sr: this.responses)
		{
			//adds the values of the questions that have been selected
			total+= sr.questions.get(index).getAnswer();
		}

		//mean calculation
		double mean = (float)total/this.responses.size();
		
		//Gathering of the square of each value 
		ArrayList<Double> squares = new ArrayList<Double>();
		for(surveyResponse sr: this.responses)
		{
			double square = (sr.questions.get(index).getAnswer()-mean) *(sr.questions.get(index).getAnswer()-mean);
			squares.add(square);
		}
		
		//Total of squares
		double totalsquaress = 0;
		for(double d:squares)
		{
			totalsquaress+=d;
		}
		totalsquaress = totalsquaress/this.responses.size(); 
		
		//Standard deviation by getting square root of the sum of  squares
		double stanDev = Math.sqrt(totalsquaress);
		//rounded and returned 
		return Math.round(stanDev* 100.0)/100.0;
	}
	
	
	public int getMaxiumQuestion(int index)
	{
		
		//value to represent max
		int max = 0;
		//list for all the values from each question
		ArrayList<Integer> values = new ArrayList<Integer>();
		
		//adding question answer to list
		for(surveyResponse sr: this.responses)
		{
			values.add(sr.questions.get(index).getAnswer());
		}
		//getting the max value and retunring it
		max = Collections.max(values);
		return max;
	}
	
	public int getMinimumQuestion(int index)
	{
		int min = 0;
		//value to represent 
		ArrayList<Integer> values = new ArrayList<Integer>();
		//list for all the values from each question

		//adding question answer to list

		for(surveyResponse sr: this.responses)
		{
			values.add(sr.questions.get(index).getAnswer());
		}
		//getting the min value and retunring it
		min = Collections.min(values);
		return min;
	}

    @Override
    public String toString() {
        return
                "Rubric name = " + rubricName;
    }
}