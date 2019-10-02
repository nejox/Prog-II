package übungsaufgaben_klausur.iban;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FalscheIBANException extends Exception {

	public FalscheIBANException() {
		super("FEHLER: Datei entḧalt ungültige IBAN");
	}

	public FalscheIBANException(String msg) {
		super(msg);
	}

	static boolean ibanCheck(String iban) throws FalscheIBANException {

		if (iban != null && iban.startsWith("DE") && iban.substring(2).length() == 20) {
			return true;
		} else {
			throw new FalscheIBANException("IBAN " + iban + " ist ungültig!");
		}
	}

	static void ibanAusDateiLesen(String dateiName) throws FalscheIBANException {
		try (BufferedReader br = new BufferedReader(new FileReader(dateiName));) {
			boolean flag = true;

			while (br.ready()) {
				String iban = br.readLine();

				if (!ibanCheck(iban)) {
					flag = false;
				}
			}

			if (flag) {
				System.out.println("Alle IBANs gültig!");
			} else {

			}

		} catch (IOException e) {
			System.out.println("Fehler beim Lesevorgang von Datei: " + dateiName);
		} catch (NullPointerException e) {
			System.out.println("Datei " + dateiName + " existiert nicht");
		}

	}

	public static void main(String[] args) {
		try {
			ibanAusDateiLesen("E:\\Jochen\\Google Drive\\Studium\\Prog II\\Testdaten\\IBANs.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void dateienTest(String[] dateien) {
		for (String datei : dateien) {
			try {
				ibanAusDateiLesen(datei);
			} catch (Exception e) {
				System.out.println("Datei " + datei + " fehlerhaft!");
			}

		}
	}

}
