package übung20;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TCPServerRunnable implements Runnable {

	private static final int PORT = 5000;
	private Socket connection;

	public TCPServerRunnable(Socket connection) {
		super();
		this.connection = connection;
	}

	public static void main(String[] args) {
		try (ServerSocket ss = new ServerSocket(PORT);) {

			while (!ss.isClosed()) {
				Socket connection = ss.accept();
				TCPServerRunnable server1 = new TCPServerRunnable(connection);
				Thread t1 = new Thread(server1);
				t1.start();

				System.out.println("TCPServer Waiting for client on port 5000");
				System.out.println(
						"THE CLIENT " + connection.getInetAddress() + ":" + connection.getPort() + " IS CONNECTED ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				OutputStream os = connection.getOutputStream();) {

			String line = br.readLine();
			System.out.println(line);

		} catch (Exception e) {

		}

	}
}