package jpass.util;

import jpass.ui.TextComponentFactory;
import org.junit.Test;

import javax.swing.*;

public class SpringUtilitiesTest {

    @Test
    public void makeGridTest() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Password:"));
        final JPasswordField password = TextComponentFactory.newPasswordField();
        panel.add(password);
        JPasswordField repeat = null;
        boolean confirm=true;
            repeat = TextComponentFactory.newPasswordField();
            panel.add(new JLabel("Repeat:"));
            panel.add(repeat);

        SpringUtilities.makeCompactGrid(panel, confirm ? 2 : 1, 2, 5, 5, 5, 5);
        org.junit.Assert.assertTrue(true);
    }



}
