package lab3;

import java.awt.Color;

public class Shape implements Comparable<Shape>{
	private double area;
	private Color color;
	
	public Shape(int r, int g, int b) {
		color = new Color(r, g, b);
	}
	
	public void setArea(double area) {this.area = area;}
	public Color getColor() {return color;}
	public double getArea() {return area;}

	@Override
	public int compareTo(Shape s) {
		if (this.area < s.getArea()) {return -1;}
		if (this.area == s.getArea()) {return 0;}
		else {return 1;}
	}
}

class Circle extends Shape{
	private int diameter;
	
	public Circle(int r, int g, int b, int diameter) {
		super(r, g, b);
		this.diameter = diameter;
		super.setArea(Math.PI * (diameter / 2.0 * diameter / 2.0));
	}
		
	public int getDiameter() {return diameter;}
	public Color getColor() {return super.getColor();}
	public double getArea() {return super.getArea();}
}

class Rectangle extends Shape{
	private int length, width;
	
	public Rectangle(int r, int g, int b, int length, int width) {
		super(r, g, b);
		this.length = length;
		this.width = width;
		super.setArea(length * width);
	}
	
	public int getLength() {return length;}
	public int getWidth() {return width;}
	public Color getColor() {return super.getColor();}
	public double getArea() {return super.getArea();}
}

class Square extends Shape {
	private int side;
	
	public Square(int r, int g, int b, int side) {
		super(r, g, b);
		this.side = side;
		super.setArea(side * side);
	}
	
	public int getSide() {return side;}
	public Color getColor() {return super.getColor();}
	public double getArea() {return super.getArea();}
}
