package altklausur_SS17;

public class FalscheIBANException extends Exception {
	
	public FalscheIBANException() {
		super("FEHLER: Datei enthält ungültige IBAN");
		// TODO Auto-generated constructor stub
	}

	public FalscheIBANException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
