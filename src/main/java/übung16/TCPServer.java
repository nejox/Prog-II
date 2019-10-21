package übung16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) {

		final int PORT = 5000;

		String[] woerter = { "Scheiße", "Programmiersprache", "Auto", "Katze", "Katzenfutter", "Lacrosse",
				"DeineMutter", "Ideenlos" };
		int index = 1;//(int) (Math.random() * woerter.length);
		int versuche = 1;
		String wort = woerter[index].toUpperCase();
		String encrypted = "";
		for (int j = 0; j < wort.length(); j++) {
			encrypted += "_ "; // Verschlüsseltes Wort
		}

		try (ServerSocket ss = new ServerSocket(PORT);
				Socket connection = ss.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				OutputStream os = connection.getOutputStream();) {

			System.out.println("TCPServer Waiting for client on port 5000");
			System.out.println(
					"THE CLIENT " + connection.getInetAddress() + ":" + connection.getPort() + " IS CONNECTED ");

			os.write(("Server: Erraten Sie folgendes Wort: " + encrypted + "\n").getBytes());

			while (true) {

				String s = "";
				char c = ' ';
				boolean flag = false;
				boolean endErraten = false;

				if (br.ready()) {
					s = br.readLine().toUpperCase();// liest bis nächsten Zeilenumbruch, wenn keiner ist failed

					if (!s.isEmpty()) {
						c = s.charAt(0);
						versuche++;
						for (int i = 0; i < wort.length(); i++) {
							if (wort.charAt(i) == c) {
								char[] a = encrypted.toCharArray();
								a[(i * 2)] = c;
								encrypted = String.valueOf(a);
								if (encrypted.indexOf("_") == -1) {
									endErraten = true;
								}
								flag = true;
							}
						}

						if (versuche == 20 && !endErraten) {
							os.write("LOST".getBytes());
							os.write("Server: Verloren - Anzahl Versuche vorbei".getBytes());
							os.flush();
							break;
						}

						if (endErraten) {
							os.write("WON".getBytes());
							os.write("Server: Gewonnen".getBytes());
							os.flush();
							break;
						} else {

							if (flag) {
								os.write("Server: Richtig geraten!\n".getBytes());
								os.write((versuche + ". Versuch: " + encrypted + "\n").getBytes());
							} else {
								os.write(("Server: " + versuche + ". Versuch: Falsch geraten\n").getBytes());
							}
							os.flush();
						}
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}