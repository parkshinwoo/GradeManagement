package DrawingGraph;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
	
	public List<MyPoint> shapeList;
	
	public DrawingPanel() {
		this.setBackground(Color.WHITE);
		
		shapeList = new ArrayList<>();
		
		paint(this.getGraphics());
	}

	@Override
	public void paint(Graphics g) {
		if(shapeList.isEmpty()) {
		}else {
			for(MyPoint point : shapeList) {
				g.drawLine(point.getId_x(), point.getScore_y(), point.getId_x()+1, point.getScore_y()+1);
			}
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D)g;
		
		if(shapeList.isEmpty()) {
		}else {
			for(MyPoint point : shapeList) {
				g2D.drawLine(point.getId_x(), point.getScore_y(), point.getId_x(), point.getScore_y());
			}
		}
	}
}