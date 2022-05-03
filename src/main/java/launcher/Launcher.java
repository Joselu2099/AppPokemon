package launcher;

import model.PokemonRepository;

public class Launcher {
    public static void main(String[] args) {
        PokemonRepository.getInstance();
        PokemonRepository.getInstance().getPokemons().forEach(pk -> System.out.println(pk.toString()));
    }
}
