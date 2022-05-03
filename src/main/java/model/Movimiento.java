package model;

public abstract class Movimiento {
    private int id;
    private String nombre;

    public Movimiento() {
        this.id = 0;
        this.nombre = "";
    }

    public Movimiento(String nombre) {
        this.id = 0;
        this.nombre = nombre;
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

    public abstract void consumoEstamina();
}
