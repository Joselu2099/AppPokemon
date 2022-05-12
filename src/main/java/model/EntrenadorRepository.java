package model;

import model.utils.ModelUtils;
import model.utils.NombresEntrenador;
import persistence.DAOFactory;
import persistence.EntrenadorDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EntrenadorRepository {

    private static EntrenadorRepository INSTANCE;

    private Map<String, Entrenador> altosMando;
    private Map<Integer, Entrenador> entrenadores;
    private EntrenadorDAO entrenadorDAO;

    private EntrenadorRepository() {
        entrenadores = new HashMap<>();
        entrenadorDAO = DAOFactory.getINSTANCE().getEntrenadorDAO();
        this.loadRepository();
    }

    public static EntrenadorRepository getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new EntrenadorRepository();
        return INSTANCE;
    }

    private void loadRepository() {
        getEntrenador(1);
        try {
            entrenadorDAO.getAll().forEach(e -> entrenadores.put(e.getId(), e));
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
        Entrenador e = null;
        try {
            e = entrenadorDAO.get(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if(!entrenadores.containsValue(e))
            entrenadores.put(e.getId(), e);
        return e;
    }

    public Entrenador getEntrenador(String nombre) {
        Entrenador e = null;
        try {
            e = entrenadorDAO.get(nombre);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if(!entrenadores.containsValue(e))
            entrenadores.put(e.getId(), e);
        return e;
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
