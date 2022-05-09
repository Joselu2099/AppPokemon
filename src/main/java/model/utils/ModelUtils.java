package model.utils;

import eu.iamgio.pokedex.pokemon.*;
import eu.iamgio.pokedex.pokemon.move.*;
import eu.iamgio.pokedex.util.Pair;
import model.Movimiento;
import model.MovimientoNull;
import model.Pokemon;

import static eu.iamgio.pokedex.pokemon.move.MoveCategory.*;

public class ModelUtils {
    public static Pokemon parsePokemon(String nombrePk) {
        PokemonPokedex pk = PokemonPokedex.fromName(nombrePk.toLowerCase());
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
