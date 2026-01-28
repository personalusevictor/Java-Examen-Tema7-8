package Examen_UT7_UT8_2;

public class Empleado {
	private String dni;
	private String nombre;
	private int edad;
	private double salario;
	static private int numDeEmpleados = 0;
	
	public Empleado(String dni, String nombre, int edad) {
		this(dni, nombre, edad, 0);
	}
	
	public Empleado(String dni, String nombre, int edad, double salario) {
		setDni(dni);
		setNombre(nombre);
		setEdad(edad);
		setSalario(salario);
		numDeEmpleados++;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if (dni == null || dni.trim().isEmpty()) {
			System.out.println("Error: el dni no es valido, inicializandolo a \"Desconodio\"");
			this.dni = "Desconocido";
		} else {
			this.dni = dni;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().isEmpty()) {
			System.out.println("Error: el nombre no es valido, inicializadolo a \"Desconocido\"");
			this.nombre = "Desconocido";
		} else {
			this.nombre = nombre;
		}
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		if (edad <= 0 || edad>100) {
			System.out.println("Error: la edad no es valida, inicializandola a 1");
			this.edad = 1;
		} else {
			this.edad = edad;
		}
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		if (salario < 0) {
			System.out.println("Error: el salario no es valido inicializadolo a 0");
			this.salario = 0;
		} else {
			this.salario = salario;
		}
	}

	public static int getNumDeEmpleados() {
		return numDeEmpleados;
	}
	
	public double calcularSalarioAnual() {
		return salario*12;
	}
	
	public void aumentarSalario(double porcentaje) {
		this.salario = (this.salario * porcentaje) / 100;
	}
	
	@Override
	public String toString() {
		return String.format("\n=== Información ===\nDNI: %s\nNombre: %s\nEdad: %d\nSalario: %.2f\nSalario Anual: %.2f", dni, nombre, edad, salario, calcularSalarioAnual());
	}
	
	@Override
	public boolean equals(Object otro) {
		
		if (otro == null) {
			return false;
		}
		
		if (this == otro) {
			return true;
		}
		
		if (!(otro instanceof Empleado)) {
			return false;
		}
		
		Empleado otroemEmpleado = (Empleado) otro;
		if (this.dni.equals(otroemEmpleado.dni) && this.nombre.equals(otroemEmpleado.nombre) && this.edad == otroemEmpleado.edad && this.salario == otroemEmpleado.salario) {
			return true;
		} else {
			return false;
		}
	}
	
}
