package übung12;

import static org.junit.jupiter.api.Assertions.*;

import javax.xml.bind.ValidationException;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void personOk() throws ValidationException {
		
		Person p = new Person("Jojo", "Schmidt", "Siebenbürger", "67", "Sennfeld");
		
		assertTrue(p.getVorname().equals("Jojo"));
		assertTrue(p.getNachname().equals("Schmidt"));
		assertTrue(p.getStraße().equals("Siebenbürger"));
		assertTrue(p.getHausnummer().equals("67"));
		assertTrue(p.getOrt().equals("Sennfeld"));
	}

	@Test
	void vornameInvalid() throws ValidationException {
		Person p = new Person("jojo", "Schmidt", "Siebenbürger", "67", "Sennfeld");
		assertTrue(p.getVorname().equals("jojo"));
	}

	@Test
	void strasseInvalid() throws ValidationException {
		Person p = new Person("Jojo", "Schmidt", "siebenbürger", "67", "Sennfeld");
		assertTrue(p.getStraße().equals("siebenbürger"));
	}

	@Test
	void ortInvalid() throws ValidationException {
		Person p = new Person("Jojo", "Schmidt", "siebenbürger", "67", "sennfeld");
		assertTrue(p.getOrt().equals("sennfeld"));
	}

	@Test
	void hausnrInvalid() throws ValidationException {
		Person p = new Person("Jojo", "Schmidt", "siebenbürger", "A7", "Sennfeld");
		assertTrue(p.getHausnummer().equals("A7"));
	}

}
