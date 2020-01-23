package übung20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimzahlThread extends Thread {
	List<Integer> zahlenZumTesten = new ArrayList<>();
	Map<Integer, Boolean> ergebnis = new HashMap<>();

	public PrimzahlThread(List<Integer> zahlenZumTesten) {
		this.zahlenZumTesten = zahlenZumTesten;
	}

	public boolean testeObPrimzahl(int zahlZumTesten) {
		if (zahlZumTesten < 2)
			return false;
		for (int divisor = 2; divisor < zahlZumTesten; divisor++) {
			if (zahlZumTesten % divisor == 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void run() {
		for (Integer integer : zahlenZumTesten) {
			boolean istPrimzahl = testeObPrimzahl(integer);
			ergebnis.put(integer, istPrimzahl);
		}
	}

	public static void main(String[] args) {
		Map<Integer, Boolean> result = new HashMap<>();

		ArrayList<Integer> shit = new ArrayList<>();
		
		shit.add(341);
		shit.add(633910099);
		PrimzahlThread pt1 = new PrimzahlThread(shit);
		pt1.start();
		
		ArrayList<Integer> shit2 = new ArrayList<>();
		shit2.add(7);
		shit2.add(5);
		shit2.add(55);
		PrimzahlThread pt2 = new PrimzahlThread(shit2);
		pt2.start();
		try {
			pt1.join();
			pt2.join();
			result.putAll(pt1.ergebnis);
			result.putAll(pt2.ergebnis);

			for (Map.Entry<Integer, Boolean> entry : result.entrySet()) {
				System.out.println(entry.getKey().toString() + " -> " + entry.getValue().toString());
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}