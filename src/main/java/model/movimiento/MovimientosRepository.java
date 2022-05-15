package model.movimiento;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dao.DAOFactory;
import dao.MovimientoDAO;


public class MovimientosRepository {

    private static MovimientosRepository INSTANCE;

    private Map<Integer, Movimiento> movimientosID;
    private MovimientoDAO movimientoDAO;

    private MovimientosRepository() {
    	movimientosID = new HashMap<>();
        movimientoDAO = DAOFactory.getINSTANCE().getMovimientoDAO();
        this.loadRepository();
    }

    public static MovimientosRepository getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new MovimientosRepository();
        return INSTANCE;
    }

    private void loadRepository() {
        try {
            movimientoDAO.getAll().forEach(mv -> movimientosID.put(mv.getId(), mv));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Movimiento> getMovimientos() {
        return new ArrayList<Movimiento>(movimientosID.values());
    }

    public Movimiento getMovimiento(int id) {
        return movimientosID.get(id);
    }
    
    public Movimiento getMovimiento(String nombre) {
        for(Movimiento mv: movimientosID.values()) {
        	if(mv.getNombre().equals(nombre))
        		return mv;
        }
        return new MovimientoNull();
    }
}
