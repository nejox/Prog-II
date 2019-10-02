package de.fhws.streams;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SignTest {

	@Test
	void testSignOperator() {
		assertTrue(0 == Sign.sign(0));
		assertTrue(1 == Sign.sign(5));
		assertTrue(-1 == Sign.sign(-5));
//		fail("Not yet implemented");
	}

	@Test
	void testPositiveSignOperator() {
		assertTrue(1 == Sign.sign(5));
	}

	@Test
	void testNegativeSignOperator() {
		assertTrue(-1 == Sign.sign(-5));
	}
	
	@Test
	void testNeutralSignOperator() {
		assertTrue(0 == Sign.sign(0));
	}

}
