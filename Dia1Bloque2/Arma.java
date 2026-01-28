package Dia1Bloque2;

public class Arma {
	private String nombreArma;
	private int daño;
	
	Arma(String nombreArma, int daño) {
		setNombreArma(nombreArma);
		setDaño(daño);
	}

	public String getNombreArma() {
		return nombreArma;
	}

	public void setNombreArma(String nombreArma) {
		if(nombreArma == null || nombreArma.trim().isEmpty()) {
			System.out.println("Error: El arma no tiene un nombre valido");
			return;
		} else {
			this.nombreArma = nombreArma.substring(0, 1).toUpperCase() + nombreArma.substring(1).toLowerCase();
		}
	}

	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = (daño <= 0) ? 1 : daño;
	}
	
	public String toString() {
		return String.format("\n!Has conseguido un nuevo arma¡\nNombre del Arma: %s\nPuede infligir: %d puntos de daño", nombreArma, daño);
	}
}
