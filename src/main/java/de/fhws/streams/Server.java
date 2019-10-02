package de.fhws.streams;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try (ServerSocket ss = new ServerSocket(5000);
				Socket connection = ss.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				OutputStream os = connection.getOutputStream();) {

			System.out.println("TCPServer Waiting for client on port 5000");
			System.out.println(
					"THE CLIENT " + connection.getInetAddress() + ":" + connection.getPort() + " IS CONNECTED ");

			while (true) {
				if (br.ready()) {
					String line = br.readLine();
					if (line != null) {
						System.out.println(line);
						os.write("ok".getBytes());
						os.flush();
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
