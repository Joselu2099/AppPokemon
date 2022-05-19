package dao;

import model.pokemon.Pokemon;
import java.sql.SQLException;
import java.util.List;

public interface PokemonDAO {
    Pokemon create(Pokemon assistant) throws SQLException;

    void delete(Pokemon assistant) throws SQLException;

    void updateProfile(Pokemon assistant) throws SQLException;

    Pokemon get(int id) throws SQLException;
    
    Pokemon getLast() throws SQLException;

    List<Pokemon> getAll() throws SQLException;
    
    List<Pokemon> getPokemonsEquipo(int idEntrenador) throws SQLException;
    
    List<Pokemon> getPokemonsCaja(int idEntrenador) throws SQLException;
}
