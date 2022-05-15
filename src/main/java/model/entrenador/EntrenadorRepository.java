package model.entrenador;

import model.pokemon.PokemonRepository;
import model.utils.ModelUtils;
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

    public boolean addEntrenador(Entrenador entrenador){
        try {
            entrenadorDAO.create(entrenador);
            entrenadores.put(entrenador.getId(), entrenador);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addEntrenadores(ArrayList<Entrenador> entrenadoresIn){
        entrenadoresIn.forEach(e -> entrenadores.put(e.getId(), e));
    }

    public Entrenador generarEntrenadorRandom(int nivelEquipo){
        return new Entrenador(NombresEntrenador.fromId(ModelUtils.generarNumRandom(1,NombresEntrenador.NUM_NOMBRES)), PokemonRepository.getINSTANCE().generarEquipoPokemon(nivelEquipo));
    }

    public void generarAltosMando(){

    }
}
