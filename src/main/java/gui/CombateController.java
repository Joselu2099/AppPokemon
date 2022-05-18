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
import model.pokemon.Pokemon;

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
	private Pokemon[] pokemonsJugador;
	private Pokemon[] pokemonsRival;
	private int numPokemonJugador;
	private int numPokemonRival;
	ArrayList<String> msgs;
	
	@FXML
	private void ejectuarMv1(ActionEvent event) {
		ejecuteMove(0);
	}
	
	@FXML
	private void ejectuarMv2(ActionEvent event) {
		ejecuteMove(1);
	}
	
	@FXML
	private void ejectuarMv3(ActionEvent event) {
		ejecuteMove(2);
	}
	
	@FXML
	private void ejectuarMv4(ActionEvent event) {
		ejecuteMove(3);
	}
	
	private void ejecuteMove(int numMove) {
  		msgs = AppPokemon.getINSTANCE().ejecutarMovimiento(pokemonsJugador[numPokemonJugador], pokemonsRival[numPokemonRival], pokemonsJugador[numPokemonJugador].getMovimientos().get(numMove) , "");
		System.out.println(msgs);
  		txtArea.setText(msgs.get(0));
		if(msgs.size()==2) {
			pokemonsJugador[numPokemonJugador]=updatePokemonStats(pokemonsJugador[numPokemonJugador], msgs.get(1));
			co.setPokemonJugadorUpdated(pokemonsJugador[numPokemonJugador]);
		}
		if(msgs.size()==3) {
			pokemonsJugador[numPokemonJugador]=updatePokemonStats(pokemonsJugador[numPokemonJugador], msgs.get(1));
			co.setPokemonJugadorUpdated(pokemonsJugador[numPokemonJugador]);
			pokemonsRival[numPokemonRival]=updatePokemonStats(pokemonsRival[numPokemonRival], msgs.get(2));
			co.setPokemonRivalUpdated(pokemonsRival[numPokemonRival]);
		}
		if(pokemonsJugador[numPokemonJugador].getVitalidad()<=0) {
			numPokemonJugador++;
			setPokemonJugador();
		}
		if(pokemonsRival[numPokemonRival].getVitalidad()<=0) {
			numPokemonRival++;
			setPokemonRival();
		}
		System.out.println("Pokes jugador: " +pokemonsJugador[numPokemonJugador]);
		System.out.println("Pokes rival: " +pokemonsRival[numPokemonRival]);
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
		mv1.setDisable(true);
		mv2.setDisable(true);
		mv3.setDisable(true);
		mv4.setDisable(true);
		int i=0;
		for(Movimiento mv: pokemonsJugador[numPokemonJugador].getMovimientos()) {
			switch(i) {
				case 0:
					mv1.setText(mv.getNombre());
					mv1.setDisable(false);
					break;
				case 1:
					mv2.setText(mv.getNombre());
					mv2.setDisable(false);
					break;
				case 2:
					mv3.setText(mv.getNombre());
					mv3.setDisable(false);
					break;
				case 3:
					mv4.setText(mv.getNombre());
					mv4.setDisable(false);
					break;
			}
			i++;
		}
	}
	
	public Pokemon updatePokemonStats(Pokemon poke, String msg) {
		ArrayList<String> atributos = (ArrayList<String>)UtilsGUI.splitString(msg);
		poke.setVitalidad(Integer.parseInt(atributos.get(1)));
		poke.setAtaque(Integer.parseInt(atributos.get(2)));
		poke.setDefensa(Integer.parseInt(atributos.get(3)));
		poke.setAtaqueEspecial(Integer.parseInt(atributos.get(4)));
		poke.setDefensaEspecial(Integer.parseInt(atributos.get(5)));
		poke.setVelocidad(Integer.parseInt(atributos.get(6)));
		poke.setEstamina(Integer.parseInt(atributos.get(7)));
		poke.setEstado(UtilsGUI.stringToEstado(atributos.get(8)));
		return poke;
	}
	
	private void setPokemonJugador() {
		imgPk1.setImage(new Image(pokemonsJugador[numPokemonJugador].getSprite()));
		setMovimientos();	
	}
	
	private void setPokemonRival() {
		imgPk2.setImage(new Image(pokemonsRival[numPokemonJugador].getSprite()));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pokemonsJugador=new Pokemon[4];
		pokemonsRival=new Pokemon[4];
		msgs=new ArrayList<String>();
		String path = getClass().getResource("/audio/combate.mp3").getPath();
		Media media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setVolume(0.3);
		mediaPlayer.play();
		co = AppPokemon.getINSTANCE().crearCombateRandom();
		
		numPokemonJugador=0;
		numPokemonRival=0;
		pokemonsJugador=co.getJugador().getPokemons().toArray(pokemonsJugador);
		pokemonsRival=co.getRival().getPokemons().toArray(pokemonsRival);
		setPokemonJugador();
		setPokemonRival();
	}
}
