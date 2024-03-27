package view;

import java.awt.EventQueue;

import controller.StudentController;
import dao.StudentDAO;
import dao.MySQLConnector;
import model.Student;

public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 new LoginView(
							 new StudentController(
									 new Student(
											 new StudentDAO(
													 new MySQLConnector()
					 								)
											)
									)
							);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
