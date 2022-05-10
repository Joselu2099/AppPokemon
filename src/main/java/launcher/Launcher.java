package launcher;

import controller.AppPokemon;

import javax.management.Query;
import java.sql.*;

public class Launcher {
    public static void main(String[] args) {
        AppPokemon.getINSTANCE();
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost::3306/pokemon";
            String login = "root";

            connection = DriverManager.getConnection("jdbc:odbc:bd");
            Statement stmt = connection.createStatement();
            String query = "SELECT ";
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()){
                //Leer datos
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
