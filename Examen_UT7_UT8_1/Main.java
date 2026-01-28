package Examen_UT7_UT8_1;

public class Main {
	public static void main(String[] args) {
		Caja caja = new Caja(20, 20, 20, "Amazon");
		CajaOptima cajaopt = new CajaOptima(50, 50, 50, "AliExpress");
		CajaOptima cajaopt2 = new CajaOptima(50, 50, 50, "AliExpress");
		
		System.out.println(caja);
		System.out.println(cajaopt);
		System.out.println(cajaopt2);
	}
}
