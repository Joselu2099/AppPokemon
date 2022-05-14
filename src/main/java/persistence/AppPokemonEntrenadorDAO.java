package persistence;

import model.entrenador.*;
import model.pokemon.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        //TODO
        return new Entrenador(rs.getInt("id_entrenador"),
                rs.getString("nombre"));
    }

    @Override
    public Entrenador create(Entrenador assistant) throws SQLException {
        statement.executeUpdate("INSERT INTO ENTRENADOR(NOMBRE,POKEDOLLARS)" +
                " VALUES('" + assistant.getNombre() + "', " + assistant.getPokedollars() +")");
        return get(assistant.getNombre());
    }

    @Override
    public void delete(Entrenador assistant) throws SQLException {
        statement.executeUpdate("DELETE FROM ENTRENADOR WHERE ID_ENTRENADOR ="+ assistant.getId());
    }

    @Override
    public void updateProfile(Entrenador assistant) throws SQLException {
        statement.executeUpdate("UPDATE ENTRENADOR" +
                " SET NOMBRE='" + assistant.getNombre() +"'"+
                " WHERE ID_ENTRENADOR = " + assistant.getId());
        statement.executeUpdate("UPDATE ENTRENADOR" +
                " SET POKEDOLLARS=" + assistant.getPokedollars() +
                " WHERE ID_ENTRENADOR = " + assistant.getId());
        statement.executeUpdate("UPDATE ENTRENADOR" +
                " SET POKEMONS='" + UtilsDAO.listToString(assistant.getPokemons().stream().map(Pokemon::getId).collect(Collectors.toList())) +"'"+
                " WHERE ID_ENTRENADOR = " + assistant.getId());
        statement.executeUpdate("UPDATE ENTRENADOR" +
                " SET POKEMONS_CAJA='" + UtilsDAO.listToString(assistant.getCajaPokemon().stream().map(Pokemon::getId).collect(Collectors.toList())) +"'"+
                " WHERE ID_ENTRENADOR = " + assistant.getId());
    }

    @Override
    public Entrenador get(int id) throws SQLException {
        ArrayList<Entrenador> entrenadores = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM ENTRENADOR WHERE ID_ENTRENADOR="+id);
        while (rs.next()){
            entrenadores.add(resultToEntrenador(rs));
        }
        if(entrenadores.size()>0) return entrenadores.get(0);
        return null;
    }

    public Entrenador get(String nombre) throws SQLException {
        ArrayList<Entrenador> entrenadores = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM ENTRENADOR WHERE NOMBRE='"+nombre+"'");
        while (rs.next()){
            entrenadores.add(resultToEntrenador(rs));
        }
        if(entrenadores.size()>0) return entrenadores.get(0);
        return null;
    }

    @Override
    public List<Entrenador> getAll() throws SQLException {
        ArrayList<Entrenador> entrenadores = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM ENTRENADOR");
        while (rs.next()){
            entrenadores.add(resultToEntrenador(rs));
        }
        return entrenadores;
    }


}
