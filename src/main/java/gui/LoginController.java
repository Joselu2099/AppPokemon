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
    		AppPokemon.getINSTANCE().login(txtField.getText());
    		ControladorGUI.setStageSize(1280, 720);
            ControladorGUI.setRoot("appPokemon");
    	}else {
    		lblWarning.setText("El nombre del entrenador es incorrecto");
    	}
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
