package übung18;

public class MauKarte implements Comparable<MauKarte> {
	
	private MauFarben farbe;
	private MauWerte wert;

	public MauKarte(MauFarben farbe, MauWerte wert) {
		super();
		this.farbe = farbe;
		this.wert = wert;
	}

	public MauFarben getFarbe() {
		return farbe;
	}

	public MauWerte getWert() {
		return wert;
	}

	@Override
	public int compareTo(MauKarte o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
