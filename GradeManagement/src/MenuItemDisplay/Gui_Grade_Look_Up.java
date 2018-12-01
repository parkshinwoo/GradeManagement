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
	private Students currentEntry; // ���� ǥ�õǴ� �л� ��ü�� ���� ��������
	private StudentsQueries studentsQueries;
	private List<Students> results;
	private int numberOfEntries = 0;
	private int currentEntryIndex;

	private JButton browseButton; // ��� �л� �����͸� ��ȸ�ϴ� ��ư
	private JButton previousButton; // ���� ��ü�� ���� ��ư
	private JTextField indexTextField; // ���� ���° ��ü�� ��Ÿ�´����� ���� ��ȣ (�������� �ʼ�)
	private JTextField maxTextField; // ��ȸ ������ ��ü���� ���� (�������� ������ ������ ��ȣ)
	private JButton nextButton; // ���� ��ü�� ���� ��ư
	private JTextField idTextField; // �л��� StudentID�� ǥ���ϴ� ����
	private JTextField nameTextField; // �л� �̸�
	private JTextField attendanceTextField; // �⼮
	private JTextField lateTextField; // ����
	private JTextField absentTextField; // �Ἦ
	private JTextField midtermTextField; // �߰����
	private JTextField finalTextField; // �⸻���
	private JTextField presentationTextField; // ��ǥ
	private JTextField project_proposalTextField; // ������Ʈ ���ȼ�
	private JTextField requirement_specificationTextField; // �䱸���� ����
	private JTextField gui_planTextField; // gui ��ȹ��
	private JTextField design_specificationTextField; // ���� ����
	private JTextField project_codeTextField; // ���� ���α׷� �ڵ�
	private JTextField final_reportTextField; // ���� ����
	private JTextField total_scoreTextField; // ����
	private JTextField gradeTextField; // ����
	private JTextField queryTextField; // �̸����� �˻��Ҷ� �˻��� �̸��� �ִ� ����
	private JButton queryButton; // �̸����� �˻��ϴ� ��ư
	

	public Gui_Grade_Look_Up() {
		super("���� ��ȸ");

		studentsQueries = new StudentsQueries();

		JPanel navigatePanel = new JPanel();
		JPanel queryPanel = new JPanel();
		JPanel displayPanel = new JPanel();

		previousButton = new JButton("����");
		indexTextField = new JTextField(2);
		maxTextField = new JTextField(2);
		nextButton = new JButton("����");
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
		queryButton = new JButton("�˻�");
		browseButton = new JButton("��� �л� �˻�");
	
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		this.setSize(500, 580); 
		this.setResizable(false); 
		                                                    
		navigatePanel.setLayout(new BoxLayout(navigatePanel, BoxLayout.X_AXIS));

		previousButton.setEnabled(false); // ��Ȱ��ȭ
		previousButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				previousButtonActionForformed(evt);

			}

		});

		navigatePanel.add(previousButton);
		navigatePanel.add(Box.createHorizontalStrut(10)); // ����������� 10�ȼ� ����

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
		
		displayPanel.add(new JLabel("�л� ID:"));
		idTextField.setEnabled(false);
		displayPanel.add(idTextField);
		
		displayPanel.add(new JLabel("�̸�:"));
		nameTextField.setEnabled(false);
		displayPanel.add(nameTextField);
	
		displayPanel.add(new JLabel("�⼮ Ƚ��:"));
		attendanceTextField.setEnabled(false);
		displayPanel.add(attendanceTextField);
		
		displayPanel.add(new JLabel("���� Ƚ��:"));
		lateTextField.setEnabled(false);
		displayPanel.add(lateTextField);
		
		displayPanel.add(new JLabel("�Ἦ Ƚ��:"));
		absentTextField.setEnabled(false);
		displayPanel.add(absentTextField);
		
		displayPanel.add(new JLabel("�߰���� ����:"));
		midtermTextField.setEnabled(false);
		displayPanel.add(midtermTextField);
		
		displayPanel.add(new JLabel("�⸻��� ����:"));
		finalTextField.setEnabled(false);
		displayPanel.add(finalTextField);
		
		displayPanel.add(new JLabel("��ǥ ����:"));
		presentationTextField.setEnabled(false);
		displayPanel.add(presentationTextField);
		
		displayPanel.add(new JLabel("������Ʈ ���ȼ� ����:"));
		project_proposalTextField.setEnabled(false);
		displayPanel.add(project_proposalTextField);
		
		displayPanel.add(new JLabel("�䱸���� ���� ����:"));
		requirement_specificationTextField.setEnabled(false);
		displayPanel.add(requirement_specificationTextField);
		
		displayPanel.add(new JLabel("GUI ��ȹ�� ����:"));
		gui_planTextField.setEnabled(false);
		displayPanel.add(gui_planTextField);
		
		displayPanel.add(new JLabel("���� ���� ����:"));
		design_specificationTextField.setEnabled(false);
		displayPanel.add(design_specificationTextField);
		
		displayPanel.add(new JLabel("���� ���α׷� ����:"));
		project_codeTextField.setEnabled(false);
		displayPanel.add(project_codeTextField);
		
		displayPanel.add(new JLabel("���� ���� ����:"));
		final_reportTextField.setEnabled(false);
		displayPanel.add(final_reportTextField);
		
		displayPanel.add(new JLabel("����:"));
		total_scoreTextField.setEnabled(false);
		displayPanel.add(total_scoreTextField);
		
		displayPanel.add(new JLabel("���� ���:"));
		gradeTextField.setEnabled(false);
		displayPanel.add(gradeTextField);
		

		this.add(displayPanel);

		queryPanel.setLayout(new BoxLayout(queryPanel, BoxLayout.X_AXIS));
		queryPanel.setBorder(BorderFactory.createTitledBorder("�̸����� �л� ã��"));
		queryPanel.add(Box.createHorizontalStrut(5));
		queryPanel.add(new JLabel("�̸�:"));
		queryPanel.add(Box.createHorizontalStrut(10));
		queryPanel.add(queryTextField);
		queryPanel.add(Box.createHorizontalStrut(10));

		// �̸����� ��ȸ�ϴ� ��ư�� �̺�Ʈ�� ����մϴ�.
		queryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				queryButtonActionPerformed(evt);
			}
		});

		queryPanel.add(queryButton);
		queryPanel.add(Box.createHorizontalStrut(5));
		this.add(queryPanel);

		// ��� �л��� ��ȸ�ϴ� ��ư�� �̺�Ʈ�� ����մϴ�.
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

	
	// ���� ��ü�� ���� ��ư
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

	// ���� ��ü�� ���� ��ư
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
