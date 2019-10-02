package übung16;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ToUpperCaseWriterTest {

	@Test
	public void writeCharTest() {

		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(baos);
				ToUpperCaseWriter writer = new ToUpperCaseWriter(osw);) {

			writer.write('a');
			writer.flush();
			String uppercase = baos.toString();
			assertEquals(uppercase, "A");
			writer.close();

		} catch (IOException e) {
			fail("IOException" + e.getMessage());
		}

	}

	@Test
	public void write1Test() {

		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(baos);
				ToUpperCaseWriter writer = new ToUpperCaseWriter(osw);) {

			writer.write('1');
			writer.flush();
			String uppercase = baos.toString();
			assertEquals(uppercase, "1");
			writer.close();

		} catch (IOException e) {
			fail("IOException" + e.getMessage());
		}
	}

	@Test
	public void asciiUppercaseTest() {
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(baos);
				ToUpperCaseWriter writer = new ToUpperCaseWriter(osw);) {

			for (int i = 0; i < 128; i++) {
				char c = (char) i;

				writer.write(c);
			}

			writer.flush();
			String uppercase = baos.toString();
			char[] uppercaseArray = uppercase.toCharArray();
			for (int i = 0; i < uppercaseArray.length; i++) {
				if (uppercaseArray[i] >= 'a' && uppercaseArray[i] <= 'z') {
					fail("Kleinschreibung!");
				}
			}

			writer.close();

		} catch (IOException e) {
			fail("IOException" + e.getMessage());
		}
	}

	@Test
	public void asciiUnchangedTest() {
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(baos);
				ToUpperCaseWriter writer = new ToUpperCaseWriter(osw);) {

			char[] cArray = new char[128];

			for (int i = 0; i < 128; i++) {
				char c = (char) i;
				cArray[i] = c;
				writer.write(c);
			}

			writer.flush();
			String uppercase = baos.toString();
			char[] uppercaseArray = uppercase.toCharArray();

			for (int i = 0; i < uppercaseArray.length; i++) {
				if (!(cArray[i] >= 'a' && cArray[i] <= 'z')) {
					assertEquals(cArray[i], uppercaseArray[i]);
				}
			}

			writer.close();

		} catch (IOException e) {
			fail("IOException" + e.getMessage());
		}
	}
}