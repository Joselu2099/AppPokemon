package launcher;

import controller.AppPokemon;
import model.EntrenadorRepository;
import persistence.DAOFactory;
import persistence.EntrenadorDAO;
import java.sql.*;

public class Launcher {
    public static void main(String[] args) {
        AppPokemon.getINSTANCE();

        System.out.println(EntrenadorRepository.getINSTANCE().getEntrenadores());

        //DAOFactory daoFactory = new AppPokemonDAOFactory();
        //daoFactory.cerrarConexion();

        try {
            EntrenadorDAO entrenadorDAO = DAOFactory.getINSTANCE().getEntrenadorDAO();
            System.out.println(entrenadorDAO.get(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DAOFactory.getINSTANCE().cerrarConexion();

        //System.out.println(EntrenadorRepository.getINSTANCE().generarEntrenadorRandom(50));


    }
}
