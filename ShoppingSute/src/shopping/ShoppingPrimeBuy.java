package shopping;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/shop")
public class ShoppingPrimeBuy extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String item=req.getParameter("name");
		resp.getWriter().print("<html><body>");
		resp.getWriter().print("<h1>You have selected: "+item+"<h1>");
		
		double shoeCP=2000;
		double shirtCp=1800;
		double kurthaCp=300;
		int reqularDiscount=20;
		
		switch(item)
		{
		case "shoe":{
			
			
			resp.getWriter().println("<h1>Cost price is: " +shoeCP + "&#8377<h1>");
			resp.getWriter().println("<h1>Regular Discount is: " +((shoeCP*reqularDiscount)/100)+ "&#8377<h1>");
			break;
		}
		case "shirt":{
			
			resp.getWriter().println("<h1>Cost price is: " +shirtCp + "&#8377<h1>");
			resp.getWriter().println("<h1>Regular Discount is: " +((shirtCp*reqularDiscount)/100)+ "&#8377<h1>");
			
	
			break;
		}
		case "kurtha":{
			resp.getWriter().println("<h1>Cost price is: " +kurthaCp+ "&#8377<h1>");
			resp.getWriter().println("<h1>Regular Discount is: " +((kurthaCp*reqularDiscount)/100)+ "&#8377<h1>");
		
			break;
		}
		}
		resp.getWriter().print("</body></html>");
	}

}
