package model.movimiento;

import eu.iamgio.pokedex.pokemon.PokemonType;
import model.utils.ModelUtils;

public class MovimientoMejora extends Movimiento {

    private int mejora;
    private TipoMejora tipoMejora;

    public MovimientoMejora() {
        super();
        this.mejora = 0;
        this.tipoMejora = TipoMejora.UNKNOWN;
    }

    public MovimientoMejora(String nombre, PokemonType tipo, int mejora, TipoMejora tipoMejora) {
        super(nombre, tipo);
        this.mejora = mejora;
        this.tipoMejora = tipoMejora;
    }
    
    public MovimientoMejora(int id, String nombre, PokemonType tipo, int mejora, TipoMejora tipoMejora) {
        super(id, nombre, tipo);
        this.mejora = mejora;
        this.tipoMejora = tipoMejora;
    }

    public int getMejora() {
        return mejora;
    }

    public void setMejora(int mejora) {
        this.mejora = mejora;
    }

    public TipoMejora getTipoMejora() {
        return tipoMejora;
    }

    public void setTipoMejora(TipoMejora tipoMejora) {
        this.tipoMejora = tipoMejora;
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
    
    @Override
	public String toString() {
		return super.toString() + ", Mejora el " + tipoMejora + " en " + mejora+", consumoEstamina=" + consumoEstamina();
	}

}
