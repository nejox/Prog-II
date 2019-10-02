package übung15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Musikdatei {

	private static void copy_buffered(String pfad) throws IOException {

		try (FileInputStream fis_ = new FileInputStream(pfad);
				FileOutputStream fos_ = new FileOutputStream(pfad + "buffered");
				BufferedInputStream fis = new BufferedInputStream(fis_);
				BufferedOutputStream fos = new BufferedOutputStream(fos_);) {

			int b;

			do {
				b = fis.read();
				if (b != -1) {
					fos.write(b);
				}

			} while (b != -1);

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	private static void copy_Notbuffered(String pfad) throws IOException {

		try (FileInputStream fis = new FileInputStream(pfad);
				FileOutputStream fos = new FileOutputStream(pfad + "notbuffered");) {
			int b;
			do {
				b = fis.read();
				if (b != -1) {
					fos.write(b);
				}

			} while (b != -1);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {

		

		try (Scanner scanner = new Scanner(System.in);){
			
			System.out.println("Geben Sie den Pfad zur Musikdatei an");
			String pfad = scanner.nextLine();

			boolean flag = true;
			do {
				try {
					FileInputStream fis = new FileInputStream(pfad);
					flag = false;
					fis.close();
				} catch (FileNotFoundException e) {
					System.out.println("Pfad falsch oder Datei nicht vorhanden - Bitte erneut eingeben");
					pfad = scanner.nextLine();
				}
			} while (flag);

			// Run1
			long startTime = System.currentTimeMillis();

			copy_buffered(pfad);

			long endTime = System.currentTimeMillis();
			long duration = endTime - startTime;
			System.out.println("buffered: " + duration + " ms");

			// Run2
			startTime = System.currentTimeMillis();

			copy_Notbuffered(pfad);

			endTime = System.currentTimeMillis();
			duration = endTime - startTime;
			System.out.println("not buffered: " + duration + " ms");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
