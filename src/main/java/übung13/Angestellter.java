package übung13;

public class Angestellter {
	private String nachname;
	private String vorname;
	private String id;
	private double gehalt;
	private double gehaltsfaktor;
	private String geburtsdatum;

	public Angestellter(String nachname, String vorname, String id, double gehalt, String geburtsdatum) {
		super();
		this.nachname = nachname;
		this.vorname = vorname;
		this.id = id;
		this.gehalt = gehalt;
		this.geburtsdatum = geburtsdatum;
		this.gehaltsfaktor = 1.0;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getGehalt() {
		return gehalt;
	}

	public void setGehalt(double gehalt) {
		this.gehalt = gehalt;
	}

	public double getGehaltsfaktor() {
		return gehaltsfaktor;
	}

	public void setGehaltsfaktor(double gehaltsfaktor) {
		this.gehaltsfaktor = gehaltsfaktor;
	}

	public String getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

}
