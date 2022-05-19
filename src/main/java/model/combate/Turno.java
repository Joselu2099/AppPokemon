package model.combate;

import model.movimiento.*;

public class Turno {

    private int id;
    private int numTurno;
    private Movimiento accionRealizadaJugador;
    private Movimiento accionRealizadaRival;
    private Combate combate;

    public Turno() {
        this.id = 0;
        this.numTurno = 0;
        this.accionRealizadaJugador = new MovimientoNull();
        this.accionRealizadaRival = new MovimientoNull();
        this.combate = new Combate();
    }

    public Turno(int numTurno) {
        this.id = 0;
        this.numTurno = numTurno;
        this.accionRealizadaJugador = new MovimientoNull();
        this.accionRealizadaRival = new MovimientoNull();
        this.combate = new Combate();
    }
    
    public Turno(int id , int numTurno, Movimiento accionRealizadaJugador, Movimiento accionRealizadaRival) {
        this.id = id;
    	this.numTurno = numTurno;
        this.accionRealizadaJugador = accionRealizadaJugador;
        this.accionRealizadaRival = accionRealizadaRival;
        this.combate = new Combate();
    }

    public Turno(int id , int numTurno, Movimiento accionRealizadaJugador, Movimiento accionRealizadaRival, Combate combate) {
        this.id = id;
    	this.numTurno = numTurno;
        this.accionRealizadaJugador = accionRealizadaJugador;
        this.accionRealizadaRival = accionRealizadaRival;
        this.combate = combate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Combate getCombate() {
		return combate;
	}
    
    public void setCombate(Combate combate) {
		this.combate = combate;
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

    public void next() {
        numTurno++;
        this.accionRealizadaJugador = new MovimientoNull();
        this.accionRealizadaRival = new MovimientoNull();
    }
    
    @Override
    public String toString() {
    	return "Turno " + numTurno + ":\n"
    			+ " " + "Accion Jugador: " + accionRealizadaJugador + "\n"
    			+ " " + "Accion Rival: " + accionRealizadaRival + "\n";
    }
}
