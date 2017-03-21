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
        Alarm instance = new Alarm();
        
        assertEquals(0, instance.getHours());
        assertEquals(0, instance.getMinutes());
        
        instance.snooze();
        assertEquals(0, instance.getHours());
        assertEquals(0, instance.getMinutes());
        
        instance.turnOnAlarm();
        assertEquals(0, instance.getHours());
        assertEquals(0, instance.getMinutes());
        
        instance.setSounding(true);
        instance.snooze();
        assertEquals(0, instance.getHours());
        assertEquals(5, instance.getMinutes());
        assertEquals(false, instance.isSounding());
        
        instance.setHours(23);
        instance.setMinutes(55);
        instance.setSounding(true);
        instance.snooze();
        assertEquals(0, instance.getHours());
        assertEquals(0, instance.getMinutes());
        assertEquals(false, instance.isSounding());
        
    }

    /**
     * Test of getAlarmTime method, of class Alarm.
     */
    @Test
    public void testGetAlarmTime() {
        System.out.println("getAlarmTime");
        Alarm instance = new Alarm();
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
