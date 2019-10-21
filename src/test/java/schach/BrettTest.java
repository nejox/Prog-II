package schach;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class BrettTest {
	@Test
	void test_korrekteFelderMarkiert() {
		int x = 4;
		int y = 5;
		Dame d = new Dame(x, y);
		Brett expectedBrett = new Brett();
		boolean[][] brett = expectedBrett.brett;

		// Turmwege
		for (int i = 0; i < 8; i++) {
			brett[x][i] = true;
			brett[i][y] = true;
		}
		int x1;
		int y1;
		for (x1 = x, y1 = y; x1 >= 0 && y1 >= 0; x1--, y1--) {
			brett[x1][y1] = true;
		}
		// diagonal links unten
		for (x1 = x, y1 = y; x1 >= 0 && y1 < 8; x1--, y1++) {
			brett[x1][y1] = true;
		}
		// diagonal rechts oben
		for (x1 = x, y1 = y; x1 < 8 && y1 >= 0; x1++, y1--) {
			brett[x1][y1] = true;
		}
		// diagonal rechts unten
		for (x1 = x, y1 = y; x1 < 8 && y1 < 8; x1++, y1++) {
			brett[x1][y1] = true;
		}

		Brett markiertesBrett = d.gibErlaubteFelder();
		Assert.assertArrayEquals(expectedBrett.brett, markiertesBrett.brett);

	}

}
