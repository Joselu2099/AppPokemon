package model.utils;

import eu.iamgio.pokedex.pokemon.PokemonType;
import junit.framework.TestCase;
import model.pokemon.TablaTipos;

public class TablaTiposTest extends TestCase {

    public void testGetEfectividad() {
        assertEquals(TablaTipos.getEfectividad(PokemonType.FIRE, PokemonType.STEEL), 2.0);
        assertEquals(TablaTipos.getEfectividad(PokemonType.NORMAL, PokemonType.ROCK), 0.5);
    }

    public void testGetIndex() {
        assertEquals(TablaTipos.getIndex(PokemonType.WATER), 1);
        assertEquals(TablaTipos.getIndex(PokemonType.PSYCHIC), 12);
    }
}