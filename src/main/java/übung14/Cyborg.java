package übung14;

public class Cyborg extends Entscheidungsträger {
	Mensch mensch;
	Roboter roboter;

	public Cyborg() {
		mensch = new Mensch();
		roboter = new Roboter();
	}

	@Override
	public Entscheidungen entscheide(Gefahren gefahr) {

		Entscheidungen a = mensch.entscheide(gefahr);
		Entscheidungen b = roboter.entscheide(gefahr);

		if (a == b) {
			return a;
		} else {
			return (Math.random() <= 0.5) ? a : b;
		}
	}
}
