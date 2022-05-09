package model;

import controller.AppPokemon;
import eu.iamgio.pokedex.Generation;
import model.utils.ModelUtils;
import model.utils.NombresEntrenador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class EntrenadorRepository {

    private static EntrenadorRepository INSTANCE;

    private Map<String, Entrenador> altosMando;
    private Map<Integer, Entrenador> entrenadores;

    private EntrenadorRepository() {
        entrenadores = new HashMap<>();
        this.loadRepository();
    }

    public static EntrenadorRepository getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new EntrenadorRepository();
        return INSTANCE;
    }

    private void loadRepository() {
        //Pokemon pk1 = ModelUtils.parsePokemon("charizard");
        //Entrenador knekro = new Entrenador("Knekro", )

    }

    public ArrayList<Entrenador> getEntrenadores() {
        return new ArrayList<Entrenador>(entrenadores.values());
    }

    public void setEntrenadores(Map<Integer, Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    public Entrenador getEntrenador(int id) {
        return entrenadores.get(id);
    }

    public void addEntrenador(Entrenador entrenador){
        entrenadores.put(entrenador.getId(), entrenador);
    }

    public void addEntrenadores(ArrayList<Entrenador> entrenadoresIn){
        entrenadoresIn.forEach(e -> entrenadores.put(e.getId(), e));
    }

    public int generarNumRandom(int M, int N){
        return (int) Math.floor(Math.random()*(N-M+1)+M);
    }

    public Entrenador generarEntrenadorRandom(){
        return new Entrenador(NombresEntrenador.fromId(generarNumRandom(1,NombresEntrenador.NUM_NOMBRES)), PokemonRepository.getINSTANCE().generarEquipoPokemon(5));
    }
}
