package launcher;

import model.PokemonRepository;

public class Launcher {
    public static void main(String[] args) {
        PokemonRepository.getINSTANCE();
        PokemonRepository.getINSTANCE().getPokemons().forEach(pk -> System.out.println(pk.getSprite()));
    }
}
