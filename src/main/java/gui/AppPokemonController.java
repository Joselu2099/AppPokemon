package gui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import controller.AppPokemon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
	private Button btnCapturar;
	
	private MediaPlayer mediaPlayer;
	
	@FXML
    private void exit(ActionEvent event) {
        ControladorGUI.setScene("login");
        mediaPlayer.stop();
	}
	
	@FXML
	private void save(ActionEvent event) {
		//TODO
	}
	
	@FXML
	private void capturar(ActionEvent event) {
		ControladorGUI.setScene("capture");
		mediaPlayer.stop();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String path = getClass().getResource("/audio/appPokemon.mp3").getPath();
		Media media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setVolume(0.3);
		mediaPlayer.play();
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
