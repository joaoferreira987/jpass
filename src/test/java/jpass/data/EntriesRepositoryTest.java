package jpass.data;

import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import jpass.xml.bind.Entries;
import jpass.xml.bind.Entry;

public class EntriesRepositoryTest{


    @Test
    public void testNewInstance(){

        EntriesRepository er = EntriesRepository.newInstance("test2.xml");

        org.junit.Assert.assertSame(er.getClass(), EntriesRepository.class);


    }

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


}