package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import service.UserServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/usuarios/*")

public class UserServlet extends HttpServlet {
	
	private UserServiceImpl userService;
	private ObjectMapper objectMapper;
	
	@Override
	public void init() throws ServletException{
		userService = new UserServiceImpl();
		objectMapper = new ObjectMapper();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pathInfo = req.getPathInfo();
		try {
			
			if(pathInfo == null || pathInfo.equals("/")) {
				
				List<User> usarios = userService.findAllUser();
				String json = objectMapper.writeValueAsString(usarios);
				resp.setContentType("application/json");
				resp.getWriter().write(json);
				
			}else {
				
				String[] pathParts = pathInfo.split("/");
				Long id = Long.parseLong(pathParts[1]);
				User user = userService.getUserById(id);
				if(user!=null) {
					
					String json = objectMapper.writeValueAsString(user);
					resp.setContentType("application/json");
					resp.getWriter().write(json);
					
				}else {
					resp.sendError(HttpServletResponse.SC_NOT_FOUND);
				}
				
				
			}
			
		}
		catch(SQLException|ClassNotFoundException e) {
			
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
		
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			User user = objectMapper.readValue(req.getReader(), User.class);
			userService.saveUser(user);
			resp.setStatus(HttpServletResponse.SC_CREATED);
			
		}catch(SQLException|ClassNotFoundException e) {
			
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}
	
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			User user = objectMapper.readValue(req.getReader(), User.class);
			userService.updateUser(user);
			resp.setStatus(HttpServletResponse.SC_CREATED);
			
		}catch(SQLException|ClassNotFoundException e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		
		}
		
		
	}
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String pathInfo = req.getPathInfo();
		String[] pathParts = pathInfo.split("/");
		
		try {
			
			if(pathInfo!=null&&pathParts.length>1) {
				
				Long id = Long.parseLong(pathParts[1]);
				userService.deleteUser(id);
				resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
				
			}else {
				
				resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
				
			}
		}catch(SQLException|ClassNotFoundException e) {
			
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

}
