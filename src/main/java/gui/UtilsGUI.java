package gui;

import javafx.scene.image.ImageView;

public class UtilsGUI {

	public static int getIdFromURL(@SuppressWarnings("exports") ImageView image) {
		String str = image.getImage().getUrl();
		String id = "";
		for(int i = 73; str.charAt(i)!='.';i++) {
			id+=str.charAt(i);
		}
		return Integer.parseInt(id);
	}
}
