package com.csci360.alarmclock;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Normin' Performers
 */
public class Clock {
        // Object responsible for storing and changing
        // the time of the Clock object
	Time time;
	// Boolean that holds the value that determines
        // whether or not the clock is in 12-Hour Time
        boolean twelveHourTime;

        /**
         * Used to initialize a new clock object
         */
	public Clock() {
                // Initializes the new time object
		time = new Time();
                // Defaults the Clock to 12-Hour Time
		twelveHourTime = true;
	}

        /**
         * Used to set the time of the Clock
         * 
         * @param hours
         * @param minutes 
         */
	public void setTime(int hours, int minutes) {
                // Sets the time to the designated
		time.setTime(hours, minutes);
	}

        /**
         * Used to switch the time format of
         * the clock from twelve hour time to
         * twenty four hour time and vice versa
         */
	public void switchTimeFormat() {
                // Inverts the 12-Hour Time boolean
		twelveHourTime = !twelveHourTime;
	}

        /**
         * Used to get the time stored in the Clock
         * 
         * @return 
         */
	public String getTimeString() {
                // Holds the time to be returned
		String returnTime = "";
                // Holds the current hour number of the Time
		int hours = time.getHours();
                // Holds the current minute number of the Time
                int minutes = time.getMinutes();
                
                // Splits based off of whether or not the
                // Clock is in 12-Hour Time
		if (twelveHourTime) {      
                        // Splits based off whether it is 12 o'clock
                        if (hours % 12 == 0) {
                            // If it is 12, add 12 to the returnTime
                            returnTime += Integer.toString(12);
                        } else {
                            // Otherwise, add the hour value, modulo 12
                            returnTime += Integer.toString(hours % 12);
                        }
                        
                        returnTime += ":";
                        
                        // Splits based off whether the minutes are
                        // less than 10
                        if (minutes < 10) {
                            // If it is less than 10, adds an extra 0
                            returnTime += Integer.toString(0);
                        }
                        // Adds the current minute value to the returnTime
                        returnTime += Integer.toString(minutes);

                        // Splits based on whether the time is less than 12
			if (hours >= 12) {
                                // If not, adds "pm" to the returnTime
				returnTime += " pm";
			} else {
                                // Otherwise, adds "am" to the returnTime
				returnTime += " am";
			}
		} else {
                        // Splits based off whether the hour value is
                        // a single digit
			if (hours < 10) {
                            // If so, it adds an extra 0
                            returnTime += Integer.toString(0);
                        }
                        // Adds the hour value to the returnTime
                        returnTime += Integer.toString(time.getHours());
                        
                        returnTime += ":";
                        
                        // Splits based off whether the minute value is
                        // a single digit
                        if (minutes < 10) {
                            // If so, it adds an extra 0
                            returnTime += Integer.toString(0);
                        }
                        // Adds the minute value to the returnTime
			returnTime += Integer.toString(time.getMinutes());
		}

                // Returns the correct time
		return returnTime;
	}

    public Time getTime() {
        return time;
    }
}