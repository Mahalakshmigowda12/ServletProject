package mylogics;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/sub")
public class Substract extends GenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num1=arg0.getParameter("num1");
		String num2=arg0.getParameter("num2");
		int x=Integer.parseInt(num1);
		int y=Integer.parseInt(num2);
		int res=x-y;
		arg1.getWriter().print("<h1>the <span style='color:red'>Difference</span> of <span style='color:red'>"+num1+"</span> and <span style='color:red'> "+num2+" </span> is "+res+" </span></h1>");
		
	}

}
