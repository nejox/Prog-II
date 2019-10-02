package übungsaufgaben_klausur.iterator;

import java.util.Iterator;

public class RouletteZahlen implements Iterable<Integer> {

	public static void main(String[] args) {
		RouletteZahlen rZ = new RouletteZahlen();
		Iterator<Integer> iter = rZ.iterator();

//		for (int i = 0; i < 37; i++) {
//			System.out.println(i);
//		}
		
		//c
//		while (iter.hasNext()) {
//			System.out.println(iter.next());
//		}
		for (Integer integer : rZ) {
			System.out.println(integer);
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		return new RouletteZahlenIterator();
	}
}
