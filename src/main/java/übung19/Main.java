package übung19;

import übung19.Baum.Knoten;

public class Main {

	public static <E> void main(String[] args) {
		@SuppressWarnings("unused")
		Naehrstoffangaben na = new Naehrstoffangaben.NaehrstoffBuilder(5, 3).withEiweiß(20).withKohlenhydrate(60)
				.withFett(13).build();

		Baum<String> tree = new Baum<String>();
		tree.insert(new Knoten<String>("Shit"));
		tree.insert(new Knoten<String>("hachja"));
		tree.insert(new Knoten<String>("Fett alter"));
		tree.ausgabe();
	}

}
