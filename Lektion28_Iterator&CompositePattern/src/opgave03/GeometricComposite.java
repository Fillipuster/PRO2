package opgave03;

import java.util.ArrayList;

// Composite/middlenode of geometric structure. Has no area, but can carry children.
public class GeometricComposite extends GeometricComponent {

	private ArrayList<GeometricComponent> children = new ArrayList<>();
	
	public GeometricComposite(String name) {
		super(name);
	}
	
	@Override
	public void addChild(GeometricComponent element) {
		children.add(element);
	}
	
	@Override
	public GeometricComponent getChild(int index) {
		return children.get(index);
	}
	
	// removeChild
	
	@Override
	public double getArea() {
		double area = 0d;
		for (GeometricComponent g : children) {
			area += g.getArea();
		}
		
		return area;
	}
	
	@Override
	public void draw() {
		draw(0);
	}
	
	@Override
	public void draw(int depth) {
		// Spacer
		String spacer = "";
		for (int i = 0; i < depth; i++) {
			spacer += "\t";
		}
		
		// Printout
		System.out.println(spacer + super.getName() + " " + getArea()  + " →");
		depth++;
		
		for (GeometricComponent g : children) {
			g.draw(depth);
		}
	}
	
}
