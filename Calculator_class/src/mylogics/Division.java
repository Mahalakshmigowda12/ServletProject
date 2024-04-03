package mylogics;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/div")
public class Division extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String num1=req.getParameter("num1");
	String num2=req.getParameter("num2");
	int x=Integer.parseInt(num1);
	int y=Integer.parseInt(num2);
	int res=x/y;
	resp.getWriter().print("<h1>the <span style='color:red'>Division</span> of <span style='color:red'>"+num1+"</span> and <span style='color:red'> "+num2+" </span> is "+res+" </span></h1>");
	
	
}
	
}
