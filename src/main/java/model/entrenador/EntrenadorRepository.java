package model.entrenador;

import model.pokemon.PokemonRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import dao.DAOFactory;
import dao.EntrenadorDAO;

public class EntrenadorRepository {

    private static EntrenadorRepository INSTANCE;

    private Map<String, Entrenador> altosMando;
    private Map<Integer, Entrenador> entrenadores;
    private EntrenadorDAO entrenadorDAO;

    private EntrenadorRepository() {
        entrenadores = new HashMap<>();
        altosMando = new HashMap<>();
        entrenadorDAO = DAOFactory.getINSTANCE().getEntrenadorDAO();
        this.loadRepository();
    }

    public static EntrenadorRepository getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new EntrenadorRepository();
        return INSTANCE;
    }

    private void loadRepository() {
        try {
            entrenadorDAO.getAll().forEach(e -> {
            	if(e.getNombre().equals("Knekro") || e.getNombre().equals("Red") || e.getNombre().equals("Blue"))
            		altosMando.put(e.getNombre(), e);
            	else entrenadores.put(e.getId(), e);
            });
        } catch (SQLException e) {
        	System.err.println("Base de datos sin conexion :(");
            e.printStackTrace();
        }
    }
    
    public ArrayList<Entrenador> getEntrenadores() {
        return new ArrayList<Entrenador>(entrenadores.values());
    }

    public void setEntrenadores(Map<Integer, Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    public Entrenador getEntrenador(int id) {
    	if(entrenadores.containsKey(id)) 
    		return entrenadores.get(id);
    	return null;
    }

    public Entrenador getEntrenador(String nombre) {
    	for(Entrenador entrenador: entrenadores.values()) {
    		if(entrenador.getNombre().equals(nombre)) 
    			return entrenador;
    	}
    	return null;
    }

    public Entrenador addEntrenador(Entrenador entrenador){
        try {
            entrenador = entrenadorDAO.create(entrenador);
            entrenadores.put(entrenador.getId(), entrenador);
            return entrenador;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addEntrenadores(ArrayList<Entrenador> entrenadoresIn){
        entrenadoresIn.forEach(e -> entrenadores.put(e.getId(), e));
    }

    public Entrenador generarEntrenadorRandom(int nivelEquipo){
    	Entrenador random = new Entrenador(NombresEntrenador.generarNombreRandom());
    	random.setPokemons(PokemonRepository.getINSTANCE().generarEquipoPokemon(random, nivelEquipo));
        return random;
    }

    public Map<String, Entrenador> getAltosMando() {
		return altosMando;
	}
    
    public boolean existAltoMando(String nombre) {
    	return altosMando.containsKey(nombre);
    }
}
