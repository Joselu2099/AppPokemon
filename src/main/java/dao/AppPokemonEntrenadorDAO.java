package dao;

import model.entrenador.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
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
    	return new Entrenador(rs.getInt("id_entrenador"),
                rs.getString("nombre"),
                rs.getInt("pokedollars"), 
    			UtilsDAO.pokemonsEquipoFromEntrenador(rs.getInt("id_entrenador")),
    			UtilsDAO.pokemonsCajaFromEntrenador(rs.getInt("id_entrenador")),
    			UtilsDAO.combatesFromEntrenador(rs.getInt("id_entrenador")));
    }

    @Override
    public Entrenador create(Entrenador assistant) throws SQLException {
        statement.executeUpdate("INSERT INTO ENTRENADOR(NOMBRE,POKEDOLLARS)" +
                " VALUES('" + assistant.getNombre() + "', " + assistant.getPokedollars() +")");
        return getLast();
    }

    @Override
    public void delete(Entrenador assistant) throws SQLException {
        statement.executeUpdate("DELETE FROM ENTRENADOR WHERE ID_ENTRENADOR ="+ assistant.getId());
    }

    @Override
    public void updateProfile(Entrenador assistant) throws SQLException {
        statement.executeUpdate("UPDATE ENTRENADOR" +
                " SET POKEDOLLARS=" + assistant.getPokedollars() +
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
    
    @Override
    public Entrenador getLast() throws SQLException {
        ArrayList<Entrenador> entrenadores = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM ENTRENADOR ORDER BY ID_ENTRENADOR DESC LIMIT 1");
        while (rs.next()){
            entrenadores.add(resultToEntrenador(rs));
        }
        if(entrenadores.size()>0) return entrenadores.get(0);
        return null;
    }
    
    @Override
    public List<Entrenador> getAll() throws SQLException {
        LinkedList<Entrenador> entrenadores = new LinkedList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM ENTRENADOR");
        while (rs.next()){
            entrenadores.add(resultToEntrenador(rs));
        }
        return entrenadores;
    }


}
