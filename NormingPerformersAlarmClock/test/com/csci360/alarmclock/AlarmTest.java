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

    /**
     * Test of getHours method, of class Alarm.
     */
    @Test
    public void testGetHours() {
        System.out.println("getHours");
        Alarm instance = new Alarm();
        int expResult = 0;
        int result = instance.getHours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHours method, of class Alarm.
     */
    @Test
    public void testSetHours() {
        System.out.println("setHours");
        int hours = 0;
        Alarm instance = new Alarm();
        instance.setHours(hours);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMinutes method, of class Alarm.
     */
    @Test
    public void testGetMinutes() {
        System.out.println("getMinutes");
        Alarm instance = new Alarm();
        int expResult = 0;
        int result = instance.getMinutes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMinutes method, of class Alarm.
     */
    @Test
    public void testSetMinutes() {
        System.out.println("setMinutes");
        int minutes = 0;
        Alarm instance = new Alarm();
        instance.setMinutes(minutes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isSounding method, of class Alarm.
     */
    @Test
    public void testIsSounding() {
        System.out.println("isSounding");
        Alarm instance = new Alarm();
        boolean expResult = false;
        boolean result = instance.isSounding();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSounding method, of class Alarm.
     */
    @Test
    public void testSetSounding() {
        System.out.println("setSounding");
        boolean sounding = false;
        Alarm instance = new Alarm();
        instance.setSounding(sounding);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isRadioAlarm method, of class Alarm.
     */
    @Test
    public void testIsRadioAlarm() {
        System.out.println("isRadioAlarm");
        Alarm instance = new Alarm();
        boolean expResult = false;
        boolean result = instance.isRadioAlarm();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRadioAlarm method, of class Alarm.
     */
    @Test
    public void testSetRadioAlarm() {
        System.out.println("setRadioAlarm");
        boolean radioAlarm = false;
        Alarm instance = new Alarm();
        instance.setRadioAlarm(radioAlarm);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAlarmOn method, of class Alarm.
     */
    @Test
    public void testIsAlarmOn() {
        System.out.println("isAlarmOn");
        Alarm instance = new Alarm();
        boolean expResult = false;
        boolean result = instance.isAlarmOn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of turnOnAlarm method, of class Alarm.
     */
    @Test
    public void testTurnOnAlarm() {
        System.out.println("turnOnAlarm");
        Alarm instance = new Alarm();
        instance.turnOnAlarm();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of turnOffAlarm method, of class Alarm.
     */
    @Test
    public void testTurnOffAlarm() {
        System.out.println("turnOffAlarm");
        Alarm instance = new Alarm();
        instance.turnOffAlarm();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAlarmTimeToSound method, of class Alarm.
     */
    @Test
    public void testGetAlarmTimeToSound() {
        System.out.println("getAlarmTimeToSound");
        Alarm instance = new Alarm();
        String expResult = "";
        String result = instance.getAlarmTimeToSound();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOffset method, of class Alarm.
     */
    @Test
    public void testGetOffset() {
        System.out.println("getOffset");
        Alarm instance = new Alarm();
        int expResult = 0;
        int result = instance.getOffset();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOffset method, of class Alarm.
     */
    @Test
    public void testSetOffset() {
        System.out.println("setOffset");
        int offset = 0;
        Alarm instance = new Alarm();
        instance.setOffset(offset);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
