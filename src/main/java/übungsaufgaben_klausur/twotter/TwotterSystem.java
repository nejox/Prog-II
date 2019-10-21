package übungsaufgaben_klausur.twotter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TwotterSystem {

	private Map<User, List<Message>> userMsg = new HashMap<>();

	public void addMessage(User u, Message m) {
		List<Message> msgs;

		if (userMsg.containsKey(u)) {
			msgs = userMsg.get(u);
		} else {
			msgs = new ArrayList<>();
		}

		msgs.add(m);
		userMsg.put(u, msgs);
	}

	public List<Message> getAllMessages() {
		List<Message> msgs = new ArrayList<>();

		Collection<List<Message>> list = userMsg.values();

		for (List<Message> hashSet : list) {
//			for (Message msg : hashSet) {
//				msgs.add(msg);
//			}
			msgs.addAll(hashSet);
		}
		return msgs;
	}

	public List<Message> getAllMessagesFromUser(User u) {
		List<Message> msgs = new ArrayList<>();

		msgs = getAllMessages();
		msgs = msgs.stream().filter(msg -> msg.getAuthor().equals(u)).collect(Collectors.toList());
		return msgs;
	}

	public List<Message> getAllMessagesFromDate(String date) {
		List<Message> msgs = new ArrayList<>();

//		msgs = getAllMessages();
//		msgs = msgs.stream().filter(msg -> msg.getCreationDate().equals(date)).collect(Collectors.toList());
		return getAllMessages().stream().filter(msg -> msg.getCreationDate().equals(date)).collect(Collectors.toList());

//		return msgs;
	}

	public static void main(String[] args) {
		TwotterSystem sys = new TwotterSystem();
		User u = new User("Pter", "1234");
		sys.addMessage(u, new Message(u, "Hello World", "2018-01-31"));
		sys.addMessage(u, new Message(u, "Shit alla", "2019-01-31"));
		List<Message> z = sys.getAllMessages();
		List<Message> m = sys.getAllMessagesFromDate("2018-01-31");
		List<Message> d = sys.getAllMessagesFromUser(u);
	}
}
