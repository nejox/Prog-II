package tutorium.iteratoren;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Haus implements Comparable<Haus>, Iterable<Raum> {
	List<Stockwerk> etagen = new ArrayList<>();
	String adresse;

	public Haus(String adresse) {
		super();
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Haus: " + adresse + " mit " + getQuadratmeterSumme() + " m²";
	}

	public Haus addStockwerk(Stockwerk o) {
		etagen.add(o);
		return this;
	}

	public int getQuadratmeterSumme() {
		return this.etagen.stream().reduce(0, (a, b) -> a + b.getFlächeSumme(), Integer::sum);
		// this.stockwerkList.stream().mapToInt(Stockwerk::getQuadratmeterSumme).sum();
	}

	@Override
	public int compareTo(Haus o) {
//		return this.etagen.stream().map(f -> f.räume.stream().reduce(0, (a, b) -> a + b.größe, Integer::sum)).reduce(0,
//				Integer::sum)
//				- o.etagen.stream().map(f -> f.räume.stream().reduce(0, (a, b) -> a + b.größe, Integer::sum)).reduce(0,
//						Integer::sum);
		return getQuadratmeterSumme() - o.getQuadratmeterSumme();
	}

	@Override
	public Iterator<Raum> iterator() {
		return new Iterator<Raum>() {
			private int currentStockwerk = 0;
			private int currentRaum = 0;

			@Override
			public Raum next() {
				Raum raum = etagen.get(currentStockwerk).räume.get(currentRaum);
				currentRaum++;
				if (currentRaum > etagen.get(currentStockwerk).räume.size() - 1) {
					currentStockwerk++;
					currentRaum = 0;
				}

				return raum;
			}

			@Override
			public boolean hasNext() {
				if (currentStockwerk < etagen.size() - 1) {
					return true;
				}

				return currentRaum < etagen.get(currentStockwerk).räume.size() - 1;
			}
		};
	}
}
