package übung13;

public class Quizfrage extends Frage {
	private String Antwort;
	private String Text;

	public Quizfrage(String text, String antwort) {
		Text = text;
		Antwort = antwort;
	}

	@Override
	public void gibFrageAus() {
		System.out.println(this.Text);
		System.out.println("Antwort: \n"+this.Antwort+" \n");
	}

}
