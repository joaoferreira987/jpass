
package jpass.util;

import org.junit.Assert;
import org.junit.Test;

public class CryptUtilsTest {

    //According to category-partition....
    
    @Test
    public void testNullCharacters(){

        //arrange
        String null_string = null;

        //act and assert

        org.junit.Assert.assertThrows(java.lang.NullPointerException.class , () -> CryptUtils.getSha256Hash(null_string.toCharArray()) );
    
    }

    @Test
    public void testMorethan32chars(){

        //arrange
        String text = "abcedfghijklmnopqrstuvwxyz1234567890abcedfghijklmnopqrstuvwxyz1234567890";
        byte[] result;
        
        //act
        try{
            result = CryptUtils.getSha256Hash(text.toCharArray());
        } catch(Exception e){
            throw new RuntimeException(e);
        }
         
        org.junit.Assert.assertEquals(result.length,32);

    }

    @Test
    public void testLessthan32chars(){

         //arrange
        String text = "abcedfghijklmnopqrstuvwxyz1234567890";
        byte[] result;
        
        //act
        try{
            result = CryptUtils.getSha256Hash(text.toCharArray());
        } catch(Exception e){
            throw new RuntimeException(e);
        }
         
        org.junit.Assert.assertEquals(result.length,32);


    }

    @Test
    public void testLessthan32charsWithIteration(){

        //arrange
        String text = "abcedfghijklmnopqrstuvwxyz1234567890";
        byte[] result;

        //act
        try{
            result = CryptUtils.getSha256Hash(text.toCharArray(),2);
        } catch(Exception e){
            throw new RuntimeException(e);
        }

        org.junit.Assert.assertEquals(result.length,32);


    }

   
}
