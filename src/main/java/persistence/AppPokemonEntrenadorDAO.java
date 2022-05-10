package persistence;

import model.Entrenador;
import model.utils.ModelUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class AppPokemonEntrenadorDAO implements EntrenadorDAO {

    private static AppPokemonEntrenadorDAO INSTANCE = null;
    private final Connection connection;
    private Statement statement;

    private AppPokemonEntrenadorDAO() {
        this.connection = DAOFactory.getINSTANCE().getConnection();
        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Aplicamos el patron Singleton.
    public static synchronized AppPokemonEntrenadorDAO getInstance() {
        if (INSTANCE == null)
            INSTANCE = new AppPokemonEntrenadorDAO();
        return INSTANCE;
    }

    private Entrenador resultToEntrenador(ResultSet rs) throws SQLException{
        /*
        System.out.println(rs.getMetaData().getColumnName(1) + " - " + rs.getMetaData().getColumnType(1) + "\n" +
                rs.getMetaData().getColumnName(2) + " - " + rs.getMetaData().getColumnType(2) + "\n" +
                rs.getMetaData().getColumnName(3) + " - " + rs.getMetaData().getColumnType(2) + "\n" +
                rs.getMetaData().getColumnName(4) + " - " + rs.getMetaData().getColumnType(2) + "\n" +
                rs.getMetaData().getColumnName(5) + " - " + rs.getMetaData().getColumnType(2));

        System.out.println(rs.getInt("id_entrenador") + "\n" +
                rs.getString("nombre") + "\n" +
                rs.getInt("pokedollars") + "\n" +
                rs.getString("pokemons") + "\n" +
                rs.getString("pokemons_caja"));
        */
        return new Entrenador(rs.getInt("id_entrenador"),
                rs.getString("nombre"));
    }

    private String entrenadorToInsert(Entrenador entrenador) throws SQLException{
        //TODO
        return "";
    }

    @Override
    public void create(Entrenador assistant) throws SQLException {
        //TODO
    }

    @Override
    public boolean delete(Entrenador assistant) throws SQLException {
        //TODO
        return false;
    }

    @Override
    public void updateProfile(Entrenador assistant) throws SQLException {
        statement.executeUpdate("UPDATE ENTRENADOR" +
                " SET NOMBRE=" + assistant.getNombre() +
                " WHERE codEquipo = " + assistant.getId());
    }

    @Override
    public Entrenador get(int id) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM ENTRENADOR WHERE ID_ENTRENADOR="+id);
        Entrenador e = resultToEntrenador(rs);
        return e;
    }

    @Override
    public List<Entrenador> getAll() throws SQLException {
        ArrayList<Entrenador> entrenadores = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM ENTRENADOR");
        while (rs.next()){
            entrenadores.add(resultToEntrenador(rs));
        }
        statement.close();
        return entrenadores;
    }


}
