package launcher;

import model.MovimientosRepository;
import model.PokemonRepository;

public class Launcher {
    public static void main(String[] args) {
        MovimientosRepository.getINSTANCE().getMovimientos().forEach(mv -> System.out.println(mv.getNombre()));
    }
}
