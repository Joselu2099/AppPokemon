package model;

import eu.iamgio.pokedex.pokemon.PokemonType;
import eu.iamgio.pokedex.pokemon.Sprite;
import eu.iamgio.pokedex.pokemon.Stat;
import eu.iamgio.pokedex.util.Pair;

public class ModelUtils {
    public static Pokemon parsePokemon(String nombrePk){
        eu.iamgio.pokedex.pokemon.PokemonPokedex pk = eu.iamgio.pokedex.pokemon.PokemonPokedex.fromName(nombrePk);
        int id = pk.getId();
        String nombre = pk.getName();
        int vitalidad = pk.getStat(Stat.Type.HP).getBaseStat();
        int ataque = pk.getStat(Stat.Type.ATTACK).getBaseStat();
        int defensa = pk.getStat(Stat.Type.DEFENSE).getBaseStat();
        int ataqueEspecial = pk.getStat(Stat.Type.SPECIAL_ATTACK).getBaseStat();
        int defensaEspecial = pk.getStat(Stat.Type.SPECIAL_DEFENSE).getBaseStat();
        int velocidad = pk.getStat(Stat.Type.SPEED).getBaseStat();
        int experiencia = pk.getBaseExperience();
        Pair<PokemonType, PokemonType> tipos = pk.getTypes();
        String sprite = pk.getSprite(Sprite.Type.FRONT_DEFAULT).getUrl();

        return new Pokemon(id, nombre, vitalidad, ataque, defensa, ataqueEspecial, defensaEspecial, velocidad, experiencia, tipos, sprite);
    }

}
