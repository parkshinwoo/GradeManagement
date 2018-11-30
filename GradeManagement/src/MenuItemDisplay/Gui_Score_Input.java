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
	private JButton update_attendanceButton; // �⼮ Ƚ�� �Է� ��ư
	private JTextField lateTextField; // ����
	private JButton update_lateButton; // ���� Ƚ�� �Է� ��ư
	private JTextField absentTextField; // �Ἦ
	private JButton update_absentButton; // �Ἦ Ƚ�� �Է� ��ư
	private JTextField midtermTextField; // �߰����
	private JButton update_midtermButton; // �߰���� ���� �Է� ��ư
	private JTextField finalTextField; // �⸻���
	private JButton update_finalButton; // �⸻��� ���� �Է� ��ư
	private JTextField presentationTextField; // ��ǥ
	private JButton update_presentationButton; // ��ǥ ���� �Է� ��ư
	private JTextField project_proposalTextField; // ������Ʈ ���ȼ�
	private JButton update_project_proposalButton; // ������Ʈ ���ȼ� ���� �Է� ��ư
	private JTextField requirement_specificationTextField; // �䱸���� ����
	private JButton update_requirement_specificationButton; // �䱸���� ���� ���� �Է� ��ư
	private JTextField gui_planTextField; // gui ��ȹ��
	private JButton update_gui_planButton; // gui ��ȹ�� ���� �Է� ��ư
	private JTextField design_specificationTextField; // ���� ����
	private JButton update_design_specificationButton; // ���� ���� ���� �Է� ��ư
	private JTextField project_codeTextField; // ���� ���α׷� �ڵ�
	private JButton update_project_codeButton; // ���� ���α׷� �ڵ� ���� �Է� ��ư
	private JTextField final_reportTextField; // ���� ����
	private JButton update_final_reportButton; // ���� ���� ���� �Է� ��ư
	private JTextField queryTextField; // �̸����� �˻��Ҷ� �˻��� �̸��� �ִ� ����
	private JButton queryButton; // �̸����� �˻��ϴ� ��ư
	private JButton update_allButton; // �Ѳ����� ��� ������ �Է��Ҷ� ���� ��ư 
	

	public Gui_Score_Input() {
		super("���� �Է�");

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
		update_attendanceButton = new JButton("���");
		lateTextField = new JTextField(10);
		update_lateButton = new JButton("���");
		absentTextField = new JTextField(10);
		update_absentButton = new JButton("���");
		midtermTextField = new JTextField(10);
		update_midtermButton = new JButton("���");
		finalTextField = new JTextField(10);
		update_finalButton = new JButton("���");
		presentationTextField = new JTextField(10);
		update_presentationButton = new JButton("���");
		project_proposalTextField = new JTextField(10);
		update_project_proposalButton = new JButton("���");
		requirement_specificationTextField = new JTextField(10);
		update_requirement_specificationButton = new JButton("���");
		gui_planTextField = new JTextField(10);
		update_gui_planButton = new JButton("���");
		design_specificationTextField = new JTextField(10);
		update_design_specificationButton = new JButton("���");
		project_codeTextField = new JTextField(10);
		update_project_codeButton = new JButton("���");
		final_reportTextField = new JTextField(10);
		update_final_reportButton = new JButton("���");
		queryTextField = new JTextField(10);
		queryButton = new JButton("�˻�");
		browseButton = new JButton("��� �л� �˻�");
		update_allButton = new JButton("��� ���� ���");

		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		this.setSize(800, 600); 
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

		
		displayPanel.setLayout(new GridLayout(14, 3, 4, 4));
		
		displayPanel.add(new JLabel("�л� ID:"));
		idTextField.setEnabled(false);
		displayPanel.add(idTextField);
		displayPanel.add(new JLabel());

		displayPanel.add(new JLabel("�̸�:"));
		nameTextField.setEnabled(false);
		displayPanel.add(nameTextField);
		displayPanel.add(new JLabel());

		displayPanel.add(new JLabel("�⼮ Ƚ��(��ȸ���� ���ڷ� �Է� (������ 32)):"));
		displayPanel.add(attendanceTextField);
		update_attendanceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				update_attendanceButtonActonPerformed(evt);
			}
		});
		displayPanel.add(update_attendanceButton);
		
		displayPanel.add(new JLabel("���� Ƚ��(��ȸ���� ���ڷ� �Է�):"));
		displayPanel.add(lateTextField);
		update_lateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				update_lateButtonActonPerformed(evt);
			}
		});
		displayPanel.add(update_lateButton);
		
		displayPanel.add(new JLabel("�Ἦ Ƚ��(��ȸ���� ���ڷ� �Է�):"));
		displayPanel.add(absentTextField);
		update_absentButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				update_absentButtonActonPerformed(evt);
			}
		});
		displayPanel.add(update_absentButton);
		
		displayPanel.add(new JLabel("�߰���� ����(100�� �������� �Է�):"));
		displayPanel.add(midtermTextField);
		update_midtermButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				update_midtermButtonActonPerformed(evt);
			}
		});
		displayPanel.add(update_midtermButton);
		
		displayPanel.add(new JLabel("�⸻��� ����(100�� �������� �Է�):"));
		displayPanel.add(finalTextField);
		update_finalButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				update_finalButtonActonPerformed(evt);
			}
		});
		displayPanel.add(update_finalButton);
		
		displayPanel.add(new JLabel("��ǥ ����(100�� �������� �Է�):"));
		displayPanel.add(presentationTextField);
		update_presentationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				update_presentationButtonActonPerformed(evt);
			}
		});
		displayPanel.add(update_presentationButton);
		
		displayPanel.add(new JLabel("������Ʈ ���ȼ� ����(100�� �������� �Է�):"));
		displayPanel.add(project_proposalTextField);
		update_project_proposalButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				update_project_proposalButtonActonPerformed(evt);
			}
		});
		displayPanel.add(update_project_proposalButton);
		
		displayPanel.add(new JLabel("�䱸���� ���� ����(100�� �������� �Է�):"));
		displayPanel.add(requirement_specificationTextField);
		update_requirement_specificationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				update_requirement_specificationButtonActonPerformed(evt);
			}
		});
		displayPanel.add(update_requirement_specificationButton);
		
		displayPanel.add(new JLabel("GUI ��ȹ�� ����(100�� �������� �Է�):"));
		displayPanel.add(gui_planTextField);
		update_gui_planButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				update_gui_planButtonActonPerformed(evt);
			}
		});
		displayPanel.add(update_gui_planButton);
		
		displayPanel.add(new JLabel("���� ���� ����(100�� �������� �Է�):"));
		displayPanel.add(design_specificationTextField);
		update_design_specificationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				update_design_specificationButtonActonPerformed(evt);
			}
		});
		displayPanel.add(update_design_specificationButton);
		
		displayPanel.add(new JLabel("���� ���α׷� ����(100�� �������� �Է�):"));
		displayPanel.add(project_codeTextField);
		update_project_codeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				update_project_codeButtonActonPerformed(evt);
			}
		});
		displayPanel.add(update_project_codeButton);
		
		displayPanel.add(new JLabel("���� ���� ����(100�� �������� �Է�):"));
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

		// ��� ������ �ѹ��� ������Ʈ �ϴ� ��ư�� �̺�Ʈ�� ����մϴ�.
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
			JOptionPane.showMessageDialog(this, "���� ��� ����!", "���� ���", JOptionPane.PLAIN_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "������ ��ϵ��� �ʾҽ��ϴ�!", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
	}

	private void update_project_codeButtonActonPerformed(ActionEvent evt) {
		int result = studentsQueries.UpdateProject_code(nameTextField.getText(), Integer.parseInt(project_codeTextField.getText()));

		if(result == 1) {
			JOptionPane.showMessageDialog(this, "���� ��� ����!", "���� ���", JOptionPane.PLAIN_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "������ ��ϵ��� �ʾҽ��ϴ�!", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
	}

	private void update_design_specificationButtonActonPerformed(ActionEvent evt) {
		int result = studentsQueries.UpdateDesign_specification(nameTextField.getText(), Integer.parseInt(design_specificationTextField.getText()));

		if(result == 1) {
			JOptionPane.showMessageDialog(this, "���� ��� ����!", "���� ���", JOptionPane.PLAIN_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "������ ��ϵ��� �ʾҽ��ϴ�!", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
	}

	private void update_gui_planButtonActonPerformed(ActionEvent evt) {
		int result = studentsQueries.UpdateGui_plan(nameTextField.getText(), Integer.parseInt(gui_planTextField.getText()));

		if(result == 1) {
			JOptionPane.showMessageDialog(this, "���� ��� ����!", "���� ���", JOptionPane.PLAIN_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "������ ��ϵ��� �ʾҽ��ϴ�!", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
	}

	private void update_requirement_specificationButtonActonPerformed(ActionEvent evt) {
		int result = studentsQueries.UpdateRequirement_specification(nameTextField.getText(), Integer.parseInt(requirement_specificationTextField.getText()));

		if(result == 1) {
			JOptionPane.showMessageDialog(this, "���� ��� ����!", "���� ���", JOptionPane.PLAIN_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "������ ��ϵ��� �ʾҽ��ϴ�!", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
	}

	private void update_project_proposalButtonActonPerformed(ActionEvent evt) {
		int result = studentsQueries.UpdateProject_proposal(nameTextField.getText(), Integer.parseInt(project_proposalTextField.getText()));

		if(result == 1) {
			JOptionPane.showMessageDialog(this, "���� ��� ����!", "���� ���", JOptionPane.PLAIN_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "������ ��ϵ��� �ʾҽ��ϴ�!", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
	}

	private void update_presentationButtonActonPerformed(ActionEvent evt) {
		int result = studentsQueries.UpdatePresentation(nameTextField.getText(), Integer.parseInt(presentationTextField.getText()));

		if(result == 1) {
			JOptionPane.showMessageDialog(this, "���� ��� ����!", "���� ���", JOptionPane.PLAIN_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "������ ��ϵ��� �ʾҽ��ϴ�!", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
	}

	private void update_finalButtonActonPerformed(ActionEvent evt) {
		int result = studentsQueries.UpdateFinal(nameTextField.getText(), Integer.parseInt(finalTextField.getText()));

		if(result == 1) {
			JOptionPane.showMessageDialog(this, "���� ��� ����!", "���� ���", JOptionPane.PLAIN_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "������ ��ϵ��� �ʾҽ��ϴ�!", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
	}

	private void update_midtermButtonActonPerformed(ActionEvent evt) {
		int result = studentsQueries.UpdateMidterm(nameTextField.getText(), Integer.parseInt(midtermTextField.getText()));

		if(result == 1) {
			JOptionPane.showMessageDialog(this, "���� ��� ����!", "���� ���", JOptionPane.PLAIN_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "������ ��ϵ��� �ʾҽ��ϴ�!", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
	}

	private void update_absentButtonActonPerformed(ActionEvent evt) {
		int result = studentsQueries.UpdateAbsent(nameTextField.getText(), Integer.parseInt(absentTextField.getText()));

		if(result == 1) {
			JOptionPane.showMessageDialog(this, "���� ��� ����!", "���� ���", JOptionPane.PLAIN_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "������ ��ϵ��� �ʾҽ��ϴ�!", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
	}

	private void update_lateButtonActonPerformed(ActionEvent evt) {
		int result = studentsQueries.UpdateLate(nameTextField.getText(), Integer.parseInt(lateTextField.getText()));

		if(result == 1) {
			JOptionPane.showMessageDialog(this, "���� ��� ����!", "���� ���", JOptionPane.PLAIN_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "������ ��ϵ��� �ʾҽ��ϴ�!", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
	}

	private void update_attendanceButtonActonPerformed(ActionEvent evt) {
		int result = studentsQueries.UpdateAttendance(nameTextField.getText(), Integer.parseInt(attendanceTextField.getText()));

		if(result == 1) {
			JOptionPane.showMessageDialog(this, "���� ��� ����!", "���� ���", JOptionPane.PLAIN_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "������ ��ϵ��� �ʾҽ��ϴ�!", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
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
			JOptionPane.showMessageDialog(this, "������ ��ϵǾ����ϴ�!", "���� ���", JOptionPane.PLAIN_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "������ ��ϵ��� �ʾҽ��ϴ�!", "Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
	}

}
