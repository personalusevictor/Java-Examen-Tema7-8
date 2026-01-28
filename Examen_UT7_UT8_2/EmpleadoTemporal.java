package Examen_UT7_UT8_2;

public class EmpleadoTemporal extends Empleado {
	private int duracionContrato;
	private Area areaTrabajo;
	
	public EmpleadoTemporal(String dni, String nombre, int edad, int duracionContrato, Area areaTrabajo) {
		this(dni, nombre, edad, 0, duracionContrato, areaTrabajo);
	}
	
	public EmpleadoTemporal(String dni, String nombre, int edad, double salario, int duracionContrato, Area areaTrabajo) {
		super(dni, nombre, edad, salario);
		setDuracionContrato(duracionContrato);
		setAreaTrabajo(areaTrabajo);
	}

	public int getDuracionContrato() {
		return duracionContrato;
	}

	public void setDuracionContrato(int duracionContrato) {
		if (duracionContrato < 0) {
			System.out.println("Error: la duración del contrato no es valida, inicializandola a 0");
			this.duracionContrato = 0;
		} else {
			this.duracionContrato = duracionContrato;
		}
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
	
	public void finalizarContrato() {
		duracionContrato = 0;
		System.out.println("Finalización de contrato realizado correctamente.");
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format("%s\nArea de Trabajo: %s", (duracionContrato == 0 ? "Contrato finalizado" : "Duración de contrato: "+duracionContrato+ " meses"), areaTrabajo);
	}
	
	@Override
	public boolean equals(Object otro) {
		if (otro == null) {
			return false;
		}
		
		if(this == otro ) {
			return true;
		}
		
		if (!(otro instanceof EmpleadoTemporal)) {
			return false;
		}
		
		EmpleadoTemporal otroEmpleadoTemporal = (EmpleadoTemporal) otro;
		
		if (super.equals(otroEmpleadoTemporal) && this.duracionContrato == otroEmpleadoTemporal.duracionContrato && this.areaTrabajo == otroEmpleadoTemporal.areaTrabajo) {
			return true;
		} else {
			return false;
		}
	}
	
}
