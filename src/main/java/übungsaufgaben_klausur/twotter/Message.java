package übungsaufgaben_klausur.twotter;

public class Message {

	private User author;
	private int charCounter;
	private String message;
	private String creationDate;

	public Message(String s) {
		this.message = s;
	}

	public Message(User author, String message, String creationDate) {
		super();
		this.author = author;
		this.message = message;
		this.creationDate = creationDate;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public int getCharCounter() {
		return charCounter;
	}

	public void setCharCounter(int charCounter) {
		this.charCounter = charCounter;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

}
