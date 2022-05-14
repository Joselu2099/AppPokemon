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

	private static final int START_WIDTH = 640;
	private static final int START_HEIGHT = 420;
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
			scene = new Scene(loadFXML("login"), START_WIDTH, START_HEIGHT);
		} catch (IOException e) {
			System.err.println("Carga incorrecta del FXML");
			e.printStackTrace();
		}
        
        stage.setTitle("AppPokemon");
        //ControladorGUI.class.getResourceAsStream("icon.png")
        stage.getIcons().add(new Image(ControladorGUI.class.getResourceAsStream("/images/icon.png"))); 
        stage.setResizable(false);
        setStageSize(START_WIDTH, START_HEIGHT);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void setStageSize(int width, int height) {
    	stage.setWidth(width);
        stage.setHeight(height);
    }
    
    public static void close() {
    	stage.close();
    }

    public static void setRoot(String fxml) {
        try {
			scene.setRoot(loadFXML(fxml));
		} catch (IOException e) {
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