package org.jsp.todo_app.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp_todo_app_dto_services.TodoServices;

@WebServlet("/add-task")
@MultipartConfig
public class AddTaskServlet  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TodoServices service =new TodoServices();
		service.addTask(req,resp);
	}

}
