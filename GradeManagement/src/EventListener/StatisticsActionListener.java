package EventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MenuItemDisplay.Average_Total_Score_Look_Up;
import MenuItemDisplay.Grant_Grade;

public class StatisticsActionListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		// 메뉴 아이템의 종류에 따라 처리하기 위한 스위치문
		switch(cmd) {
		case "학점 부여":
			new Grant_Grade();
			break;
		case "학생 총점 평균 확인":
			new Average_Total_Score_Look_Up();
			break;
		case "점수 분포 그래프 확인":
			System.out.println("점수 분포 그래프 확인");
			break;
		}

	}
}
