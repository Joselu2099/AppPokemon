package launcher;

import controller.AppPokemon;
import gui.ControladorGUI;
import model.entrenador.EntrenadorRepository;


public class Launcher {
    public static void main(String[] args) {
        AppPokemon.getINSTANCE();
        
    	ControladorGUI.getINSTANCE().launchController();
       
    	AppPokemon.getINSTANCE().closeConnections();
    }
}
 