package jpass.util;

import org.junit.Test;

public class ClipboardUtilsTest {
    
    @Test
    public void testSetClipboard(){

        try {
            ClipboardUtils.setClipboardContent("test");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        org.junit.Assert.assertEquals("test",ClipboardUtils.getClipboardContent());
        



    }

    @Test
    public void testClearClipboard(){

        try {
            ClipboardUtils.setClipboardContent("test");
            ClipboardUtils.clearClipboardContent();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        org.junit.Assert.assertNull(ClipboardUtils.getClipboardContent());

    }

}
