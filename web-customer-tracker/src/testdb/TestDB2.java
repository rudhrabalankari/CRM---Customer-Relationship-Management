package testdb;

import java.io.IOException;

import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestDB2")
public class TestDB2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// set up the connection variables
		String userID = "springstudent";
		String password = "springstudent";

		String jdbcURL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";

		String driver = "com.mysql.jdbc.Driver";

		// get the connection to the data base
		try {
			System.out.println("Connecting to the data base");

			Class.forName(driver);
			Connection conn = DriverManager.getConnection(jdbcURL, userID, password);

			System.out.println("Connection Successful!");

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();

			throw new ServletException();
		}

	}

}
