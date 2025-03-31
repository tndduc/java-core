package bap.jp.b2;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class B1 {
    private static final String FILE_PATH = "D:\\BAP Project\\Java-core\\src\\main\\java\\bap\\jp\\b2\\data.txt";

    public static void main(String[] args) throws Exception {
	List<Student> students = loadStudentsFromFile();
	Scanner scanner = new Scanner(System.in);

	while (true) {
	    System.out.println("\n===== QUẢN LÝ SINH VIÊN =====");
	    System.out.println("1. Xem danh sách");
	    System.out.println("2. Thêm sinh viên");
	    System.out.println("3. Sửa thông tin sinh viên");
	    System.out.println("4. Xóa sinh viên");
	    System.out.println("5. Thoát");
	    System.out.print("Chọn: ");

	    int choice = scanner.nextInt();
	    scanner.nextLine();

	    switch (choice) {
		case 1:
		    displayStudents(students);
		    break;
		case 2:
		    addStudent(scanner, students);
		    break;
		case 3:
		    updateStudent(scanner, students);
		    break;
		case 4:
		    deleteStudent(scanner, students);
		    break;
		case 5:
		    System.out.println("Thoát chương trình. Tạm biệt!");
		    scanner.close();
		    return;
		default:
		    System.out.println("Lựa chọn không hợp lệ!");
	    }
	}
    }

    private static List<Student> loadStudentsFromFile() throws IOException {
	List<Student> students = new ArrayList<>();
	File file = new File(FILE_PATH);
	if (!file.exists()) return students;

	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	    String line;
	    while ((line = br.readLine()) != null) {
		String[] tokens = line.split(",");
		if (tokens.length == 3) {
		    students.add(new Student(tokens[0].trim(), tokens[1].trim(), Double.parseDouble(tokens[2].trim())));
		}
	    }
	}
	return students;
    }

    private static void displayStudents(List<Student> students) {
	System.out.println("Danh sách sinh viên:");
	for (int i = 0; i < students.size(); i++) {
	    System.out.println((i + 1) + ". " + students.get(i));
	}
    }

    private static void addStudent(Scanner scanner, List<Student> students) {
	System.out.print("Nhập mã sinh viên: ");
	String studentId = scanner.nextLine();

	for (Student student : students) {
	    if (student.getStudentId().equalsIgnoreCase(studentId)) {
		System.out.println("Mã sinh viên đã tồn tại!");
		return;
	    }
	}

	System.out.print("Nhập tên sinh viên: ");
	String studentName = scanner.nextLine();
	System.out.print("Nhập điểm: ");
	double studentPoint = scanner.nextDouble();
	scanner.nextLine();

	students.add(new Student(studentId, studentName, studentPoint));
	saveStudentsToFile(students);
	System.out.println("Thêm thành công!");
    }

    private static void updateStudent(Scanner scanner, List<Student> students) {
	System.out.print("Nhập mã sinh viên cần sửa: ");
	String studentId = scanner.nextLine();

	for (Student student : students) {
	    if (student.getStudentId().equalsIgnoreCase(studentId)) {
		System.out.print("Nhập tên mới: ");
		student.setName(scanner.nextLine());
		System.out.print("Nhập điểm mới: ");
		student.setPoint(scanner.nextDouble());
		scanner.nextLine();
		saveStudentsToFile(students);
		System.out.println("Cập nhật thành công!");
		return;
	    }
	}
	System.out.println("Không tìm thấy sinh viên!");
    }

    private static void deleteStudent(Scanner scanner, List<Student> students) {
	System.out.print("Nhập mã sinh viên cần xóa: ");
	String studentId = scanner.nextLine();

	for (int i = 0; i < students.size(); i++) {
	    if (students.get(i).getStudentId().equalsIgnoreCase(studentId)) {
		students.remove(i);
		saveStudentsToFile(students);
		System.out.println("Xóa thành công!");
		return;
	    }
	}
	System.out.println("Không tìm thấy sinh viên!");
    }

    private static void saveStudentsToFile(List<Student> students) {
	try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
	    for (Student student : students) {
		bw.write(student.getStudentId() + "," + student.getName() + "," + student.getPoint());
		bw.newLine();
	    }
	    System.out.println("Dữ liệu đã cập nhật!");
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}