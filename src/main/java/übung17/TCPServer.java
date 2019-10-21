package übung17;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) {

		final int PORT = 5000;

		String[] woerter = { "Scheiße", "Programmiersprache", "Auto", "Katze", "Katzenfutter", "Lacrosse",
				"DeineMutter", "Ideenlos" };
		int index = 1;// (int) (Math.random() * woerter.length);
		int versuche = 1;
		String wort = woerter[index].toUpperCase();
		String encrypted = "";
		for (int j = 0; j < wort.length(); j++) {
			encrypted += "_ "; // Verschlüsseltes Wort
		}

		try (ServerSocket ss = new ServerSocket(PORT); Socket connection = ss.accept();
//				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//				OutputStream os = connection.getOutputStream();
				ObjectInputStream ois = new ObjectInputStream(connection.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
						"E:\\Jochen\\Google Drive\\Studium\\Programmieren II\\Testdaten\\person.dat"));) {

			System.out.println("TCPServer Waiting for client on port 5000");
			System.out.println(
					"THE CLIENT " + connection.getInetAddress() + ":" + connection.getPort() + " IS CONNECTED ");

			while (true) {
				Person p1 = (Person) ois.readObject();
				oos.writeObject(p1);
				oos.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}