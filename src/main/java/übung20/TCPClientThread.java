package übung20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientThread {

	public static void main(String[] args) {

		final int PORT = 5000;
		final String HOST = "localhost";

		try (Socket connection = new Socket(HOST, PORT);
				OutputStream os = connection.getOutputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				Scanner scanner = new Scanner(System.in);) {

			System.out.println("Eingabe:");
			String line = scanner.nextLine() + "\n";

			if (!line.isEmpty()) {
				os.write(line.getBytes());
				os.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
