package Query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DataModel.Grade_Ratio;

public class Grade_RatioQueries {
	
	private static final String URL = 
			"jdbc:mysql://localhost:3306/Grade_management?characterEncoding=UTF-8&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "pass";
	private Connection connection = null;
	public PreparedStatement selectAllGrade_Ratio = null;
	private PreparedStatement updateA_plus = null;
	private PreparedStatement updateA_zero = null;
	private PreparedStatement updateB_plus = null;
	private PreparedStatement updateB_zero = null;
	private PreparedStatement updateC_plus = null;
	private PreparedStatement updateC_zero = null;
	private PreparedStatement updateF = null;
	
	
	public Grade_RatioQueries() {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			selectAllGrade_Ratio = 
					connection.prepareStatement("SELECT * FROM Grades");
			updateA_plus = 
					connection.prepareStatement("UPDATE Grades SET A_plus = ? WHERE Grade = '등급 비율'");
			updateA_zero = 
					connection.prepareStatement("UPDATE Grades SET A_zero = ? WHERE Grade = '등급 비율'");
			updateB_plus = 
					connection.prepareStatement("UPDATE Grades SET B_plus = ? WHERE Grade = '등급 비율'");
			updateB_zero = 
					connection.prepareStatement("UPDATE Grades SET B_zero = ? WHERE Grade = '등급 비율'");
			updateC_plus = 
					connection.prepareStatement("UPDATE Grades SET C_plus = ? WHERE Grade = '등급 비율'");
			updateC_zero = 
					connection.prepareStatement("UPDATE Grades SET C_zero = ? WHERE Grade = '등급 비율'");
			updateF = 
					connection.prepareStatement("UPDATE Grades SET F = ? WHERE Grade = '등급 비율'");
			
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		}
	}
	
	public List<Grade_Ratio> getAllGrade_Ratio(){
		List<Grade_Ratio> results = null;
		ResultSet resultSet = null;
		
		try {
			resultSet = selectAllGrade_Ratio.executeQuery();
			results = new ArrayList<Grade_Ratio>(); 
			
			while(resultSet.next()) { 
				results.add(new Grade_Ratio(
					resultSet.getString("Grade"),
					resultSet.getInt("A_plus"),
					resultSet.getInt("A_zero"),
					resultSet.getInt("B_plus"),
					resultSet.getInt("B_zero"),
					resultSet.getInt("C_plus"),
					resultSet.getInt("C_zero"),
					resultSet.getInt("F")
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
	
	public int UpdateA_plus(int a_plus) {
		int result = 0;
			
		try {
			updateA_plus.setInt(1, a_plus);
			result = updateA_plus.executeUpdate(); 
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}
	
	public int UpdateA_zero(int a_zero) {
		int result = 0;
		
		try {
			updateA_zero.setInt(1, a_zero);
			result = updateA_zero.executeUpdate(); 
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}
	
	public int UpdateB_plus(int b_plus) {
		int result = 0;
		
		try {
			updateB_plus.setInt(1, b_plus);
			result = updateB_plus.executeUpdate(); 
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}
	
	public int UpdateB_zero(int b_zero) {
		int result = 0;
		
		try {
			updateB_zero.setInt(1, b_zero);
			result = updateB_zero.executeUpdate(); 
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}
	
	public int UpdateC_plus(int c_plus) {
		int result = 0;
		
		try {
			updateC_plus.setInt(1, c_plus);
			result = updateC_plus.executeUpdate(); 
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}
	
	public int UpdateC_zero(int c_zero) {
		int result = 0;
		
		try {
			updateC_zero.setInt(1, c_zero);
			result = updateC_zero.executeUpdate(); 
		}catch(SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		}
		return result;
	}
	
	public int UpdateF(int f) {
		int result = 0;
		
		try {
			updateF.setInt(1, f);
			result = updateF.executeUpdate(); 
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
