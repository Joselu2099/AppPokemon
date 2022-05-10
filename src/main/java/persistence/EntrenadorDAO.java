package persistence;

import model.Entrenador;

import java.sql.SQLException;
import java.util.List;

public interface EntrenadorDAO {
    void create(Entrenador assistant) throws SQLException;

    boolean delete(Entrenador assistant) throws SQLException;

    void updateProfile(Entrenador assistant) throws SQLException;

    Entrenador get(int id) throws SQLException;

    List<Entrenador> getAll() throws SQLException;
}
