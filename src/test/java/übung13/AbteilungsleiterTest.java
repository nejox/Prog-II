package übung13;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class AbteilungsleiterTest {

	Abteilungsleiter al = new Abteilungsleiter("Schmidt", "Jochen", "1", 2400.00, "18.07.1996");
	Angestellter an = new Angestellter("Mustermann", "Max", "2", 2000.00, "22.08.1992");

	@Test
	void test_befoerdern() {
		al.befoerdern(an);
		double gehaltsfaktor1 = an.getGehaltsfaktor();
		al.befoerdern(an);
		assertEquals(1.1, gehaltsfaktor1);
		assertEquals(1.21, an.getGehaltsfaktor(),0.001);
		
	}

}
