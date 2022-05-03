package model;

import eu.iamgio.pokedex.Generation;

import java.util.HashSet;
import java.util.Set;

public class ObjetoRepository {

    private static ObjetoRepository INSTANCE;

    private Set<ObjetoPokemon> objetosPokemon;

    private ObjetoRepository(){
        objetosPokemon = new HashSet<>();
        this.loadRepository();
    }

    public static ObjetoRepository getInstance(){
        if(INSTANCE == null)
            INSTANCE = new ObjetoRepository();
        return INSTANCE;
    }
    private void loadRepository(){
        Generation.GENERATION_I.load().getPokemonNames().stream()
                .map(pk -> eu.iamgio.pokedex.pokemon.Pokemon.fromName(pk))
                .flatMap(pk -> pk.getHeldItems().stream()
                        .map(itemHold -> ModelUtils.parseItemsPokemon(itemHold))
                        .forEach(objetoPokemon -> objetosPokemon.add(objetoPokemon)));
    }

    public Set<Objeto> getObjetosPokemon() {
        return new HashSet<>(objetosPokemon);
    }
}
