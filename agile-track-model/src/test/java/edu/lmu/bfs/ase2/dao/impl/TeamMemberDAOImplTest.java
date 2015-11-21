/**
 * 
 */
package edu.lmu.bfs.ase2.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.List;

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

import edu.lmu.bfs.ase2.model.TeamMember;
import edu.lmu.bfs.ase2.model.User;

/**
 * @author Fran
 * 
 */
public class TeamMemberDAOImplTest {

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

		if (sessionFactory != null) {
			// Commit the transaction
			Session session = sessionFactory.getCurrentSession();
			session.getTransaction().commit();

			// Close the session
			sessionFactory.close();
		}

	}

	private void checkAssertions(User user) {

		// Get the User from the DB again to check assertions
		UserDAOImpl dao = new UserDAOImpl(sessionFactory);
		User savedUser = dao.getUserById(user.getId());

		this.checkAssertions(user, savedUser);

	}

	private void checkAssertions(User user, User savedUser) {

		// Check Assertions
		assertNotNull(user.getId());
		assertNotNull(savedUser.getId());
		assertEquals(user.getId(), savedUser.getId());
		assertEquals(user.getName(), savedUser.getName());
		assertEquals(user.getPassword(), savedUser.getPassword());

	}

	/**
	 * Test method for
	 * {@link edu.lmu.bfs.ase2.dao.impl.UserDAOImpl#createUser(edu.lmu.bfs.ase2.model.User)}
	 * .
	 */
	@Test
	public void testCreateUser() {
		String methodName = "testCreateUser";

		// Create a User and set it up with some values
		TeamMember user = new TeamMember();

		user.setName(this.getClass().getName() + "." + methodName + "()");
		user.setPassword("fran");
		user.setUsername("fran" + Calendar.getInstance().getTimeInMillis());

		// Save to DB
		UserDAOImpl dao = new UserDAOImpl(sessionFactory);
		dao.createUser(user);

		// Check Assertions
		checkAssertions(user);
	}

	/**
	 * Test method for
	 * {@link edu.lmu.bfs.ase2.dao.impl.UserDAOImpl#updateUser(edu.lmu.bfs.ase2.model.User)}
	 * .
	 */
	@Test
	public void testUpdateUser() {
		String methodName = "testUpdateUser";

		// Create a User and set it up with some values
		TeamMember user = new TeamMember();

		user.setName(this.getClass().getName() + "." + methodName + "()");
		user.setPassword("fran");
		user.setUsername("fran" + Calendar.getInstance().getTimeInMillis());

		// Save to DB
		UserDAOImpl dao = new UserDAOImpl(sessionFactory);
		dao.createUser(user);

		// Get the User from the DB again to check assertions
		User savedUser = dao.getUserById(user.getId());

		// Check Assertions
		checkAssertions(user, savedUser);

		// Update the user
		savedUser.setName(this.getClass().getName() + "." + methodName
				+ "() Updated");
		savedUser.setPassword("franupdated");
		savedUser.setUsername("updt"
				+ Calendar.getInstance().getTimeInMillis());

		dao.updateUser(savedUser);

		// Check Assertions
		checkAssertions(savedUser);
	}

	/**
	 * Test method for
	 * {@link edu.lmu.bfs.ase2.dao.impl.UserDAOImpl#deleteUser(edu.lmu.bfs.ase2.model.User)}
	 * .
	 */
	@Test
	public void testDeleteUser() {
		String methodName = "testDeleteUser";

		// Create a User and set it up with some values
		TeamMember user = new TeamMember();

		user.setName(this.getClass().getName() + "." + methodName + "()");
		user.setPassword("fran");
		user.setUsername("fran" + Calendar.getInstance().getTimeInMillis());

		// Save to DB
		UserDAOImpl dao = new UserDAOImpl(sessionFactory);
		dao.createUser(user);

		// Get the User from the DB again to check assertions
		User savedUser = dao.getUserById(user.getId());
		checkAssertions(user, savedUser);

		// Delete
		dao.deleteUser(savedUser);

		// Get the User from the DB again to make sure its deleted
		User deletedUser = dao.getUserById(user.getId());

		assertNull(deletedUser);

	}

	/**
	 * Test method for
	 * {@link edu.lmu.bfs.ase2.dao.impl.UserDAOImpl#getUserById(java.lang.Integer)}
	 * .
	 */
	@Test
	public void testGetUserById() {
		String methodName = "testGetUserById";

		// Create a User and set it up with some values
		TeamMember user = new TeamMember();

		user.setName(this.getClass().getName() + "." + methodName + "()");
		user.setPassword("fran");
		user.setUsername("fran" + Calendar.getInstance().getTimeInMillis());

		// Save to DB
		UserDAOImpl dao = new UserDAOImpl(sessionFactory);
		dao.createUser(user);

		// Get the User from the DB and check assertions
		User savedUser = dao.getUserById(user.getId());
		checkAssertions(user, savedUser);
	}

	/**
	 * Test method for
	 * {@link edu.lmu.bfs.ase2.dao.impl.UserDAOImpl#getUserByUsername(java.lang.String)}
	 * .
	 */
	@Test
	public void testGetByUsername() {
		String methodName = "testGetByUsername";

		// Create a User and set it up with some values
		TeamMember user = new TeamMember();

		user.setName(this.getClass().getName() + "." + methodName + "()");
		user.setPassword("fran");
		user.setUsername("fran" + Calendar.getInstance().getTimeInMillis());

		// Save to DB
		UserDAOImpl dao = new UserDAOImpl(sessionFactory);
		dao.createUser(user);

		// Check Assertions
		checkAssertions(user);

		// Call the DB Method
		TeamMember tm = new TeamMember();
		tm = (TeamMember) dao.getUserByUsername(user.getUsername());

		// check assertions
		checkAssertions(user, tm);

	}

	/**
	 * Test method for
	 * {@link edu.lmu.bfs.ase2.dao.impl.UserDAOImpl#getUsersByRole()}.
	 */
	@Test
	public void testGetUsersByRole() {
		String methodName = "testGetUsersByRole";

		// Create a User and set it up with some values
		TeamMember user = new TeamMember();

		user.setName(this.getClass().getName() + "." + methodName + "()");
		user.setPassword("fran");
		user.setUsername("fran" + Calendar.getInstance().getTimeInMillis());

		// Save to DB
		UserDAOImpl dao = new UserDAOImpl(sessionFactory);
		dao.createUser(user);

		// Check Assertions
		checkAssertions(user);

		// Get Users by Role
		@SuppressWarnings("unchecked")
		List<TeamMember> users = (List<TeamMember>) dao.getUsersByRole(user
				.getRole());

		// check assertions
		assertNotNull(users);
		assertNotEquals(0, users.size());

		// check the user we just created is one of the users in the list... it
		// should be
		boolean foundIt = false;
		for (User next : users) {
			// is this the one we just added?
			if (next.getId().equals(user.getId())) {
				foundIt = true;
				break;
			}
		}
		assertTrue(foundIt);

	}

}
