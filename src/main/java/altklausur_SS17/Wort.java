package altklausur_SS17;

public final class Wort implements Comparable<Wort> {
	String wort, wortTyp, sprache;
	int laenge;

	public Wort(String string) {
		this.wort = string;
	}

	// Methode compareTo aus Comparable
	@Override
	public int compareTo(Wort o) {
		// TODO Auto-generated method stub
		return 0;
	}
}