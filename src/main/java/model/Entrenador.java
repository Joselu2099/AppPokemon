package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import eu.iamgio.pokedex.pokemon.PokemonType;
import eu.iamgio.pokedex.util.Pair;
import model.utils.ModelUtils;

public class Entrenador {

    private static int POKEDOLLARS_BASE = ModelUtils.generarNumRandom(800, 1000);

    private int id;
    private String nombre;
    private ArrayList<Pokemon> pokemons;
    private int pokedollars;
    private CajaPokemon cajaPokemon;
    private List<Combate> combates;

    public Entrenador() {
        this.id = 0;
        this.nombre = "";
        this.pokemons = new ArrayList<Pokemon>();
        this.pokedollars = 0;
        this.cajaPokemon = new CajaPokemon();
        this.combates = new LinkedList<>();
    }

    public Entrenador(String nombre) {
        this.id = 0;
        this.nombre = nombre;
        this.pokemons = new ArrayList<>();
        this.pokedollars = POKEDOLLARS_BASE;
        this.cajaPokemon = new CajaPokemon();
        this.combates = new LinkedList<>();
    }

    public Entrenador(String nombre, ArrayList<Pokemon> pokemons) {
        this.id = 0;
        this.nombre = nombre;
        this.pokemons = pokemons;
        this.pokedollars = POKEDOLLARS_BASE;
        this.cajaPokemon = new CajaPokemon();
        this.combates = new LinkedList<>();
    }

    public Entrenador(int id, String nombre, ArrayList<Pokemon> pokemons, int pokedollars, CajaPokemon cajaPokemon, LinkedList<Combate> combates) {
        this.id = id;
        this.nombre = nombre;
        this.pokemons = pokemons;
        this.pokedollars = pokedollars;
        this.cajaPokemon = cajaPokemon;
        this.combates = combates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public int getPokedollars() {
        return pokedollars;
    }

    public void setPokedollars(int pokedollars) {
        this.pokedollars = pokedollars;
    }

    public CajaPokemon getCajaPokemon() {
        return cajaPokemon;
    }

    public void setCajaPokemon(CajaPokemon cajaPokemon) {
        this.cajaPokemon = cajaPokemon;
    }

    public List<Combate> getCombates() {
        return combates;
    }

    public void setCombates(List<Combate> combates) {
        this.combates = combates;
    }

    public void addPokemon(Pokemon pokemon) {
        if (pokemons.size() == 4) {
            cajaPokemon.addPokemon(pokemon);
        } else pokemons.add(pokemon);
    }

    public boolean sacarPokemon(Pokemon pokemon) {
        if (cajaPokemon.isPokemonInCaja(pokemon)) {
            if (pokemons.size() != 4) {
                pokemons.add(pokemon);
                cajaPokemon.removePokemon(pokemon);
                return true;
            }
        }
        return false;
    }

    public void entrenar() {
        //TODO
    }

    public void capturar(Pokemon pokemon) {
        if(pokemons.size()<4){
            pokemons.add(pokemon);
        }else{
            cajaPokemon.addPokemon(pokemon);
        }
    }

    public void addCombate(Combate combate) {
        combates.add(combate);
    }

    public Pokemon criar(Pokemon padre, Pokemon madre) {
    	String nombres[] = new String[2];
    	nombres[0] = padre.getNombre().substring(0, (int)(padre.getNombre().length())/2);
    	nombres[1] = madre.getNombre().substring(0, (int)(madre.getNombre().length())/2);
    	
    	Pokemon hijo;
		if (ModelUtils.generarNumRandom(0, 1) == 0)
    		hijo = new Pokemon(nombres[0]+nombres[1]);
    	else
    		hijo = new Pokemon(nombres[1]+nombres[0]);

		ArrayList<Movimiento> movimientosHijo = new ArrayList<Movimiento>();
		for (int i = 0; i < 2; i++) {
			movimientosHijo.add(padre.getMovimientos().get(i));
			movimientosHijo.add(madre.getMovimientos().get(i));
		}
		hijo.setMovimientos(movimientosHijo);

		PokemonType tipo1;
		PokemonType tipo2;
		Pair<PokemonType, PokemonType> tipos;
		
		tipo1 = padre.getTipoAleatorio();
		tipo2 = madre.getTipoAleatorio();
		while(tipo1.equals(tipo2)){
		    if(ModelUtils.generarNumRandom(0,1)==0)
		        tipo2 = padre.getTipoAleatorio();
		    else tipo2 = madre.getTipoAleatorio();
		}
		tipos = new Pair<PokemonType, PokemonType>(tipo1, tipo2);
		hijo.setTipos(tipos);

    	if (padre.getAtaque() >= madre.getAtaque()) hijo.setAtaque(padre.getAtaque());
    	else hijo.setAtaque(madre.getAtaque());
    	
    	if (padre.getVitalidad() >= madre.getVitalidad()) hijo.setVitalidad(padre.getVitalidad());
    	else hijo.setVitalidad(madre.getVitalidad());
    	
    	if (padre.getDefensa() >= madre.getDefensa()) hijo.setDefensa(padre.getDefensa());
    	else hijo.setDefensa(madre.getDefensa());
    	
    	if (padre.getAtaqueEspecial() >= madre.getAtaqueEspecial()) hijo.setAtaqueEspecial(padre.getAtaqueEspecial());
    	else hijo.setAtaqueEspecial(madre.getAtaqueEspecial());
    	
    	if (padre.getDefensaEspecial() >= madre.getDefensaEspecial()) hijo.setDefensaEspecial(padre.getDefensaEspecial());
    	else hijo.setDefensaEspecial(madre.getDefensaEspecial());
    	
    	if (padre.getVelocidad() >= madre.getVelocidad()) hijo.setVelocidad(padre.getVelocidad());
    	else hijo.setVelocidad(madre.getVelocidad());
    	
    	if (padre.getEstamina() >= madre.getEstamina()) hijo.setEstamina(padre.getEstamina());
    	else hijo.setEstamina(madre.getEstamina());
    	
    	return hijo;
    }

    public void addPokedollars(int cantidad) {
        this.pokedollars+=cantidad;
    }

    public boolean retirarPokedollars(int cantidad) {
        if(pokedollars-cantidad >= 0) {
            this.pokedollars -= cantidad;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entrenador that = (Entrenador) o;
        return id == that.id && pokedollars == that.pokedollars && nombre.equals(that.nombre) && Objects.equals(pokemons, that.pokemons) && Objects.equals(cajaPokemon, that.cajaPokemon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, pokemons, pokedollars, cajaPokemon);
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", pokemons=" + pokemons +
                ", pokedollars=" + pokedollars +
                ", cajaPokemon=" + cajaPokemon +
                ", combates=" + combates +
                '}';
    }
}
