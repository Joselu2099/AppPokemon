package controller;

import model.combate.*;
import model.entrenador.*;
import model.movimiento.*;
import model.pokemon.*;
import persistence.DAOFactory;

public class AppPokemon {

    private static AppPokemon INSTANCE;
    private Entrenador currentEntrenador;
    private Combate currentCombate;

    private AppPokemon() {
        this.currentEntrenador = new Entrenador();
        this.currentCombate = new Combate();
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

    public boolean isEntrenadorRegistrado(String nombre) {
    	return EntrenadorRepository.getINSTANCE().getEntrenador(nombre)!=null;
    }
    
    public void login(String nombre){
    	if(isEntrenadorRegistrado(nombre)) 
    		this.currentEntrenador = EntrenadorRepository.getINSTANCE().getEntrenador(nombre);
    	else registrarEntrenador(nombre);
    }

    public boolean registrarEntrenador(String nombre){
    	this.currentEntrenador = new Entrenador(nombre);
        return EntrenadorRepository.getINSTANCE().addEntrenador(currentEntrenador);
    }

    public void capturarPokemon(Pokemon pokemon) {
        PokemonRepository.getINSTANCE().generarPokemonRandom(1);
        //TODO
        currentEntrenador.capturar(pokemon);
    }

    public void capturarPokemon(Pokemon pokemon, String mote) {
        pokemon.setMote(mote);
        capturarPokemon(pokemon);
    }

    public void crearCombate(Entrenador rival){
        this.currentCombate = new Combate(currentEntrenador, rival);
    }

    public void crearCombateRandom(int nivelCombate){
    	this.currentCombate = new Combate(currentEntrenador, EntrenadorRepository.getINSTANCE().generarEntrenadorRandom(currentEntrenador.getNivelEquipo()));
    }

    public void empezarCombate(){
        this.currentCombate.empezarCombate();
        //TODO
    }

    public boolean ejecutarMovimiento(Pokemon atacante, Pokemon rival, Movimiento mv, String msg){
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
            atacante.aplicarMejora(mvM, msg);
            return true;
        }
        return false;
    }

    public void debilitarPokemon(Combate co, Entrenador entrenadorKO, Pokemon pokemonKO, Pokemon pokemonRival){
        co.debilitarPokemon(entrenadorKO, pokemonKO);
        pokemonRival.aumentarExperiencia((int)(pokemonRival.getNivel() + pokemonKO.getNivel()*10) / 4);
    }

    public void finalizarCombate(Combate combate){
        combate.terminarCombate();
        this.currentEntrenador.addCombate(combate);
    }
}
