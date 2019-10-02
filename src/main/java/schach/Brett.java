package schach;

public class Brett {
	boolean[][] brett = new boolean[8][8];

	public Brett() {

	}

	public void markiereFeld(int x, int y) {
		brett[x - 1][y - 1] = true;
	}

	public boolean gibFeld(int x, int y) {
		return brett[x - 1][y - 1];
	}

	public Brett kombiniere(Brett brett) {
		Brett ergebnisBrett = new Brett();
		for (int i = 0; i < this.brett.length; i++) {
			for (int j = 0; j < this.brett[i].length; j++) {
				if (this.brett[i][j] == true || brett.brett[i][j] == true) {
					ergebnisBrett.brett[i][j] = true;
				}
			}
		}

		return ergebnisBrett;
	}

}
