package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class ControladorGUI extends Application {

	private static final int WIDTH = 750;
	private static final int HEIGHT = 500;
	private static ControladorGUI INSTANCE;
    private static Scene scene;

    public static ControladorGUI getINSTANCE() {
    	if(INSTANCE==null) INSTANCE = new ControladorGUI();
    	return INSTANCE;
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        scene = new Scene(loadFXML("AppPokemonGUI"), WIDTH, HEIGHT);
        
        primaryStage.setTitle("AppPokemon");
        primaryStage.setResizable(false);
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ControladorGUI.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public void launchController() {
        launch();
    }
}