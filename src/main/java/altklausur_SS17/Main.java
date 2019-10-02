package altklausur_SS17;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean ibanCheck(String iban) throws FalscheIBANException {
		if (iban != null && iban.substring(0, 2).equals("DE") && iban.substring(2).length() == 20) {
			return true;
		} else {
			throw new FalscheIBANException("Die IBAN " + iban + " ist ungültig!");
		}
	}

	public static void ibanAusDateiLesen(String pfad) throws Exception {

		try (BufferedReader br = new BufferedReader(new FileReader(pfad));) {

			while (br.ready()) {
				String iban = br.readLine();
				boolean flag = ibanCheck(iban);
				if (!flag) {
					throw new Exception();
				}
			}
			System.out.println("Alle IBANs erfolgreich eingelesen");

		} catch (FalscheIBANException e) {
			throw e;
		} catch (FileNotFoundException e) {
			System.out.println("Datei " + pfad + " nicht gefunden");
		} catch (IOException e) {
			System.out.println("Fehler beim Lesevorgang von Datei: " + pfad);
		} catch (NullPointerException e) {
			System.out.println("Datei " + pfad + " existiert nicht");
		}
	}

	public static void dateienTest(String[] dateien) {

		for (int i = 0; i < dateien.length; i++) {
			try {
				ibanAusDateiLesen(dateien[i]);
			} catch (Exception e) {
				System.out.println("Fehler bei Datei: " + dateien[i]);
			}
		}

	}
}
