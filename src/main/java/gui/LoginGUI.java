package gui;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import controller.AppPokemon;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class LoginGUI{
	
	@FXML
	private Label lblText;
	@FXML
	private TextField txtField;
	@FXML
	private Button btnLogin;
	
	
    @FXML
    private void login(ActionEvent event) {
    	AppPokemon.getINSTANCE().login(txtField.getText());
        ControladorGUI.setRoot("appPokemon");
    }
}
