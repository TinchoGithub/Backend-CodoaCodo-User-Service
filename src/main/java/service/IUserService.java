package service;

import java.sql.SQLException;
import java.util.List;

import model.User;

public interface IUserService {
	
	List<User>findAllUser() throws SQLException, ClassNotFoundException;
	User getUserById(Long id) throws SQLException, ClassNotFoundException;
	void saveUser(User user) throws SQLException, ClassNotFoundException;
	void updateUser(User user) throws SQLException, ClassNotFoundException;
	void deleteUser(Long id) throws SQLException, ClassNotFoundException;
	
}
