package übung20;

import java.util.Timer;
import java.util.TimerTask;

public class YingYangRunnable extends TimerTask {
	private String message;

	public YingYangRunnable(String message) {
		super();
		this.message = message;
	}

	public void machAusgabe() {
		System.out.println(message);
	}

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new YingYangRunnable("Ying"), 0, 500);
		timer.schedule(new YingYangRunnable("Yang"), 250, 500);
	}

	@Override
	public void run() {
		machAusgabe();
	}
}
