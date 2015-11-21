/**
 * 
 */
package edu.lmu.bfs.ase2.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

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

import edu.lmu.bfs.ase2.model.ProductBacklog;
import edu.lmu.bfs.ase2.model.UserStory;

/**
 * @author Fran
 *
 */
public class ProductBacklogDAOImplTest {

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


	private static void checkAssertions(ProductBacklog productBacklog) {
		
		// Get the ProductBacklog from the DB again to check assertions
		ProductBacklogDAOImpl dao = new ProductBacklogDAOImpl(sessionFactory);
		ProductBacklog savedProductBacklog = (ProductBacklog) dao.getEntityById(productBacklog.getId());

		checkAssertions(productBacklog, savedProductBacklog);
	}
	
	private static void checkAssertions(ProductBacklog productBacklog, ProductBacklog savedProductBacklog) {
		
		// Check Assertions
		assertNotNull(productBacklog.getId());
		assertNotNull(savedProductBacklog.getId());
		assertEquals(productBacklog.getId(), savedProductBacklog.getId());
		assertEquals(productBacklog.getName(), savedProductBacklog.getName());
		assertEquals(productBacklog.getProjectId(), savedProductBacklog.getProjectId());
	}
	

	/**
	 * Test method for {@link edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImpl#createProductBacklog(edu.lmu.bfs.ase2.model.ProductBacklog)}.
	 *
	 * @TestCriteria Path of least resistance (Happy Path). Test that a
	 *               ProductBacklog can be created on the DB - uses Hibernate
	 * 
	 * @ExpectedResults Product Backlog saved to DB successfully.
	 * 
	 */
	@Test
	public void testCreateProductBacklog() {
		String methodName = "testCreateProductBacklog";

		// Create a Product Backlog and set it up with some values
		ProductBacklog productBacklog = new ProductBacklog();

		productBacklog.setName(this.getClass().getName() + "." + methodName
				+ "()");
		productBacklog.setProjectId(0);

		// Save to DB
		ProductBacklogDAOImpl dao = new ProductBacklogDAOImpl(sessionFactory);
		dao.createEntity(productBacklog);
		
		// Check Assertions
		checkAssertions(productBacklog);

	}

	/**
	 * Test method for {@link edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImpl#updateProductBacklog(edu.lmu.bfs.ase2.model.ProductBacklog)}.
	 * 
	 * @TestCriteria Test that a ProductBacklog's name can be updated on the DB -
	 *               uses Hibernate. Update Name on existing Product Backlog to a
	 *               different value
	 * 
	 * @ExpectedResults Existing Product Backlog updated to DB successfully.
	 * 
	 */
	@Test
	public void testUpdateProductBacklogName() {
		String methodName = "testUpdateProductBacklogName";

		// create the Product Backlog to test.
		ProductBacklog productBacklog = new ProductBacklog();

		productBacklog.setName(this.getClass().getName() + "." + methodName
				+ "()");
		productBacklog.setProjectId(0);

		// Save to DB
		ProductBacklogDAOImpl dao = new ProductBacklogDAOImpl(sessionFactory);
		dao.createEntity(productBacklog);

		// Check Assertions before doing the update
		checkAssertions(productBacklog);

		// Test updating the ProductBacklog
		productBacklog.setName(productBacklog.getName() + " - Updated");

		// Save to DB
		dao.updateEntity(productBacklog);

		// Check Assertions
		checkAssertions(productBacklog);

	}
	
	
	/**
	 * Test method for {@link edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImpl#updateProductBacklog(edu.lmu.bfs.ase2.model.ProductBacklog)}.
	 * 
	 * @TestCriteria Test that a ProductBacklog's user stories can be updated on the DB -
	 *               uses Hibernate. Update User stories on existing Product Backlog
	 * 
	 * @ExpectedResults Existing Product Backlog updated to DB successfully.
	 * 
	 */
	@Test
	public void testUpdateProductBacklogUserStories() {
		String methodName = "testUpdateProductBacklogUserStories";

		// create the Product Backlog to test.
		ProductBacklog productBacklog = new ProductBacklog();

		productBacklog.setName(this.getClass().getName() + "." + methodName
				+ "()");
		productBacklog.setProjectId(0);

		// Save to DB
		ProductBacklogDAOImpl dao = new ProductBacklogDAOImpl(sessionFactory);
		dao.createEntity(productBacklog);
		
		ProductBacklog savedProductBacklog = (ProductBacklog) dao.getEntityById(productBacklog.getId());

		// Check Assertions before doing the update
		checkAssertions(productBacklog, savedProductBacklog);

		// Add some user stories
		UserStory us = new UserStory();
		us.setProductBacklog(savedProductBacklog);
		us.setDescription(methodName + " User Story " + (savedProductBacklog.getUserStories().size()+1) + " for backlog " + savedProductBacklog.getId());
		us.setTitle(methodName + " User Story " + (savedProductBacklog.getUserStories().size()+1) + " for backlog " + savedProductBacklog.getId());
		savedProductBacklog.getUserStories().add(us);

		// Save to DB
		dao.updateEntity(savedProductBacklog);

		ProductBacklog savedProductBacklog2 = (ProductBacklog) dao.getEntityById(productBacklog.getId());

		// Check Assertions
		checkAssertions(savedProductBacklog, savedProductBacklog2);
		
		// make sure the user stories exist
		assertNotNull(savedProductBacklog2.getUserStories());
		assertNotEquals(0,savedProductBacklog2.getUserStories().size());

	}

	
	/**
	 * Test method for {@link edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImpl#updateProductBacklog(edu.lmu.bfs.ase2.model.ProductBacklog)}.
	 * 
	 * @TestCriteria Test that a ProductBacklog's Project ID can be updated on
	 *               the DB - uses Hibernate. Update Project on existing Product
	 *               Backlog to a different valid value
	 * 
	 * @ExpectedResults Existing Product Backlog updated to DB successfully.
	 *                  Note, there are currently no integrity constraints on
	 *                  Project Id. This test may need updating if constraints
	 *                  are added.
	 * 
	 */
	@Test
	public void testUpdateProductBacklogProjectId() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImpl#updateProductBacklog(edu.lmu.bfs.ase2.model.ProductBacklog)}.
	 * 
	 * @TestCriteria Attempt to update Product Backlog with an invalid ID (that
	 *               doesn't exist on the DB)
	 * 
	 * @ExpectedResults Should fail to update the DB. Record should not be added
	 *                  to the DB (as ID might be out of sequence)
	 * 
	 */
	@Test
	public void testUpdateProductBacklogInvalidId() {
		fail("Not yet implemented");
	}
	

	/**
	 * Test method for {@link edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImpl#deleteProductBacklog(edu.lmu.bfs.ase2.model.ProductBacklog)}.
	 */
	@Test
	public void testDeleteProductBacklog() {
		fail("Not yet implemented");
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
	public void testGetProductBacklogById() {
		String methodName = "testCreateProductBacklog";

		// Create a Product Backlog and set it up with some values
		ProductBacklog productBacklog = new ProductBacklog();

		productBacklog.setName(this.getClass().getName() + "." + methodName
				+ "()");
		productBacklog.setProjectId(0);

		// Save to DB
		ProductBacklogDAOImpl dao = new ProductBacklogDAOImpl(sessionFactory);
		dao.createEntity(productBacklog);
		
		// Check Assertions -- this calls GetProductBaklogById
		checkAssertions(productBacklog);

	}

	/**
	 * Test method for {@link edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImpl#getProductBacklogByProjectID(java.lang.Integer)}.
	 * 
	 * @TestCriteria Select Product Backlogs from DB By Profile ID
	 * 
	 * @ExpectedResults Existing Product Backlogs returned from DB successfully.
	 * 
	 */
	@Test
	public void testGetProductBacklogByProjectID() {
		// TODO set up some test data here, but for now, I know there are a bunch against project ID 0
		
		// Select from DB
		ProductBacklogDAOImpl dao = new ProductBacklogDAOImpl(sessionFactory);
		List<ProductBacklog> list = dao.getProductBacklogByProjectID(0);

		// Check Assertions
		assertFalse(0==list.size());
		
		// TODO set up assertions for the list elements

	}
	
	/**
	 * Test method for {@link edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImpl#getProductBacklogByProjectID(java.lang.Integer)}.
	 * 
	 * @TestCriteria Select Product Backlogs from DB By Profile ID
	 * 
	 * @ExpectedResults Existing Product Backlogs returned from DB successfully.
	 * 
	 */
	@Test
	public void testGetProductBacklogByProjectIDEmptyList() {

		// Select from DB - assumes there are no project Ids of -99
		ProductBacklogDAOImpl dao = new ProductBacklogDAOImpl(sessionFactory);
		List<ProductBacklog> list = dao.getProductBacklogByProjectID(-99);

		// Check Assertions
		assertEquals(0,list.size());


	}
	
	

}
