package dynamic;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/check")
public class CheckColor  implements Servlet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String color=arg0.getParameter("x");
		if(color.equals("red"))
		{
			arg1.getWriter().print("<h1 style='color:red'>"+"the color is red"+"</h1>");
		}else if(color.equals("blue"))
		{
			arg1.getWriter().print("<h1 style='color:blue'>"+"the color is blue"+"</h1>");
		}else if(color.equals("green"))
		{
			arg1.getWriter().print("<h1 style='color:green'>"+"the color is green"+"</h1>");
		}else{
			arg1.getWriter().print("sorry i don't know the color");
		}
	}

}
