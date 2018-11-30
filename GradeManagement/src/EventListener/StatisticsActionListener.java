package EventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatisticsActionListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		// 메뉴 아이템의 종류에 따라 처리하기 위한 스위치문
		switch(cmd) {
		case "학점 부여":
			System.out.println("학점 부여");
			break;
		case "학생 총점 평균 확인":
			System.out.println("학생 총점 평균 확인");
			break;
		case "점수 분포 그래프 확인":
			System.out.println("점수 분포 그래프 확인");
			break;
		}

	}
}
