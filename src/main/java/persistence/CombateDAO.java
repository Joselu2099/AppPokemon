package persistence;

import model.Combate;

import java.sql.SQLException;
import java.util.List;

public interface CombateDAO {
    void create(Combate assistant) throws SQLException;

    boolean delete(Combate assistant) throws SQLException;

    void updateProfile(Combate assistant) throws SQLException;

    Combate get(int id) throws SQLException;

    List<Combate> getAll() throws SQLException;
}