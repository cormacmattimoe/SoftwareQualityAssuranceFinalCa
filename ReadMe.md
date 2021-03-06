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

[This is an example of a commit that follows a test driven development approach](https://github.com/cormacmattimoe/SoftwareQualityAssuranceFinalCa/commit/4b6ca76b8dfa186f60ca3a2da7168f5ec94148f6)

In this commit, I create a method for creating a rubric and getting the Rubric by its name

***How to perform Test-Driven Development***


Following steps define how to perform TDD test,

1. Add a test.
2. Run all tests and see if any new test fails.
3. Write some code.
4. Run tests and Refactor code.
5. Repeat.

![TDD](https://miro.medium.com/max/1126/1*UcGzy1kcqcI4ZG-NsXMxjA.png)



# Code Coverage Tool 


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
- The status bar at the bottom show the results after the test case(s) has been ran/debugged. 
    - If you click on the result it will navigate you to the Test Report. 
-   When a test case fails, the user is given a rundown of the mistake, which aids in identifying the problem's root cause.



 ##  Run  1
 ![](https://github.com/cormacmattimoe/SoftwareQualityAssuranceFinalCa/blob/96ebfe7dce09301c8695aa1c331c8777a8e8e3b0/Screenshot%202021-05-20%20at%2014.09.36.png) </br> 
 As you can see from the screenshot it highlights:
 A full report on the tests that pass and the tests that fail. 
 You can see that 12 passed and 6 failed meaning that I needed get all tests to pass successfully.

 </br>



 ## Run 2
 This the result I got on run 2 when I refactor my code and it displayed a full report below:
 All tests passed.
   
 ![](https://github.com/cormacmattimoe/SoftwareQualityAssuranceFinalCa/blob/506fe8d0ea346bc2555b5b2c1a2a5eb206804919/Screenshot%202021-05-21%20at%2000.53.09.png)  </br>


 </br></br>



# Team Version Control

The main version control that I have used for this assignment is **GitHub**.


* Version control, also known as source control, is the practice of tracking and managing changes to software code. Version control systems are software tools that help software teams manage changes to source code over time. 

* Version control software keeps track of every modification to the code. If a mistake is made, developers can turn back the clock and compare earlier versions of the code to help fix the mistake while minimizing disruption to all other team members.
* When discussing Github it is important to talk about the Gitflow and how this helps to assist the development process.

![GitHub Flow](https://i2.wp.com/build5nines.com/wp-content/uploads/2018/01/GitHub-Flow.png?fit=900%2C310&ssl=1).

## Git Flow
Git flow is the process of branching in a git project. This process is very useful in collaboration projects and has been adapted and encouraged as a software development "standard practice".

## Advantages of Git Flow
- Allows for parallel development
- Supports fixes
- Develop in isolation
- Promotes the use of a staging area


**For my assignment I have created the following branches: -**

## Structure of branches

1. **master** - main one that is pulled from all other branches
2. **develop** - this is the branch which all the branches merge into.
3. **develop_readMe** - All the branches will be merged into this branch before being pulled by the master branch.
4. **taskEstimation_doc** - contains all the content relating to task estimation and scrum sprint backlog.
5. **tdd_doc** - contains all the content relating to test driven development and unit testing.
6.  **codecoveragemetric_doc** - contains all the content relating to the code coverage tool that I have used, including features and benefits of it
7. **codereview_doc** - contains all the content relating to code reviews and checklist
8. **develop_studentsystem** - this branch contains the student grade system.

**ReadMe is broken into 5 different topics which my branches show above**
1. Task Estimation and Scrum Sprint BackLog.
2. Test Driven Development and Unit Testing
3. Code Coverage Tool.
4. Team Version Control.
5. Code Review Checklist

**Benefits of following this approach for a project**
1.  Parallel development.
2.  Release staging area
3.  Support for fixes


# Code Review 

**What is a code review?**

The process through which programmers analyze the code of their peers is known as code review. To share information with one another, as well as to check for flaws and evaluate code quality.
It has been shown to accelerate and streamline the software development process.

**Benefits to Code Reviews**
1.  Finding bugs early, when they are cheap to fix.
2. Coding standards compliance. Code review helps to maintain consistent coding style across    a company.
3. Teaching and sharing knowledge between the developers.


![Code Review](https://research.aimultiple.com/wp-content/uploads/2019/12/codereview.jpg).


![Code Review](https://research.aimultiple.com/wp-content/uploads/2019/12/codereview.jpg).





## Code Review Checklist:
1. Adequate white space and indentation?
2. Correct use of syntax?
3. Access modifiers used correctly?
4. Does the naming convention make sense and do they have meaning?
5. Does the code make sense? Is it readable? If some code is unclear, is there a code comment to signify the function of the code?
6. Is there associated unit tests? If not, why not?
7. Are unit tests passing? If not, why not?
8. Is there adequate description in the pull request title?
9. Does one method have one specific action? Do I need to split the method into two methods?
10. Is there any repeated code/ duplication of code?



![Code Review checklist](https://i2.wp.com/d331tpl5vusgqa.cloudfront.net/wp-content/uploads/2015/08/Code-Review-Checklist.png?ssl=1).

## Pull Request

A pull request is a method of submitting your work to an open project. The use of good pull requests within a team's workflow enhances the overall team productivity while minimizing frustration that can occur when an error occurs.

Pull Requests have been shown to be more useful when they are simple to evaluate and test.
[This link showing where I am using the code review checklist in my pull request!](https://github.com/cormacmattimoe/SoftwareQualityAssuranceFinalCa/pull/5)



 # Retrospective

**Retrospectives** are meetings held at the end of each Sprint where team members collectively analyse how things went in order to improve the process for the next Sprint.
In the instance of the project, I will cover three questions:

 1. What went well in the project?
 2. What could be improved
 3. What I would do differently?

 ### What went well?

 * My Sprint backlog and task estimations at the beginning of the project definitely helped me remain on schedule and gave me a better knowledge of the approaches used in industry to calculate task estimates.
 * I have gained a greater understanding of Test Driven Development and how important it is when coding.
 * In addition, I gained a deeper grasp of pull requests and their importance in Software Quality Assurance.

### What could be improved?

* Time management - I felt I spent too much time trying to get different features to work instead of completing others and returning back to the feature, so could definitely improve this part.

* Unit testing - create more unit tests to expand the application even further.

 
 ### What I would do differently?

* Created more pull requests to notify me to go back and change problems. This would be very important wheh working as a team and review eachothers code.



