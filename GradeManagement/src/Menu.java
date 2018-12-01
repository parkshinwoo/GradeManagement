import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import EventListener.GradeResultActionListener;
import EventListener.InputActionListener;
import EventListener.SettingActionListener;
import EventListener.StatisticsActionListener;

public class Menu extends JFrame{

	Menu(){
		this.setTitle("���� ���� ���α׷�");
		this. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createMenu(); // �޴��ٸ� �����մϴ�.
		
		this.setLocationRelativeTo(null);
		this.setSize(400, 300);
		this.setVisible(true);
	}
	
	void createMenu() {
		
		JMenuBar menuBar = new JMenuBar();
		
		
		/*
		 * ���� �Է� �޴��Դϴ�.
		 * ���, ������ �Է��ϱ� ���� �޴��Դϴ�.
		 * ���� �Է��� GUI�� ���� ����ڰ� ���� �Է��ϴ� ���, CSV�� ���� �Է��ϴ� ��� �ΰ��� �Դϴ�.
		 * ����� �⼮, ����, �Ἦ �� �׸��� �� Ƚ���� �Է��մϴ�.(�� �б� ���� ������ �� 32ȸ ����, �Ἦ �׸��� ���� ��� ���� ����)
	     * ������ ������ int ���·� 100�� ������ ���ؿ� ���� �Է��� �մϴ�. 
		 */
		JMenu input = new JMenu("���� �Է�");
		// EventListener package�� �����մϴ�.
		InputActionListener listener_input = new InputActionListener(); // ���� �Է� ���� �̺�Ʈ �������Դϴ�.
		
		JMenuItem gui_input = new JMenuItem("���� �Է�");
		JMenuItem csv_input = new JMenuItem("���Ϸ� ���� �Է�");
		
		gui_input.addActionListener(listener_input); // �޴� �����ۿ� �̺�Ʈ ������ �߰�
		csv_input.addActionListener(listener_input);
		
		input.add(gui_input);
		input.add(csv_input);

		menuBar.add(input);

		/*
		 * ���� �޴��Դϴ�.
		 * ���� ��� �ݿ� ������ �����մϴ�. (A+ 15%, B+ 60% ��)
		 */
		JMenu setting = new JMenu("����");
		SettingActionListener listener_setting = new SettingActionListener();
		
		JMenuItem grade_rate = new JMenuItem("���� ��� �ݿ� ���� ����");
		
		grade_rate.addActionListener(listener_setting); // �޴� �����ۿ� �̺�Ʈ ������ �߰�
		
		setting.add(grade_rate);
		
		menuBar.add(setting);
		
		/*
		 * ��� �޴��Դϴ�.
		 * 1. �л����� ������ �ο��ϴ� ���� �ο� 
		 * 2. �л����� ������ ����� ���
		 * 3. ���� ��� �� �Ѱ����� �����ؼ� ���� ������ ���� �׷��� �׸���
		 * �� ������ ������� �����˴ϴ�.
		 */
		JMenu statistics = new JMenu("���");
		StatisticsActionListener listener_statistics = new StatisticsActionListener();
		
		JMenuItem grant_grade = new JMenuItem("���� �ο�");
		JMenuItem average_score = new JMenuItem("�л� ���� ��� Ȯ��");
		JMenuItem graph_score = new JMenuItem("���� ���� �׷��� Ȯ��");
		
		grant_grade.addActionListener(listener_statistics); // �޴� �����ۿ� �̺�Ʈ ������ �߰�
		average_score.addActionListener(listener_statistics); 
		graph_score.addActionListener(listener_statistics);
		
		statistics.add(grant_grade);
		statistics.add(average_score);
		statistics.add(graph_score);
		
		menuBar.add(statistics);
		
		/*
		 * ���� Ȯ�� �޴��Դϴ�.
		 * 1. GUI ȭ������ ������ Ȯ��
		 * 2. CSV ���Ϸ� ���� ���
		 * �� �ΰ��� ������� �����˴ϴ�.
		 */
		JMenu grade_result = new JMenu("���� Ȯ��");
		GradeResultActionListener listener_grade_result = new GradeResultActionListener();
		
		JMenuItem grade_lookup = new JMenuItem("���� ��ȸ");
		JMenuItem grade_into_file = new JMenuItem("���� ��� CSV ���Ϸ� ��������");
		
		grade_lookup.addActionListener(listener_grade_result); // �޴� �����ۿ� �̺�Ʈ ������ �߰�
		grade_into_file.addActionListener(listener_grade_result);
		
		grade_result.add(grade_lookup);
		grade_result.add(grade_into_file);
		
		menuBar.add(grade_result);
		
		// �޴��ٸ� �����ӿ� �����մϴ�.
		this.setJMenuBar(menuBar); 
	}
	
	
	public static void main(String[] args) {
		new Menu();
	}

}
