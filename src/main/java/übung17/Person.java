package übung17;

import java.io.Serializable;

public class Person implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7790530644149659935L;
	private String vorname;
	private String nachname;
	private String telnr;

	public Person(String vorname, String nachname, String telnr) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.telnr = telnr;
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

	public String getTelnr() {
		return telnr;
	}

	public void setTelnr(String telnr) {
		this.telnr = telnr;
	}

}
