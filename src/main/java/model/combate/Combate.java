package model.combate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.entrenador.Entrenador;
import model.movimiento.Movimiento;
import model.pokemon.Pokemon;

public class Combate {

    private int id;
    private Entrenador jugador;
    private Entrenador rival;
    private Entrenador ganador;
    private LinkedList<Turno> turnos;
    private ArrayList<Pokemon> pokemonsKOJugador;
    private ArrayList<Pokemon> pokemonsKORival;


    public Combate() {
        this.id = 0;
        this.jugador = new Entrenador();
        this.rival = new Entrenador();
        this.ganador = new Entrenador();
        this.turnos = new LinkedList<>();
        this.pokemonsKOJugador = new ArrayList<>();
        this.pokemonsKORival = new ArrayList<>();
    }

    public Combate(Entrenador jugador, Entrenador rival) {
        this.id = 0;
        this.jugador = jugador;
        this.rival = rival;
        this.ganador = new Entrenador();
        this.turnos = new LinkedList<>();
        this.pokemonsKOJugador = new ArrayList<>();
        this.pokemonsKORival = new ArrayList<>();
    }
    
    

    public Combate(int id, Entrenador jugador, Entrenador rival, Entrenador ganador, List<Turno> turnos,
			List<Pokemon> pokemonsKOJugador, List<Pokemon> pokemonsKORival) {
		this.id = id;
		this.jugador = jugador;
		this.rival = rival;
		this.ganador = ganador;
		this.turnos = (LinkedList<Turno>) turnos;
		this.pokemonsKOJugador = (ArrayList<Pokemon>)pokemonsKOJugador;
		this.pokemonsKORival = (ArrayList<Pokemon>)pokemonsKORival;
	}

	public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setTurnos(LinkedList<Turno> turnos) {
        this.turnos = turnos;
    }

    public ArrayList<Pokemon> getPokemonsKOJugador() {
        return this.pokemonsKOJugador;
    }

    public void setPokemonsKOJugador(ArrayList<Pokemon> pokemonsKOJugador) {
        this.pokemonsKOJugador = pokemonsKOJugador;
    }

    public ArrayList<Pokemon> getPokemonsKORival() {
        return this.pokemonsKORival;
    }

    public void setPokemonsKORival(ArrayList<Pokemon> pokemonsKORival) {
        this.pokemonsKORival = pokemonsKORival;
    }

    public ArrayList<Pokemon> getPokemonsKOGanador() {
        if(ganador.equals(jugador)) return getPokemonsKOJugador();
        else return getPokemonsKORival();
    }

    public void empezarCombate() {
        this.turnos.add(new Turno(1));
    }

    public void siguienteTurno(Movimiento mvJugador, Movimiento mvRival) {
        turnos.getLast().setAccionRealizadaJugador(mvJugador);
        turnos.getLast().setAccionRealizadaRival(mvRival);
        System.out.println(turnos.getLast());
        turnos.add(new Turno(turnos.getLast().getNumTurno()+1));
    }

    public void debilitarPokemon(Entrenador entrenador, Pokemon pokemon){
        if(entrenador.equals(jugador))
            pokemonsKOJugador.add(pokemon);
        else pokemonsKORival.add(pokemon);
    }
    
    public void terminarCombate(Entrenador entrenador){
        if (entrenador.getId()==jugador.getId()){
            this.ganador = rival;
            int cantidad= jugador.getPokedollars()/3;
            rival.addPokedollars(cantidad);
            jugador.retirarPokedollars(cantidad);
        }else{ 
            ganador = jugador; 
            int cantidad= rival.getPokedollars()/3;
            jugador.addPokedollars(cantidad);
            rival.retirarPokedollars(cantidad);
        }
    }
    
    public void setPokemonJugadorUpdated(Pokemon pokemon) {
    	jugador.getPokemons().forEach(pk -> {
    		if(pk.getId()==pokemon.getId())
    			pk=pokemon;
    	});
    }
    
    public void setPokemonRivalUpdated(Pokemon pokemon) {
    	rival.getPokemons().forEach(pk -> {
    		if(pk.getId()==pokemon.getId())
    			pk=pokemon;
    	});
    }

	@Override
	public String toString() {
		return "Combate [id=" + id + ", jugador=" + jugador + ", rival=" + rival + ", ganador=" + ganador + ", turnos="
				+ turnos + ", pokemonsKOJugador=" + pokemonsKOJugador + ", pokemonsKORival=" + pokemonsKORival + "]";
	}
    
    
}