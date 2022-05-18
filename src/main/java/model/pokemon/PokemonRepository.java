package model.pokemon;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import dao.DAOFactory;
import dao.PokemonDAO;
import eu.iamgio.pokedex.Generation;
import eu.iamgio.pokedex.pokemon.PokemonType;
import model.entrenador.Entrenador;
import model.movimiento.Movimiento;
import model.movimiento.MovimientosRepository;
import model.utils.ModelUtils;

public class PokemonRepository {

    private static PokemonRepository INSTANCE;
    private static final int NUM_POKEMONS = Generation.GENERATION_I.load().getPokemonNames().size();

    private PokemonDAO pokemonDAO;
    private Map<Integer, Pokemon> pokemons;

    private PokemonRepository() {
    	pokemonDAO = DAOFactory.getINSTANCE().getPokemonDAO();
        pokemons = new HashMap<Integer, Pokemon>();
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
        ArrayList<Movimiento> mvs = (ArrayList<Movimiento>) getMovimientoForPokemon(pk);
        pk.aprenderMovimiento(mvs.get(ModelUtils.generarNumRandom(0, mvs.size()-1)));
        pokemons.put(pk.getId(), pk);
        return pk;
    }

    public Pokemon getPokemonBase(String nombre) {
        Pokemon pk = ModelUtils.parsePokemon(nombre.toLowerCase());
        if(pokemons.containsValue(pk)) return pk;
        ArrayList<Movimiento> mvs = (ArrayList<Movimiento>) getMovimientoForPokemon(pk);
        pk.aprenderMovimiento(mvs.get(ModelUtils.generarNumRandom(0, mvs.size()-1)));
        pokemons.put(pk.getId(), pk);
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

    public ArrayList<Pokemon> generarEquipoPokemon(Entrenador e, int nivel){
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
        	Pokemon poke = generarPokemonRandom(nivel);
        	poke.setEntrenador(e);
        	for (int j = 0; j < 3; j++) {
        		ArrayList<Movimiento> mvs = (ArrayList<Movimiento>) getMovimientoForPokemon(poke);
        		poke.aprenderMovimiento(mvs.get(ModelUtils.generarNumRandom(0, mvs.size()-1)));
    		}
            pokemons.add(poke);
        }
        return pokemons;
    }
    
    public List<Movimiento> getMovimientoForPokemon(Pokemon pk){
    	return MovimientosRepository.getINSTANCE().getMovimientosOfType(pk.getTipos().getFirst(), pk.getTipos().getSecond());
    }
    
    public List<Movimiento> getMovimientoForType(PokemonType tipo1, PokemonType tipo2){
    	return MovimientosRepository.getINSTANCE().getMovimientosOfType(tipo1, tipo2);
    }
}
