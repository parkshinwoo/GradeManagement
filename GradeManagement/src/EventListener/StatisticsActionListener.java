package EventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatisticsActionListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		// �޴� �������� ������ ���� ó���ϱ� ���� ����ġ��
		switch(cmd) {
		case "���� �ο�":
			System.out.println("���� �ο�");
			break;
		case "�л� ���� ��� Ȯ��":
			System.out.println("�л� ���� ��� Ȯ��");
			break;
		case "���� ���� �׷��� Ȯ��":
			System.out.println("���� ���� �׷��� Ȯ��");
			break;
		}

	}
}
