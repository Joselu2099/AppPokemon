package model;

public class MovimientoEstado extends Movimiento{
	
	Estado estado;
	int numTurnos;
	
	public MovimientoEstado() {
		super();
		this.estado = Estado.SIN_ESTADO;
		this.numTurnos = 0;
	}
	
	public MovimientoEstado(String nombre, Estado estado, int numTurnos) {
		super(nombre);
		this.estado = Estado.SIN_ESTADO;
		this.numTurnos = numTurnos;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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
