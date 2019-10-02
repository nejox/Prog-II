package tutorium.builder;

public class Computer {
	private String sNr;
	private String hersteller;
	private int kernAnzahl;
	private Betriebssystem bs;

	private Computer(String sNr, String hersteller, int kernAnzahl, Betriebssystem bs) {
		super();
		this.sNr = sNr;
		this.hersteller = hersteller;
		this.kernAnzahl = kernAnzahl;
		this.bs = bs;
	}

	public void ausfuehren(Programm programm) {

		for (int i = 0; i < kernAnzahl; i++) {
			new Thread() {

				public void run() {
					try {
						Thread.sleep(bs.sleepTime);
					} catch (Exception e) {
						e.printStackTrace();
					}
					programm.fuehreAus();
				}

			}.start();
		}

	}

	public static class ComputerBuilder {

		private String sNr;
		private String hersteller;
		private int kernAnzahl;
		private Betriebssystem bs;

		public ComputerBuilder(String sNr, String hersteller) {
			this.sNr = sNr;
			this.hersteller = hersteller;
			this.kernAnzahl = 1;
			this.bs = Betriebssystem.WINDOWS10;
		}

		public ComputerBuilder withKernen(int anzahl) {
			this.kernAnzahl = anzahl;
			return this;
		}

		public ComputerBuilder withBS(Betriebssystem bs) {
			this.bs = bs;
			return this;
		}

		public Computer build() {
			return new Computer(sNr, hersteller, kernAnzahl, bs);
		}

	}

}
