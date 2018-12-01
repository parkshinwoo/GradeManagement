package EventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MenuItemDisplay.Average_Total_Score_Look_Up;
import MenuItemDisplay.Grant_Grade;

public class StatisticsActionListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		// �޴� �������� ������ ���� ó���ϱ� ���� ����ġ��
		switch(cmd) {
		case "���� �ο�":
			new Grant_Grade();
			break;
		case "�л� ���� ��� Ȯ��":
			new Average_Total_Score_Look_Up();
			break;
		case "���� ���� �׷��� Ȯ��":
			System.out.println("���� ���� �׷��� Ȯ��");
			break;
		}

	}
}
