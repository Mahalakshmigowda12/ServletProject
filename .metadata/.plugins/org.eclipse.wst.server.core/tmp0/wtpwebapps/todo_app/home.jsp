<%@page import="org.jsp_todo_app_dto.Task"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">HOME-PAGE</h1>
	<%
	List<Task> tasks = (List<Task>) request.getAttribute("tasks");
	%>
	<%
	if (!tasks.isEmpty()) {
	%>
	<div>
		<table border="1">
			<tr>
				<th>Task Image</th>
				<th>Task Name</th>
				<th>Task Description</th>
				<th>Created Time</th>
				<th>Status</th>
				<th>Delete</th>
				<th>Edit</th>
			</tr>

			<%
			for (Task task : tasks) {
			%>
			<tr>
				<th>
				   <img src= height="70px" width="70px" src="data:image/png/base64, <%task.getEncodeImage();%>"/>
				</th>
				<%=
				task.getName();
				%>
				<th>
					<%=
					task.getDescription()
					%>
				</th>
				<th>
					<%=
					task.getAddedtime()
					%>
				</th>
				<th>
					<%=
					task.isStatus()
					%>
				</th>
				<th><a href="delete"><button>Delete</button></a></th>
				<th><a href="edit"><button>Edit</button></a></th>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	<%
	}
	%>
	<center>
	<a href="add_task.html"><button type="button">Add Task</button></a>
	<a href="logout"><button class="extra">Logout</button></a>
	</center>
</body>
</html>