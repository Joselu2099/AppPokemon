package model;

public class MovimientoMejora extends Movimiento {

    private int mejora;
    private int numTurnos;

    public MovimientoMejora() {
        super();
        this.mejora = 0;
        this.numTurnos = 0;
    }

    public MovimientoMejora(String nombre, int estamina, int mejora, int numTurnos) {
        super(nombre, estamina);
        this.mejora = mejora;
        this.numTurnos = numTurnos;
    }

    public int getMejora() {
        return mejora;
    }

    public void setMejora(int mejora) {
        this.mejora = mejora;
    }

    public int getNumTurnos() {
        return numTurnos;
    }

    public void setNumTurnos(int numTurnos) {
        this.numTurnos = numTurnos;
    }

    public void consumoEstamina() {
        //TODO
    }

}
