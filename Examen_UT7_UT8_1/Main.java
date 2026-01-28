package Examen_UT7_UT8_1;

import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	
	static Caja caja = null;
	static CajaOptima cajaOptima = null;

	static void mostrarMenu() {
		System.out.println("\n=== Menu | Caja y CajaOptima ===");
		System.out.println("1.- Crear Objeto Caja");
		System.out.println("2.- Crear Objeto CajaOptima");
		System.out.println("3.- Mostrar Objeto Caja");
		System.out.println("4.- Mostrar Objeto CajaOptima");
		System.out.println("5.- Realizar Equals de CajaOptima");
		System.out.println("6.- Mostrar Cartón Total");
		System.out.println("7.- Salir");
		System.out.print("Elige una opción: ");
	}

	static Unidad mostrarMenuUnidad() {
		int opcion;

		do {
			System.out.println("=== Selección Unidad de Medida ===");
			System.out.println("1.- CM");
			System.out.println("2.- M");
			System.out.println("Elige una opción: ");
			opcion = sc.nextInt();

			switch (opcion) {
				case 1 -> {
					return Unidad.CM;
				}

				case 2 -> {
					return Unidad.M;
				}
				default -> {
					System.out.println("Error: la opción no es valida");
				}
			}
		} while (true);
	}

	public static void main(String[] args) {
		int opcion;
		
		do {
			mostrarMenu();
			opcion = sc.nextInt();
			sc.nextLine();
			
			switch (opcion) {
					case 1 -> {
						System.out.print("Introduce el ancho: ");
						int ancho = sc.nextInt();
						
						System.out.print("Introduce el alto: ");
						int alto = sc.nextInt();
						
						System.out.print("Introduce el fondo: ");
						int fondo = sc.nextInt();
						
						sc.nextLine();
						System.out.println("Introduce etiqueta: ");
						String etiqueta = sc.nextLine();
						
						Unidad unidad = mostrarMenuUnidad();
						
						caja = new Caja(ancho, alto, fondo, unidad, etiqueta);
						System.out.println("Caja creada correctamente.");
					}
					
					case 2 -> {
						System.out.print("Introduce el ancho: ");
						int ancho = sc.nextInt();
						
						System.out.print("Introduce el alto: ");
						int alto = sc.nextInt();
						
						System.out.print("Introduce el fondo: ");
						int fondo = sc.nextInt();
						
						sc.nextLine();
						System.out.println("Introduce etiqueta: ");
						String etiqueta = sc.nextLine();
						
						Unidad unidad = mostrarMenuUnidad();
						
						cajaOptima = new CajaOptima(ancho, alto, fondo, unidad, etiqueta);
						System.out.println("Caja Optima creada correctamente.");
					}
					case 3 -> {
						if(caja == null) {
							System.out.println("Error: no se ha creado ninguna Caja");
						} else {
							System.out.println(caja);
						}
					}
					
					case 4 -> {
						if (cajaOptima == null) {
							System.out.println("Error: no se ha creado ninguna Caja Optima");
						} else {
							System.out.println(cajaOptima);
						}
					}
					
					case 5 -> {
						if(cajaOptima == null) {
							System.out.println("Error: debes crear primero una caja para poder comparar");
							break;
						}
						
						System.out.println("Creando una segunda cajaOptima para comparar...");
						
						System.out.print("Introduce el ancho: ");
						int ancho = sc.nextInt();
						
						System.out.print("Introduce el alto: ");
						int alto = sc.nextInt();
						
						System.out.print("Introduce el fondo: ");
						int fondo = sc.nextInt();
						
						sc.nextLine();
						System.out.println("Introduce etiqueta: ");
						String etiqueta = sc.nextLine();
						
						Unidad unidad = mostrarMenuUnidad();
						
						CajaOptima otra = new CajaOptima(ancho, alto, fondo, unidad, etiqueta);
						
						System.out.println("Comparación equals():");
						if (cajaOptima.equals(otra)) {
							System.out.println("Las cajas óptimas SON IGUALES");
						} else {
							System.out.println("Las cajas óptimas NO SON IGUALES");
						}
					}
					
					case 6 -> {
						System.out.println("Cartón total utilizado: "+CajaOptima.cartonTotal()+"\n");
					}
					
					case 7 -> {
						System.out.println("Saliendo del programa...");
					}
					
					default -> {
						System.out.println("Error: la opción no es valida");
					}
			}
			
		} while (opcion != 7);
	}
}
