package Examen_UT7_UT8_1;

public class CajaOptima extends Caja{
	private static final double FACTOR_REDUCCION = 0.80;
	private static double cartonTotal = 0;
	
	CajaOptima(int ancho, int alto, int fondo, Unidad unidadMedida, String etiqueta) {
		super(ancho, alto, fondo, unidadMedida, etiqueta);
		cartonTotal += getArea();
	}
	
	public double getArea() {
		return 2 * ((getAncho() * getAlto())) + ((getAncho() * getFondo())) + ((getAlto() + getFondo()));
	}
	
	@Override
	public double getVolumen() {
		return super.getVolumen() * FACTOR_REDUCCION;
	}
	
	public static double cartonTotal() {
		return cartonTotal;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format("\nArea: %.4f%s\nVolumen Óptimo: %.4f%s\nCarton Total: %.4f%s", getArea(), getUnidadMedida(),getVolumen(), getUnidadMedida(), cartonTotal(), getUnidadMedida());
	}
	
	@Override
	public boolean equals(Object otro) {
		if (otro == null) {
			return false;
		}
		
		if (this == otro) {
			return true;
		}
		
		CajaOptima otraCajaOptima = (CajaOptima) otro;
		if (getAlto() == otraCajaOptima.getAlto() && getAncho() == otraCajaOptima.getAncho() && getFondo() == otraCajaOptima.getFondo() && getUnidadMedida() == otraCajaOptima.getUnidadMedida() && getEtiqueta().equals(otraCajaOptima.getEtiqueta()) && getVolumen() == otraCajaOptima.getVolumen() && getArea() == otraCajaOptima.getArea()) {
			return true;
		} else {
			return false;
		}
	}
	
}
