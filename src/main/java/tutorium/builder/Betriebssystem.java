package tutorium.builder;

public enum Betriebssystem {
	WINDOWS_XP(500), WINDOWS10(100), LINUX(0);

	public final int sleepTime;

	Betriebssystem(int sleepTime) {
		this.sleepTime = sleepTime;
	}
}
