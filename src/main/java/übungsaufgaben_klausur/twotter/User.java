package übungsaufgaben_klausur.twotter;

import java.io.Serializable;

public class User implements Serializable, Comparable<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2302653647067327113L;

	final String bname;
	transient final String pw;

	public User(String name, String pw) {
		this.bname = name;
		this.pw = pw;
	}

	@Override
	public int compareTo(User o) {
		if (this.bname.length() < o.bname.length()) {
			return -1;
		} else if (this.bname.length() > o.bname.length()) {
			return 1;
		} else {
			return this.bname.compareTo(o.bname);
		}
	}

}
