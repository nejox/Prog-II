package de.fhws.streams;

public class PrimzahlRunnable implements Runnable {
	int zahlZumTesten;
	String ergebnis;

	public PrimzahlRunnable(int zahlZumTesten) {
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

	public static void main(String[] args) {
		PrimzahlRunnable pt1 = new PrimzahlRunnable(341);
		PrimzahlRunnable pt2 = new PrimzahlRunnable(633910099);
		Thread t1 = new Thread(pt1);
		Thread t2 = new Thread(pt2);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();

			System.out.println(pt1.ergebnis);
			System.out.println(pt2.ergebnis);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void run() {
		boolean istPrimzahl = testeObPrimzahl();
		ergebnis = zahlZumTesten + " ist " + (istPrimzahl ? "eine " : "keine ") + "Primzahl.";
	}
}