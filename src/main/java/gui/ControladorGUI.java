package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.io.IOException;

/**
 * JavaFX App
 */
public class ControladorGUI extends Application {

	public static final int LOGIN_WIDTH = 640;
	public static final int LOGIN_HEIGHT = 450;
	public static final int APP_WIDTH = 1280;
	public static final int APP_HEIGHT = 720;
	public static final int COMBATE_WIDTH = 640;
	public static final int COMBATE_HEIGHT = 600;
	
	private static ControladorGUI INSTANCE;
    private static Scene scene;
    private static Stage stage;

    public static ControladorGUI getINSTANCE() {
    	if(INSTANCE==null) INSTANCE = new ControladorGUI();
    	return INSTANCE;
    }
    
    @Override
    public void start(@SuppressWarnings("exports") Stage primaryStage) {
    	ControladorGUI.stage = primaryStage;
    	try {
 			scene = new Scene(loadFXML("login"), LOGIN_WIDTH, LOGIN_HEIGHT);
 		} catch (IOException e) {
 			System.err.println("Carga incorrecta del FXML");
 			e.printStackTrace();
 		}
        stage.setTitle("AppPokemon");
        stage.getIcons().add(new Image(ControladorGUI.class.getResourceAsStream("/images/icon.png"))); 
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void close() {
    	stage.close();
    }
    
    public static void setScene(String fxml) {
    	try {
	        switch(fxml) {
	        	case "login":
	        		scene = new Scene(loadFXML("login"), LOGIN_WIDTH, LOGIN_HEIGHT);
	        		break;
	        	case "pokemonChooser":
	        		scene = new Scene(loadFXML("pokemonChooser"), LOGIN_WIDTH, LOGIN_HEIGHT);
	        		break;
	        	case "appPokemon":
	        		scene = new Scene(loadFXML("appPokemon"), APP_WIDTH, APP_HEIGHT);
	        		break;
	        	case "capture":
	        		scene = new Scene(loadFXML("capture"), LOGIN_WIDTH, LOGIN_HEIGHT);
	        		break;
	        	case "combate":
	        		scene = new Scene(loadFXML("combate"), COMBATE_WIDTH, COMBATE_HEIGHT);
	        		break;
	        }
	        stage.setScene(scene);
    	} catch (IOException e) {
 			System.err.println("Carga incorrecta del FXML");
 			e.printStackTrace();
 		}
    }

    private static Parent loadFXML(String fxml) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(ControladorGUI.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public void launchController() {
        launch();
    }
}