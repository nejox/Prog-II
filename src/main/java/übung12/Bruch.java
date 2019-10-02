
package übung12;

public class Bruch {

	private int zaehler;
	private int nenner;

	public Bruch(int zaehler, int nenner) {
		if (nenner == 0) {
			throw new ArithmeticException();
		}
		this.zaehler = zaehler;
		this.nenner = nenner;
	}

	public int getZaehler() {
		return zaehler;
	}

	public void setZaehler(int zaehler) {
		this.zaehler = zaehler;
	}

	public int getNenner() {
		return nenner;
	}

	public void setNenner(int nenner) {
		this.nenner = nenner;
	}
}