package DrawingGraph;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class DrawingGraph extends JFrame {
	private ShapesPanel sp;
	private DrawingPanel dp;
	
	public DrawingGraph() {
		super("성적 분포 그래프 확인");
		
		sp = new ShapesPanel();
		dp = new DrawingPanel();
		
		sp.init(dp);
		
		this.add(sp, BorderLayout.NORTH);
		this.add(dp, BorderLayout.CENTER);
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 250);
		this.setResizable(false);
		this.setVisible(true);
	}
}
