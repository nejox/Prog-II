package übungsaufgaben_klausur.musik;

public class MusikStueck {
	protected String titel; // NamedesMusikstueckes
	protected String interpret;// Gruppe/SaengerdesStueckes
	protected int laenge;// DauerinSekunden

	public MusikStueck(String titel, String interpret, int laenge) {
		this.titel = titel;
		this.interpret = interpret;
		this.laenge = laenge;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getInterpret() {
		return interpret;
	}

	public void setInterpret(String interpret) {
		this.interpret = interpret;
	}

	public int getLaenge() {
		return laenge;
	}

	public void setLaenge(int laenge) {
		this.laenge = laenge;
	}

	public String toString() {
		return "Musikstück mit Titel " + titel + " von " + interpret + " dauert " + laenge + " Sekunden";
	}

}
