package übung18;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MauMau {

	private ArrayList<MauKarte> spielset = new ArrayList<>();

	public MauMau() {
		super();
		this.spielset = createGameset();
	}

	public static void main(String[] args) {
		MauMau spiel = new MauMau();
		MauSpieler spieler1 = new MauSpieler();
		spiel.gibKarten(spieler1);
	}

	private ArrayList<MauKarte> createGameset() {

		ArrayList<MauKarte> spielset = new ArrayList<>();

		MauFarben[] farben = MauFarben.values();
		MauWerte[] werte = MauWerte.values();

		for (int i = 0; i < farben.length; i++) {
			for (int j = 0; j < werte.length; j++) {
				spielset.add(new MauKarte(farben[i], werte[j]));
			}
		}

		return spielset;
	}

	private void gibKarten(MauSpieler spieler1) {

		Set<MauKarte> handKarten = new HashSet<>();

		while (handKarten.size() < 5) {
			int j = (int) (Math.random() * spielset.size());
			handKarten.add(spielset.get(j));
		}
		ArrayList<MauKarte> handKartenListe = new ArrayList<>(handKarten);
		spieler1.setHand(handKartenListe);
	}

}
