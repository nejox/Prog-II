package übung16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MatrikelnrMatcher {

	public static void main(String[] args) {

		try {
			splitStudiengaenge("C:\\Users\\Jojo\\Desktop\\Testdaten\\MatrNr.txt");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static void splitStudiengaenge(String dateiname) throws IOException, MatrikelNummerException {
		BufferedReader br = new BufferedReader(new FileReader(dateiname));

		BufferedWriter bWInf = new BufferedWriter(new FileWriter("C:\\Users\\Jojo\\Desktop\\Testdaten\\WInfNr.txt"));
		BufferedWriter bInf = new BufferedWriter(new FileWriter("C:\\Users\\Jojo\\Desktop\\Testdaten\\InfNr.txt"));
		BufferedWriter bEC = new BufferedWriter(new FileWriter("C:\\Users\\Jojo\\Desktop\\Testdaten\\ECNr.txt"));
		boolean flag = true;
		do {
			String line = br.readLine();
			if (line == null)
				break;

			int matnr = Integer.valueOf(line);

			if (matnr >= 6100000 && matnr <= 6199999) {
				bEC.write(line);
				bEC.newLine();
			} else if (matnr >= 5100000 && matnr <= 5199999) {
				bInf.write(line);
				bInf.newLine();
			} else if (matnr >= 5000000 && matnr <= 5099999) {
				bWInf.write(line);
				bWInf.newLine();
			} else {
				flag = false;
			}

		} while (true);
		
		br.close();
		bEC.close();
		bInf.close();
		bWInf.close();

		if (!flag) {
			throw new MatrikelNummerException();
		}
	}

}
