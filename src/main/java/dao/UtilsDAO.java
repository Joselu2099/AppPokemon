package dao;

import model.combate.Turno;
import model.entrenador.Entrenador;
import model.entrenador.EntrenadorRepository;
import model.movimiento.*;
import model.pokemon.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import eu.iamgio.pokedex.pokemon.PokemonType;

public class UtilsDAO {
    public static void crearModificar(String query) throws SQLException {
        Statement statement = DAOFactory.getINSTANCE().getConnection().createStatement();
        statement.executeUpdate(query);
        statement.close();
    }

    public static void inserts(List<String> querys) throws SQLException {
        Statement statement = DAOFactory.getINSTANCE().getConnection().createStatement();
        for(String query: querys){
            statement.executeUpdate(query);
        }
        statement.close();
    }

    public static ResultSet consultar(String query) throws SQLException {
        Statement statement = DAOFactory.getINSTANCE().getConnection().createStatement();
        ResultSet rs = statement.executeQuery(query);
        statement.close();
        return rs;
    }

    public static Integer safeValueOf(String s) {
        try {
            return Integer.valueOf(s);
        } catch (NumberFormatException | NullPointerException ignored) {
        }
        return null;
    }

    public static List<Integer> stringToList(String union) {
        return union != null ? Arrays.stream(union.split(",")).map(UtilsDAO::safeValueOf).filter(Objects::nonNull).collect(Collectors.toList()) : new ArrayList<>();
    }

    public static String listToString(List<Integer> ids) {
        return ids != null ? ids.stream().map(i -> Integer.toString(i)).collect(Collectors.joining(",")) : "";
    }

    public static List<String> splitString(String s) {
        return s == null ? new ArrayList<>() : Arrays.stream(s.split(",")).collect(Collectors.toList());
    }

    public static String joinString(List<String> list) {
        return list == null ? "" : String.join(",", list);
    }

    public static List<Pokemon> idsToPokemons(String ids){
    	List<Integer> listIds = stringToList(ids);
    	PokemonDAO pokemonDAO = DAOFactory.getINSTANCE().getPokemonDAO();
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        for(Integer id: listIds){
        	try {
				pokemons.add(pokemonDAO.get(id));
			} catch (SQLException e) {
				System.err.println("Pokemon no encontrado (idsToPokemons:UtilsDAO)");
			}
        }
        return pokemons;
    }
    
    public static String pokemonsToString(List<Pokemon> pokemons) {
        return listToString(pokemons.stream().map(pk -> pk.getId()).collect(Collectors.toList()));
    }
    
    public static List<Turno> turnosFromCombate(int idCombate){
    	TurnoDAO turnoDAO = DAOFactory.getINSTANCE().getTurnoDAO();
    	try {
			return turnoDAO.getTurnosFromCombate(idCombate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return new LinkedList<Turno>();
    }
    
    public static List<Movimiento> idsToMovimientos(int id1, int id2, int id3, int id4){
    	ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
    	if(id1!=0) movimientos.add(MovimientosRepository.getINSTANCE().getMovimiento(id1));
    	if(id2!=0) movimientos.add(MovimientosRepository.getINSTANCE().getMovimiento(id2));
    	if(id3!=0) movimientos.add(MovimientosRepository.getINSTANCE().getMovimiento(id3));
    	if(id4!=0) movimientos.add(MovimientosRepository.getINSTANCE().getMovimiento(id4));
    	return movimientos;
    }
    
    public static Movimiento idToMovimiento(int id) {
		if(id!=0) return MovimientosRepository.getINSTANCE().getMovimiento(id);
		return new MovimientoNull();
	}
    
    public static Entrenador idToEntrenador(int id) {
    	if(id!=0) return EntrenadorRepository.getINSTANCE().getEntrenador(id);
    	return new Entrenador();
    }
    	
    
    public static PokemonType stringToPokemonType(String str) {
    	if(str==null) return PokemonType.UNKNOWN;
    	switch (str.toUpperCase()){
	        case "STEEL":
	            return PokemonType.STEEL;
	        case "WATER":
	            return PokemonType.WATER;
	        case "BUG":
	            return PokemonType.BUG;
	        case "DRAGON":
	            return PokemonType.DRAGON;
	        case "ELECTRIC":
	            return PokemonType.ELECTRIC;
	        case "GHOST":
	            return PokemonType.GHOST;
	        case "FIRE":
	            return PokemonType.FIRE;
	        case "FAIRY":
	            return PokemonType.FAIRY;
	        case "ICE":
	            return PokemonType.ICE;
	        case "FIGHTING":
	            return PokemonType.FIGHTING;
	        case "NORMAL":
	            return PokemonType.NORMAL;
	        case "GRASS":
	            return PokemonType.GRASS;
	        case "PSYCHIC":
	            return PokemonType.PSYCHIC;
	        case "ROCK":
	            return PokemonType.ROCK;
	        case "DARK":
	            return PokemonType.DARK;
	        case "GROUND":
	            return PokemonType.GROUND;
	        case "POISON":
	            return PokemonType.POISON;
	        case "FLYING":
	            return PokemonType.FLYING;
	        case "UNKNOWN":
	        default:
	            return PokemonType.UNKNOWN;
    	}
    }
    
    public static String pokemonTypeToString(PokemonType type) {
    	return type.toString();
    }
    
    public static Estado stringToEstado(String str) {
    	switch(str.toUpperCase()) {
	    	case "PARALIZADO":
	    		return Estado.PARALIZADO;
	    	case "DORMIDO":
	    		return Estado.DORMIDO;
	    	case "QUEMADO":
	    		return Estado.QUEMADO;
	    	case "ENVENENADO":
	    		return Estado.ENVENENADO;
	    	case "CONFUSO":
	    		return Estado.CONFUSO;
	    	case "CONGELADO":
	    		return Estado.CONGELADO;
	    	case "SIN_ESTADO":
	    	default:
	    		return Estado.SIN_ESTADO;
    	}
    }
    
    public static String estadoToString(Estado estado) {
    	return estado.toString();
    }
    
    public static TipoMejora stringToTipoMejora(String str) {
    	switch(str.toUpperCase()) {
	    	case "ATAQUE":
	    		return TipoMejora.ATAQUE;
	    	case "DEFENSA":
	    		return TipoMejora.DEFENSA;
	    	case "ATAQUE_ESP":
	    		return TipoMejora.ATAQUE_ESP;
	    	case "DEFENSA_ESP":
	    		return TipoMejora.DEFENSA_ESP;
	    	case "VELOCIDAD":
	    		return TipoMejora.VELOCIDAD;
	    	case "VITALIDAD":
	    		return TipoMejora.VITALIDAD;
	    	case "UNKNOWN":
	    	default:
	    		return TipoMejora.UNKNOWN;
    	}
    }
    
    public static String tipoMejoraToString(TipoMejora tipoMejora) {
    	return tipoMejora.toString();
    }
}
