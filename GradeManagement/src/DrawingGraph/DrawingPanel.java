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
		super.paint(g);
		if(shapeList.isEmpty()) {
		}else {
			int i = 0;
			for(MyPoint point : shapeList) {
				g.setColor(Color.GREEN);
				g.fillRect(point.getId_x() + i*20, 0, 20, point.getScore_y());
				
				/*
				// ¹Øº¯
				g.drawLine(point.getId_x() + i*20, 100, point.getId_x() + (i+1)*20, 100);
				// À­º¯
				g.drawLine(point.getId_x() + i*20, 0, point.getId_x() + (i+1)*20, 0);
				// ÁÂº¯
				g.drawLine(point.getId_x() + i*20, 0, point.getId_x() + i*20, 100);
				// ¿ìº¯
				g.drawLine(point.getId_x() + (i+1)*20, 0, point.getId_x() + (i+1)*20, 100);
				*/
				i++;
			}
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D)g;
		
		if(shapeList.isEmpty()) {
		}else {
			int i = 0;
			for(MyPoint point : shapeList) {
				g.setColor(Color.GREEN);
				g.fillRect(point.getId_x() + i*20, 0, 20, point.getScore_y());
				
				/*
				// ¹Øº¯
				g.drawLine(point.getId_x() + i*20, 100, point.getId_x() + (i+1)*20, 100);
				// À­º¯
				g.drawLine(point.getId_x() + i*20, (100 - point.getScore_y()), point.getId_x() + (i+1)*20, (100 - point.getScore_y()));
				// ÁÂº¯
				g.drawLine(point.getId_x() + i*20, 100, point.getId_x() + i*20, (100 - point.getScore_y()));
				// ¿ìº¯
				g.drawLine(point.getId_x() + (i+1)*20, 100, point.getId_x() + (i+1)*20, (100 - point.getScore_y()));
				*/
				
				i++;
			}
		}
	}
}