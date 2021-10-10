package lab3;

import java.util.ArrayList;
import java.util.List;

public class ShapeFactory {
	private List<Shape> shapeList = new ArrayList<>();

	public ShapeFactory(int num) {
		System.out.println("***********************");
		System.out.println("Load Shapes...");
		System.out.println("-----------------------");
		for (int i = 0; i < num; i++) {
			System.out.print((i + 1) + ". ");
			createShapes();
			if (i != num - 1) {System.out.println();}
		}
		System.out.println("-----------------------");
	}
	
	public static ShapeFactory getInstance(int num) {return new ShapeFactory(num);}
	
	public List<Shape> getShapeList() {return shapeList;}
	
	private void createShapes() {
		int shapeSelect, r, g, b;
		
		shapeSelect = randomize(1, 3);
		r = randomize(0, 250);
		g = randomize(0, 250);
		b = randomize(0, 250);
		
		if (shapeSelect == 1) {
			int diameter = randomize(30, 80);
			Circle circle = new Circle(r, g, b, diameter);
			shapeList.add(circle);
			System.out.println("Circle");
			System.out.println("   radius\t" + Math.round((diameter / 2.0) * 100.0) / 100.0);
			System.out.println("   area \t" + Math.round(circle.getArea() * 100.0) / 100.0);
		}
		else if (shapeSelect == 2) {
			int length = randomize(30, 80);
			int width = randomize(30, 80);
			Rectangle rectangle = new Rectangle(r, g, b, length, width);
			shapeList.add(rectangle);
			System.out.println("Rectangle");
			System.out.println("   length\t" + length);
			System.out.println("   width\t" + width);
			System.out.println("   area \t" + rectangle.getArea());
		}
		else {
			int side = randomize(40, 90);
			Square square = new Square(r, g, b, side);
			shapeList.add(square);
			System.out.println("Square");
			System.out.println("   side \t" + side);
			System.out.println("   area \t" + square.getArea());
		}
		
	}
	
	public int randomize(int min, int max) {
		return (int)(Math.random()*(max - min + 1) + min);
	}

}
