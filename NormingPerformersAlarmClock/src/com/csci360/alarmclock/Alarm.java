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
    private boolean radioAlarm;
    private boolean sounding;
    private boolean alarmOn;
    
    public Alarm() {
        
        hours = 0;
        minutes = 0;
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
        if(this.hours < 24 && this.hours > 0){
            this.hours = hours;
        }
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
        if(this.minutes < 60 && this.minutes > 0){
            this.minutes = minutes;
        }
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
    }
    
    public void snooze() {
        
        int alarmHours = getHours();
        int alarmMinutes = getMinutes();
        
        if(isAlarmOn() && isSounding()){
            
            setSounding(false);
            
            alarmMinutes += SNOOZE_TIME;
        
        
            if(alarmMinutes >= 60){
            
                alarmMinutes = alarmMinutes % 60;
                alarmHours++;
            
            }
        
            if(alarmHours >= 24){
            
                alarmHours = alarmHours % 24;
            
            }
        
            setHours(alarmHours);
            setMinutes(alarmMinutes);
        }        
    } 
    
    public String getAlarmTime(){
        
        String alarmTime = "";
        int alarmTimeHours = getHours();
        int alarmTimeMinutes = getMinutes();
        alarmTime += String.format("%02d", alarmTimeHours);
        alarmTime += ":";
        alarmTime += String.format("%02d", alarmTimeMinutes);
                
        return alarmTime;
    }
}
