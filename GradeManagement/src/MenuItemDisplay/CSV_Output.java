package MenuItemDisplay;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Query.StudentsQueries;

public class CSV_Output{
	
	//private String enc = new java.io.OutputStreamWriter(System.out).getEncoding();
	//System.out.println("���� ���ڵ� : " + enc);
	private StudentsQueries studentsQueries = null;
	private ResultSet resultset = null;
	
	public CSV_Output() {
		csv_save();
	}
	
	private void csv_save() {
		try {
			String csvFileName = "C:����.csv";
			studentsQueries = new StudentsQueries();
			
			String head = "�л�ID , �л� �̸� , �⼮ , ���� , �Ἦ , �߰���� , �⸻��� ,"
					+ " ��ǥ , ������Ʈ ���ȼ� , �䱸���� ���� , GUI ��ȹ�� , "
					+ "���� ���� , ���� ���α׷� �ڵ� , ���� ���� , ���� , ���� \r\n";
			String row = "";
			String student_id;
			String student_name;
			String attendance;
			String late;
			String absent;
			String midterm;
			String Final;
			String presentation;
			String project_proposal;
			String requirement_specification;
			String gui_plan;
			String design_specification;
			String project_code;
			String final_report;
			String total_score;
			String grade;
			
			BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(csvFileName), "MS949")
					);
			writer.write(head);
			
			resultset = studentsQueries.selectAllStudent.executeQuery();
			
			while(resultset.next()) {
				student_id = String.valueOf(resultset.getInt("StudentID"));
				student_name = resultset.getString("Student_name");
				attendance = String.valueOf((resultset.getInt("Attendance")));
				late = String.valueOf((resultset.getInt("Late")));
				absent = String.valueOf((resultset.getInt("Absent")));
				midterm = String.valueOf((resultset.getInt("Midterm")));
				Final = String.valueOf((resultset.getInt("Final")));
				presentation = String.valueOf((resultset.getInt("Presentation")));
				project_proposal = String.valueOf((resultset.getInt("Project_proposal")));
				requirement_specification = String.valueOf((resultset.getInt("Requirement_specification")));
				gui_plan = String.valueOf((resultset.getInt("Gui_plan")));
				design_specification = String.valueOf((resultset.getInt("Design_specification")));
				project_code = String.valueOf((resultset.getInt("Project_code")));
				final_report = String.valueOf((resultset.getInt("Final_report")));
				total_score = String.valueOf((resultset.getInt("Total_score")));
				grade = resultset.getString("Grade");
				
				row = student_id + " , " + student_name + " , " + attendance + " , " + 
				       late + " , " + absent + " , " + midterm + " , " +
					   Final + " , " + presentation + " , " + project_proposal + " , " +
				       requirement_specification + " , " + gui_plan + " , " + design_specification + " , " +
					   project_code + " , " + final_report + " , " + total_score + " , " + grade + "\r\n";
				   
				writer.write(row);
			}
			JOptionPane.showMessageDialog(null, "���� ������ ������ ������Ʈ ������ ����Ǿ����ϴ�!", "���� ���� ����", JOptionPane.PLAIN_MESSAGE);
			writer.close();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(SQLException sqlException) {
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

	
	
	
	
	
	
	
	
	
	