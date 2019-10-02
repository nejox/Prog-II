package übung14;

public class Roboter extends Entscheidungsträger {

	public Entscheidungen entscheide(Gefahren gefahr) {
		if (gefahr == Gefahren.GEFAHR_LINKS) {
			this.entscheidung = Entscheidungen.RECHTS;
		} else if (gefahr == Gefahren.GEFAHR_RECHTS) {
			this.entscheidung = Entscheidungen.LINKS;
		} else {
			this.entscheidung = Entscheidungen.BREMSEN;
		}

		return this.entscheidung;
	}
}
