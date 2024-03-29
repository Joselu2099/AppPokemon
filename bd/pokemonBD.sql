CREATE TABLE ENTRENADOR(
       ID_ENTRENADOR INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
       NOMBRE VARCHAR(10) NOT NULL UNIQUE,
       POKEDOLLARS INT NOT NULL DEFAULT 800
);

CREATE TABLE MOVIMIENTO(
       ID_MOVIMIENTO INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
       NOMBRE VARCHAR(20) NOT NULL UNIQUE,
       POTENCIA INT,
       TIPO VARCHAR(10),
       ESTADO VARCHAR(10),
       MEJORA INT,
	   TIPO_MEJORA VARCHAR(10)
);

CREATE TABLE POKEMON(
       ID_POKEMON INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
       NOMBRE VARCHAR(15) NOT NULL,
	   MOTE VARCHAR(20) NOT NULL UNIQUE,
       VITALIDAD INT NOT NULL,
	   ATAQUE INT NOT NULL,
	   DEFENSA INT NOT NULL,
	   ATAQUE_ESP INT NOT NULL,
	   DEFENSA_ESP INT NOT NULL,
	   VELOCIDAD INT NOT NULL,
	   ESTAMINA INT NOT NULL,
	   NIVEL INT NOT NULL DEFAULT 0,
	   EXPERIENCIA INT NOT NULL DEFAULT 0,
       MOVIMIENTO1 INT,
	   MOVIMIENTO2 INT,
	   MOVIMIENTO3 INT,
	   MOVIMIENTO4 INT,
	   FERTILIDAD INT NOT NULL DEFAULT 5,
	   TIPO1 VARCHAR(10) NOT NULL DEFAULT 'UNKNOWN', 
	   TIPO2 VARCHAR(10) NOT NULL DEFAULT 'UNKNOWN',
	   ESTADO VARCHAR(10) NOT NULL DEFAULT 'SIN_ESTADO',
       SPRITE VARCHAR(80) NOT NULL,
	   ENTRENADOR INT,
	   EQUIPO_CAJA VARCHAR(6) NOT NULL,
	   CONSTRAINT MV1_FK FOREIGN KEY(MOVIMIENTO1) REFERENCES MOVIMIENTO(ID_MOVIMIENTO),
	   CONSTRAINT MV2_FK FOREIGN KEY(MOVIMIENTO2) REFERENCES MOVIMIENTO(ID_MOVIMIENTO),
	   CONSTRAINT MV3_FK FOREIGN KEY(MOVIMIENTO3) REFERENCES MOVIMIENTO(ID_MOVIMIENTO),
	   CONSTRAINT MV4_FK FOREIGN KEY(MOVIMIENTO4) REFERENCES MOVIMIENTO(ID_MOVIMIENTO),
	   CONSTRAINT ENT_FK FOREIGN KEY(ENTRENADOR) REFERENCES ENTRENADOR(ID_ENTRENADOR) ON DELETE CASCADE
);

CREATE TABLE COMBATE(
       ID_COMBATE INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
       JUGADOR INT NOT NULL,
       RIVAL VARCHAR(20) NOT NULL, 
       GANADOR VARCHAR(20) NOT NULL,
       POKEMON_KO_JUGADOR VARCHAR(15) NOT NULL, 
       POKEMON_KO_RIVAL VARCHAR(15) NOT NULL,
	   CONSTRAINT COMBATE_JUGADOR_FK FOREIGN KEY (JUGADOR) REFERENCES ENTRENADOR (ID_ENTRENADOR)
);
	   
CREATE TABLE TURNO(
       ID_TURNO INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	   COMBATE INT NOT NULL,
       NUM_TURNO INT NOT NULL,
       MOVIMIENTO_JUGADOR INT NOT NULL,
       MOVIMIENTO_RIVAL INT NOT NULL,
	   CONSTRAINT COMBATE_FK FOREIGN KEY(COMBATE) REFERENCES COMBATE(ID_COMBATE) ON DELETE CASCADE,
	   CONSTRAINT TURNO_JUGADOR_FK FOREIGN KEY (MOVIMIENTO_JUGADOR) REFERENCES MOVIMIENTO (ID_MOVIMIENTO),
       CONSTRAINT TURNO_RIVAL_FK FOREIGN KEY (MOVIMIENTO_RIVAL) REFERENCES MOVIMIENTO (ID_MOVIMIENTO)
);
	  

INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('PUNO FUEGO', 'FIRE', 75);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('CASCADA', 'WATER', 15);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('MARTILLAZO', 'WATER', 10);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('TENAZA', 'WATER', 15);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('HIDROBOMBA', 'WATER', 120);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('PISTOLA AGUA', 'WATER', 40);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('SURF', 'WATER', 90);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('LATIGO CEPA', 'GRASS', 10);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('ABSORBER', 'GRASS', 15);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('DANZA PETALO', 'GRASS', 15);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('HOJA AFILADA', 'GRASS', 15);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('MEGAAGOTAR', 'GRASS', 15);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('RAYO SOLAR', 'GRASS', 15);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('CHUPAVIDAS', 'BUG', 80);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('PIN MISIL', 'BUG', 25);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('FURIA DRAGON', 'DRAGON', 100);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('ONDA TRUENO', 'ELECTRIC', 90);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('LENGUETAZO', 'GHOST', 50);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('NEBLINA', 'ICE', 100);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('CONTRAATAQUE', 'FIGHTING', 75);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('DOBLE PATADA', 'FIGHTING', 30);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('MOVIMIENTO SISMICO', 'FIGHTING', 30);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('PATADA BAJA', 'FIGHTING', 50);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('PATADA GIRO', 'FIGHTING', 60);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('PATADA SALTO', 'FIGHTING', 100);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('PATADA SALTO ALTA', 'FIGHTING', 130);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('SUMISION', 'FIGHTING', 80);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('AGARRE', 'NORMAL', 55);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('ARANAZO', 'NORMAL', 40);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('ATADURA', 'NORMAL', 15);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('ATAQUE FURIA', 'NORMAL', 15);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('ATAQUE RAPIDO', 'NORMAL', 40);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('LATIGO', 'NORMAL', 75);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('COME SUENOS', 'PSYCHIC', 100);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('PSICOONDA', 'PSYCHIC', 50);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('AVALANCHA', 'ROCK', 75);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('LANZARROCAS', 'ROCK', 50);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('HUESO PALO', 'GRASS', 65);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('HUESOMERANG', 'GRASS', 50);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('TERREMOTO', 'GRASS', 100);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('ATAQUE AEREO', 'FLYING', 140);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('ATAQUE ALA', 'FLYING', 60);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('PICO TALADRO', 'FLYING', 80);
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES('PICOTAZO', 'FLYING', 35);



INSERT INTO MOVIMIENTO(NOMBRE, TIPO, ESTADO) VALUES('ASCUAS', 'FIRE', 'QUEMADO');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, ESTADO) VALUES('LANZALLAMAS', 'FIRE', 'QUEMADO');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, ESTADO) VALUES('GIRO FUEGO', 'FIRE', 'QUEMADO');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, ESTADO) VALUES('LLAMARADA', 'FIRE', 'QUEMADO');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, ESTADO) VALUES('ESPORAS', 'GRASS', 'DORMIDO');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, ESTADO) VALUES('PARALIZADOR', 'GRASS', 'PARALIZADO');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, ESTADO) VALUES('PARALIZAR', 'GRASS', 'PARALIZADO');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, ESTADO) VALUES('SOMNIFERO', 'GRASS', 'DORMIDO');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, ESTADO) VALUES('DOBLE ATAQUE', 'BUG','ENVENENADO');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, ESTADO) VALUES('PUNO ELECTRICO', 'ELECTRIC', 'PARALIZADO');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, ESTADO) VALUES('IMPACTRUENO', 'ELECTRIC', 'PARALIZADO');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, ESTADO) VALUES('RAYO', 'ELECTRIC', 'PARALIZADO');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, ESTADO) VALUES('TRUENO', 'ELECTRIC', 'PARALIZADO');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, ESTADO) VALUES('RAYO CONFUSO', 'GHOST', 'CONFUSO');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, ESTADO) VALUES('PUNO HIELO', 'ICE', 'CONGELADO');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, ESTADO) VALUES('RAYO HIELO', 'ICE', 'CONGELADO');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, ESTADO) VALUES('VENTISCA', 'ICE', 'CONGELADO');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, ESTADO) VALUES('CONFUSION', 'PHYCHIC', 'CONFUSO');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, ESTADO) VALUES('PSICORAYO', 'PHYCHIC', 'CONFUSO');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, ESTADO) VALUES('HIPNOSIS', 'PHYCHIC', 'DORMIDO');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, ESTADO) VALUES('PICOTAZO VENENO', 'POISON', 'ENVENENADO');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, ESTADO) VALUES('POLUCION', 'POISON', 'ENVENENADO');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, ESTADO) VALUES('RESIDUOS', 'POISON', 'ENVENENADO');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, ESTADO) VALUES('GAS VENENOSO', 'POISON', 'ENVENENADO');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, ESTADO) VALUES('POLVO VENENOSO', 'POISON', 'ENVENENADO');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, ESTADO) VALUES('TOXICO', 'POISON', 'ENVENENADO');



INSERT INTO MOVIMIENTO(NOMBRE, TIPO, MEJORA, TIPO_MEJORA) VALUES('POTENCIAR ATAQUE', 'FIGHTING', 5, 'ATAQUE');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, MEJORA, TIPO_MEJORA) VALUES('POTENCIAR DEFENSA', 'NORMAL', 3, 'DEFENSA');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, MEJORA, TIPO_MEJORA) VALUES('REFUJIO', 'WATER', 3,'DEFENSA');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, MEJORA, TIPO_MEJORA) VALUES('RAYO AURORA', 'ICE', -2,'ATAQUE');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, MEJORA, TIPO_MEJORA) VALUES('PSIQUICO', 'PSYCHIC', -2,'DEFENSA');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, MEJORA, TIPO_MEJORA) VALUES('AGILIDAD', 'PSYCHIC', 1,'VELOCIDAD');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, MEJORA, TIPO_MEJORA) VALUES('BARRERA', 'PSYCHIC', 2,'DEFENSA');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, MEJORA, TIPO_MEJORA) VALUES('MEDITACION', 'PSYCHIC', 2, 'ATAQUE');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, MEJORA, TIPO_MEJORA) VALUES('ACIDO', 'POISON', -5, 'DEFENSA');
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, MEJORA, TIPO_MEJORA) VALUES('ARMADURA ACIDA', 'POISON', 5, 'DEFENSA');



INSERT INTO ENTRENADOR(NOMBRE, POKEDOLLARS) VALUES('KNEKRO', 99999);
INSERT INTO ENTRENADOR(NOMBRE, POKEDOLLARS) VALUES('RED', 99999);
INSERT INTO ENTRENADOR(NOMBRE, POKEDOLLARS) VALUES('BLUE', 99999);
INSERT INTO ENTRENADOR(NOMBRE, POKEDOLLARS) VALUES('ILLOJUAN', 99999);



INSERT INTO POKEMON(NOMBRE, MOTE, VITALIDAD, ATAQUE, DEFENSA, ATAQUE_ESP, DEFENSA_ESP, VELOCIDAD, ESTAMINA, NIVEL, MOVIMIENTO1, MOVIMIENTO2, MOVIMIENTO3, MOVIMIENTO4, TIPO1, SPRITE, ENTRENADOR, EQUIPO_CAJA)
VALUES('SNORLAX', 'SNORLAX_KNEKRO', 481, 330, 189, 149, 295, 96, 190, 100, 63, 12, 64, 80, 'NORMAL', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/143.png', 1, 'EQUIPO');
INSERT INTO POKEMON(NOMBRE, MOTE, VITALIDAD, ATAQUE, DEFENSA, ATAQUE_ESP, DEFENSA_ESP, VELOCIDAD, ESTAMINA, NIVEL, MOVIMIENTO1, MOVIMIENTO2, MOVIMIENTO3, MOVIMIENTO4, TIPO1, TIPO2, SPRITE, ENTRENADOR, EQUIPO_CAJA)
VALUES('ZAPDOS', 'ZAPDOS_KNEKRO', 384, 279, 269, 349, 278, 299, 200, 100, 58, 59, 41, 78,'ELECTRIC', 'NORMAL', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/145.png', 1, 'EQUIPO');
INSERT INTO POKEMON(NOMBRE, MOTE, VITALIDAD, ATAQUE, DEFENSA, ATAQUE_ESP, DEFENSA_ESP, VELOCIDAD, ESTAMINA, NIVEL, MOVIMIENTO1, MOVIMIENTO2, MOVIMIENTO3, MOVIMIENTO4, TIPO1, TIPO2, SPRITE, ENTRENADOR, EQUIPO_CAJA)
VALUES('STARMIE', 'STARMIE_KNEKRO', 324, 249, 269, 299, 269, 329, 185, 100, 2, 49, 70, 79, 'WATER', 'PSYCHIC', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/121.png', 1, 'EQUIPO');
INSERT INTO POKEMON(NOMBRE, MOTE, VITALIDAD, ATAQUE, DEFENSA, ATAQUE_ESP, DEFENSA_ESP, VELOCIDAD, ESTAMINA, NIVEL, MOVIMIENTO1, MOVIMIENTO2, MOVIMIENTO3, MOVIMIENTO4, TIPO1, TIPO2, SPRITE, ENTRENADOR, EQUIPO_CAJA)
VALUES('RHYDON', 'RHYDON_KNEKRO', 414, 359, 339, 189, 189, 179, 178, 100, 40, 22, 38, 36, 'GRASS', 'ROCK', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/112.png', 1, 'EQUIPO');

INSERT INTO POKEMON(NOMBRE, MOTE, VITALIDAD, ATAQUE, DEFENSA, ATAQUE_ESP, DEFENSA_ESP, VELOCIDAD, ESTAMINA, NIVEL, MOVIMIENTO1, MOVIMIENTO2, MOVIMIENTO3, MOVIMIENTO4, TIPO1, SPRITE, ENTRENADOR, EQUIPO_CAJA)
VALUES('SNORLAX', 'SNORLAX_ILLOJUAN', 481, 330, 189, 149, 295, 96, 190, 100, 66, 18, 22, 80, 'NORMAL', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/143.png', 4, 'EQUIPO');
INSERT INTO POKEMON(NOMBRE, MOTE, VITALIDAD, ATAQUE, DEFENSA, ATAQUE_ESP, DEFENSA_ESP, VELOCIDAD, ESTAMINA, NIVEL, MOVIMIENTO1, MOVIMIENTO2, MOVIMIENTO3, MOVIMIENTO4, TIPO1, TIPO2, SPRITE, ENTRENADOR, EQUIPO_CAJA)
VALUES('ZAPDOS', 'ZAPDOS_ILLOJUAN', 384, 279, 269, 349, 278, 299, 200, 100, 58, 59, 41, 78,'ELECTRIC', 'NORMAL', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/145.png', 4, 'EQUIPO');
INSERT INTO POKEMON(NOMBRE, MOTE, VITALIDAD, ATAQUE, DEFENSA, ATAQUE_ESP, DEFENSA_ESP, VELOCIDAD, ESTAMINA, NIVEL, MOVIMIENTO1, MOVIMIENTO2, MOVIMIENTO3, MOVIMIENTO4, TIPO1, TIPO2, SPRITE, ENTRENADOR, EQUIPO_CAJA)
VALUES('STARMIE', 'STARMIE_ILLOJUAN', 324, 249, 269, 299, 269, 329, 185, 100, 6, 67, 5, 79, 'WATER', 'PSYCHIC', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/121.png', 4, 'EQUIPO');
INSERT INTO POKEMON(NOMBRE, MOTE, VITALIDAD, ATAQUE, DEFENSA, ATAQUE_ESP, DEFENSA_ESP, VELOCIDAD, ESTAMINA, NIVEL, MOVIMIENTO1, MOVIMIENTO2, MOVIMIENTO3, MOVIMIENTO4, TIPO1, TIPO2, SPRITE, ENTRENADOR, EQUIPO_CAJA)
VALUES('RHYDON', 'RHYDON_ILLOJUAN', 414, 359, 339, 189, 189, 179, 178, 100, 40, 22, 38, 36, 'GRASS', 'ROCK', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/112.png', 4, 'EQUIPO');

