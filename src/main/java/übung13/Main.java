package übung13;

public class Main {

	public static void main(String[] args) {
		// Aufgabe 1
//		Person[] Personen = new Person[100];
//
//		for (int i = 0; i < Personen.length; i++) {
//			if (i % 2 == 0) {
//				Personen[i] = new Student();
//			} else {
//				Personen[i] = new Professor();
//			}
//			
//			Personen[i].gibTaetigkeitAus();
//		}

		// Aufgabe 2
//		Frage[] Quizbogen = new Frage[10];
//
//		for (int i = 0; i < Quizbogen.length; i++) {
//			if (i % 2 == 0) {
//				Quizbogen[i] = new Quizfrage("Was ist 2+3*6-5?", "15");
//			} else {
//				Quizbogen[i] = new MultipleChoiceFrage("Was geht heute?",
//						new String[] { "Katze", "Auto", "Studio", "Beine" });
//			}
//		}
//
//		for (int i = 0; i < Quizbogen.length; i++) {
//			System.out.println((i+1)+". Frage:");
//			Quizbogen[i].gibFrageAus();
//		}
		
		//Aufgabe 4
		ChangeCalculator cc = new ChangeCalculator();
		cc.test();

	}

}
