package jpass.util;

import org.junit.Assert;
import org.junit.Test;

public class ConfigurationTest {


    @Test
    public void testNullStringAndDV(){

        //arrange
        Configuration conf_obj = Configuration.getInstance();
        String arg1 = null;
        Integer arg2 = null;

        //act
        Integer result = conf_obj.getInteger(arg1,arg2);

        //assert
        org.junit.Assert.assertNull(result);


    }
    @Test
    public void testNotNullStringAndNullDV(){

        //arrange
        Configuration conf_obj = Configuration.getInstance();
        String arg1 = "default.password.generation.length";
        Integer arg2 = null;

        //act
        Integer result = conf_obj.getInteger(arg1,arg2);

        //assert
        org.junit.Assert.assertEquals(14,result.intValue());

    }

    @Test
    public void testNotNullStringAndDV(){

        //arrange
        Configuration conf_obj = Configuration.getInstance();
        String arg1 = "random_key";
        Integer arg2 = new Integer(15);

        //act
        Integer result = conf_obj.getInteger(arg1,arg2);

        //assert
        org.junit.Assert.assertEquals(15,result.intValue());

    }

    @Test
    public void testNullStringAndNotNullDV(){

        //arrange
        Configuration conf_obj = Configuration.getInstance();
        String arg1 = null;
        Integer arg2 = new Integer(15);

        //act
        Integer result = conf_obj.getInteger(arg1,arg2);

        //assert
        org.junit.Assert.assertEquals(15,result.intValue());


    }

    @Test
    public void testNotMappedNullDV(){
         
         //arrange
        Configuration conf_obj = Configuration.getInstance();
        String arg1 = "random_key";
        Integer arg2 = null;

        //act
        Integer result = conf_obj.getInteger(arg1,arg2);

        //assert
        org.junit.Assert.assertNull(result);
    }

    @Test
    public void testMappedNullDV(){

        //arrange
        Configuration conf_obj = Configuration.getInstance();
        String arg1 = "default.password.generation.length";
        Integer arg2 = null;

        //act
        Integer result = conf_obj.getInteger(arg1,arg2);

        

        //assert
        org.junit.Assert.assertEquals(14,result.intValue());

    }

    @Test
    public void testNotMappedNotNullDV(){
         //arrange
        Configuration conf_obj = Configuration.getInstance();
        String arg1 = "random_key";
        Integer arg2 = new Integer(14);

        //act
        Integer result = conf_obj.getInteger(arg1,arg2);

        //assert
        org.junit.Assert.assertEquals(14,result.intValue());
    }
    
    @Test
    public void testMappedNotNullDV(){
        //arrange
        Configuration conf_obj = Configuration.getInstance();
        String arg1 = "default.password.generation.length";
        Integer arg2 = new Integer(15);

        //act
        Integer result = conf_obj.getInteger(arg1,arg2);

        //assert
        org.junit.Assert.assertEquals(14,result.intValue());
    }

}