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
import com.csci360.alarmclock.Time;
import java.util.Timer;
import java.util.TimerTask;
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
    
    private Controller system = new Controller();
    private boolean isOn = true;
    private int editTimeClick = 0;
    private int viewAlarmClick = 0;
    private int sounding = 0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.powerCircle.setFill(Color.LAWNGREEN);
        this.timeText.setText(system.getClock().getTimeString());
        this.editText.setText("");
        this.station.setText(Double.toString(system.getRadio().getFmStation()));
        
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
    
    private void playSound(String sound) {
        
        URL file = FXMLDocumentController.class.getClassLoader().getResource(sound);
        final Media media = new Media(file.toString());
        final MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    
    }
    
    @FXML
    private void updateTimeText() {
        if (!isOn) {
            this.timeText.setText("");
        } else if (viewAlarmClick == 1) {
            this.timeText.setText(system.getAlarm1().getAlarmTime());
        } else if (viewAlarmClick == 2) {
            this.timeText.setText(system.getAlarm2().getAlarmTime());
        } else {
            this.timeText.setText(system.getClock().getTimeString());
        }
    }
    
    @FXML
    private void updateEditText() {
        if (editTimeClick == 1 && viewAlarmClick == 0) {
            this.editText.setText("Editing Hours");
        } else if (editTimeClick == 2 && viewAlarmClick == 0) {
            this.editText.setText("Editing Minutes");
        } else if (editTimeClick == 0 && viewAlarmClick == 0) {
            this.editText.setText("Viewing Time");
        } else if (editTimeClick == 1 && viewAlarmClick == 1) {
            this.editText.setText("Editing Alarm1 Hours");
        } else if (editTimeClick == 2 && viewAlarmClick == 1) {
            this.editText.setText("Editing Alarm1 Minutes");
        } else if (editTimeClick == 0 && viewAlarmClick == 1) {
            this.editText.setText("Viewing Alarm1");
        } else if (editTimeClick == 1 && viewAlarmClick == 2) {
            this.editText.setText("Editing Alarm2 Hours");
        } else if (editTimeClick == 2 && viewAlarmClick == 2) {
            this.editText.setText("Editing Alarm2 Minutes");
        } else if (editTimeClick == 0 && viewAlarmClick == 2) {
            this.editText.setText("Viewing Alarm2");
        }
    }
    
    @FXML
    private void updateSounding() {
        if(system.alarm1Sounding()) {
            this.editText.setText("WAKE UP");
            playSound("batman_theme_x.wav");
        }
        else if (system.alarm2Sounding()) {
            this.editText.setText("WAKE UP");
            playSound("batman_theme_x.wav");
        }
    }
    
    @FXML
    private void snoozeClicked(ActionEvent event) {
        system.snooze();
        updateEditText();
        
    }
    
    @FXML
    private void stopClicked(ActionEvent event) {
        system.getAlarm1().stopAlarm();
        system.getAlarm2().stopAlarm();
        updateEditText();
    }
    
    
    
    @FXML
    private void onOffClicked(ActionEvent event) {
        isOn = !isOn;
        
        if(isOn) {
            this.timeText.setText(system.getClock().getTimeString()); 
        } else {
            this.timeText.setText("");
        }
        
        if (this.onOffButton.isSelected())
            this.powerCircle.setFill(Color.LAWNGREEN);
        else
            this.powerCircle.setFill(Color.RED);
    }
    
    @FXML
    private void onEditTimeClicked(ActionEvent event) {
        editTimeClick += 1;
        editTimeClick = editTimeClick % 3;
        updateEditText();
    }
    
    @FXML
    private void on1224HRClicked(ActionEvent event) {
        system.switchTimeFormat();
        updateTimeText();
    }
    
    @FXML
    private void onUpClicked(ActionEvent event) {
        if (editTimeClick == 1 && viewAlarmClick == 0) {
            int hours = (system.getClock().getTime().getHours() + 1) % 24;
            int minutes = system.getClock().getTime().getMinutes();
            system.setTime(hours, minutes);
            updateTimeText();
        } else if (editTimeClick == 2 && viewAlarmClick == 0) {
            int hours = system.getClock().getTime().getHours();
            int minutes = (system.getClock().getTime().getMinutes() + 1) % 60;
            system.setTime(hours, minutes);
            updateTimeText();
        } else if (editTimeClick == 1 && viewAlarmClick == 1) {
            int hours = (system.getAlarm1().getHours() + 1) % 24;
            int minutes = system.getAlarm1().getMinutes();
            system.setAlarm(1, hours, minutes);
            updateTimeText();
        } else if (editTimeClick == 2 && viewAlarmClick == 1) {
            int hours = system.getAlarm1().getHours();
            int minutes = (system.getAlarm1().getMinutes() + 1) % 60;
            system.setAlarm(1, hours, minutes);
            updateTimeText();
        } else if (editTimeClick == 1 && viewAlarmClick == 2) {
            int hours = (system.getAlarm2().getHours() + 1) % 24;
            int minutes = system.getAlarm2().getMinutes();
            system.setAlarm(1, hours, minutes);
            updateTimeText();
        } else if (editTimeClick == 2 && viewAlarmClick == 2) {
            int hours = system.getAlarm2().getHours();
            int minutes = (system.getAlarm2().getMinutes() + 1) % 60;
            system.setAlarm(1, hours, minutes);
            updateTimeText();
        }
    }
    
    @FXML
    private void onDownClicked(ActionEvent event) {
        if (editTimeClick == 1 && viewAlarmClick == 0) {
            int hours = system.getClock().getTime().getHours() - 1;
            if (hours < 0) {
                hours += 24;
            }
            int minutes = system.getClock().getTime().getMinutes();
            system.setTime(hours, minutes);
            updateTimeText();
        } else if (editTimeClick == 2 && viewAlarmClick == 0) {
            int hours = system.getClock().getTime().getHours();
            int minutes = system.getClock().getTime().getMinutes() - 1;
            if (minutes < 0) {
                minutes += 60;
            }
            system.setTime(hours, minutes);
            updateTimeText();
        } else if (editTimeClick == 1 && viewAlarmClick == 1) {
            int hours = (system.getAlarm1().getHours() - 1) % 24;
            int minutes = system.getAlarm1().getMinutes();
            if (hours < 0) {
                hours += 24;
            }
            system.setAlarm(1, hours, minutes);
            updateTimeText();
        } else if (editTimeClick == 2 && viewAlarmClick == 1) {
            int hours = system.getAlarm1().getHours();
            int minutes = (system.getAlarm1().getMinutes() - 1) % 60;
            if (minutes < 0) {
                minutes += 60;
            }
            system.setAlarm(1, hours, minutes);
            updateTimeText();
        } else if (editTimeClick == 1 && viewAlarmClick == 2) {
            int hours = (system.getAlarm2().getHours() - 1) % 24;
            int minutes = system.getAlarm2().getMinutes();
            if (hours < 0) {
                hours += 24;
            }
            system.setAlarm(1, hours, minutes);
            updateTimeText();
        } else if (editTimeClick == 2 && viewAlarmClick == 2) {
            int hours = system.getAlarm2().getHours();
            int minutes = (system.getAlarm2().getMinutes() - 1) % 60;
            if (minutes < 0) {
                minutes += 60;
            }
            system.setAlarm(1, hours, minutes);
            updateTimeText();
        }
    }
    
    @FXML
    private void onViewAlarmClicked(ActionEvent event) {
        viewAlarmClick += 1;
        viewAlarmClick = viewAlarmClick % 3;
        updateEditText();
        updateTimeText();
    }
    
    @FXML
    private void onDoneClicked(ActionEvent event) {
        viewAlarmClick = 0;
        editTimeClick = 0;
        updateEditText();
        updateTimeText();
    }
    
    @FXML
    private void onAMFMclicked(ActionEvent event) {
        system.getRadio().switchType();
        if(system.getRadio().getRadioType() == "AM"){
            this.station.setText(Integer.toString(system.getRadio().getAmStation()));
        }
        if(system.getRadio().getRadioType() == "FM"){
            this.station.setText(Double.toString(system.getRadio().getFmStation()));
        }
    }
    
    @FXML
    private void incStationClick(ActionEvent event){
        system.getRadio().incrementStation();
        if(system.getRadio().getRadioType() == "AM"){
            this.station.setText(Integer.toString(system.getRadio().getAmStation()));
        }
        if(system.getRadio().getRadioType() == "FM"){
            this.station.setText(Double.toString(system.getRadio().getFmStation()));
        }
    }
    
        @FXML
    private void decStationClick(ActionEvent event){
        system.getRadio().decrementStation();
        if(system.getRadio().getRadioType() == "AM"){
            this.station.setText(Integer.toString(system.getRadio().getAmStation()));
        }
        if(system.getRadio().getRadioType() == "FM"){
            this.station.setText(Double.toString(system.getRadio().getFmStation()));
        }
    }
}
