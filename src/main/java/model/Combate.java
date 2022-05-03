package model;

import java.util.ArrayList;
import java.util.LinkedList;

public class Combate {

    private int idCombate;
    private Entrenador jugador;
    private Entrenador rival;
    private Entrenador ganador;
    private LinkedList<Turno> turnos;
    private ArrayList<Pokemon> pokemonsKOJugador;
    private ArrayList<Pokemon> pokemonsKORival;


    public Combate() {
        this.idCombate = 0;
        this.jugador = new Entrenador();
        this.rival = new Entrenador();
        this.ganador = new Entrenador();
        this.turnos= new LinkedList<>();
        this.pokemonsKOJugador = new ArrayList<>();
        this.pokemonsKORival = new ArrayList<>();
    }
    public Combate(Entrenador jugador, Entrenador rival) {
        this.idCombate = 0;
        this.jugador = jugador;
        this.rival = rival;
        this.ganador = new Entrenador();
        this.turnos= new LinkedList<>();
        this.pokemonsKOJugador = new ArrayList<>();
        this.pokemonsKORival = new ArrayList<>();
    }
    public int getIdCombate() {
        return this.idCombate;
    }

    public void setIdCombate(int idCombate) {
        this.idCombate = idCombate;
    }

    public Entrenador getJugador() {
        return this.jugador;
    }

    public void setJugador(Entrenador jugador) {
        this.jugador = jugador;
    }

    public Entrenador getRival() {
        return this.rival;
    }

    public void setRival(Entrenador rival) {
        this.rival = rival;
    }

    public Entrenador getGanador() {
        return this.ganador;
    }

    public void setGanador(Entrenador ganador) {
        this.ganador = ganador;
    }

    public LinkedList<Turno> getTurnos() {
		return this.turnos;
	}

    public void setTurnos(LinkedList <Turno> turnos) {
		this.turnos = turnos;
	}

    public ArrayList<Pokemon> getPokemonKOJugador()
    {
		return this.pokemonsKOJugador;
	}

    public void setPokemonsKOJugador(ArrayList<Pokemon> pokemonsKOJugador)
    {
		this.pokemonsKOJugador = pokemonsKOJugador;
	}

    public ArrayList<Pokemon> getPokemonsKORival()
    {
		return this.pokemonsKORival;
	}

    public void setPokemonsKORival (ArrayList<Pokemon> pokemonsKORival)
    {
		this.pokemonsKORival = pokemonsKORival;
	}
    public void siguienteTurno() {
        // TODO
    }
    public void terminarCombate() {
        
        if (pokemonsKOJugador.size()==4){
            this.ganador = rival;
            // TODO
        }
        else {
            if (pokemonsKORival.size()==4){
                this.ganador = jugador;
            }
        }
    }
}