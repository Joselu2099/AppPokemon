package gui;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import controller.AppPokemon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.combate.Combate;
import model.movimiento.Movimiento;

public class CombateController implements Initializable {
	
	@FXML
	private ImageView imgPk1;
	@FXML
	private ImageView imgPk2;
	@FXML
	private TextArea txtArea;
	@FXML
	private Button btnRetirada;
	@FXML
	private Button mv1;
	@FXML
	private Button mv2;
	@FXML
	private Button mv3;
	@FXML
	private Button mv4;
	
	private MediaPlayer mediaPlayer;
	private Combate co;
	private ArrayList<Movimiento> movimientosJugador;
	private ArrayList<Movimiento> movimientosRival;
	private int numPokemonJugador;
	private int numPokemonRival;
	private String msg;
	
	@FXML
	private void ejectuarMv1(ActionEvent event) {
		System.out.println(co.getRival().getPokemons().get(numPokemonRival) + "\n " + movimientosJugador.get(numPokemonJugador));
		AppPokemon.getINSTANCE().ejecutarMovimiento(co.getJugador().getPokemons().get(numPokemonJugador), co.getRival().getPokemons().get(numPokemonRival), movimientosJugador.get(0) , msg);
		txtArea.setText(msg);
		System.out.println(co.getRival().getPokemons().get(numPokemonRival));
	}
	
	@FXML
	private void ejectuarMv2(ActionEvent event) {
		
	}
	
	@FXML
	private void ejectuarMv3(ActionEvent event) {
		
	}
	
	@FXML
	private void ejectuarMv4(ActionEvent event) {
		
	}
	
	@FXML
	private void retirar(ActionEvent event) {
		mediaPlayer.stop();
		txtArea.setText("Terminado combate");
		//AppPokemon.getINSTANCE().finalizarCombate();
	}
	
	private void setMovimientos() {
		mv1.setText("Movimiento no aprendido");
		mv2.setText("Movimiento no aprendido");
		mv3.setText("Movimiento no aprendido");
		mv4.setText("Movimiento no aprendido");
		int i=0;
		for(Movimiento mv: movimientosJugador) {
			switch(i) {
				case 0:
					mv1.setText(mv.getNombre());
					break;
				case 1:
					mv2.setText(mv.getNombre());
					break;
				case 2:
					mv3.setText(mv.getNombre());
					break;
				case 3:
					mv4.setText(mv.getNombre());
					break;
			}
			i++;
		}
	}
	
	private void setPokemonJugador(int num) {
		imgPk1.setImage(new Image(AppPokemon.getINSTANCE().getSpritePokemon(co.getJugador(), num)));
		setMovimientos();	
	}
	
	private void setPokemonRival(int num) {
		imgPk2.setImage(new Image(AppPokemon.getINSTANCE().getSpritePokemon(co.getRival(), num)));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String path = getClass().getResource("/audio/combate.mp3").getPath();
		Media media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setVolume(0.3);
		mediaPlayer.play();
		co = AppPokemon.getINSTANCE().crearCombateRandom();
		
		numPokemonJugador=0;
		numPokemonRival=0;
		movimientosJugador=co.getJugador().getPokemons().get(numPokemonJugador).getMovimientos();
		movimientosRival=co.getRival().getPokemons().get(numPokemonJugador).getMovimientos();
		setPokemonJugador(numPokemonJugador);
		setPokemonRival(numPokemonRival);
	}
}
