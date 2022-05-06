CREATE TABLE ENTRENADOR(
       ID_ENTRENADOR INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
       NOMBRE VARCHAR(10) NOT NULL,
       POKEDOLLARS INT DEFAULT 500,
       POKEMONS VARCHAR(15),
       POKEMONS_CAJA VARCHAR(4000)
);

CREATE TABLE COMBATE(
       ID_COMBATE INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
       JUGADOR INT NOT NULL,
       RIVAL INT NOT NULL, 
       GANADOR INT, 
       TURNOS VARCHAR(4000), 
       POKEMON_KO_JUGADOR VARCHAR(15), 
       POKEMON_KO_RIVAL VARCHAR(15), 
	   CONSTRAINT COMBATE_JUGADOR_FK FOREIGN KEY (JUGADOR) REFERENCES ENTRENADOR (ID_ENTRENADOR),
	   CONSTRAINT COMBATE_RIVAL_FK FOREIGN KEY (RIVAL) REFERENCES ENTRENADOR (ID_ENTRENADOR),
	   CONSTRAINT COMBATE_GANADOR_FK FOREIGN KEY (GANADOR) REFERENCES ENTRENADOR (ID_ENTRENADOR)
);
	
CREATE TABLE MOVIMIENTO(
       ID_MOVIMIENTO INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
       NOM_MOVIMIENTO VARCHAR(20) NOT NULL,
       POTENCIA INT,
       TIPO VARCHAR(10),
       ESTADO VARCHAR(10),
       ESTAMINA INT,
       MEJORA INT
);
	   
CREATE TABLE TURNO(
       ID_TURNO INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
       NUM_TURNO INT,
       MOVIMIENTO_JUGADOR INT,
       MOVIMIENTO_RIVAL INT,
	   CONSTRAINT TURNO_JUGADOR_FK FOREIGN KEY (MOVIMIENTO_JUGADOR) REFERENCES MOVIMIENTO (ID_MOVIMIENTO),
       CONSTRAINT TURNO_RIVAL_FK FOREIGN KEY (MOVIMIENTO_RIVAL) REFERENCES MOVIMIENTO (ID_MOVIMIENTO)
);
	   