package jpass.util;

import org.junit.Test;

public class ClipboardUtilsTest {
    
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
    public void testEmptySetClipboard(){

        try {
            ClipboardUtils.setClipboardContent("");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        org.junit.Assert.assertNull(ClipboardUtils.getClipboardContent());

    }

    @Test
    public void testNullSetClipboard(){

        try {
            ClipboardUtils.setClipboardContent(null);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        org.junit.Assert.assertNull(ClipboardUtils.getClipboardContent());

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
