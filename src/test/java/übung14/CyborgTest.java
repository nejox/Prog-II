package übung14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CyborgTest {

	@Test
	void test_EntscheidungNichtZufällig() {
		Cyborg cy = new Cyborg();
		Entscheidungen entscheidung = cy.entscheide(Gefahren.GEFAHR_LINKS);
		
		assertEquals(Entscheidungen.RECHTS, entscheidung);
		
	}
	
	@Test
	void test_MenschlicheEntscheidung() {
		Mensch mensch = new Mensch();
		Entscheidungen entscheidung = mensch.entscheide(Gefahren.GEFAHR_LINKS);
		
		assertEquals(Entscheidungen.RECHTS, entscheidung);
	}
	
	@Test
	void test_RoboterEntscheidung() {
		Roboter rob = new Roboter();
		Entscheidungen entscheidung = rob.entscheide(Gefahren.GEFAHR_LINKS);
		
		assertEquals(Entscheidungen.RECHTS, entscheidung);
	}

}
