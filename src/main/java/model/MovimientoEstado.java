package model;

public class MovimientoEstado {
	
	Estado estado;
	int numTurnos;
	
	public MovimientoEstado() {
		this.estado = new Estado();
		this.numTurnos = 0;
	}
	
	public MovimientoEstado(Estado estado, int numTurnos) {
		this.estado = estado;
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
