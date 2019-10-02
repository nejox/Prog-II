package übung18;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Vokabeltrainer {
	Map<String, HashSet<String>> english2German = new HashMap<>();

	public void addToDictionary(String englischWord, String germanWord) {
		if (english2German.containsKey(englischWord)) {

			HashSet<String> dict = english2German.get(englischWord);
			if (!dict.contains(germanWord)) {
				dict.add(germanWord);
				english2German.put(englischWord, dict);
			}

		} else {

			HashSet<String> german = new HashSet<>();
			german.add(germanWord);
			english2German.put(englischWord, german);
		}
	}

	public void addToDictionarySet(String englischWord, HashSet<String> germanWords) {
		if (english2German.containsKey(englischWord)) {
			HashSet<String> dict = english2German.get(englischWord);

			for (String w : germanWords) {
				if (!dict.contains(w)) {
					dict.add(w);
				}
			}
			
			english2German.put(englischWord, dict);
		} else {
			english2German.put(englischWord, germanWords);
		}
	}

	public void getFromDictionary(String englischWord) {

	}

	public static void main(String[] args) {
		Vokabeltrainer guessingGame = new Vokabeltrainer();
		HashSet<String> germanWords = new HashSet<>();
		germanWords.add("reinigen");
		germanWords.add("säubern");
		guessingGame.addToDictionary("to clean", "reinigen");
		guessingGame.addToDictionary("to clean", "säubern");
		guessingGame.addToDictionarySet("to clean", germanWords);
	}
}
