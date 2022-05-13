package persistence;

import model.movimiento.Movimiento;
import java.sql.SQLException;
import java.util.List;

public interface MovimientoDAO {

    Movimiento get(String nombre) throws SQLException;

    Movimiento get(int id) throws SQLException;

    List<Movimiento> getAll() throws SQLException;
}
