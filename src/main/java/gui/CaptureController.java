package gui;

import java.io.File;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
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
	
	private MediaPlayer mediaPlayer;
	private Pokemon poke;
	
	@FXML
	private void capturar() {
        if(ModelUtils.generarNumRandom(1, 3)>1) {
        	lblWarning.setText(" ");
        	mediaPlayer.stop();
    		String path = getClass().getResource("/audio/victoria.mp3").getPath();
    		Media media = new Media(new File(path).toURI().toString());
    		mediaPlayer = new MediaPlayer(media);
    		mediaPlayer.setVolume(0.3);
    		mediaPlayer.play();
			pnMote.setVisible(true);
		}else lblWarning.setText("No has conseguido capturarlo, vuelve a intentarlo :(");
	}
	
	@FXML
	private void ponerMote(ActionEvent event) {
		lblMote.setTextFill(Color.web("#000000"));
		if(!txtMote.getText().isEmpty()) {
			if(AppPokemon.getINSTANCE().isMoteCogido(txtMote.getText()+"_"+AppPokemon.getINSTANCE().getCurrentEntrenador().getNombre())) {
				lblMote.setText("Ese mote ya esta elegido, elige otro");
				lblMote.setTextFill(Color.web("#FF0000"));
			}else{
				AppPokemon.getINSTANCE().capturarPokemon(poke,txtMote.getText());
				ControladorGUI.setScene("appPokemon");
				mediaPlayer.stop();
			}
		}else{
			
			if(AppPokemon.getINSTANCE().isMoteCogido(poke.getMote())) {
				lblMote.setText("Debes ponerle un mote para registrar al pokemon");
				lblMote.setTextFill(Color.web("#FF0000"));
				ControladorGUI.setScene("appPokemon");
				mediaPlayer.stop();
			}else AppPokemon.getINSTANCE().capturarPokemon(poke);
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String path = getClass().getResource("/audio/capturar.mp3").getPath();
		Media media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setVolume(0.3);
		mediaPlayer.play();
		poke = PokemonRepository.getINSTANCE().generarPokemonRandom(1);
		pk.setImage(new Image(poke.getSprite()));
	}
	
}
