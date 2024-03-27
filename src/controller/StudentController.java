package controller;

import model.Student;
import model.StudentDTO;

public class StudentController {

	private Student student;
	
	public StudentController(Student student) {
		this.student = student;
	}
	
	public boolean registerStudent(StudentDTO studentDTO) {
		return student.registerStudent(studentDTO);
	}
	
	public boolean isStudentRegistered(StudentDTO studentDTO) {
		return student.isStudentRegistered(studentDTO);
	}
	
	public boolean isAuthenticated(StudentDTO studentDTO) {
		return student.isAuthenticated(studentDTO);
	}
	
	public StudentDTO recoverStudent(StudentDTO studentDTO) {
		return student.recoverStudent(studentDTO);
	}
	
	public boolean deleteAccount(StudentDTO studentDTO) {
		return student.deleteAccount(studentDTO);
	}
	
	public Student getStudent() {
		if(student == null)
			student = new Student(student.getStudentDAOInterface());
		return student;
	}
	
	public void updateStudent(StudentDTO studentDTO) {
		student.updateStudent(studentDTO);
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
