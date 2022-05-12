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
        return entrenadores.get(id);
    }

    public void addEntrenador(Entrenador entrenador){
        entrenadores.put(entrenador.getId(), entrenador);
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
