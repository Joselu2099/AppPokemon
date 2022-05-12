package persistence;

import model.Pokemon;

import java.sql.SQLException;
import java.util.List;

public class AppPokemonPokemonDAO implements PokemonDAO{
    @Override
    public Pokemon create(Pokemon assistant) throws SQLException {
        return null;
    }

    @Override
    public void delete(Pokemon assistant) throws SQLException {

    }

    @Override
    public void updateProfile(Pokemon assistant) throws SQLException {

    }

    @Override
    public Pokemon get(int id) throws SQLException {
        return null;
    }

    @Override
    public Pokemon get(String nombre) throws SQLException {
        return null;
    }

    @Override
    public List<Pokemon> getAll() throws SQLException {
        return null;
    }
}
