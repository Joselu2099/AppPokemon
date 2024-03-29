package dao;

import model.entrenador.Entrenador;
import java.sql.SQLException;
import java.util.List;

public interface EntrenadorDAO {
    Entrenador create(Entrenador assistant) throws SQLException;

    void delete(Entrenador assistant) throws SQLException;

    void updateProfile(Entrenador assistant) throws SQLException;

    Entrenador get(int id) throws SQLException;
    
    Entrenador getLast() throws SQLException;

    List<Entrenador> getAll() throws SQLException;
}
