package controller;

import model.*;

public class AppPokemon {

    private static AppPokemon INSTANCE;

    private Entrenador currentEntrenador;

    private AppPokemon() {
        //Cargar entrenador logueado registrado en BD
        currentEntrenador = new Entrenador();
        //Hacer load de todos los repositorios
    }

    public static AppPokemon getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new AppPokemon();
        return INSTANCE;
    }

    public void registrarEntrenador(String nombre){
        Entrenador entrenador = new Entrenador(nombre);
        EntrenadorRepository.getINSTANCE().addEntrenador(entrenador);
    }

    public void capturarPokemon(Pokemon pokemon) {
        currentEntrenador.capturar(pokemon);
    }

    public void capturarPokemon(Pokemon pokemon, String mote) {
        asignarMote(mote, pokemon);
        currentEntrenador.capturar(pokemon);
    }

    public void asignarMote(String mote, Pokemon pk){
        pk.setMote(mote);
    }

    public void crearCombate(Entrenador rival){
        Combate combate = new Combate(currentEntrenador, rival);
    }

    public void crearCombateRandom(){
        Combate combate = new Combate(currentEntrenador, EntrenadorRepository.getINSTANCE().generarEntrenadorRandom());
    }

    public boolean ejecutarMovimiento(Pokemon atacante, Pokemon rival, Movimiento mv, String msg){
        if (mv.getClass().getSimpleName().equals(MovimientoAtaque.class.getSimpleName())) {
            MovimientoAtaque mvA = (MovimientoAtaque) mv;
            return atacante.atacar(rival, mvA, msg);
        }
        if (mv.getClass().getSimpleName().equals(MovimientoEstado.class.getSimpleName())) {
            MovimientoEstado mvE = (MovimientoEstado) mv;
            if(rival.isInmune(mvE)){
                msg = rival.getNombre() + " es inmune a " + mvE.getNombre();
                return false;
            }else{
                rival.setEstado(mvE.getEstado());
                return true;
            }
        }
        if (mv.getClass().getSimpleName().equals(MovimientoMejora.class.getSimpleName())) {
            MovimientoMejora mvM = (MovimientoMejora) mv;
            return true;
        }
        return false;
    }

    public void debilitarPokemon(Combate co, Entrenador entrenadorKO, Pokemon pokemonKO, Pokemon pokemonRival){
        co.debilitarPokemon(entrenadorKO, pokemonKO);
        pokemonRival.aumentarExperiencia((int)(pokemonRival.getNivel() + pokemonKO.getNivel()*10) / 4);
    }

    public void finalizarCombate(Combate combate){
        combate.terminarCombate();
        this.currentEntrenador.addCombate(combate);
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
