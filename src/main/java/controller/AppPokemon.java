package controller;

import model.combate.*;
import model.entrenador.*;
import model.movimiento.*;
import model.pokemon.*;
import persistence.DAOFactory;

public class AppPokemon {

    private static AppPokemon INSTANCE;

    private DAOFactory factory;
    private Entrenador currentEntrenador;
    private Combate currentCombate;

    private AppPokemon() {
        //Cargar entrenador logueado registrado en BD
        this.currentEntrenador = new Entrenador();
        this.currentCombate = new Combate();
        this.factory = DAOFactory.getINSTANCE();
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

    public boolean login(String nombre){
        Entrenador e = EntrenadorRepository.getINSTANCE().getEntrenador(nombre);
        if(e==null) return false;
        currentEntrenador = e;
        return true;
    }

    public boolean registrarEntrenador(String nombre){
        Entrenador entrenador = new Entrenador(nombre);
        return EntrenadorRepository.getINSTANCE().addEntrenador(entrenador);
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
