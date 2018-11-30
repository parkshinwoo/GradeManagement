package Query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DataModel.Students;

public class StudentsQueries {
	private static final String URL = 
			"jdbc:mysql://localhost:3306/Grade_management?characterEncoding=UTF-8&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "pass";
	
	private Connection connection = null;
	
	private PreparedStatement selectAllStudent = null;
	private PreparedStatement selectStudentByName = null;
	private PreparedStatement updateAttendance = null;
	private PreparedStatement updateLate = null;
	private PreparedStatement updateAbsent = null;
	private PreparedStatement updateMidterm = null;
	private PreparedStatement updateFinal = null;
	private PreparedStatement updatePresentation = null;
	private PreparedStatement updateProject_proposal = null;
	private PreparedStatement updateRequirement_specification = null;
	private PreparedStatement updateGui_plan = null;
	private PreparedStatement updateDesign_specification = null;
	private PreparedStatement updateProject_code = null;
	private PreparedStatement updateFinal_report = null;
	
	private PreparedStatement updateTotal_score = null;
	private PreparedStatement updateGrade = null;
	
	
	public StudentsQueries() {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			selectAllStudent = 
					connection.prepareStatement("SELECT * FROM Students");
			selectStudentByName = 
					connection.prepareStatement("SELECT * FROM Students WHERE Student_name = ?");
			updateAttendance = 
					connection.prepareStatement("UPDATE Students SET Attendance = ? WHERE Student_name = ?");
			updateLate = 
					connection.prepareStatement("UPDATE Students SET Late = ? WHERE Student_name = ?");
			updateAbsent = 
					connection.prepareStatement("UPDATE Students SET Absent = ? WHERE Student_name = ?");
			updateMidterm = 
					connection.prepareStatement("UPDATE Students SET Midterm = ? WHERE Student_name = ?");
			updateFinal = 
					connection.prepareStatement("UPDATE Students SET Final = ? WHERE Student_name = ?");
			updatePresentation = 
					connection.prepareStatement("UPDATE Students SET Presentation = ? WHERE Student_name = ?");
			updateProject_proposal = 
					connection.prepareStatement("UPDATE Students SET Project_proposal = ? WHERE Student_name = ?");
			updateRequirement_specification =
					connection.prepareStatement("UPDATE Students SET Requirement_specification = ? WHERE Student_name = ?");
			updateGui_plan = 
					connection.prepareStatement("UPDATE Students SET Gui_plan = ? WHERE Student_name = ?");
			updateDesign_specification =
					connection.prepareStatement("UPDATE Students SET Design_specification = ? WHERE Student_name = ?");
			updateProject_code = 
					connection.prepareStatement("UPDATE Students SET Project_code = ? WHERE Student_name = ?");
			updateFinal_report =
					connection.prepareStatement("UPDATE Students SET Final_report = ? WHERE Student_name = ?");
			
			updateTotal_score = 
					connection.prepareStatement("UPDATE Students SET Total_score = ? WHERE Student_name = ?");
			updateGrade = 
					connection.prepareStatement("UPDATE Students SET Total_score = ? WHERE Student_name = ?");
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		}
	}
	
	public List<Students> getAllStudent(){
		List<Students> results = null;
		ResultSet resultSet = null;
		
		try {
			resultSet = selectAllStudent.executeQuery();
			results = new ArrayList<Students>(); 
			
			while(resultSet.next()) { 
				results.add(new Students(
					resultSet.getInt("StudentID"), 
					resultSet.getString("Student_name"),
					resultSet.getInt("Attendance"),
					resultSet.getInt("Late"),
					resultSet.getInt("Absent"),
					resultSet.getInt("Midterm"),
					resultSet.getInt("Final"),
					resultSet.getInt("Presentation"),
					resultSet.getInt("Project_proposal"),
					resultSet.getInt("Requirement_specification"),
					resultSet.getInt("Gui_plan"),
					resultSet.getInt("Design_specification"),
					resultSet.getInt("Project_code"),
					resultSet.getInt("Final_report"),
					resultSet.getInt("Total_score"),
					resultSet.getString("Grade")
					));
			}
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}finally { 
			try {
				resultSet.close();  
			}catch(SQLException sqlException) {
				sqlException.printStackTrace();
				close(); 
			}
		}
		return results;
	}
	                                     
	public List<Students> getStudentByName(String name){
		List<Students> results = null;
		ResultSet resultSet = null;
		
		try {
			selectStudentByName.setString(1, name); 
			
			resultSet = selectStudentByName.executeQuery(); 
			
			results = new ArrayList<Students>();
			
			while(resultSet.next()) {
				results.add(new Students(
						resultSet.getInt("StudentID"), 
						resultSet.getString("Student_name"),
						resultSet.getInt("Attendance"),
						resultSet.getInt("Late"),
						resultSet.getInt("Absent"),
						resultSet.getInt("Midterm"),
						resultSet.getInt("Final"),
						resultSet.getInt("Presentation"),
						resultSet.getInt("Project_proposal"),
						resultSet.getInt("Requirement_specification"),
						resultSet.getInt("Gui_plan"),
						resultSet.getInt("Design_specification"),
						resultSet.getInt("Project_code"),
						resultSet.getInt("Final_report"),
						resultSet.getInt("Total_score"),
						resultSet.getString("Grade")
						));
			}
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}finally {
			try {
				resultSet.close();
			}catch(SQLException sqlException) {
				sqlException.printStackTrace();
				close();
			}
		}
		return results; 
	}
	
	public int UpdateAttendance(String name, int attendance) {
		int result = 0;
		
		if(attendance < 0) {
			attendance = 0;
		}else if(attendance > 32) {
			attendance = 32; // 16주, 1주에 수업 2회이므로 최대 32회
		}
		
		try {
			updateAttendance.setInt(1, attendance);
			updateAttendance.setString(2, name);
			result = updateAttendance.executeUpdate(); 
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}
	public int UpdateLate(String name, int late) {
		int result = 0;
		
		if(late < 0) {
			late = 0;
		}else if(late > 32) {
			late = 32;
		}
		
		try {
			updateLate.setInt(1, late);
			updateLate.setString(2, name);
			result = updateLate.executeUpdate(); 
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}
	public int UpdateAbsent(String name, int absent) {
		int result = 0;
		
		if(absent < 0) {
			absent = 0;
		}else if(absent > 32) {
			absent = 32;
		}
		
		try {
			updateAbsent.setInt(1, absent);
			updateAbsent.setString(2, name);
			result = updateAbsent.executeUpdate(); 
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}
	public int UpdateMidterm(String name, int midterm) {
		int result = 0;
		
		if(midterm < 0) {
			midterm = 0;
		}else if(midterm > 100) {
			midterm = 100; // 입력은 100점 만점 기준으로 합니다. 향후 성적 계산시, 설정한 비율에 맞춰서 계산
		}
		
		try {
			updateMidterm.setInt(1, midterm);
			updateMidterm.setString(2, name);
			result = updateMidterm.executeUpdate(); 
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}
	public int UpdateFinal(String name, int Final) {
		int result = 0;
		
		if(Final < 0) {
			Final = 0;
		}else if(Final > 100) {
			Final = 100;
		}
		
		try {
			updateFinal.setInt(1, Final);
			updateFinal.setString(2, name);
			result = updateFinal.executeUpdate(); 
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}
	public int UpdatePresentation(String name, int presentation) {
		int result = 0;
		
		if(presentation < 0) {
			presentation = 0;
		}else if(presentation > 100) {
			presentation = 100;
		}
		
		try {
			updatePresentation.setInt(1, presentation);
			updatePresentation.setString(2, name);
			result = updatePresentation.executeUpdate(); 
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}
	public int UpdateProject_proposal(String name, int project_proposal) {
		int result = 0;
		
		if(project_proposal < 0) {
			project_proposal = 0;
		}else if(project_proposal > 100) {
			project_proposal = 100;
		}
		
		try {
			updateProject_proposal.setInt(1, project_proposal);
			updateProject_proposal.setString(2, name);
			result = updateProject_proposal.executeUpdate(); 
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}
	public int UpdateRequirement_specification(String name, int requirement_specification) {
		int result = 0;
		
		if(requirement_specification < 0) {
			requirement_specification = 0;
		}else if(requirement_specification > 100) {
			requirement_specification = 100;
		}
		
		try {
			updateRequirement_specification.setInt(1, requirement_specification);
			updateRequirement_specification.setString(2, name);
			result = updateRequirement_specification.executeUpdate(); 
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}
	public int UpdateGui_plan(String name, int gui_plan) {
		int result = 0;
		
		if(gui_plan < 0) {
			gui_plan = 0;
		}else if(gui_plan > 100) {
			gui_plan = 100;
		}
		
		try {
			updateGui_plan.setInt(1, gui_plan);
			updateGui_plan.setString(2, name);
			result = updateGui_plan.executeUpdate(); 
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}
	public int UpdateDesign_specification(String name, int design_specification) {
		int result = 0;
		
		if(design_specification < 0) {
			design_specification = 0;
		}else if(design_specification > 100) {
			design_specification = 100;
		}
		
		try {
			updateDesign_specification.setInt(1, design_specification);
			updateDesign_specification.setString(2, name);
			result = updateDesign_specification.executeUpdate(); 
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}
	public int UpdateProject_code(String name, int project_code) {
		int result = 0;
		
		if(project_code < 0) {
			project_code = 0;
		}else if(project_code > 100) {
			project_code = 100;
		}
		
		try {
			updateProject_code.setInt(1, project_code);
			updateProject_code.setString(2, name);
			result = updateProject_code.executeUpdate(); 
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}
	public int UpdateFinal_report(String name, int final_report) {
		int result = 0;
		
		if(final_report < 0) {
			final_report = 0;
		}else if(final_report > 100) {
			final_report = 100;
		}
		
		try {
			updateFinal_report.setInt(1, final_report);
			updateFinal_report.setString(2, name);
			result = updateFinal_report.executeUpdate(); 
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}
	
	public int UpdateTotal_score(String name, int total_score) {
		int result = 0;
		
		if(total_score < 0) {
			total_score = 0;
		}else if(total_score > 100) {
			total_score = 100;
		}
		
		try {
			updateTotal_score.setInt(1, total_score);
			updateTotal_score.setString(2, name);
			result = updateTotal_score.executeUpdate(); 
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}
	
	public int UpdateGrade(String name, String grade) {
		int result = 0;
		
		try {
			updateGrade.setString(1, grade);
			updateGrade.setString(2, name);
			result = updateGrade.executeUpdate(); 
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}
	
	public void close() {
		try {
			connection.close();
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
}
