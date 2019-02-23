package trng.reflection;

public class Student {
	Integer studentNo;
	String studentName;
	public Integer getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(Integer studentNo) {
		this.studentNo = studentNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	@Override
	public String toString() {
		return "Student [studentNo=" + studentNo + ", studentName="
				+ studentName + "]";
	}
}
