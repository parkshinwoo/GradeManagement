package EventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MenuItemDisplay.Set_Grade_Ratio;

public class SettingActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		// 메뉴 아이템의 종류에 따라 처리하기 위한 스위치문
		switch(cmd) {
		case "성적 등급 반영 비율 설정":
			new Set_Grade_Ratio();
			break;		
		}
	}
}
