/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juliansmith
 */
public class AlarmTest {
    
    public AlarmTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of snooze method/getAlarmTimeToSound of class Alarm.
     */
    @Test
    public void testSnooze() {
        System.out.println("snooze");
        Alarm instance = new Alarm(new Clock());
        //test instantiation
        assertEquals(0, instance.getHours());
        assertEquals(0, instance.getMinutes());
        assertEquals(0, instance.getOffset());
        //test snooze while not sounding/alarm off
        instance.snooze();
        assertEquals(0, instance.getHours());
        assertEquals(0, instance.getMinutes());
        assertEquals(0, instance.getOffset());
        //test snooze when alarm on and sounding
        instance.turnOnAlarm();
        instance.setSounding(true);
        instance.snooze();
        assertEquals(0, instance.getHours());
        assertEquals(0, instance.getMinutes());
        assertEquals(5, instance.getOffset());
        assertEquals(false, instance.isSounding());
        //test snooze when alarm on and not sounding
        instance.snooze();
        assertEquals(0, instance.getHours());
        assertEquals(0, instance.getMinutes());
        assertEquals(5, instance.getOffset());
        assertEquals(false, instance.isSounding());

        instance.stopAlarm();
        //test carry over minutes and hours for snooze
        instance.setHours(23);
        instance.setMinutes(55);
        instance.setSounding(true);
        instance.snooze();
        assertEquals(23, instance.getHours());
        assertEquals(55, instance.getMinutes());
        assertEquals(5, instance.getOffset());
        //test getAlarmTimeToSound/getAlarmTime
        String expResult = "00:00";
        String result = instance.getAlarmTimeToSound();
        assertEquals(expResult, result);
        String expResult2 = "11:55 pm";
        String result2 = instance.getAlarmTime();
        assertEquals(expResult, result);
        
        assertEquals(false, instance.isSounding());
        
    }

    /**
     * Test of getAlarmTime method, of class Alarm.
     */
    @Test
    public void testGetAlarmTime() {
        System.out.println("getAlarmTime");
        Alarm instance = new Alarm(new Clock());
        String expResult = "12:00 am";
        String result = instance.getAlarmTime();
        assertEquals(expResult, result);
        
        instance.setHours(10);
        instance.setMinutes(10);
        expResult = "10:10 am";
        result = instance.getAlarmTime();
        assertEquals(expResult, result);
        
        instance.setHours(5);
        instance.setMinutes(5);
        expResult = "05:05 am";
        result = instance.getAlarmTime();
        assertEquals(expResult, result);
    }    
}
