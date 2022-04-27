package controller;

import java.util.List;
import java.util.stream.Collectors;
import eu.iamgio.pokedex.Generation;
import eu.iamgio.pokedex.pokemon.Pokemon;
import eu.iamgio.pokedex.pokemon.PokemonType;
import eu.iamgio.pokedex.util.Pair;

public class AppPokemon {
	public static void main(String[] args) {

		List<Pokemon> pokemons = Generation.GENERATION_I.load().getPokemonNames().stream()
				.map(pk -> Pokemon.fromName(pk))
				.collect(Collectors.toList());
		
		for (Pokemon pokemon : pokemons) {
			if(pokemon.getName().equals("blastoise")){
				pokemon.getMoves().forEach(mv -> System.out.println(mv.getName()));
			}
		}
        
	}
}
