package jpass.util;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.Test;


import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    public void testDefaultStripString(){
         //arrange
         String text = "hAakOV9DEgmHkipx26fbMW5Llj6zHEmdiVoMgnRg0fNgdYwetqAnFvDD4kkitROS1tOObJMECaOcfdnf";
        
 
         //act
         String result = StringUtils.stripString(text);
 
         //assert
         org.junit.Assert.assertEquals("hAakOV9DEgmHkipx26fbMW5Llj6zHEmdiVoMgnRg0fNgdYwetqAnFvDD4kkitROS1tOObJMECaOcfdnf", result);
    }
  

    @Test
    public void testnonValidXML(){

        String text = "<?&>␛?␊#&␊G^a-jå∫∆avµa2bl√øog\0x";

        char a = (char) 0x11FFFF;

        String result = StringUtils.stripNonValidXMLCharacters(Character.toString(a));

        org.junit.Assert.assertEquals("?", result);


    }

    @Test
    public void validXML1(){

        char a = (char) 0x9;

        String result = StringUtils.stripNonValidXMLCharacters(Character.toString(a));

        org.junit.Assert.assertEquals(a, result);

    }
    @Test
    public void validXML2(){

        char a = (char) 0xA;

        String result = StringUtils.stripNonValidXMLCharacters(Character.toString(a));

        org.junit.Assert.assertEquals(a, result);

    }

    @Test
    public void validXML3(){

        char a = (char) 0xD;

        String result = StringUtils.stripNonValidXMLCharacters(Character.toString(a));

        org.junit.Assert.assertEquals(a, result);

    }
    
    @Test
    public void validXML4(){

        char a = (char) 0x20;

        String result = StringUtils.stripNonValidXMLCharacters(Character.toString(a));

        org.junit.Assert.assertEquals(a, result);

    }

    @Test
    public void validXML5(){

        char a = (char) 0xD7FF;

        String result = StringUtils.stripNonValidXMLCharacters(Character.toString(a));

        org.junit.Assert.assertEquals(a, result);

    }

    @Test
    public void validXML6(){

        char a = (char) 0xE000;

        String result = StringUtils.stripNonValidXMLCharacters(Character.toString(a));

        org.junit.Assert.assertEquals(a, result);

    }

    @Test
    public void validXML7(){

        char a = (char) 0xFFFD;

        String result = StringUtils.stripNonValidXMLCharacters(Character.toString(a));

        org.junit.Assert.assertEquals(a, result);

    }

    @Test
    public void validXML8(){

        char a = (char) 0x10000;

        String result = StringUtils.stripNonValidXMLCharacters(Character.toString(a));

        org.junit.Assert.assertEquals(a, result);

    }

    @Test
    public void validXML9(){

        char a = (char) 0x10FFF;

        String result = StringUtils.stripNonValidXMLCharacters(Character.toString(a));

        org.junit.Assert.assertEquals(a, result);

    }
   
    /* 
    @ParameterizedTest
    @ValueSource(ints = {0x9, 0xA, 0xD, 0x20, 0xD7FF, 0xE000,0xFFFD,0x10000,0x10FFF}) 
    public void validXMLtestEdgeCases(int number) {

        char a = (char) number;

        String result = StringUtils.stripNonValidXMLCharacters(Character.toString(a));

        org.junit.Assert.assertEquals(a, result);
    }*/

}