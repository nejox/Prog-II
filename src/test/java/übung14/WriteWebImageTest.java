package übung14;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import übung15.WriteWebImage;

class WriteWebImageTest {

	@Test
	void test() {
		try {
			WriteWebImage.main(0, 0); // Offset sollte nicht größer sein als die länge, Länge sollte nicht bei
										// ArrayOutofBounds sein
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
