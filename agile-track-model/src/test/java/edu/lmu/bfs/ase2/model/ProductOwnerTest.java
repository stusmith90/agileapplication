/**
 * 
 */
package edu.lmu.bfs.ase2.model;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Fran
 * 
 */
public class ProductOwnerTest {

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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link edu.lmu.bfs.ase2.model.User#setUsername(java.lang.String)}.
	 */
	@Test
	public void testSetUsername() {
		String methodName = "testSetUsername";

		ProductOwner po = new ProductOwner();
		po.setUsername(methodName);

		assertEquals(methodName, po.getUsername());
	}

	/**
	 * Test method for
	 * {@link edu.lmu.bfs.ase2.model.User#setPassword(java.lang.String)}.
	 */
	@Test
	public void testSetPassword() {
		String methodName = "testSetPassword";

		ProductOwner po = new ProductOwner();
		po.setPassword(methodName);

		assertEquals(methodName, po.getPassword());
	}

	/**
	 * Test method for
	 * {@link edu.lmu.bfs.ase2.model.User#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		String methodName = "testSetName";

		ProductOwner po = new ProductOwner();
		po.setName(methodName);

		assertEquals(methodName, po.getName());
	}

	/**
	 * Test method for {@link edu.lmu.bfs.ase2.model.User#getRole()}.
	 */
	@Test
	public void testGetRole() {
		ProductOwner po = new ProductOwner();
		assertEquals(ProductOwner.class.getName(), po.getRole());
	}

	/**
	 * Test method for
	 * {@link edu.lmu.bfs.ase2.model.User#setRole(java.lang.String)}.
	 */
	@Test
	public void testSetRole() {
		String methodName = "testSetRole";

		ProductOwner po = new ProductOwner();
		po.setRole(methodName);

		assertEquals(ProductOwner.class.getName(), po.getRole());
	}

	/**
	 * Test method for
	 * {@link edu.lmu.bfs.ase2.model.User#setId(java.lang.Integer)}.
	 */
	@Test
	public void testSetId() {
		ProductOwner po = new ProductOwner();
		po.setId(2);

		assertEquals(2, po.getUsername());
	}

}
