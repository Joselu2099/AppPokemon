module org.openjfx.AppPokemon {
    requires javafx.controls;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.swing;
    requires javafx.web;
    requires javafx.media;
	requires java.sql;
	requires pokedex.java.api;
	requires org.apache.commons.io;

    opens gui to javafx.fxml;
    exports gui;
}
