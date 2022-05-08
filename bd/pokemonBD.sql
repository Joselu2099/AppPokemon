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
       NOMBRE VARCHAR(20) NOT NULL,
	   ESTAMINA INT,
       POTENCIA INT,
       TIPO VARCHAR(10),
       ESTADO VARCHAR(10),
       MEJORA INT,
	   NUM_TURNOS INT
);
	   
CREATE TABLE TURNO(
       ID_TURNO INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
       NUM_TURNO INT,
       MOVIMIENTO_JUGADOR INT,
       MOVIMIENTO_RIVAL INT,
	   CONSTRAINT TURNO_JUGADOR_FK FOREIGN KEY (MOVIMIENTO_JUGADOR) REFERENCES MOVIMIENTO (ID_MOVIMIENTO),
       CONSTRAINT TURNO_RIVAL_FK FOREIGN KEY (MOVIMIENTO_RIVAL) REFERENCES MOVIMIENTO (ID_MOVIMIENTO)
);
	   
--ENTRENADORES	   
INSERT INTO ENTRENADOR(NOMBRE) VALUES('ANTONIO');
INSERT INTO ENTRENADOR(NOMBRE) VALUES('PERICO');
INSERT INTO ENTRENADOR(NOMBRE) VALUES('ROBERTO');
INSERT INTO ENTRENADOR(NOMBRE) VALUES('KYLIAN'); 

--COMBATES
INSERT INTO COMBATE(JUGADOR, RIVAL, GANADOR) VALUES(1,2,3);
INSERT INTO COMBATE(JUGADOR, RIVAL, GANADOR) VALUES(2,4,1);
INSERT INTO COMBATE(JUGADOR, RIVAL, GANADOR) VALUES(3,4,2);

--MOVIMIENTOS ATAQUE
INSERT INTO MOVIMIENTO(NOMBRE, ESTAMINA, POTENCIA, TIPO) VALUES('LANZALLAMAS', 10, 50, 'FIRE');
INSERT INTO MOVIMIENTO(NOMBRE, ESTAMINA, POTENCIA, TIPO) VALUES('PISTOLA DE AGUA', 5, 15, 'WATER');
INSERT INTO MOVIMIENTO(NOMBRE, ESTAMINA, POTENCIA, TIPO) VALUES('LATIGO CEPA', 5, 10, 'PLANT');

--MOVIMIENTOS ESTADO
INSERT INTO MOVIMIENTO(NOMBRE, ESTAMINA, ESTADO, NUM_TURNOS) VALUES('PARALIZAR', 10, 'PARALIZADO', 3);
INSERT INTO MOVIMIENTO(NOMBRE, ESTAMINA, ESTADO, NUM_TURNOS) VALUES('SOMNIFERO', 15, 'DORMIDO', 5);
INSERT INTO MOVIMIENTO(NOMBRE, ESTAMINA, ESTADO, NUM_TURNOS) VALUES('PARALIZAR', 10, 'PARALIZADO', 2);

--MOVIMIENTOS MEJORA
INSERT INTO MOVIMIENTO(NOMBRE, ESTAMINA, MEJORA, NUM_TURNOS) VALUES('POTENCIAR ATAQUE', 3, 5, 1);
INSERT INTO MOVIMIENTO(NOMBRE, ESTAMINA, MEJORA, NUM_TURNOS) VALUES('POTENCIAR DEFENSA', 3, 3, 2);
INSERT INTO MOVIMIENTO(NOMBRE, ESTAMINA, MEJORA, NUM_TURNOS) VALUES('POTENCIAR ATAQUE_ESP', 3, 6, 2);

--TURNOS
INSERT INTO TURNO(NUM_TURNO, MOVIMIENTO_JUGADOR, MOVIMIENTO_RIVAL) VALUES(1, 1, 2);
INSERT INTO TURNO(NUM_TURNO, MOVIMIENTO_JUGADOR, MOVIMIENTO_RIVAL) VALUES(1, 2, 3);
INSERT INTO TURNO(NUM_TURNO, MOVIMIENTO_JUGADOR, MOVIMIENTO_RIVAL) VALUES(1, 4, 5);