package gui;

import controller.AppPokemon;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AppPokemonGUI extends Application {

    private static AppPokemonGUI INSTANCE;

    private AppPokemonGUI(){

    }

    public static AppPokemonGUI getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new AppPokemonGUI();
        return INSTANCE;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("AppPokemonGUI.fxml"));
        stage.setTitle("AppPokemon");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
