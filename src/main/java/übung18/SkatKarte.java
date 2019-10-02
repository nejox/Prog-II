package übung18;

public class SkatKarte implements Comparable<SkatKarte> {

	private SkatFarben farbe;
	private SkatWerte wert;

	public SkatKarte(SkatFarben farbe, SkatWerte wert) {
		super();
		this.farbe = farbe;
		this.wert = wert;
	}

	public SkatFarben getFarbe() {
		return farbe;
	}

	public SkatWerte getWert() {
		return wert;
	}

	@Override
	public int compareTo(SkatKarte o) {

		if (this.getWert().equals(SkatWerte.Bube)) {
			if (o.getWert().equals(SkatWerte.Bube)) {
				return this.getFarbe().compareTo(o.getFarbe());
			} else {
				return -1;
			}

		} else if (o.getWert().equals(SkatWerte.Bube)) {
			if (this.getWert().equals(SkatWerte.Bube)) {
				return this.getFarbe().compareTo(o.getFarbe());
			} else {
				return 1;
			}

		} else {

			int i = this.getFarbe().compareTo(o.getFarbe());
			if (i == 0) {
				return this.getWert().compareTo(o.getWert()) * -1;
			}
			return i;
		}
	}
}
