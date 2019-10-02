package tutorium.builder;

public class Main {

	public static void main(String[] args) {

		Computer cp = new Computer.ComputerBuilder("100","IBM")
							.withBS(Betriebssystem.WINDOWS10)
							.withKernen(4)
							.build();
		
		cp.ausfuehren(Main::programm);
		
	}
	
	static void programm() {
		System.out.println("Hallo Welt");
	}

}
