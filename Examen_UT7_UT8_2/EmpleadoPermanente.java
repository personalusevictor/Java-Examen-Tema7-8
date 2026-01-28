package Examen_UT7_UT8_2;

public class EmpleadoPermanente extends Empleado {
	private Area areaTrabajo;
	private boolean[] beneficios = new boolean[5];

	public EmpleadoPermanente(String dni, String nombre, int edad, Area areaTrabajo) {
		this(dni, nombre, edad, 0, areaTrabajo);
	}
	
	public EmpleadoPermanente(String dni, String nombre, int edad, double salario, Area areaTrabajo) {
		super(dni, nombre, edad, salario);
		setAreaTrabajo(areaTrabajo);
	}

	public Area getAreaTrabajo() {
		return areaTrabajo;
	}

	public void setAreaTrabajo(Area areaTrabajo) {
		if (areaTrabajo == null) {
			System.out.println("Error: el área no puede ser null, inicializadolo a TEST");
			this.areaTrabajo = Area.TEST;
		} else {
			this.areaTrabajo = areaTrabajo;
		}
	}

	public int BeneficioAIndice(String benificio) {
		return switch (benificio.toLowerCase()) {
			case "comidas" -> 0;
			case "salarioextra" -> 1;
			case "vijaes" -> 2;
			case "viernes" -> 3;
			case "equipamiento" -> 4;
			default -> -1;
		};
	}

	public void agregarBenificio(String beneficio) {
		int indice = BeneficioAIndice(beneficio);

		if (indice == -1) {
			System.out.println("Error: benificio no valido");
			return;
		}

		beneficios[indice] = true;
		System.out.println("Beneficio '" + beneficio + "' activado");
	}

	public void quitarBeneficio(String beneficio) {
		int indice = BeneficioAIndice(beneficio);

		if (indice != -1) {
			System.out.println("Error: benficio no valido");
			return;
		}

		beneficios[indice] = false;
		System.out.println("Beneficio '" + beneficio + "' desactivado");
	}

	public String mostrarBeneficios() {
		String[] nombresBeneficios = { "comidas", "salarioextra", "viajes", "viernes", "equipamiento" };
		String beneficiosActivos = "Beneficios activos: ";
		boolean tieneAlgunBeneficio = false;

		for (int i = 0; i < beneficios.length; i++) {
			if (beneficios[i]) {
				beneficiosActivos += nombresBeneficios[i] + " ";
				tieneAlgunBeneficio = true;
			}
		}

		if (!tieneAlgunBeneficio) {
			return "Ningún beneficio activo";
		}

		return beneficiosActivos.trim();
	}
	
	public String toString() {
		return super.toString() + String.format("\nArea de Trabajo: %s\n%s", areaTrabajo, mostrarBeneficios());
	}
}
