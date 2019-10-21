package übung20;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Kreuzwortraetsel implements Comparator<String> {
	static String[] alleWoerter = { "Bienenschwarm", "Buch", "Bibel", "Beige", "Barriere", "Bein", "Beil", "Christ",
			"Christian", "Carmen" };
	
	public static void main(String[] args) {
//		TreeSet<String> t1 = new TreeSet<>(new WortComparator());
		TreeSet<String> t1 = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() < o2.length()) {
					return -1;
				} else if (o1.length() > o2.length()) {
					return 1;
				} else {
					return o1.compareTo(o2);
				}
			}
		});

		List<String> list = Arrays.asList(alleWoerter);

//		Collections.sort(list, new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				if (o1.length() < o2.length()) {
//					return -1;
//				} else if (o1.length() > o2.length()) {
//					return 1;
//				} else {
//					return o1.compareTo(o2);
//				}
//			}
//		});
//		
//		Collections.sort(list, new WortComparator());

		t1.addAll(list);

		for (String wort : t1) {
			System.out.println(wort);
		}

	}

	@Override
	public int compare(String o1, String o2) {
		if (o1.length() < o2.length()) {
			return -1;
		} else if (o1.length() > o2.length()) {
			return 1;
		} else {
			return o1.compareTo(o2);
		}

	}
}