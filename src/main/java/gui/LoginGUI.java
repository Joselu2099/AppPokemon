package gui;

import java.io.IOException;
import javafx.fxml.FXML;

public class LoginGUI {

    @FXML
    private void login() throws IOException {
        ControladorGUI.setRoot("appPokemon");
    }
}
