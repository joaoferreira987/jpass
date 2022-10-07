package jpass.data;

import org.junit.Assert;
import org.junit.Test;


public class EntriesRepositoryTest {


    @Test
    public void testNullkey(){

        //arrange
        String filename = "validFilename.txt";
        byte[] key = null;

        //act 
        EntriesRepository result;
        result = EntriesRepository.newInstance(filename,key);

        org.junit.Assert.assertNull(result);


    }

    @Test
    public void testNullFilename(){

        //arrange
        String filename = null; 
        byte[] key = "c18nd6NMDB".getBytes();

        //act
        EntriesRepository result;
        result = EntriesRepository.newInstance(filename,key);

        org.junit.Assert.assertNull(result);

    }

    @Test
    public void testValidKeyAndFilename(){

        //arrange
        String filename = "validFilename.txt";
        byte[] key = "c18nd6NMDB".getBytes();
        
        //act
        EntriesRepository result;
        result = EntriesRepository.newInstance(filename,key);

        //assert

        org.junit.Assert.assertTrue(result instanceof EntriesRepository);



    }

}