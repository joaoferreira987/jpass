# TVVS - Assignment 8 - Dataflow Testing

- João Ferreira - up201806716
- José Ferrão - up201805386
- jpass project

The main goal of assignment #8 is to perform white-box testing in an open-source project. In general, we expect you to perform ‘Dataflow Testing’ in your pre-assigned project, write unit test cases using the JUnit framework, and report your findings. In detail:

Select 3 different functions from any package. By different we mean different number and type of variables in each function’s body code.
Perform ‘Dataflow Testing’, in particular, all-defs, all-c-uses, all-p-uses, and all-uses.

Write unit test cases using the JUnit framework. Note: in maven projects, tests should be developed under src/test/java.


## 1. Which functions have you selected for testing and why.

1. stripNonValidXMLCharacters(final String in) 
2. getValue(String key, T defaultValue, Class\<T> type)
3. stripString(String text, int length)

We choose the previous functions for testing because they all come from the same "util" package (utility) which is a crucial package to test since their functions could be used by any other package not only in this project and perhaps other projects and also because they vary in number and type of variables. 

   - The first function has 4 variables of type (String, Stringbuilder,int and char)
   - The second has 3 variables with types \<T> (Integer), String and Class
   - The final function has 2 variables with types 

## 2. What is the purpose of each function.

### 2.1 stripNonValidXMLCharacters(final String in), returns String
This function receives a string and removes non-valid XML characters from it.

### 2.2 getValue(String key, T defaultValue, Class\<T> type), returns T
This functions tries to get an Integer value from the configuration file that maps to the specified key, the function will return the defaultValue if it cannot parse the specified key. 
Note: We will test this function (which is private) by calling "getInteger". This means that the function will receive "Integer.class" as a last argument which means it will return an integer.

### 2.3 stripString(String text, int length), returns String
This function receives a string and a length and if possible strips the string to the provided length.
 

## 3.Step-by-step of the ‘Dataflow Testing’ for each function and each variable. We are interesting in seeing a tabular summary for each variable, as the one presented in lecture #9 and all paths for each coverage criteria: all-defs, all-c-uses, all-p-uses, and all-uses.


## 3.1 stripNonValidXMLCharacters

This function has 4 variables (String in, Stringbuilder out, char current, int i)

### Dataflow Graph

![](https://i.imgur.com/Xf1ZkYz.png)


### Tables

**String in**
![](https://i.imgur.com/r0ODjlk.png)

**Stringbuilder out**
![](https://i.imgur.com/i4aM4DW.png)


**char current**
![](https://i.imgur.com/8e0QO17.png)


**int i**
![](https://i.imgur.com/brAjDxA.png)


### Coverage Criteria:

#### All defs:
1. variable *in*: Path <1,2,4>
2. variable *out*: Path <6,7,8,9,10,11,12>
3. variable *current*: Path <10,11,12>
4. variable *i*: Paths <8,9,10>,<14,14>

#### All-c-uses:
1. variable *in*: Paths <1,2,4>,<1,2,3,4>,<1,2,3,6,7,8,9,10>
2. variable *out*: Paths <6,7,8,9,10,11,12>,<6,7,8,9,10,11,12,13>,<6,7,8,9,10,11,12,13,14,15>,<6,7,8,9,15>,<6,7,8,9,10,11,12,13,14,15,16>,<6,7,8,9,15,16>
3. variable *current*: Path <10,11,12>
4. variable *i*: Paths <8,9,10>,<8,9,10,11,12,13,14>,<8,9,10,11,12,14>,<8,9,10,11,14>,<14,9,10>,<14,14>

#### All-p-uses:
1. variable *in*: Paths <1,2,3>,<1,2,4>,<1,2,3,4>,<1,2,3,6>,<1,2,3,6,7,8,9,10>,<1,2,3,6,7,8,9,15>
2. variable *out*: No paths
3. variable *current*: Paths <10,11,12>,<10,11,13>
4. variable *i*: Paths <8,9,10>,<8,9,15>,<14,9,10>,<14,9,15>

#### All-uses:
1. variable *in*: Paths <1,2,4>,<1,2,3,4>,<1,2,3,6,7,8,9,10>
2. variable *out*: Paths <6,7,8,9,10,11,12>,<6,7,8,9,10,11,12,13>,<6,7,8,9,10,11,12,13,14,15>,<6,7,8,9,15>,<6,7,8,9,10,11,12,13,14,15,16>,<6,7,8,9,15,16>
3. variable *current*: Paths <10,11,12>,<10,11,13>
4. variable *i*: Paths <8,9,10>,<8,9,15>,<8,9,10,11,12,13,14>,<8,9,10,11,12,14>,<8,9,10,11,14>,<14,9,10>,<14,9,15>,<14,14>

## 3.2 getValue

This function has variables (String key, T defaultValue, Class\<T> type, T value, String prop). The function's third argument will always be called using Integer.class as Class\<T> type which means the variable value will be of type Integer.

### Dataflow Graph

![](https://i.imgur.com/ORFU9lJ.png)

### Tables

**String key**

![](https://i.imgur.com/AaHoy6b.png)


**Integer defaultValue**

![](https://i.imgur.com/4R8H26k.png)


**Integer.class type**

![](https://i.imgur.com/llvvlGr.png)

**Integer value**

![](https://i.imgur.com/9rsJ0lz.png)

**String prop**

![](https://i.imgur.com/7CgBxJh.png)


### Coverage Criteria

#### All defs:
1. variable *key*: Path<1,2,3>
2. variable *defaultValue*: Path<1,2>
3. variable *type*: Path<1,2,3,4,5>
4. variable *value*: Path<1,2,3,4,6>, Path<5,6>
5. variable *prop*: Path <3,4,5> (Pair 3)

#### All c-uses:
1. variable *key*: Path<1,2,3>
2. variable *defaultValue*: Path<1,2>
3. variable *type*: Path<1,2,3,4,5>
4. variable *value*: Path<1,2,3,4,6>, Path<5,6>
5. variable *prop*: Path <3,4,5> (Pair 3)

#### All p-uses:
1. variable *key*: No p-uses
2. variable *defaultValue*: No p-uses
3. variable *type*: No p-uses
4. variable *value*: No p-uses
5. variable *prop*: Path <3,4,5>(Pair 1), Path <3,4,6> (Pair 2)
#### All uses:
1. variable *key*: Path<1,2,3>
2. variable *defaultValue*: Path<1,2>
3. variable *type*: Path<1,2,3,4,5>
4. variable *value*: Path<1,2,3,4,6>, Path<5,6>
5. variable *prop*: Path <3,4,5> (Pair 1), Path <3,4,6> (Pair 2), Path <3,4,5> (Pair 3)

## 3.3 stripString

This function has 3 variables (String text, int length and String result).

### Dataflow Graph

![](https://i.imgur.com/A3Y9QEq.png)


### Tables

**String Text**
![](https://i.imgur.com/wm3Metu.png)

**int length**
![](https://i.imgur.com/UexIpTS.png)

**String result**
![](https://i.imgur.com/4xR1JEl.png)

### Coverage Criteria:
#### All defs:
1. variable *text*: Path <1,2>
2. variable *length*: Path <1,2,3,4,5>
3. variable *result*: Path <5,7>

#### All-c-uses:
1. variable *text*: Paths <1,2>,<1,2,3,4,5>
2. variable *length*: No Paths
3. variable *result*: Path <5,7>

#### All-p-uses:
1. variable *text*: Paths <1,2,3,4>,<1,2,3,7>,<1,2,3,4,5>,<1,2,3,4,7>
2. variable *length*: Paths <1,2,3,4,5>,<1,2,3,4,7>
3. variable *result*: No paths

#### All-uses:
1. variable *text*: Paths <1,2>,<1,2,3,4,5>,<1,2,3,4>,<1,2,3,7>,<1,2,3,4,7>
2. variable *length*: Paths <1,2,3,4,5>,<1,2,3,4,7>
3. variable *result*: Path <5,7>


## 4.Brief description of the unit tests generated for each coverage criteria.

If we cover the All-uses criteria then all the other criteria will be covered as well. To do so we need to perform the following unit tests:

### 4.1 stripNonValidXMLCharacters

**Variable in**

To cover all uses of the **in** variable we need to create the following tests:

- Path\<1,2,4> : stripNonValidXMLCharacters(in = null), we expect null.
- Path\<1,2,3,4> : stripNonValidXMLCharacters(in = ""), we expect "".
- Path\<1,2,3,6,7,8,9,10> : stripNonValidXMLCharacters(in = "Any Other String"), we expect "Any Other String".

**Variable out**

To cover all uses of the **out** variable we need to create the following tests:

- Paths<6,7,8,9,10,11,12>,<6,7,8,9,10,11,12,13>,<6,7,8,9,10,11,12,13,14,15> and <6,7,8,9,10,11,12,13,14,15,16> are all covered in this test: stripNonValidXMLCharacters(in = "\<ValidString\>"), we expect "?Valid String?".
- Paths <6,7,8,9,15,16> and <6,7,8,9,15> are impossible to reach since empty string input exits the function at node 4.

**Variable current**

To cover all uses of the **current** variable we need to create the following tests:

- The developed tests above are enough to cover all uses of the current variable

**Variable i**

To cover all uses of the **i** variable we need to create the following tests:

- The developed tests above are enough to cover all uses of the i variable EXCEPT
- Path <8,9,15> is impossible to reach since empty string input exits the function at node 4.

**Final Note**

Most of the derived tests are either, (this will also be the case for the other functions)
1) A repeat of one another, for example if we cover the variable out, we will also cover the variable current and so on.
2) A repeat of tests that we already created in other stages of this project, more specifically testEmptyXMLString, testNullXMLString, testNonValidXMLString.

### 4.2 getValue

It's important that we remember that getValue is a private function, which will be tested by calling the getInteger function. This getInteger function only calls the getValue function with the last parameter called type being always equal to Integer.class.

**Variable key**

To cover all uses of the **key** variable we need to create the following test:

- Path<1,2,3> : getValue(key = "default.password.generation.length", defaultValue=20, type=Integer.class), we expect 14 (Test 1)

**Variable defaultValue**

To cover all uses of the **defaultValue** variable we need to create the following test:

- Path<1,2> : If we use (Test 1) we will cover all uses of the defaultValue variable

**Variable type**

To cover all uses of the **type** variable we need to create the following test:

-  Path<1,2,3,4,5> : If we use (Test 1) we will cover all uses of the type variable

**Variable value**
To cover all uses of the **value** variable we need to create the following tests:

- Path<1,2,3,4,6> : - getValue(key = "field.not.in.config", defaultValue=20, type=Integer.class), we expect 20 (Test 2)
- Path<5,6> : If we use (Test 1) we will cover this path


**Variable prop**

To cover all uses of the **prop** variable we need to create the following tests:

- If we apply (Test 1) and (Test 2) we will cover all uses of the variable prop.

**Final note**

All of the presented tests are already present in test suite as the following unit test:

**Test 1** - testMappedNotNullDV()
**Test 2** - testNotMappedNotNullDV()

### 4.3 getString

**Variable text**

To cover all uses of the **text** variable we need to create the following tests:

- Path <1,2,3,4,5> : stripString("hello", 3), expected return "hel", already covered in *testSmallerLength()*.
- Path <1,2,3,7> : stripString(null,1) , we expect null and is already covered in *testNullString()*.
- Path <1,2,3,4,7> : stripString("test", 8), we expect "test" and is already covered in *testBiggerLength()*.
- Paths <1,2> and <1,2,3,4> are already covered in the Path <1,2,3,4,5>.

**Variable length**

To cover all uses of the **length** variable we need to create the following tests:

- Path <1,2,3,4,5> : previously done in the text variable, already covered in *testSmallerLength()*.
- Path <1,2,3,4,7> : previously done in the text variable, already covered in *testBiggerLength()*.

**Variable result**

To cover all uses of the **result** variable we need to create the following test:

- Path <5,7> : stripString("example", 2), we expect "ex". 
*testSmallerLength()* an equivalent test already covers this path. 


## 5.Brief description of the outcome of each unit test and whether any test results in a failure (and why).

**testEmptyXMLString** - This test pasess
**testNullXMLString** - This test passes
**testNonValidXMLString** - Using an invalid XML string, the test should have passed but we detected a bug in the stripNonValidXMLCharacters function where the invalid characters were not replaced by ‘?’, resulting in a failed test and the discovery of a new bug!
**testMappedNotNullDV()** - This test passes 
**testNotMappedNotNullDV()** - This test passes
**testSmallerLength()** - This test failed, which lead to the discovery of a small bug where the program simply added the string “…” which is an unexpected and unintended behaviour for the function.
**testNullString()** - This test passes
**testBiggerLength()** - This test passes
