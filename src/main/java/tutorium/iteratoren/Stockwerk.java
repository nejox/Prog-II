package tutorium.iteratoren;

import java.util.ArrayList;
import java.util.List;

public class Stockwerk {
	List<Raum> räume = new ArrayList<>();
	int nummer;

	public Stockwerk(int nr) {
		this.nummer = nr;
	}

	public Stockwerk addRaum(Raum r) {
		räume.add(r);
		return this;
	}

	public int getFlächeSumme() {
		return this.räume.stream().reduce(0, (a, b) -> a + b.getGröße(), Integer::sum);
		// this.raumList.stream().mapToInt(Raum::getGroesse).sum();
	}

	public int getRaumAnzahl() {
		return this.räume.size();
	}
}
