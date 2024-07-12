package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import model.User;

public class UserServiceImpl implements IUserService {
	
	private Conexion conexion;
	
	public UserServiceImpl() {
		this.conexion = new Conexion();
	}

	@Override
	public List<User> findAllUser() throws SQLException, ClassNotFoundException {
		
		List<User> users = new ArrayList<User>();
		Connection connection = conexion.getConnection();
		String request = "SELECT * FROM user";
		PreparedStatement ps = connection.prepareStatement(request);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			User user = new User(
					rs.getLong("id"),
					rs.getString("nameUser"),
					rs.getString("email"),
					rs.getString("password"),
					rs.getString("birthdate"),
					rs.getString("country")
	            );
			
			
			users.add(user);
		}
		
		ps.close();
		rs.close();
		connection.close();
		
		return users;
	}

	@Override
	public User getUserById(Long id) throws SQLException, ClassNotFoundException {
		
		User user = null;
		Connection connection = conexion.getConnection();
		String request = "SELECT * FROM user WHERE ID=?";
		PreparedStatement ps = connection.prepareStatement(request);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
			user = new User(
					rs.getLong("id"),
					rs.getString("nameUser"),
					rs.getString("email"),
					rs.getString("password"),
					rs.getString("birthdate"),
					rs.getString("country")
					);
		}
		
		ps.close();
		rs.close();
		connection.close();
				
		return user;
	}

	@Override
	public void saveUser(User user) throws SQLException, ClassNotFoundException{
		
		Connection connection = conexion.getConnection();
		String request = "INSERT INTO user (nameUser, email, password, birthdate, country) VALUES (?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(request);
		
		ps.setString(1, user.getNameUser());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getBirthdate());
		ps.setString(5, user.getCountry());
		
		ps.executeUpdate();
		
		ps.close();
		connection.close();
		
	}

	@Override
	public void updateUser(User user) throws SQLException, ClassNotFoundException{
		
		Connection connection = conexion.getConnection();
		String request = "UPDATE user SET nameUser=?, email=?, password=?, birthdate=?, country=? WHERE ID=?";
		PreparedStatement ps = connection.prepareStatement(request);
		
		ps.setString(1, user.getNameUser());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getBirthdate());
		ps.setString(5, user.getCountry());
		ps.setLong(6, user.getId());
		
		ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		
	}

	@Override
	public void deleteUser(Long id) throws ClassNotFoundException, SQLException{
		
		Connection connection = conexion.getConnection();
		String request = "DELETE FROM user WHERE ID=?";
		PreparedStatement ps = connection.prepareStatement(request);
		
		ps.setLong(1, id);
		ps.executeUpdate();
		
		ps.close();
		connection.close();
		
			
	}
	

}
