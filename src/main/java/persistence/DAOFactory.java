package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DAO abstract factory.
 */

public abstract class DAOFactory {

    public static final String DAO = "dao.AppPokemonDAOFactory";

    private static DAOFactory INSTANCE = null;
    private final String URL = "jdbc:mysql://localhost:3306/pokemon";
    private final String LOGIN = "root";
    private final String PASSWORD = "";
    private Connection connection;


    protected DAOFactory() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL,LOGIN,PASSWORD);
            System.out.println("Conexion establecida");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Crea un tipo de factoria DAO.
     * Solo existe el tipo FactoriaDAO
     */
    @SuppressWarnings("deprecation")
    public static synchronized DAOFactory getInstance(String type) throws DAOException {
        if (INSTANCE == null)
            try {
                INSTANCE = (DAOFactory) Class.forName(type).newInstance();
            } catch (Exception e) {
                throw new DAOException(e.getMessage());
            }
        return INSTANCE;
    }

    public static DAOFactory getINSTANCE() throws DAOException {
        return getInstance(DAOFactory.DAO);
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
        return connection;
    }

    // Metodos factoria para obtener adaptadores

    public abstract EntrenadorDAO getEntrenadorDAO();

    public abstract PokemonDAO getPokemonDAO();

    public abstract MovimientoDAO getMovimientoDAO();

    public abstract CombateDAO getCombateDAO();

    public abstract TurnoDAO getTurnoDAO();

}