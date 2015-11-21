/**
 * 
 */
package edu.lmu.bfs.ase2.model;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import edu.lmu.bfs.ase2.dao.IMarkerEntity;
import edu.lmu.bfs.ase2.dao.impl.UserStoryDAOImpl;

/**
 * @author Fran Modified by Bamo
 *
 */
public class UserStoryApp {

	SessionFactory sessionFactory;

	public UserStoryApp() {
		try {
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testGetTaskListByUserStoy();
	}
	public void setUp() throws Exception {
		// Start Hibernate DB Transaction

		// Create the SessionFactory from hibernate.cfg.xml
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		// Open the session and begin the transaction
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	}

	public void testGetTaskListByUserStoy(){
		UserStoryDAOImpl dao = new UserStoryDAOImpl(sessionFactory);
		UserStory userstory = new UserStory();
		List<IMarkerEntity> list = dao.listEntity(userstory);
		for (Iterator<IMarkerEntity> iterator = list.iterator(); iterator.hasNext();) {
			UserStory type = (UserStory) iterator.next();
			Set<Task> taskSet = type.getTaskSet();
			for (Iterator<Task> iterator2 = taskSet.iterator(); iterator2.hasNext();) {
				Task task = (Task) iterator2.next();
				System.out.println(task.getName());
			}
		}
	}
	
	public static void main(String[] arg){
		new UserStoryApp();
	}
}
