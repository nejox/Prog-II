package übung12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BruchTest {

	@Test
	void bothPositive() {
		Bruch bruch = new Bruch(2, 2);
		assertFalse(0 == bruch.getNenner());
	}

	@Test
	void nennerNegative() {
		Bruch bruch = new Bruch(2, -2);
		assertFalse(0 == bruch.getNenner());
	}
	
	@Test
	void zaehlerNegative() {
		Bruch bruch = new Bruch(-2, 2);
		assertFalse(0 == bruch.getNenner());
	}

	@Test
	void divisionByZero() {
		Bruch bruch = new Bruch(2, 0);
		assertFalse(0 == bruch.getNenner());
	}

}
