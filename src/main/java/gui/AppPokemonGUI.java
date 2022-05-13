package gui;

import java.io.IOException;
import javafx.fxml.FXML;

public class AppPokemonGUI {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("AppPokemonGUI");
    }
}
