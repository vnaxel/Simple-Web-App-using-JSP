package fr.training.simplewebapp.servlet;

import java.io.IOException;

import fr.training.simplewebapp.beans.UserAccount;
import fr.training.simplewebapp.utils.MyUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns= {"/userInfo"})
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public UserInfoServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		UserAccount loginedUser = MyUtils.getLoginedUser(session);
		
		if (loginedUser == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		request.setAttribute("user", loginedUser);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/userInfoView.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doGet(request, response);
	}

}
