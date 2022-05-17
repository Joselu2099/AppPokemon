package model.movimiento;

import eu.iamgio.pokedex.pokemon.PokemonType;
import model.utils.ModelUtils;

public class MovimientoEstado extends Movimiento {

    private Estado estado;

    public MovimientoEstado() {
        super();
        this.estado = Estado.SIN_ESTADO;
    }

    public MovimientoEstado(String nombre, PokemonType tipo, Estado estado) {
        super(nombre, tipo);
        this.estado = Estado.SIN_ESTADO;
    }

    public MovimientoEstado(int id, String nombre, PokemonType tipo, Estado estado) {
        super(id, nombre, tipo);
        this.estado = Estado.SIN_ESTADO;
    }

    
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
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
