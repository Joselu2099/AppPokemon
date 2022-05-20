package dao;

import model.combate.Combate;
import java.sql.SQLException;
import java.util.List;

public interface CombateDAO {
	Combate create(Combate assistant) throws SQLException;

    void delete(Combate assistant) throws SQLException;

    Combate get(int id) throws SQLException;
    
    List<Combate> getCombatesFromEntrenador(int idEntrenador) throws SQLException;

    Combate getLast() throws SQLException;
    
    List<Combate> getAll() throws SQLException;
}
