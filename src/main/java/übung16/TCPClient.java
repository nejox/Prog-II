package übung16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) {

		final int PORT = 5000;
		final String HOST = "localhost";

		try (Socket connection = new Socket(HOST, PORT);
				OutputStream os = connection.getOutputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				Scanner scanner = new Scanner(System.in);) {

			String msg = "";
			boolean waitForResponse = false;
			boolean gameOver = false;

			while (true) {

				do {
					if (br.ready()) {
						msg = br.readLine();
						if (msg.equals("WON") || msg.equals("LOST")) {
							gameOver = true;
						} else {
							System.out.println("Client: " + msg);
						}
						waitForResponse = false;
					} else if (!br.ready() && !waitForResponse) {
						break;
					}
				} while (true);

				if (gameOver) {
					break;
				}

				System.out.println("Nachricht eingeben:");
				msg = scanner.nextLine() + "\n";

				if (!msg.isEmpty()) {
					os.write(msg.getBytes());
					os.flush();
					waitForResponse = true;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
