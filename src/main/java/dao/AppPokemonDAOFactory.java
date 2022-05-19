package dao;

public final class AppPokemonDAOFactory extends DAOFactory {

    public AppPokemonDAOFactory() {
        super();
    }

    @Override
    public EntrenadorDAO getEntrenadorDAO() {
        return AppPokemonEntrenadorDAO.getInstance();
    }

    @Override
    public PokemonDAO getPokemonDAO() {
        return AppPokemonPokemonDAO.getInstance();
    }

    @Override
    public MovimientoDAO getMovimientoDAO() {
        return AppPokemonMovimientoDAO.getInstance();
    }

    @Override
    public CombateDAO getCombateDAO() {
    	return AppPokemonCombateDAO.getInstance();
    }

    @Override
    public TurnoDAO getTurnoDAO() {
    	return AppPokemonTurnoDAO.getInstance();
    }


}