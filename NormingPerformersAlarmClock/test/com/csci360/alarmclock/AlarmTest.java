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
     * Test of snooze method, of class Alarm.
     */
    @Test
    public void testSnooze() {
        System.out.println("snooze");
        Alarm instance = new Alarm(new Clock());

        assertEquals(0, instance.getHours());
        assertEquals(0, instance.getMinutes());
        assertEquals(0, instance.getOffset());

        instance.snooze();
        assertEquals(0, instance.getHours());
        assertEquals(0, instance.getMinutes());
        assertEquals(0, instance.getOffset());

        instance.turnOnAlarm();
        instance.setSounding(true);
        instance.snooze();
        assertEquals(0, instance.getHours());
        assertEquals(0, instance.getMinutes());
        assertEquals(5, instance.getOffset());
        assertEquals(false, instance.isSounding());

        instance.snooze();
        assertEquals(0, instance.getHours());
        assertEquals(0, instance.getMinutes());
        assertEquals(5, instance.getOffset());
        assertEquals(false, instance.isSounding());
        
        instance.stopAlarm();

        instance.setHours(23);
        instance.setMinutes(55);
        instance.setSounding(true);
        instance.snooze();
        assertEquals(23, instance.getHours());
        assertEquals(55, instance.getMinutes());
        assertEquals(5, instance.getOffset());
        
        String expResult = "00:00";
        String result = instance.getAlarmTimeToSound();
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
        String expResult = "00:00";
        String result = instance.getAlarmTime();
        assertEquals(expResult, result);
        
        instance.setHours(10);
        instance.setMinutes(10);
        expResult = "10:10";
        result = instance.getAlarmTime();
        assertEquals(expResult, result);
        
        instance.setHours(5);
        instance.setMinutes(5);
        expResult = "05:05";
        result = instance.getAlarmTime();
        assertEquals(expResult, result);
    }    
}
