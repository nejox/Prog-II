package übung17;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

public class Browser {
	public URL back() {
		try {
			// simulate: fetch last URL from Stack
			return (Math.random() < 0.5 ? new URL("http://google.de") : null);
		} catch (MalformedURLException e) {
			return null;
		}
	}

	public void retrieveSite(URL back) {
		System.out.println(back);

	}

	public static void main(String[] args) {
		System.out.println("Normal back");
		Browser browser = new Browser();
		Optional<URL> back = Optional.ofNullable(browser.back());
		
		back.ifPresent(value -> {
			browser.retrieveSite(value);
		});
	}
}