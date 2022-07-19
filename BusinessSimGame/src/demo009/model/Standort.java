package demo009.model;

public class Standort {

	/**
	 * Ort, in dem der Standort platziert wird. Die Funktionalit�t ist nicht vom Ortsnamen abh�ngig.
	 * Der Ort kann beliebig gew�hlt werden und dient lediglich der Illustration im Spiel. 
	 */
	private String ort;
	
	public Standort(String ort) {
		this.ort=ort;
	}

	/**
	 * Jeder Standort steht in einem Ort. Die Methode gibt den Ort des Standortes zur�ck.
	 * @return Ort, in dem der Standort steht.
	 */
	public String getOrt() {
		return ort;
	}


}