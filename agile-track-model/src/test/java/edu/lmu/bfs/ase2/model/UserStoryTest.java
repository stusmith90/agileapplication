/**
 * 
 */
package edu.lmu.bfs.ase2.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;




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
public class UserStoryTest {

	SessionFactory sessionFactory;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
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

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * @TestCriteria Path of least resistance (Happy Path). Test that a
	 *               SprintBacklog can be created on the DB - uses Hibernate
	 * 
	 * @ExpectedResults Sprint Backlog saved to DB successfully.
	 * 
	 */
	@Test
	public void testHibernateCreate() {
		String methodName = "testHibernateCreate";

		// Create a Sprint Backlog and set it up with some values
		UserStory userStory = new UserStory();
		userStory.setId(1);
		userStory.setDescription("sffdsfds");
		userStory.setTitle(this.getClass().getName() + "." + methodName
				+ "()");
		userStory.setAcceptanceCriteria("xdsgdsgsd");
		userStory.setPriority(3);
		ProductBacklog pr = new ProductBacklog();
		pr.setId(12);
		userStory.setProductBacklog(pr);
		User user = new ProductOwner();
		userStory.setProductOwner(user);
		userStory.setStoryPointEstimate(4);
		// Save to DB
		UserStoryDAOImpl dao = new UserStoryDAOImpl(sessionFactory);
		dao.createEntity(userStory);
		// Check Assertions
		assertNotNull(userStory.getId());
		assertEquals(this.getClass().getName() + "." + methodName + "()",
				userStory.getTitle());
	}
	
	/**
	 * @TestCriteria Select Sprint Backlogs from DB By Profile ID
	 * 
	 * @ExpectedResults Existing Sprint Backlogs returned from DB successfully.
	 */
	@Test
	public void testHibernateGetByProfileId() {
		
		// TODO set up some test data here, but for now, I know there are a bunch against project ID 0
		
		// Select from DB
		UserStoryDAOImpl dao = new UserStoryDAOImpl(sessionFactory);
		UserStory userStory = new UserStory();
		List<IMarkerEntity> list = dao.listEntity(userStory);

		// Check Assertions
        assertNotNull("Find all method for 'UserStory' illegally returned null", list);
        assertTrue("Find all method for 'UserStory' failed to return any data", list.size() > 0);
		
		// TODO set up assertions for the list elements

	}	
	
	@Test
	public void testGetTaskListByUserStoy(){
		UserStoryDAOImpl dao = new UserStoryDAOImpl(sessionFactory);
		UserStory userstory = new UserStory();
		List<IMarkerEntity> list = dao.listEntity(userstory);
		// Check Assertions
        assertNotNull("Find all method for 'UserStory' illegally returned null", list);
        assertTrue("Find all method for 'UserStory' failed to return any data", list.size() > 0);		
	}

	@Test
	public void testFindUserStoryByProductBacklog(){
		UserStoryDAOImpl dao = new UserStoryDAOImpl(sessionFactory);
		ProductBacklog productBacklog = new ProductBacklog();
		productBacklog.setId(12);
		List<IMarkerEntity> list = dao.findUserStoryByProductBacklog(productBacklog);
		// Check Assertions
        assertNotNull("Find all method for 'UserStory' illegally returned null", list);
        assertTrue("Find all method for 'UserStory' failed to return any data", list.size() > 0);		
	}
}
