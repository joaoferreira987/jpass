# TVVS - Assignment 5 - Line and Decision Coverage

- João Ferreira - up201806716
- José Ferrão - up201805386
- jpass project


## 1. Line and branch coverage of the unit tests you developed in Assignment #2 and Assignment #3.

To get information regarding the line and branch of coverage of the developed unit tests we will use the JaCoCo Code Coverage Library. Before executing the operation we decided to exclude 3 sub-packages that are related to the user interface: "jpass.ui", "jpass.ui.action", "jpass.ui.helper" and also a specific class SpringUtilities. We did so by adding the following to the plugin configuration:

```xml
<excludes>
            <exclude>jpass/ui/**</exclude>
            <exclude>jpass/ui/helper/**</exclude>
            <exclude>jpass/ui/action/**</exclude>
            <exclude>jpass/util/SpringUtilities.class</exclude>
</excludes>
```

We can run the library which returns the following table

![](https://i.imgur.com/FlX4ova.png)

This means that the developed tests so far have a line coverage of 79% and a branch coverage of 50% which is very low.
Some important things to consider are:

**1.** The jpass.util and jpass.data missed plenty of instructions.
**2.** The jpass.util and jpass.data missed most of their branches.
**3.** Some classes have almost no coverage
**4.** Overall we have to work very hard on improving branch coverage.


## 2. Brief description of the JUnit features explored by your tests, e.g., parameterized tests (with the @ParameterizedTest annotation), assert expected exceptions (with the @Test(expected = ...) annotation), type of asserts (assertTrue, assertNull, …), etc.


In this chapter we list all different JUnit features we explored when developing unit tests. We will now list all of those tecniques and provide examples with them. 

* **Parameterized Test**

```java 
    @ParameterizedTest
    @ValueSource(ints = {0x9, 0xA, 0xD, 0x20, 0xD7FF, 0xE000,0xFFFD,0x10000,0x10FFF}) 
    public void validXMLTestEdgeCases(int number) {

        char a = (char) number;
        String b = Character.toString(a);

        String result = StringUtils.stripNonValidXMLCharacters(Character.toString(a));

        org.junit.Assert.assertEquals(b, result);
    }
```

* **Assert Null**
```java 
    @Test
    public void testClearClipboard(){

        try {
            ClipboardUtils.setClipboardContent("test");
            ClipboardUtils.clearClipboardContent();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        org.junit.Assert.assertNull(ClipboardUtils.getClipboardContent());

    }
```

* **Assert Not Null**
```java 
    @Test
    public void testGetEntries(){

        DataModel dm = DataModel.getInstance();
        
        try{
            dm.setEntries(EntriesRepository.newInstance("test1.xml").readDocument());
        }catch(Exception e){
            System.out.println("Error");
        }
        
        Entries result = dm.getEntries();

        org.junit.Assert.assertNotNull(result);


    }
```

* **Assert Equals**
```java 
    @Test
    public void testSetClipboard(){

        try {
            ClipboardUtils.setClipboardContent("test");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        org.junit.Assert.assertEquals("test",ClipboardUtils.getClipboardContent());

    }
````

* **Assert Array Equals**
```java 
    @Test
    public void testSetPassword(){

        DataModel dm = DataModel.getInstance();

        dm.setPassword("string".getBytes());
        
        byte[] result = dm.getPassword();

        org.junit.Assert.assertArrayEquals("string".getBytes(), result);
    }
```

* **Assert Same**
```java 
    @Test
    public void testNewInstance(){

        EntriesRepository er = EntriesRepository.newInstance("test2.xml");

        org.junit.Assert.assertSame(er.getClass(), EntriesRepository.class);

    }
```

* **Assert Fail**
```java 
    @Test
    public void testWriteDocument(){

        DataModel dm = DataModel.getInstance();
        
        try{
            dm.setEntries(EntriesRepository.newInstance("test1.xml").readDocument());
        }catch(Exception e){
            System.out.println("Error");
        }
        
        Entries entries = dm.getEntries();

        EntriesRepository er = EntriesRepository.newInstance("test2.xml");
        try {
            er.writeDocument(entries);
        } catch (DocumentProcessException | IOException c) {
            
            org.junit.Assert.fail();
            
        }

    }
```

* **Assert True**
```java 
    @Test
    public void testSetModified(){

        DataModel dm = DataModel.getInstance();

        dm.setModified(true);
        
        boolean result = dm.isModified();

        org.junit.Assert.assertTrue(result);

    }
```

* **Assert Throws**
```java 
    @Test
    public void testNullCharacters(){

        //arrange
        String null_string = null;

        //act and assert

        org.junit.Assert.assertThrows(java.lang.NullPointerException.class , () -> CryptUtils.getSha256Hash(null_string.toCharArray()) );
    
    }
```

```java 
    @Test
    public void testNegativeLength(){

        //arrange
        String text = "String";
        int length = -1;
        
         //act and assert
        org.junit.Assert.assertThrows(StringIndexOutOfBoundsException.class, () -> StringUtils.stripString(text,length));

    }
```

## 3. Line and branch coverage of the unit tests you have developed in this assignment.

After developing several tests and focusing especially on missed branches we ended up with a line coverage of 96% and branch coverage of 90% having only missed 15 branches. Notice that instruction coverage went from 79% to 96% and branch coverage went from 50% to 90%.

![](https://i.imgur.com/dJ6HWQy.png)

On a final note, some of the branches that were missed were associated with files that can't be changed during program execution (configuration files) or branches that are impossible to reach. Here is an example that occurred in different ways in the code: 

```java
result == null || result.isEmpty()
```

In this case there are 4 theoritical branches, however, if result is equal to null, result.isEmpty only has 1 possible outcome, instead of two.