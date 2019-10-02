package de.fhws.streams;

import de.fhws.streams.Person.PersonenBuilder;

public class Main {

	public static void main(String[] args) {
	
		PersonenBuilder pB = new PersonenBuilder("Jochen", "Schmidt", "Shit alter");
		Person jS = pB.build();
		
		Person nN = pB.withEmail("schmidtjochen")
						.withTelnr("023420303434")
						.build();

	}

}
