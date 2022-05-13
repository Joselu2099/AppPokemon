package model.utils;

import eu.iamgio.pokedex.pokemon.*;
import model.pokemon.Pokemon;


public class ModelUtils {
    public static Pokemon parsePokemon(String nombrePk) {
        PokemonPokedex pk = PokemonPokedex.fromName(nombrePk.toLowerCase());
        return new Pokemon(pk.getId()
                , pk.getName()
                , pk.getStat(Stat.Type.HP).getBaseStat()
                , pk.getStat(Stat.Type.ATTACK).getBaseStat()
                , pk.getStat(Stat.Type.DEFENSE).getBaseStat()
                , pk.getStat(Stat.Type.DEFENSE).getBaseStat()
                , pk.getStat(Stat.Type.SPECIAL_DEFENSE).getBaseStat()
                , pk.getStat(Stat.Type.SPEED).getBaseStat()
                , pk.getBaseExperience()
                , pk.getTypes()
                , pk.getSprite(Sprite.Type.FRONT_DEFAULT).getUrl());
    }
    public static Pokemon parsePokemon(int idPokemon) {
        PokemonPokedex pk = PokemonPokedex.fromId(idPokemon);
        return new Pokemon(pk.getId()
                , pk.getName()
                , pk.getStat(Stat.Type.HP).getBaseStat()
                , pk.getStat(Stat.Type.ATTACK).getBaseStat()
                , pk.getStat(Stat.Type.DEFENSE).getBaseStat()
                , pk.getStat(Stat.Type.DEFENSE).getBaseStat()
                , pk.getStat(Stat.Type.SPECIAL_DEFENSE).getBaseStat()
                , pk.getStat(Stat.Type.SPEED).getBaseStat()
                , pk.getBaseExperience()
                , pk.getTypes()
                , pk.getSprite(Sprite.Type.FRONT_DEFAULT).getUrl());
    }

    public static int generarNumRandom(int M, int N){
        return (int) Math.floor(Math.random()*(N-M+1)+M);
    }
}
