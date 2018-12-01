package DataModel;

public class Grade_Ratio {
	private String Grade;
	private int A_plus;
	private int A_zero;
	private int B_plus;
	private int B_zero;
	private int C_plus;
	private int C_zero;
	private int F;
	
	public Grade_Ratio() {
		
	}
	
	public Grade_Ratio(String Grade, int A_plus, int A_zero, int B_plus, int B_zero, int C_plus, int C_zero, int F) {
		setGrade(Grade);
		setA_plus(A_plus);
		setA_zero(A_zero);
		setB_plus(B_plus);
		setB_zero(B_zero);
		setC_plus(C_plus);
		setC_zero(C_zero);
		setF(F);
	}

	public String getGrade() {
		return Grade;
	}

	public void setGrade(String grade) {
		Grade = grade;
	}

	public int getA_plus() {
		return A_plus;
	}

	public void setA_plus(int a_plus) {
		A_plus = a_plus;
	}

	public int getA_zero() {
		return A_zero;
	}

	public void setA_zero(int a_zero) {
		A_zero = a_zero;
	}

	public int getB_plus() {
		return B_plus;
	}

	public void setB_plus(int b_plus) {
		B_plus = b_plus;
	}

	public int getB_zero() {
		return B_zero;
	}

	public void setB_zero(int b_zero) {
		B_zero = b_zero;
	}

	public int getC_plus() {
		return C_plus;
	}

	public void setC_plus(int c_plus) {
		C_plus = c_plus;
	}

	public int getC_zero() {
		return C_zero;
	}

	public void setC_zero(int c_zero) {
		C_zero = c_zero;
	}

	public int getF() {
		return F;
	}

	public void setF(int f) {
		F = f;
	}
	
	

}
