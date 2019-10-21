package übungsaufgaben_klausur.mitarbeiter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class Mitarbeiter implements Serializable {

	private String vorname = null;
	private String nachname = null;
	private int nummer = 0;
	transient private int gehalt = 0;

	public Mitarbeiter(String vorname, String nachname, int nummer, int gehalt) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.nummer = nummer;
		this.gehalt = gehalt;
	}// endconstructor
		// . . . alle getter- und setter-Methoden

	@Override
	public String toString() {
		return "Nachname: " + nachname + " Vorname: " + vorname + " Personalnummer: " + nummer + " Gehalt: " + gehalt;
	}
	// endmethod toString

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		return result;
	}
	// endmethod hashcode

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Mitarbeiter)) {
			return false;
		}
		Mitarbeiter other = (Mitarbeiter) obj;
		if (gehalt != other.gehalt) {
			return false;
		}
		return false;
	}// endmethod equals

	public static Mitarbeiter[] sortiere(Collection<Mitarbeiter> team) {
		Mitarbeiter[] m = team.toArray(new Mitarbeiter[0]);

		Arrays.sort(m, new VergleichePersonalNummer());

		return m;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public int getGehalt() {
		return gehalt;
	}

	public void setGehalt(int gehalt) {
		this.gehalt = gehalt;
	}

	public static void main(String[] args) {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("mitarbeiter.dat"));
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
						"mitarbeiter.dat"));) {
			Mitarbeiter m1 = new Mitarbeiter("Jochen", "schmidt", 345, 345);
			oos.writeObject(m1);

			Mitarbeiter m2 = new Mitarbeiter("Peter", "lustig", 33, 99234);
			oos.writeObject(m2);

			Mitarbeiter m3 = new Mitarbeiter("Hans", "Peter", 3434, 23400);
			oos.writeObject(m3);
			oos.writeObject(null);

			boolean flag = true;
			HashSet<Mitarbeiter> set = new HashSet<>();

			while (flag) {
				Mitarbeiter m = (Mitarbeiter) ois.readObject();
				if (m != null) {
					set.add(m);
				} else {
					flag = false;
				}
			}

			for (Mitarbeiter mitarbeiter : set) {
				System.out.println(mitarbeiter.toString());
			}

			Mitarbeiter[] mArray = sortiere(set);
			
			for (Mitarbeiter mitarbeiter : mArray) {
				System.out.println(mitarbeiter.toString());
			}
			
			

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}// endclass Mitarbeiter