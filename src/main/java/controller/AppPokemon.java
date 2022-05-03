package controller;

import eu.iamgio.pokedex.exception.PokedexException;
import eu.iamgio.pokedex.pokemon.PokemonPokedex;
import eu.iamgio.pokedex.pokemon.PokemonType;
import eu.iamgio.pokedex.util.Pair;
import model.*;

import java.util.Scanner;

public class AppPokemon {

	private static AppPokemon INSTANCE;

	private Entrenador currentEntrenador;

	private AppPokemon(){
		//Coger entrenador registrado en BD
		currentEntrenador = new Entrenador();
	}

	public AppPokemon getINSTANCE(){
		if(INSTANCE==null)
			INSTANCE = new AppPokemon();
		return INSTANCE;
	}

	public boolean capturarPokemon(Pokemon pokemon){
		currentEntrenador.addPokemon(pokemon);
		return false;
	}

	public Pokemon generarPokemonRandom(){
		int numRandom = (int) Math.floor(Math.random()*(PokemonRepository.getINSTANCE().getNumeroPokemons()-1+1)+1);  // Valor entre M y N, ambos incluidos.
		return PokemonRepository.getINSTANCE().getPokemon(numRandom);
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Introduce un nombre de un pokemon: ");
			String pokemon = sc.nextLine();
			PokemonPokedex pk = PokemonPokedex.fromName(pokemon.toLowerCase());
			Pair<PokemonType, PokemonType> types = pk.getTypes();
			if(types.getSecond()!=null)
				System.out.println(pk.getName() + " es de tipo " + types.getFirst() + " y " + types.getSecond());
			else
				System.out.println(pk.getName() + " es de tipo " + types.getFirst());
		} catch (PokedexException e) {
			e.printStackTrace();
		}
	}
}
