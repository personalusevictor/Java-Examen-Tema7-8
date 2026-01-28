package Dia1Bloque2;

public class Jugador {
	private String nombreJugador;
	private int vidaJugador;
	private Arma arma;
	
	public Jugador(String nombreJugador, int vidaJugador, Arma arma) {
		setNombreJugador(nombreJugador);
		setVidaJugador(vidaJugador);
		setArma(arma);
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		if(nombreJugador == null || nombreJugador.trim().isEmpty()) {
			System.out.println("Error: Enemigo desconocido");
		} else {
			this.nombreJugador = nombreJugador.substring(0, 1).toUpperCase() + nombreJugador.substring(1).toLowerCase();
		}
	}

	public int getVidaJugador() {
		return vidaJugador;
	}

	public void setVidaJugador(int vidaJugador) {
		this.vidaJugador = Math.max(0, vidaJugador);
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}
	
	public void equiparArma(Arma arma) {
		setArma(arma);
		System.out.println("\nHaz equipado el arma: "+getArma().getNombreArma());
	}
	
	public void atacar(Enemigo enemigo) {
		if(enemigo == null || arma == null) return;
			enemigo.recibirDaño(getArma().getDaño());
		System.out.println(getNombreJugador() + " ha atacado a " + enemigo.getNombreEnemigo() + " inflinjiendo " + arma.getDaño() + " puntos de daño");
	}
	
	public boolean estaVivo() {
		return (vidaJugador > 0);
	}
	
	public String toString() {
		return String.format("\n%s\nVida: %d\nArma: %s", nombreJugador, vidaJugador, getArma().getNombreArma());
	}
}
