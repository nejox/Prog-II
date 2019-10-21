package de.fhws.streams;

public class PrimzahlAnonymerThread {
	public static void main(String[] args) {
		int zahlZumTesten = 633910099;
		Thread t1 = new Thread() {
			@Override
			public void run() {
				boolean istPrimzahl = false;
				if (zahlZumTesten < 2)
					istPrimzahl = false;
				else
					istPrimzahl = true;
				for (int divisor = 2; divisor < zahlZumTesten; divisor++)
					if (zahlZumTesten % divisor == 0)
						istPrimzahl = false;
				System.out.println(zahlZumTesten + " ist " + (istPrimzahl ? "eine " : "keine ") + "Primzahl.");
			}
		};
		t1.start();

		class LocalClassThread extends Thread {
			boolean istPrimzahl;

			@Override
			public void run() {
				if (zahlZumTesten < 2)
					istPrimzahl = false;
				else
					istPrimzahl = true;
				for (int divisor = 2; divisor < zahlZumTesten; divisor++)
					if (zahlZumTesten % divisor == 0)
						istPrimzahl = false;
			}
			
			public boolean getErgebnis() {
				return istPrimzahl;
			}
		}
		LocalClassThread t = new LocalClassThread();
		t.start();
		try {
			t.join();
			System.out.println(t.getErgebnis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
