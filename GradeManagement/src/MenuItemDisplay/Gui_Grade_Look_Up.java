package MenuItemDisplay;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DataModel.Students;
import Query.StudentsQueries;

public class Gui_Grade_Look_Up extends JFrame {
	private Students currentEntry; // 현재 표시되는 학생 객체를 위한 참조변수
	private StudentsQueries studentsQueries;
	private List<Students> results;
	private int numberOfEntries = 0;
	private int currentEntryIndex;

	private JButton browseButton; // 모든 학생 데이터를 조회하는 버튼
	private JButton previousButton; // 이전 객체를 보는 버튼
	private JTextField indexTextField; // 현재 몇번째 객체를 나타냈는지에 대한 번호 (페이지의 쪽수)
	private JTextField maxTextField; // 조회 가능한 객체들의 갯수 (페이지의 마지막 페이지 번호)
	private JButton nextButton; // 다음 객체를 보는 버튼
	private JTextField idTextField; // 학생의 StudentID를 표시하는 영역
	private JTextField nameTextField; // 학생 이름
	private JTextField attendanceTextField; // 출석
	private JTextField lateTextField; // 지각
	private JTextField absentTextField; // 결석
	private JTextField midtermTextField; // 중간고사
	private JTextField finalTextField; // 기말고사
	private JTextField presentationTextField; // 발표
	private JTextField project_proposalTextField; // 프로젝트 제안서
	private JTextField requirement_specificationTextField; // 요구사항 명세서
	private JTextField gui_planTextField; // gui 계획서
	private JTextField design_specificationTextField; // 설계 명세서
	private JTextField project_codeTextField; // 최종 프로그램 코드
	private JTextField final_reportTextField; // 최종 보고서
	private JTextField total_scoreTextField; // 총점
	private JTextField gradeTextField; // 학점
	private JTextField queryTextField; // 이름으로 검색할때 검색할 이름을 넣는 영역
	private JButton queryButton; // 이름으로 검색하는 버튼
	

	public Gui_Grade_Look_Up() {
		super("성적 조회");

		studentsQueries = new StudentsQueries();

		JPanel navigatePanel = new JPanel();
		JPanel queryPanel = new JPanel();
		JPanel displayPanel = new JPanel();

		previousButton = new JButton("이전");
		indexTextField = new JTextField(2);
		maxTextField = new JTextField(2);
		nextButton = new JButton("다음");
		idTextField = new JTextField(10);
		nameTextField = new JTextField(10);
		attendanceTextField = new JTextField(10);
		lateTextField = new JTextField(10);
		absentTextField = new JTextField(10);
		midtermTextField = new JTextField(10);
		finalTextField = new JTextField(10);
		presentationTextField = new JTextField(10);
		project_proposalTextField = new JTextField(10);
		requirement_specificationTextField = new JTextField(10);
		gui_planTextField = new JTextField(10);
		design_specificationTextField = new JTextField(10);
		project_codeTextField = new JTextField(10);
		final_reportTextField = new JTextField(10);
		total_scoreTextField = new JTextField(10);
		gradeTextField = new JTextField(10);
		queryTextField = new JTextField(10);
		queryButton = new JButton("검색");
		browseButton = new JButton("모든 학생 검색");
	
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		this.setSize(500, 580); 
		this.setResizable(false); 
		                                                    
		navigatePanel.setLayout(new BoxLayout(navigatePanel, BoxLayout.X_AXIS));

		previousButton.setEnabled(false); // 비활성화
		previousButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				previousButtonActionForformed(evt);

			}

		});

		navigatePanel.add(previousButton);
		navigatePanel.add(Box.createHorizontalStrut(10)); // 수평방향으로 10픽셀 간격

		indexTextField.setHorizontalAlignment(JTextField.CENTER);
		indexTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				indexTextFieldActionPerformed(evt);
			}

		});

		navigatePanel.add(indexTextField);
		navigatePanel.add(Box.createHorizontalStrut(10));

		navigatePanel.add(new JLabel("of"));
		navigatePanel.add(Box.createHorizontalStrut(10));

		maxTextField.setHorizontalAlignment(JTextField.CENTER); 
		maxTextField.setEditable(false);
		navigatePanel.add(maxTextField);
		navigatePanel.add(Box.createHorizontalStrut(10));

		nextButton.setEnabled(false);
		nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				nextButtonActionPerformed(evt);

			}

		});

		navigatePanel.add(nextButton);
		this.add(navigatePanel);

		displayPanel.setLayout(new GridLayout(16, 2, 4, 4));
		
		displayPanel.add(new JLabel("학생 ID:"));
		idTextField.setEnabled(false);
		displayPanel.add(idTextField);
		
		displayPanel.add(new JLabel("이름:"));
		nameTextField.setEnabled(false);
		displayPanel.add(nameTextField);
	
		displayPanel.add(new JLabel("출석 횟수:"));
		attendanceTextField.setEnabled(false);
		displayPanel.add(attendanceTextField);
		
		displayPanel.add(new JLabel("지각 횟수:"));
		lateTextField.setEnabled(false);
		displayPanel.add(lateTextField);
		
		displayPanel.add(new JLabel("결석 횟수:"));
		absentTextField.setEnabled(false);
		displayPanel.add(absentTextField);
		
		displayPanel.add(new JLabel("중간고사 점수:"));
		midtermTextField.setEnabled(false);
		displayPanel.add(midtermTextField);
		
		displayPanel.add(new JLabel("기말고사 점수:"));
		finalTextField.setEnabled(false);
		displayPanel.add(finalTextField);
		
		displayPanel.add(new JLabel("발표 점수:"));
		presentationTextField.setEnabled(false);
		displayPanel.add(presentationTextField);
		
		displayPanel.add(new JLabel("프로젝트 제안서 점수:"));
		project_proposalTextField.setEnabled(false);
		displayPanel.add(project_proposalTextField);
		
		displayPanel.add(new JLabel("요구사항 명세서 점수:"));
		requirement_specificationTextField.setEnabled(false);
		displayPanel.add(requirement_specificationTextField);
		
		displayPanel.add(new JLabel("GUI 계획서 점수:"));
		gui_planTextField.setEnabled(false);
		displayPanel.add(gui_planTextField);
		
		displayPanel.add(new JLabel("설계 명세서 점수:"));
		design_specificationTextField.setEnabled(false);
		displayPanel.add(design_specificationTextField);
		
		displayPanel.add(new JLabel("최종 프로그램 점수:"));
		project_codeTextField.setEnabled(false);
		displayPanel.add(project_codeTextField);
		
		displayPanel.add(new JLabel("최종 보고서 점수:"));
		final_reportTextField.setEnabled(false);
		displayPanel.add(final_reportTextField);
		
		displayPanel.add(new JLabel("총점:"));
		total_scoreTextField.setEnabled(false);
		displayPanel.add(total_scoreTextField);
		
		displayPanel.add(new JLabel("학점 등급:"));
		gradeTextField.setEnabled(false);
		displayPanel.add(gradeTextField);
		

		this.add(displayPanel);

		queryPanel.setLayout(new BoxLayout(queryPanel, BoxLayout.X_AXIS));
		queryPanel.setBorder(BorderFactory.createTitledBorder("이름으로 학생 찾기"));
		queryPanel.add(Box.createHorizontalStrut(5));
		queryPanel.add(new JLabel("이름:"));
		queryPanel.add(Box.createHorizontalStrut(10));
		queryPanel.add(queryTextField);
		queryPanel.add(Box.createHorizontalStrut(10));

		// 이름으로 조회하는 버튼에 이벤트를 등록합니다.
		queryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				queryButtonActionPerformed(evt);
			}
		});

		queryPanel.add(queryButton);
		queryPanel.add(Box.createHorizontalStrut(5));
		this.add(queryPanel);

		// 모든 학생을 조회하는 버튼에 이벤트를 등록합니다.
		browseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				browseButtonActionPerformed(evt);
			}

		});

		this.add(browseButton);


		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent evt) {
				studentsQueries.close();
				//System.exit(0);
			}
		});

		this.setVisible(true);
	}

	
	// 이전 객체를 보는 버튼
	private void previousButtonActionForformed(ActionEvent evt) {
		currentEntryIndex--;

		if(currentEntryIndex < 0) {
			currentEntryIndex = numberOfEntries - 1;
		}

		indexTextField.setText("" + (currentEntryIndex + 1));
		indexTextFieldActionPerformed(evt);
	}

	private void indexTextFieldActionPerformed(ActionEvent evt) {
		currentEntryIndex = (Integer.parseInt(indexTextField.getText()) - 1);

		if(numberOfEntries != 0 && currentEntryIndex < numberOfEntries) {
			currentEntry = results.get(currentEntryIndex);
			maxTextField.setText("" + numberOfEntries);
			indexTextField.setText("" + (currentEntryIndex + 1));
			
			idTextField.setText("" + currentEntry.getStudentID());
			nameTextField.setText(currentEntry.getStudent_name());
			attendanceTextField.setText(String.valueOf(currentEntry.getAttendance()));
			lateTextField.setText(String.valueOf(currentEntry.getLate()));
			absentTextField.setText(String.valueOf(currentEntry.getAbsent()));
			midtermTextField.setText(String.valueOf(currentEntry.getMidterm()));
			finalTextField.setText(String.valueOf(currentEntry.getFinal()));
			presentationTextField.setText(String.valueOf(currentEntry.getPresentation()));
			project_proposalTextField.setText(String.valueOf(currentEntry.getProject_proposal()));
			requirement_specificationTextField.setText(String.valueOf(currentEntry.getRequirement_specification()));
			gui_planTextField.setText(String.valueOf(currentEntry.getGui_plan()));
			design_specificationTextField.setText(String.valueOf(currentEntry.getDesign_specification()));
			project_codeTextField.setText(String.valueOf(currentEntry.getProject_code()));
			final_reportTextField.setText(String.valueOf(currentEntry.getFinal_report()));
			total_scoreTextField.setText(String.valueOf(currentEntry.getTotal_score()));
			gradeTextField.setText(currentEntry.getGrade());
			
		}
	}

	// 다음 객체를 보는 버튼
	private void nextButtonActionPerformed(ActionEvent evt) {
		currentEntryIndex++;

		if(currentEntryIndex >= numberOfEntries) {
			currentEntryIndex = 0;
		}

		indexTextField.setText("" + (currentEntryIndex + 1));
		indexTextFieldActionPerformed(evt);
	}

	private void queryButtonActionPerformed(ActionEvent evt) {
		results = studentsQueries.getStudentByName(queryTextField.getText());
		numberOfEntries = results.size();
		if(numberOfEntries != 0) {
			currentEntryIndex = 0;
			currentEntry = results.get(currentEntryIndex);
			maxTextField.setText("" + numberOfEntries);
			indexTextField.setText("" + (currentEntryIndex + 1));
			
			idTextField.setText("" + currentEntry.getStudentID());
			nameTextField.setText(currentEntry.getStudent_name());
			attendanceTextField.setText(String.valueOf(currentEntry.getAttendance()));
			lateTextField.setText(String.valueOf(currentEntry.getLate()));
			absentTextField.setText(String.valueOf(currentEntry.getAbsent()));
			midtermTextField.setText(String.valueOf(currentEntry.getMidterm()));
			finalTextField.setText(String.valueOf(currentEntry.getFinal()));
			presentationTextField.setText(String.valueOf(currentEntry.getPresentation()));
			project_proposalTextField.setText(String.valueOf(currentEntry.getProject_proposal()));
			requirement_specificationTextField.setText(String.valueOf(currentEntry.getRequirement_specification()));
			gui_planTextField.setText(String.valueOf(currentEntry.getGui_plan()));
			design_specificationTextField.setText(String.valueOf(currentEntry.getDesign_specification()));
			project_codeTextField.setText(String.valueOf(currentEntry.getProject_code()));
			final_reportTextField.setText(String.valueOf(currentEntry.getFinal_report()));
			total_scoreTextField.setText(String.valueOf(currentEntry.getTotal_score()));
			gradeTextField.setText(currentEntry.getGrade());
			
			nextButton.setEnabled(true);
			previousButton.setEnabled(true);
		}else {
			browseButtonActionPerformed(evt);
		}
	}

	private void browseButtonActionPerformed(ActionEvent evt) {
		try {
			results = studentsQueries.getAllStudent();
			numberOfEntries = results.size();

			if(numberOfEntries != 0) {
				currentEntryIndex = 0;
				currentEntry = results.get(currentEntryIndex);
				maxTextField.setText("" + numberOfEntries);
				indexTextField.setText("" + (currentEntryIndex + 1));
				
				idTextField.setText("" + currentEntry.getStudentID());
				nameTextField.setText(currentEntry.getStudent_name());
				attendanceTextField.setText(String.valueOf(currentEntry.getAttendance()));
				lateTextField.setText(String.valueOf(currentEntry.getLate()));
				absentTextField.setText(String.valueOf(currentEntry.getAbsent()));
				midtermTextField.setText(String.valueOf(currentEntry.getMidterm()));
				finalTextField.setText(String.valueOf(currentEntry.getFinal()));
				presentationTextField.setText(String.valueOf(currentEntry.getPresentation()));
				project_proposalTextField.setText(String.valueOf(currentEntry.getProject_proposal()));
				requirement_specificationTextField.setText(String.valueOf(currentEntry.getRequirement_specification()));
				gui_planTextField.setText(String.valueOf(currentEntry.getGui_plan()));
				design_specificationTextField.setText(String.valueOf(currentEntry.getDesign_specification()));
				project_codeTextField.setText(String.valueOf(currentEntry.getProject_code()));
				final_reportTextField.setText(String.valueOf(currentEntry.getFinal_report()));
				total_scoreTextField.setText(String.valueOf(currentEntry.getTotal_score()));
				gradeTextField.setText(currentEntry.getGrade());
				
				nextButton.setEnabled(true);
				previousButton.setEnabled(true);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
}
