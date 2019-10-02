package übung13;

public class MultipleChoiceFrage extends Frage {
	private String Text;
	private String[] Antworten;

	public MultipleChoiceFrage(String text, String[] antworten) {
		Text = text;
		Antworten = antworten;
	}

	@Override
	public void gibFrageAus() {
		char abc = 'A';
		System.out.println(this.Text);		
		System.out.print("Antwort: \n");
		for (int i = 0; i < Antworten.length; i++) {
			System.out.print(abc + ": " + Antworten[i] + "\t");
			abc++;
		}
		System.out.println("\n");

	}

}
