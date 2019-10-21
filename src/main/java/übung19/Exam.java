package übung19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Exam implements ReadQuestions, ToTest {
	private static final String QUESTIONFORMAT1 = "\\textbf{";
	private static final String QUESTIONFORMAT2 = "}\\";
	private static final String DOCUMENTEND = "\\end{document}";

	private ArrayList<Question> questions = new ArrayList<>();

	// Liest den Tex‐Header aus einer Datei u. gibt ihn als String zurück
	String readHeaderFromFile() {
		return null;

	}

	public static void main(String[] args) throws IOException {
		Exam ex1 = new Exam();
		ex1.readQuestions("E:\\Jochen\\Google Drive\\Studium\\Programmieren II\\Testdaten\\Exam\\questions.csv");
		ex1.toTest("E:\\Jochen\\Google Drive\\Studium\\Programmieren II\\Testdaten\\Exam\\test.tex");

	}

	@Override
	public ToTest readQuestions(String path) throws IOException {
		try (BufferedReader bR = new BufferedReader(new FileReader(path));) {
			while (bR.ready()) {
				String line = bR.readLine();

				if (!line.isEmpty()) {
					questions.add(Question.toQuestion(line));
				}

			}

		} catch (Exception e) {
		}
		
		return this;
	}

	@Override
	public void toTest(String path) throws IOException {
		try (BufferedWriter bW = new BufferedWriter(new FileWriter(path));) {

			// Header schreiben
			bW.write(readHeaderFromFile());

			// Fragen schreiben
			for (Question question : questions) {
				String line = QUESTIONFORMAT1 + question.text + QUESTIONFORMAT2;
				System.out.println(line);
				bW.write(line);
			}

			bW.write(DOCUMENTEND);

		} catch (Exception e) {
		}
	}
}
