# Introduction

  This assignment is based on the use of gitflow and Unit testing. The main objective of this assignment is to create a software component that storing information about student grades.
  
  This component does not have a user interface or connection to external storage. There is only a "controller" class with methods to support different features is included. The only way to determine if the code is working is to run it through a JUnit test suite.
  When I created this project, I used a Test-Driven Development strategy, and each commit includes tests and the necessary code.

 #### Assignment Requirements:

  * A scrum sprint backlog and a task estimation of the tasks I that I needed to complete.

  * A section describing Unit test and Test Driven Development

  * A section describing a code coverage tool that I selected, why I selected it and how I used the tool
  
  * A section describing a code coverage tool that I chose:
     *  Why I selected it?
     *  How I used the tool?

  * A section describing code reviews.




# Scrum sprint backlog and task estimation 
![Scrum](https://www.ntaskmanager.com/wp-content/uploads/2019/08/blog4.png)

The scrum methodology begins by developing a Sprint Backlog. A sprint backlog is a series of tasks derived from the product backlog, the demands of the product owner are translated into small manageable tasks to be completed during a sprint. It is important to discuss these objectives with your team and outline what tasks will be completed in the next sprint.

## Sprint backlog for Student Grade System
### Task estimation

 To create estimations for my tasks I decided to go with the techique that is known as "T-Shirt Sizing".
 This is a form of estimation used to size items in a sprint backlog. Items can be defined as using t-shirt sizes (e.g. XS,S,M,L,XL).Members of a team will size each other's items in this method, and then compare all of the figures. 
 * If all estimates are the same, that is considered as the ideal size
 * if this is not the case, then this is discussed among the team to arrive at the same estimate.

 Since this assignment was not a group assignment, I had to create my own criteria for determining the task estimation based on t-shirt sizes. 
 Which was based on several different criterias following:

 Does the task.....

 1. Contain complex objects
 2. include creating new objects?
 3. Is a test required?
 4. have some sort of arithmetic operation?
 5. have method/methods that return a value?
 6. include a method that takes in parameters
 7.  include a method that takes in parameters
 8.  include if/switch statement

Using t-shirt sizes will help to estimate the different tasks to be completed.

 * If a task answers yes to less then 3 of the following questions it was deemed an S task.
 * If a task answers yes to more then 3 but less then 5 of the following questions it was deemed an M task.
 * If a task answers yes to 5 or more of the following questions it was deemed an L task.

 ### Tasks

 **Tasks and estimates**

 A Table of tasks and estimations below:

 |  Task No |   User Story    |    Size estimation       |  Owner     |
 |----------|--------         |--------	|--------	|
 |1         |Create new Rubric  |S	|Cormac Mattimoe|
 |2         |Create new Criterion |S	|Cormac Mattimoe|
 |3         |Add a new StudentGrade per Criterion |S	|Cormac Mattimoe|
 |5         |Get a list of all Rubrices -  |M	|Cormac Mattimoe|
 |6         |Get a Rubric by name |M	|Cormac Mattimoe|
 |7         |Ensure a grade is between 1-5 |M	|Cormac Mattimoe|
 |8        |Getting all grades associated with a specific Rubric   |L	|Cormac Mattimoe|
 |9        |Get average for a Rubric across all grades  |L	|Cormac Mattimoe|
 |10        |Get standard deviation for a Rubric across all grades   |L	|Cormac Mattimoe|
 |11        |Get minimum and maximum score  for a Rubric across all grades  |L	|Cormac Mattimoe|
 |12       | Get standard deviation for a specific critertion of a Rubric |L	|Cormac Mattimoe|
  |13       | Get minimum and maximum score  for a specific critertion of a Rubric |L	|Cormac Mattimoe|

 
 #### Comparing the difficulty of two tasks with different estimates
Depending on the amount of work required, this is an estimate in relative terms rather than absolute terms. 

 **Task Comparison**

Compare the 2 task below

 1. Get average of a rubric
 2. Add a criterion to a rubric


 | Criteria 	| Task 1 	| Task 2 	|
 |----------	|--------	|--------	|
 | 1        	| Yes    	| No     	|
 | 2        	| Yes    	| Yes     	|
 | 3        	| Yes    	| Yes     	|
 | 4        	| Yes     	| No     	|
 | 5        	| Yes     	| No    	|
 | 6        	| Yes    	| No    	|
 | 7       	    | No    	| No    	|
 | 8      	    | No    	| No    	|
 | SUM      	| 6    	    | 2      	|


From this we can see that task 1 has a sum of 6 to yes and task 2 has a sum of 2 to yes this means that task 1 the it is L while task 2 only answers yes to 2 meaning that it is S 

 **Velocity Metric Calculation**
The t-shirt sizing technique that i has give each t-shirt a size of numeric value as a representation of each task
 S = 1 
 M = 2 
 L = 3

***Calculation of the velocity metric as follows***

There is a number of different ways to calculte the velocity of the various tasks which are outlined below:
  1. Get the number of tasks completed by t-shirt size e.g. [s:2 ,m:3, l:1]
  2. Multiply the number value of the tasks completed by the numerical value assigned to each t-shirt size e.g. [s:2x3, m:3x3, l:3x1] = [s:6, m:9, l:3]
  3. Sum of the numerical values calculated e.g. 6+9+3 = 18
  4. Divided the sum by 3 because there are 3 t-shirt sizes to get the velocity metric e.g. 18/3 = 6
    
Now the velocity of the task has been calculated.

This velocity metric will be used to calculate how quickly the team is progressing in comparison to task sizes; the higher the figure, the more tasks are performed.


# Test-Driven Development and Unit testing

TDD is a software creation methodology in which test cases are created to define and verify what the code can do. In simple terms, test cases for each feature are developed and checked first, and if the test fails, new code is written to pass the test, resulting in code that is straightforward and bug-free.

***How to perform Test-Driven Development***


Following steps define how to perform TDD test,

1. Add a test.
2. Run all tests and see if any new test fails.
3. Write some code.
4. Run tests and Refactor code.
5. Repeat.

![TDD](https://miro.medium.com/max/1126/1*UcGzy1kcqcI4ZG-NsXMxjA.png)



**Code Coverage Tool**


Test coverage is one of the many basic metrics used in software development to analyze, monitor, and calculate the accuracy of the code written in a project.

Test coverage is a metric that tests how thoroughly the established code is checked using a test suite.

The Test Coverage Metric used in this project is Java Test Runner as shown below as example:

This is a extension that allows the user to Run and debug JUnit test cases in Visual Studio Code. 

The features include:
 * Run/Debug Test Cases.
 * Customize Test Configurations
 * View Test Report.
 * View Tests in Test Explorer. 
 * Show Test Logs.

**Example of the Java Test Runner running:**

![Java Test Runner: vscode-java-test](https://devblogs.microsoft.com/visualstudio/wp-content/uploads/sites/4/2018/02/Java-Test-Runner.png).

- You can 'Run Test/ Debug Test' above the class and above each method which allows you to run a single test case for a method. 
- Test Explorer on the left hand side displays all the test cases within the project. If you click on specific test case it will direct you to the source code. 
- The status bar at the bottom show the results after the test case(s) has been            ran/debugged. 
    - If you click on the result it will navigate you to the Test Report. 
-   When a test case fails, the user is given a rundown of the mistake, which aids in identifying the problem's root cause.

