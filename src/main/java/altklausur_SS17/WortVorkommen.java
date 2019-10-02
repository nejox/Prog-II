package altklausur_SS17;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class WortVorkommen implements Comparable<Position> {

	private HashMap<Wort, HashSet<Position>> map = new HashMap<>();

	public static void main(String[] args) {
		Wort und = new Wort("und");
		WortVorkommen woerter = new WortVorkommen();
		woerter.einfuegen(und, new Position(1, 3));
		woerter.einfuegen(und, new Position(3, 7));
		Position letztePosition = woerter.holeLetztePosition(und);
		Collection<Position> allePositionen = woerter.holeAlle(und);
		int anzahlVorkommen = woerter.anzahlVorkommen(und);
	}

	public int anzahlVorkommen(Wort w) {
		HashSet<Position> set = map.get(w);
		return set.size();
	}

	public void einfuegen(Wort w, Position p) {

		if (map.containsKey(w)) {
			HashSet<Position> set = map.get(w);
			set.add(p);
			map.put(w, set);
		} else {
			HashSet<Position> set = new HashSet<>();
			set.add(p);
			map.put(w, set);
		}
	}

	public Collection<Position> holeAlle(Wort w) {
		return map.get(w);
	}

	public Position holeLetztePosition(Wort w) {
		HashSet<Position> set = map.get(w);
		Position p = new Position(0, 0);
		for (Position position : set) {
			if (position.compareTo(p) >= 0) {
				p = position;
			}
		}

		return p;
	}

	@Override
	public int compareTo(Position o) {
		
		return 0;
	}

}
