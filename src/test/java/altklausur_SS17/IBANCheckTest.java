package altklausur_SS17;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.core.Is;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.jupiter.api.Test;

class IBANCheckTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	void testWithRightIBAN() throws FalscheIBANException {
		assertEquals(true, Main.ibanCheck("DE2130120400000BYI1522"));
	}

	@Test
	void testWithWrongIBAN() {
		try {
			Main.ibanCheck("234234222234");
			fail();
		} catch (FalscheIBANException e) {
		}
	}

	@Test
	void testWithEmptyString() {
		try {
			Main.ibanCheck("");
			fail();
		} catch (FalscheIBANException e) {
		}
	}

	// example mit @Rule ansatz

	@Test
	void testWithEmptyString2() throws FalscheIBANException {

		thrown.expect(FalscheIBANException.class);
		thrown.expectMessage("IBAN");
		Main.ibanCheck("");
	}

	@Test
	public void testDivisionWithException() {

		thrown.expect(ArithmeticException.class);

		int i = 1 / 0;

	}
}
