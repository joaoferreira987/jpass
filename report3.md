# TVVS - Assignment 3 - Boundary Value Analysis

- João Ferreira - up201806716
- José Ferrão - up201805386
- jpass project

## 1. Which functions have you selected for testing and why.

We chose the "util" package to perform all testing since this package is used by many different packages and even contains functions that might be useful to be exported to other projects which means we should test them extensively. 

- stripNonValidXMLCharacters(), from jpass.utils package and StringUtils class
- stripString(), from jpass.utils package and StringUtils class
- getInteger(), from jpass.utils package and Configuration class

## 2. What is the purpose of each function.

### 2.1 stripNonValidXMLCharacters(final String in), returns String
This function receives a string and removes non-valid XML characters from it.

### 2.2 stripString(String text, int length), returns String
This function receives a string and a length and if possible strips the string to the provided length.

### 2.3 getInteger(String key, Integer defaultValue), returns Integer
This functions tries to get an Integer value from the configuration file that maps to the specified key, the function will return the defaultValue if it cannot parse the specified key. 


## 3. Step-by-step of the ‘Boundary Value Analysis’ for each function.

### 3.1 stripNonValidXMLCharacters

For the stripNonValidXMLCharacters function we defined the following categories:

- A null string ( **A** )
- An empty string ( **B** )
- A string that contains non-valid XML Characters ( **C** )
- A string that doesn't contain non-valid XML Characters ( **D** )

This allows us to define the following Boundary Value scenarios for each category:

**Category A:**

**Test 1:** On-Point - We provide a null string
**Test 2:** Off-Point - We provide an empty string
**Test 3:** Off-Point - We provide a non-empty string

**Category B:**

Test 4: On-Point - We provide an empty string
Test 5: Off-Point - We provide a null string
**Test 6: Off-Point** - We provide a string with one valid XML character
**Test 7: Off-Point** - We provide a string with one invalid XML character 

**Category C:**

**Test 8:** On-Point - We provide a string that contains one valid XML character
**Test 9:** Off-Point - We provide a string that doesn't contain any XML character
Test 10: Off-Point - We provide a null string
Test 11: Off-Point - We provide an empty String

**Category D:**

Test 12: On-Point - We provide a string that doesn't contain any XML character
Test 13: Off-Point - We provide a string that contains one valid XML character
Test 14: Off-Point - We provide a null string
Test 15: Off-Point - We provide an empty String

**Final Tests**: By analyzing the different test scenarios we can tell that some of them are redundant. Removing the redundant tests (4,5,10,11,12,13,14,15) leaves us with the following tests to be implemented - **1,2,3,6,7,8,9**.

### 3.2 stripString

For the stripString function we defined the following categories:

- A string and the input length is bigger than string's length ( **A** )
- A string and the input length is smaller or equal than string's length ( **B** )
- Negative length ( **C** )
- String is null ( **D** )
- String is empty ( **E** )

This allows us to define the following Boundary Value scenarios for each category:

**Category A:**

**Test 1**: On-Point - We provide a string with size N, and a length bigger than N.
**Test 2**: Off-Point - We provide a string with size N, and a length equal to N.
**Test 3**: Off-Point - We provide a null string.

**Category B:**

**Test 4**: On-Point - We provide a string with size N, and a length smaller or equal to N.
**Test 5**: Off-Point - We provide a string with size N, and a length equal to N+1.
Test 6: Off-Point - We provide a null string.
**Test 7**: Off-Point - We provide an empty string.
**Test 8**: Off-Point - We provide a negative length.

**Category C:**

Test 9: On-Point - We provide a negative length.
**Test 10**: Off-Point - We provide a length of 0.


**Category D:**

Test 11: On-Point - We provide a null string.
Test 12: Off-Point - We provide an empty string.
Test 13: Off-Point - We provide a non-empty string.

**Category E:**

Test 14: On-Point - We provide an empty string.
Test 15: Off-Point - We provide a non-empty string.
Test 16: Off-Point - We provide a null string. 

**Final Tests**: By analyzing the different test scenarios we can tell that some of them are redundant. Removing the redundant tests (6,9,11,12,13,14,15,16) leaves us with the following tests to be implemented - **1,2,3,4,5,7,8,10**.

### 3.3 getInteger

For the getInteger function we defined the following categories:

- A null string key, with null object default value (**A**)
- A null string key, with Integer object default value (**B**)
- A string key that doesn't exist in the configuration file, with null object default value (**C**)
- A string key that doesn't exist in the configuration file, with Integer object default value (**D**)
- A string key that exists in the configuration file, with null object default value (**E**)
- A string key that exists in the configuration file, with Integer object default value (**F**)

This allows us to define the following Boundary Value scenarios for each category:

**Category A:**

**Test 1: On-point:** We provide a null string key and null object default value.
**Test 2: Off-point:** We provide a non-null string key and null object default value.
**Test 3: Off-point:** We provide a non-null string key and Integer object default value.
**Test 4: Off-point:** We provide a null string key and Integer object default value.

**Category B:**

Test 5: On-point: We provide a null string key and Integer object default value.
Test 6: Off-point: We provide a non-null string key and Integer object default value.
Test 7: Off-point: We provide a null string key and null object default value.
Test 8: Off-point: We provide a non-null string key and null object default value.

**Category C:**

**Test 9: On-point:** A string key that doesn't exist in the configuration file, with null object default value.
**Test 10: Off-point:** A string key that exists in the configuration, with null object default value.
**Test 11: Off-point:** A string key that doesn't exist in the configuration, with Integer object default value.
**Test 12: Off-point:** A string key that exists in the configuration, with Integer object default value.

**Category D:** to **Category F:**

Test 13 to test 24: All this tests will be redudant from the category C tests, the only thing that will change is that the On-point will be the specific test itself and it's off-points would be the remaining tests. 

**Final Tests**: By analyzing the different test scenarios we can tell that some of them are redundant. Removing the redundant tests (5,6,7,8,13-24) leaves us with the following tests to be implemented - **1,2,3,4,9,10,11,12**.


## 4. Brief description of the unit tests generated for each ‘boundary’.

After applying the Category-Partition and Boundary we can create the Unit Tests using the Junit Framework. Most tests use the triple A approach - Arrange, Act, Assert. Each class that was tested has their own "Classtest" file.  
It's important to note that some of the derived tests from this analysis were either redundant, as we have already pointed out, or they were already implemented in the second assignment. We will only mention the new tests.

### 4.1 stripNonValidXMLCharacters

Inside src\test\java\jpass\util\StringUtilsTest.java test we implemented the following tests:

Let's not forget the categories we defined:

**Category A:** Null String

- **Off-Point - testEmptyXMLString()** - When the input string is empty the function should return an empty string.

**Category B:** Empty String

- **Off-Point - testOffByOneValidXMLChar()** - When the input string is a valid XML string with one character, the function should return that speficific character.
- **Off-Point - testOffByOneInvalidXMLChar()** - When the input string is a invalid XML string with one character, the function should return a string with a question mark.

**Category C and D:** The tests derived from this categories already exist in the test suite.

### 4.2 stripString

Inside src\test\java\jpass\util\StringUtilsTest.java test we implemented the following tests:

Let's not forget the categories we defined:

**Category A:** A string and the input length is bigger than string’s length

- **Off-Point - testEqualLength()** - When the input string length is equal to the length parameter the function should return the original string.

**Category B:** A string and the input length is smaller or equal than string's length

- **Off-Point - testOffbyOneLength()** - When the input string length is equal to N, and the length parameter is equal to N+1, the function should return the original string.

- **Off-Point - testEmptyString()** - When the input string is empty, the function should return an empty string


**Category C:** Negative length

- **Off-Point - testLengthZero()** - When the length parameter is equal to Zero, the function should return an empty string.

**Category D and E:** The tests derived from this categories already exist in the test suite.



### 4.3 getInteger

Inside src\test\java\jpass\util\ConfigurationTest.java test we implemented the following tests:

Let's not forget the categories we defined:


**Category A:** A null string key, with null object default value

- **On-point - testNullStringAndDV()** - We provide a null string key and null object default value and we expect a null return.

- **Off-point - testNotNullStringAndNullDV()** - We provide a non-null string key present in the configuration file and null object default value and we expect the mapped value.

- **Off-point - testNotNullStringAndDV()** - We provide a non-null string key and Integer object default value and we expect the default value, since the key isn't present in the configuration file.

- **Off-point - testNullStringAndNotNullDV()** - We provide a null string key and Integer object default value and we expect the default value.

**Category B:** Redundant tests.

**Category C:** A string key that doesn't exist in the configuration file, with null object default value

- **On-point - testNotMappedNullDV()** - We provide a string key that doesn't exist in the configuration file, with null object default value and we expect null.

- **Off-point - testMappedNullDV()** - We provide a string key that exists in the configuration file, with null object default value and we expect the mapped value.

- **Off-point - testNotMappedNotNullDV()** - We provide a string key that doesn't exist in the configuration file, with Integer object default value and we expect the default value

- **Off-point - testMappedNotNullDV()** - We provide A string key that exists in the configuration, with Integer object default value and we expect the mapped value.

**Category D:** to **Category F:** - Redundant tests.


## 5. Brief description of the outcome of each unit test and whether any test results in a failure (and why).

Using the command “mvn test” we can run all the created tests. This will print out on the console how many tests passed and how many failed. It will also point out exactly which tests failed and why. Some tests resulted in failure and we will now explain why

### 5.1 stripNonValidXMLCharacters

- testEmptyXMLString() - The test passed as expected because an empty string doesn’t have an invalid XML character, so it returns an empty string also.
- testOffByOneValidXMLChar() - The input string was a valid XML char and we expected the result to be the same as the input one and a successfull test.
- testOffByOneInvalidXMLChar() - In the last case, using an invalid XML char, the test should have passed but we detected a bug, in the stripNonValidXMLCharacters function where the invalid characters were not replaced by ‘?’, resulting in a failed test and the discovery of a bug already reported in the previous assignment.

### 5.2 stripString

- testEqualLength() - As expected, the first case test passed successfully.
- testOffbyOneLength() - the second case test passed successfully as it is very similar with the first one.
- testEmptyString() - The test was successfull as the input string was an empty string and the expected result was an empty string too.
- testLengthZero() - This test failed, which lead to the discovery of a small bug where the program simply added the string “…” which is an unexpected and unintended behaviour for the function.

### 5.3 getInteger

- testNullStringAndDV() - Test Failed with an Error
- testNotNullStringAndNullDV() - Test Failed with an Error
- testNotNullStringAndDV() - Test Succeeded 
- testNullStringAndNotNullDV() - Test Failed with an Error
- testNotMappedNullDV() - Test Succeeded
- testMappedNullDV() - Test Failed with an Error
- testNotMappedNotNullDV - Test Succeeded
- testMappedNotNullDV - Test Assertion failed.

The test suite built for this function revealed two problems with it. First is that it's not ready to receive a null Integer object for the default value parameter ( three tests failed with this error "java.lang.NullPointerException" ). The other problem is that the function has portability problems, more specifically because of the way it fetches the configuration file. In other words, if the function is used in the "main" java context it works, but when used in "test" context it stops working. We verified this fact by printing the "getConfigurationFolderPath()" value which is used by the Configuration class to get the location of the .conf file and we got the path "jpass\target", which differs from it's correct value "jpass\src\main\config". 
