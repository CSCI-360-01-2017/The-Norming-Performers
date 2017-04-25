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
        assertFalse(instance.radioIsPlaying());
        instance.startRadio();
        assertTrue(instance.radioIsPlaying());
    }

    /**
     * Test of stopRadio method, of class Controller.
     */
    @Test
    public void testStopRadio() {
        System.out.println("stopRadio");
        Controller instance = new Controller();
        instance.startRadio();
        assertTrue(instance.radioIsPlaying());
        instance.stopRadio();
        assertFalse(instance.radioIsPlaying());
    }

    /**
     * Test of startTune method, of class Controller.
     */
    @Test
    public void testStartTune() {
        System.out.println("startTune");
        Controller instance = new Controller();
        assertFalse(instance.tuneIsPlaying());
        instance.startTune();
        assertTrue(instance.tuneIsPlaying());
    }

    /**
     * Test of stopTune method, of class Controller.
     */
    @Test
    public void testStopTune() {
        System.out.println("stopTune");
        Controller instance = new Controller();
        instance.startTune();
        assertTrue(instance.tuneIsPlaying());
        instance.stopTune();
        assertFalse(instance.tuneIsPlaying());
    }

    /**
     * Test of snooze method, of class Controller.
     */
    @Test
    public void testSnooze() {
        System.out.println("snooze");
        Controller instance = new Controller();
        Alarm alarm1 = instance.getAlarm1();
        Alarm alarm2 = instance.getAlarm2();
        
        // TESTS ONLY ALARM 1
        alarm1.setSounding(true);
        assertTrue(alarm1.isSounding());
        instance.snooze();
        assertFalse(alarm1.isSounding());
        
        // TESTS ONLY ALARM 2
        alarm2.setSounding(true);
        assertTrue(alarm2.isSounding());
        instance.snooze();
        assertFalse(alarm2.isSounding());
        
        // TESTS BOTH ALARMS
        alarm1.setSounding(true);
        alarm2.setSounding(true);
        assertTrue(alarm1.isSounding());
        assertTrue(alarm2.isSounding());
        instance.snooze();
        assertFalse(alarm1.isSounding());
        assertFalse(alarm2.isSounding());
        
        // TESTS NEITHER ALARM
        alarm1.setSounding(false);
        alarm2.setSounding(false);
        assertFalse(alarm1.isSounding());
        assertFalse(alarm2.isSounding());
        instance.snooze();
        assertFalse(alarm1.isSounding());
        assertFalse(alarm2.isSounding());
    }

    /**
     * Test of switchTimeFormat method, of class Controller.
     */
    @Test
    public void testSwitchTimeFormat() {
        System.out.println("switchTimeFormat");
        Controller instance = new Controller();
        Clock clock = instance.getClock();
        assertTrue(clock.twelveHourTime);
        instance.switchTimeFormat();
        assertFalse(clock.twelveHourTime);
        instance.switchTimeFormat();
        assertTrue(clock.twelveHourTime);
    }

    /**
     * Test of setTime method, of class Controller.
     */
    @Test
    public void testSetTime() {
        System.out.println("setTime");
        int h = 12;
        int m = 50;
        Controller instance = new Controller();
        instance.setTime(h, m);
        assertEquals(12, instance.getClock().getTime().getHours());
        assertEquals(50, instance.getClock().getTime().getMinutes());
    }

    /**
     * Test of setAlarm method, of class Controller.
     */
    @Test
    public void testSetAlarm() {
        System.out.println("setAlarm");
        int alarmNumber = 1;
        int h = 4;
        int m = 47;
        Controller instance = new Controller();
        
        // TESTS ALARM 1
        instance.setAlarm(alarmNumber, h, m);
        assertEquals(4, instance.getAlarm1().getHours());
        assertEquals(47, instance.getAlarm1().getMinutes());
        
        // TESTS ALARM 2
        alarmNumber = 2;
        instance.setAlarm(alarmNumber, h, m);
        assertEquals(4, instance.getAlarm1().getHours());
        assertEquals(47, instance.getAlarm2().getMinutes());
    }

    /**
     * Test of radioIsPlaying method, of class Controller.
     */
    @Test
    public void testRadioIsPlaying() {
        System.out.println("radioIsPlaying");
        Controller instance = new Controller();
        assertFalse(instance.radioIsPlaying());
        instance.startRadio();
        assertTrue(instance.radioIsPlaying());
    }

    /**
     * Test of tuneIsPlaying method, of class Controller.
     */
    @Test
    public void testTuneIsPlaying() {
        System.out.println("tuneIsPlaying");
        Controller instance = new Controller();
        assertFalse(instance.tuneIsPlaying());
        instance.startTune();
        assertTrue(instance.tuneIsPlaying());
    }

    /**
     * Test of alarm1Sounding method, of class Controller.
     */
    @Test
    public void testAlarm1Sounding() {
        System.out.println("alarm1Sounding");
        Controller instance = new Controller();
        assertFalse(instance.getAlarm1().isSounding());
        instance.getAlarm1().setSounding(true);
        assertTrue(instance.getAlarm1().isSounding());
    }

    /**
     * Test of alarm2Sounding method, of class Controller.
     */
    @Test
    public void testAlarm2Sounding() {
        System.out.println("alarm2Sounding");
        Controller instance = new Controller();
        assertFalse(instance.getAlarm2().isSounding());
        instance.getAlarm2().setSounding(true);
        assertTrue(instance.getAlarm2().isSounding());
    }

    /**
     * Test of checkAlarms method, of class Controller.
     */
    @Test
    public void testCheckAlarms() {
        System.out.println("checkAlarms");
        Controller instance = new Controller();
        instance.getClock().setTime(4, 40);
        instance.setAlarm(1, 4, 40);
        instance.setAlarm(2, 4, 40);
        instance.checkAlarms();
        System.out.println(instance.getAlarm1().getAlarmTime());
        System.out.println(instance.getAlarm1().getOffsetHours());
        System.out.println(instance.getClock().getTimeString());
        assertTrue(instance.getAlarm1().isSounding());
        assertTrue(instance.getAlarm2().isSounding());
    }
    
}
