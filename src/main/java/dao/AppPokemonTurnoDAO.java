package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import model.combate.Turno;

public class AppPokemonTurnoDAO implements TurnoDAO {

    private static AppPokemonTurnoDAO INSTANCE = null;
    private final Connection connection;
    private Statement statement;

    private AppPokemonTurnoDAO() {
        this.connection = DAOFactory.getINSTANCE().getConnection();
        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized AppPokemonTurnoDAO getInstance() {
        if (INSTANCE == null)
            INSTANCE = new AppPokemonTurnoDAO();
        return INSTANCE;
    }

    private Turno resultToTurno (ResultSet rs) throws SQLException{
        return new Turno(rs.getInt("id_turno"), rs.getInt("num_turno"), UtilsDAO.idToMovimiento(rs.getInt("movimiento_jugador")), UtilsDAO.idToMovimiento(rs.getInt("movimiento_rival")));
    }

    @Override
    public Turno create(Turno assistant) throws SQLException {
        statement.executeUpdate("INSERT INTO TURNO(ID_TURNO, COMBATE, NUM_TURNO, MOVIMIENTO_JUGADOR, MOVIMIENTO_RIVAL)" +
                " VALUES(" + assistant.getId() + ", " + assistant.getCombate().getId() + ", " + assistant.getNumTurno() +" , " + assistant.getAccionRealizadaJugador().getId() + "," + assistant.getAccionRealizadaRival().getId() + ")");
        return getLast();
    }
    
    @Override
    public void delete(Turno assistant) throws SQLException{
    	statement.executeUpdate("DELETE FROM TURNO WHERE ID_TURNO ="+ assistant.getId());
    }
    
    @Override
    public Turno getLast() throws SQLException {
        ArrayList<Turno> turnos = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM TURNO ORDER BY ID_ENTRENADOR DESC LIMIT 1");
        while (rs.next()){
            turnos.add(resultToTurno(rs));
        }
        if(turnos.size()>0) return turnos.get(0);
        return null;
    }

	@Override
	public Turno get(int id) throws SQLException {
		ArrayList<Turno> turnos = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM TURNO WHERE ID_TURNO="+id);
        while (rs.next()){
            turnos.add(resultToTurno(rs));
        }
        if(turnos.size()>0) return turnos.get(0);
        return null;
	}
	
	@Override
	public List<Turno> getTurnosFromCombate(int idCombate) throws SQLException {
		LinkedList<Turno> turnos = new LinkedList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM TURNO WHERE COMBATE="+idCombate);
        while (rs.next()){
            turnos.add(resultToTurno(rs));
        }
        return turnos;
	}

	@Override
	public List<Turno> getAll() throws SQLException {
		ArrayList<Turno> turnos = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM TURNO");
        while (rs.next()){
            turnos.add(resultToTurno(rs));
        }
        return turnos;
	}

}