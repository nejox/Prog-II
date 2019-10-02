package übung13;

import org.junit.jupiter.api.Test;

import org.junit.Assert;

class ChangeCalculatorTest {

	ChangeCalculator cc = new ChangeCalculator();

	@Test
	void test() {
		int[] ergebnis = new int[] { 0, 0, 1, 1, 1, 0, 0, 1 };
		Assert.assertArrayEquals(ergebnis, cc.getChange(2, 35));
	}

}