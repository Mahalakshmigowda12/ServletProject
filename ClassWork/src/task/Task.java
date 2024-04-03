package task;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/task")
public class Task  extends HttpServlet{
	private static final String DoB = null;
	Connection connection;
	@Override
	public void init() throws ServletException {
	
		loadClass();
		connection();
		createTable();
		}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String Mobile=req.getParameter("mobile");
//		long phone=Integer.parseInt(Mobile);
		String Degree=req.getParameter("degree");
		String Stream=req.getParameter("stream");
		String Date=req.getParameter("dob");
//		int DOB=Integer.parseInt(Date);
		String Gender=req.getParameter("gender");
		String Address=req.getParameter("address");
		String Country=req.getParameter("country");
//		System.out.println(name);
//		System.out.println(Mobile);
//		System.out.println(Degree);
//		System.out.println(Date);
//		System.out.println(Gender);
//		System.out.println(Address);
//		System.out.println(Country);
	
//		try {
//			connection.prepareStatement("CREATE TABLE STUDENT(NAME varchar(20),mobile varchar(10) primary key ,GENDER VARCHAR(20),STREAM varchar(20),COUNTRY varchar(20),ADDRESS varchar(20),DOB varchar(20))").execute();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		insertValues(name, Mobile, Gender, Stream, Country, Address, DoB);
		resp.getWriter().println("<h1>Form submitted</h1>");
	}
	
	public void loadClass()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("class loaded");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("driver class not loaded");
		}
	}
	
	public void connection()
	{
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_registration?createDatabaseIfNotExist=true","root","Maha");
			System.out.println("connection established");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("not established");
		}
	}
	public void createTable()
	{
		try {
			connection.prepareStatement("CREATE TABLE STUDENT(NAME varchar(20),MOBILE varchar(10) primary key,GENDER varchar(20),STREAM varchar(20),COUNTRY varchar(20),ADDRESS varchar(20),DOB varchar(20))").execute();
			System.out.println("table is created");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("table is not created");
		}
	}
	
	private void insertValues(String NAME,String MOBILE,String GENDER,String STREAM,String COUNTRY,String ADDRESS,String DoB)
	{
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?,?,?,?");
			
			preparedStatement.setString(1, NAME);
			preparedStatement.setString(2, MOBILE);
			preparedStatement.setString(3, GENDER);
			preparedStatement.setString(4, STREAM);
			preparedStatement.setString(5, COUNTRY);
			preparedStatement.setString(6, ADDRESS);
			preparedStatement.setString(7, DoB);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
