package übung17;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) {

		final int PORT = 5000;
		final String HOST = "localhost";

		try (Socket connection = new Socket(HOST, PORT);
				OutputStream os = connection.getOutputStream();
//				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				ObjectOutputStream oos = new ObjectOutputStream(os);
				Scanner scanner = new Scanner(System.in);) {

			while (true) {
				System.out.println("Bitte geben Sie Vorname, Nachname und TelNr der Person an (Absatz jeweils:");

				String vorname = scanner.nextLine();
				String nachname = scanner.nextLine();
				String telnr = scanner.nextLine();

				übung17.Person p1 = new übung17.Person(vorname, nachname, telnr);
				oos.writeObject(p1);
				oos.flush();
				System.out.println("Daten übertragen");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
