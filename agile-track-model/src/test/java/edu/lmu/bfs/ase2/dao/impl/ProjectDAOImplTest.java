/**
 * 
 */
package edu.lmu.bfs.ase2.dao.impl;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.lmu.bfs.ase2.model.Project;

/**
 * @author Stuart
 *
 */
public class ProjectDAOImplTest {

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

	static SessionFactory sessionFactory;

	@Test
	public void test() {
		fail("Not yet implemented");
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
		
		if ( sessionFactory != null )
		{
			// Commit the transaction
			Session session = sessionFactory.getCurrentSession();
			session.getTransaction().commit();
			
			// Close the session
			sessionFactory.close();
		}
	
	}

	/**
	 * Test method for {@link edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImpl#getProductBacklogById(java.lang.Integer)}.
	 * 
	 * @TestCriteria Select an existing Product Backlog by ID
	 * 
	 * @ExpectedResults Existing Product Backlog returned from DB successfully.
	 * 
	 */
	@Test
	public void testGetProjectById() {
	
		// Get the Product from the DB again to check assertions
		ProjectDAOImpl dao = new ProjectDAOImpl(sessionFactory);
		Project savedProject = (Project) dao.getEntityById (0);
		
		assertNotNull(savedProject);
		assertEquals (new Integer(0), savedProject.getId()); 

	
	}

}
