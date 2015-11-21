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
public class SystemAdminTest {

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

		SystemAdmin sa = new SystemAdmin();
		sa.setUsername(methodName);

		assertEquals(methodName, sa.getUsername());
	}

	/**
	 * Test method for
	 * {@link edu.lmu.bfs.ase2.model.User#setPassword(java.lang.String)}.
	 */
	@Test
	public void testSetPassword() {
		String methodName = "testSetPassword";

		SystemAdmin sa = new SystemAdmin();
		sa.setPassword(methodName);

		assertEquals(methodName, sa.getPassword());
	}

	/**
	 * Test method for
	 * {@link edu.lmu.bfs.ase2.model.User#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		String methodName = "testSetName";

		SystemAdmin sa = new SystemAdmin();
		sa.setName(methodName);

		assertEquals(methodName, sa.getName());
	}

	/**
	 * Test method for {@link edu.lmu.bfs.ase2.model.User#getRole()}.
	 */
	@Test
	public void testGetRole() {
		SystemAdmin sa = new SystemAdmin();
		assertEquals(SystemAdmin.class.getName(), sa.getRole());
	}

	/**
	 * Test method for
	 * {@link edu.lmu.bfs.ase2.model.User#setRole(java.lang.String)}.
	 */
	@Test
	public void testSetRole() {
		String methodName = "testSetRole";

		SystemAdmin sa = new SystemAdmin();
		sa.setRole(methodName);

		assertEquals(SystemAdmin.class.getName(), sa.getRole());
	}

	/**
	 * Test method for
	 * {@link edu.lmu.bfs.ase2.model.User#setId(java.lang.Integer)}.
	 */
	@Test
	public void testSetId() {
		SystemAdmin sa = new SystemAdmin();
		sa.setId(2);

		assertEquals(2, sa.getUsername());
	}

}
