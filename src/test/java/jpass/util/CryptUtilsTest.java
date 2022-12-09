
package jpass.util;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
//import org.apache.commons.codec.binary.Hex;
//import java.util.HexFormat;



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
    public void testPKCSHash(){

         //arrange
        String text = "abcedfghijklmnopqrstuvwxyz1234567890";
        byte[] result;
        
        //act
        try{
            result = CryptUtils.getPKCS5Sha256Hash(text.toCharArray());
        } catch(Exception e){
            throw new RuntimeException(e);
        }
         
        org.junit.Assert.assertEquals(result.length,32);


    }

    @Test
    public void testSha256(){

        String input = "test";
        byte[] result;

        try{

            result = CryptUtils.getSha256Hash(input.toCharArray());
        }catch(Exception e){
            throw new RuntimeException(e);
        }

        byte[] expected = hexStringToByteArray("9F86D081884C7D659A2FEAA0C55AD015A3BF4F1B2B0B822CD15D6C15B0F00A08");

    

        org.junit.Assert.assertArrayEquals(result,expected);

    }

    @Test
    public void testPKCSHash2(){

         String input = "test";
        byte[] result;

        try{

            result = CryptUtils.getPKCS5Sha256Hash(input.toCharArray());
        }catch(Exception e){
            throw new RuntimeException(e);
        }

        
        byte[] expected = hexStringToByteArray("3A602AB05899748C9DFB71012C31C5BDE660964C2FC7937AAD802FFE64DCEE79");

        

        org.junit.Assert.assertArrayEquals(result,expected);


    }


    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                             + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
    
    public static String bytesToHex(byte[] bytes) {
       final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray(); 
        char[] hexChars = new char[bytes.length * 2];
    for (int j = 0; j < bytes.length; j++) {
        int v = bytes[j] & 0xFF;
        hexChars[j * 2] = HEX_ARRAY[v >>> 4];
        hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
    }
    return new String(hexChars);
}

    
   
}
