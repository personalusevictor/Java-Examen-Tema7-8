package Dia1Bloque2;

public class Enemigo {
	private String nombreEnemigo;
	private int vidaEnemigo;
	private Arma arma;
	
	public Enemigo(String nombreEnemigo, int vida, Arma arma) {
		setNombreEnemigo(nombreEnemigo);
		setVida(vida);
		setArma(arma);
	}

	public String getNombreEnemigo() {
		return nombreEnemigo;
	}

	public void setNombreEnemigo(String nombreEnemigo) {
		if(nombreEnemigo == null || nombreEnemigo.trim().isEmpty()) {
			System.out.println("Error: Enemigo desconocido");
		} else {
			this.nombreEnemigo = nombreEnemigo.substring(0, 1).toUpperCase() + nombreEnemigo.substring(1).toLowerCase();
		}
	}

	public int getVidaEnemigo() {
		return vidaEnemigo;
	}

	public void setVida(int vidaEnemigo) {
		this.vidaEnemigo = Math.max(0, vidaEnemigo);	
	}
		
	public Arma getArma() { return arma; }

  public void setArma(Arma arma) { this.arma = arma; }
	
	public void recibirDaño(int cantidad) {
		vidaEnemigo = Math.max(0, vidaEnemigo - cantidad);
	}
	
	public boolean estaVivo() {
		return vidaEnemigo > 0;
	}
	
	public String toString() {
		return String.format("Enemigo: %s\nVida: %d", nombreEnemigo, vidaEnemigo);
	}
	
}
