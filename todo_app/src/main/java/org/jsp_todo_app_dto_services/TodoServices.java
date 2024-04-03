package org.jsp_todo_app_dto_services;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.jsp_todo_app_dao.TodoDao;
import org.jsp_todo_app_dto.Task;
import org.jsp_todo_app_dto.User;

public class TodoServices {
TodoDao dao=new TodoDao();
	
	public void signup(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		User user=new User();
		
		user.setEmail(req.getParameter("email"));
		user.setGender(req.getParameter("gender"));
		user.setMobile(Long.parseLong(req.getParameter("mobile")));
		user.setName(req.getParameter("nam"));
		user.setPassword(req.getParameter("password"));
		
		dao.saveUser(user);

//		
//		 resp.getWriter().print("<h1 style:'color:green'>account created succesfully </h1>");
//		 req.getRequestDispatcher("logon.html").include(req, resp);
		 
		 List<User> users1=dao.findByEmail(user.getEmail());
		 List<User> users2=dao.findByMobile(user.getMobile());
		 
		 
		 if(users1.isEmpty() && users2.isEmpty())
		 {
			 dao.saveUser(user);
			 resp.getWriter().print("<h1 align='center' style='color:green'>Account created succesfully</h1>");
			 req.getRequestDispatcher("logim.html").include(req, resp);
		 }else
			 if(users1.isEmpty())
			 {
				 resp.getWriter().print("<h1 align='center' style='color:red'>Mobile number should be unigue</h1>");
			 }else if(users2.isEmpty())
			 {
				 resp.getWriter().print("<h1 align='center' style='color:red'>Emailshould be unigue</h1>");
			 }else{
				 resp.getWriter().print("<h1 align='center' style='color:red'>Mobile number and email should be unigue</h1>");
			 }
		 req.getRequestDispatcher("signup.html").include(req, resp);
		 
	}

	public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String emph=req.getParameter("email");
	String password=req.getParameter("pass");
	
	List<User>list=null;
	try {
		long mobile = Long.parseLong(emph);
		list = dao.findByMobile(mobile);
		if (list.isEmpty()) {
			resp.getWriter().print("<h1 align='center' style='color:red'>Incorrect Mobile Number</h1>");
		}
	} catch (NumberFormatException e) {
		String email = emph;
		list = dao.findByEmail(email);
		if (list.isEmpty()) {
			resp.getWriter().print("<h1 align='center' style='color:red'>Incorrect Email</h1>");
		}
	}

	if (!list.isEmpty()) {

		User user = list.get(0);

  		// to set the session
		// to allow users for some pages only after login
		if (list.get(0).getPassword().equals(password))
		{
			req.getSession().setAttribute("user", list.get(0));
			resp.getWriter().print("<h1 align='center' style='color:green'>Login Success</h1>");
			
			//after login going to home, so to carry the tasks adding 2 lines here
			List<Task> tasks = dao.fetch_task_by_id(user.getId());
			req.setAttribute("tasks", tasks);
			
			req.getRequestDispatcher("home.jsp").include(req, resp);
		} else {
			resp.getWriter().print("<h1 align='center' style='color:red'>Incorrect Password</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
	}

	else {
		req.getRequestDispatcher("login.html").include(req, resp);
	}
		
	}
	public void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.getSession().removeAttribute("user");
		resp.getWriter().print("<h1 align='center' style=color:'green'>Logout Success</h1>");
		req.getRequestDispatcher("login.html").include(req, resp);
	}

	public void addTask(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String name=req.getParameter("name");
		String discription=req.getParameter("desription");
		Part image=req.getPart("image");
		
		Task task=new Task();
		task.setName(name);
		task.setDescription(discription);
		task.setStatus(false);
		task.setAddedtime(LocalDateTime.now());
		
		byte[] pic=new byte[image.getInputStream().available()];
		image.getInputStream().read(pic);
		task.setImage(pic);
		User user=(User)req.getSession().getAttribute("user");
		task.setUser(user);
		
		dao.saveTask(task);
		resp.getWriter().print("<h1> align='center' style='color=green'  ");
		
	}
	
	
}
