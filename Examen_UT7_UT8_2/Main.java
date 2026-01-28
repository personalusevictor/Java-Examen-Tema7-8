package Examen_UT7_UT8_2;

import java.util.*;

public class Main {

	static Scanner sc = new Scanner(System.in);

	static void mostrarMenu() {
		System.out.println("\n=== Menu | Empleado ===");
		System.out.println("1.- Crear Objeto");
		System.out.println("2.- Mostrar Objeto");
		System.out.println("3.- Aumentar Salario");
		System.out.println("4.- Igualar Empleados equals()");
		System.out.println("5.- Agregar Beneficios a Empleado Permanente");
		System.out.println("6.- Quitar Beneficios a Empleado Permanente");
		System.out.println("0.- Salir");
		System.out.print("Elige una opción: ");
	}

	static void elegirObjeto() {
		System.out.println("\n=== Elegir Objeto ===");
		System.out.println("1.- Empleado");
		System.out.println("2.- Empleado Temporal");
		System.out.println("3.- Empleado Permanente");
		System.out.print("Elige una opción: ");
	}

	static Area elegirArea() {
		System.out.println("\n=== Elegir Area ===");
		System.out.println("1.- Desarrollo");
		System.out.println("2.- Diseño");
		System.out.println("3.- Test");
		System.out.print("Elige una opción: ");

		switch (sc.nextInt()) {
			case 1 -> {
				return Area.DESARROLLO;
			}
			case 2 -> {
				return Area.DISEÑO;
			}
			case 3 -> {
				return Area.TEST;
			}
			default -> {
				System.out.println("\nError: valor no correcto, inicializándolo a Test");
				return Area.TEST;
			}
		}
	}

	public static void main(String[] args) {
		int opcion;

		Empleado empleado = null;
		EmpleadoTemporal empleadoTemporal = null;
		EmpleadoPermanente empleadoPermanente = null;

		do {
			mostrarMenu();
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
				case 1 -> {
					System.out.print("\nDNI: ");
					String dni = sc.nextLine();

					System.out.print("Nombre: ");
					String nombre = sc.nextLine();

					System.out.print("Edad: ");
					int edad = sc.nextInt();

					System.out.print("Salario (0 si no aplica): ");
					double salario = sc.nextDouble();
					sc.nextLine();

					elegirObjeto();
					int opcionObjeto = sc.nextInt();
					sc.nextLine();

					switch (opcionObjeto) {
						case 1 -> empleado = new Empleado(dni, nombre, edad, salario);
						case 2 -> {
							System.out.print("Duración de contrato (meses): ");
							int duracionContrato = sc.nextInt();
							sc.nextLine();
							Area area = elegirArea();
							sc.nextLine();
							empleadoTemporal = new EmpleadoTemporal(dni, nombre, edad, duracionContrato, area);
						}
						case 3 -> {
							Area area = elegirArea();
							sc.nextLine();
							empleadoPermanente = new EmpleadoPermanente(dni, nombre, edad, area);
						}
						default -> System.out.println("\nOpción incorrecta");
					}
				}

				case 2 -> {
					elegirObjeto();
					int opcionObjeto = sc.nextInt();
					sc.nextLine();

					switch (opcionObjeto) {
						case 1 -> {
							if (empleado != null)
								System.out.println(empleado);
							else
								System.out.println("\nNo se ha creado ningún Empleado.");
						}
						case 2 -> {
							if (empleadoTemporal != null)
								System.out.println(empleadoTemporal);
							else
								System.out.println("\nNo se ha creado ningún Empleado Temporal.");
						}
						case 3 -> {
							if (empleadoPermanente != null)
								System.out.println(empleadoPermanente);
							else
								System.out.println("\nNo se ha creado ningún Empleado Permanente.");
						}
						default -> System.out.println("\nOpción incorrecta");
					}
				}

				case 3 -> {
					elegirObjeto();
					int opcionObjeto = sc.nextInt();
					sc.nextLine();

					System.out.print("Cantidad a aumentar: ");
					double cantidad = sc.nextDouble();
					sc.nextLine();

					switch (opcionObjeto) {
						case 1 -> {
							if (empleado != null)
								empleado.aumentarSalario(cantidad);
							else
								System.out.println("\nNo existe el Empleado.");
						}
						case 2 -> {
							if (empleadoTemporal != null)
								empleadoTemporal.aumentarSalario(cantidad);
							else
								System.out.println("\nNo existe el Empleado Temporal.");
						}
						case 3 -> {
							if (empleadoPermanente != null)
								empleadoPermanente.aumentarSalario(cantidad);
							else
								System.out.println("\nNo existe el Empleado Permanente.");
						}
						default -> System.out.println("\nOpción incorrecta");
					}
				}

				case 4 -> {
					if (empleado != null && empleadoTemporal != null)
						System.out.println("Empleado vs Empleado Temporal: " + empleado.equals(empleadoTemporal));
					if (empleado != null && empleadoPermanente != null)
						System.out.println("Empleado vs Empleado Permanente: " + empleado.equals(empleadoPermanente));
					if (empleadoTemporal != null && empleadoPermanente != null)
						System.out
								.println("Empleado Temporal vs Empleado Permanente: " + empleadoTemporal.equals(empleadoPermanente));
				}
				
				case 5 -> {
					if (empleadoPermanente != null) {
						System.out.print("Que beneficio quieres agregar: ");
						empleadoPermanente.agregarBenificio(sc.nextLine());
					} else {
						System.out.println("\nError: no existe ningun empleado permanente");
					}
				}
				
				case 6 -> {
					if (empleadoPermanente != null) {
						System.out.print("Que beneficio quieres quitar: ");
						empleadoPermanente.quitarBeneficio(sc.nextLine());
					} else {
						System.out.println("\nError: no existe ningun empleado permanente");
					}
				}

				case 0 -> System.out.println("\nSaliendo del programa...");
				default -> System.out.println("\nOpción no válida");
			}

		} while (opcion != 0);
	}
}