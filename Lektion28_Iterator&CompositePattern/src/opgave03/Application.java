package opgave03;

public class Application {

	public static void main(String[] args) {
		
		GeometricComponent root = new GeometricComposite("Dodecahedron");
		root.addChild(new GeometricFigure("Triangle", 2.3));
		root.addChild(new GeometricFigure("Circle", 1.0));
		GeometricComponent l1 = new GeometricComposite("Hexagon");
		root.addChild(l1);
		
		l1.addChild(new GeometricFigure("Square", 4.8));
		l1.addChild(new GeometricFigure("Rectangle", 3.4));
		GeometricComponent l2 = new GeometricComposite("Pentagon");
		l1.addChild(l2);
		
		l2.addChild(new GeometricFigure("Ellipse", 8.7));
		l2.addChild(new GeometricFigure("Trapez", 11.0));
		
		System.out.println("Drawing...\n");
		root.draw();
		
		System.out.println("\nArea of root:\t\t" + root.getArea());
		System.out.println("\nArea of L2:\t\t" + l2.getArea());
		System.out.println("\nArea of L2's 1st child:\t" + l2.getChild(0).getArea());
	}

}
