package persistence;

import junit.framework.TestCase;
import model.entrenador.Entrenador;
import org.junit.Assert;
import dao.DAOFactory;
import dao.EntrenadorDAO;

import java.sql.SQLException;

public class AppPokemonEntrenadorDAOTest extends TestCase {

    private EntrenadorDAO entrenadorDAO = DAOFactory.getINSTANCE().getEntrenadorDAO();
    private Entrenador paco = new Entrenador("Paco");
    private int idPaco;

    public void testCreate() {
        int idInicialPaco = paco.getId();
        try {
            paco = entrenadorDAO.create(paco);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        idPaco = paco.getId();
        Assert.assertNotEquals(idInicialPaco, idPaco);
    }
    
    public void testDelete() {
        boolean isBorrado = false;
        try {
            entrenadorDAO.delete(paco);
            isBorrado = true;
        } catch (SQLException e) {
            isBorrado = false;
        }
        assertTrue(isBorrado);
    }

}