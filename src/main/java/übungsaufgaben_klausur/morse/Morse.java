package übungsaufgaben_klausur.morse;

import java.util.HashMap;

public class Morse {
	public static String[][] tabelle = { { "A", ".−" }, { "B", "−..." }, { "C", "−.-." }, { "D", "-.." }, { "E", "." },
			{ "F", "..-." }, { "G", "--." }, { "H", "...." }, { "I", ".." }, { "J", ".---" }, { "K", "_._" },
			{ "L", ".-.." }, { "M", "--" }, { "N", "-." }, { "O", "---" }, { "P", ".--." }, { "Q", "--.-" },
			{ "R", ".-." }, { "S", "..." }, { "T", "-" }, { "U", "..-" }, { "V", "...-" }, { "W", ".--" },
			{ "X", "-..-" }, { "Y", "-.--" }, { "Z", "--.." } };
	// end tabelle

	public static HashMap getMorseCodeMap(String[][] table) {

		HashMap<String, String> map = new HashMap<>();

//		for (int i = 0; i < table.length; i++) {
//			for (int j = 0; j < table[i].length; j++) {
//
//			}
//		}

		for (String[] codes : table) {
			map.put(codes[0], codes[1]);
		}

		return map;

	}

	public static String zeichenketteToMorse(String s) {
		
		s = s.toUpperCase();
		String result = "";
		HashMap<String, String> map = getMorseCodeMap(tabelle);

		for (int i = 0; i < s.length(); i++) {
			String c = s.substring(i, (i + 1));
			if (c.isEmpty() || c.equals(" ")) {
				result += " ";
			} else {
				result += map.get(c) + " ";
			}
		}

		return result;
	}

	public static void main(String[] args) {
		getMorseCodeMap(tabelle);

		String s = zeichenketteToMorse("Klausurerfolg");
		System.out.println(s);
	}
}
