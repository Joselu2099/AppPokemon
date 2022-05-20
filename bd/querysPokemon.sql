

--QUERIES ENTRENADOR

--Sentencia para insertar entrenadores
INSERT INTO ENTRENADOR(NOMBRE, POKEDOLLARS) VALUES([INSERTA NOMBRE ENTRENADOR],[INSERTA POKEDOLLARS]);
--Sentencia para borrar entrenadores
DELETE FROM ENTRENADOR WHERE ID_ENTRENADOR = [INSERTA ID_ENTRENADOR];
--Sentencia para actualizar un entrenador
UPDATE ENTRENADOR SET POKEDOLLARS=[INSERTA POKEDOLLARS] WHERE ID_ENTRENADOR = [INSERTA ID_ENTRENADOR];
--Sentencia para obtener los datos de un entrenador a partir de un ID
SELECT * FROM ENTRENADOR WHERE ID_ENTRENADOR= [INSERTA ID_ENTRENADOR];
--Sentencia para obtener los datos del último entrenador
SELECT * FROM ENTRENADOR ORDER BY ID_ENTRENADOR DESC LIMIT 1;
--Sentencia para obtener los datos de los entrenadores
SELECT * FROM ENTRENADOR;
   
   
--QUERIES MOVIMIENTO

--Sentencia para insertar movimientos ataque
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES([INSERTA NOMBRE MOVIMIENTO],[INSERTA TIPO],[INSERTA POTENCIA]);
--Sentencia para insertar movimientos estado
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES([INSERTA NOMBRE MOVIMIENTO],[INSERTA TIPO],[INSERTA ESTADO]);
--Sentencia para insertar movimientos mejora
INSERT INTO MOVIMIENTO(NOMBRE, TIPO, POTENCIA) VALUES([INSERTA NOMBRE MOVIMIENTO],[INSERTA TIPO],[INSERTA MEJORA], [INSERTA TIPO MEJORA]);


--Sentencia para obtener los datos del movimiento a partir de un nombre del movimiento
SELECT * FROM MOVIMIENTO WHERE NOMBRE='[INSERTA NOMBRE MOVIMIENTO]';
--Sentencia para obtener los datos del movimiento a partir de un id del movimiento	
SELECT * FROM MOVIMIENTO WHERE ID_MOVIMIENTO=[INSERTA ID DEL MOVIMIENTO];
--Sentencia para obtener todos los datos de los movimientos
SELECT * FROM MOVIMIENTO;


--QUERIES POKEMON

--Seleccionar ultimo pokemon insertado
SELECT * FROM POKEMON ORDER BY ID_POKEMON DESC LIMIT 1


--Sentencia para insertar un Pokemon
INSERT INTO POKEMON(NOMBRE, MOTE, VITALIDAD, ATAQUE, DEFENSA, ATAQUE_ESP, DEFENSA_ESP, VELOCIDAD, ESTAMINA, NIVEL, [MOVIMIENTOS INSERTADOS], TIPO1, TIPO2, ESTADO, SPRITE, ENTRENADOR, EQUIPO_CAJA)
    	VALUES('[INSERTA NOMBRE POKEMON]', '[INSERTA MOTE]', [INSERTA VITALIDAD], [INSERTA ATAQUE], [INSERTA DEFENSA], [INSERTA ATAQUE ESPECIAL], [INSERTA DEFENSA ESPECIAL], [INSERTA VELOCIDAD]
    	        , [INSERTA ESTAMINA], [INSERTA NIVEL], [MOVIMIENTOS INSERTADOS], '[INSERTA TIPO1]', '[INSERTA TIPO2]', '[INSERTA ESTADO]'
				, '[INSERTA URL DE LA IMAGEN]', [INSERTA ID_ENTRENADOR], '[INSERTAR EQUIPO O CAJA]');
--Sentencia para borrar un Pokemon
DELETE FROM POKEMON WHERE ID_POKEMON = [INSERTA ID_POKEMON];
--Sentencia para actualizar el nombre de un Pokemon
UPDATE POKEMON SET NOMBRE='[INSERTA NOMBRE]' WHERE ID_POKEMON = [INSERTAR ID_POKEMON];
--Sentencia para actualizar el mote de un Pokemon
UPDATE POKEMON SET MOTE=[INSERTA MOTE] WHERE ID_POKEMON = [INSERTAR ID_POKEMON];
--Sentencia para actualizar la vitalidad de un Pokemon
UPDATE POKEMON SET VITALIDAD=[INSERTA VITALIDAD] WHERE ID_POKEMON = [INSERTAR ID_POKEMON];
--Sentencia para actualizar el ataque de un Pokemon
UPDATE POKEMON SET ATAQUE=[INSERTA ATAQUE] WHERE ID_POKEMON = [INSERTAR ID_POKEMON];
--Sentencia para actualizar la defensa de un Pokemon
UPDATE POKEMON SET DEFENSA=[INSERTA DEFENSA] WHERE ID_POKEMON = [INSERTAR ID_POKEMON];
--Sentencia para actualizar el ataque especial de un Pokemon
UPDATE POKEMON SET ATAQUE_ESP=[INSERTA ATAQUE ESPECIAL] WHERE ID_POKEMON = [INSERTAR ID_POKEMON];
--Sentencia para actualizar la defensa especial de un Pokemon
UPDATE POKEMON SET DEFENSA_ESP=[INSERTA DEFENSA ESPECIAL] WHERE ID_POKEMON = [INSERTAR ID_POKEMON];
--Sentencia para actualizar la velocidad de un Pokemon
UPDATE POKEMON SET VELOCIDAD=[INSERTA VELOCIDAD] WHERE ID_POKEMON = [INSERTAR ID_POKEMON];
--Sentencia para actualizar la estamina de un Pokemon
UPDATE POKEMON SET ESTADO=[INSERTA ESTAMINA] WHERE ID_POKEMON = [INSERTAR ID_POKEMON];
--Sentencia para actualizar el nivel de un Pokemon
UPDATE POKEMON SET NIVEL=[INSERTA NIVEL] WHERE ID_POKEMON = [INSERTAR ID_POKEMON];
--Sentencia para actualizar la experiencia de un Pokemon
UPDATE POKEMON SET EXPERIENCIA=[INSERTA EXPERIENCIA] WHERE ID_POKEMON = [INSERTAR ID_POKEMON];
--Sentencia para actualizar los movimientos de un Pokemon (esto se hace por cada movimiento)
UPDATE POKEMON SET MOVIMIENTO1=[INSERTA ID MOVIMIENTO]  WHERE ID_POKEMON = [INSERTAR ID_POKEMON];
--Sentencia para actualizar la fertilidad de un Pokemon
UPDATE POKEMON SET FERTILIDAD=[INSERTA FERTILIDAD] WHERE ID_POKEMON = [INSERTAR ID_POKEMON];
--Sentencia para actualizar el tipo 1 de un Pokemon
UPDATE POKEMON SET TIPO1=[INSERTA TIPO1] WHERE ID_POKEMON = [INSERTAR ID_POKEMON];
--Sentencia para actualizar el tipo 2 de un Pokemon
UPDATE POKEMON SET TIPO2=[INSERTA TIPO2] WHERE ID_POKEMON = [INSERTAR ID_POKEMON];
--Sentencia para actualizar el estado de un Pokemon
UPDATE POKEMON SET ESTADO=[INSERTA ESTADO] WHERE ID_POKEMON = [INSERTAR ID_POKEMON];
--Sentencia para actualizar la imagen de un Pokemon
UPDATE POKEMON SET SPRITE=[INSERTA URL DE LA IMAGEN] WHERE ID_POKEMON = [INSERTAR ID_POKEMON];
--Sentencia para obtener todos los datos del pokemon a partir de la id pokemon
SELECT * FROM POKEMON WHERE ID_POKEMON= [INSERTAR ID_POKEMON];
--Sentencia para obtener todos los datos del último pokemon
SELECT * FROM POKEMON ORDER BY ID_POKEMON DESC LIMIT 1;
--Sentencia para obtener todos los datos de todos los pokemon
SELECT * FROM POKEMON;
--Sentencia para obtener todos los datos de los pokemon a partir de la id de un entrenador
SELECT * FROM POKEMON WHERE ENTRENADOR= [INSERTA ID_ENTRENADOR];

	
--QUERIES TURNO

--Sentencia para insertar un turno
INSERT INTO TURNO(ID_TURNO, COMBATE, NUM_TURNO, MOVIMIENTO_JUGADOR, MOVIMIENTO_RIVAL) 
VALUES([INSERTA ID TURNO], [INSERTA ID COMBATE], [INSERTA NUMERO TURNO], [INSERTA ID MOVIMIENTO JUGADOR], [INSERTA ID MOVIMIENTO RIVAL]);
--Sentencia para borrar un turno a partir de una id de turno
DELETE FROM TURNO WHERE ID_TURNO = [INSERTA ID TURNO];
--Sentencia para obtener todos los datos del último turno	
SELECT * FROM TURNO ORDER BY ID_ENTRENADOR DESC LIMIT 1;	
--Sentencia para obtener todos los datos del turno a partir de una id de turno
SELECT * FROM TURNO WHERE ID_TURNO= [INSERTA ID TURNO];	
--Sentencia para obtener todos los datos del turno a partir de la id de combate
SELECT * FROM TURNO WHERE COMBATE= [INSERTA ID COMBATE];
--Sentencia para obtener todos los datos de los turnos
SELECT * FROM TURNO;


--QUERIES COMBATE

--Sentencia para insertar combate
INSERT INTO COMBATE (ID_COMBATE, JUGADOR, RIVAL, GANADOR, POKEMON_KO_JUGADOR, POKEMON_KO_RIVAL, COMBATE_JUGADOR_FK, COMBATE_RIVAL_FK, COMBATE_GANADOR_FK) 
VALUES([INSERTA ID_COMBATE],[INSERTA JUGADOR],[INSERTA RIVAL],[INSERTA GANADOR],[INSERTA POKEMON_KO_JUGADOR], ,[INSERTA POKEMON_KO_RIVAL],[INSERTA COMBATE_JUGADOR_FK],[INSERTA COMBATE_RIVAL_FK], ,[INSERTA COMBATE_GANADOR_FK]);

--Sentencia para crear un combate
INSERT INTO COMBATE(JUGADOR,RIVAL,GANADOR,POKEMON_KO_JUGADOR,POKEMON_KO_RIVAL) 
		VALUES([INSERTA ID JUGADOR], [INSERTA ID RIVAL], [INSERTA ID GANADOR], '[INSERTA POKEMON_KO_JUGADOR]', '[INSERTA POKEMON_KO_RIVAL]');
--Sentencia para borrar un combate	
DELETE FROM COMBATE WHERE ID_COMBATE = [INSERTA ID_COMBATE];		
--Sentencia para obtener todos los datos de un combate a partir de la id de combate
SELECT * FROM COMBATE WHERE ID_COMBATE= [INSERTA ID COMBATE];
--Sentencia para obtener todos los datos de un combate a partir de la id de entrenador
SELECT * FROM COMBATE WHERE JUGADOR= [INSERTA ID ENTRENADOR];
--Sentencia para obtener todos los datos de todos los combates
SELECT * FROM COMBATE;