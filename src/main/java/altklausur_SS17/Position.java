package altklausur_SS17;

public final class Position implements Comparable<Position> {
	int zeilennummer, spaltennummer;
	// Methode compareTo aus Comparable

	public Position(int i, int j) {
		this.zeilennummer = i;
		this.spaltennummer = j;
	}

	@Override
	public int compareTo(Position o) {
		
		return this.zeilennummer - o.zeilennummer;
		
	}
}