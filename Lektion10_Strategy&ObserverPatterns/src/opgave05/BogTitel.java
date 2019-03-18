package opgave05;

import java.util.ArrayList;
import java.util.Observable;

public class BogTitel extends Observable {
	
	private String titel;
	private int antal;
	
	private ArrayList<Kunde> kunder = new ArrayList<>();
	
	public BogTitel(String titel, int antal) {
		setTitel(titel);
		setAntal(antal);
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public int getAntal() {
		return antal;
	}

	public void setAntal(int antal) {
		this.antal = antal;
	}
	
	public ArrayList<Kunde> getKunder() {
		return new ArrayList<>(kunder);
	}
	
	public void indkøbTilLager(int antal) {
		this.antal += antal;
	}
	
	public void etKøb(Kunde k) {
		kunder.add(k);
		k.addKøbtBog(this);
		
		antal--;
		
		setChanged();
		notifyObservers();
	}
	
	@Override
	public String toString() {
		return titel;
	}
	
}
