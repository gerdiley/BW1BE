package it.epicode.bw.models;

public enum TipoMezzo {
	AUTOBUS(100),
	TRAM(150);
	
	public final int capienza;
	
	private TipoMezzo (int capienza) {
		this.capienza = capienza;
	}
}
