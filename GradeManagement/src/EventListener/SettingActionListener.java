package EventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MenuItemDisplay.Set_Grade_Ratio;

public class SettingActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		// �޴� �������� ������ ���� ó���ϱ� ���� ����ġ��
		switch(cmd) {
		case "���� ��� �ݿ� ���� ����":
			new Set_Grade_Ratio();
			break;		
		}
	}
}
