package opgave05;

public class SpiritusAdapter extends Vare {

	private Spiritus spiritus;
	
	public SpiritusAdapter(Spiritus spiritus) {
		super(spiritus.getBetegnelse(), spiritus.getPris());
		setSpiritus(spiritus);
	}

	public Spiritus getSpiritus() {
		return spiritus;
	}

	public void setSpiritus(Spiritus spiritus) {
		this.spiritus = spiritus;
	}
	
	@Override
	public double beregnMoms() {
		return spiritus.hentMoms();
	}

}
