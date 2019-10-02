package tutorium.iteratoren;

public class Raum {
	String bezeichnung;
	int größe;
	
	public Raum(String bezeichnung, int größe) {
		super();
		this.bezeichnung = bezeichnung;
		this.größe = größe;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public int getGröße() {
		return größe;
	}

	public void setGröße(int größe) {
		this.größe = größe;
	}

	@Override
	public String toString() {
		return "Raum [bezeichnung=" + bezeichnung + ", größe=" + größe + "]";
	}
	
	
}
