package model;

import eu.iamgio.pokedex.Generation;
import model.utils.ModelUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PokemonRepository {

    private static PokemonRepository INSTANCE;

    private Map<Integer, Pokemon> pokemons;

    private PokemonRepository() {
        pokemons = new HashMap<>();
        this.loadRepository();
    }

    public static PokemonRepository getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new PokemonRepository();
        return INSTANCE;
    }

    private void loadRepository() {
        ArrayList<Pokemon> pks = (ArrayList<Pokemon>) Generation.GENERATION_I.load().getPokemonNames().stream()
                .map(ModelUtils::parsePokemon)
                .collect(Collectors.toList());

        pks.forEach(pk -> pokemons.put(pk.getId(), pk));
    }

    public ArrayList<Pokemon> getPokemons() {
        return new ArrayList<Pokemon>(pokemons.values());
    }

    public Pokemon getPokemon(int id) {
        return pokemons.get(id);
    }

    public int getNumeroPokemons() {
        return pokemons.size();
    }

    public int generarNumRandom(int M, int N){
        return (int) Math.floor(Math.random()*(N-M+1)+M);
    }

    public Pokemon generarPokemonRandom() {
        return getPokemon(generarNumRandom(1,getNumeroPokemons()));
    }

    public Pokemon generarPokemon(String nombre, int nivel) {
        Pokemon pk = ModelUtils.parsePokemon(nombre);
        for (int i = 0; i < nivel; i++) {
            pk.subirNivel();
        }
        return pk;
    }

    public ArrayList<Pokemon> generarEquipoPokemon(int nivel){
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Pokemon pk = generarPokemonRandom();
            for (int j = 0; j < nivel; j++) {
                pk.subirNivel();
            }
            pokemons.add(generarPokemonRandom());
        }
        return pokemons;
    }
}
