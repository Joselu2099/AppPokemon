package gui;

import java.net.URL;
import java.util.ResourceBundle;

import controller.AppPokemon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.pokemon.*;
import model.utils.ModelUtils;

public class CaptureController implements Initializable{

	@FXML
	private ImageView pk;
	@FXML
	private Pane pnMote;
	@FXML
	private Label lblWarning;
	@FXML
	private Label lblMote;
	@FXML
	private TextField txtMote;
	
	
	private Pokemon poke;
	
	@FXML
	private void capturar() {
        if(ModelUtils.generarNumRandom(1, 3)>1) {
        	System.out.println("CAPTURADO");
			lblWarning.setText(" ");
			pnMote.setVisible(true);
		}else lblWarning.setText("No has conseguido capturarlo, vuelve a intentarlo :(");
	}
	
	@FXML
	private void ponerMote(ActionEvent event) {
		if(!txtMote.getText().isEmpty()) {
			AppPokemon.getINSTANCE().capturarPokemon(poke,txtMote.getText());
		}else AppPokemon.getINSTANCE().capturarPokemon(poke);
		ControladorGUI.setScene("appPokemon");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		poke = PokemonRepository.getINSTANCE().generarPokemonRandom(1);
		pk.setImage(new Image(poke.getSprite()));
	}
	
}
