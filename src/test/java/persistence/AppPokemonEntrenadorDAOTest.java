package persistence;

import junit.framework.TestCase;
import model.Entrenador;
import org.junit.Assert;

import java.sql.SQLException;

public class AppPokemonEntrenadorDAOTest extends TestCase {

    private EntrenadorDAO entrenadorDAO = DAOFactory.getINSTANCE().getEntrenadorDAO();
    private Entrenador paco;

    public void testCreate() {
        paco = new Entrenador("Paco");
        int idInicialPaco = paco.getId();
        try {
            paco = entrenadorDAO.create(paco);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Assert.assertNotEquals(idInicialPaco, paco.getId());
        testUpdateProfile(paco);
    }

    public void testDelete(Entrenador entrenador) {
        boolean isBorrado = false;
        try {
            entrenadorDAO.delete(entrenador);
            isBorrado = true;
        } catch (SQLException e) {
            isBorrado = false;
        }
        assertTrue(isBorrado);
    }

    public void testUpdateProfile(Entrenador entrenador) {
        entrenador.setPokedollars(1555);
        try {
            entrenadorDAO.updateProfile(entrenador);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals(1555, testGet(entrenador.getId()).getPokedollars());
    }

    public Entrenador testGet(int id) {
        Entrenador e = null;
        try {
            e = entrenadorDAO.get(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        assertNotNull(e);
        return e;
    }

    public void testGetAll() {
    }
}