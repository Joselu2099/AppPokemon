package model;

import eu.iamgio.pokedex.Generation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MovimientosRepository {

    private static MovimientosRepository INSTANCE;

    private Map<Integer, Movimiento> movimientos;

    private MovimientosRepository(){
        movimientos = new HashMap<>();
        this.loadRepository();
    }

    public static MovimientosRepository getINSTANCE(){
        if(INSTANCE == null)
            INSTANCE = new MovimientosRepository();
        return INSTANCE;
    }

    private void loadRepository(){
        ArrayList<Movimiento> pks = (ArrayList<Movimiento>) Generation.GENERATION_I.load().getMoveNames().stream()
                .map(ModelUtils::parseMovimiento)
                .collect(Collectors.toList());

        pks.forEach(mv -> movimientos.put(mv.getId(), mv));
    }

    public ArrayList<Movimiento> getMovimientos() {
        return new ArrayList<Movimiento>(movimientos.values());
    }

    public Movimiento getMovimiento(int id){
        return movimientos.get(id);
    }
}
