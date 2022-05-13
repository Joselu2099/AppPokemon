module org.openjfx.AppPokemon {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires pokedex.java.api;

    opens gui to javafx.fxml;
    exports gui;
}
