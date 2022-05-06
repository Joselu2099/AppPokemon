package model;

public abstract class Movimiento {
    private int id;
    private String nombre;
    private int estamina;

    public Movimiento() {
        this.id = 0;
        this.nombre = "";
        this.estamina = 0;
    }

    public Movimiento(String nombre, int estamina) {
        this.id = 0;
        this.nombre = nombre;
        this.estamina = estamina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstamina() {
        return estamina;
    }

    public void setEstamina(int estamina) {
        this.estamina = estamina;
    }

    public abstract void consumoEstamina();
}
