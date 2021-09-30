package fr.training.simplewebapp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import fr.training.simplewebapp.beans.UserAccount;
import fr.training.simplewebapp.utils.DBUtils;
import fr.training.simplewebapp.utils.MyUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public LoginServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
		
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String rememberMeStr = request.getParameter("rememberMe");
		boolean remember = "Y".equals(rememberMeStr);
		
		UserAccount user = null;
		boolean hasError = false;
		String errorString = null;
		
		if (userName == null || password == null || userName.length() == 0 || password.length() == 0) {
			hasError = true;
			errorString = "Required username and password";
		} else {
			Connection conn = MyUtils.getStoredConnection(request);
			try {
				user = DBUtils.findUser(conn,  userName, password);
				
				if (user == null) {
					hasError = true;
					errorString = "User Name or password invalid";
				}
			} catch (SQLException e){
				e.printStackTrace();
				hasError = true;
				errorString = e.getMessage();
			}
		}
		
		if (hasError) {
			user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			request.setAttribute("errorString", errorString);
			request.setAttribute("user", user);
			
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
			dispatcher.forward(request, response);
		} else {
			HttpSession session = request.getSession();
			MyUtils.storeLoginedUser(session, user);
			
			if (remember) {
				MyUtils.storeUserCookie(response, user);
			} else {
				MyUtils.deleteUserCookie(response);
			}
			response.sendRedirect(request.getContextPath() + "/userInfo");
		}
	}

}
