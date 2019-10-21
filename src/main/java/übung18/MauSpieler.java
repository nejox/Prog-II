package übung18;

import java.util.ArrayList;

public class MauSpieler {
	private ArrayList<MauKarte> hand = new ArrayList<>();

	public ArrayList<MauKarte> getHand() {
		return hand;
	}

	public void setHand(ArrayList<MauKarte> hand) {
		this.hand = hand;
	}
}
