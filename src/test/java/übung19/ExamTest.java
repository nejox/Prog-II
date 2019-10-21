package übung19;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class ExamTest {

	@Test
	void test_FileIsExisting() throws IOException {
		String pathCSV = "E:\\Jochen\\Google Drive\\Studium\\Programmieren II\\Testdaten\\Exam\\questions.csv";
		String pathTEX = "E:\\Jochen\\Google Drive\\Studium\\Programmieren II\\Testdaten\\Exam\\test.tex";

		File f = new File(pathTEX);
		f.delete();

		Exam test = new Exam();
		test.readQuestions(pathCSV).toTest(pathTEX);

		FileInputStream fis = new FileInputStream(
				"E:\\Jochen\\Google Drive\\Studium\\Programmieren II\\Testdaten\\Exam\\test.tex");
	}

}
