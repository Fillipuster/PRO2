package opgave05;

import java.util.ArrayList;

public class Kunde {

	private String navn;
	
	private ArrayList<BogTitel> købteBøger = new ArrayList<>();
	
	public Kunde(String navn) {
		setNavn(navn);
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	public void addKøbtBog(BogTitel bog) {
		købteBøger.add(bog);
	}
	
	public ArrayList<BogTitel> getKøbteBøger(){
		return new ArrayList<>(købteBøger);
	}
	
	@Override
	public String toString() {
		return navn;
	}
	
}
