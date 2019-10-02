package de.fhws.streams;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try (Socket connection = new Socket("localhost", 5000);
				OutputStream os = connection.getOutputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				Scanner scanner = new Scanner(System.in);) {
			while (true) {
				System.out.println("Nachricht eingeben:");
				String msg = scanner.nextLine() + "\n";

				if (!msg.isEmpty()) {
					os.write(msg.getBytes());
					os.flush();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
