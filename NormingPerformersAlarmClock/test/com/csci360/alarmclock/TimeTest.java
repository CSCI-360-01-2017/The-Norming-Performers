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
        Time instance = new Time();
        instance.increment();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHours method, of class Time.
     */
    @Test
    public void testGetHours() {
        System.out.println("getHours");
        Time instance = new Time();
        int expResult = 0;
        int result = instance.getHours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMinutes method, of class Time.
     */
    @Test
    public void testGetMinutes() {
        System.out.println("getMinutes");
        Time instance = new Time();
        int expResult = 0;
        int result = instance.getMinutes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
