package com.csci360.alarmclock;

/**
 *
 * @author Normin' Performers
 */
public class Controller {
    private Radio radio;
    private Clock clock;
    private Alarm alarm1;
    private Alarm alarm2;
    private int volume;
    
    public Controller() {
        radio = new Radio();
        clock = new Clock();
        alarm1 = new Alarm();
        alarm2 = new Alarm();
        volume = 0;
    }
    
    public void startRadio() {
        radio.startRadio();
    }
    
    public void stopRadio() {
        radio.stopRadio();
    }
    
    public void startTune() {
        
    }
    
    public void stopTune() {
        
    }
    
    public void snooze() {
        if (alarm1.isSounding() || alarm2.isSounding()) {
            radio.stopRadio();
        }
        
        if (alarm1.isSounding()) {
            alarm1.snooze();
        }
        
        if (alarm2.isSounding()) {
            alarm2.snooze();
        }
    }
    
    public void switchTimeFormat() {
        clock.switchTimeFormat();
    }
    
    public void setTime(int h, int m) {
        clock.setTime(h, m);
    }
    
    public void setAlarm(int alarmNumber, int h, int m) {
        if (alarmNumber == 1) {
            alarm1.setHours(h);
            alarm1.setMinutes(m);
        } else if (alarmNumber == 2) {
            alarm2.setHours(h);
            alarm2.setMinutes(m);
            
        }
    }
}
