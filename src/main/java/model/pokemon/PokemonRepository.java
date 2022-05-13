package model.pokemon;

import eu.iamgio.pokedex.Generation;
import model.utils.ModelUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PokemonRepository {

    private static PokemonRepository INSTANCE;

    private ArrayList<String> nombresPokemon;
    private Map<Integer, Pokemon> pokemons;

    private PokemonRepository() {
        pokemons = new HashMap<>();
        nombresPokemon = (ArrayList<String>) Generation.GENERATION_I.load().getPokemonNames();
        //this.loadRepository();
    }

    public static PokemonRepository getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new PokemonRepository();
        return INSTANCE;
    }
    /*
    private void loadRepository() {
        ArrayList<Pokemon> pks = (ArrayList<Pokemon>) Generation.GENERATION_I.load().getPokemonNames().stream()
                .map(ModelUtils::parsePokemon)
                .collect(Collectors.toList());

        pks.forEach(pk -> pokemons.put(pk.getId(), pk));
    }
    */
    public ArrayList<Pokemon> getPokemons() {
        return new ArrayList<Pokemon>(pokemons.values());
    }

    public Pokemon getPokemon(int id) {
        if(pokemons.containsKey(id))
            return pokemons.get(id);
        Pokemon pk = ModelUtils.parsePokemon(id);
        pokemons.put(pk.getId(), pk);
        return pk;
    }

    public Pokemon getPokemon(String nombre) {
        Pokemon pk = ModelUtils.parsePokemon(nombre);
        if(pokemons.containsValue(pk)) return pk;
        pokemons.put(pk.getId(), pk);
        return pk;
    }

    public int getNumeroPokemons() {
        return pokemons.size();
    }

    public Pokemon generarPokemonRandom() {
        return getPokemon(ModelUtils.generarNumRandom(1,getNumeroPokemons()));
    }

    public Pokemon generarPokemonRandom(int nivel) {
        Pokemon pk = getPokemon(ModelUtils.generarNumRandom(1,getNumeroPokemons()));
        for (int i = 0; i < nivel; i++) {
            pk.subirNivel();
        }
        return pk;
    }

    public Pokemon generarPokemon(String nombre, int nivel) {
        Pokemon pk = getPokemon(nombre);
        for (int i = 0; i < nivel; i++) {
            pk.subirNivel();
        }
        return pk;
    }

    public ArrayList<Pokemon> generarEquipoPokemon(int nivel){
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            pokemons.add(generarPokemonRandom(nivel));
        }
        return pokemons;
    }
}
