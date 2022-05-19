package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import org.apache.commons.io.FilenameUtils;
import dao.DAOFactory;
import model.combate.*;
import model.entrenador.*;
import model.movimiento.*;
import model.pokemon.*;
import model.utils.ModelUtils;

public class AppPokemon {
    private static AppPokemon INSTANCE;
    private Entrenador currentEntrenador;
    private Combate currentCombate;

    private AppPokemon() {
        this.currentEntrenador = new Entrenador();
        this.currentCombate = new Combate();
        EntrenadorRepository.getINSTANCE();
        PokemonRepository.getINSTANCE();
        MovimientosRepository.getINSTANCE();
    }

    public static AppPokemon getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new AppPokemon();
        return INSTANCE;
    }
    
    public void closeConnections() {
    	DAOFactory.getINSTANCE().cerrarStatment();
        DAOFactory.getINSTANCE().cerrarConexion();
    }

    public Entrenador getCurrentEntrenador() {
		return currentEntrenador;
	}
    
    public Combate getCurrentCombate() {
		return currentCombate;
	}
    
    public boolean isEntrenadorRegistrado(String nombre) {
    	return (EntrenadorRepository.getINSTANCE().getEntrenador(nombre)!=null || EntrenadorRepository.getINSTANCE().existAltoMando(nombre));
    }
    
    public boolean login(String nombre){
    	if(isEntrenadorRegistrado(nombre)) {
    		this.currentEntrenador = EntrenadorRepository.getINSTANCE().getEntrenador(nombre);
    		return true;
    	}
    	return false;
    }

    public boolean registrarEntrenador(String nombre){
    	if(isEntrenadorRegistrado(nombre)) return false;
    	this.currentEntrenador = new Entrenador(nombre);
    	this.currentEntrenador = EntrenadorRepository.getINSTANCE().addEntrenador(currentEntrenador);
    	if(this.currentEntrenador==null) return false;
    	return true;
    }

    public void escogerPokemon(Pokemon pokemon) {
    	this.currentEntrenador.addPokemon(pokemon);
    }
    
    public void capturarPokemon(Pokemon pokemon) {
        this.currentEntrenador.capturar(pokemon);
    }

    public void capturarPokemon(Pokemon pokemon, String mote) {
        pokemon.setMote(mote);
        capturarPokemon(pokemon);
    }

    public Combate crearCombateRandom(){
    	this.currentCombate = new Combate(currentEntrenador, 
    			EntrenadorRepository.getINSTANCE().generarEntrenadorRandom(ModelUtils.generarNumRandom(currentEntrenador.nivelMinimoEquipo(), 
    																									currentEntrenador.nivelMaximoEquipo())));
    	return currentCombate;
    }

	public ArrayList<Movimiento> getMovimientosPokemon(int numPk){
		return currentEntrenador.getPokemons().get(numPk).getMovimientos();
	}
    
    public void empezarCombate(){
        this.currentCombate.empezarCombate();
        //TODO
    }

    public ArrayList<String> ejecutarMovimiento(Pokemon atacante, Pokemon rival, Movimiento mv, String msg){
        if (mv.getClass().getSimpleName().equals(MovimientoAtaque.class.getSimpleName())) {
            MovimientoAtaque mvA = (MovimientoAtaque) mv;
            return atacante.atacar(rival, mvA, msg);
        }
        if (mv.getClass().getSimpleName().equals(MovimientoEstado.class.getSimpleName())) {
            MovimientoEstado mvE = (MovimientoEstado) mv;
            return rival.aplicarEstado(atacante, mvE, msg);
        }
        if (mv.getClass().getSimpleName().equals(MovimientoMejora.class.getSimpleName())) {
            MovimientoMejora mvM = (MovimientoMejora) mv;
            return atacante.aplicarMejora(mvM, msg);   
        }
        return new ArrayList<String>();
    }

    public void debilitarPokemon(Combate co, Entrenador entrenadorKO, Pokemon pokemonKO, Pokemon pokemonRival){
        co.debilitarPokemon(entrenadorKO, pokemonKO);
        pokemonRival.aumentarExperiencia((int)(pokemonRival.getNivel() + pokemonKO.getNivel()*10) / 4);
    }

    public void finalizarCombate(Combate co, Entrenador ganador){
    	currentCombate=co;
        currentCombate.terminarCombate(ganador);
        this.currentEntrenador.addCombate(currentCombate);
        //TODO
        //EntrenadorRepository.getINSTANCE().updateEntrenador(currentEntrenador);
        exportarDatos();
    }
    
    public void exportarDatos() {
    	String path = "";
    	try {
    		path = getClass().getResource("/logs/combate.log").getPath();
    	}catch(NullPointerException n) {
    		path = getClass().getResource("/logs").getPath();
    	}
    	String newPath = "";
    	for (int i = 0; i < 54; i++) {
			newPath+=path.charAt(i);
		}
    	newPath+="src/main/resources/logs/combate.log";
        File file = new File(newPath);
        if (!file.exists()) {
            try {
				file.createNewFile();
			} catch (IOException e) {
				System.err.println("Fallo al crear fichero");
				e.printStackTrace();
			}
        }
        
    	try {
    		FileWriter fw = new FileWriter(file);
    		BufferedWriter bw = new BufferedWriter(fw);
    		
    		bw.write("\n");
    		bw.append("Combate " + currentCombate.getId() + ":\n");
    		bw.append("Jugador: " + currentCombate.getJugador().getNombre() +"\n");
    		bw.append("Rival: " + currentCombate.getRival().getNombre() +"\n");
    		bw.append("Ganador: " + currentCombate.getGanador().getNombre() +"\n");
    		for (Turno turno : currentCombate.getTurnos()) {
    			bw.append("Turno: " + turno.getNumTurno()+"\n");
    			bw.append("Entrenador: "+ turno.getAccionRealizadaJugador()+"\n");
    			bw.append("Rival: "+ turno.getAccionRealizadaRival()+"\n");
			}
    		String pksDebilitados="";
    		for(Pokemon pk: currentCombate.getPokemonsKOJugador()) {
    			pksDebilitados+=pk.getNombre() + ", ";
    		}
    		bw.append("Pokemons Jugador debilitados: " + pksDebilitados + "\n");
    		pksDebilitados="";
    		for(Pokemon pk: currentCombate.getPokemonsKORival()) {
    			pksDebilitados+=pk.getNombre() + ", ";
    		}
    		bw.append("Pokemons Rival debilitados: " + pksDebilitados + "\n");
    		bw.append("\n");
    		bw.close();		
    	} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
}
