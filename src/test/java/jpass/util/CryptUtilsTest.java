package jpass.util;

import org.junit.Assert;
import org.junit.Test;

public class CryptUtilsTest {

    //According to category-partition....

    @Test
    public void testNullCharacters(){

        //arrange
        String null_string = null;

        //act
        String result = getSha256Hash(null_string);

        //assert
        org.junit.Assert.assertNull(result);
    
    }

    @Test
    public void testMorethan64chars(){

        //arrange
        String text = "abcedfghijklmnopqrstuvwxyz1234567890abcedfghijklmnopqrstuvwxyz1234567890"

        //act
        String result = getSha256Hash(text);

        //assert
        org.junit.Assert.assertTrue(result.length == 64);

    }

    @Test
    public void testLessthan64chars(){

         //arrange
        String text = "abcedfghijklmnopqrstuvwxyz1234567890"

        //act
        String result = getSha256Hash(text);

        //assert
        org.junit.Assert.assertTrue(result.length == 64);


    }

    @Test
    public void testCorrectHash(){

        //arrange
        String text = "string"

        //act
        String result = getSha256Hash(text);

        //assert
        org.junit.Assert.assertEquals("473287f8298dba7163a897908958f7c0eae733e25d2e027992ea2edc9bed2fa8", result);

    }
    
   
}