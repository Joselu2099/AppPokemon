package model;

import java.util.ArrayList;

public class Entrenador {

	private static int POKEDOLLARS_BASE = 800;
	
	int idEntrenador;
	String nombre;
	ArrayList<Pokemon> pokemons;
	int pokedollars;
	CajaPokemon cajaPokemon;
	
	public Entrenador() {
		this.idEntrenador=0;
		this.nombre="";
		this.pokemons=new ArrayList();
		this.pokedollars=0;
		this.cajaPokemon=new CajaPokemon();
	}

	public Entrenador(String nombre) {
		this.idEntrenador = idEntrenador;
		this.nombre = nombre;
		this.pokemons = pokemons;
		this.pokedollars = POKEDOLLARS_BASE;
		//TODO
		this.cajaPokemon = cajaPokemon;
	}

	public int getIdEntrenador() {
		return idEntrenador;
	}

	public void setIdEntrenador(int idEntrenador) {
		this.idEntrenador = idEntrenador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Pokemon> getPokemons() {
		return pokemons;
	}

	public void setPokemons(ArrayList<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

	public int getPokedollars() {
		return pokedollars;
	}

	public void setPokedollars(int pokedollars) {
		this.pokedollars = pokedollars;
	}

	public CajaPokemon getCajaPokemon() {
		return cajaPokemon;
	}

	public void setCajaPokemon(CajaPokemon cajaPokemon) {
		this.cajaPokemon = cajaPokemon;
	}
	
	public void moverPokemon() {
		//TODO
	}
	
	public void sacarPokemon() {
		//TODO
	}
	
	public void entrenar() {
		//TODO
	}
	
	public void capturar() {
		//TODO
	}
	
	public void combatir() {
		//TODO
	}
	
	public void criar() {
		//TODO
	}
	
	public void retirar() {
		//TODO
	}
	
	public void generar() {
		//TODO
	}
	
	public boolean retirarPokedollars() {
		//TODO
	}
	
	public void addPokedollars() {
		//TODO
	}

	
	
	
	

}
