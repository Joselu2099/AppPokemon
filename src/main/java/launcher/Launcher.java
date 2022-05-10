package launcher;

import controller.AppPokemon;
import model.EntrenadorRepository;
import persistence.AppPokemonDAOFactory;
import persistence.DAOFactory;

import java.sql.*;

public class Launcher {
    public static void main(String[] args) {
        AppPokemon.getINSTANCE();

        //DAOFactory daoFactory = new AppPokemonDAOFactory();
        //daoFactory.cerrarConexion();
        System.out.println(EntrenadorRepository.getINSTANCE().generarEntrenadorRandom(50));
    }
}
