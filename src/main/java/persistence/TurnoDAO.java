package persistence;

import model.combate.Turno;
import java.sql.SQLException;
import java.util.List;

public interface TurnoDAO {
    void create(Turno assistant) throws SQLException;

    void delete(Turno assistant) throws SQLException;

    void updateProfile(Turno assistant) throws SQLException;

    Turno get(int id) throws SQLException;

    List<Turno> getAll() throws SQLException;
}
