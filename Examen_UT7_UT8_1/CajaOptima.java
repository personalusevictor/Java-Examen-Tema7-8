package Examen_UT7_UT8_1;

public class CajaOptima extends Caja{
	static double cartonTotal;
	private double area;
	
	CajaOptima(int ancho, int alto, int fondo, String etiqueta) {
		super(ancho, alto, fondo, etiqueta);
		setArea(area);
		cartonTotal += getArea();
	}

	public double getArea() {
		return 2 * ((getAncho() * getAlto())) + ((getAncho() * getFondo()))	+ ((getAlto() * getFondo()));
	}
	
	public void setArea(double area) {
			this.area = area;
	}

	@Override
	public double getVolumen() {
		return super.getVolumen() / 0.80;
	}
	
	public static double cartonTotal() {
		return cartonTotal;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format("\nArea: %.4f%s\nVolumen Óptimo: %.4f%s\nCartón Total: %.4f%s", getArea(), getUnidadMedida(), getVolumen(), getUnidadMedida(), cartonTotal(), getUnidadMedida());
	}
	
}
