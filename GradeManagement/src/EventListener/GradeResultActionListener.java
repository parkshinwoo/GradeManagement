package EventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeResultActionListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		// �޴� �������� ������ ���� ó���ϱ� ���� ����ġ��
		switch(cmd) {
		case "���� ��ȸ":
			System.out.println("���� ��ȸ");
			break;
		case "���� ��� ���Ϸ� ��������":
			System.out.println("���� ��� ���Ϸ� ��������");
			break;
		}
	}
}
