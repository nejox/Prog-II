package schach;

public class LaeuferImpl extends AbstractFigur implements Laeufer {
	public LaeuferImpl(int x, int y) {
		super(x, y);
	}

	@Override
	public Brett gibErlaubteFelder() {
		Brett brett = new Brett();

		// diagonal links oben
		int x1;
		int y1;
		for (x1 = x, y1 = y; x1 > 0 && y1 > 0; x1--, y1--) {
			brett.markiereFeld(x1, y1);
		}
		// diagonal links unten
		for (x1 = (x+1), y1 = (y+1); x1 > 0 && y1 <= 8; x1--, y1++) {
			brett.markiereFeld(x1, y1);
		}
		// diagonal rechts oben
		for (x1 = (x+1), y1 = (y+1); x1 <= 8 && y1 > 0; x1++, y1--) {
			brett.markiereFeld(x1, y1);
		}
		// diagonal rechts unten
		for (x1 = x, y1 = y; x1 <= 8 && y1 <= 8; x1++, y1++) {
			brett.markiereFeld(x1, y1);
		}
		return brett;
	}

	public static void main(String[] args) {
		LaeuferImpl l = new LaeuferImpl(4, 5);
		Brett brett = l.gibErlaubteFelder();
		for (int j = 1; j <= 8; j++) {
			for (int i = 1; i <= 8; i++) {
				if (brett.gibFeld(i, j))
					System.out.print("x");
				else
					System.out.print("o");
			}
			System.out.println();
		}
	}
}
