/**
 * 
 */
package edu.lmu.bfs.ase2.dao.impl;

import static org.junit.Assert.fail;

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

/**
 * @author Fran
 *
 */
public class UserDAOImplTest {

	static SessionFactory sessionFactory;
	
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
	 * Test method for {@link edu.lmu.bfs.ase2.dao.impl.UserDAOImpl#updateUser(edu.lmu.bfs.ase2.model.User)}.
	 */
	@Test
	public void testUpdateUser() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link edu.lmu.bfs.ase2.dao.impl.UserDAOImpl#deleteUser(edu.lmu.bfs.ase2.model.User)}.
	 */
	@Test
	public void testDeleteUser() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link edu.lmu.bfs.ase2.dao.impl.UserDAOImpl#getUserById(java.lang.Integer)}.
	 */
	@Test
	public void testGetUserById() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link edu.lmu.bfs.ase2.dao.impl.UserDAOImpl#getUsersByRole(java.lang.String)}.
	 */
	@Test
	public void testGetUsersByRole() {
		fail("Not yet implemented"); // TODO
	}

}
