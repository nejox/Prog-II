package übung16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Telefonmatcher {

	static final String C_SOURCE_PATH = "C:\\Users\\Jojo\\Desktop\\Testdaten\\Telefonstrings.txt";
	static final String C_SOURCE_PATH_CORRPUTED = "C:\\Users\\Jojo\\Desktop\\Testdaten\\Telefonstrings - Corrupted.txt";
	static final String C_TARGET_PATH = "C:\\Users\\Jojo\\Desktop\\Testdaten\\Telefonnr.txt";

	public static void matchNumber(String pfad) throws IOException {

		HandyTastatur[] tastatur = new HandyTastatur[26];
		int i = 2;
		int j = 0;
		int counter = 0;
		char c = 'A';

		while (j < 26) {
			if ((counter >= 3 && (c != 'S' && c != 'Z'))) {
				counter = 0;
				i++;
			}
			tastatur[j] = new HandyTastatur(c, i);
			counter++;
			c++;
			j++;
		}

		try (BufferedReader br = new BufferedReader(new FileReader(pfad));
				BufferedWriter bw = new BufferedWriter(new FileWriter(C_TARGET_PATH));) {

			String s;

			do {
				String nr = "";
				s = br.readLine();
				
				if(s == null) {
					break;
				}
				
				if (!s.isEmpty()) {
					char[] sArray = s.toCharArray();

					try {

						for (i = 0; i < sArray.length; i++) {
							boolean flag = false;

							for (j = 0; j < tastatur.length; j++) {
								if (sArray[i] == tastatur[j].zeichen) {
									nr += String.valueOf(tastatur[j].zahl);
									flag = true;// match getroffen
								}
							}
							if (!flag) {// kein match
								throw new IllegalTelefonNumberException();
							}
						}
						if (!nr.isEmpty()) {
							bw.write(nr);
							bw.newLine();
						}
					} catch (Exception e) {
						// do nothing
					}

				} else {
					continue;
				}
				
			} while (true);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
