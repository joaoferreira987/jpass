package jpass.data;

import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import jpass.xml.bind.Entries;
import jpass.xml.bind.Entry;

public class DataModelTest{


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

    @Test
    public void testSetPassword(){

        DataModel dm = DataModel.getInstance();

        dm.setPassword("string".getBytes());
        
        byte[] result = dm.getPassword();

        org.junit.Assert.assertArrayEquals("string".getBytes(), result);
    }

    @Test
    public void testClearPassword(){

        DataModel dm = DataModel.getInstance();

        dm.setPassword("string".getBytes());

        dm.clear();

        byte[] result = dm.getPassword();

        org.junit.Assert.assertNull(result);
    }

    @Test
    public void testSetModified(){

        DataModel dm = DataModel.getInstance();

        dm.setModified(true);
        
        boolean result = dm.isModified();

        org.junit.Assert.assertTrue(result);

    }
    @Test
    public void testIsNotModified(){

        DataModel dm = DataModel.getInstance();    
        boolean result = dm.isModified();

        org.junit.Assert.assertTrue(!result);

    }

    @Test
    public void testGetLists(){

        DataModel dm = DataModel.getInstance();

        try{
            dm.setEntries(EntriesRepository.newInstance("test1.xml").readDocument());
        }catch(Exception e){
            System.out.println("Error");
        }

        List<String> titles = dm.getTitles();

        org.junit.Assert.assertEquals(titles.get(0),"Github");


    }

    @Test
    public void testSetFileName(){
        DataModel dm = DataModel.getInstance();

        dm.setFileName("filename.xml");
        
        String result = dm.getFileName();

        org.junit.Assert.assertEquals(result,"filename.xml");


    }

    @Test
    public void testGetEntryByTitle(){
        DataModel dm = DataModel.getInstance();

        try{
            dm.setEntries(EntriesRepository.newInstance("test1.xml").readDocument());
        }catch(Exception e){
            System.out.println("Error");
        }

        Entry entry = dm.getEntryByTitle("Github");
        String result = entry.getUrl();

        org.junit.Assert.assertEquals(result,"www.github.com");
    }

    @Test
    public void testGetEntryByTitleNull(){
        DataModel dm = DataModel.getInstance();

        try{
            dm.setEntries(EntriesRepository.newInstance("test1.xml").readDocument());
        }catch(Exception e){
            System.out.println("Error");
        }

        Entry entry = dm.getEntryByTitle(null);

        String result = entry.getUrl();

        org.junit.Assert.assertEquals(result,null);
    }

    @Test
    public void testClearDataInstance(){

        DataModel dm = DataModel.getInstance();
        dm.clearInstance();

        org.junit.Assert.assertNotNull(DataModel.getInstance());
    
    }
}