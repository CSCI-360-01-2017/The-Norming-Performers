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
public class TimeTest {
    
    public TimeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of increment method, of class Time.
     */
    @Test
    public void testIncrement() {
        System.out.println("increment");
        int h = 0;
        int m = 0;
        Time instance = new Time();
        instance.setTime(h, m);
        //instantiate
        assertEquals(0, instance.getHours());
        assertEquals(0, instance.getMinutes());
        //minutes increment properly
        instance.increment();
        assertEquals(0, instance.getHours());
        assertEquals(1, instance.getMinutes());
        //minutes carry over
        instance.setTime(h, 59);
        instance.increment();
        assertEquals(1, instance.getHours());
        assertEquals(0, instance.getMinutes());
    }

    /**
     * Test of setTime method, of class Time.
     */
    @Test
    public void testSetTime() {
        System.out.println("setTime");
        int h = 0;
        int m = 0;
        Time instance = new Time();
        instance.setTime(h, m);
        assertEquals(0, instance.getHours());
        assertEquals(0, instance.getMinutes());
    }
}
