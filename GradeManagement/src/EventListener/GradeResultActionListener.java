package EventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MenuItemDisplay.CSV_Output;
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
		case "���� ��� CSV ���Ϸ� ��������":
			new CSV_Output();
			break;
		}
	}
}
