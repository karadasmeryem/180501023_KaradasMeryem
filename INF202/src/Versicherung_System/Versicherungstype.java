package Versicherung_System;

public class Versicherungstype {
	private String erdbeben; 
	private String fahrzeug;  
	private String krankheit; 
	private String auto;
	
	public void Personal (String erdbeben, String fahrzeug, String krankheit, String auto ) 
			      
	{
		this.seterdbeben(erdbeben); 
		this.setNachname(fahrzeug); 
		this.setGeburtsdatum(krankheit);  
		this.setpersonalID(auto);
	}

	private void setGeburtsdatum(String krankheit2) {
		// TODO Auto-generated method stub
		
	}

	private void setpersonalID(String auto2) {
		// TODO Auto-generated method stub
		
	}

	private void setNachname(String fahrzeug2) {
		// TODO Auto-generated method stub
		
	}

	public String geterdbeben() {
		return erdbeben;
	}

	public void seterdbeben(String erdbeben) {
		this.erdbeben = erdbeben;
	} 
	 
	public String getfahrzeug() {
		return fahrzeug;
	}

	public void setfahrzeug(String fahrzeug) {
		this.fahrzeug = fahrzeug;
	}
	public String getkrankheit() {
		return krankheit;
	}

	public void setkrankheit(String krankheit) {
		this.krankheit = krankheit;
	}

	public String getauto() {
		return auto;
	}

	public void setauto(String auto) {
		this.auto = auto;
	}
}
	