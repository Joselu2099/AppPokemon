package model;

import controller.AppPokemon;
import eu.iamgio.pokedex.pokemon.PokemonType;
import eu.iamgio.pokedex.pokemon.move.PokemonPersonalMove;
import eu.iamgio.pokedex.util.Pair;
import model.utils.ModelUtils;
import model.utils.TablaTipos;

import java.util.ArrayList;
import java.util.Objects;

import static model.utils.ModelUtils.parsePokemon;

public class Pokemon {

    private final int ESTAMINA_BASE = 50;
    private final int FERTILIDAD_BASE = 5;
    private final int NIVEL_BASE = 0;

    private int id;
    private String nombre;
    private String mote;
    private int vitalidad;
    private int ataque;
    private int defensa;
    private int ataqueEspecial;
    private int defensaEspecial;
    private int velocidad;
    private int estamina;
    private int nivel;
    private int experiencia;
    private ArrayList<Movimiento> movimientos;
    private int fertilidad;
    private Pair<PokemonType, PokemonType> tipos;
    private Estado estado;
    private String sprite;

    public Pokemon(int id, String nombre, int vitalidad, int ataque, int defensa, int ataqueEspecial, int defensaEspecial, int velocidad, int experiencia, Pair<PokemonType, PokemonType> tipos, String sprite) {
        this.id = id;
        this.nombre = nombre;
        this.mote = nombre;
        this.vitalidad = vitalidad;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataqueEspecial = ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
        this.velocidad = velocidad;
        this.setEstamina(ESTAMINA_BASE);
        this.setNivel(NIVEL_BASE);
        this.experiencia = experiencia;
        this.movimientos = new ArrayList<>();
        this.setFertilidad(FERTILIDAD_BASE);
        this.tipos = tipos;
        this.setEstado(Estado.SIN_ESTADO);
        this.sprite = sprite;
    }

    public Pokemon(int id, String nombre, String mote, int vitalidad, int ataque, int defensa, int ataqueEspecial, int defensaEspecial, int velocidad, int estamina, int nivel, int experiencia, ArrayList<Movimiento> movimientos, int fertilidad, Pair<PokemonType, PokemonType> tipos, Estado estado, String sprite) {
        this.id = id;
        this.nombre = nombre;
        this.mote = mote;
        this.vitalidad = vitalidad;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataqueEspecial = ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
        this.velocidad = velocidad;
        this.estamina = estamina;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.movimientos = movimientos;
        this.fertilidad = fertilidad;
        this.tipos = tipos;
        this.estado = estado;
        this.sprite = sprite;
    }

    public Pokemon(Pokemon pokemon) {
        this.id = pokemon.getId();
        this.nombre = pokemon.getNombre();
        this.mote = pokemon.getMote();
        this.vitalidad = pokemon.getVitalidad();
        this.ataque = pokemon.getAtaque();
        this.defensa = pokemon.getDefensa();
        this.ataqueEspecial = pokemon.getAtaqueEspecial();
        this.defensaEspecial = pokemon.getDefensaEspecial();
        this.velocidad = pokemon.getVelocidad();
        this.estamina = pokemon.getEstamina();
        this.nivel = pokemon.getNivel();
        this.experiencia = pokemon.getExperiencia();
        this.movimientos = pokemon.getMovimientos();
        this.fertilidad = pokemon.getFertilidad();
        this.tipos = pokemon.getTipos();
        this.estado = pokemon.getEstado();
        this.sprite = pokemon.getSprite();
    }

    public Pokemon(String nombre) {
        this(parsePokemon(nombre));
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

    public String getMote() {
        return mote;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }

    public int getVitalidad() {
        return vitalidad;
    }

    public void setVitalidad(int vitalidad) {
        this.vitalidad = vitalidad;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public void setAtaqueEspecial(int ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }

    public int getDefensaEspecial() {
        return defensaEspecial;
    }

    public void setDefensaEspecial(int defensaEspecial) {
        this.defensaEspecial = defensaEspecial;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getEstamina() {
        return estamina;
    }

    public void setEstamina(int estamina) {
        this.estamina = estamina;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public int getFertilidad() {
        return fertilidad;
    }

    public void setFertilidad(int fertilidad) {
        this.fertilidad = fertilidad;
    }

    public Pair<PokemonType, PokemonType> getTipos() {
        return tipos;
    }

    public void setTipos(Pair<PokemonType, PokemonType> tipos) {
        this.tipos = tipos;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public void subirNivel(){
        this.nivel++;
        this.estamina+=ModelUtils.generarNumRandom(1,5);
        this.vitalidad+=ModelUtils.generarNumRandom(1,5);
        this.ataque+=ModelUtils.generarNumRandom(1,5);
        this.defensa+=ModelUtils.generarNumRandom(1,5);
        this.ataqueEspecial+=ModelUtils.generarNumRandom(1,5);
        this.defensaEspecial+=ModelUtils.generarNumRandom(1,5);
        this.velocidad+=ModelUtils.generarNumRandom(1,5);
    }

    public void aumentarExperiencia(int cantidad){
        this.experiencia = cantidad;
        if(experiencia >= 10*nivel){
            subirNivel();
        }
    }

    public boolean atacar(Pokemon rival, MovimientoAtaque mvA, String msg){
        if(this.getEstamina()-mvA.consumoEstamina() >= 0) {
                int potenciaTotal = 0;
                if(rival.isInmune(mvA)){
                    msg = rival.getNombre() + " es inmune a " + mvA.getNombre();
                    return false;
                }
                potenciaTotal = (int) (this.getAtaque() * mvA.getPotencia() - rival.getDefensa());
                if(this.isTipo(mvA.getTipo()))
                    potenciaTotal = (int) (this.getAtaque() * 1.5 * mvA.getPotencia() - rival.getDefensa());
                if(TablaTipos.getEfectividad(mvA.getTipo(), rival.getTipos().getFirst())==0.5
                        || TablaTipos.getEfectividad(mvA.getTipo(), rival.getTipos().getSecond())==0.5)
                    potenciaTotal = (int) (this.getAtaque() * 0.5 * mvA.getPotencia() - rival.getDefensa());

                msg = this.getNombre() + " ejecuta " + mvA.getNombre() + " haciendo " + potenciaTotal + "de daño a " + rival.getNombre();
                switch (this.tieneVentaja(rival)) {
                    case VENTAJA:
                        potenciaTotal = 2*potenciaTotal;
                        msg = this.getNombre() + " ejecuta " + mvA.getNombre() + " haciendo " + potenciaTotal + "de daño a " + rival.getNombre() + " [Es muy efectivo]";
                        break;
                    case DESVENTAJA:
                        msg = this.getNombre() + " ejecuta " + mvA.getNombre() + " haciendo " + potenciaTotal + "de daño a " + rival.getNombre() + " [Es poco efectivo]";
                        break;
                    case NEUTRO:
                    default:
                        break;
                }
                rival.setVitalidad(rival.getVitalidad()-potenciaTotal);
                return true;
        }else{
            msg = this.getNombre() + "no tiene suficiente estamina para hacer " + mvA.getNombre();
            return false;
        }
    }

    public void aplicarMejora(MovimientoMejora mvM, String msg){
        //TODO
    }

    public void descansar(){
        if(estamina <= ESTAMINA_BASE-5)
            this.estamina+=5;
    }

    public void aprenderAtaque(){
        //TODO
    }

    public boolean isTipo(PokemonType type){
        return (tipos.getFirst().equals(type) || tipos.getSecond().equals(type));
    }

    public VentajaDesventaja tieneVentaja(Pokemon rival){
        double e1 = TablaTipos.getEfectividad(tipos.getFirst(), rival.getTipos().getFirst());
        double e2 = TablaTipos.getEfectividad(tipos.getFirst(), rival.getTipos().getSecond());
        double e3 = TablaTipos.getEfectividad(tipos.getSecond(), rival.getTipos().getFirst());
        double e4 = TablaTipos.getEfectividad(tipos.getSecond(), rival.getTipos().getSecond());
        if(e1 == 2.0 || e2 == 2.0 || e3 == 2.0 || e4 == 2.0) return VentajaDesventaja.VENTAJA;
        if(e1 == 1.0 || e2 == 1.0 || e3 == 1.0 || e4 == 1.0) return VentajaDesventaja.NEUTRO;
        if(e1 == 0.5 || e2 == 0.5 || e3 == 0.5 || e4 == 0.5) return  VentajaDesventaja.DESVENTAJA;
        throw new IllegalArgumentException();
    }

    public boolean isInmune(Movimiento mv){
        double e1 = TablaTipos.getEfectividad(tipos.getFirst(), mv.getTipo());
        double e2 = TablaTipos.getEfectividad(tipos.getFirst(), mv.getTipo());
        return (e1==0 || e2==0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return id == pokemon.id && vitalidad == pokemon.vitalidad && ataque == pokemon.ataque && defensa == pokemon.defensa && ataqueEspecial == pokemon.ataqueEspecial && defensaEspecial == pokemon.defensaEspecial && velocidad == pokemon.velocidad && estamina == pokemon.estamina && nivel == pokemon.nivel && experiencia == pokemon.experiencia && fertilidad == pokemon.fertilidad && nombre.equals(pokemon.nombre) && Objects.equals(mote, pokemon.mote) && Objects.equals(movimientos, pokemon.movimientos) && Objects.equals(tipos, pokemon.tipos) && estado == pokemon.estado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, mote, vitalidad, ataque, defensa, ataqueEspecial, defensaEspecial, velocidad, estamina, nivel, experiencia, movimientos, fertilidad, tipos, estado);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", mote='" + mote + '\'' +
                ", vitalidad=" + vitalidad +
                ", ataque=" + ataque +
                ", defensa=" + defensa +
                ", ataqueEspecial=" + ataqueEspecial +
                ", defensaEspecial=" + defensaEspecial +
                ", velocidad=" + velocidad +
                ", estamina=" + estamina +
                ", nivel=" + nivel +
                ", experiencia=" + experiencia +
                ", movimientos=" + movimientos +
                ", fertilidad=" + fertilidad +
                ", tipo1=" + tipos.getFirst() +
                ", tipo2=" + tipos.getSecond() +
                ", estado=" + estado +
                ", sprite='" + sprite + '\'' +
                '}';
    }
}
