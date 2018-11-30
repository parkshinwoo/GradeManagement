package DataModel;

public class Students {
	private int StudentID; // 학생 ID 
	private String Student_name; // 학생 이름
	private int Attendance; // 출석 횟수
	private int Late; // 지각 횟수
	private int Absent; // 결석 횟수
	private int Midterm; // 중간고사 점수
	private int Final; // 기말고사 점수
	private int Presentation; // 발표 점수
	private int Project_proposal; // 프로젝트 제안서
	private int Requirement_specification; // 요구사항 명세서
	private int Gui_plan; // GUI 계획서
	private int Design_specification; // 설계 명세서 
	private int Project_code; // 최종 프로그램 코드
	private int Final_report; // 최종 보고서
	
	public Students() {
		
	}
	
	public Students(int StudentID, String Student_name, int Attendance, int Late, int Absent,
			int Midterm, int Final, int Presentation, int Project_proposal,
			int Requirement_specification, int Gui_plan, int Design_specification, int Project_code, int Final_report) {
		setStudentID(StudentID);
		setStudent_name(Student_name);
		setAttendance(Attendance);
		setLate(Late);
		setAbsent(Absent);
		setMidterm(Midterm);
		setFinal(Final);
		setPresentation(Presentation);
		setProject_proposal(Project_proposal);
		setRequirement_specification(Requirement_specification);
		setGui_plan(Gui_plan);
		setDesign_specification(Design_specification);
		setProject_code(Project_code);
		setFinal_report(Final_report);
	}

	public int getStudentID() {
		return StudentID;
	}

	public void setStudentID(int StudentID) {
		this.StudentID = StudentID;
	}

	public String getStudent_name() {
		return Student_name;
	}

	public void setStudent_name(String Student_name) {
		this.Student_name = Student_name;
	}

	public int getAttendance() {
		return Attendance;
	}

	public void setAttendance(int Attendance) {
		this.Attendance = Attendance;
	}

	public int getLate() {
		return Late;
	}

	public void setLate(int Late) {
		this.Late = Late;
	}

	public int getAbsent() {
		return Absent;
	}

	public void setAbsent(int Absent) {
		this.Absent = Absent;
	}

	public int getMidterm() {
		return Midterm;
	}

	public void setMidterm(int Midterm) {
		this.Midterm = Midterm;
	}

	public int getFinal() {
		return Final;
	}

	public void setFinal(int Final) {
		this.Final = Final;
	}

	public int getPresentation() {
		return Presentation;
	}

	public void setPresentation(int Presentation) {
		this.Presentation = Presentation;
	}

	public int getProject_proposal() {
		return Project_proposal;
	}

	public void setProject_proposal(int Project_proposal) {
		this.Project_proposal = Project_proposal;
	}

	public int getRequirement_specification() {
		return Requirement_specification;
	}

	public void setRequirement_specification(int Requirement_specification) {
		this.Requirement_specification = Requirement_specification;
	}

	public int getGui_plan() {
		return Gui_plan;
	}

	public void setGui_plan(int Gui_plan) {
		this.Gui_plan = Gui_plan;
	}

	public int getDesign_specification() {
		return Design_specification;
	}

	public void setDesign_specification(int Design_specification) {
		this.Design_specification = Design_specification;
	}

	public int getProject_code() {
		return Project_code;
	}

	public void setProject_code(int Project_code) {
		this.Project_code = Project_code;
	}

	public int getFinal_report() {
		return Final_report;
	}

	public void setFinal_report(int Final_report) {
		this.Final_report = Final_report;
	}
	
}
