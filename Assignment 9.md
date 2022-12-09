# TVVS - Assignment 9 - Mutation Testing

- João Ferreira - up201806716
- José Ferrão - up201805386
- jpass project

The main goal of assignment #9 is to perform white-box testing in an open-source project. In general, we expect you to perform ‘Mutation’ testing in your pre-assigned project, write unit test cases using the JUnit framework, collect mutation score coverage using the PIT library for Java, and report your findings. In detail:

Configure your Maven project to use the PIT library for Java and to report mutation score.
Take all unit tests developed in all assignments and collect their mutation score.
Analyze which mutants survive to your unit test cases and which parts of the source code has the most not-killed mutants.
Identify, if any, equivalent mutants.
In case the unit tests developed in all previous assignments do not achieve 100% mutation score (exclude classes/mutants in classes related to the GUI), develop new test cases to increase the mutation score of your set of tests. Make an extra effort to increase the mutation score as much as possible.

To perform this task we first had to make sure all of our tests passed. This means that tests that failed because of assertion or because of errors had to be addressed. This meant redesining the tests, deleting the tests or fixing bugs in the code. We also needed to add the pitest library and exclude UI classes in the analysis since those weren't tested.

## Mutation score of the unit tests you developed in all assignments.

After running the mutation testing tool we got the following results:

![](https://i.imgur.com/cCdbjHT.png)

From here can make the following assertions:

- The jpass class didn't kill any mutants, which makes sense since the only developed tests (2) only tested if the main() function ran without failing. We might remove this class from mutation analysis.
- The util class didn't kill almost 40 porcent of mutants, this is the class we developed most of the tests for, which means we need to take a deeper look at them to figure out why this happens.
- The data class also only had a score of 60 porcent which means we will also take a deeper look at it's tests.
- The project had an a mutation score of 81 porcent since it killed 284 out of 352 mutants. This is a decent score but can definitely be improved.

## Equivalent mutants, if any.

"An equivalent mutant is a mutant that always behaves in the same way as the original program". This means that if pitest generates an equivalent mutant it won't be able to kill it which will then affect the final mutation score. 

![](https://i.imgur.com/MDUYOog.png)

In this case instead of having text.length **>** length, we have text.length **>=** length, the conditional boundary changed is an equivalent mutant because having a bigger length or the same length as the same output resulting in an equal assert. Ex: stripString("string",6) = string, stripString("string",7).



## Brief description of test cases developed to increase project’s mutation score.

To increase project's mutation score we developed the following tests:

- Developed simple unit tests for the Entry class parameters since it's class had no mutants killed
-  Added 1 test in the Data Model class and Entry Repository to detect a null getInstance() mutation. To do so we had to create a method that nullified this static instance.
-  Added tests for 2 untested functions in the Configuration class, Is function and getArray()
-  Removed ClipboardUtils from pitest analysis since it's tests were green when running with mvn test and red when running with pitest. We would say that it's also fair to remove them since they are related to an element of UI (the clipboard).
-  Removed jpass main class from analysis, this class has no functions with parameters and return value and it's behaviour it's very hard to track and it's tests (which only ran  the main function and checked for failures) never killed any mutants.
-  Added more tests for the StringUtils class to cover more cases in the stripXMLstring. This led to a discovery of a bug in the implementation. We looked at the mutants for the branch "((current >= 0x10000) && (current <= 0x10FFFF))"" and we saw that they didn't die. We then figured out this happens because the current variable of type char and because of this the variable current can only hold an heximal number like so "0xZZZZ". This led to the loss of information and in two conditions that could never be met and tests that will always fail. For now we removed the branch and the incorrect tests, but the end goal would be to refactor the function so that no information is lost.

In the end we had the following results:

![](https://i.imgur.com/9m5YDEx.png)
