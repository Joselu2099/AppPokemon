package model.movimiento;

public class MovimientoNull extends Movimiento {

    public MovimientoNull() {
        super();
    }

    @Override
    public int consumoEstamina() {
        return 0;
    }
    
    @Override
    public String toString() {
    	return "Movimiento nulo";
    }
}
