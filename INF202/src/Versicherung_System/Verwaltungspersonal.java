package Versicherung_System;

public class Verwaltungspersonal extends Personal14{
	private String versicherungsabteilung;        
	private String abteilungID;

	public Verwaltungspersonal(String vorname, String nachname, String geschlecht, String geburtsdatum,
			String personalID, String email, String arbeitsanfangsdatum, String telefonnummer, String maklergebühr) {
		super(vorname, nachname, geschlecht, geburtsdatum, personalID, email, arbeitsanfangsdatum, telefonnummer, maklergebühr);
		// TODO Auto-generated constructor stub 
		
	this.setVersicherungsabteilung(getVersicherungsabteilung());
	this.setAbteilungID(abteilungID);
	
}

public String getVersicherungsabteilung() {
	return versicherungsabteilung;
}

public void setVersicherungsabteilung(String versicherungsabteilung) {
	this.versicherungsabteilung = versicherungsabteilung;
}

public String getAbteilungID() {
	return abteilungID;
}

public void setAbteilungID(String abteilungID) {
	this.abteilungID = abteilungID;
}
	
}
