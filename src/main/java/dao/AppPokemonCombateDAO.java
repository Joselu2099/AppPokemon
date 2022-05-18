package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.combate.Combate;

public class AppPokemonCombateDAO implements CombateDAO {
	private static AppPokemonCombateDAO INSTANCE = null;
    private final Connection connection;
    private Statement statement;

    private AppPokemonCombateDAO() {
        this.connection = DAOFactory.getINSTANCE().getConnection();
        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Aplicamos el patron Singleton.
    public static synchronized AppPokemonCombateDAO getInstance() {
        if (INSTANCE == null)
            INSTANCE = new AppPokemonCombateDAO();
        return INSTANCE;
    }

    private Combate resultToCombate(ResultSet rs) throws SQLException{
        //TODO
       /* Combate  ent = new Combate(rs.getString("jugador"),
                rs.getString("rival"));*/
        return new Combate();
    }
	 
	@Override
	public void create(Combate assistant) throws SQLException {
		 statement.executeUpdate("INSERT INTO COMBATE(JUGADOR,RIVAL,GANADOR,TURNOS,POKEMON_KO_JUGADOR,POKEMON_KO_RIVAL)" +
	                " VALUES('" + assistant.getJugador() + "', '" + assistant.getRival() +"', '" + assistant.getGanador() +"', "
	                		+ "" + assistant.getTurnos() +", '" + assistant.getPokemonsKOJugador() +"', '" + assistant.getPokemonsKORival() +"')");
	}

	@Override
	public void delete(Combate assistant) throws SQLException {
		statement.executeUpdate("DELETE FROM COMBATE WHERE ID_COMBATE ="+ assistant.getId());		
	}

	@Override
	public void updateProfile(Combate assistant) throws SQLException {
		statement.executeUpdate("UPDATE COMBATE" +
                " SET JUGADOR='" + assistant.getJugador() +"'"+
                " WHERE ID_COMBATE = " + assistant.getId());
        statement.executeUpdate("UPDATE COMBATE" +
                " SET RIVAL='" + assistant.getRival() +"'"+
                " WHERE ID_COMBATE = " + assistant.getId());
        statement.executeUpdate("UPDATE COMBATE" +
                " SET GANADOR='" + assistant.getGanador() +"'"+
                " WHERE ID_COMBATE = " + assistant.getId());
        statement.executeUpdate("UPDATE COMBATE" +
                " SET TURNOS=" + assistant.getTurnos() +
                " WHERE ID_COMBATE = " + assistant.getId());
        statement.executeUpdate("UPDATE COMBATE" +
                " SET POKEMON_KO_JUGADOR='" + assistant.getPokemonsKOJugador() +"'"+
                " WHERE ID_COMBATE = " + assistant.getId());
        statement.executeUpdate("UPDATE COMBATE" +
                " SET POKEMON_KO_RIVAL='" + assistant.getPokemonsKORival() +"'"+
                " WHERE ID_COMBATE = " + assistant.getId());		
	}

	@Override
	public Combate get(int id) throws SQLException {
		ArrayList<Combate> combates = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM COMBATE WHERE ID_COMBATE="+id);
        while (rs.next()){
            combates.add(resultToCombate(rs));
        }
        combates.forEach(e-> System.out.println(e));
        return combates.get(0);		
	}

	@Override
	public List<Combate> getAll() throws SQLException {
		 ArrayList<Combate> combates = new ArrayList<>();
	        ResultSet rs = statement.executeQuery("SELECT * FROM COMBATE");
	        while (rs.next()){
	            combates.add(resultToCombate(rs));
	        }
	        return combates;		
	}

}
