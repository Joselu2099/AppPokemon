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
}
