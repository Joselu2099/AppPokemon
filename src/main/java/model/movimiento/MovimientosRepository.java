package model.movimiento;

import eu.iamgio.pokedex.Generation;
import model.utils.ModelUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MovimientosRepository {

    private static MovimientosRepository INSTANCE;

    private Map<Integer, Movimiento> movimientos;

    private MovimientosRepository() {
        movimientos = new HashMap<>();
        this.loadRepository();
    }

    public static MovimientosRepository getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new MovimientosRepository();
        return INSTANCE;
    }

    private void loadRepository() {

    }

    public ArrayList<Movimiento> getMovimientos() {
        return new ArrayList<Movimiento>(movimientos.values());
    }

    public Movimiento getMovimiento(int id) {
        return movimientos.get(id);
    }
}
