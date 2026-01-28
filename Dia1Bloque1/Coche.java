package Dia1Bloque1;

public class Coche {
	private String marca;
	private String modelo;
	private int velocidad;
	
	Coche() {
		this(null, null, 0);
	}
	
	Coche(String marca, String modelo, int velocidad) {
		setMarca(marca);
		setModelo(modelo);
		setVelocidad(velocidad);
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		if(marca == null || marca.trim().isEmpty()) {
			this.marca = "Desconocida";
		} else {
			this.marca = marca;
		}
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		if(modelo == null || modelo.trim().isEmpty()) {
			this.modelo = "Desconocido";
		} else {
			this.modelo = modelo;
		}
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = Math.max(0, velocidad);
	}
	
	public void acelerar(int cantidad) {
		this.velocidad += cantidad;
	}
	
	public void acelerar() {
		this.velocidad += 10;
	}
	
	public void frenar(int cantidad) {
		this.velocidad -= cantidad;
		
		if(this.velocidad <= 0) {
			this.velocidad = 0;
		}
	}
	
	public String toString() {
		return String.format("\nMarca: %s\nModelo: %s\nVelocidad: %d", marca, modelo, velocidad);
	}
	
}
