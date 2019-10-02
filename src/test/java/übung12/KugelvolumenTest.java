package übung12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KugelvolumenTest {

	@Test
	void testVolumen() {
		assertEquals(0.0, Kugelvolumen.berechneKugelvolumen(0));
//		fail("Not yet implemented");
	}

	@Test
	void testPosVolumen() {
		assertEquals(4.189, Kugelvolumen.berechneKugelvolumen(1), 0.01);// 1
		assertEquals(523.599, Kugelvolumen.berechneKugelvolumen(5), 0.01);// 5
	}

	@Test
	void testNegVolumen() {
		assertEquals(-4.189, Kugelvolumen.berechneKugelvolumen(-1), 0.01);
	}

}
