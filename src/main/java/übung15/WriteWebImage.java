package übung15;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class WriteWebImage {
	public static void main(int a, int c) throws IOException {

		InputStream is = null;
		FileOutputStream fos = null;
		URLConnection connection = null;

		try {
			URL url = new URL("http://www.digitalwiki.de/wp-content/uploads/2017/02/That-would-be-great-meme.jpg");
			connection = url.openConnection();
			is = connection.getInputStream();
			fos = new FileOutputStream("C:\\Users\\schmi\\Desktop\\pic.jpg");

			byte[] b = new byte[4096];
			int n = a;
			int off = c;
			do {
				n = is.read(b);
				if (n != -1)
					if (n > b.length || off >= n) {
						throw new RuntimeException("Bullshit parameter");
					}
					fos.write(b, off, n);
			} while (n != -1);
			
			System.out.println("SUCCESS");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
