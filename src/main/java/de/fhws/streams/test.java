package de.fhws.streams;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

public abstract class test {
	public abstract void shit();

	public static void main(String[] args) throws ClassNotFoundException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine(); //gibt null zurück
		FileInputStream fis = new FileInputStream("shit");
		fis.read(); //gibt -1 zurück
		ObjectInputStream ois = new ObjectInputStream(System.in);
		
		try {
			ois.readObject();	
		} catch (EOFException e) {
			// TODO: handle exception
		}
		
		
		try {
			return;
		} finally {
			System.out.println("shit");
		}
	}
}
