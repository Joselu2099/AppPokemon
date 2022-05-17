package dao;

import model.entrenador.Entrenador;
import model.movimiento.Movimiento;
import model.pokemon.Pokemon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import eu.iamgio.pokedex.pokemon.PokemonType;
import eu.iamgio.pokedex.util.Pair;

public class AppPokemonPokemonDAO implements PokemonDAO{

    private static AppPokemonPokemonDAO INSTANCE = null;
    private final Connection connection;
    private Statement statement;

    private AppPokemonPokemonDAO() {
        this.connection = DAOFactory.getINSTANCE().getConnection();
        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized AppPokemonPokemonDAO getInstance() {
        if (INSTANCE == null)
            INSTANCE = new AppPokemonPokemonDAO();
        return INSTANCE;
    }
    private Pokemon resultToPokemon(ResultSet rs) throws SQLException{  
	    Pair<PokemonType, PokemonType> tipos = new Pair<PokemonType, PokemonType>(UtilsDAO.stringToPokemonType(rs.getString("tipo1")), UtilsDAO.stringToPokemonType(rs.getString("tipo2")));
	    return new Pokemon(rs.getInt("id_Pokemon"),
	            rs.getString("nombre"),
	            rs.getString("mote"),
	            rs.getInt("vitalidad"),
	            rs.getInt("ataque"),
	            rs.getInt("defensa"),
	            rs.getInt("ataque_esp"),
	            rs.getInt("defensa_esp"),
	            rs.getInt("velocidad"),
	            rs.getInt("estamina"),
	            rs.getInt("nivel"),
	            rs.getInt("experiencia"),
	            (ArrayList<Movimiento>)UtilsDAO.idsToMovimientos(rs.getInt("movimiento1"), rs.getInt("movimiento2"), rs.getInt("movimiento3"), rs.getInt("movimiento4")),
	            rs.getInt("fertilidad"),
	            tipos,
	            UtilsDAO.stringToEstado(rs.getString("estado")),
	            rs.getString("sprite"),
	            rs.getString("equipo_caja"));
    }

    @Override
    public Pokemon create(Pokemon assistant) throws SQLException {
    	String camposInserted = "";
    	String mvsInserted = "";
    	for (int i = 0; i < assistant.getMovimientos().size(); ) {
			mvsInserted+=", "+assistant.getMovimientos().get(i).getId();
			i++;
			camposInserted+=", MOVIMIENTO" + i;
		}
    	String query = "INSERT INTO POKEMON(NOMBRE, MOTE, VITALIDAD, ATAQUE, DEFENSA, ATAQUE_ESP, DEFENSA_ESP, VELOCIDAD, ESTAMINA, NIVEL" + camposInserted +", TIPO1, TIPO2, ESTADO, SPRITE, ENTRENADOR, EQUIPO_CAJA)" +
    	        " VALUES('" + assistant.getNombre() 
    	        + "', '" + assistant.getMote() 
    	        +"', " + assistant.getVitalidad() 
    	        +", " + assistant.getAtaque() 
    	        +", " + assistant.getDefensa() 
    	        +", " + assistant.getAtaqueEspecial() 
    	        +", " + assistant.getDefensaEspecial() 
    	        +", " + assistant.getVelocidad() 
    	        +", " + assistant.getEstamina() 
    	        +", " + assistant.getNivel() 
    	        + mvsInserted 
    	        + ", '"+UtilsDAO.pokemonTypeToString(assistant.getTipos().getFirst()) 
    	        +"', '" + UtilsDAO.pokemonTypeToString(assistant.getTipos().getSecond())
    	        +"', '" + UtilsDAO.estadoToString(assistant.getEstado()) 
    	        +"', '" + assistant.getSprite()
    	        +"', " + assistant.getEntrenador().getId() 
    	        +", '" + assistant.getEquipoCaja() +"')";
    	System.out.println(query);
    	statement.executeUpdate(query);
        return getLast();
    }

    @Override
    public void delete(Pokemon assistant) throws SQLException {
        statement.executeUpdate("DELETE FROM POKEMON WHERE ID_POKEMON ="+ assistant.getId());
    }

    @Override
    public void updateProfile(Pokemon assistant) throws SQLException {
	    //TODO
	    statement.executeUpdate("UPDATE POKEMON" +
	        " SET NOMBRE='" + assistant.getNombre() +"'"+
	        " WHERE ID_POKEMON = " + assistant.getId());
	    statement.executeUpdate("UPDATE POKEMON" +
	        " SET MOTE=" + assistant.getMote() +
	        " WHERE ID_POKEMON = " + assistant.getId());
	    statement.executeUpdate("UPDATE POKEMON" +
	        " SET VITALIDAD=" + assistant.getVitalidad() +
	        " WHERE ID_POKEMON = " + assistant.getId());
	    statement.executeUpdate("UPDATE POKEMON" +
	        " SET ATAQUE=" + assistant.getAtaque() +
	        " WHERE ID_POKEMON = " + assistant.getId());
	    statement.executeUpdate("UPDATE POKEMON" +
	        " SET DEFENSA=" + assistant.getDefensa() +
	        " WHERE ID_POKEMON = " + assistant.getId());
	    statement.executeUpdate("UPDATE POKEMON" +
	        " SET ATAQUE_ESP=" + assistant.getAtaqueEspecial() +
	        " WHERE ID_POKEMON = " + assistant.getId());
	    statement.executeUpdate("UPDATE POKEMON" +
	        " SET DEFENSA_ESP=" + assistant.getDefensaEspecial() +
	        " WHERE ID_POKEMON = " + assistant.getId());
	    statement.executeUpdate("UPDATE POKEMON" +
	        " SET VELOCIDAD=" + assistant.getVelocidad() +
	        " WHERE ID_POKEMON = " + assistant.getId());
	    statement.executeUpdate("UPDATE POKEMON" +
	        " SET ESTADO=" + assistant.getEstamina() +
	        " WHERE ID_POKEMON = " + assistant.getId());
	    statement.executeUpdate("UPDATE POKEMON" +
	        " SET NIVEL=" + assistant.getNivel() +
	        " WHERE ID_POKEMON = " + assistant.getId());
	    statement.executeUpdate("UPDATE POKEMON" +
	        " SET EXPERIENCIA=" + assistant.getExperiencia() +
	        " WHERE ID_POKEMON = " + assistant.getId());
	    statement.executeUpdate("UPDATE POKEMON" +
	        " SET MOVIMIENTOS=" + UtilsDAO.listToString(assistant.getMovimientos().stream().map(Movimiento::getId).collect(Collectors.toList())) +"'"+
	        " WHERE ID_POKEMON = " + assistant.getId());
	    statement.executeUpdate("UPDATE POKEMON" +
	        " SET FERTILIDAD=" + assistant.getFertilidad() +
	        " WHERE ID_POKEMON = " + assistant.getId());
	    statement.executeUpdate("UPDATE POKEMON" +
	        " SET TIPO1=" + UtilsDAO.pokemonTypeToString(assistant.getTipos().getFirst()) +
	        " WHERE ID_POKEMON = " + assistant.getId());
	    statement.executeUpdate("UPDATE POKEMON" +
	        " SET TIPO2=" + UtilsDAO.pokemonTypeToString(assistant.getTipos().getSecond()) +
	        " WHERE ID_POKEMON = " + assistant.getId());
	    statement.executeUpdate("UPDATE POKEMON" +
	        " SET ESTADO=" + UtilsDAO.estadoToString(assistant.getEstado()) +
	        " WHERE ID_POKEMON = " + assistant.getId());
	    statement.executeUpdate("UPDATE POKEMON" +
	        " SET SPRITE=" + assistant.getSprite() +
	        " WHERE ID_POKEMON = " + assistant.getId());
    }

    @Override
    public Pokemon get(int id) throws SQLException {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM POKEMON WHERE ID_POKEMON="+id);
        while (rs.next()){
            pokemons.add(resultToPokemon(rs));
        }
        return pokemons.get(0);    
    }
    
    @Override
    public Pokemon getLast() throws SQLException {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM POKEMON ORDER BY ID_POKEMON DESC LIMIT 1");
        while (rs.next()){
            pokemons.add(resultToPokemon(rs));
        }
        return pokemons.get(0);    
    }

  
    @Override
    public List<Pokemon> getAll() throws SQLException {
        LinkedList<Pokemon> pokemons = new LinkedList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM POKEMON");
        while (rs.next()){
            pokemons.add(resultToPokemon(rs));
        }
        return pokemons;    
    }
    
    @Override
    public List<Pokemon> getPokemonsEquipo(Entrenador entrenador) throws SQLException {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM POKEMON WHERE ENTRENADOR="+ entrenador.getId());
        while (rs.next()){
        	if(rs.getString("equipo_caja").equals("EQUIPO"))
        		pokemons.add(resultToPokemon(rs));
        }
        return pokemons;    
    }
    
    @Override
    public List<Pokemon> getPokemonsCaja(Entrenador entrenador) throws SQLException {
        List<Pokemon> pokemons = new LinkedList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM POKEMON WHERE ENTRENADOR="+ entrenador.getId());
        while (rs.next()){
        	if(rs.getString("equipo_caja").equals("CAJA"))
        		pokemons.add(resultToPokemon(rs));
        }
        return pokemons;    
    }
}
