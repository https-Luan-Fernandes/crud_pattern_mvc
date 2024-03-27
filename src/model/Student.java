package model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import dao.StudentDAOInterface;

public class Student {
	
	private String name;
	private String enrollment;
	private String email;
	private String password;
	private StudentDAOInterface studentDAO;

	public Student(StudentDAOInterface studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if(name != null && name != "") {
			this.name = name;
		}
	}

	public String getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(String enrollment) {
		if(enrollment != null && enrollment != "") {
			this.enrollment = enrollment;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(email != null && email != "") {
			this.email = email;
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if(password != null && password != "") {
			this.password = password;
		}
	}
	
	public StudentDAOInterface getStudentDAOInterface() {
		return studentDAO;
	}
	
	public boolean isRegistrationInformationValid(StudentDTO studentDTO) {
	    return studentDTO.getName() != null && !studentDTO.getName().isEmpty() &&
	           studentDTO.getEnrollment() != null && !studentDTO.getEnrollment().isEmpty() &&
	           studentDTO.getEmail() != null && !studentDTO.getEmail().isEmpty() &&
	           studentDTO.getPassword() != null && !studentDTO.getPassword().isEmpty();
	}
	
	public boolean registerStudent(StudentDTO studentDTO) {
		if(isRegistrationInformationValid(studentDTO)) {
			if(studentDAO != null) {
				try {
					return studentDAO.registerStudent(studentDTO);	
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	public void updateModel(StudentDTO studentDTO) {
		setName(studentDTO.getName());
		setEnrollment(studentDTO.getEnrollment());
		setEmail(studentDTO.getEmail());
		setPassword(studentDTO.getPassword());
	}
	
	public void updateStudent(StudentDTO studentDTO) {
		if(isRegistrationInformationValid(studentDTO)) {
			updateModel(studentDTO);
			try {
				studentDAO.updateStudent(studentDTO);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "Informações inválidas");
		}
	}
	
	public boolean isAuthenticated(StudentDTO studentDTO) {
		return enrollment.equals( studentDTO.getEnrollment() ) && password.equals( studentDTO.getPassword());
	}
	
	public boolean isEnrollmentPasswordValid(StudentDTO studentDTO) {
		return studentDTO.getEnrollment() != null && !studentDTO.getEnrollment().isEmpty() &&
			    studentDTO.getPassword() != null && !studentDTO.getPassword().isEmpty();
	}
	
	public boolean isLoginInformationEqual(StudentDTO studentDTO, StudentDTO recoveredStudentDTO) {
		return recoveredStudentDTO.getEnrollment().equals(studentDTO.getEnrollment()) &&
				recoveredStudentDTO.getPassword().equals(studentDTO.getPassword());
	}
	
	public boolean isStudentRegistered(StudentDTO studentDTO) {
		try {
			if(isEnrollmentPasswordValid(studentDTO)) {
				StudentDTO recoveredStudentDTO = studentDAO.recoverStudent(studentDTO);
				if(recoveredStudentDTO != null && isLoginInformationEqual(studentDTO, recoveredStudentDTO)) {
					updateModel(recoveredStudentDTO);
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public StudentDTO recoverStudent(StudentDTO studentDTO) {
		try {
			StudentDTO recoveredStudent = studentDAO.recoverStudent(studentDTO);
			return recoveredStudent;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteAccount(StudentDTO studentDTO) {
		if(isAuthenticated(studentDTO)) {
			try {
				return studentDAO.deleteStudent(studentDTO);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
