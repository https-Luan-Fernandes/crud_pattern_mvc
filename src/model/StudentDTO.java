package model;

public class StudentDTO {
	private String name;
	private String enrollment;
	private String email;
	private String password;
	
	public StudentDTO() {}
	
	public StudentDTO(String enrollment, String password) {
		this.enrollment = enrollment;
		this.password = password;
	}
	
	public StudentDTO(String enrollment, String email, String password) {
		this.enrollment = enrollment;
		this.email = email;
		this.password = password;
	}
	
	public StudentDTO(String name, String enrollment, String email, String password) {
		this.name = name;
		this.enrollment = enrollment;
		this.email = email;
		this.password = password;
	}
	
	public String toString() {
		return "Nome: " + name + " Matricula: " + enrollment + " Email: " + email + " Senha: " + password;
	}
	
	/**
	 * @return the nome
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the nome to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the matricula
	 */
	public String getEnrollment() {
		return enrollment;
	}
	/**
	 * @param enrollment the matricula to set
	 */
	public void setEnrollment(String enrollment) {
		this.enrollment = enrollment;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the senha
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the senha to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
