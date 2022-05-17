package dao;

import model.movimiento.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AppPokemonMovimientoDAO implements MovimientoDAO{

    private static AppPokemonMovimientoDAO INSTANCE = null;
    private final Connection connection;
    private Statement statement;

    private AppPokemonMovimientoDAO() {
        this.connection = DAOFactory.getINSTANCE().getConnection();
        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Aplicamos el patron Singleton.
    public static synchronized AppPokemonMovimientoDAO getInstance() {
        if (INSTANCE == null)
            INSTANCE = new AppPokemonMovimientoDAO();
        return INSTANCE;
    }

    public Movimiento resultToMovimiento(ResultSet rs) throws SQLException{
        Integer potencia = rs.getInt("potencia");
        String estado = rs.getString("estado");
        String  tipoMejora = rs.getString("tipo_mejora");
        if(potencia!=null && estado==null && tipoMejora==null)
			return new MovimientoAtaque(rs.getInt("id_movimiento"), rs.getString("nombre"), UtilsDAO.stringToPokemonType(rs.getString("tipo")), potencia);
        if(estado!=null && tipoMejora==null) 
        	return new MovimientoEstado(rs.getInt("id_movimiento"), rs.getString("nombre"), UtilsDAO.stringToPokemonType(rs.getString("tipo")), UtilsDAO.stringToEstado(estado));
        if(tipoMejora!=null)
        	return new MovimientoMejora(rs.getInt("id_movimiento"), rs.getString("nombre"), UtilsDAO.stringToPokemonType(rs.getString("tipo")), rs.getInt("mejora"), UtilsDAO.stringToTipoMejora(tipoMejora));
        return new MovimientoNull();
    }

    @Override
    public Movimiento get(String nombre) throws SQLException {
    	ArrayList<Movimiento> movimientos = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM MOVIMIENTO WHERE NOMBRE='"+nombre+"'");
        while (rs.next()){
        	movimientos.add(resultToMovimiento(rs));
        }
        return movimientos.get(0);
    }

    @Override
    public Movimiento get(int id) throws SQLException {
    	ArrayList<Movimiento> movimientos = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM MOVIMIENTO WHERE ID_MOVIMIENTO="+id);
        while (rs.next()){
        	movimientos.add(resultToMovimiento(rs));
        }
        return movimientos.get(0);
    }

    @Override
    public List<Movimiento> getAll() throws SQLException {
    	ArrayList<Movimiento> movimientos = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM MOVIMIENTO");
        while (rs.next()){
        	movimientos.add(resultToMovimiento(rs));
        }
        return movimientos;
    }
}
