package model.utils;

public enum NombresEntrenador {
    ANTONIO(1, "Antonio"),
    JOSEMANU(2, "Jose Manuel"),
    PACO(3, "Paco"),
    JAVI(4, "Javi"),
    ADRIAN(5, "Adrian"),
    ZUZA(7, "Zuza"),
    DAMIAN(8, "Damian"),
    DENIS(9, "Denis"),
    DANI(10, "Dani"),
    PABLO(11, "Pablo"),
    MIGUEL(12, "Miguel"),
    BRYAN(13, "Bryan"),
    JOSE(14, "Jose Andres");

    public final static int NUM_NOMBRES = 14;

    private int id;
    private String name;

    NombresEntrenador(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public static String fromId(int id) {
        for (NombresEntrenador ne : NombresEntrenador.values()) {
            if (ne.id == id) {
                return ne.getName();
            }
        }
        throw new IllegalArgumentException();
    }
}
