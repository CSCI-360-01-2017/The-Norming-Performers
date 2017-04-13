package com.csci360.alarmclock;
import java.util.Timer;
import java.util.TimerTask;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Normin' Performers
 */

public class Time {
        // Java Timer used to increment the time
        private Timer timer;
        // Holds the hour value of the time
        private int hours;
        // Holds the minute value of the time
        private int minutes;
	
        /**
         * Used to initialize a new Time object
         */
        public Time() {
                // Defaults the hour and minute values to 0
        	hours = 0;
                minutes = 0;
                // Creates a new Timer object
                timer = new Timer();
                // Creates a new schedule for the timer to act
                // every minute
                timer.schedule(new IncrementTask(), 0, 6000);
        }

        /**
         * Class used to continually increment the time
         */
        class IncrementTask extends TimerTask {
                /**
                 * Used to increment the time
                 */
                public void run() {
                    // Increments the time
                    increment();
                }
        }

        /**
         * Used to increment the minute value of the system
         * and, if needed, increment the hours
         */
        public void increment() {
                // Increments the minute value
                minutes++;

                // Splits if the minutes equal 60
                if (minutes % 60 == 0) {
                        // If so, it resets the minutes to 0 and
                        // increments the hour value by one
                        minutes = 0;
                        hours++;

                        // Splits if the hour value equals 24
                        if (hours % 24 == 0) {
                                // Resets the hour value to 0
                                hours = 0;
                        }
                }
        }
        
        public int minuteDifference(Time otherTime) {
            int hourDif = this.hours - otherTime.getHours();
            int minuteDif = this.minutes - otherTime.getMinutes();
            return (hourDif*60) + minuteDif;
        }

        /**
         * 
         * @param h
         * @param m 
         */
        public void setTime(int h, int m) {
                // Sets the hour value to the provided
                hours = h;
                // Sets the minute value to the provided
                minutes = m;
        }

        /**
         * Used to get the current hour value of the Time
         * 
         * @return 
         */
        public int getHours() {
                // Returns the hour value
                return hours;
        }

        /**
         * Used to get the current minute value of the Time
         * 
         * @return 
         */
        public int getMinutes() {
                // Returns the minute value
                return minutes;
        }
}