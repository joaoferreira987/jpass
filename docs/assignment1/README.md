# TTVS - Assignment 1 

- João Ferreira - up201806716
- José Ferrão - up201805386


## 1. Brief description of your project. For example, What is it? How is the source code organized?

Jpass is a Java Application that serves as a password manager application. This application stores user information in an encrypted file protected by a master password using a strong encryption method.
The source code is organized in a package called Jpass. This package has other "sub-packages" where each achieves a particular feature of the application. For example the jpass.crypt package contains classes that are responsible for all cryptographic operations and the jpass.ui contains the classes responsible for providing a user interface.

## 2.Brief description of what static testing is and why you think it is important and relevant.

Static testing is a way of assessing code verification without executing the code itself. This type of testing aims to find potential defects in the design of the software using strategies such as static analysis or code reviews.

Static analysis is relevant for the following reasons:
- Improved code readability and maintenance since it enforces certain coding norms 
- Early fault detection 
- Improves system security 


## 3.Brief description of the static testing tool used in this assignment and how was it configured for your project. Your description must explain, e.g., why you enabled or disabled any default configuration or bug pattern.

In this assignment, we used the "CheckStyle" and "PMD" tools.

### CheckStyle

Let's first look at the CheckStyle tool. Checkstyle is a development tool that helps programmers write Java code that adheres to a coding standard. We added this tool to the build and report sections of the pom.xml file and also used a ruleset that contains styling rules recommended by Google. 

### PMD

PMD is a source code analyzer using a rules-based approach. Designed to inspect Java code and point out inefficient structures such as unused local variables, duplicate import statements, or empty try/catch blocks. This tool was also added to the build and report sections of the pom.xml file.

## 4. Brief description of the report produced by the static testing tool.

### CheckStyle

The CheckStyle tool generated a report that contained a total of 362 warnings. The report first presented how these bugs are distributed through the source code, more specifically how many warnings are present in each file. The report then shows the categories of warnings and what rules were broken in each category. Finally, the report goes through each file and lists and rules that were broken for each file. This extensive listing contains the line and a message for each warning instance.

### PMD

The PMD tool generated a report that contained the violations distributed by priorities from 1 to 5, where number 1 is considered the most severe and number 5 least severe. The tool also presents how they are distributed through the source code, grouped by files. Each item has information regarding the rule, how it was broken, and the exact line in the source code. 


## 5. Brief description of the 5x2 randomly selected bugs.

### CheckStyle

Regarding the CheckStyle tool we selected the following bugs:

1. Empty Line Separator - Checks if there is an empty line between Fields (allowNoEmptyLineBetweenFields: "true") 
2. Line Length - Limits the size of a line, in our case to 100 characters (max: "100")
3. Indentation - Enforces the amount of "empty" space in certain situations, for example, the basic offset is set to 4. (basicOffset: "4")
4. Custom Import Order - This enforces certain rules related to the order of imports, more specifically if they are sorted by group and in alphabetical order. (sortImportsInGroupAlphabetically: "true")
5. AvoidEscapedUnicodeCharacters - Restricts using Unicode escapes (such as \u221e) together with regular strings. This rule can be broken if the line has a comment following it. This is used to make sure developers explain what the Unicode represents. (allowByTailComment: "true")

### PMD

Using the PMD tool, we selected the following bugs:

1. Unnecessary Parentheses - Checks if there are parentheses that should be removed
2. Comment Size - Limits the size of a comment length (80) and the number of lines(6).
3. Short Variable - Limits the minimum length of a variable by 3.
4. Dataflow Anomaly Analysis - Tracks local definitions, undefinitions, and references to variables on different paths on the data flow.
5. Method Argument Could Be Final - Checks if a method argument is called final if is never re-assigned.


## 6.Brief description of how those 5x2 bugs were addressed/fixed. Tip: provide examples before and after fixing those bugs.

### CheckStyle

1. Empty line separator - To fix this bug, we simply removed the empty line between the fields.
2. Line Length - For this rule, we decided to increase the value of the maximum length allowed, from 100 to 150. In case any line surpassed this value, we would manually refactor the code to address this issue.
3. Indentation - We considered this rule to not be relevant for the context of our project
4. Custom Import Order - To address this bug we refactored import statements to their correct alphabetical order or removed extra separations.
5. AvoidEscapedUnicodeCharacters - To fix this bug, for every occurrence of it we added an inline comment providing the meaning of the Unicode instance

### PMD 

1. Unnecessary Parentheses - this rule was disabled, too many parentheses are not violations in our project context.
2. Comment Size - this rule was disabled, a comment shouldn't have an upper limit in this project.
3. Short Variable - this rule was disabled as it did not make sense in our project context, it's not a violation to have variables with 1 or 2 characters.
4. Dataflow Anomaly Analysis - this rule was customized, and the number of maxPaths was changed from 1000 to 50, increasing the performance of the rule.
5. Method Argument Could Be Final - this rule was disabled, our priority is not to try to re-assign methods to final.

## 7. Final Remarks

This assignment report also includes the 4 reports generated by the two tools. Each tool generated 2 reports, one associated with the default configurations and original code and the other associated with new configurations and refactored code. 

It's important to mention that some "bugs" occurred almost one hundred times, in this case, we didn't alter the code for all of those instances as it would be very time consuming and not the goal of the presented task. Instead, we recognize that the bug exists, we fixed some instances of it and we have as a goal for the future to fix all instances of it. 
