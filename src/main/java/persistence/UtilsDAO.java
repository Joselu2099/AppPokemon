package persistence;

import model.Pokemon;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UtilsDAO {
    public static void crearModificar(String query) throws SQLException {
        Statement statement = DAOFactory.getINSTANCE().getConnection().createStatement();
        statement.executeUpdate(query);
        statement.close();
    }

    public static void inserts(List<String> querys) throws SQLException {
        Statement statement = DAOFactory.getINSTANCE().getConnection().createStatement();
        for(String query: querys){
            statement.executeUpdate(query);
        }
        statement.close();
    }

    public static ResultSet consultar(String query) throws SQLException {
        Statement statement = DAOFactory.getINSTANCE().getConnection().createStatement();
        ResultSet rs = statement.executeQuery(query);
        statement.close();
        return rs;
    }

    public static Integer safeValueOf(String s) {
        try {
            return Integer.valueOf(s);
        } catch (NumberFormatException | NullPointerException ignored) {
        }
        return null;
    }

    public static List<Integer> stringToList(String union) {
        return union != null ? Arrays.stream(union.split(",")).map(UtilsDAO::safeValueOf).filter(Objects::nonNull).collect(Collectors.toList()) : new ArrayList<>();
    }

    public static String listToString(List<Integer> ids) {
        return ids != null ? ids.stream().map(i -> Integer.toString(i)).collect(Collectors.joining(",")) : "";
    }

    public static List<String> splitString(String s) {
        return s == null ? new ArrayList<>() : Arrays.stream(s.split(",")).collect(Collectors.toList());
    }

    public static String joinString(List<String> list) {
        return list == null ? "" : String.join(",", list);
    }

    public List<Pokemon> idsToPokemons(List<Integer> ids){
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        for(Integer i: ids){
            //TODO
        }
        return pokemons;
    }
}
