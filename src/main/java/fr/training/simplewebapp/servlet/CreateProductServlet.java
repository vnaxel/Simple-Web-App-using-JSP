package fr.training.simplewebapp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import fr.training.simplewebapp.beans.Product;
import fr.training.simplewebapp.utils.DBUtils;
import fr.training.simplewebapp.utils.MyUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/createProduct")
public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateProductServlet() {
    	super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	
    	RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
    	dispatcher.forward(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	Connection conn = MyUtils.getStoredConnection(request);
    	
    	String code = (String) request.getParameter("code");
    	String name = (String) request.getParameter("name");
    	String priceStr = (String) request.getParameter("price");
    	
    	float price = 0;
    	try {
    		price = Float.parseFloat(priceStr);
    	} catch (Exception e) {
    	}
    	
    	Product product = new Product(code, name, price);
    	
    	String errorString = null;
    	
    	String regex = "\\w+";
    	
    	if (code == null || !code.matches(regex)) {
    		errorString = "Product Code Invalid";
    	}
    	
    	if (errorString == null) {
    		try {
    			DBUtils.insertProduct(conn, product);
    		} catch (SQLException e) {
    			e.printStackTrace();
    			errorString = e.getMessage();
    		}
    	}
    	
    	request.setAttribute("errorString", errorString);
    	request.setAttribute("product", product);
    	
    	if (errorString != null) {
    		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
    		dispatcher.forward(request, response);
    	} else {
    		response.sendRedirect(request.getContextPath() + "/productList");
    	}
    	
	}

}
