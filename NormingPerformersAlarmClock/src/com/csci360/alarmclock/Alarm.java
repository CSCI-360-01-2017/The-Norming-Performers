/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock;

/**
 *
 * @author Normin' Performers
 */

public class Alarm {
    
    static final int SNOOZE_TIME = 5;
    
    private int hours;
    private int minutes;
    private int offset;
    private boolean radioAlarm;
    private boolean sounding;
    private boolean alarmOn;
    
    public Alarm() {
        
        hours = 0;
        minutes = 0;
        offset = 0;
        radioAlarm = false;
        sounding = false;
        alarmOn = false;
        
    }

    /**
     * @return the hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * @param hours the hours to set
     */
    public void setHours(int hours) {
        this.hours = hours;
    }

    /**
     * @return the minutes
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * @param minutes the minutes to set
     */
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    /**
     * @return the sounding
     */
    public boolean isSounding() {
        return sounding;
    }

    /**
     * @param sounding the sounding to set
     */
    public void setSounding(boolean sounding) {
        this.sounding = sounding;
    }

    /**
     * @return the radioAlarm
     */
    public boolean isRadioAlarm() {
        return radioAlarm;
    }

    /**
     * @param radioAlarm the radioAlarm to set
     */
    public void setRadioAlarm(boolean radioAlarm) {
        this.radioAlarm = radioAlarm;
    }

    /**
     * @return the alarmOn
     */
    public boolean isAlarmOn() {
        return alarmOn;
    }

    public void turnOnAlarm() {
        this.alarmOn = true;
    }
    
    public void turnOffAlarm() {
        this.alarmOn = false;
        this.offset = 0;
        this.sounding = false;
    }
    
    public void stopAlarm() {
        
        turnOffAlarm();
        turnOnAlarm();

    }

    public void snooze() {

        int offsetMinutes = getOffset();
        
        if(isAlarmOn() && isSounding()){
            
            setSounding(false);
            
            offsetMinutes += SNOOZE_TIME;
            
            setOffset(offsetMinutes);
        }        
    } 
    
    public String getAlarmTime(){
        
        String alarmTime = "";
        int alarmTimeHours = getHours();
        int alarmTimeMinutes = getMinutes();
        
        alarmTime += String.format("%02d", alarmTimeHours);
        alarmTime += String.format("%02d", alarmTimeMinutes);
                
        return alarmTime;
    }
    
    public String getAlarmTimeToSound(){
        
        String alarmTimeToSound = "";
        int alarmTimeHours = getHours();
        int alarmTimeMinutes = getMinutes();
        int alarmOffsetMinutes = getOffset();
        
        alarmTimeMinutes += alarmOffsetMinutes;
        alarmTimeHours += (alarmOffsetMinutes / 60);
        if(alarmTimeMinutes >= 60){
            
            alarmTimeMinutes = alarmTimeMinutes % 60;
        
        }
        
        if(alarmTimeHours >= 24){
            
            alarmTimeHours = alarmTimeHours % 24;
        
        }
        
        alarmTimeToSound += String.format("%02d", alarmTimeHours);
        alarmTimeToSound += String.format("%02d", alarmTimeMinutes);
        
        return alarmTimeToSound;
    }

    public int getOffset() {
        return offset;
    }   
    
    public void setOffset(int offset) {
        this.offset = offset;
    }
}
