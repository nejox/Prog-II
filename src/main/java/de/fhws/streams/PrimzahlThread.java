package de.fhws.streams;

public class PrimzahlThread extends Thread {
	int zahlZumTesten;
	String ergebnis;

	public PrimzahlThread(int zahlZumTesten) {
		this.zahlZumTesten = zahlZumTesten;
	}

	public boolean testeObPrimzahl() {
		if (zahlZumTesten < 2)
			return false;
		for (int divisor = 2; divisor < zahlZumTesten; divisor++)
			if (zahlZumTesten % divisor == 0)
				return false;
		return true;
	}

	@Override
	public void run() {
		boolean istPrimzahl = testeObPrimzahl();
		ergebnis = zahlZumTesten + " ist " + (istPrimzahl ? "eine " : "keine ") + "Primzahl.";
	}

	public static void main(String[] args) {
		PrimzahlThread pt1 = new PrimzahlThread(341);
		pt1.start();
		PrimzahlThread pt2 = new PrimzahlThread(633910099);
		pt2.start();
		
		try {
			pt1.join();
			pt2.join();
			
			System.out.println(pt1.ergebnis);
			System.out.println(pt2.ergebnis);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}