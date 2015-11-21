/**
 * 
 */
package edu.lmu.bfs.ase2.dao.impl;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.lmu.bfs.ase2.model.SprintBacklog;

/**
 * @author Fran
 *
 */
public class SprintBacklogDAOImplTest {

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
	 * Convenience method creates a Calendar instance at midnight today, and add
	 * or deduct a specified number of days from it
	 * 
	 * @param days
	 *            0 if today, negative or positive value to move data to a
	 *            different date forward or back by that number of days
	 * @return
	 */
	private Calendar addDays(int days) {
		// Get Calendar instance of now
		Calendar cal = Calendar.getInstance();

		// Adjust the date (dateIncrement of 0 will not adjust the date)
		cal.add(Calendar.DATE, days);

		return cal;
	}
	
	/**
	 * Convenience method to assert two Calendar dates are the same, ignoring
	 * the time element
	 * 
	 * @param cal1
	 * @param cal2
	 */
	private static void assertDateEquals(Calendar cal1, Calendar cal2) {
		assertEquals(
				0,
				Days.daysBetween(new DateTime(cal1.getTimeInMillis()),
						new DateTime(cal2.getTimeInMillis())).getDays());
	}
	
	private static void checkAssertions(SprintBacklog sprintBacklog) {
		
		// Get the SprintBacklog from the DB again to check assertions
		SprintBacklogDAOImpl dao = new SprintBacklogDAOImpl(sessionFactory);
		SprintBacklog savedSprintBacklog = dao.getSprintBacklogById(sprintBacklog.getId());

		// Check Assertions
		assertNotNull(sprintBacklog.getId());
		assertNotNull(savedSprintBacklog.getId());
		assertEquals(sprintBacklog.getId(), savedSprintBacklog.getId());
		assertEquals(sprintBacklog.getName(), savedSprintBacklog.getName());
		assertEquals(sprintBacklog.getProjectId(), savedSprintBacklog.getProjectId());
		assertDateEquals(sprintBacklog.getStartDate(), savedSprintBacklog.getStartDate());
		assertDateEquals(sprintBacklog.getEndDate(), savedSprintBacklog.getEndDate());
		
	}
	

	/**
	 * Test method for {@link edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImpl#createSprintBacklog(edu.lmu.bfs.ase2.model.SprintBacklog)}.
	 *
	 * @TestCriteria Path of least resistance (Happy Path). Test that a
	 *               SprintBacklog can be created on the DB - uses Hibernate
	 * 
	 * @ExpectedResults Sprint Backlog saved to DB successfully.
	 * 
	 */
	@Test
	public void testCreateSprintBacklog() {
		String methodName = "testCreateSprintBacklog";

		// Create a Sprint Backlog and set it up with some values
		SprintBacklog sprintBacklog = new SprintBacklog();

		sprintBacklog.setName(this.getClass().getName() + "." + methodName
				+ "()");
		sprintBacklog.setProjectId(0);
		sprintBacklog.setStartDate(Calendar.getInstance());
		sprintBacklog.setEndDate(addDays(1));

		// Save to DB
		SprintBacklogDAOImpl dao = new SprintBacklogDAOImpl(sessionFactory);
		dao.createSprintBacklog(sprintBacklog);
		
		// Check Assertions
		checkAssertions(sprintBacklog);

	}

	/**
	 * Test method for {@link edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImpl#updateSprintBacklog(edu.lmu.bfs.ase2.model.SprintBacklog)}.
	 * 
	 * @TestCriteria Test that a SprintBacklog's name can be updated on the DB -
	 *               uses Hibernate. Update Name on existing Sprint Backlog to a
	 *               different value
	 * 
	 * @ExpectedResults Existing Sprint Backlog updated to DB successfully.
	 * 
	 */
	@Test
	public void testUpdateSprintBacklogName() {
		String methodName = "testUpdateSprintBacklogName";

		// create the Sprint Backlog to test.
		SprintBacklog sprintBacklog = new SprintBacklog();

		sprintBacklog.setName(this.getClass().getName() + "." + methodName
				+ "()");
		sprintBacklog.setProjectId(0);
		sprintBacklog.setStartDate(Calendar.getInstance());
		sprintBacklog.setEndDate(Calendar.getInstance());

		// Save to DB
		SprintBacklogDAOImpl dao = new SprintBacklogDAOImpl(sessionFactory);
		dao.createSprintBacklog(sprintBacklog);

		// Check Assertions before doing the update
		checkAssertions(sprintBacklog);

		// Test updating the SprintBacklog
		sprintBacklog.setName(sprintBacklog.getName() + " - Updated");

		// Save to DB
		dao.updateSprintBacklog(sprintBacklog);

		// Check Assertions
		checkAssertions(sprintBacklog);

	}
	
	/**
	 * Test method for {@link edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImpl#updateSprintBacklog(edu.lmu.bfs.ase2.model.SprintBacklog)}.
	 * 
	 * @TestCriteria Test that a SprintBacklog's start Date can be updated on
	 *               the DB - uses Hibernate. Update Start Date on existing
	 *               Sprint Backlog to a different valid value
	 * 
	 * @ExpectedResults Existing Sprint Backlog updated to DB successfully.
	 * 
	 */
	@Test
	public void testUpdateSprintBacklogStartDate() {
		String methodName = "testUpdateSprintBacklogStartDate";

		// create the Sprint Backlog to test.
		SprintBacklog sprintBacklog = new SprintBacklog();

		sprintBacklog.setName(this.getClass().getName() + "." + methodName
				+ "()");
		sprintBacklog.setProjectId(0);
		sprintBacklog.setStartDate(Calendar.getInstance());
		sprintBacklog.setEndDate(Calendar.getInstance());

		// Save to DB
		SprintBacklogDAOImpl dao = new SprintBacklogDAOImpl(sessionFactory);
		dao.createSprintBacklog(sprintBacklog);

		// Check Assertions before doing update
		checkAssertions(sprintBacklog);

		// Test updating the SprintBacklog
		sprintBacklog.setStartDate(this.addDays(-1));

		// Save to DB
		dao.updateSprintBacklog(sprintBacklog);

		// Check Assertions
		checkAssertions(sprintBacklog);

	}
	
	/**
	 * Test method for {@link edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImpl#updateSprintBacklog(edu.lmu.bfs.ase2.model.SprintBacklog)}.
	 * 
	 * @TestCriteria Test that a SprintBacklog's end Date can be updated on the
	 *               DB - uses Hibernate. Update End Date on existing Sprint
	 *               Backlog to a different valid value
	 * 
	 * @ExpectedResults Existing Sprint Backlog updated to DB successfully.
	 * 
	 */
	@Test
	public void testUpdateSprintBacklogEndDate() {
		String methodName = "testUpdateSprintBacklogEndDate";

		// create the Sprint Backlog to test.
		SprintBacklog sprintBacklog = new SprintBacklog();

		sprintBacklog.setName(this.getClass().getName() + "." + methodName
				+ "()");
		sprintBacklog.setProjectId(0);
		sprintBacklog.setStartDate(Calendar.getInstance());
		sprintBacklog.setEndDate(Calendar.getInstance());

		// Save to DB
		SprintBacklogDAOImpl dao = new SprintBacklogDAOImpl(sessionFactory);
		dao.createSprintBacklog(sprintBacklog);

		// Check Assertions before doing update
		checkAssertions(sprintBacklog);

		// Test updating the SprintBacklog
		sprintBacklog.setEndDate(this.addDays(1));

		// Save to DB
		dao.updateSprintBacklog(sprintBacklog);

		// Check Assertions
		checkAssertions(sprintBacklog);
	}
	
	/**
	 * Test method for {@link edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImpl#updateSprintBacklog(edu.lmu.bfs.ase2.model.SprintBacklog)}.
	 * 
	 * @TestCriteria Test that a SprintBacklog's Project ID can be updated on
	 *               the DB - uses Hibernate. Update Project on existing Sprint
	 *               Backlog to a different valid value
	 * 
	 * @ExpectedResults Existing Sprint Backlog updated to DB successfully.
	 *                  Note, there are currently no integrity constraints on
	 *                  Project Id. This test may need updating if constraints
	 *                  are added.
	 * 
	 */
	@Test
	public void testUpdateSprintBacklogProjectId() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImpl#updateSprintBacklog(edu.lmu.bfs.ase2.model.SprintBacklog)}.
	 * 
	 * @TestCriteria Attempt to update Sprint Backlog with an invalid ID (that
	 *               doesn't exist on the DB)
	 * 
	 * @ExpectedResults Should fail to update the DB. Record should not be added
	 *                  to the DB (as ID might be out of sequence)
	 * 
	 */
	@Test
	public void testUpdateSprintBacklogInvalidId() {
		fail("Not yet implemented");
	}
	

	/**
	 * Test method for {@link edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImpl#deleteSprintBacklog(edu.lmu.bfs.ase2.model.SprintBacklog)}.
	 */
	@Test
	public void testDeleteSprintBacklog() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImpl#getSprintBacklogById(java.lang.Integer)}.
	 * 
	 * @TestCriteria Select an existing Sprint Backlog by ID
	 * 
	 * @ExpectedResults Existing Sprint Backlog returned from DB successfully.
	 * 
	 */
	@Test
	public void testGetSprintBacklogById() {
		String methodName = "testCreateSprintBacklog";

		// Create a Sprint Backlog and set it up with some values
		SprintBacklog sprintBacklog = new SprintBacklog();

		sprintBacklog.setName(this.getClass().getName() + "." + methodName
				+ "()");
		sprintBacklog.setProjectId(0);
		sprintBacklog.setStartDate(Calendar.getInstance());
		sprintBacklog.setEndDate(addDays(1));

		// Save to DB
		SprintBacklogDAOImpl dao = new SprintBacklogDAOImpl(sessionFactory);
		dao.createSprintBacklog(sprintBacklog);
		
		// Check Assertions -- this calls GetSprintBaklogById
		checkAssertions(sprintBacklog);

	}

	/**
	 * Test method for {@link edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImpl#getSprintBacklogByProjectID(java.lang.Integer)}.
	 * 
	 * @TestCriteria Select Sprint Backlogs from DB By Profile ID
	 * 
	 * @ExpectedResults Existing Sprint Backlogs returned from DB successfully.
	 * 
	 */
	@Test
	public void testGetSprintBacklogByProjectID() {
		// TODO set up some test data here, but for now, I know there are a bunch against project ID 0
		
		// Select from DB
		SprintBacklogDAOImpl dao = new SprintBacklogDAOImpl(sessionFactory);
		List<SprintBacklog> list = dao.getSprintBacklogByProjectID(0);

		// Check Assertions
		assertFalse(0==list.size());
		
		// TODO set up assertions for the list elements

	}
	
	/**
	 * Test method for {@link edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImpl#getSprintBacklogByProjectID(java.lang.Integer)}.
	 * 
	 * @TestCriteria Select Sprint Backlogs from DB By Profile ID
	 * 
	 * @ExpectedResults Existing Sprint Backlogs returned from DB successfully.
	 * 
	 */
	@Test
	public void testGetSprintBacklogByProjectIDEmptyList() {

		// Select from DB - assumes there are no project Ids of -99
		SprintBacklogDAOImpl dao = new SprintBacklogDAOImpl(sessionFactory);
		List<SprintBacklog> list = dao.getSprintBacklogByProjectID(-99);

		// Check Assertions
		assertEquals(0,list.size());


	}
	
	

}
