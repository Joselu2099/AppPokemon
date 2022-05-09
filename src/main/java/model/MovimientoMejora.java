package model;

import eu.iamgio.pokedex.pokemon.PokemonType;

public class MovimientoMejora extends Movimiento {

    private int mejora;
    private int numTurnos;

    public MovimientoMejora() {
        super();
        this.mejora = 0;
        this.numTurnos = 0;
    }

    public MovimientoMejora(String nombre, PokemonType tipo, int mejora, int numTurnos) {
        super(nombre, tipo);
        this.mejora = mejora;
        this.numTurnos = numTurnos;
    }

    public int getMejora() {
        return mejora;
    }

    public void setMejora(int mejora) {
        this.mejora = mejora;
    }

    public int getNumTurnos() {
        return numTurnos;
    }

    public void setNumTurnos(int numTurnos) {
        this.numTurnos = numTurnos;
    }

    public int consumoEstamina() {
        return numTurnos*10;
    }

}
