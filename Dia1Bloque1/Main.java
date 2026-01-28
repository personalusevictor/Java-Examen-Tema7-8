package Dia1Bloque1;

public class Main {
	public static void main(String[] args) {
		Coche coche1 = new Coche();
		coche1.setMarca("Tesla");
		coche1.setModelo("Model S");
		coche1.setVelocidad(0);
		System.out.println(coche1);
		
		Coche coche2 = new Coche("Audi", "RS7", 0);
		System.out.println(coche2);
		
		Coche coche3 = new Coche("Hyundai", "i30 1.4cv", 0);
		coche3.acelerar(20);
		coche3.acelerar();
		coche3.frenar(15);
		System.out.println(coche3);
	}
}
