package übung13;

public class ChangeCalculator extends SimpleChangeCalculator {

	@Override
	public int[] getChange(int euros, int cent) {
		// TODO Auto-generated method stub
		int[] ergebnis = new int[Coin.availableCoins.length];
		int cents = euros * 100 + cent;
		Coin[] coins = Coin.availableCoins;

		for (int i = coins.length - 1; i >= 0; i--) {
			ergebnis[i] = cents / coins[i].getValue();
			cents = cents % coins[i].getValue();
		}
		
		return ergebnis;
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		super.test();
	}

}
