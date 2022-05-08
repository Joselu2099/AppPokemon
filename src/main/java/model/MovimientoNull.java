package model;

public class MovimientoNull extends Movimiento {

    public MovimientoNull() {
        super();
    }

    @Override
    public int consumoEstamina() {
        return 0;
    }
}
