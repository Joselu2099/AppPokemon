package model.movimiento;

import eu.iamgio.pokedex.pokemon.PokemonType;

public class MovimientoAtaque extends Movimiento {

    private int potencia;

    public MovimientoAtaque() {
        super();
        potencia = 0;
    }

    public MovimientoAtaque(String nombre, PokemonType tipo, int potencia) {
        super(nombre, tipo);
        this.potencia = potencia;
    }

    public MovimientoAtaque(int id, String nombre, PokemonType tipo, int potencia) {
        super(id, nombre, tipo);
        this.potencia = potencia;
    }
    
    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int consumoEstamina() {
        return potencia/2;
    }

	@Override
	public String toString() {
		return super.toString() + ", potencia=" + potencia + ", consumoEstamina=" + consumoEstamina()+"]";
	}

    
}
