package übungsaufgaben_klausur.twotter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserManager {

	public void serialize(List<User> objects) throws IOException {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/user.dat"));) {

			for (User user : objects) {
				oos.writeObject(user);
			}
			oos.writeObject(null);

		} catch (Exception e) {
			throw new RuntimeException("ERROR");
		}

	}

	public List<User> deserialize() {

		List<User> liste = new ArrayList<>();

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/user.dat"));) {
			boolean flag = true;

			do {
				Object obj = ois.readObject();
				if (obj == null) {
					flag = false;
				} else {
					liste.add((User) obj);
				}

			} while (flag);

		} catch (Exception e) {
			throw new RuntimeException("ERROR");
		}

		return liste;

	}

	public static void main(String[] args) {

		User[] users = { new User("Harald", "sh1t"), new User("Manni", "pw1") };

		UserManager um = new UserManager();

		try {
			um.serialize(Arrays.asList(users));
			List<User> usersList = um.deserialize();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
