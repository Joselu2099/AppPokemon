package persistence;

import model.movimiento.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        Movimiento movimiento;
        int id = rs.getInt("id_movimiento");
        String nombre = rs.getString("nombre");
        int potencia = rs.getInt("potencia");
        String tipo = rs.getString("tipo");
        String estado = rs.getString("estado");
        String  tipoMejora = rs.getString("tipo_mejora");

        return new MovimientoAtaque();
    }

    @Override
    public Movimiento get(String nombre) throws SQLException {
        return null;
    }

    @Override
    public Movimiento get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Movimiento> getAll() throws SQLException {
        return null;
    }
}
