package übung12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PunktTest {

	@Test
	void xyAreOk() {
		Punkt p = new Punkt(2, 2);
		p.verschiebePunkt(5, 5);
		assertTrue((5 == p.x) && (5 == p.y));
	}

	@Test
	void xInvalid() {
		Punkt p = new Punkt(2, 2);
		try {
			p.verschiebePunkt(1980, 5);
			fail();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Test
	void yInvalid() {
		Punkt p = new Punkt(2, 2);
		try {
			p.verschiebePunkt(5, 1200);
			fail();
		} catch (RuntimeException e) {
			// TODO: handle exception
		}

	}

	@Test
	void negativeCoordinates() {
		Punkt p = new Punkt(2, 2);
		try {
			p.verschiebePunkt(-5, -5);
			fail();
		} catch (Exception e) {
			// TODO: handle exception
		}
//		assertTrue((5 == p.x) && (5 == p.y));
	}
}
