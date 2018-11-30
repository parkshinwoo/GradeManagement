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

public class Gui_Score_Input extends JFrame {
	
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
	private JButton update_attendanceButton; // 출석 횟수 입력 버튼
	private JTextField lateTextField; // 지각
	private JButton update_lateButton; // 지각 횟수 입력 버튼
	private JTextField absentTextField; // 결석
	private JButton update_absentButton; // 결석 횟수 입력 버튼
	private JTextField midtermTextField; // 중간고사
	private JButton update_midtermButton; // 중간고사 성적 입력 버튼
	private JTextField finalTextField; // 기말고사
	private JButton update_finalButton; // 기말고사 성적 입력 버튼
	private JTextField presentationTextField; // 발표
	private JButton update_presentationButton; // 발표 점수 입력 버튼
	private JTextField project_proposalTextField; // 프로젝트 제안서
	private JButton update_project_proposalButton; // 프로젝트 제안서 점수 입력 버튼
	private JTextField requirement_specificationTextField; // 요구사항 명세서
	private JButton update_requirement_specificationButton; // 요구사항 명세서 점수 입력 버튼
	private JTextField gui_planTextField; // gui 계획서
	private JButton update_gui_planButton; // gui 계획서 점수 입력 버튼
	private JTextField design_specificationTextField; // 설계 명세서
	private JButton update_design_specificationButton; // 설계 명세서 점수 입력 버튼
	private JTextField project_codeTextField; // 최종 프로그램 코드
	private JButton update_project_codeButton; // 최종 프로그램 코드 점수 입력 버튼
	private JTextField final_reportTextField; // 최종 보고서
	private JButton update_final_reportButton; // 최종 보고서 점수 입력 버튼
	private JTextField queryTextField; // 이름으로 검색할때 검색할 이름을 넣는 영역
	private JButton queryButton; // 이름으로 검색하는 버튼
	private JButton update_allButton; // 한꺼번에 모든 점수를 입력할때 쓰는 버튼 
	

	public Gui_Score_Input() {
		super("점수 입력");

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
		update_attendanceButton = new JButton("등록");
		lateTextField = new JTextField(10);
		update_lateButton = new JButton("등록");
		absentTextField = new JTextField(10);
		update_absentButton = new JButton("등록");
		midtermTextField = new JTextField(10);
		update_midtermButton = new JButton("등록");
		finalTextField = new JTextField(10);
		update_finalButton = new JButton("등록");
		presentationTextField = new JTextField(10);
		update_presentationButton = new JButton("등록");
		project_proposalTextField = new JTextField(10);
		update_project_proposalButton = new JButton("등록");
		requirement_specificationTextField = new JTextField(10);
		update_requirement_specificationButton = new JButton("등록");
		gui_planTextField = new JTextField(10);
		update_gui_planButton = new JButton("등록");
		design_specificationTextField = new JTextField(10);
		update_design_specificationButton = new JButton("등록");
		project_codeTextField = new JTextField(10);
		update_project_codeButton = new JButton("등록");
		final_reportTextField = new JTextField(10);
		update_final_reportButton = new JButton("등록");
		queryTextField = new JTextField(10);
		queryButton = new JButton("검색");
		browseButton = new JButton("모든 학생 검색");
		update_allButton = new JButton("모든 점수 등록");

		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		this.setSize(800, 600); 
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

		
		displayPanel.setLayout(new GridLayout(14, 3, 4, 4));
		
		displayPanel.add(new JLabel("학생 ID:"));
		idTextField.setEnabled(false);
		displayPanel.add(idTextField);
		displayPanel.add(new JLabel());

		displayPanel.add(new JLabel("이름:"));
		nameTextField.setEnabled(false);
		displayPanel.add(nameTextField);
		displayPanel.add(new JLabel());

		displayPanel.add(new JLabel("출석 횟수(몇회인지 숫자로 입력 (개근은 32)):"));
		displayPanel.add(attendanceTextField);
		update_attendanceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				update_attendanceButtonActonPerformed(evt);
			}
		});
		displayPanel.add(update_attendanceButton);
		
		displayPanel.add(new JLabel("지각 횟수(몇회인지 숫자로 입력):"));
		displayPanel.add(lateTextField);
		update_lateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				update_lateButtonActonPerformed(evt);
			}
		});
		displayPanel.add(update_lateButton);
		
		displayPanel.add(new JLabel("결석 횟수(몇회인지 숫자로 입력):"));
		displayPanel.add(absentTextField);
		update_absentButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				update_absentButtonActonPerformed(evt);
			}
		});
		displayPanel.add(update_absentButton);
		
		displayPanel.add(new JLabel("중간고사 점수(100점 만점으로 입력):"));
		displayPanel.add(midtermTextField);
		update_midtermButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				update_midtermButtonActonPerformed(evt);
			}
		});
		displayPanel.add(update_midtermButton);
		
		displayPanel.add(new JLabel("기말고사 점수(100점 만점으로 입력):"));
		displayPanel.add(finalTextField);
		update_finalButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				update_finalButtonActonPerformed(evt);
			}
		});
		displayPanel.add(update_finalButton);
		
		displayPanel.add(new JLabel("발표 점수(100점 만점으로 입력):"));
		displayPanel.add(presentationTextField);
		update_presentationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				update_presentationButtonActonPerformed(evt);
			}
		});
		displayPanel.add(update_presentationButton);
		
		displayPanel.add(new JLabel("프로젝트 제안서 점수(100점 만점으로 입력):"));
		displayPanel.add(project_proposalTextField);
		update_project_proposalButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				update_project_proposalButtonActonPerformed(evt);
			}
		});
		displayPanel.add(update_project_proposalButton);
		
		displayPanel.add(new JLabel("요구사항 명세서 점수(100점 만점으로 입력):"));
		displayPanel.add(requirement_specificationTextField);
		update_requirement_specificationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				update_requirement_specificationButtonActonPerformed(evt);
			}
		});
		displayPanel.add(update_requirement_specificationButton);
		
		displayPanel.add(new JLabel("GUI 계획서 점수(100점 만점으로 입력):"));
		displayPanel.add(gui_planTextField);
		update_gui_planButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				update_gui_planButtonActonPerformed(evt);
			}
		});
		displayPanel.add(update_gui_planButton);
		
		displayPanel.add(new JLabel("설계 명세서 점수(100점 만점으로 입력):"));
		displayPanel.add(design_specificationTextField);
		update_design_specificationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				update_design_specificationButtonActonPerformed(evt);
			}
		});
		displayPanel.add(update_design_specificationButton);
		
		displayPanel.add(new JLabel("최종 프로그램 점수(100점 만점으로 입력):"));
		displayPanel.add(project_codeTextField);
		update_project_codeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				update_project_codeButtonActonPerformed(evt);
			}
		});
		displayPanel.add(update_project_codeButton);
		
		displayPanel.add(new JLabel("최종 보고서 점수(100점 만점으로 입력):"));
		displayPanel.add(final_reportTextField);
		update_final_reportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				update_final_reportButtonActonPerformed(evt);
			}
		});
		displayPanel.add(update_final_reportButton);

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

		// 모든 점수를 한번에 업데이트 하는 버튼에 이벤트를 등록합니다.
		update_allButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				update_allButtonActonPerformed(evt);
			}

		});

		this.add(update_allButton);

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent evt) {
				studentsQueries.close();
				//System.exit(0);
			}
		});

		this.setVisible(true);
	}

	private void update_final_reportButtonActonPerformed(ActionEvent evt) {
		int result = studentsQueries.UpdateFinal_report(nameTextField.getText(), Integer.parseInt(final_reportTextField.getText()));

		if(result == 1) {
			JOptionPane.showMessageDialog(this, "점수 등록 성공!", "점수 등록", JOptionPane.PLAIN_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "점수가 등록되지 않았습니다!", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
	}

	private void update_project_codeButtonActonPerformed(ActionEvent evt) {
		int result = studentsQueries.UpdateProject_code(nameTextField.getText(), Integer.parseInt(project_codeTextField.getText()));

		if(result == 1) {
			JOptionPane.showMessageDialog(this, "점수 등록 성공!", "점수 등록", JOptionPane.PLAIN_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "점수가 등록되지 않았습니다!", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
	}

	private void update_design_specificationButtonActonPerformed(ActionEvent evt) {
		int result = studentsQueries.UpdateDesign_specification(nameTextField.getText(), Integer.parseInt(design_specificationTextField.getText()));

		if(result == 1) {
			JOptionPane.showMessageDialog(this, "점수 등록 성공!", "점수 등록", JOptionPane.PLAIN_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "점수가 등록되지 않았습니다!", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
	}

	private void update_gui_planButtonActonPerformed(ActionEvent evt) {
		int result = studentsQueries.UpdateGui_plan(nameTextField.getText(), Integer.parseInt(gui_planTextField.getText()));

		if(result == 1) {
			JOptionPane.showMessageDialog(this, "점수 등록 성공!", "점수 등록", JOptionPane.PLAIN_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "점수가 등록되지 않았습니다!", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
	}

	private void update_requirement_specificationButtonActonPerformed(ActionEvent evt) {
		int result = studentsQueries.UpdateRequirement_specification(nameTextField.getText(), Integer.parseInt(requirement_specificationTextField.getText()));

		if(result == 1) {
			JOptionPane.showMessageDialog(this, "점수 등록 성공!", "점수 등록", JOptionPane.PLAIN_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "점수가 등록되지 않았습니다!", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
	}

	private void update_project_proposalButtonActonPerformed(ActionEvent evt) {
		int result = studentsQueries.UpdateProject_proposal(nameTextField.getText(), Integer.parseInt(project_proposalTextField.getText()));

		if(result == 1) {
			JOptionPane.showMessageDialog(this, "점수 등록 성공!", "점수 등록", JOptionPane.PLAIN_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "점수가 등록되지 않았습니다!", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
	}

	private void update_presentationButtonActonPerformed(ActionEvent evt) {
		int result = studentsQueries.UpdatePresentation(nameTextField.getText(), Integer.parseInt(presentationTextField.getText()));

		if(result == 1) {
			JOptionPane.showMessageDialog(this, "점수 등록 성공!", "점수 등록", JOptionPane.PLAIN_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "점수가 등록되지 않았습니다!", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
	}

	private void update_finalButtonActonPerformed(ActionEvent evt) {
		int result = studentsQueries.UpdateFinal(nameTextField.getText(), Integer.parseInt(finalTextField.getText()));

		if(result == 1) {
			JOptionPane.showMessageDialog(this, "점수 등록 성공!", "점수 등록", JOptionPane.PLAIN_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "점수가 등록되지 않았습니다!", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
	}

	private void update_midtermButtonActonPerformed(ActionEvent evt) {
		int result = studentsQueries.UpdateMidterm(nameTextField.getText(), Integer.parseInt(midtermTextField.getText()));

		if(result == 1) {
			JOptionPane.showMessageDialog(this, "점수 등록 성공!", "점수 등록", JOptionPane.PLAIN_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "점수가 등록되지 않았습니다!", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
	}

	private void update_absentButtonActonPerformed(ActionEvent evt) {
		int result = studentsQueries.UpdateAbsent(nameTextField.getText(), Integer.parseInt(absentTextField.getText()));

		if(result == 1) {
			JOptionPane.showMessageDialog(this, "점수 등록 성공!", "점수 등록", JOptionPane.PLAIN_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "점수가 등록되지 않았습니다!", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
	}

	private void update_lateButtonActonPerformed(ActionEvent evt) {
		int result = studentsQueries.UpdateLate(nameTextField.getText(), Integer.parseInt(lateTextField.getText()));

		if(result == 1) {
			JOptionPane.showMessageDialog(this, "점수 등록 성공!", "점수 등록", JOptionPane.PLAIN_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "점수가 등록되지 않았습니다!", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
	}

	private void update_attendanceButtonActonPerformed(ActionEvent evt) {
		int result = studentsQueries.UpdateAttendance(nameTextField.getText(), Integer.parseInt(attendanceTextField.getText()));

		if(result == 1) {
			JOptionPane.showMessageDialog(this, "점수 등록 성공!", "점수 등록", JOptionPane.PLAIN_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "점수가 등록되지 않았습니다!", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
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
				
				
				nextButton.setEnabled(true);
				previousButton.setEnabled(true);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void update_allButtonActonPerformed(ActionEvent evt) {
		int[] result = new int[12];
		
		for(int i=0; i<12; i++) {
			if(i == 0)
				result[i] = studentsQueries.UpdateAttendance(nameTextField.getText(), Integer.parseInt(attendanceTextField.getText()));
			else if(i == 1)
				result[i] = studentsQueries.UpdateLate(nameTextField.getText(), Integer.parseInt(lateTextField.getText()));
			else if(i == 2)
				result[i] = studentsQueries.UpdateAbsent(nameTextField.getText(), Integer.parseInt(absentTextField.getText()));
			else if(i == 3)
				result[i] = studentsQueries.UpdateMidterm(nameTextField.getText(), Integer.parseInt(midtermTextField.getText()));
			else if(i == 4)
				result[i] = studentsQueries.UpdateFinal(nameTextField.getText(), Integer.parseInt(finalTextField.getText()));
			else if(i == 5)
				result[i] = studentsQueries.UpdatePresentation(nameTextField.getText(), Integer.parseInt(presentationTextField.getText()));
			else if(i == 6)
				result[i] = studentsQueries.UpdateProject_proposal(nameTextField.getText(), Integer.parseInt(project_proposalTextField.getText()));
			else if(i == 7)
				result[i] = studentsQueries.UpdateRequirement_specification(nameTextField.getText(), Integer.parseInt(requirement_specificationTextField.getText()));
			else if(i == 8)
				result[i] = studentsQueries.UpdateGui_plan(nameTextField.getText(), Integer.parseInt(gui_planTextField.getText()));
			else if(i == 9)
				result[i] = studentsQueries.UpdateDesign_specification(nameTextField.getText(), Integer.parseInt(design_specificationTextField.getText()));
			else if(i == 10)
				result[i] = studentsQueries.UpdateProject_code(nameTextField.getText(), Integer.parseInt(project_codeTextField.getText()));
			else if(i == 11)
				result[i] = studentsQueries.UpdateFinal_report(nameTextField.getText(), Integer.parseInt(final_reportTextField.getText()));
		}
		
		if(result[0] == 1 && result[1] == 1 && result[2] == 1 && result[3] == 1 && result[4] == 1 && result[5] == 1 && result[6] == 1 && result[7] == 1 && result[8] == 1 && result[9] == 1 && result[10] == 1 && result[11] == 1) {
			JOptionPane.showMessageDialog(this, "점수가 등록되었습니다!", "점수 등록", JOptionPane.PLAIN_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "점수가 등록되지 않았습니다!", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
	}

}
