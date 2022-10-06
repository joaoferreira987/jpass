package jpass.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {

    
    /**

        TestCase1()
        If length is bigger than the provided string, then the function should return the original string
    
     */
    @Test
    public void testCase1(){
        
        //arrange
        String text = "String"; 
        int length = 7;
        
        //act
        String result = StringUtils.stripString(text,length);
    
        //assert
        org.junit.Assert.assertEquals("String", result);
    
    }

     /**

        testCase2()
        If length is smaller than the provided string, then the function should return the correct substring
    
     */
    @Test
    public void testCase2(){
        
        //arrange
        
        String text = "String"; 
        int length = 2;
        
        //act
        String result = StringUtils.stripString(text,length);
    
        //assert
        org.junit.Assert.assertEquals("St", result);
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

        //act
        String result = StringUtils.stripString(text,length);
        
         //assert
        org.junit.Assert.assertEquals("String",result);

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
    
    //...
}