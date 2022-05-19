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
        return new Combate(rs.getInt("id_combate"),
        		UtilsDAO.idToEntrenador(rs.getInt("jugador")),
        		UtilsDAO.idToEntrenador(rs.getInt("rival")),
        		UtilsDAO.idToEntrenador(rs.getInt("ganador")),
        		UtilsDAO.turnosFromCombate(rs.getInt("combate")),
        		UtilsDAO.idsToPokemons(rs.getString("pokemon_ko_jugador")),
        		UtilsDAO.idsToPokemons(rs.getString("pokemon_ko_rival")));
    }
	 
	@Override
	public void create(Combate assistant) throws SQLException {
		 statement.executeUpdate("INSERT INTO COMBATE(JUGADOR,RIVAL,GANADOR,POKEMON_KO_JUGADOR,POKEMON_KO_RIVAL)" +
	                " VALUES(" + assistant.getJugador().getId() + ", " + assistant.getRival().getId() +", " + assistant.getGanador().getId()
	                +", '"+ UtilsDAO.pokemonsToString(assistant.getPokemonsKOJugador()) +"', '" + UtilsDAO.pokemonsToString(assistant.getPokemonsKORival()) +"')");
	}

	@Override
	public void delete(Combate assistant) throws SQLException {
		statement.executeUpdate("DELETE FROM COMBATE WHERE ID_COMBATE ="+ assistant.getId());		
	}

	@Override
	public Combate get(int id) throws SQLException {
		ArrayList<Combate> combates = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM COMBATE WHERE ID_COMBATE="+id);
        while (rs.next()){
            combates.add(resultToCombate(rs));
        }
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
