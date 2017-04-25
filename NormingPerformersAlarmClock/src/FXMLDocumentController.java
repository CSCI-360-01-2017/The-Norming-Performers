/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import com.csci360.alarmclock.Controller;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author ty
 */
public class FXMLDocumentController implements Initializable {
        
    @FXML private ToggleButton onOffButton;
    @FXML private Circle powerCircle;
    @FXML private Text timeText;
    @FXML private Text editText;
    @FXML private Text station;
    @FXML private Button viewAlarmButton;
    @FXML private Button editButton;
    @FXML private ToggleButton radioOnOffButton;
    @FXML private ToggleButton AMFMButton;
    @FXML private ToggleButton toneRadioButton;
    @FXML private Button downStation;
    @FXML private Button upStation;
    
    private Controller system = new Controller();
    private boolean isOn = true;
    private boolean radioWasOn;
    private MediaPlayer batmanPlayer;
    private MediaPlayer radioPlayer;
    
    private String displayed = "time";
    private String editing = "none";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.powerCircle.setFill(Color.LAWNGREEN);
        this.timeText.setText(system.getClock().getTimeString());
        this.editText.setText("");
        this.station.setText(Double.toString(system.getRadio().getFmStation()));
        
        URL file = FXMLDocumentController.class.getClassLoader().getResource("batman_theme_x.mp3");
        final Media media = new Media(file.toString());
        this.batmanPlayer = new MediaPlayer(media);
        this.batmanPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        
        Timer timer = new Timer();
        timer.schedule(new IncrementTask(), 0, 6000);
    }
    
    class IncrementTask extends TimerTask {
        /**
        * Used to increment the time
        */
        public void run() {
            // Increments the time
            system.checkAlarms();
            updateTimeText();
            updateEditText();
            updateSounding();
        }
    }
    
    private void playSound() {
        this.batmanPlayer.play();
    }
    
    @FXML
    private void updateTimeText() {
        if (!isOn)
            this.timeText.setText("");
        else if (this.displayed.equals("time"))
            this.timeText.setText(system.getClock().getTimeString());
        else if (this.displayed.equals("alarm1"))
            this.timeText.setText(system.getAlarm1().getAlarmTime());
        else if (this.displayed.equals("alarm2"))
            this.timeText.setText(system.getAlarm2().getAlarmTime());
    }
    
    @FXML
    private void updateEditText() {
        if (this.displayed.equals("time")) {
            if (this.editing.equals("none"))
                this.editText.setText("Viewing Time");
            else if (this.editing.equals("minutes"))
                this.editText.setText("Editing Time Minutes");
            else if (this.editing.equals("hours"))
                this.editText.setText("Editing Time Hours");
            
        } else if (this.displayed.equals("alarm1")) {
            if (this.editing.equals("none"))
                this.editText.setText("Viewing Alarm1");
            else if (this.editing.equals("minutes"))
                this.editText.setText("Editing Alarm1 Minutes");
            else if (this.editing.equals("hours"))
                this.editText.setText("Editing Alarm1 Hours");
            
        } else if (this.displayed.equals("alarm2")) {
            if (this.editing.equals("none"))
                this.editText.setText("Viewing Alarm2");
            else if (this.editing.equals("minutes"))
                this.editText.setText("Editing Alarm2 Minutes");
            else if (this.editing.equals("hours"))
                this.editText.setText("Editing Alarm2 Hours");
        }
    }
    
    @FXML
    private void updateSounding() {
        if(system.alarm1Sounding()) {
            this.editText.setText("WAKE UP");
            if (this.toneRadioButton.isSelected() && !this.radioOnOffButton.isSelected()) {
                this.radioOnOffButton.setSelected(true);
                this.playRadio();
            }
            else if (this.toneRadioButton.isSelected() && this.radioOnOffButton.isSelected())
            {
                this.unmuteRadio();
            }
            else
            {
                this.muteRadio();
                this.playSound();
            }
                
        }
        else if (system.alarm2Sounding()) {
            this.editText.setText("WAKE UP");
            if (this.toneRadioButton.isSelected() && !this.radioOnOffButton.isSelected()) {
                this.radioOnOffButton.setSelected(true);
                this.playRadio();
            } 
            else if (this.toneRadioButton.isSelected() && this.radioOnOffButton.isSelected())
            {
                this.unmuteRadio();
            }
            else
            {
                this.muteRadio();
                this.playSound();
            }
        }
    }
    
    @FXML
    private void snoozeClicked(ActionEvent event) {
        system.snooze();
        this.batmanPlayer.stop();
        if (this.radioWasOn == false) {
            this.muteRadio();
        }
        updateEditText();
    }
    
    @FXML
    private void stopClicked(ActionEvent event) {
        system.getAlarm1().stopAlarm();
        system.getAlarm2().stopAlarm();
        this.batmanPlayer.stop();
        if(this.radioWasOn == false)
        {
            this.stopRadio();
        }
        else if(this.radioWasOn == true)
        {
            this.unmuteRadio();
        }
        updateEditText();
    }
    
    
    
    @FXML
    private void onOffClicked(ActionEvent event) {
        isOn = !isOn;
        
        if(isOn)
            this.timeText.setText(system.getClock().getTimeString()); 
        else
            this.timeText.setText("");
        
        if (this.onOffButton.isSelected())
            this.powerCircle.setFill(Color.LAWNGREEN);
        else
            this.powerCircle.setFill(Color.RED);
    }
    
    @FXML
    private void onEditTimeClicked(ActionEvent event) {
        if (this.editing.equals("none") || this.editing.equals("minutes")) {
            this.editing = "hours";
            this.viewAlarmButton.setDisable(true);
        } else if (this.editing.equals("hours")) {
            this.editing = "minutes";
            this.viewAlarmButton.setDisable(true);
        }
        
        updateEditText();
    }
    
    @FXML
    private void on1224HRClicked(ActionEvent event) {
        system.switchTimeFormat();
        updateTimeText();
    }
    
    @FXML
    private void onUpClicked(ActionEvent event) {
        if (this.displayed.equals("time")) {
            if (this.editing.equals("minutes")) {
                int hours = system.getClock().getTime().getHours();
                int minutes = (system.getClock().getTime().getMinutes() + 1) % 60;
                system.setTime(hours, minutes);
                updateTimeText();
            } else if (this.editing.equals("hours")) {
                int hours = (system.getClock().getTime().getHours() + 1) % 24;
                int minutes = system.getClock().getTime().getMinutes();
                system.setTime(hours, minutes);
                updateTimeText();
            }
            
        } else if (this.displayed.equals("alarm1")) {
            if (this.editing.equals("minutes")) {
                int hours = system.getAlarm1().getHours();
                int minutes = (system.getAlarm1().getMinutes() + 1) % 60;
                system.setAlarm(1, hours, minutes);
                updateTimeText();
            } else if (this.editing.equals("hours")) {
                int hours = (system.getAlarm1().getHours() + 1) % 24;
                int minutes = system.getAlarm1().getMinutes();
                system.setAlarm(1, hours, minutes);
                updateTimeText();
            }
            
        } else if (this.displayed.equals("alarm2")) {
            if (this.editing.equals("minutes")) {
                int hours = system.getAlarm2().getHours();
                int minutes = (system.getAlarm2().getMinutes() + 1) % 60;
                system.setAlarm(1, hours, minutes);
                updateTimeText();
            } else if (this.editing.equals("hours")) {
                int hours = (system.getAlarm2().getHours() + 1) % 24;
                int minutes = system.getAlarm2().getMinutes();
                system.setAlarm(1, hours, minutes);
                updateTimeText();
            }
        }
    }
    
    @FXML
    private void onDownClicked(ActionEvent event) {
        if (this.displayed.equals("time")) {
            if (this.editing.equals("minutes")) {
                int hours = system.getClock().getTime().getHours();
                int minutes = system.getClock().getTime().getMinutes() - 1;
                if (minutes < 0)
                    minutes += 60;
                system.setTime(hours, minutes);
                updateTimeText();
                updateTimeText();
            } else if (this.editing.equals("hours")) {
                int hours = system.getClock().getTime().getHours() - 1;
                if (hours < 0)
                    hours += 24;
                int minutes = system.getClock().getTime().getMinutes();
                system.setTime(hours, minutes);
                updateTimeText();
            }
            
        } else if (this.displayed.equals("alarm1")) {
            if (this.editing.equals("minutes")) {
                int hours = system.getAlarm1().getHours();
                int minutes = (system.getAlarm1().getMinutes() - 1) % 60;
                if (minutes < 0)
                    minutes += 60;
                system.setAlarm(1, hours, minutes);
                updateTimeText();
            } else if (this.editing.equals("hours")) {
                int hours = (system.getAlarm1().getHours() - 1) % 24;
                int minutes = system.getAlarm1().getMinutes();
                if (hours < 0)
                    hours += 24;
                system.setAlarm(1, hours, minutes);
                updateTimeText();
            }
            
        } else if (this.displayed.equals("alarm2")) {
            if (this.editing.equals("minutes")) {
                int hours = system.getAlarm2().getHours();
                int minutes = (system.getAlarm2().getMinutes() - 1) % 60;
                if (minutes < 0)
                    minutes += 60;
                system.setAlarm(1, hours, minutes);
                updateTimeText();
            } else if (this.editing.equals("hours")) {
                int hours = (system.getAlarm2().getHours() - 1) % 24;
                int minutes = system.getAlarm2().getMinutes();
                if (hours < 0)
                    hours += 24;
                system.setAlarm(1, hours, minutes);
                updateTimeText();
            }
        }
    }
    
    @FXML
    private void onViewAlarmClicked(ActionEvent event) {
        if (this.displayed.equals("time")) {
            this.displayed = "alarm1";
            this.viewAlarmButton.setText("View Alarm2");
        } else if (this.displayed.equals("alarm1")) {
            this.displayed = "alarm2";
            this.viewAlarmButton.setText("View Time");
        } else if (this.displayed.equals("alarm2")) {
            this.displayed = "time";
            this.viewAlarmButton.setText("View Alarm1");
        }
        
        updateEditText();
        updateTimeText();
    }
    
    @FXML
    private void onDoneClicked(ActionEvent event) {
        this.displayed = "time";
        this.editing = "none";
        this.viewAlarmButton.setText("View Alarm1");
        this.viewAlarmButton.setDisable(false);
        updateEditText();
        updateTimeText();
    }
    
    @FXML
    private void onAMFMclicked(ActionEvent event) {
        system.getRadio().switchType();
        if(system.getRadio().getRadioType().equals("AM")){
            this.station.setText(Integer.toString(system.getRadio().getAmStation()));
            this.stopRadio();
            this.playRadio();
        }
        if(system.getRadio().getRadioType().equals("FM")){
            this.station.setText(Double.toString(system.getRadio().getFmStation()));
            this.stopRadio();
            this.playRadio();
        }
    }
    
    @FXML
    private void onRadioOnOffclicked(ActionEvent event) {
        if (this.radioOnOffButton.isSelected()) {
            this.AMFMButton.setDisable(false);
            this.downStation.setDisable(false);
            this.upStation.setDisable(false);
            this.radioWasOn = true;
            this.playRadio();
        } else {
            this.AMFMButton.setDisable(true);
            this.downStation.setDisable(true);
            this.upStation.setDisable(true);
            this.radioWasOn = false;
            this.stopRadio();
        }
    }
    
    private void playRadio() {
        String type = this.system.getRadio().getRadioType();
        if (type.equals("FM")) {
            double station = this.system.getRadio().getFmStation();
            URL file = FXMLDocumentController.class.getClassLoader().getResource("radio/radio_active.mp3");
            
            if (station == 100.1)
                file = FXMLDocumentController.class.getClassLoader().getResource("radio/mr_blue_sky.mp3");
            else if (station == 99.3)
                file = FXMLDocumentController.class.getClassLoader().getResource("radio/mean_mr_mustard.mp3");
            
            final Media media = new Media(file.toString());
            this.radioPlayer = new MediaPlayer(media);
            this.radioPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            this.radioPlayer.play();
            
        } else {
            int station = this.system.getRadio().getAmStation();
            URL file = FXMLDocumentController.class.getClassLoader().getResource("radio/radio_active.mp3");
            
            if (station == 1000)
                file = FXMLDocumentController.class.getClassLoader().getResource("radio/mean_mr_mustard.mp3");
            else if (station == 1150)
                file = FXMLDocumentController.class.getClassLoader().getResource("radio/mr_blue_sky.mp3");        
            
            final Media media = new Media(file.toString());
            this.radioPlayer = new MediaPlayer(media);
            this.radioPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            this.radioPlayer.play();
        }
    }
    
    private void stopRadio() {
        if (this.radioPlayer != null)
            this.radioPlayer.stop();
    }
    
    private void pauseRadio() {
        if (this.radioPlayer != null)
            this.radioPlayer.pause();
    }
    
    private void muteRadio() {
        if (this.radioPlayer != null)
            this.radioPlayer.setMute(true);
    }
    
    private void unmuteRadio() {
        if (this.radioPlayer != null)
            this.radioPlayer.setMute(false);
    }
    
    @FXML
    private void incStationClick(ActionEvent event){
        system.getRadio().incrementStation();
        if(system.getRadio().getRadioType().equals("AM")){
            this.station.setText(Integer.toString(system.getRadio().getAmStation()));
            this.stopRadio();
            this.playRadio();
        }
        if(system.getRadio().getRadioType().equals("FM")){
            this.station.setText(Double.toString(system.getRadio().getFmStation()));
            this.stopRadio();
            this.playRadio();
        }
    }
    
        @FXML
    private void decStationClick(ActionEvent event){
        system.getRadio().decrementStation();
        if(system.getRadio().getRadioType().equals("AM")){
            this.station.setText(Integer.toString(system.getRadio().getAmStation()));
            this.stopRadio();
            this.playRadio();
        }
        if(system.getRadio().getRadioType().equals("FM")){
            this.station.setText(Double.toString(system.getRadio().getFmStation()));
            this.stopRadio();
            this.playRadio();
        }
    }
}
