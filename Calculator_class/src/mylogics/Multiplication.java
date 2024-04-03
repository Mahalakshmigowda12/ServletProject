package mylogics;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Multiplication extends HttpServlet{

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num1=arg0.getParameter("num1");
		String num2=arg0.getParameter("num2");
		int x=Integer.parseInt(num1);
		int y=Integer.parseInt(num2);
		int res=x*y;
		arg1.getWriter().print("<h1>the <span style='color:red'>product</span> of <span style='color:red'>"+num1+"</span> and <span style='color:red'> "+num2+" </span> is "+res+" </span></h1>");
		
	}
}