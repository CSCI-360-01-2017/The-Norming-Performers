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
public class RadioTest {
    
    public RadioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of startRadio method, of class Radio.
     */
    @Test
    public void testStartRadio() {
        System.out.println("startRadio");
        Radio instance = new Radio();
        assertFalse(instance.isPlaying());
        instance.startRadio();
        assertTrue(instance.isPlaying());
    }

    /**
     * Test of stopRadio method, of class Radio.
     */
    @Test
    public void testStopRadio() {
        System.out.println("stopRadio");
        Radio instance = new Radio();
        instance.startRadio();
        assertTrue(instance.isPlaying());
        instance.stopRadio();
        assertFalse(instance.isPlaying());
    }

    /**
     * Test of incrementStation method, of class Radio.
     */
    @Test
    public void testIncrementStation() {
        System.out.println("incrementStation");
        Radio instance = new Radio();
        
        // TESTING FM
        assertEquals("FM", instance.getRadioType());
        assertEquals(100.1, instance.getFmStation(), .001);
        instance.incrementStation();
        assertEquals(100.3, instance.getFmStation(), .001);
        for (int i = 0; i < 13; i++)
            instance.incrementStation();
        assertEquals(102.9, instance.getFmStation(), .001);
        for (int i = 0; i < 25; i++)
            instance.incrementStation();
        assertEquals(107.9, instance.getFmStation(), .001);
        instance.incrementStation();
        assertEquals(88.1, instance.getFmStation(), .001);
        
        // TESTING AM
        instance.switchType();
        assertEquals("AM", instance.getRadioType());
        assertEquals(1000, instance.getAmStation());
        instance.incrementStation();
        assertEquals(1010, instance.getAmStation());
        for (int i = 0; i < 13; i++)
            instance.incrementStation();
        assertEquals(1140, instance.getAmStation());
        for (int i = 0; i < 46; i++)
            instance.incrementStation();
        assertEquals(1600, instance.getAmStation());
        instance.incrementStation();
        assertEquals(540, instance.getAmStation());
    }

    /**
     * Test of decrementStation method, of class Radio.
     */
    @Test
    public void testDecrementStation() {
        System.out.println("decrementStation");
        Radio instance = new Radio();
        
        // TESTING FM
        assertEquals("FM", instance.getRadioType());
        assertEquals(100.1, instance.getFmStation(), .001);
        instance.decrementStation();
        assertEquals(99.9, instance.getFmStation(), .001);
        for (int i = 0; i < 10; i++)
            instance.decrementStation();
        assertEquals(97.9, instance.getFmStation(), .001);
        for (int i = 0; i < 49; i++)
            instance.decrementStation();
        assertEquals(88.1, instance.getFmStation(), .001);
        instance.decrementStation();
        assertEquals(107.9, instance.getFmStation(), .001);
        
        // TESTING AM
        instance.switchType();
        assertEquals("AM", instance.getRadioType());
        assertEquals(1000, instance.getAmStation());
        instance.decrementStation();
        assertEquals(990, instance.getAmStation());
        for (int i = 0; i < 13; i++)
            instance.decrementStation();
        assertEquals(860, instance.getAmStation());
        for (int i = 0; i < 32; i++)
            instance.decrementStation();
        assertEquals(540, instance.getAmStation());
        instance.decrementStation();
        assertEquals(1600, instance.getAmStation());
    }

    /**
     * Test of switchType method, of class Radio.
     */
    @Test
    public void testSwitchType() {
        System.out.println("switchType");
        Radio instance = new Radio();
        assertEquals("FM", instance.getRadioType());
        instance.switchType();
        assertEquals("AM", instance.getRadioType());
        instance.switchType();
        assertEquals("FM", instance.getRadioType());
    }
    
}
