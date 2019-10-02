package übungsaufgaben_klausur.gzip;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.zip.GZIPOutputStream;

public class Client {
	public static void main(String[] args) throws IOException {
		byte[] bytesToTransfer = "HalloWelt".getBytes();
		Socket connectionToHost = new Socket("localhost", 5555);
		OutputStream os = connectionToHost.getOutputStream();
		
		GZIPOutputStream gzipos = new GZIPOutputStream(os);
		gzipos.write(bytesToTransfer);
		gzipos.flush();
		gzipos.close();
	}
}