package model.movimiento;

import eu.iamgio.pokedex.pokemon.PokemonType;

public abstract class Movimiento {
    private int id;
    private String nombre;
    private PokemonType tipo;

    public Movimiento() {
        this.id = 0;
        this.nombre = "";
        this.tipo = PokemonType.UNKNOWN;
    }

    public Movimiento(String nombre, PokemonType tipo) {
        this.id = 0;
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    public Movimiento(int id, String nombre, PokemonType tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
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

    public PokemonType getTipo() {
        return tipo;
    }

    public void setTipo(PokemonType tipo) {
        this.tipo = tipo;
    }

    public abstract int consumoEstamina();

	@Override
	public String toString() {
		return "Movimiento [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo;
	}
    
    
}
