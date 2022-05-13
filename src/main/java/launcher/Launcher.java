package launcher;

import controller.AppPokemon;
import gui.AppPokemonGUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;

public class Launcher {
    public static void main(String[] args) {
        //AppPokemon.getINSTANCE();
        AppPokemonGUI.getINSTANCE(args);
       

        /*
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
        */

    }
}
