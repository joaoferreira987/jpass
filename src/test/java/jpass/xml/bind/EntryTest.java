package jpass.xml.bind;

import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import jpass.xml.bind.Entries;
import jpass.xml.bind.Entry;

public class EntryTest {
    

   

    @Test
    public void testEntryTitle(){
    
        Entry e = new Entry();
        e.setTitle("title");

        org.junit.Assert.assertEquals("title", e.getTitle());
        
    }

    @Test
    public void testEntryUrl(){
    
        Entry e = new Entry();
        e.setUrl("www.github.com");
        org.junit.Assert.assertEquals("www.github.com", e.getUrl());
        
    }

    @Test
    public void testEntryUser(){
    
        Entry e = new Entry();
        e.setUser("user");
        org.junit.Assert.assertEquals("user", e.getUser());
        
    }

    @Test
    public void testEntryPassword(){
    
        Entry e = new Entry();
        e.setPassword("password");
        org.junit.Assert.assertEquals("password", e.getPassword());
        
    }

    @Test
    public void testEntryNotes(){
    
        Entry e = new Entry();
        e.setNotes("notes");
        org.junit.Assert.assertEquals("notes", e.getNotes());
        
    }

    @Test
    public void testCreationDate(){
    
        Entry e = new Entry();
        e.setCreationDate("22/11/2022");
        org.junit.Assert.assertEquals("22/11/2022", e.getCreationDate());
        
    }

}
