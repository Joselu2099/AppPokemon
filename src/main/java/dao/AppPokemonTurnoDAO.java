package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
}
    public static synchronized AppPokemonTurnoDAO getInstance() {
        if (INSTANCE == null)
            INSTANCE = new AppPokemonTurnoDAO();
        return INSTANCE;
    }

    private Turno resultToTurno (ResultSet rs) throws SQLException{
        Turno e = new Turno(rs.getInt("numTurno"),
        rs.getMovimiento("accionRealizadaJugador")
        rs.getMovimiento("accionRealizadaRival"));
    }

    @Override
    public Turno create(Turno assistant) throws SQLException {
        statement.executeUpdate("INSERT INTO TURNO(ID_TURNO, COMBATE, NUMTURNO, ACCIONREALIZADAJUGADOR, ACCIONREALIZADARIVAL)" +
                " VALUES('" + assistant.getCombate() + "', " + assistant.getNumTurno() +" , " + assistant.getAccionRealizadaJugador() + "," + assistant.getAccionRealizadaRival() + ")");
        return getLast();
    }

    @Override
    public void updateProfile(Turno assistant) throws SQLException {
        statement.executeUpdate("UPDATE TURNO" +
                " SET TURNO='" + assistant.getNumTurno() +"'"+
                " SET MOVIMIENTO = " + assistant.getAccionRealizadaJugador();
                " SET MOVIMIENTO = " + assistant.getAccionRealizadaRival());
    }

