package gui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.entrenador.EntrenadorRepository;
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
	
	private MediaPlayer mediaPlayer;
	
    @FXML
    private void login(ActionEvent event) {
    	if(txtField.getText().length()!=0) {
    		if(EntrenadorRepository.getINSTANCE().existAltoMando(txtField.getText())) {
    			lblWarning.setText("Ese nombre pertenece a uno de los Altos Mando, prueba otro :)");
    		}else {
    			if(AppPokemon.getINSTANCE().isEntrenadorRegistrado(txtField.getText())) {
    				if(AppPokemon.getINSTANCE().login(txtField.getText()))
        				ControladorGUI.setScene("appPokemon");
    			}else {
    				if(AppPokemon.getINSTANCE().registrarEntrenador(txtField.getText()))
        				ControladorGUI.setScene("pokemonChooser");
    			}
    		}
    	}else lblWarning.setText("El nombre del entrenador es incorrecto");
    	mediaPlayer.stop();
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String path = getClass().getResource("/audio/login.mp3").getPath();
		Media media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setVolume(0.3);
		mediaPlayer.play();
	}
}
