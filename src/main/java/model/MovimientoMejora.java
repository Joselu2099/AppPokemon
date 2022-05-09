package model;

import eu.iamgio.pokedex.pokemon.PokemonType;
import model.utils.ModelUtils;

public class MovimientoMejora extends Movimiento {

    private int mejora;

    public MovimientoMejora() {
        super();
        this.mejora = 0;
    }

    public MovimientoMejora(String nombre, PokemonType tipo, int mejora) {
        super(nombre, tipo);
        this.mejora = mejora;
    }

    public int getMejora() {
        return mejora;
    }

    public void setMejora(int mejora) {
        this.mejora = mejora;
    }

    /**
     * Num_turnos es una propiedad calculada, de forma random una mejora podra durar entre 1 o 5 turnos.
     * @return numero de turnos que dura la mejora o que se realiza la mejora
     */
    public int getNumTurnos() {
        return ModelUtils.generarNumRandom(1,5);
    }

    public int consumoEstamina() {
        return getNumTurnos()*10;
    }

}
