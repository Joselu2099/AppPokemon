package model;

import eu.iamgio.pokedex.Generation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PokemonRepository {

    private static PokemonRepository INSTANCE;

    private List<Pokemon> pokemons;

    private PokemonRepository(){
        pokemons = new ArrayList<>();
        this.loadRepository();
    }

    public static PokemonRepository getInstance(){
        if(INSTANCE == null)
            INSTANCE = new PokemonRepository();
        return INSTANCE;
    }

    private void loadRepository(){
        pokemons = Generation.GENERATION_I.load().getPokemonNames().stream()
                .map(ModelUtils::parsePokemon)
                .collect(Collectors.toList());
    }

    public List<Pokemon> getPokemons() {
        return new ArrayList<Pokemon>(pokemons);
    }
}
