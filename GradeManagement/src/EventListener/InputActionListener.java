package EventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MenuItemDisplay.Gui_Score_Input;

public class InputActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		// �޴� �������� ������ ���� ó���ϱ� ���� ����ġ��
		switch(cmd) {
		case "���� �Է�":
			new Gui_Score_Input();
			break;
		case "���Ϸ� ���� �Է�":
			System.out.println("���Ϸ� ���� �Է�");
			break;
		}
		
	}
}
