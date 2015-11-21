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
public class TeamMemberTest {

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

		TeamMember tm = new TeamMember();
		tm.setUsername(methodName);

		assertEquals(methodName, tm.getUsername());
	}

	/**
	 * Test method for
	 * {@link edu.lmu.bfs.ase2.model.User#setPassword(java.lang.String)}.
	 */
	@Test
	public void testSetPassword() {
		String methodName = "testSetPassword";

		TeamMember tm = new TeamMember();
		tm.setPassword(methodName);

		assertEquals(methodName, tm.getPassword());
	}

	/**
	 * Test method for
	 * {@link edu.lmu.bfs.ase2.model.User#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		String methodName = "testSetName";

		TeamMember tm = new TeamMember();
		tm.setName(methodName);

		assertEquals(methodName, tm.getName());
	}

	/**
	 * Test method for {@link edu.lmu.bfs.ase2.model.User#getRole()}.
	 */
	@Test
	public void testGetRole() {
		TeamMember tm = new TeamMember();
		assertEquals(TeamMember.class.getName(), tm.getRole());
	}

	/**
	 * Test method for
	 * {@link edu.lmu.bfs.ase2.model.User#setRole(java.lang.String)}.
	 */
	@Test
	public void testSetRole() {
		String methodName = "testSetRole";

		TeamMember tm = new TeamMember();
		tm.setRole(methodName);

		assertEquals(TeamMember.class.getName(), tm.getRole());
	}

	/**
	 * Test method for
	 * {@link edu.lmu.bfs.ase2.model.User#setId(java.lang.Integer)}.
	 */
	@Test
	public void testSetId() {
		TeamMember tm = new TeamMember();
		tm.setId(2);

		assertEquals(2, tm.getUsername());
	}

}
