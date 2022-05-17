package gui;

import java.net.URL;
import java.util.ResourceBundle;
import controller.AppPokemon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController implements Initializable{
	
	@FXML
	private Label lblWarning;
	@FXML
	private TextField txtField;
	@FXML
	private Button btnLogin;
	
	
    @FXML
    private void login(ActionEvent event) {
    	if(txtField.getText().length()!=0) {
    		if(txtField.getText().equals("Knekro") || 
    				txtField.getText().equals("Knekro".toLowerCase()) || 
    				txtField.getText().equals("Knekro".toUpperCase()) ||
    				txtField.getText().equals("Red") || 
    				txtField.getText().equals("Red".toLowerCase()) || 
    				txtField.getText().equals("Red".toUpperCase()) || 
    				txtField.getText().equals("Blue") || 
    				txtField.getText().equals("Blue".toLowerCase()) || 
    				txtField.getText().equals("Blue".toUpperCase())) {
    			lblWarning.setText("Ese nombre pertenece a uno de los Altos Mando, prueba otro :)");
    		}else {
    			AppPokemon.getINSTANCE().login(txtField.getText());
        		ControladorGUI.setStageSize(ControladorGUI.APP_WIDTH, ControladorGUI.APP_HEIGHT);
                ControladorGUI.setRoot("appPokemon");
    		}
    	}else {
    		lblWarning.setText("El nombre del entrenador es incorrecto");
    	}
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
