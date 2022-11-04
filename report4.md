
# TVVS - Assignment 4 - Model-based Testing

- João Ferreira - up201806716
- José Ferrão - up201805386
- jpass project

## 1. Which use cases have you selected for testing and why.


**Use Case 1** - Generate a Password
- "As a user i can get randomly generated passwords."

Since this is a password manager application, we figured it would be important to test the feature of randomly generating a password.

**Use Case 2** - Add an Entry
- "As a user i can add a new password entry."

This is perhaps the most important feature in a password management application.

**Use Case 3** - Open a JPass Encripted file
- "As a user i can open Jpass files by typing their respective passwords."

Other key feature of this application is the possibilty to import encripted JPASS files which means it's a good idea to test it.

## 2. Derive the state machine, transition tree, and transition table of each use case. Note: write a brief description of each diagram.

### **1. Use Case 1** -Generate a Password

**State Machine**

![](https://i.imgur.com/DJaVZPM.png)

**Transition Tree**

![](https://i.imgur.com/ncjIyIi.png)

**Transition Table**

![](https://i.imgur.com/rNk27vT.png)


**Brief Description:**

1. To understand the State Machine diagram it's important to know the meaning of the variables it defines. The N variable represents the amount of ticked boxes in the Generate Password UI, 3 are selected by default and to generate a password atleast one must be selected, which is demonstrated in the diagram. The G variable represents whether a password has been generated (G=1) or not (G=0). Since there are 2 different UIs (User Interface) for the Generate Password feature, we use the UI variable to check which is being used.
2. To understand the Transition Tree diagram we need to know that GP means Generate Password, UI means User Interface and _N is used to represent the same state that appears for the N+1th time. 
3. The Transition Table is used to determine the intended behavior for the empty cells. For our example, it results in 20 additional sneak path tests.


### **2. Use Case 2** - Add an Entry

**State Machine**

![](https://i.imgur.com/OXljvug.png)



**Transition Tree**

![](https://i.imgur.com/p1NsbJG.png)

**Transition Table**

![](https://i.imgur.com/jDsUQls.png)


**Brief Description:**

1. The State Machine diagram captures the fact that in order to add a new entry you only need to have a Title, this is represented via the T variable.
2. Another constraint which we abstracted out but is definitely important, which is the fact that if a password is introduced, they must be equal in both password fields. To represent this we need a lot more transitions (one transition for each possible character), 2 variables and a state + transition in case the user pressed "ok" and passwords differ. 
3. The Transition Table is used to determine the intended behavior for the empty cells. For our example, it results in 12 additional sneak path tests.


### **3.Use Case 3** - Open a JPass Encripted File 

**State Machine**

![](https://i.imgur.com/PNsW15i.png)

**Transition Tree**

![](https://i.imgur.com/tmp26Ox.png)


**Transition Table**

![](https://i.imgur.com/oVdncRB.png)


**Brief Description:**

1. The State Machine diagram shows that if a user opens a jpass file and types a wrong password then the file shouldn't open, otherwise it should. Note: We abstracted out the possibility of opening a non-jpass 
2. The Transition Table is used to determine the intended behavior for the empty cells. For our example, it results in 20 additional sneak path tests.


## 3. Brief description of each test developed on the QF-Test tool.

The following test cases were derived from the leaves of the transition trees, for each Use Case. Furthermore, for each Use Case, we select a sneak path from the transition table and we derive one more test from that.

Each test set has a setup operation which launches the JPass application and a teardown operation which makes the initial state the "Home" page.

Note 1: **Path** in the state machine - State (Action) -> Next_State
Note 2: "-X>" is used to represent a transition that shouldn't be possible.

### Use Case 1 - Test exit Entry UI

- **Path** in the state machine - Home (Add Entry) -> Entry UI (Press Ok) -> Home (final state).

- This test checks if you can enter the "Entry UI" and exit it by pressing "Ok".

### Use Case 1 - Test Generate Password in Entry UI

- **Path** in the state machine - Home (Add Entry) -> Entry UI (Press Generate Password Button) -> Generate Password UI (Click Generate) -> Generate Password UI (Click Accept) -> Entry UI (final state).

- This test checks if you can generate a password through the Add entry UI.

### Use Case 1 - Test exit Generate Password UI

- **Path** in the state machine - Home (Press Ctrl-Z) -> Generate Password UI (Press Close Button) -> Home (final state).

- This test checks if you can exit the Generate Password UI.

### Use Case 1 - **Sneak path** test

- If we are in Generate Password UI and we untick all it's boxes (N=0) and we click generate, a new password shouldn't be generated. 

- **Path** in the state machine - Home (Press Ctr-Z) -> Generate Password UI (Untick Each Ticked Box) -> Generate Password UI (Click Generate) -X> Generate Password UI with Password.


 
### Use Case 2 - Add an Entry Test

- **Path** in the state machine - Home (Add Entry) -> Add new Entry UI (Add letter  inside Title field -> Add new Entry UI (Press Ok) -> Home (final state).

- This test is used to check if you can add an entry.

### Use Case 2 - Add an Entry w/ no Title Test

- **Path** in the state machine - Home (Add Entry) -> Add new Entry UI (Press Ok) -> Title Warning (Press "ok") -> Add new Entry UI (final state).

- This test checks for when the user doesn't add a Title which should restrict it from adding an entry.

### Use Case 2 - **Sneak path** test

- When we are in the Add Entry UI and Title is empty (T=0) and we press "Ok" we shouldn't transition to the Home state.

- **Path** in the state machine - Home (Add Entry) -> Add new Entry UI (Press Ok) -X> Home.


### Use Case 3 - Test JPASS decryption by provididing correct password

- **Path** in the state machine - Home (Open File) -> Open File UI (Select "Jpass File") -> Enter Password UI (Type correct Password) -> Home w/ Jpass Information

- When a user opens a file and provides a correct password, the file should be successfully decrypted.

### Use Case 3 - Test incorrect password

- **Path** in the state machine - Home (Open File) -> Open File UI (Select "Jpass File") -> Enter Password UI (Type incorrect Password) -> Error UI (Press Ok) -> Home (final state).

- When a user opens a file and provides a correct password, the file shouldn't be opened, instead an Error UI should be displayed.


### Use Case 3 - **Sneak path** test

- When we are in the Enter Password UI, we shouldnt be able to transition to the Open File UI by pressing CTRL-O.

- **Path** in the state machine - Home (Open File) -> Open File UI (Select "Jpass File") -> Enter Password UI (CTRL-O) -X> Open File UI.


## 4. Brief description of the outcome of each test and whether any test results in a failure (and why).

We developed 3 test sets, each for each Use Case. Each test sets launches the program and runs it's respective test we layed out in section 3 of this report. Regarding the non sneak path tests all of them run and pass with no errors ( 7 out of 7 ).

Finally, we created the Sneak Path tests, 1 for each Use Case, since the tests fail, it means we don't have a sneak path present in them. 

## 5. In English (mandatory), detail feedback/opinion of the QF-Test tool.

* Simple composition of complex, high coverage tests without the need to program.
* Intelligent recording and filtering.
* The need to have shortcuts to the creation of test sets and test cases would be a good addition to the tool.
