package shopping;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/shop")
public class Shopping extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String item=req.getParameter("name");
	switch(item)
	{
	case "shoe":{
		int price=1200;
		int discount=200;
		resp.getWriter().println("you selected : " +item);
		resp.getWriter().println("cost price is : " +price);
		resp.getWriter().println("Regular discount: " +discount);
		resp.getWriter().println("the Selling price :" +(price-discount));
		break;
	}
	case "shirt":{
		int price=1800;
		int discount=300;
		resp.getWriter().println("you selected : " +item);
		resp.getWriter().println("cost price is : " +price);
		resp.getWriter().println("Regular discount: " +discount);
		resp.getWriter().println("the Selling price :" +(price-discount));
		break;
	}
	case "kurtha":{
		int price=2000;
		int discount=200;
		resp.getWriter().println("you selected : " +item);
		resp.getWriter().println("cost price is : " +price);
		resp.getWriter().println("Regular discount: " +discount);
		resp.getWriter().println("the Selling price :" +(price-discount));
		break;
	}
	}
	}
}
