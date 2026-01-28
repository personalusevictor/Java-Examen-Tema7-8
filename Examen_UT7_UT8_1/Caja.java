package Examen_UT7_UT8_1;
import java.util.Scanner;


public class Caja {
	
	static Scanner sc = new Scanner(System.in);
	
	private int ancho;
	private int alto;
	private int fondo;
	private Unidad unidadMedida;
	private String etiqueta;
	
	Caja(int ancho, int alto, int fondo, Unidad unidadMedida,String etiqueta) {
		setAncho(ancho);
		setAlto(alto);
		setFondo(fondo);
		setUnidadMedida(unidadMedida);
		setEtiqueta(etiqueta);	
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		if (ancho <= 0) {
			System.out.println("Error: el ancho no es valido, la inicialización de este atributo se realizará a 1");
			this.ancho = 1;
		} else {
			this.ancho = ancho;
		}
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		if (alto <= 0) {
			System.out.println("Error: el alto no es valido, la inicialización de este atributo se realizará a 1");
			this.alto = 1;
		} else {
			this.alto = alto;
		}
	}

	public int getFondo() {
		return fondo;
	}

	public void setFondo(int fondo) {
		if (fondo <= 0) {
			System.out.println("Error: el fondo no es valido, la inicialización de este atributo se realizará a 1");
			this.fondo = 1;
		} else {
			this.fondo = fondo;
		}
	}

	public Unidad getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(Unidad unidadMedida) {
		if (unidadMedida == null) {
			System.out.println("Error: la unidad de medida no es valida, inicializando a \"CM\"");
			this.unidadMedida = Unidad.CM;
		} else {
			this.unidadMedida = unidadMedida;
		}
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		if (etiqueta == null || etiqueta.trim().isEmpty()) {
			System.out.println("Error: la etiqueta no tiene un valor adecuado, inicizandolo a \"Desconocido\"");
			this.etiqueta = "Desconocido";
		} else {
			this.etiqueta = etiqueta.substring(0, 1).toUpperCase() + etiqueta.substring(1);
		}
	}
	
	public double getVolumen() {
		if(this.unidadMedida == Unidad.CM) {
			return ((this.ancho / 100.0) * (this.alto / 100.0) * (this.fondo / 100.0));
		} else {
			return ancho * alto * fondo;
		}
	}

	@Override
	public String toString() {
		getVolumen();
		return String.format("\n=== Información === \nAncho: %d\nAlto: %d\nFondo: %d\nEtiqueta: %s\nVolumen: %.4f%s", ancho, alto, fondo, etiqueta, getVolumen(), unidadMedida);
	}

}
