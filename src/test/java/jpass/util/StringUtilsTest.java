package jpass.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {

    
    /**

        TestBiggerLength
        If length is bigger than the provided string, then the function should return the original string
    
     */
    @Test
    public void testBiggerLength(){
        
        //arrange
        String text = "String"; 
        int length = 7;
        
        //act
        String result = StringUtils.stripString(text,length);
    
        //assert
        org.junit.Assert.assertEquals("String", result);
    
    }

     /**

        testSmallerLength
        If length is smaller than the provided string, then the function should return the correct substring
    
     */
    @Test
    public void testSmallerLength(){
        
        //arrange
        
        String text = "String"; 
        int length = 2;
        
        //act
        String result = StringUtils.stripString(text,length);
    
        //assert
        org.junit.Assert.assertEquals("St", result);
    }

    @Test
    public void testEqualLength(){

        //arrange
        String text = "String";
        int length = 6;

        //act
        String result = StringUtils.stripString(text,length);

        //assert
        org.junit.Assert.assertEquals("String", result);

    }

    @Test
    public void testOffbyOneLength(){

        //arrange
        String text = "Example";
        int length = 8;

        //act
        String result = StringUtils.stripString(text,length);

        //assert
        org.junit.Assert.assertEquals("Example", result);

    }

    @Test
    public void testEmptyString(){

        //arrange
        String text = "";
        int length = 8;

        //act
        String result = StringUtils.stripString(text,length);

        //assert
        org.junit.Assert.assertEquals("", result);

    }

    @Test
    public void testLengthZero(){

        //arrange
        String text = "String";
        int length = 0;

        //act
        String result = StringUtils.stripString(text,length);

        //assert
        org.junit.Assert.assertEquals("", result);

    }

    /**
        testNegativeLength()
        If the provided length is null, the function should return the provided string object
    */

    @Test
    public void testNegativeLength(){

        //arrange
        String text = "String";
        int length = -1;
        
         //act and assert
        org.junit.Assert.assertThrows(StringIndexOutOfBoundsException.class, () -> StringUtils.stripString(text,length));

    }

    

    /**
        testNullString()
        If the provided string is null, the function should return null
     */
    @Test 
    public void testNullString(){
        
        //arrange
        String text = null;
        int length = 3; //doesnt matter

        //act
        String result = StringUtils.stripString(text,length);

        //assert
        org.junit.Assert.assertNull(result);
    }

    @Test
    public void testEmptyXMLString(){

        //arrange
        String text = "";

        //act
        String result = StringUtils.stripNonValidXMLCharacters("");

        //assert
        org.junit.Assert.assertEquals("", result);



    }
    
    @Test
    public void testNullXMLString(){

        //arrange
        String text = null;

        //act
        String result = StringUtils.stripNonValidXMLCharacters(null);

        //assert
        org.junit.Assert.assertNull(result);



    }

    @Test
    public void testOffByOneValidXMLChar() {

        //arrange
        String text = "a";

        //act
        String result = StringUtils.stripNonValidXMLCharacters(text);

        //assert
        org.junit.Assert.assertEquals("a", result);

    }

    @Test
    public void testOffByOneInvalidXMLChar() {

        //arrange
        String text = "&";

        //act
        String result = StringUtils.stripNonValidXMLCharacters(text);

        //assert
        org.junit.Assert.assertEquals("?", result);

    }

    @Test
    public void testNonValidXMLString(){

        //arrange
        String text = "<invalid>&<string>";

        //act
        String result = StringUtils.stripNonValidXMLCharacters(text);
        System.out.print(result);

        //assert
        org.junit.Assert.assertEquals("?invalid???string?",result);

    }

    @Test
    public void testValidXMLString(){

        //arrange
        String text = "validstring";

        //act
        String result = StringUtils.stripNonValidXMLCharacters(text);

        //assert
        org.junit.Assert.assertEquals("validstring", result);


    }


    


}