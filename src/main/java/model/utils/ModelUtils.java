package model.utils;

import eu.iamgio.pokedex.pokemon.*;
import eu.iamgio.pokedex.util.Pair;
import model.pokemon.Pokemon;


public class ModelUtils {
    public static Pokemon parsePokemon(String nombrePk) {
        PokemonPokedex pk = PokemonPokedex.fromName(nombrePk.toLowerCase());
        PokemonType type1 = pk.getTypes().getFirst();
        PokemonType type2 = pk.getTypes().getSecond();
        if(type1==null) type1=PokemonType.UNKNOWN;
        if(type2==null) type2=PokemonType.UNKNOWN;
        Pair<PokemonType, PokemonType> tipos = new Pair<PokemonType, PokemonType>(type1, type2);
        return new Pokemon(pk.getId()
                , pk.getName()
                , pk.getStat(Stat.Type.HP).getBaseStat()
                , pk.getStat(Stat.Type.ATTACK).getBaseStat()
                , pk.getStat(Stat.Type.DEFENSE).getBaseStat()
                , pk.getStat(Stat.Type.DEFENSE).getBaseStat()
                , pk.getStat(Stat.Type.SPECIAL_DEFENSE).getBaseStat()
                , pk.getStat(Stat.Type.SPEED).getBaseStat()
                , pk.getBaseExperience()
                , tipos
                , pk.getSprite(Sprite.Type.FRONT_DEFAULT).getUrl());
    }
    public static Pokemon parsePokemon(int idPokemon) {
        PokemonPokedex pk = PokemonPokedex.fromId(idPokemon);
        PokemonType type1 = pk.getTypes().getFirst();
        PokemonType type2 = pk.getTypes().getSecond();
        if(type1==null) type1=PokemonType.UNKNOWN;
        if(type2==null) type2=PokemonType.UNKNOWN;
        Pair<PokemonType, PokemonType> tipos = new Pair<PokemonType, PokemonType>(type1, type2);
        return new Pokemon(pk.getId()
                , pk.getName()
                , pk.getStat(Stat.Type.HP).getBaseStat()
                , pk.getStat(Stat.Type.ATTACK).getBaseStat()
                , pk.getStat(Stat.Type.DEFENSE).getBaseStat()
                , pk.getStat(Stat.Type.DEFENSE).getBaseStat()
                , pk.getStat(Stat.Type.SPECIAL_DEFENSE).getBaseStat()
                , pk.getStat(Stat.Type.SPEED).getBaseStat()
                , pk.getBaseExperience()
                , tipos
                , pk.getSprite(Sprite.Type.FRONT_DEFAULT).getUrl());
    }

    public static int generarNumRandom(int M, int N){
        return (int) Math.floor(Math.random()*(N-M+1)+M);
    }
}
