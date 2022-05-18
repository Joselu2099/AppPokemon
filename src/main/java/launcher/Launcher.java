package launcher;

import controller.AppPokemon;
import gui.ControladorGUI;


public class Launcher {
    public static void main(String[] args) {
        AppPokemon.getINSTANCE();
        
    	ControladorGUI.getINSTANCE().launchController();
       
    	AppPokemon.getINSTANCE().closeConnections();
    	
    	AppPokemon.getINSTANCE().exportarDatos();
    }
}
 