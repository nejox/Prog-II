package übung19;

public class Naehrstoffangaben {

	int portionsGroesse;
	int anzahlPortionen;
	int eiweiß;
	int fett;
	int kohlenhydrate;
	int natrium;

	private Naehrstoffangaben(int portionsGroesse, int anzahlPortionen, int eiweiß, int fett, int kohlenhydrate,
			int natrium) {
		super();
		this.portionsGroesse = portionsGroesse;
		this.anzahlPortionen = anzahlPortionen;
		this.eiweiß = eiweiß;
		this.fett = fett;
		this.kohlenhydrate = kohlenhydrate;
		this.natrium = natrium;
	}

	public static class NaehrstoffBuilder {
		int portionsGroesse;
		int anzahlPortionen;
		int eiweiß;
		int fett;
		int kohlenhydrate;
		int natrium;

		public NaehrstoffBuilder(int portionsGroesse, int anzahlPortionen) {
			super();
			this.portionsGroesse = portionsGroesse;
			this.anzahlPortionen = anzahlPortionen;
		}

		public NaehrstoffBuilder withEiweiß(int eiweiß) {
			this.eiweiß = eiweiß;
			return this;
		}

		public NaehrstoffBuilder withFett(int fett) {
			this.fett = fett;
			return this;
		}

		public NaehrstoffBuilder withKohlenhydrate(int kohlenhydrate) {
			this.kohlenhydrate = kohlenhydrate;
			return this;
		}

		public NaehrstoffBuilder withNatrium(int natrium) {
			this.natrium = natrium;
			return this;
		}

		public Naehrstoffangaben build() {
			return new Naehrstoffangaben(portionsGroesse, anzahlPortionen, eiweiß, fett, kohlenhydrate, natrium);
		}
	}

}
