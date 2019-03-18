package opgave05;

import java.util.Observable;
import java.util.Observer;

public class Indkøber implements Observer {
	
	private String name;
	
	public Indkøber(String name) {
		setName(name);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof BogTitel) {
			BogTitel bog = (BogTitel) o;
			if (bog.getAntal() < 6) {
				System.out.println("Indkøber 10 stk. '" + bog.getTitel() + "'...");
				bog.indkøbTilLager(10);
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
