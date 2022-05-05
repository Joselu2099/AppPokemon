package model;

import java.util.LinkedList;
import java.util.List;

public class CajaPokemon {
    private int id;
    private List<Pokemon> pokemons;

    public CajaPokemon(){
        id = 0;
        pokemons = new LinkedList<>();
    }

    public boolean isPokemonInCaja(Pokemon pokemon){
        return pokemons.contains(pokemon);
    }

    public void addPokemon(Pokemon pokemon){
        pokemons.add(pokemon);
    }

    public void removePokemon(Pokemon pokemon){
        pokemons.remove(pokemon);
    }
}
