package gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javafx.scene.image.ImageView;
import model.movimiento.Estado;

public class UtilsGUI {

	public static int getIdFromURL(@SuppressWarnings("exports") ImageView image) {
		String str = image.getImage().getUrl();
		String id = "";
		for(int i = 73; str.charAt(i)!='.';i++) {
			id+=str.charAt(i);
		}
		return Integer.parseInt(id);
	}
	
	public static List<String> splitString(String s) {
        return s == null ? new ArrayList<>() : Arrays.stream(s.split(",")).collect(Collectors.toList());
    }
	
	@SuppressWarnings("exports")
	public static Estado stringToEstado(String str) {
    	switch(str.toUpperCase()) {
	    	case "PARALIZADO":
	    		return Estado.PARALIZADO;
	    	case "DORMIDO":
	    		return Estado.DORMIDO;
	    	case "QUEMADO":
	    		return Estado.QUEMADO;
	    	case "ENVENENADO":
	    		return Estado.ENVENENADO;
	    	case "CONFUSO":
	    		return Estado.CONFUSO;
	    	case "CONGELADO":
	    		return Estado.CONGELADO;
	    	case "SIN_ESTADO":
	    	default:
	    		return Estado.SIN_ESTADO;
    	}
    }
}
