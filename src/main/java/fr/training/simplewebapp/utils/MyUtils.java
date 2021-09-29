package fr.training.simplewebapp.utils;

import java.sql.Connection;

import fr.training.simplewebapp.beans.UserAccount;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MyUtils {
	
	public static final String ATT_NAME_CONNECTION = "3uPQ16u3D7LJQrVeGT5n";
	
	private static final String ATT_NAME_USER_NAME = "R71iC7TGDTk82ht8GN5g";
	
	public static void storeConnection(ServletRequest request, Connection conn) {
		request.setAttribute(ATT_NAME_CONNECTION,  conn);
	}
	
	public static Connection getStoredConnection(ServletRequest request) {
		Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
		return conn;
	}
	
	public static void storeLoginedUser(HttpSession session, UserAccount loginedUser) {
		session.setAttribute("loginedUser", loginedUser);
	}
	
	public static UserAccount getLoginedUser(HttpSession session) {
		UserAccount loginedUser = (UserAccount) session.getAttribute("loginedUser");
		return loginedUser;
	}
	
	public static void storeUserCookie(HttpServletResponse response, UserAccount user) {
		System.out.println("store user cookie");
		Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, user.getUserName());
		cookieUserName.setMaxAge(24*60*60);
		response.addCookie(cookieUserName);
	}
	
	public static String getUserNameInCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if(ATT_NAME_USER_NAME.equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}
	
	public static void deleteUserCookie(HttpServletResponse response) {
		Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, null);
		cookieUserName.setMaxAge(0);
		response.addCookie(cookieUserName);
	}
}
