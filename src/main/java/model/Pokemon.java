package model;

import eu.iamgio.pokedex.item.ItemHold;
import eu.iamgio.pokedex.pokemon.PokemonType;
import eu.iamgio.pokedex.pokemon.move.PokemonPersonalMove;
import eu.iamgio.pokedex.util.Pair;
import java.util.ArrayList;

import static model.ModelUtils.*;

public class Pokemon {

    private final int ESTAMINA_BASE = 10;
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
    private int precision;
    private int evasion;
    private int estamina;
    private int nivel;
    private int experiencia;
    private ArrayList<PokemonPersonalMove> movimientos;
    private int fertilidad;
    private Pair<PokemonType, PokemonType> tipos;
    private Estado estado;
    private ItemHold objeto;

    public Pokemon(int id, String nombre, int vitalidad, int ataque, int defensa, int ataqueEspecial, int defensaEspecial, int velocidad, int precision, int evasion, int experiencia, Pair<PokemonType, PokemonType> tipos) {
        this.id = id;
        this.nombre = nombre;
        this.setMote("");
        this.vitalidad = vitalidad;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataqueEspecial = ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
        this.velocidad = velocidad;
        this.precision = precision;
        this.evasion = evasion;
        this.setEstamina(ESTAMINA_BASE);
        this.setNivel(NIVEL_BASE);
        this.experiencia = experiencia;
        this.movimientos = new ArrayList<>();
        this.setFertilidad(FERTILIDAD_BASE);
        this.tipos = tipos;
        this.setEstado(Estado.SIN_ESTADO);
        this.setObjeto(null);
    }

    public Pokemon(Pokemon pokemon){
        this.id = pokemon.getId();
        this.nombre = pokemon.getNombre();
        this.mote = pokemon.getMote();
        this.vitalidad = pokemon.getVitalidad();
        this.ataque = pokemon.getAtaque();
        this.defensa = pokemon.getDefensa();
        this.ataqueEspecial = pokemon.getAtaqueEspecial();
        this.defensaEspecial = pokemon.getDefensaEspecial();
        this.velocidad = pokemon.getVelocidad();
        this.precision = pokemon.getPrecision();
        this.evasion = pokemon.getEvasion();
        this.estamina = pokemon.getEstamina();
        this.nivel = pokemon.getNivel();
        this.experiencia = pokemon.getExperiencia();
        this.movimientos = pokemon.getMovimientos();
        this.fertilidad = pokemon.getFertilidad();
        this.tipos = pokemon.getTipos();
        this.estado = pokemon.getEstado();
        this.objeto = pokemon.getObjeto();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pokemon(String nombre){
        this(parsePokemon(nombre));
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

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
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

    public ArrayList<PokemonPersonalMove> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<PokemonPersonalMove> movimientos) {
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

    public ItemHold getObjeto() {
        return objeto;
    }

    public void setObjeto(ItemHold objeto) {
        this.objeto = objeto;
    }

    
}
