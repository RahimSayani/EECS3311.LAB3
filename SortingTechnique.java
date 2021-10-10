package lab3;

import java.util.ArrayList;
import java.util.List;

public class SortingTechnique {
	private List<Shape> shapeList = new ArrayList<>();
	
	private SortingTechnique(List<Shape> shapeList) {
		this.shapeList = shapeList;
		selectionSort(shapeList);
	}
	
	public static SortingTechnique getInstance(List<Shape> shapeList) {return new SortingTechnique(shapeList);}
	
	private void selectionSort(List<Shape> shapeList) {
		
		int n = shapeList.size();
		
		for (int i = 0; i < n - 1; i++) {
			
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if(shapeList.get(j).compareTo(shapeList.get(minIndex)) == -1) {
					minIndex = j;
				}
			}	
			
			Shape temp = shapeList.get(minIndex);
			shapeList.set(minIndex, shapeList.get(i));
			shapeList.set(i, temp);
		}	
		printList();
	}
	
	public void printList() {
		System.out.println("Sort Shapes...");
		System.out.println("-----------------------");
		
		for (int i = 0; i < shapeList.size(); i++) {
			
			if (shapeList.get(i) instanceof Circle) {
				Circle circle = (Circle) shapeList.get(i);
				System.out.println((i + 1) + ". Circle");
				System.out.println("   radius\t" + Math.round((circle.getDiameter() / 2.0) * 100.0) / 100.0);
				System.out.println("   area \t" + Math.round(circle.getArea() * 100.0) / 100.0);
			}
			else if(shapeList.get(i) instanceof Rectangle) {
				Rectangle rectangle = (Rectangle) shapeList.get(i);
				System.out.println((i + 1) + ". Rectangle");
				System.out.println("   length\t" + rectangle.getLength());
				System.out.println("   width\t" + rectangle.getWidth());
				System.out.println("   area \t" + rectangle.getArea());
			}
			else {
				Square square = (Square) shapeList.get(i);
				System.out.println((i + 1) + ". Square");
				System.out.println("   side \t" + square.getSide());
				System.out.println("   area \t" + square.getArea());
			}
			if (i != shapeList.size() - 1) {System.out.println();}
		}
		System.out.println("-----------------------");
		System.out.println("***********************");
		System.out.println();
	}
	
	public List<Shape> getSortedList() {return shapeList;}

}
