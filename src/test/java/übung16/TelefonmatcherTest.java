package übung16;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class TelefonmatcherTest {

	@Test
	void test_EverythingFine() throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(Telefonmatcher.C_TARGET_PATH));) {

			Telefonmatcher.matchNumber(Telefonmatcher.C_SOURCE_PATH);
			int i = 1;
			do {

				String s = br.readLine();

				if (s == null) {
					break;
				}

				if (!s.isEmpty()) {
					if (i == 1) {
						assertEquals("325858238349", s);
					} else if (i == 2) {
						assertEquals("7246438562436", s);
					}
				} else {
					continue;
				}

				i++;
			} while (true);

		} catch (Exception e) {
			fail();
		}

	}

	@Test
	void test_CorruptedFile() {

		try (BufferedReader br = new BufferedReader(new FileReader(Telefonmatcher.C_TARGET_PATH));) {

			Telefonmatcher.matchNumber(Telefonmatcher.C_SOURCE_PATH_CORRPUTED);
			int i = 1;
			do {

				String s = br.readLine();
				if (s == null) {
					break;
				}

				if (!s.isEmpty()) {
					if (i == 1) {
						assertEquals("325858238349", s);
					} else if (i == 2) {
						assertEquals("7246438562436", s);
					} else if (i == 3) {
						assertEquals("2", s);
					}
				} else {
					break;
				}

				i++;
			} while (true);

		} catch (Exception e) {
			fail();
		}
	}

}
