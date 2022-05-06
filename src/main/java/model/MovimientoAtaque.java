package model;

import eu.iamgio.pokedex.pokemon.PokemonType;

public class MovimientoAtaque extends Movimiento{

	private int potencia;
	private PokemonType tipo;

	public MovimientoAtaque() {
		super();
		potencia = 0;
		tipo = PokemonType.NORMAL;
	}

	public MovimientoAtaque(String nombre, int estamina, int potencia, PokemonType tipo) {
		super(nombre, estamina);
		this.potencia = potencia;
		this.tipo = tipo;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public PokemonType getTipo() {
		return tipo;
	}

	public void setTipo(PokemonType tipo) {
		this.tipo = tipo;
	}

	public void consumoEstamina() {
		//TODO
	}

}
