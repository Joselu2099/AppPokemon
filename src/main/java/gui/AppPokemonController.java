package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class AppPokemonController implements Initializable{

	@FXML
	private MenuItem mnQuit;
	@FXML
	private MenuItem mnSave;
	
	@FXML
    private void exit(ActionEvent event) {
		ControladorGUI.setStageSize(640, 420);
        ControladorGUI.setRoot("login");
	}
	
	@FXML
	private void save(ActionEvent event) {
		//TODO
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
