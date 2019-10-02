package übung12;

import javax.xml.bind.ValidationException;

public class Person {
	private String vorname;
	private String nachname;
	private String straße;
	private String hausnummer;
	private String ort;

	public Person(String vorname, String nachname, String straße, String hausnummer, String ort) throws ValidationException {
		if (Character.isLowerCase(vorname.charAt(0)) || Character.isLowerCase(straße.charAt(0))
				|| Character.isLowerCase(ort.charAt(0)) || !Character.isDigit(hausnummer.charAt(0))) {
			throw new ValidationException("Error");
		}
		this.vorname = vorname;
		this.nachname = nachname;
		this.straße = straße;
		this.hausnummer = hausnummer;
		this.ort = ort;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getStraße() {
		return straße;
	}

	public void setStraße(String straße) {
		this.straße = straße;
	}

	public String getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

}