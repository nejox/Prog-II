package übung22;

import java.util.List;
import java.util.stream.Collectors;

public class BBruder {
	String name;
	int bankDrueckenGewicht;
	int knieBeugenGewicht;

	public BBruder(String name, int bankDrueckenGewicht, int knieBeugenGewicht) {
		this.name = name;
		this.bankDrueckenGewicht = bankDrueckenGewicht;
		this.knieBeugenGewicht = knieBeugenGewicht;
	}

	@Override
	public String toString() {
		return String.format("Name:%s,Bankdrücken:%dkg,Kniebeugen%dkg", name, bankDrueckenGewicht, knieBeugenGewicht);
	}

	public static void main(String[] args) {
		List<BBruder> bBrothers = List.of(new BBruder("Burt", 238, 311), new BBruder("Bronski", 200, 274),
				new BBruder("Bruno", 236, 328));

		System.out.println(bBrothers.stream().reduce("", (a, b) -> a + ", " + b.name, String::concat).substring(2));
		bBrothers.stream().map(b -> b.name).reduce((a, b) -> a + ", " + b).ifPresent(x -> System.out.println(x));
		System.out.println(bBrothers.stream().map(b -> b.name).collect(Collectors.joining(", ")));
		

		System.out.println(bBrothers.stream().reduce(0, (a, b) -> a + b.bankDrueckenGewicht, Integer::sum) / bBrothers.size());

	}
}