# TTVS - Assignment 2

- João Ferreira - up201806716
- José Ferrão - up201805386


## 1. Which functions have you selected for testing and why.

We chose the "util" package to perform most testing since this package is used by many different packages and even contains functions that might be useful to be exported to other projects which means we should test them extensively. 
From the package jpass.util we chose the following functions:

1. stripNonValidXMLCharacters from the StringUtils
2. stripString from the StringUtils class
3. formatIsoDateTime from the DateUtils class
4. getSha256Hash from the CryptUtils class

We also chose a function from the "data" package:

5. newInstance (with encryption) from EntriesRepository class

## 2. What is the purpose of each function.

### 2.1 stripNonValidXMLCharacters
This function receives a string and removes non-valid XML characters from it.

### 2.2 stripString
This function receives a string and a length and if possible strips the string to the provided length.

### 2.3 formatIsoDateTime
This function formats data to ISO standard ("yyyy-mm-ddThh:mm:ss").

### 2.4 getSha256Hash 
This function receives a string and returns it's SHA-256 hash. 

### 2.5 newInstance
This function creates a document repository with encryption.

## 3. Step-by-step of the ‘Category-Partition’ algorithm for each function.

### 3.1 stripNonValidXMLCharacters

1. We have 1 parameter:
	- The string
2. For each parameter we define the characteristics as:
	- The string must not be null or empty
3. Constraints in order to minimize the set of tests:
	- None.
4. We combine the other characteristics to get the following tests:
	- String is null
	- String contains non-valid XML characters
	- String doesn't contain non-valid XML characters

### 3.2 stripString

1. We have 2 parameters:
	- The string
	- A length
2. For each parameter we define the characteristics as:
	- The string must not be null
	- The string length must be bigger than the length from the input
3. Constraints in order to minimize the set of tests:
	- Negative lengths are not allowed
4. We combine the other characteristics to get the following tests:
	-  A string and the input length is bigger than string's length
	-  A string and the input length is smaller or equal than string's length
	-  Negative length
	-  String is null


### 3.3 formatIsoDateTime

1. We have 2 parameters:
	- Date string
	- Date time Formatter

2. For each parameter we define the characteristics as:
	- The date string must not be null
	- Date String must have the right format

3. Constraints in order to minimize the set of tests:
    - Since the function is named formatIsoDateTime, the formatter variable should always have the following attribute 'yyyy-MM-ddHH:mm:ss'

4. We combine the other characteristics to get the following tests:
    - The formatter isn't according to the ISO format
    - The formatter is according to the ISO format aswell as the date string
    - The formatter is according to the ISO format but not the date string
    - The formatter is according to the ISO format but the date string isn't actually a date.

### 3.4 getSha256Hash 

1. We have 1 parameter:
	- Input characters
2. For each parameter we define the characteristics as:
	- The string must not be null or empty
3. Constraints in order to minimize the set of tests:
	- None.
4. We combine the other characteristics to get the following tests:
	- Empty or null input
	- String bigger than 64 characters
	- String smaller than 64 characters
    
### 3.5 newInstance

1. We have 2 parameters:
	- A string with the file name
	- A key
2. For each parameter we define the characteristics as:
	- The key cannot be null otherwise it won't have encryption
	- The file name cannot be null
3. Constraints in order to minimize the set of tests:
	- None.
4. We combine the other characteristics to get the following tests:
	- The key is null
	- The file name is null
	- The file name and the key are not null


## 4. Brief description of the unit tests generated for each category.

After applying the Category-Partition we can create the Unit Tests using the Junit Framework. Most tests use the triple A approach - Arrange, Act, Assert. Each class that was tested has their own "Classtest" file.  

### 4.1 stripNonValidXMLCharacters

- testNullXMLString() - When the input string is null the function should return null
- testNonValidXMLString() - When the input string contains non-valid XML characters, the function should replace them with the character '?'.
- testValidXMLString() - When the input string only contains valid XML characters, the function should return as it was provided.

### 4.2 stripString

- testBiggerLength() - The first test has a length bigger than the string's length, testing if we get the same result as the original string.
- testSmallerLength() - The second test has a smaller length than the string's length, testing if we get only part of the original string.
- testNegativeLength() - In the third test, we have a negative length as an input. Using the assertThrow function this test expects the "StringIndexOutOfBoundsException.class" exception. 
- testNullString() - The last test, we have a null string as an input and we expect null return value.

### 4.3 formatIsoDateTime

- testCorrectFormatandString() - For this test we pass the proper ISO_LOCAL_DATE_TIME formatter and a correct date in that format.
- testIncorrectFormat() - For this test we pass a correct date with an incorrect date string (dd-mm-yy), the function should return a placeholder date, since the format doesn't conform to ISO standards. 
- testIncorrectStringNoTime() - In this test we pass a date string that doesn't contain time information, the function should return the date string + '00:00:00'.
- testIncorrectStringNotDate() - In this test we pass a string that isn't a date and we expect that the function returns a placeholder date.

### 4.4 getSha256Hash 

- testNullCharacters() - This test uses the assertThrow function and expects the "java.lang.NullPointerException.class" exception.
- testMorethan32chars() and testLessthan32chars() - This tests were made because hash functions should always return an hash with the same size, whether the provided string is smaller or bigger than its fixed output length. 

### 4.5 newInstance

- testNullKey() (or empty array) - Since this function expects a non-empty byte array, if none is provided the function should return null
- testNullFileName() - Since this function expects a non-empty string, if none is provided the function should return null.
- testValidKeyAndFilename() - Since proper arguments were passed the function should return the appropriate newly created object. 



## 5. Brief description of the outcome of each unit test and whether any test results in a failure (and why).

Using the command "mvn test" we can run all the created tests. This will print out on the console how many tests passed and how many failed. It will also point out exactly which tests failed and why. Some tests resulted in failure and we will now explain why

### 5.1 stripNonValidXMLCharacters

- testNullXMLString() - the test passed as expected because null doesn't have an invalid XML character, so it returns null also.
- testNonValidXMLString() - Using an invalid XML string, the test should have passed but we detected a bug in the stripNonValidXMLCharacters function where the invalid characters were not replaced by '?', resulting in a failed test and the discovery of a new bug!
- testValidXMLString() - In the last case, the input string was a valid XML string and we expected the result to be the same as the input one and a successfull test.

### 5.2 stripString

- testBiggerLength() - As expected, the first case test passed successfully. 
- testSmallerLength() - This test failed, which lead to the discovery of a small bug where the program simply added the string "..." which is an unexpected and unintended behaviour for the function. 
- testNegativeLength() - The third succeeds. Since the length field is negative, the function stripString gets an index out of bounds, which was contemplated and expected by the test.
- testNullString() - The last test was successfull as the input string was null and the expected result was null too.

### 5.3 formatIsoDateTime

- testCorrectFormatandString() - This test passes.
- testIncorrectFormat() - This test doesn't pass, since the function returns a date in a format that doesn't conform to the ISO standard, which is not supposed to happen.
- testIncorrectStringNoTime() - This test doesn't pass. The function returns a placeholder date, which is incorrect, since it should be capable to parse the date and then append with placeholder time.
- testIncorrectStringNotDate() - This test passes. 


### 5.4 getSha256Hash 

- testNullCharacters() - This test succeeded, the expected exception is thrown.
- testMorethan32chars() and testLessthan32chars() - This tests succeed, thus veryfing a key property of hash functions.

### 5.5 newInstance

- testNullKey() (or empty array) - This tests fails. The functions returns a non-null object even though a key was not passed.
- testNullFileName() - This test fails. The function returns a non-null object even though a filename was not passed.
- testValidKeyAndFilename() - This test succeeds.
