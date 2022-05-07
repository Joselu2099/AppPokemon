package model;

import java.util.ArrayList;

public class Entrenador {

    private static int POKEDOLLARS_BASE = 800;

    int id;
    String nombre;
    ArrayList<Pokemon> pokemons;
    int pokedollars;
    CajaPokemon cajaPokemon;

    public Entrenador() {
        this.id = 0;
        this.nombre = "";
        this.pokemons = new ArrayList<Pokemon>();
        this.pokedollars = 0;
        this.cajaPokemon = new CajaPokemon();
    }

    public Entrenador(String nombre) {
        this.id = 0;
        this.nombre = nombre;
        this.pokemons = new ArrayList<>();
        this.pokedollars = POKEDOLLARS_BASE;
        //TODO
        this.cajaPokemon = new CajaPokemon();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void addPokemon(Pokemon pokemon) {
        if (pokemons.size() == 4) {
            cajaPokemon.addPokemon(pokemon);
        } else pokemons.add(pokemon);
    }

    public boolean sacarPokemon(Pokemon pokemon) {
        if (cajaPokemon.isPokemonInCaja(pokemon)) {
            if (pokemons.size() != 4) {
                pokemons.add(pokemon);
                cajaPokemon.removePokemon(pokemon);
                return true;
            }
        }
        return false;
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
        return false;
    }

    public void addPokedollars() {
        //TODO
    }


}
