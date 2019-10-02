package übung14;

public class Mensch extends Entscheidungsträger {

	@Override
	public Entscheidungen entscheide(Gefahren gefahr) {

		if (gefahr == Gefahren.GEFAHR_LINKS) {
			this.entscheidung = Entscheidungen.RECHTS;
		} else if (gefahr == Gefahren.GEFAHR_RECHTS) {
			this.entscheidung = Entscheidungen.LINKS;
		} else {
			this.entscheidung = Entscheidungen.BREMSEN;
		}

		int wahrscheinlichkeit = (int) (Math.random() * 4);
		if (wahrscheinlichkeit == 0) {
			this.entscheidung = Entscheidungen.UNENTSCHIEDEN;
		}
		
		return this.entscheidung;
	}

}
