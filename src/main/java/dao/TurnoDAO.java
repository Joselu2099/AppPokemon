package dao;

import model.combate.Turno;
import java.sql.SQLException;
import java.util.List;

public interface TurnoDAO {
    Turno create(Turno assistant) throws SQLException;

    void delete(Turno assistant) throws SQLException;

    Turno get(int id) throws SQLException;
    
    Turno getLast() throws SQLException;
    
    List<Turno> getTurnosFromCombate(int idCombate) throws SQLException;

    List<Turno> getAll() throws SQLException;
}
