package übungsaufgaben_klausur.dateisuche;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Finder {

	public BufferedReader getSystemInAsBufferedReader() {
		// Teilaufgabe a

		return new BufferedReader(new InputStreamReader(System.in));
	}

	public void findStringInFiles(String searchString, String[] filenames) {
		// Teilaufgabe b
		for (String datei : filenames) {
			int index = 1;

			try (BufferedReader br = new BufferedReader(new FileReader(datei));) {
				while (br.ready()) {
					String line = br.readLine();
					if (line.contains(searchString)) {
						System.out.println("Treffer: Zeile " + index + " @" + datei);
					}
					index++;
				}

			} catch (FileNotFoundException e) {
				System.out.println("Fehler beim Öffnen von: " + datei);
			} catch (Exception e) {
			}
		}
	}

	public static void main(String[] args) {
		Finder finder = new Finder();
		BufferedReader br = finder.getSystemInAsBufferedReader();
		String searchString = null;
		try {
			searchString = br.readLine();
			finder.findStringInFiles(searchString, args);
			br.close();
		} catch (IOException ex) {
			System.out.println("Einlesenfehlgeschlagen.");
		}
	}
}