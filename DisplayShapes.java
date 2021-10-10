package lab3;

import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DisplayShapes extends JPanel implements ActionListener{
	private List<Shape> shapeList = new ArrayList<>();
	private ShapeFactory creator;
	private SortingTechnique sortList;
	private JButton loadButton;
	private JButton sortButton;
	private boolean loadShapes = false;
	private boolean sortShapes = false;
	
	public static void main(String [] args) {
		new DisplayShapes();
	}
	
	public DisplayShapes() {
		JFrame frame = new JFrame("Display Shapes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setVisible(true);
		frame.add(this);

		loadButton = new JButton("Load shapes");
		loadButton.setBounds(170, 10, 120, 30);
		loadButton.addActionListener(this);
		frame.add(loadButton);
		
		sortButton = new JButton("Sort shapes");
		sortButton.setBounds(310, 10, 120, 30);
		sortButton.addActionListener(this);
		frame.add(sortButton);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		
		if (source == loadButton) {
			creator = ShapeFactory.getInstance(6);
			shapeList = creator.getShapeList();
			loadShapes = true;
			repaint();
		}
		if (source == sortButton && loadShapes) {
			sortList = SortingTechnique.getInstance(shapeList);
			shapeList = sortList.getSortedList();
			sortShapes = true;
			repaint();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graph = (Graphics2D) g;
		
		loadButton.repaint();
		sortButton.repaint();
		
		if (loadShapes) {
			int x = 20;
			int y = 20;
			
			for (int i = 0; i < shapeList.size(); i++) {
				graph.setColor(shapeList.get(i).getColor());
				
				if (shapeList.get(i) instanceof Circle) {
					Circle circle = (Circle) shapeList.get(i);
					graph.fillOval(x, y, circle.getDiameter(), circle.getDiameter());
					x += circle.getDiameter() + 10;
					y += circle.getDiameter() + 10;
				}
				if (shapeList.get(i) instanceof Rectangle) {
					Rectangle rectangle = (Rectangle) shapeList.get(i);
					graph.fillRect(x, y, rectangle.getWidth(), rectangle.getLength());
					x += rectangle.getWidth() + 10;
					y += rectangle.getLength() + 10;
				}
				if (shapeList.get(i) instanceof Square) {
					Square square = (Square) shapeList.get(i);
					graph.fillRect(x, y, square.getSide(), square.getSide());
					x += square.getSide() + 10;
					y += square.getSide() + 10;
				}
			}
		}
		if (sortShapes && loadShapes) {loadShapes = false; sortShapes = false;}
	}
	
}
	
	

