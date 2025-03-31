package bap.jp.b2;

public class Student {
    private String name;
    private String studentId;
    private double point;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getStudentId() {
	return studentId;
    }

    public void setStudentId(String studentId) {
	this.studentId = studentId;
    }

    public double getPoint() {
	return point;
    }

    public void setPoint(double point) {
	this.point = point;
    }

    public Student(String studentId, String name, double point) {
	this.name = name;
	this.studentId = studentId;
	this.point = point;
    }

    @Override
    public String toString() {
	return 	"Tên :" + name +
		", Mã Sinh viên : " + studentId +
		", Điểm : " + point +
		'.';
    }
}
