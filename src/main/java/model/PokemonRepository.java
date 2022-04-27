package model;

import eu.iamgio.pokedex.Generation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PokemonRepository {

    private static PokemonRepository INSTANCE;

    List<Pokemon> pokemons;

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
                .map(pk -> eu.iamgio.pokedex.pokemon.Pokemon.fromName(pk))
                .map(pk -> ModelUtils.parsePokemon(pk))
                .collect(Collectors.toList());
    }
}
