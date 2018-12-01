import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import EventListener.GradeResultActionListener;
import EventListener.InputActionListener;
import EventListener.SettingActionListener;
import EventListener.StatisticsActionListener;

public class Menu extends JFrame{

	Menu(){
		this.setTitle("성적 관리 프로그램");
		this. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createMenu(); // 메뉴바를 구성합니다.
		
		this.setLocationRelativeTo(null);
		this.setSize(400, 300);
		this.setVisible(true);
	}
	
	void createMenu() {
		
		JMenuBar menuBar = new JMenuBar();
		
		
		/*
		 * 성적 입력 메뉴입니다.
		 * 출결, 성적을 입력하기 위한 메뉴입니다.
		 * 점수 입력은 GUI를 통해 사용자가 직접 입력하는 방식, CSV를 통해 입력하는 방식 두가지 입니다.
		 * 출결은 출석, 지각, 결석 세 항목의 각 횟수를 입력합니다.(한 학기 기준 수업은 총 32회 지각, 결석 항목을 통해 출결 점수 산출)
	     * 나머지 점수는 int 형태로 100점 만점의 기준에 맞춰 입력을 합니다. 
		 */
		JMenu input = new JMenu("성적 입력");
		// EventListener package에 구현합니다.
		InputActionListener listener_input = new InputActionListener(); // 성적 입력 관련 이벤트 리스너입니다.
		
		JMenuItem gui_input = new JMenuItem("점수 입력");
		JMenuItem csv_input = new JMenuItem("파일로 점수 입력");
		
		gui_input.addActionListener(listener_input); // 메뉴 아이템에 이벤트 리스너 추가
		csv_input.addActionListener(listener_input);
		
		input.add(gui_input);
		input.add(csv_input);

		menuBar.add(input);

		/*
		 * 설정 메뉴입니다.
		 * 성적 등급 반영 비율을 설정합니다. (A+ 15%, B+ 60% 등)
		 */
		JMenu setting = new JMenu("설정");
		SettingActionListener listener_setting = new SettingActionListener();
		
		JMenuItem grade_rate = new JMenuItem("성적 등급 반영 비율 설정");
		
		grade_rate.addActionListener(listener_setting); // 메뉴 아이템에 이벤트 리스너 추가
		
		setting.add(grade_rate);
		
		menuBar.add(setting);
		
		/*
		 * 통계 메뉴입니다.
		 * 1. 학생에게 학점을 부여하는 학점 부여 
		 * 2. 학생들의 총점의 평균을 계산
		 * 3. 점수 요소 중 한가지를 선택해서 점수 분포에 대한 그래프 그리기
		 * 위 세가지 기능으로 구성됩니다.
		 */
		JMenu statistics = new JMenu("통계");
		StatisticsActionListener listener_statistics = new StatisticsActionListener();
		
		JMenuItem grant_grade = new JMenuItem("학점 부여");
		JMenuItem average_score = new JMenuItem("학생 총점 평균 확인");
		JMenuItem graph_score = new JMenuItem("점수 분포 그래프 확인");
		
		grant_grade.addActionListener(listener_statistics); // 메뉴 아이템에 이벤트 리스너 추가
		average_score.addActionListener(listener_statistics); 
		graph_score.addActionListener(listener_statistics);
		
		statistics.add(grant_grade);
		statistics.add(average_score);
		statistics.add(graph_score);
		
		menuBar.add(statistics);
		
		/*
		 * 성적 확인 메뉴입니다.
		 * 1. GUI 화면으로 성적을 확인
		 * 2. CSV 파일로 성적 출력
		 * 위 두가지 기능으로 구성됩니다.
		 */
		JMenu grade_result = new JMenu("성적 확인");
		GradeResultActionListener listener_grade_result = new GradeResultActionListener();
		
		JMenuItem grade_lookup = new JMenuItem("성적 조회");
		JMenuItem grade_into_file = new JMenuItem("성적 결과 CSV 파일로 내보내기");
		
		grade_lookup.addActionListener(listener_grade_result); // 메뉴 아이템에 이벤트 리스너 추가
		grade_into_file.addActionListener(listener_grade_result);
		
		grade_result.add(grade_lookup);
		grade_result.add(grade_into_file);
		
		menuBar.add(grade_result);
		
		// 메뉴바를 프레임에 부착합니다.
		this.setJMenuBar(menuBar); 
	}
	
	
	public static void main(String[] args) {
		new Menu();
	}

}
