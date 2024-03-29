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
import model.entrenador.Entrenador;
import model.movimiento.Movimiento;
import model.movimiento.MovimientoNull;
import model.pokemon.Pokemon;
import model.utils.ModelUtils;

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
		ejecutarTurno(0);
	}
	
	@FXML
	private void ejectuarMv2(ActionEvent event) {
		ejecutarTurno(1);
	}
	
	@FXML
	private void ejectuarMv3(ActionEvent event) {
		ejecutarTurno(2);
	}
	
	@FXML
	private void ejectuarMv4(ActionEvent event) {
		ejecutarTurno(3);
	}
	
	private Movimiento ejecuteMove(Pokemon atacante, Pokemon rival, int numMove) {
  		msgs = AppPokemon.getINSTANCE().ejecutarMovimiento(atacante, rival, atacante.getMovimientos().get(numMove) , "");
  		txtArea.setText(msgs.get(0));
  		if(msgs.size()==1) return new MovimientoNull();
  		if(atacante.equals(pokemonsJugador[numPokemonJugador])) {
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
  		}else {
  			if(msgs.size()==2) {
  				pokemonsRival[numPokemonRival]=updatePokemonStats(pokemonsRival[numPokemonRival], msgs.get(1));
  				co.setPokemonRivalUpdated(pokemonsRival[numPokemonRival]);
  			}
  			if(msgs.size()==3) {
  				pokemonsRival[numPokemonRival]=updatePokemonStats(pokemonsRival[numPokemonRival], msgs.get(1));
  				co.setPokemonRivalUpdated(pokemonsRival[numPokemonRival]);
  				pokemonsJugador[numPokemonJugador]=updatePokemonStats(pokemonsJugador[numPokemonJugador], msgs.get(2));
  				co.setPokemonJugadorUpdated(pokemonsJugador[numPokemonJugador]);
  			}
  		}
  		return atacante.getMovimientos().get(numMove);
	}
	
	@FXML
	private void retirar(ActionEvent event) {
		finalizarCombate(co.getRival());
	}
	
	private void finalizarCombate(Entrenador ganador) {
		mediaPlayer.stop();
		txtArea.setText("Terminado combate");
		co.terminarCombate(ganador);
		AppPokemon.getINSTANCE().finalizarCombate(co);
		ControladorGUI.setScene("appPokemon");
	}
	
	private void ejecutarTurno(int numMv) {
		int numMvRival = ModelUtils.generarNumRandom(0,3);
		if(pokemonsJugador[numPokemonJugador].getVelocidad()>pokemonsRival[numPokemonRival].getVelocidad()) {
			ejecuteMove(pokemonsJugador[numPokemonJugador], pokemonsRival[numPokemonRival], numMv);
			checkIfDebilitado(co.getRival());
			ejecuteMove(pokemonsRival[numPokemonRival], pokemonsJugador[numPokemonJugador], numMvRival);
			checkIfDebilitado(co.getJugador());
		}else {
			ejecuteMove(pokemonsRival[numPokemonRival], pokemonsJugador[numPokemonJugador], numMvRival);
			checkIfDebilitado(co.getJugador());
			ejecuteMove(pokemonsJugador[numPokemonJugador], pokemonsRival[numPokemonRival], numMv);
			checkIfDebilitado(co.getRival());
		}
		co.siguienteTurno(pokemonsJugador[numPokemonJugador].getMovimientos().get(numMv), pokemonsRival[numPokemonRival].getMovimientos().get(numMvRival));
	}
	
	public void checkIfDebilitado(@SuppressWarnings("exports") Entrenador entrenador) {
		if(!co.getGanador().equals(co.getJugador()) && !co.getGanador().equals(co.getRival())) {
			if(pokemonsJugador[numPokemonJugador].getVitalidad()<=0) {
				System.out.println(pokemonsJugador[numPokemonJugador].getNombre() + " DEBILITADO");
				co.debilitarPokemon(co.getJugador(), pokemonsJugador[numPokemonJugador]);
				if(co.getPokemonsKOJugador().size()>=4) finalizarCombate(co.getRival());
				else{
					numPokemonJugador++;
					setPokemonJugador();
				}
			}
			if(pokemonsRival[numPokemonRival].getVitalidad()<=0) {
				System.out.println(pokemonsRival[numPokemonRival].getNombre() + " DEBILITADO");
				co.debilitarPokemon(co.getRival(), pokemonsRival[numPokemonRival]);
				if(co.getPokemonsKORival().size()>=4) finalizarCombate(co.getJugador());
				else {
					numPokemonRival++;
					setPokemonRival();
				}
			}
		}
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
	
	@SuppressWarnings("exports")
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
		Image pk = new Image(pokemonsJugador[numPokemonJugador].getSprite());
		imgPk1.setImage(pk);
		setMovimientos();	
	}
	
	private void setPokemonRival() {
		Image pk = new Image(pokemonsRival[numPokemonRival].getSprite());
		imgPk2.setImage(pk);
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
		
		txtArea.setText(co.getRival().getNombre() +" te desafia!");
		numPokemonJugador=0;
		numPokemonRival=0;
		pokemonsJugador=co.getJugador().getPokemons().toArray(pokemonsJugador);
		pokemonsRival=co.getRival().getPokemons().toArray(pokemonsRival);
		setPokemonJugador();
		setPokemonRival();
		co.empezarCombate();
	}
}
