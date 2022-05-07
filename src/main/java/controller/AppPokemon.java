package controller;

import eu.iamgio.pokedex.pokemon.PokemonType;
import model.*;
import model.utils.NombresEntrenador;

import java.util.ArrayList;

public class AppPokemon {

    private static AppPokemon INSTANCE;

    private Entrenador currentEntrenador;

    private AppPokemon() {
        //Cargar entrenador logueado registrado en BD
        currentEntrenador = new Entrenador();
        //Hacer load de todos los repositorios
    }

    public AppPokemon getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new AppPokemon();
        return INSTANCE;
    }

    public void registrarEntrenador(String nombre){
        Entrenador entrenador = new Entrenador(nombre);
        //TODO
        //Añadir entrenador al Repo
    }

    public void capturarPokemon(Pokemon pokemon) {
        currentEntrenador.capturar(pokemon);
    }

    public int generarNumRandom(int M, int N){
        return (int) Math.floor(Math.random()*(N-M+1)+M);
    }

    public Pokemon generarPokemonRandom() {
        return PokemonRepository.getINSTANCE().getPokemon(generarNumRandom(1,PokemonRepository.getINSTANCE().getNumeroPokemons()));
    }

    public void crearCombate(Entrenador rival){
        Combate combate = new Combate(currentEntrenador, rival);
    }

    public void crearCombateRandom(){
        Combate combate = new Combate(currentEntrenador, generarEntrenador());
    }

    public void atacarPokemon(Pokemon atacante, Pokemon rival, Movimiento mv){
        if(mv.getClass().getSimpleName().equals(MovimientoAtaque.class.getSimpleName())){
            MovimientoAtaque mvA = (MovimientoAtaque) mv;
            if(mvA.getTipo().equals(atacante.getTipos().getFirst()) || mvA.getTipo().equals(atacante.getTipos().getSecond())){
                int potenciaTotal = (int) (atacante.getAtaque()*1.5*mvA.getPotencia()-rival.getDefensa());
            }else{
                int potenciaTotal = atacante.getAtaque()*mvA.getPotencia()-rival.getDefensa();
            }

            if(!rival.isDebil(mvA.getTipo())){

            }
        }
        if(mv.getClass().getSimpleName().equals(MovimientoEstado.class.getSimpleName())){

        }
    }

    public void debilitarPokemon(Combate co, Entrenador entrenadorKO, Pokemon pokemonKO, Pokemon pokemonRival){
        co.debilitarPokemon(entrenadorKO, pokemonKO);
        pokemonRival.aumentarExperiencia((int)(pokemonRival.getNivel() + pokemonKO.getNivel()*10) / 4);
    }

    public void finalizarCombate(Combate combate){
        combate.terminarCombate();
        this.currentEntrenador.addCombate(combate);
    }

    public Entrenador generarEntrenador(){
        return new Entrenador(NombresEntrenador.fromId(generarNumRandom(1,NombresEntrenador.NUM_NOMBRES)), generarEquipoPokemon(5));
    }

    public ArrayList<Pokemon> generarEquipoPokemon(int nivel){
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Pokemon pk = generarPokemonRandom();
            for (int j = 0; j < nivel; j++) {
                pk.subirNivel();
            }
            pokemons.add(generarPokemonRandom());
        }
        return pokemons;
    }

    /*

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Introduce un nombre de un pokemon: ");
            String pokemon = sc.nextLine();
            PokemonPokedex pk = PokemonPokedex.fromName(pokemon.toLowerCase());
            Pair<PokemonType, PokemonType> types = pk.getTypes();
            if (types.getSecond() != null)
                System.out.println(pk.getName() + " es de tipo " + types.getFirst() + " y " + types.getSecond());
            else
                System.out.println(pk.getName() + " es de tipo " + types.getFirst());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

     */
}
