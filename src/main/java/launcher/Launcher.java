package launcher;

import controller.AppPokemon;
import model.EntrenadorRepository;
import persistence.AppPokemonDAOFactory;
import persistence.DAOException;
import persistence.DAOFactory;
import persistence.EntrenadorDAO;

import java.sql.*;
import java.util.Objects;

public class Launcher {
    public static void main(String[] args) {
        AppPokemon.getINSTANCE();

        System.out.println(EntrenadorRepository.getINSTANCE().getEntrenadores());
        /*
        String URL = "jdbc:mysql://localhost:3306/pokemon";
        String LOGIN = "root";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL,LOGIN,"");
            System.out.println("Conexion establecida");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    consultaEquipo(connection, "pokemon");

                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM ENTRENADOR WHERE ID_ENTRENADOR=1");
                    System.out.println(rs.getMetaData().getColumnName(1) + " - " + rs.getMetaData().getColumnType(1) + "\n" +
                            rs.getMetaData().getColumnName(2) + " - " + rs.getMetaData().getColumnType(2) + "\n" +
                            rs.getMetaData().getColumnName(3) + " - " + rs.getMetaData().getColumnType(2) + "\n" +
                            rs.getMetaData().getColumnName(4) + " - " + rs.getMetaData().getColumnType(2) + "\n" +
                            rs.getMetaData().getColumnName(5) + " - " + rs.getMetaData().getColumnType(2));
                    System.out.println(rs.getInt(1) + "\n" +
                            rs.getString(2) + "\n" +
                            rs.getString(3) + "\n" +
                            rs.getString(4) + "\n" +
                            rs.getString(5));
                    statement.close();


                }
                Objects.requireNonNull(connection).close();
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
            }
        }

        //DAOFactory daoFactory = new AppPokemonDAOFactory();
        //daoFactory.cerrarConexion();

        try {
            EntrenadorDAO entrenadorDAO = DAOFactory.getINSTANCE().getEntrenadorDAO();
            System.out.println(entrenadorDAO.get(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DAOFactory.getINSTANCE().cerrarConexion();
        */

        //System.out.println(EntrenadorRepository.getINSTANCE().generarEntrenadorRandom(50));


    }

    public static void creaTablaEquipo(Connection con, String BDNombre) throws
            SQLException{
        String creaTabla = "create table " + BDNombre + ".EQUIPO " +
                "(codEquipo INT NOT NULL PRIMARY KEY, " +
                "nombre varchar(40) NOT NULL, " +
                "estadio varchar(40) NOT NULL, " +
                "poblacion varchar(20) NOT NULL, "+
                "provincia varchar(20) NOT NULL, "+
                "codPostal char(5)) ";
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(creaTabla);
            System.out.println("Tabla EQUIPO creada.");
        } catch(SQLException e) {
            printSQLException(e); // Ver apartado 5
        } finally {
            Objects.requireNonNull(stmt).close();
        }
    }

    public static void printSQLException(SQLException ex){
        ex.printStackTrace(System.err);
        System.err.println("SQLState: "+ex.getSQLState());
        System.err.println("Error code: "+ex.getErrorCode());
        System.err.println("Message: "+ex.getMessage());
        Throwable t = ex.getCause();
        while (t!=null) {
            System.out.println("Cause: "+t);
            t = t.getCause();
        }
    }

    public static void consultaEquipo(Connection con, String BDNombre)
            throws SQLException {
        // String sqlString = "SELECT client, password, balance FROM BANCO";
        String sqlString = "SELECT * FROM ENTRENADOR";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sqlString);
        while (rs.next()) {
            System.out.println(rs.getInt("id_entrenador") + "\n" +
                    rs.getString("nombre") + "\n" +
                    rs.getInt("pokedollars") + "\n" +
                    rs.getString("pokemons") + "\n" +
                    rs.getString("pokemons_caja"));
        }
        statement.close();
    }
}
