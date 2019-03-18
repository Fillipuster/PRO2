package question02;

public abstract class Animal {

	private String name;
	private int daysOld;
	
	public Animal(String name, int daysOld) {
		setName(name);
		setDaysOld(daysOld);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getDaysOld() {
		return daysOld;
	}
	
	public void setDaysOld(int daysOld) {
		this.daysOld = daysOld;
	}
	
	public void breathe() {
		throw new UnsupportedOperationException();
	}
	
	public void communicate() {
		throw new UnsupportedOperationException();
	}
	
	public void excreteWaste() {
		throw new UnsupportedOperationException();
	}
	
}
