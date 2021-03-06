package EventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MenuItemDisplay.CSV_Output;
import MenuItemDisplay.Gui_Grade_Look_Up;

public class GradeResultActionListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		// 메뉴 아이템의 종류에 따라 처리하기 위한 스위치문
		switch(cmd) {
		case "성적 조회":
			new Gui_Grade_Look_Up();
			break;
		case "성적 결과 CSV 파일로 내보내기":
			new CSV_Output();
			break;
		}
	}
}
