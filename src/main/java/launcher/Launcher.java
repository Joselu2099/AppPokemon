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

        /*
        String URL = "jdbc:mysql://localhost:3306/pokemon";
        String LOGIN = "root";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL,LOGIN,"");
            System.out.println("Conexion establecida");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (NullPointerException n){
                n.printStackTrace();
            }
        }

        */
    }
}
