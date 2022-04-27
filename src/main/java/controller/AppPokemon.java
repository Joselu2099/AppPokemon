package controller;

import eu.iamgio.pokedex.pokemon.Pokemon;
import eu.iamgio.pokedex.pokemon.PokemonType;
import eu.iamgio.pokedex.util.Pair;

import java.util.Scanner;

public class AppPokemon {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un nombre de un pokemon: ");
		String pokemon = sc.nextLine();
		Pokemon pk = Pokemon.fromName(pokemon.toLowerCase());
		Pair<PokemonType, PokemonType> types = pk.getTypes();
		if(types.getSecond()!=null)
			System.out.println(pk.getName() + " es de tipo " + types.getFirst() + " y " + types.getSecond());
		else
			System.out.println(pk.getName() + " es de tipo " + types.getFirst());
	}
}
