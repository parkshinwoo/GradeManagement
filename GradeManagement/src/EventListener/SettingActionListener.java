package EventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		// �޴� �������� ������ ���� ó���ϱ� ���� ����ġ��
		switch(cmd) {
		case "���� ��� �ݿ� ���� ����":
			System.out.println("���� ��� �ݿ� ���� ����");
			break;		
		}
	}
}
