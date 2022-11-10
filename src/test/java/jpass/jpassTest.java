package jpass;

import org.junit.Test;

import jpass.ui.JPassFrame;

public class jpassTest {

    @Test
    public void testJpassMain(){

        
        JPass.main(new String[]{});
    

        org.junit.Assert.assertTrue(true);
        

        

    }

    @Test
    public void testJpassMainWithFile(){

        
    
        
        JPass.main(new String[]{"test1.xml"});
    
        org.junit.Assert.assertTrue(true);
        

        

    }
    

}
