module org.openjfx.AppPokemon {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires pokedex.java.api;
	requires javafx.graphics;
	requires javafx.base;

    opens gui to javafx.fxml;
    exports gui;
}
