package com.csci360.alarmclock;

import java.util.Timer;
import java.util.TimerTask;

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
    private boolean tunePlaying;
    
    // Java Timer used to increment the time
    private Timer timer;
    
    public Controller() {
        radio = new Radio();
        clock = new Clock();
        alarm1 = new Alarm();
        alarm2 = new Alarm();
        volume = 0;
        // Creates a new Timer object
        timer = new Timer();
        // Creates a new schedule for the timer to act
        // every minute
        timer.schedule(new CheckTimeTask(), 0, 10000);
    }
    
    /**
    * Class used to continually check the alarm times against the clock time
    */
   class CheckTimeTask extends TimerTask {
        /**
         * Used to check the alarm times
         */
        @Override
        public void run() {
            // Increments the time
            checkAlarms();
        }
   }
   
   public void checkAlarms() {
       // checks whether alarm1 should go off
       if (this.alarm1.getHours() == this.clock.getTime().getHours()
           && this.alarm1.getMinutes() == this.clock.getTime().getMinutes()) {
           // the alarm1 is at the alarm time, must sound alarm
           if (this.alarm1.isRadioAlarm()) 
               // the alarm is in radio mode, plays the radio
               this.startRadio();
           
           else
               // the alarm is in tune mode, plays the tune
               this.startTune();
           
           this.alarm1.setSounding(true);
       }
       
       // checks whether alarm2 should go off
       if (this.alarm2.getHours() == this.clock.getTime().getHours()
           && this.alarm2.getMinutes() == this.clock.getTime().getMinutes()) {
           // the alarm2 is at the alarm time, must sound alarm
           if (this.alarm2.isRadioAlarm())
               // the alarm is in radio mode, plays the radio
               this.startRadio();
           
           else
               // the alarm is in tune mode, plays the tune
               this.startTune();
           
           this.alarm2.setSounding(true);
       }
   }
    
    public void startRadio() {
        radio.startRadio();
    }
    
    public void stopRadio() {
        radio.stopRadio();
    }
    
    public void startTune() {
        this.tunePlaying = true;
    }
    
    public void stopTune() {
        this.tunePlaying = false;
    }
    
    public boolean radioIsPlaying() {
        return this.radio.isPlaying();
    }
    
    public boolean tuneIsPlaying() {
        return this.tunePlaying;
    }
    
    public void snooze() {
        if (this.alarm1Sounding() || this.alarm2Sounding()) {
            this.radio.stopRadio();
            this.stopTune();
            
            if (this.alarm1Sounding()) {
                alarm1.snooze();
            }
            if (this.alarm2Sounding()) {
                alarm2.snooze();
            }
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

    public Alarm getAlarm1() {
        return alarm1;
    }

    public Alarm getAlarm2() {
        return alarm2;
    }

    public Clock getClock() {
        return clock;
    }
    
    public boolean alarm1Sounding() {
        return this.alarm1.isSounding();
    }
    
    public boolean alarm2Sounding() {
        return this.alarm2.isSounding();
    }
}
