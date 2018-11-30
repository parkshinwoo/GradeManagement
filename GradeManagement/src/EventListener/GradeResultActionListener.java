package EventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeResultActionListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		// 메뉴 아이템의 종류에 따라 처리하기 위한 스위치문
		switch(cmd) {
		case "성적 조회":
			System.out.println("성적 조회");
			break;
		case "성적 결과 파일로 내보내기":
			System.out.println("성적 결과 파일로 내보내기");
			break;
		}
	}
}
