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
	
	private JTextField attendanceTextField; // �⼮
	private JTextField midtermTextField; // �߰����
	private JTextField finalTextField; // �⸻���
	private JTextField presentationTextField; // ��ǥ
	private JTextField project_proposalTextField; // ������Ʈ ���ȼ�
	private JTextField requirement_specificationTextField; // �䱸���� ����
	private JTextField gui_planTextField; // gui ��ȹ��
	private JTextField design_specificationTextField; // ���� ����
	private JTextField project_codeTextField; // ���� ���α׷� �ڵ�
	private JTextField final_reportTextField; // ���� ����
	private JTextField a_plusTextField;
	private JTextField a_zeroTextField;
	private JTextField b_plusTextField;
	private JTextField b_zeroTextField;
	private JTextField c_plusTextField;
	private JTextField c_zeroTextField;
	private JTextField fTextField;
	
	private JButton grant_gradeButton; // ������ �ο��ϴ� �̺�Ʈ�� �߻���Ű�� ��ư
	
	public Grant_Grade() {
		super("���� �ο�");

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
		
		browseButton = new JButton("���� ��� ���� ��ȸ");
		grant_gradeButton = new JButton("���� �ο�");

		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		this.setSize(500, 570); 
		this.setResizable(false); 
		                                                    
		displayPanel.setLayout(new GridLayout(18, 2, 4, 4));
		
		displayPanel.add(new JLabel("�⼮ �ݿ� ����:"));
		displayPanel.add(new JLabel("10%"));
		
		displayPanel.add(new JLabel("�߰���� �ݿ� ����:"));
		displayPanel.add(new JLabel("15%"));
		
		displayPanel.add(new JLabel("�⸻��� �ݿ� ����:"));
		displayPanel.add(new JLabel("15%"));
		
		displayPanel.add(new JLabel("������Ʈ �ݿ� ����:"));
		displayPanel.add(new JLabel("60%"));
		
		displayPanel.add(new JLabel("��ǥ �ݿ� ����:"));
		displayPanel.add(new JLabel("10% (of 60%)"));
		
		displayPanel.add(new JLabel("������Ʈ ���ȼ� �ݿ� ����:"));
		displayPanel.add(new JLabel("10% (of 60%)"));
		
		displayPanel.add(new JLabel("�䱸���� ���� �ݿ� ����:"));
		displayPanel.add(new JLabel("15% (of 60%)"));
		
		displayPanel.add(new JLabel("GUI ��ȹ�� �ݿ� ����:"));
		displayPanel.add(new JLabel("15% (of 60%)"));
		
		displayPanel.add(new JLabel("������� �ݿ� ����:"));
		displayPanel.add(new JLabel("20% (of 60%)"));
		
		displayPanel.add(new JLabel("���� ���α׷� �ڵ� �ݿ� ����:"));
		displayPanel.add(new JLabel("20% (of 60%)"));
		
		displayPanel.add(new JLabel("���� ���� �ݿ� ����:"));
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
		
		average_total_score = studentsQueries.computeTotalScore(); // ��ü ������ ����մϴ�.
		studentsQueries.grantGrade(); // ������ �ο��մϴ�.
			
		JOptionPane.showMessageDialog(this, "��ü �л� ������ ���:"+average_total_score, "���� �ο� �Ϸ�!", JOptionPane.PLAIN_MESSAGE);
	
		browseButtonActionPerformed(evt);
	}

}
