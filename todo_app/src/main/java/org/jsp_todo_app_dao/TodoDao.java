package org.jsp_todo_app_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp_todo_app_dto.Task;
import org.jsp_todo_app_dto.User;

public class TodoDao {

	
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("maha");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	
	
	public void saveUser(User user)
	{
		 transaction.begin();
		 manager.persist(user);
		 transaction.commit();
		 
	}
	
public List<User> findByEmail(String email)
{
	return manager.createQuery("select x from User x where email=?1").setParameter(1,email).getResultList();
}

public List<User> findByMobile(long mobile)
{
	return manager.createQuery("select x from User x where mobile=?1").setParameter(1,mobile).getResultList();
}

public void saveTask(Task task) {
	 transaction.begin();
	 manager.persist(task);
	 transaction.commit(); 
	
}


public List<Task>fetchTaskByUserId(int userId)
{
return manager.createQuery("select x from Task x where user_id=?1").setParameter(1, userId).getResultList();

	
}


}

public List<Task> fetch_task_by_id(int userid) {
	// TODO Auto-generated method stub
	return manager.createQuery("select x from Task x where user_id=?1").setParameter(1, userid).getResultList();
}
}



