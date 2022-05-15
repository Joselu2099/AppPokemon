package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DAO abstract factory.
 */

public abstract class DAOFactory {

    private static DAOFactory INSTANCE = null;
    private final String URL = "jdbc:mysql://localhost:3306/pokemon";
    private final String LOGIN = "root";
    private final String PASSWORD = "";
    private Connection connection;
    private Statement statement;

    protected DAOFactory() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL,LOGIN,PASSWORD);
            statement = connection.createStatement();
            System.out.println("Conexion establecida");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static DAOFactory getINSTANCE(){
        if (INSTANCE == null) INSTANCE = new AppPokemonDAOFactory();
        return INSTANCE;
    }

    public void cerrarStatment(){
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cerrarConexion(){
        try {
            connection.close();
            System.out.println("Conexion cerrada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    // Metodos factoria para obtener adaptadores

    public abstract EntrenadorDAO getEntrenadorDAO();

    public abstract PokemonDAO getPokemonDAO();

    public abstract MovimientoDAO getMovimientoDAO();

    public abstract CombateDAO getCombateDAO();

    public abstract TurnoDAO getTurnoDAO();

}
