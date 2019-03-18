package opgave05;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public class Sælger implements Observer {

	private String name;
	
	public Sælger(String name) {
		setName(name);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof BogTitel) {
			BogTitel bog = (BogTitel) o;
			Set<BogTitel> result = new HashSet<>();
			for (Kunde k : bog.getKunder()) {
				for (BogTitel bt : k.getKøbteBøger()) {
					result.add(bt);
				}
			}
			result.remove(bog);
			
			System.out.println("Kunder der køber " + bog.getTitel() + " køber også:");
			System.out.println(result);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
