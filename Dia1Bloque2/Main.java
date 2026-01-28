package Dia1Bloque2;
import java.util.*;

public class Main {
	
	static void mostrarMenuBatalla() {
		System.out.println("\n--- Tu Turno ---");
		System.out.println("1.- Atacar");
		System.out.println("2.- Cambiar Arma");
		System.out.println("3.- Defender (Recibes menos daño)");
		System.out.println("4.- Huir");
		System.out.print("Elige una opción: ");
	}
	
	static void mostrarMenuCambiarArma() {
		System.out.println("\nElige un arma:");
        System.out.println("1.- Espada (15 daño)");
        System.out.println("2.- Daga Rápida (10 daño)");
        System.out.println("3.- Martillo Pesado (20 daño)");
        System.out.print("Opción: ");
	}
	
	private static void esperar(long ms) {
		try { Thread.sleep(ms); } 
		catch (InterruptedException e) { Thread.currentThread().interrupt(); }
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Crear armas
		Arma espada = new Arma("Espada", 15);
		Arma daga = new Arma("Daga Rápida", 10);
		Arma martillo = new Arma("Martillo Pesado", 20);

		// Crear jugador
		Jugador jugador = new Jugador("Víctor", 100, martillo);

		// Crear enemigo
		Enemigo enemigo = new Enemigo("Orco Salvaje", 80, new Arma("Garra", 8));

		// Intro
		System.out.println("=== ¡COMIENZA LA BATALLA! ===");
		System.out.println("Jugador: " + jugador.getNombreJugador() + " | Vida: " + jugador.getVidaJugador());
		System.out.println("Enemigo: " + enemigo.getNombreEnemigo() + " | Vida: " + enemigo.getVidaEnemigo());
		System.out.println();

		// Bucle principal de combate
		while (jugador.estaVivo() && enemigo.estaVivo()) {

			mostrarMenuBatalla();
			int opcion = sc.nextInt();

			switch (opcion) {

				case 1: // Atacar
					System.out.println("\nAtacas al enemigo...");
					jugador.atacar(enemigo);
					break;

				case 2: // Cambiar arma
					mostrarMenuCambiarArma();
					int armaOPC = sc.nextInt();

					switch (armaOPC) {
						case 1: jugador.equiparArma(espada); break;
						case 2: jugador.equiparArma(daga); break;
						case 3: jugador.equiparArma(martillo); break;
						default:
							System.out.println("Arma no válida."); 
							continue;
					}
					System.out.println("Has equipado: " + jugador.getArma().getNombreArma());
					break;

				case 3: // Defender
					System.out.println("\nTe pones en posición defensiva.");
					break;

				case 4: // Huir
					System.out.println("\n¡Has huido del combate!");
					return;

				default:
					System.out.println("Opción incorrecta.");
					continue;
			}

			// Comprobar si enemigo murió
			if(!enemigo.estaVivo()) {
				System.out.println("\n🎉 ¡Has derrotado al enemigo!");
				break;
			}

			esperar(800);

			// Turno del enemigo
			System.out.println("\n--- Turno del enemigo ---");

			if(opcion == 3) {
				int dañoReducido = enemigo.getArma().getDaño() / 2;
				System.out.println("El enemigo te ataca, pero estabas defendiendo. Daño recibido: " + dañoReducido);
				jugador.setVidaJugador(jugador.getVidaJugador() - dañoReducido);
			} else {
				System.out.println("El enemigo te ataca...");
				jugador.setVidaJugador(jugador.getVidaJugador() - enemigo.getArma().getDaño());
			}

			System.out.println("Tu vida actual: " + jugador.getVidaJugador());
			System.out.println("Vida del enemigo: " + enemigo.getVidaEnemigo());

			esperar(800);
		}

		// Resultado final
		if(jugador.estaVivo()) {
			System.out.println("\n🏆 ¡Has ganado la batalla!");
		} else {
			System.out.println("\n💀 El enemigo te ha derrotado...");
		}

		sc.close();
	}
}