package model;

public class Turno {
    private int numTurnos;
    private Movimiento accionRealizadaJugador;
    private Movimiento accionRealizadaRival;

    public Turno() {
        this.numTurnos=0;
        this.accionRealizadaJugador = null;
        this.accionRealizadaRival = null;
    }
    public Turno(Movimiento accionRealizadaJugador, Movimiento accionRealizadaRival ) {
        this.numTurnos=0;
        this.accionRealizadaJugador = accionRealizadaJugador;
        this.accionRealizadaRival = accionRealizadaRival;        
    }
    public int getNumTurnos() {
        return this.numTurnos;
    }

    public void setNumTurnos(int numTurnos) {
        this.numTurnos = numTurnos;
    }

    public Movimiento getAccionRealizadaJugador() {
        return this.accionRealizadaJugador;
    }

    public void setAccionRealizadaJugador(Movimiento accionRealizadaJugador) {
        this.accionRealizadaJugador = accionRealizadaJugador;
    }

    public Movimiento getAccionRealizadaRival() {
        return this.accionRealizadaRival;
    }

    public void setAccionRealizadaRival(Movimiento accionRealizadaRival) {
        this.accionRealizadaRival = accionRealizadaRival;
    }
    public void next(){
        numTurnos++;
        this.accionRealizadaJugador = null;
        this.accionRealizadaRival = null;
    }
}
