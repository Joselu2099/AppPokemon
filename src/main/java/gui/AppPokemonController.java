package gui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import controller.AppPokemon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
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
	@FXML
	private Button btnCombatir;
	@FXML
	private Label lblEntrenador;
	@FXML
	private Label lblTitNombre;
	@FXML
	private Label lblNombre;
	@FXML
	private Label lblTitPokedollars;
	@FXML
	private Label lblPokedollars;
	@FXML
	private Label lblWarning;
	@FXML
	private Pane pnCaja;
	@FXML
	private Button btnAbrirCaja;
	@FXML
	private Button btnCerrarCaja;
	@FXML
	private GridPane gridPane;
	@FXML
	private MediaPlayer mediaPlayer;
	@FXML
	private TextField selectorPoke;
	@FXML
	private TextField selectorCaja;
	@FXML
	private Button btnCambiar;
	
	
	@FXML
    private void exit(ActionEvent event) {
        ControladorGUI.setScene("login");
        mediaPlayer.stop();
	}
	
	@FXML
	private void save(ActionEvent event) {
		AppPokemon.getINSTANCE().save();
	}
	
	@FXML
	private void capturar(ActionEvent event) {
		ControladorGUI.setScene("capture");
		mediaPlayer.stop();
	}
	
	@FXML
	private void combatir(ActionEvent event) {
		if(AppPokemon.getINSTANCE().getCurrentEntrenador().getPokemons().size()<4) 
			lblWarning.setText("Para combatir necesitas tener 4 pokemons en tu equipo");
		else {
			ControladorGUI.setScene("combate");
			mediaPlayer.stop();
		}
	}
	
	@FXML
	private void abrirCaja(ActionEvent event) {
		lblEntrenador.setVisible(false);
		lblTitNombre.setVisible(false);
		lblNombre.setVisible(false);
		lblTitPokedollars.setVisible(false);
		lblPokedollars.setVisible(false);
		pnCaja.setVisible(true);
		int columnIndex=0;
		int rowIndex=0;
		for(Pokemon pk: AppPokemon.getINSTANCE().getCurrentEntrenador().getCajaPokemon()) {
			ImageView imgPk = new ImageView();
			imgPk.setImage(new Image(pk.getSprite()));
			gridPane.add(imgPk, columnIndex, rowIndex);
			columnIndex++;
			if(columnIndex>3) {
				columnIndex=0;
				rowIndex++;
			}
		}
	}
	
	@FXML
	private void cambiar(ActionEvent event) {
		if(!selectorPoke.getText().isBlank() 
				&& !selectorCaja.getText().isBlank() 
				&& AppPokemon.getINSTANCE().getCurrentEntrenador().getPokemonEquipo(selectorPoke.getText())!=null 
				&& AppPokemon.getINSTANCE().getCurrentEntrenador().getPokemonEquipo(selectorCaja.getText())!=null) {
			AppPokemon.getINSTANCE().getCurrentEntrenador().moverEquipoToCaja(AppPokemon.getINSTANCE().getCurrentEntrenador().getPokemonEquipo(selectorPoke.getText()));
			AppPokemon.getINSTANCE().getCurrentEntrenador().moverCajaToEquipo(AppPokemon.getINSTANCE().getCurrentEntrenador().getPokemonEquipo(selectorCaja.getText()));
			
		}
	}
	
	@FXML
	private void cerrarCaja(ActionEvent event) {
		pnCaja.setVisible(false);
		lblEntrenador.setVisible(true);
		lblTitNombre.setVisible(true);
		lblNombre.setVisible(true);
		lblTitPokedollars.setVisible(true);
		lblPokedollars.setVisible(true);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String path = getClass().getResource("/audio/appPokemon.mp3").getPath();
		Media media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setVolume(0.3);
		mediaPlayer.play();
		lblNombre.setText(AppPokemon.getINSTANCE().getCurrentEntrenador().getNombre());
		lblPokedollars.setText(String.valueOf(AppPokemon.getINSTANCE().getCurrentEntrenador().getPokedollars()));
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
