package gui;

import java.net.URL;
import java.util.ResourceBundle;

import controller.AppPokemon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class CombateController implements Initializable {
	
	@FXML
	private ImageView imgPk1;
	
	@FXML
	private ImageView imgPk2;
	
	@FXML
	private TextArea txtArea;
	
	@FXML
	private Button btnRetirada;
	
	private void retirar (ActionEvent event) {
		AppPokemon.getINSTANCE().finalizarCombate();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	

}
