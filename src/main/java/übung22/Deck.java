package übung22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Deck {
	List<Karte> karten;

	public void erzeugeDeck() {
		
		 karten = new ArrayList<>();
		
		Arrays.asList(Farbe.values())
		.stream()
		.forEach( (f) -> {
			Arrays.asList(Wert.values())
			.stream()
			.forEach( (w) -> {
				karten.add(new Karte(f, w));
			});
		});
		
		karten.stream().forEach( k ->  System.out.println(k) );
		System.out.println("shit");
	}

	@Override
	public String toString() {
		
		return karten.stream().map( x -> x.farbe.name() + " " + x.wert.name()).collect(Collectors.joining(", "));
	}
	
	public static void main(String[] args) {
		Deck d = new Deck();
		d.erzeugeDeck();
		System.out.println(d.toString());
	}

}
