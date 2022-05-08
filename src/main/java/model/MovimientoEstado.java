package model;

import eu.iamgio.pokedex.pokemon.PokemonType;

public class MovimientoEstado extends Movimiento {

    private Estado estado;
    private int numTurnos;

    public MovimientoEstado() {
        super();
        this.estado = Estado.SIN_ESTADO;
        this.numTurnos = 0;
    }

    public MovimientoEstado(String nombre, PokemonType tipo, Estado estado, int numTurnos) {
        super(nombre, tipo);
        this.estado = Estado.SIN_ESTADO;
        this.numTurnos = numTurnos;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
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
