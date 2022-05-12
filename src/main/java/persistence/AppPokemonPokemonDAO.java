package persistence;

import model.Pokemon;

import java.sql.SQLException;
import java.util.List;

public class AppPokemonPokemonDAO implements PokemonDAO{

    private static AppPokemonPokemonDAO INSTANCE = null;
    private final Connection connection;
    private Statement statement;

    private AppPokemonPokemonDAO() {
        this.connection = DAOFactory.getINSTANCE().getConnection();
        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized AppPokemonPokemonDAO getInstance() {
        if (INSTANCE == null)
            INSTANCE = new AppPokemonPokemonDAO
    ();
        return INSTANCE;
    }
    private Pokemon resultToPokemon(ResultSet rs) throws SQLException{
        Pokemon  ent = new Pokemon(rs.getInt("id_Pokemon"),
        rs.getString("nombre"),
        rs.getString("mote"),
        rs.getInt("vitalidad"),
        rs.getInt("ataque")
        rs.getInt("defensa")
        rs.getInt("ataque_esp")
        rs.getInt("defensa_esp")
        rs.getInt("velocidad")
        rs.getInt("estamina")
        rs.getInt("nivel")
        rs.getInt("experiencia")
        rs.getString("movimientos")
        rs.getInt("fertilidad")
        rs.getString("tipo1")
        rs.getString("tipo2")
        rs.getString("estado")
        rs.getString("sprite")
        );
        
    return ent;
    }

    @Override
    public Pokemon create(Pokemon assistant) throws SQLException {
        statement.executeUpdate("INSERT INTO POKEMON(NOMBRE,POKEDOLLARS)" +
        " VALUES('" + assistant.getNombre() + "', " + assistant.getPokedollars() +")");
        return get(assistant.getNombre());    
    }

    @Override
    public void delete(Pokemon assistant) throws SQLException {
        statement.executeUpdate("DELETE FROM POKEMON WHERE ID_POKEMON ="+ assistant.getId());

    }

    @Override
    public void updateProfile(Pokemon assistant) throws SQLException {
    statement.executeUpdate("UPDATE POKEMON" +
        " SET NOMBRE='" + assistant.getNombre() +"'"+
        " WHERE ID_POKEMON = " + assistant.getId());
    statement.executeUpdate("UPDATE POKEMON" +
        " SET POKEDOLLARS=" + assistant.getPokedollars() +
        " WHERE ID_POKEMON = " + assistant.getId());
    statement.executeUpdate("UPDATE POKEMON" +
        " SET POKEMONS='" + UtilsDAO.listToString(assistant.getPokemons().stream().map(Pokemon::getId).collect(Collectors.toList())) +"'"+
        " WHERE ID_POKEMON = " + assistant.getId());
    statement.executeUpdate("UPDATE POKEMON" +
        " SET POKEMONS_CAJA='" + UtilsDAO.listToString(assistant.getCajaPokemon().stream().map(Pokemon::getId).collect(Collectors.toList())) +"'"+
        " WHERE ID_POKEMON = " + assistant.getId());
    }

    @Override
    public Pokemon get(int id) throws SQLException {
        ArrayList<Pokemon>  = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM POKEMON WHERE ID_POKEMON="+id);
        while (rs.next()){
            .add(resultToPokemon(rs));
        }
        .forEach(e-> System.out.println(e));
        return .get(0);    
    }

    @Override
    public Pokemon get(String nombre) throws SQLException {
        ArrayList<Pokemon>  = new ArrayList<>();
        ResultSet rs = statement.executeQuery("SELECT * FROM POKEMON WHERE NOMBRE='"+nombre+"'");
        while (rs.next()){
            .add(resultToPokemon(rs));
        }
        return .get(0);    
    }

    @Override
    public List<Pokemon> getAll() throws SQLException {
        public List<Pokemon> getAll() throws SQLException {
            ArrayList<Pokemon>  = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM POKEMON");
            while (rs.next()){
                .add(resultToPokemon(rs));
            }
            return ;    
    }
}
