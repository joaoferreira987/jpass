package jpass.util;

import org.junit.Assert;
import org.junit.Test;
import java.time.format.DateTimeFormatter;

public class DateUtilsTest {

    //According to category-partition....

    @Test
    public void testCorrectFormatAndString(){

        //arrange
        final DateTimeFormatter FORMATTER = DateUtils.createFormatter("yyyy-MM-ddHH:mm:ss");
        
        //act
        String result = DateUtils.formatIsoDateTime("2017-10-15T10:15:30", FORMATTER);

        //assert
        org.junit.Assert.assertEquals("2017-10-1510:15:30", result);


    }

    @Test
    public void testNull(){

        //arrange
        final DateTimeFormatter FORMATTER = DateUtils.createFormatter(null);

        //act
        String result = DateUtils.formatIsoDateTime("2017-10-15T10:15:30", FORMATTER);

        //assert
        org.junit.Assert.assertEquals("2017-10-15", result);


    }

    @Test
    public void testIncorrectFormat(){

        //arrange
        final DateTimeFormatter FORMATTER = DateUtils.createFormatter(Configuration.getInstance().get("date.format", "dd-MM-yyyy"));
        String date = "2017-10-15T10:15:30";

        //act
        String result = DateUtils.formatIsoDateTime(date, FORMATTER);

        //assert
        org.junit.Assert.assertEquals("2017-10-15", result);

    }

    @Test
    public void testIncorrectStringNoTime(){

        //arrange
        final DateTimeFormatter FORMATTER = DateUtils.createFormatter("yyyy-MM-ddHH:mm:ss");
        String date = "2017-11-15";
        //act
        String result = DateUtils.formatIsoDateTime(date, FORMATTER);

        //assert
        org.junit.Assert.assertEquals("1970-01-0101:00:00", result);

    }

    @Test
    public void testIncorrectStringNotDate(){

        //arrange
        final DateTimeFormatter FORMATTER = DateUtils.createFormatter("yyyy-MM-ddHH:mm:ss");
        String date = "This is not a date";
        //act
        String result = DateUtils.formatIsoDateTime(date, FORMATTER);

        //assert
        org.junit.Assert.assertEquals("1970-01-0101:00:00",result);

    }

    
    //...
}