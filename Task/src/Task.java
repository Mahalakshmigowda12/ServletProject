import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/task")
public class Task  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String x=req.getParameter("number");
		int a=Integer.parseInt(x);
		String y=req.getParameter("number1");
		int b=Integer.parseInt(y);
		resp.getWriter().print("<html><head>/</head><body>");
		
		resp.getWriter().print("<table border='1px'>");
		for(int i=1;i<=b;i++)
		{
			
		resp.getWriter().print("<tr>");
		resp.getWriter().print("<td>"+a+"</td>");
		
		resp.getWriter().print("<td>"+"X"+"</td>");
		resp.getWriter().print("<td>"+i+"</td>");
		resp.getWriter().print("<td>"+"="+"</td>");
		resp.getWriter().print("<td>"+(a*i)+"</td>");
		resp.getWriter().print("</tr>");
		
		}
		resp.getWriter().print("</table>");
		resp.getWriter().print("</body></html>");
		
		
		
		
	}
	}


