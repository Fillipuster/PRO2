package opgave03;

// Superclass for all components of a geometric structure.
public abstract class GeometricComponent {

	private String name;
	
	public GeometricComponent(String name) {
		setName(name);
	}
	
	public void setName(String name) 	{this.name = name;}
	public String getName() 			{return this.name;}
	
	public void draw() {
		throw new UnsupportedOperationException();
	}
	
	public void draw(int depth) {
		throw new UnsupportedOperationException();
	}
	
	public double getArea() {
		throw new UnsupportedOperationException();
	}
	
	public void addChild(GeometricComponent element) {
		throw new UnsupportedOperationException();
	}
	
	public GeometricComponent getChild(int index) {
		throw new UnsupportedOperationException();
	}
	
}
