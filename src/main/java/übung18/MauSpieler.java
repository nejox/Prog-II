package übung18;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MauSpieler {
	private ArrayList<MauKarte> hand = new ArrayList<>();

	public ArrayList<MauKarte> getHand() {
		return hand;
	}

	public void setHand(ArrayList<MauKarte> hand) {
		this.hand = hand;
	}
}
