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
public class ControllerTest {
    
    public ControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of startRadio method, of class Controller.
     */
    @Test
    public void testStartRadio() {
        System.out.println("startRadio");
        Controller instance = new Controller();
        instance.startRadio();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stopRadio method, of class Controller.
     */
    @Test
    public void testStopRadio() {
        System.out.println("stopRadio");
        Controller instance = new Controller();
        instance.stopRadio();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of startTune method, of class Controller.
     */
    @Test
    public void testStartTune() {
        System.out.println("startTune");
        Controller instance = new Controller();
        instance.startTune();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stopTune method, of class Controller.
     */
    @Test
    public void testStopTune() {
        System.out.println("stopTune");
        Controller instance = new Controller();
        instance.stopTune();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of snooze method, of class Controller.
     */
    @Test
    public void testSnooze() {
        System.out.println("snooze");
        Controller instance = new Controller();
        instance.snooze();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of switchTimeFormat method, of class Controller.
     */
    @Test
    public void testSwitchTimeFormat() {
        System.out.println("switchTimeFormat");
        Controller instance = new Controller();
        instance.switchTimeFormat();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTime method, of class Controller.
     */
    @Test
    public void testSetTime() {
        System.out.println("setTime");
        int h = 0;
        int m = 0;
        Controller instance = new Controller();
        instance.setTime(h, m);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAlarm method, of class Controller.
     */
    @Test
    public void testSetAlarm() {
        System.out.println("setAlarm");
        int alarmNumber = 0;
        int h = 0;
        int m = 0;
        Controller instance = new Controller();
        instance.setAlarm(alarmNumber, h, m);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
