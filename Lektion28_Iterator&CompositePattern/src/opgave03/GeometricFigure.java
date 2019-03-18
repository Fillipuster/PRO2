package opgave03;

// Leaf/endnode of geometric structure. Only carries a name and area;
// cannot carry children.
public class GeometricFigure extends GeometricComponent {

	private double area;
	
	public GeometricFigure(String name, double area) {
		super(name);
		this.area = area;
	}
	
	@Override
	public void draw() {
		System.out.println(super.getName() + " " + getArea());
	}
	
	@Override
	public void draw(int depth) {
		// Spacer
		String spacer = "";
		for (int i = 0; i < depth; i++) {
			spacer += "\t";
		}
		
		// Printout
		System.out.println(spacer + super.getName() + " " + getArea());
	}
	
	@Override
	public double getArea() {
		return this.area;
	}
	
}
