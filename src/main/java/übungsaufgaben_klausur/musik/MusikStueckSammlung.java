package übungsaufgaben_klausur.musik;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class MusikStueckSammlung {

	HashMap<String, MusikStueck> map;

	public MusikStueckSammlung() {
		map = new HashMap<>();
	}

	public void musikStueckEinfuegen(MusikStueck neu) throws IllegalArgumentException {
		if (map.containsKey(neu.titel)) {
			throw new IllegalArgumentException("Key bereits enthalten");
		} else {
			map.put(neu.titel, neu);
		}

	}

	public MusikStueck[] getAlleMusikStueckeNachTitel() {

		Collection<MusikStueck> liste = map.values();

		MusikStueck[] m = liste.toArray(new MusikStueck[0]);
		Arrays.sort(m, new VergleicheMusikStueckTitel());

		return m;
	}

	public static void main(String[] args) {
		MusikStueck m1 = new MusikStueck("Nachtmusik", "Mozart", 3400);
		MusikStueck m2 = new MusikStueck("Ode an die Freude", "Beethoven", 5600);
		MusikStueck m3 = new MusikStueck("Party", "partyman", 4000);
		MusikStueckSammlung sammlung = new MusikStueckSammlung();
		sammlung.musikStueckEinfuegen(m1);
		sammlung.musikStueckEinfuegen(m2);
		sammlung.musikStueckEinfuegen(m3);
		MusikStueck[] m = sammlung.getAlleMusikStueckeNachTitel();
		
		for (MusikStueck musikStueck : m) {
			System.out.println(musikStueck.toString());
		}		

	}
}
