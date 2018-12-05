package DrawingGraph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.sql.ResultSet;
import java.sql.SQLException;
import Query.StudentsQueries;

public class ShapesPanel extends JPanel {
	private MyHandler handler;
	private DrawingPanel dp;
	private StudentsQueries studentsQueries = null;
	private ResultSet resultset = null;
	private int student_id;
	private String student_name;
	private int attendance;
	private int late;
	private int absent;
	private int midterm;
	private int Final;
	private int presentation;
	private int project_proposal;
	private int requirement_specification;
	private int gui_plan;
	private int design_specification;
	private int project_code;
	private int final_report;
	private int total_score;
	private String grade;
	
	
	public ShapesPanel() {
		studentsQueries = new StudentsQueries();
		handler = new MyHandler();
		String btNames[] = {"출결", "중간고사", "기말고사", "프로젝트", "총점"};
		JRadioButton rb;
		ButtonGroup bg = new ButtonGroup();
		for(String btn : btNames) {
			rb = new JRadioButton(btn);
			rb.setActionCommand(btn);
			rb.addActionListener(handler);
			this.add(rb);
			bg.add(rb);
		}
	}
	
	public void init(DrawingPanel dp) {
		this.dp = dp;
		defaultClick();
	}
	
	private void defaultClick() {
		JRadioButton rButton = (JRadioButton)this.getComponent(4);
		rButton.doClick();
	}

	private class MyHandler implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String shapeType = e.getActionCommand();
			
			switch(shapeType) {
			case "출결":
				add_attendance();
				break;
			case "중간고사":
				add_midterm();
				break;
			case "기말고사":
				add_final();
				break;
			case "프로젝트":
				add_project();
				break;
			case "총점":
				add_total_score();
				break;
			}
		}

		private void add_total_score() {
			try {
				resultset = studentsQueries.selectAllStudent.executeQuery();
				
				dp.shapeList.clear();
				while(resultset.next()) {
					student_id = resultset.getInt("StudentID");
					student_name = resultset.getString("Student_name");
					attendance = resultset.getInt("Attendance");
					late = resultset.getInt("Late");
					absent = resultset.getInt("Absent");
					midterm = resultset.getInt("Midterm");
					Final = resultset.getInt("Final");
					presentation = resultset.getInt("Presentation");
					project_proposal = resultset.getInt("Project_proposal");
					requirement_specification = resultset.getInt("Requirement_specification");
					gui_plan = resultset.getInt("Gui_plan");
					design_specification = resultset.getInt("Design_specification");
					project_code = resultset.getInt("Project_code");
					final_report = resultset.getInt("Final_report");
					total_score = resultset.getInt("Total_score");
					grade = resultset.getString("Grade");
							
					dp.shapeList.add(new MyPoint(student_id,total_score));
				}
				// 드로잉 패널에서 다시 그리게 해야함
				dp.repaint();
			}	
			catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}finally {
				try {
					resultset.close();
				}catch(SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
		}
			
		private void add_project() {
			try {
				resultset = studentsQueries.selectAllStudent.executeQuery();
				
				dp.shapeList.clear();
				while(resultset.next()) {
					student_id = resultset.getInt("StudentID");
					student_name = resultset.getString("Student_name");
					attendance = resultset.getInt("Attendance");
					late = resultset.getInt("Late");
					absent = resultset.getInt("Absent");
					midterm = resultset.getInt("Midterm");
					Final = resultset.getInt("Final");
					presentation = resultset.getInt("Presentation");
					project_proposal = resultset.getInt("Project_proposal");
					requirement_specification = resultset.getInt("Requirement_specification");
					gui_plan = resultset.getInt("Gui_plan");
					design_specification = resultset.getInt("Design_specification");
					project_code = resultset.getInt("Project_code");
					final_report = resultset.getInt("Final_report");
					total_score = resultset.getInt("Total_score");
					grade = resultset.getString("Grade");
							
					int score = (int)Math.floor((
							(int)Math.floor(presentation*0.1)
							+(int)Math.floor(project_proposal*0.1)
							+(int)Math.floor(requirement_specification*0.15)
							+(int)Math.floor(gui_plan*0.15)
							+(int)Math.floor(design_specification*0.2)
							+(int)Math.floor(project_code*0.2)
							+(int)Math.floor(final_report*0.1)
							)*0.6);
					
					dp.shapeList.add(new MyPoint(student_id,score));
				}
				// 드로잉 패널에서 다시 그리게 해야함
				dp.repaint();
			}	
			catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}finally {
				try {
					resultset.close();
				}catch(SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
			
		}

		private void add_final() {
			try {
				resultset = studentsQueries.selectAllStudent.executeQuery();
				
				dp.shapeList.clear();
				while(resultset.next()) {
					student_id = resultset.getInt("StudentID");
					student_name = resultset.getString("Student_name");
					attendance = resultset.getInt("Attendance");
					late = resultset.getInt("Late");
					absent = resultset.getInt("Absent");
					midterm = resultset.getInt("Midterm");
					Final = resultset.getInt("Final");
					presentation = resultset.getInt("Presentation");
					project_proposal = resultset.getInt("Project_proposal");
					requirement_specification = resultset.getInt("Requirement_specification");
					gui_plan = resultset.getInt("Gui_plan");
					design_specification = resultset.getInt("Design_specification");
					project_code = resultset.getInt("Project_code");
					final_report = resultset.getInt("Final_report");
					total_score = resultset.getInt("Total_score");
					grade = resultset.getString("Grade");
							
					dp.shapeList.add(new MyPoint(student_id,Final));
				}
				// 드로잉 패널에서 다시 그리게 해야함
				dp.repaint();
			}	
			catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}finally {
				try {
					resultset.close();
				}catch(SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
		}
			
		private void add_midterm() {
			try {
				resultset = studentsQueries.selectAllStudent.executeQuery();
				
				dp.shapeList.clear();
				while(resultset.next()) {
					student_id = resultset.getInt("StudentID");
					student_name = resultset.getString("Student_name");
					attendance = resultset.getInt("Attendance");
					late = resultset.getInt("Late");
					absent = resultset.getInt("Absent");
					midterm = resultset.getInt("Midterm");
					Final = resultset.getInt("Final");
					presentation = resultset.getInt("Presentation");
					project_proposal = resultset.getInt("Project_proposal");
					requirement_specification = resultset.getInt("Requirement_specification");
					gui_plan = resultset.getInt("Gui_plan");
					design_specification = resultset.getInt("Design_specification");
					project_code = resultset.getInt("Project_code");
					final_report = resultset.getInt("Final_report");
					total_score = resultset.getInt("Total_score");
					grade = resultset.getString("Grade");
							
					dp.shapeList.add(new MyPoint(student_id,midterm));
				}
				// 드로잉 패널에서 다시 그리게 해야함
				dp.repaint();
			}	
			catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}finally {
				try {
					resultset.close();
				}catch(SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
		}
			
	}
	
	private void add_attendance() {
		try {
			resultset = studentsQueries.selectAllStudent.executeQuery();
			
			dp.shapeList.clear();
			while(resultset.next()) {
				student_id = resultset.getInt("StudentID");
				student_name = resultset.getString("Student_name");
				attendance = resultset.getInt("Attendance");
				late = resultset.getInt("Late");
				absent = resultset.getInt("Absent");
				midterm = resultset.getInt("Midterm");
				Final = resultset.getInt("Final");
				presentation = resultset.getInt("Presentation");
				project_proposal = resultset.getInt("Project_proposal");
				requirement_specification = resultset.getInt("Requirement_specification");
				gui_plan = resultset.getInt("Gui_plan");
				design_specification = resultset.getInt("Design_specification");
				project_code = resultset.getInt("Project_code");
				final_report = resultset.getInt("Final_report");
				total_score = resultset.getInt("Total_score");
				grade = resultset.getString("Grade");
				
				int score = (int)Math.floor(100 - absent - late*0.5);
				
				dp.shapeList.add(new MyPoint(student_id,score));
			}
			// 드로잉 패널에서 다시 그리게 해야함
			dp.repaint();
		}	
		catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}finally {
			try {
				resultset.close();
			}catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
	}

}
