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
import DataModel.Grade_Ratio;
import Query.StudentsQueries;
import Query.Grade_RatioQueries;

public class Grant_Grade extends JFrame {
	private Grade_Ratio currentEntry; 
	private Grade_RatioQueries grade_ratioQueries;
	private List<Grade_Ratio> results;
	private StudentsQueries studentsQueries;
	private int numberOfEntries = 0;
	private int currentEntryIndex;

	private JButton browseButton; 
	
	private JTextField attendanceTextField; // 출석
	private JTextField midtermTextField; // 중간고사
	private JTextField finalTextField; // 기말고사
	private JTextField presentationTextField; // 발표
	private JTextField project_proposalTextField; // 프로젝트 제안서
	private JTextField requirement_specificationTextField; // 요구사항 명세서
	private JTextField gui_planTextField; // gui 계획서
	private JTextField design_specificationTextField; // 설계 명세서
	private JTextField project_codeTextField; // 최종 프로그램 코드
	private JTextField final_reportTextField; // 최종 보고서
	private JTextField a_plusTextField;
	private JTextField a_zeroTextField;
	private JTextField b_plusTextField;
	private JTextField b_zeroTextField;
	private JTextField c_plusTextField;
	private JTextField c_zeroTextField;
	private JTextField fTextField;
	
	private JButton grant_gradeButton; // 학점을 부여하는 이벤트를 발생시키는 버튼
	
	public Grant_Grade() {
		super("학점 부여");

		grade_ratioQueries = new Grade_RatioQueries();
		studentsQueries = new StudentsQueries();

		JPanel displayPanel = new JPanel();
		
		attendanceTextField = new JTextField(10);
		midtermTextField = new JTextField(10);
		finalTextField = new JTextField(10);
		presentationTextField = new JTextField(10);
		project_proposalTextField = new JTextField(10);
		requirement_specificationTextField = new JTextField(10);
		gui_planTextField = new JTextField(10);
		design_specificationTextField = new JTextField(10);
		project_codeTextField = new JTextField(10);
		final_reportTextField = new JTextField(10);
		a_plusTextField = new JTextField(10);
		a_zeroTextField= new JTextField(10);
		b_plusTextField = new JTextField(10);
		b_zeroTextField = new JTextField(10);
		c_plusTextField = new JTextField(10);
		c_zeroTextField = new JTextField(10);
		fTextField = new JTextField(10);
		
		browseButton = new JButton("학점 등급 비율 조회");
		grant_gradeButton = new JButton("학점 부여");

		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		this.setSize(500, 570); 
		this.setResizable(false); 
		                                                    
		displayPanel.setLayout(new GridLayout(18, 2, 4, 4));
		
		displayPanel.add(new JLabel("출석 반영 비율:"));
		displayPanel.add(new JLabel("10%"));
		
		displayPanel.add(new JLabel("중간고사 반영 비율:"));
		displayPanel.add(new JLabel("15%"));
		
		displayPanel.add(new JLabel("기말고사 반영 비율:"));
		displayPanel.add(new JLabel("15%"));
		
		displayPanel.add(new JLabel("프로젝트 반영 비율:"));
		displayPanel.add(new JLabel("60%"));
		
		displayPanel.add(new JLabel("발표 반영 비율:"));
		displayPanel.add(new JLabel("10% (of 60%)"));
		
		displayPanel.add(new JLabel("프로젝트 제안서 반영 비율:"));
		displayPanel.add(new JLabel("10% (of 60%)"));
		
		displayPanel.add(new JLabel("요구사항 명세서 반영 비율:"));
		displayPanel.add(new JLabel("15% (of 60%)"));
		
		displayPanel.add(new JLabel("GUI 계획서 반영 비율:"));
		displayPanel.add(new JLabel("15% (of 60%)"));
		
		displayPanel.add(new JLabel("설계명세서 반영 비율:"));
		displayPanel.add(new JLabel("20% (of 60%)"));
		
		displayPanel.add(new JLabel("최종 프로그램 코드 반영 비율:"));
		displayPanel.add(new JLabel("20% (of 60%)"));
		
		displayPanel.add(new JLabel("최종 보고서 반영 비율:"));
		displayPanel.add(new JLabel("10% (of 60%)"));
		
		displayPanel.add(new JLabel("A+:"));
		displayPanel.add(a_plusTextField);

		displayPanel.add(new JLabel("A0:"));
		displayPanel.add(a_zeroTextField);

		displayPanel.add(new JLabel("B+:"));
		displayPanel.add(b_plusTextField);
		
		displayPanel.add(new JLabel("B0:"));
		displayPanel.add(b_zeroTextField);
		
		displayPanel.add(new JLabel("C+:"));
		displayPanel.add(c_plusTextField);
		
		displayPanel.add(new JLabel("C0:"));
		displayPanel.add(c_zeroTextField);
		
		displayPanel.add(new JLabel("F:"));
		displayPanel.add(fTextField);
		
		this.add(displayPanel);
		
		browseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				browseButtonActionPerformed(evt);
			}

		});

		this.add(browseButton);
		
		grant_gradeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				grant_gradeButtonActonPerformed(evt);
			}

		});

		this.add(grant_gradeButton);

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent evt) {
				grade_ratioQueries.close();
				studentsQueries.close();
				//System.exit(0);
			}
		});

		this.setVisible(true);
	}


	private void browseButtonActionPerformed(ActionEvent evt) {
		try {
			results = grade_ratioQueries.getAllGrade_Ratio();
			numberOfEntries = results.size();

			if(numberOfEntries != 0) {
				currentEntryIndex = 0;
				currentEntry = results.get(currentEntryIndex);

				a_plusTextField.setText(String.valueOf(currentEntry.getA_plus()));
				a_zeroTextField.setText(String.valueOf(currentEntry.getA_zero()));
				b_plusTextField.setText(String.valueOf(currentEntry.getB_plus()));
				b_zeroTextField.setText(String.valueOf(currentEntry.getB_zero()));
				c_plusTextField.setText(String.valueOf(currentEntry.getC_plus()));
				c_zeroTextField.setText(String.valueOf(currentEntry.getC_zero()));
				fTextField.setText(String.valueOf(currentEntry.getF()));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void grant_gradeButtonActonPerformed(ActionEvent evt) {
		int average_total_score = 0;
		
		average_total_score = studentsQueries.computeTotalScore(); // 전체 총점을 계산합니다.
		studentsQueries.grantGrade(); // 학점을 부여합니다.
			
		JOptionPane.showMessageDialog(this, "전체 학생 총점의 평균:"+average_total_score, "학점 부여 완료!", JOptionPane.PLAIN_MESSAGE);
	
		browseButtonActionPerformed(evt);
	}

}
