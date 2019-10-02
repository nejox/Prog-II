package übungsaufgaben_klausur.iterator;

import java.util.Iterator;

public class RouletteZahlenIterator implements Iterator<Integer> {

	private int counter = 0;

	@Override
	public boolean hasNext() {
		return counter <3;
	}

	@Override
	public Integer next() {

		if (counter == 3) {
			return null;
		}

		int number = (int) (Math.random() * 37);
		if (number == 0) {
			counter++;
		}
		return number;
	}

	public void remove() {
		throw new UnsupportedOperationException("remove");
	}

}
