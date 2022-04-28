package model;

import eu.iamgio.pokedex.pokemon.PokemonType;
import eu.iamgio.pokedex.pokemon.Stat;
import eu.iamgio.pokedex.util.Pair;

public class ModelUtils {
    public static Pokemon parsePokemon(String nombrePk){
        eu.iamgio.pokedex.pokemon.Pokemon pk = eu.iamgio.pokedex.pokemon.Pokemon.fromName(nombrePk);
        int id = pk.getId();
        String nombre = pk.getName();
        int vitalidad = pk.getStat(Stat.Type.HP).getBaseStat();
        int ataque = pk.getStat(Stat.Type.ATTACK).getBaseStat();
        int defensa = pk.getStat(Stat.Type.DEFENSE).getBaseStat();
        int ataqueEspecial = pk.getStat(Stat.Type.SPECIAL_ATTACK).getBaseStat();
        int defensaEspecial = pk.getStat(Stat.Type.SPECIAL_DEFENSE).getBaseStat();
        int velocidad = pk.getStat(Stat.Type.SPEED).getBaseStat();
        int precision = pk.getStat(Stat.Type.ACCURACY).getBaseStat();
        int evasion = pk.getStat(Stat.Type.EVASION).getBaseStat();
        int experiencia = pk.getBaseExperience();
        Pair<PokemonType, PokemonType> tipos = pk.getTypes();

        return new Pokemon(id, nombre, vitalidad, ataque, defensa, ataqueEspecial, defensaEspecial, velocidad, precision, evasion, experiencia, tipos);
    }
}
