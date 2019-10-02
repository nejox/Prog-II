package übung13;

public class Abteilungsleiter extends Angestellter {

	public Abteilungsleiter(String nachname, String vorname, String id, double gehalt, String geburtsdatum) {
		super(nachname, vorname, id, gehalt, geburtsdatum);
		this.setGehaltsfaktor(2.0);
	}

	public void befoerdern(Angestellter a) {
		a.setGehaltsfaktor(a.getGehaltsfaktor() + a.getGehaltsfaktor() * 0.1);
	}

}
