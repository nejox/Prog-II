package übung18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SkatSpiel {

	private ArrayList<SkatKarte> spielset = new ArrayList<>();

	public SkatSpiel() {
		super();
		this.spielset = create_gameset();
	}

	public static void main(String[] args) {
		SkatSpiel spiel = new SkatSpiel();
		
		SkatSpieler spieler1 = new SkatSpieler();
		
		spiel.gibKarten(10, spieler1);
	}

	private ArrayList<SkatKarte> create_gameset() {

		ArrayList<SkatKarte> spielset = new ArrayList<>();

		SkatFarben[] farben = SkatFarben.values();
		SkatWerte[] werte = SkatWerte.values();

		for (int i = 0; i < farben.length; i++) {
			for (int j = 0; j < werte.length; j++) {
				spielset.add(new SkatKarte(farben[i], werte[j]));
			}
		}

		return spielset;
	}

	private void gibKarten(int anzahl, SkatSpieler spieler1) {

		Set<SkatKarte> handKarten = new HashSet<>();

		while (handKarten.size() < anzahl) {
			int j = (int) (Math.random() * spielset.size());
			handKarten.add(spielset.get(j));
		}
		ArrayList<SkatKarte> handKartenListe = new ArrayList<>(handKarten);
		Collections.sort(handKartenListe);

		spieler1.setHand(handKartenListe);
	}
}
