package dao;

import java.sql.SQLException;

import model.StudentDTO;

public interface StudentDAOInterface {
	boolean registerStudent(StudentDTO studentDTO) throws SQLException;  //Create
	StudentDTO recoverStudent(StudentDTO studentDTO) throws SQLException; //Read
	void updateStudent(StudentDTO studentDTO) throws SQLException; //Update
	boolean deleteStudent(StudentDTO studentDTO) throws SQLException; //Delete
}
