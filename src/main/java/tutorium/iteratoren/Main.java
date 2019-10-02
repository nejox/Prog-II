package tutorium.iteratoren;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
				
		
		Haus h1 = new Haus("Siebenstraße 6")
					.addStockwerk(new Stockwerk(0)
									.addRaum(new Raum("x", 23))
									.addRaum(new Raum("y", 25))
									.addRaum(new Raum("z", 22)))
					.addStockwerk(new Stockwerk(1)
									.addRaum(new Raum("a", 15))
									.addRaum(new Raum("b", 20))
									.addRaum(new Raum("c", 22)));
		
		Haus h2 = new Haus("Sexstraße 7")
					.addStockwerk(new Stockwerk(0)
							.addRaum(new Raum("d", 22))
							.addRaum(new Raum("e", 23)))
					.addStockwerk(new Stockwerk(1)
							.addRaum(new Raum("f", 13))
							.addRaum(new Raum("g", 30))
							.addRaum(new Raum("h",22)));
		
		List<Haus> häuser = new ArrayList<>();
		häuser.add(h1);
		häuser.add(h2);
		
		for (Haus haus : häuser) {
			System.out.println(haus.toString());
			for (Raum r : haus) {
				System.out.println(r.toString());
			}
		}
	}

}
