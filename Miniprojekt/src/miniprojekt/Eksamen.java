package miniprojekt;

public class Eksamen {

	private int id;
	private String betegnelse;
	
	public Eksamen(int id, String betegnelse) {
		setId(id);
		setBetegnelse(betegnelse);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBetegnelse() {
		return betegnelse;
	}

	public void setBetegnelse(String betegnelse) {
		this.betegnelse = betegnelse;
	}
	
	@Override
	public String toString() {
		return betegnelse;
	}
	
}
