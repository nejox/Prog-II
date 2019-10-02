package übung15;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamDoubler {

	OutputStream os1;
	OutputStream os2;

	public OutputStreamDoubler(OutputStream o, OutputStream s) {
		os1 = o;
		os2 = s;
	}

	public void close() throws IOException {

		try {
			os1.close();
			os2.close();
		} catch (Exception e) {
			throw new IOException();
		}
	}

	public void write(int b) throws IOException {

		boolean flag = false;

		try {
			os1.write(b);
		} catch (Exception e) {
			flag = true;
		}

		try {
			os2.write(b);
		} catch (Exception e) {
			flag = true;
		}

		if (flag)
			throw new IOException();

	}

	public static void main(String[] args) {
		try {
			OutputStream fos1 = new FileOutputStream("E:\\Jochen\\Google Drive\\Studium\\Prog II\\Testdaten\\file1.txt");
			OutputStream fos2 = new FileOutputStream("E:\\Jochen\\Google Drive\\Studium\\Prog II\\Testdaten\\file2.txt");

			OutputStreamDoubler osd = new OutputStreamDoubler(fos1, fos2);

			byte[] b = "Loret Ipsum".getBytes();

			for (int i = 0; i < b.length; i++) {
				osd.write(b[i]);
			}
			
			osd.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
