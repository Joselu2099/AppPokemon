package model.pokemon;

import eu.iamgio.pokedex.Generation;
import model.movimiento.Movimiento;
import model.movimiento.MovimientosRepository;
import model.utils.ModelUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dao.DAOFactory;
import dao.PokemonDAO;

public class PokemonRepository {

    private static PokemonRepository INSTANCE;
    private static final int NUM_POKEMONS = Generation.GENERATION_I.load().getPokemonNames().size();

    private PokemonDAO pokemonDAO;
    private Map<Integer, Pokemon> pokemons;

    private PokemonRepository() {
    	pokemonDAO = DAOFactory.getINSTANCE().getPokemonDAO();
        pokemons = new HashMap<>();
    }

    public static PokemonRepository getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new PokemonRepository();
        return INSTANCE;
    }
    
    public Pokemon getPokemon(int id) {
    	try {
			return pokemonDAO.get(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public boolean addPokemonToBD(Pokemon pokemon) {
    	try {
			pokemonDAO.create(pokemon);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    }
    
    public ArrayList<Pokemon> getPokemonsBase() {
        return new ArrayList<Pokemon>(pokemons.values());
    }

    public Pokemon getPokemonBase(int id) {
        if(pokemons.containsKey(id))
            return pokemons.get(id);
        Pokemon pk = ModelUtils.parsePokemon(id);
        pokemons.put(pk.getId(), pk);
        ArrayList<Movimiento> mvs = MovimientosRepository.getINSTANCE().getMovimientosOfType(pk.getTipos().getFirst(), pk.getTipos().getSecond());
        pk.aprenderAtaque(mvs.get(ModelUtils.generarNumRandom(0, mvs.size()-1)));
        return pk;
    }

    public Pokemon getPokemonBase(String nombre) {
        Pokemon pk = ModelUtils.parsePokemon(nombre.toLowerCase());
        if(pokemons.containsValue(pk)) return pk;
        pokemons.put(pk.getId(), pk);
        ArrayList<Movimiento> mvs = MovimientosRepository.getINSTANCE().getMovimientosOfType(pk.getTipos().getFirst(), pk.getTipos().getSecond());
        pk.aprenderAtaque(mvs.get(ModelUtils.generarNumRandom(0, mvs.size())));
        return pk;
    }
    
    public Pokemon generarPokemonRandom() {
        return getPokemonBase(ModelUtils.generarNumRandom(1,NUM_POKEMONS));
    }

    public Pokemon generarPokemonRandom(int nivel) {
        Pokemon pk = getPokemonBase(ModelUtils.generarNumRandom(1,NUM_POKEMONS));
        for (int i = 0; i < nivel; i++) {
            pk.subirNivel();
        }
        return pk;
    }

    public Pokemon generarPokemon(String nombre, int nivel) {
        Pokemon pk = getPokemonBase(nombre);
        for (int i = 0; i < nivel; i++) {
            pk.subirNivel();
        }
        return pk;
    }

    public ArrayList<Pokemon> generarEquipoPokemon(int nivel){
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            pokemons.add(generarPokemonRandom(nivel));
        }
        return pokemons;
    }
}
