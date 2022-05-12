package persistence;

import model.Movimiento;

import java.sql.SQLException;
import java.util.List;

public interface MovimientoDAO {

    Movimiento get(int id) throws SQLException;

    List<Movimiento> getAll() throws SQLException;
}
