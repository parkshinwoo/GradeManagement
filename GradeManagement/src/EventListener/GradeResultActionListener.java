package EventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MenuItemDisplay.Gui_Grade_Look_Up;

public class GradeResultActionListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		// �޴� �������� ������ ���� ó���ϱ� ���� ����ġ��
		switch(cmd) {
		case "���� ��ȸ":
			new Gui_Grade_Look_Up();
			break;
		case "���� ��� ���Ϸ� ��������":
			System.out.println("���� ��� ���Ϸ� ��������");
			break;
		}
	}
}
