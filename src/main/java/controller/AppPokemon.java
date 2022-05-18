package controller;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import dao.DAOFactory;
import model.combate.*;
import model.entrenador.*;
import model.movimiento.*;
import model.pokemon.*;
import model.utils.ModelUtils;

public class AppPokemon {
	public static final String PATH="./log/combate.log";
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
	
	public String getSpritePokemon(Entrenador e, int numPk){
		return e.getPokemons().get(numPk).getSprite();
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
            return rival.aplicarEstado(mvE, msg);
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

    public void finalizarCombate(){
        currentCombate.terminarCombate();
        this.currentEntrenador.addCombate(currentCombate);
    }
    
    public void exportarDatos() {
        File fichero = new File(PATH);
                
    	try {
    		FileWriter fw = new FileWriter(fichero);
    		BufferedWriter bw = new BufferedWriter(fw);
    		
    		for (Turno turno : currentCombate.getTurnos()) {
    			bw.write("Turno: " + turno.getNumTurno()+"\n");
    			bw.write("Entrenador: "+ turno.getAccionRealizadaJugador()+"\n");
    			bw.write("Rival: "+ turno.getAccionRealizadaRival()+"\n");
			}
    		bw.close();
    		
    		   		
    	} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
}
