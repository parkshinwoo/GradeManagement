package DrawingGraph;

import java.awt.*;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Line2D;

public class MyPoint{
	private int id_x;
	private int score_y;
	
	public MyPoint(int id_x, int score_y) {
		this.id_x = id_x;
		this.score_y = score_y;
	}

	public int getId_x() {
		return id_x;
	}

	public void setId_x(int id_x) {
		this.id_x = id_x;
	}

	public int getScore_y() {
		return score_y;
	}

	public void setScore_y(int score_y) {
		this.score_y = score_y;
	}
	
}
