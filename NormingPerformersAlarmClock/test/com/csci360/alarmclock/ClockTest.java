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
 * @author ty
 */
public class ClockTest {
    
    public ClockTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of setTime method, of class Clock.
     */
    @Test
    public void testSetTime() {
        System.out.println("setTime");
        int hours = 12;
        int minutes = 45;
        Clock instance = new Clock();
        instance.setTime(hours, minutes);
        assertEquals(12, instance.time.getHours());
        assertEquals(45, instance.time.getMinutes());
    }

    /**
     * Test of switchTimeFormat method, of class Clock.
     */
    @Test
    public void testSwitchTimeFormat() {
        System.out.println("switchTimeFormat");
        Clock instance = new Clock();
        assertTrue(instance.twelveHourTime);
        instance.switchTimeFormat();
        assertFalse(instance.twelveHourTime);
        instance.switchTimeFormat();
        assertTrue(instance.twelveHourTime);
    }

    /**
     * Test of getTime method, of class Clock.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime");
        Clock instance = new Clock();
        
        // TESTING 12 HOUR TIME
        assertTrue(instance.twelveHourTime);
        instance.setTime(14, 25);
        assertEquals("2:25 pm", instance.getTime());
        instance.setTime(2, 25);
        assertEquals("2:25 am", instance.getTime());
        instance.setTime(23, 59);
        assertEquals("11:59 pm", instance.getTime());
        instance.setTime(0, 0);
        assertEquals("12:00 am", instance.getTime());
        
        // TESTING 12 HOUR TIME
        instance.switchTimeFormat();
        assertFalse(instance.twelveHourTime);
        instance.setTime(14, 25);
        assertEquals("14:25", instance.getTime());
        instance.setTime(2, 25);
        assertEquals("02:25", instance.getTime());
        instance.setTime(23, 59);
        assertEquals("23:59", instance.getTime());
        instance.setTime(0, 0);
        assertEquals("00:00", instance.getTime());
        
    }
    
}
