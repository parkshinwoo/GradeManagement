package EventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MenuItemDisplay.Gui_Score_Input;

public class InputActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		// 메뉴 아이템의 종류에 따라 처리하기 위한 스위치문
		switch(cmd) {
		case "점수 입력":
			new Gui_Score_Input();
			break;
		case "파일로 점수 입력":
			System.out.println("파일로 점수 입력");
			break;
		}
		
	}
}
