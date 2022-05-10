package persistence;

import model.Entrenador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Clase que implementa el Adaptador DAO concreto de Usuario para el tipo H2.
 */
public final class AppPokemonEntrenadorDAO implements EntrenadorDAO {

    private static AppPokemonEntrenadorDAO INSTANCE = null;

    Connection connection;

    // Se obtiene la instancia del servicio de persistencia
    private AppPokemonEntrenadorDAO() {
        try {
            connection = DAOFactory.getINSTANCE().getConnection();
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    // Aplicamos el patron Singleton.
    public static synchronized AppPokemonEntrenadorDAO getInstance() {
        if (INSTANCE == null)
            INSTANCE = new AppPokemonEntrenadorDAO();
        return INSTANCE;
    }

    private Entrenador entityToEntrenador(){
        Entrenador entrenador = new Entrenador();
        //TODO
        return entrenador;
    }

    private String entrenadorToEntity(Entrenador entrenador){
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
        //TODO
    }

    @Override
    public Entrenador get(int id) throws SQLException {
        //SELECT * FROM ENTRENADOR WHERE ID_ENTRENADOR=ID
        String query = "SELECT * FROM ENTRENADOR WHERE ID_ENTRENADOR="+id;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        String nombre = rs.getString("nombre");
        return new Entrenador(nombre);

    }

    @Override
    public List<Entrenador> getAll() throws SQLException {
        return null;
    }
}
