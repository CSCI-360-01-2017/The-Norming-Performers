/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock;

/**
 *
 * @author ty
 */
public class Radio {
    
    static final int MIN_AM = 540;
    static final int MAX_AM = 1600;
    static final double MIN_FM = 88.0;
    static final double MAX_FM = 108.0;
        
    private String radioType = "FM";    // either FM or AM
    private double fmStation = 100.1;
    private int amStation = 1000;
    private boolean playing = false;
    
    public Radio() {}
    
    public void startRadio() {
        this.playing = true;
    }
    
    public void stopRadio() {
        this.playing = false;
    }
    
    public void incrementStation() {
        if (this.radioType.equals("FM")) {
            this.fmStation = this.fmStation + .2;
            if (this.fmStation > Radio.MAX_FM)
                this.fmStation -= (Radio.MAX_FM - Radio.MIN_FM);
            
        } else {
            this.amStation = this.amStation + 10;
            if (this.amStation > Radio.MAX_AM)
                this.amStation -= (Radio.MAX_AM - Radio.MIN_AM + 10);
        }
    }
    
    public void decrementStation() {
        if (this.radioType.equals("FM")) {
            this.fmStation = this.fmStation - .2;
            if (this.fmStation < Radio.MIN_FM)
                this.fmStation += (Radio.MAX_FM - Radio.MIN_FM);
            
        } else {
            this.amStation = this.amStation - 10;
            if (this.amStation < Radio.MIN_AM)
                this.amStation += (Radio.MAX_AM - Radio.MIN_AM + 10);
        }
    }
    
    public void switchType() {
        if (this.radioType.equals("FM"))
            this.radioType = "AM";
        else
            this.radioType = "FM";
    }

    public int getAmStation() {
        return amStation;
    }

    public double getFmStation() {
        return fmStation;
    }

    public String getRadioType() {
        return radioType;
    }

    public boolean isPlaying() {
        return playing;
    }
    
}
