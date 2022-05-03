package model;

public class Turno {
    private int numTurno;
    private Movimiento accionRealizadaJugador;
    private Movimiento accionRealizadaRival;

    public Turno() {
        this.numTurno =0;
        this.accionRealizadaJugador = new MovimientoNull();
        this.accionRealizadaRival = new MovimientoNull();
    }

    public Turno(int numTurno) {
        this.numTurno =numTurno;
        this.accionRealizadaJugador = new MovimientoNull();
        this.accionRealizadaRival = new MovimientoNull();
    }

    public Turno(int numTurno, Movimiento accionRealizadaJugador, Movimiento accionRealizadaRival ) {
        this.numTurno =numTurno;
        this.accionRealizadaJugador = accionRealizadaJugador;
        this.accionRealizadaRival = accionRealizadaRival;        
    }
    public int getNumTurno() {
        return this.numTurno;
    }

    public void setNumTurno(int numTurno) {
        this.numTurno = numTurno;
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
        numTurno++;
        this.accionRealizadaJugador = new MovimientoNull();
        this.accionRealizadaRival = new MovimientoNull();
    }
}
