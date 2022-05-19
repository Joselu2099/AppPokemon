package model.movimiento;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import dao.DAOFactory;
import dao.MovimientoDAO;
import eu.iamgio.pokedex.pokemon.PokemonType;

public class MovimientosRepository {

    private static MovimientosRepository INSTANCE;

    private HashMap<Integer, Movimiento> movimientosID;
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
        	System.err.println("Base de datos sin conexion :(");
        }
    }

    public ArrayList<Movimiento> getMovimientos() {
        return new ArrayList<Movimiento>(movimientosID.values());
    }
    
    public ArrayList<Movimiento> getMovimientosOfType(PokemonType type1, PokemonType type2){
    	return (ArrayList<Movimiento>) movimientosID.values().stream()
    			.filter(mv -> (mv.getTipo().equals(type1) || mv.getTipo().equals(type2) | mv.getTipo().equals(PokemonType.NORMAL)))
    			.collect(Collectors.toList());
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
