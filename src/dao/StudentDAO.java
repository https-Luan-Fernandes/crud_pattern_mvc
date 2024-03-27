package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.StudentDTO;

public class StudentDAO implements StudentDAOInterface{
	
	private PreparedStatement prst;
	private ResultSet rs;
	private ConnectionInterface conn;
	private String sql;
	
	public StudentDAO(ConnectionInterface conn) {
		this.conn = conn;
	}

	public boolean registerStudent(StudentDTO studentDTO) throws SQLException {
		sql = "insert into aluno(nome,matricula,email,senha) values(?,?,?,?)";
		try {
			prst = conn.getConnection().prepareStatement(sql);
			prst.setString(1, studentDTO.getName());
			prst.setString(2, studentDTO.getEnrollment());
			prst.setString(3, studentDTO.getEmail());
			prst.setString(4, studentDTO.getPassword());
			prst.execute();
			return true;
		}catch(SQLException e){
			return false;
		}finally {
			if(prst != null) {
				prst.close();
			}
			if(conn != null) {
				conn.closeConnection();
			}
		}
	}

	public StudentDTO recoverStudent(StudentDTO studentDTO) throws SQLException {
		sql = "select * from aluno where matricula = ?";
		try {
			prst = conn.getConnection().prepareStatement(sql);
			prst.setString(1, studentDTO.getEnrollment());
			rs = prst.executeQuery();
			if(rs.next()) {
				return studentDTO = new StudentDTO(
						rs.getString("nome"),
						rs.getString("matricula"),
						rs.getString("email"),
						rs.getString("senha")
						);
			}
			return null;
			}catch(SQLException e){
				throw new SQLException("Erro ao recuperar aluno: " + e.getMessage());
				}finally {
					if(prst != null) {
						prst.close();
						}
					if(rs != null) {
						rs.close();
						}
					if(conn != null) {
						conn.closeConnection();
						}
					}
		}
	

	public void updateStudent(StudentDTO studentDTO) throws SQLException {
		updateStudentName(studentDTO);
		updateStudentEmail(studentDTO);
		updateStudentPassword(studentDTO);
	}
	
	private void updateStudentName(StudentDTO studentDTO) {
		sql = "update aluno set nome = ? where matricula = ?";
		try {
			prst = conn.getConnection().prepareStatement(sql);
			prst.setString(1,studentDTO.getName());
			prst.setString(2,studentDTO.getEnrollment());
			prst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(prst != null) {
				try {
					prst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void updateStudentEmail(StudentDTO studentDTO) {
		sql = "update aluno set email = ? where matricula = ?";
		try {
			prst = conn.getConnection().prepareStatement(sql);
			prst.setString(1, studentDTO.getEmail());
			prst.setString(2, studentDTO.getEnrollment());
			prst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(prst != null) {
				try {
					prst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private void updateStudentPassword(StudentDTO studentDTO) {
		sql = "update aluno set senha = ? where matricula = ?";
		try {
			prst = conn.getConnection().prepareStatement(sql);
			prst.setString(1, studentDTO.getPassword());
			prst.setString(2, studentDTO.getEnrollment());
			prst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(prst != null) {
				try {
					prst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public boolean deleteStudent(StudentDTO studentDTO) throws SQLException {
		sql = "delete from aluno where matricula = ?";
		try {
			prst = conn.getConnection().prepareStatement(sql);
			prst.setString(1, studentDTO.getEnrollment());
			prst.execute();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(prst != null) {
				prst.close();
			}
		}
		return false;
	}
}
