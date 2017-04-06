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

/**
 *
 * @author ty
 */
public class FXMLDocumentController implements Initializable {
        
    @FXML private ToggleButton onOffButton;
    @FXML private Circle powerCircle;
    @FXML private Text timeText;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.powerCircle.setFill(Color.LAWNGREEN);
        this.timeText.setText("12:00 PM");
    }
    
    @FXML
    private void onOffClicked(ActionEvent event) {
        if (this.onOffButton.isSelected())
            this.powerCircle.setFill(Color.LAWNGREEN);
        else
            this.powerCircle.setFill(Color.RED);
    }
    
}
