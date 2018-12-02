package MenuItemDisplay;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.opencsv.CSVReader;
import Query.StudentsQueries;
import MenuItemDisplay.Gui_Grade_Look_Up;

public class CSV_Input extends JFrame {
	private StudentsQueries studentsQueries;
	
	public CSV_Input(){
		super("파일로 점수 입력");
		studentsQueries = new StudentsQueries();

		for(String[] data : readerCSV("C:/Users/User/workspace/GradeManagement/성적.csv")){
			
			studentsQueries.UpdateAttendance(data[1].trim(), Integer.parseInt(data[2].trim()));
			studentsQueries.UpdateLate(data[1].trim(), Integer.parseInt(data[3].trim()));
			studentsQueries.UpdateAbsent(data[1].trim(), Integer.parseInt(data[4].trim()));
			studentsQueries.UpdateMidterm(data[1].trim(), Integer.parseInt(data[5].trim()));
			studentsQueries.UpdateFinal(data[1].trim(), Integer.parseInt(data[6].trim()));
			studentsQueries.UpdatePresentation(data[1].trim(), Integer.parseInt(data[7].trim()));
			studentsQueries.UpdateProject_proposal(data[1].trim(), Integer.parseInt(data[8].trim()));
			studentsQueries.UpdateRequirement_specification(data[1].trim(), Integer.parseInt(data[9].trim()));
			studentsQueries.UpdateGui_plan(data[1].trim(), Integer.parseInt(data[10].trim()));
			studentsQueries.UpdateDesign_specification(data[1].trim(), Integer.parseInt(data[11].trim()));
			studentsQueries.UpdateProject_code(data[1].trim(), Integer.parseInt(data[12].trim()));
			studentsQueries.UpdateFinal_report(data[1].trim(), Integer.parseInt(data[13].trim()));
		}
		new Gui_Grade_Look_Up();
	}
	
	public static List<String[]> readerCSV(String filePath){ 
		 List<String[]> content = new ArrayList<String[]>(); 
		 CSVReader reader = null;
		 try {
		  reader = new CSVReader(new FileReader(filePath));
		  content = reader.readAll(); //전체 데이터를 가져옴.
		 } catch (FileNotFoundException e) {
		  e.printStackTrace();
		 } catch (IOException e) {
		  e.printStackTrace();
		 } finally {
		  try {  
			  if(reader != null) reader.close(); 
			  } catch (IOException e) {}
		 }
		 content.remove(0);
		 return content;
		}

	
}
