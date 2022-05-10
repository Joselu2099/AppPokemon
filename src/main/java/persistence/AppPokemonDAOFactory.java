package persistence;

/**
 * Factoria concreta DAO para el Servidor de Persistencia de la asignatura TDS.
 */

public final class AppPokemonDAOFactory extends DAOFactory {

    public AppPokemonDAOFactory() {
    }

    @Override
    public EntrenadorDAO getEntrenadorDAO() {
        return AppPokemonEntrenadorDAO.getInstance();
    }

    @Override
    public PokemonDAO getPokemonDAO() {
        return null;
    }

    @Override
    public MovimientoDAO getMovimientoDAO() {
        return null;
    }

    @Override
    public CombateDAO getCombateDAO() {
        return null;
    }

    @Override
    public TurnoDAO getTurnoDAO() {
        return null;
    }


}