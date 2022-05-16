package gui;

import java.net.URL;
import java.util.ResourceBundle;
import controller.AppPokemon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.pokemon.Pokemon;

public class AppPokemonController implements Initializable{

	@FXML
	private MenuItem mnQuit;
	@FXML
	private MenuItem mnSave;
	@FXML
	private ImageView pk1;
	@FXML
	private ImageView pk2;
	@FXML
	private ImageView pk3;
	@FXML
	private ImageView pk4;
	
	@FXML
    private void exit(ActionEvent event) {
        ControladorGUI.setScene("login");
	}
	
	@FXML
	private void save(ActionEvent event) {
		//TODO
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		int cont=0;
		for(Pokemon pk: AppPokemon.getINSTANCE().getCurrentEntrenador().getPokemons()) {
			switch(cont) {
				case 0:
					pk1.setImage(new Image(pk.getSprite()));
					break;
				case 1:
					pk2.setImage(new Image(pk.getSprite()));
					break;
				case 2:
					pk3.setImage(new Image(pk.getSprite()));
					break;
				case 3:
					pk4.setImage(new Image(pk.getSprite()));
					break;
			}
			cont++;
		}
	}
}
