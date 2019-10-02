package altklausur_SS17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Warenkorb {

	long Kdnr;
	List<Posten> posten = new ArrayList<>();
	
	private Warenkorb(long kdnr, List<Posten> posten) {
		this.Kdnr = kdnr;
		this.posten = posten;
	}

	public static class WarenkorbBuilder {
		long Kdnr;
		List<Posten> posten = new ArrayList<>();

		public WarenkorbBuilder(long kdnr) {
			this.Kdnr = kdnr;
		}

		public WarenkorbBuilder withProduct(Posten p) {
			this.posten.add(p);
			return this;
		}
		
		public Warenkorb build() {
			return new Warenkorb(Kdnr, posten);
		}

	}

	public static void main(String[] args) {
		WarenkorbBuilder wB = new WarenkorbBuilder(3434);
		Warenkorb wK = wB
						.withProduct(new Posten("3343-A", 34))
						.build();
	}

}
