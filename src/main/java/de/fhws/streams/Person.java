package de.fhws.streams;

public class Person {

	private String name;
	private String nachname;
	private String adresse;
	private String telnr;
	private String email;

	private Person(String name, String nachname, String adresse, String telnr, String email) {
		this.nachname = nachname;
		this.name = name;
		this.adresse = adresse;
		this.telnr = telnr;
		this.email = email;
	}

	public static class PersonenBuilder {

		private String name;
		private String nachname;
		private String adresse;
		private String telnr;
		private String email;

		public PersonenBuilder(String name, String nachname, String adresse) {
			this.name = name;
			this.nachname = nachname;
			this.adresse = adresse;
		}

		public PersonenBuilder withTelnr(String telnr) {
			this.telnr = telnr;
			return this;
		}

		public PersonenBuilder withEmail(String adresse) {
			this.email = email;
			return this;
		}

		public Person build() {
			return new Person(name, nachname, adresse, telnr, email);
		}

	}
}
