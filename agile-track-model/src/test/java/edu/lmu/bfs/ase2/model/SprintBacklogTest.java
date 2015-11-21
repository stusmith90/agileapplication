/**
 * 
 */
package edu.lmu.bfs.ase2.model;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Fran
 *
 */
public class SprintBacklogTest {

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
	 * Test method for {@link edu.lmu.bfs.ase2.model.SprintBacklog#setStartDate(java.util.Calendar)}.
	 */
	@Test
	public void testSetStartDate() {
		SprintBacklog sprintBacklog = new SprintBacklog();
		Calendar calendar = Calendar.getInstance();
		sprintBacklog.setStartDate(calendar);
		
		assertEquals(calendar, sprintBacklog.getStartDate());
	}

	/**
	 * Test method for {@link edu.lmu.bfs.ase2.model.SprintBacklog#setEndDate(java.util.Calendar)}.
	 */
	@Test
	public void testSetEndDate() {
		SprintBacklog sprintBacklog = new SprintBacklog();
		Calendar calendar = Calendar.getInstance();
		sprintBacklog.setEndDate(calendar);
		
		assertEquals(calendar, sprintBacklog.getEndDate());
	}

	/**
	 * @TestCriteria Attempt to add a Sprint Backlog with End Date before Start
	 *               Date
	 * 
	 * @ExpectedResults Should get an exception.
	 * 
	 */
	@Test
	public void testInvalidDateRangeEndBeforeStart() {
		fail("Not yet implemented");
	}

	/**
	 * @TestCriteria Attempt to add a Spring Backlog where start and end dates
	 *               are on same date
	 * 
	 * @ExpectedResults Should allow this.
	 */
	@Test
	public void testValidDateRangeEqualDates() {
		SprintBacklog sprintBacklog = new SprintBacklog();
		Calendar calendar = Calendar.getInstance();
		sprintBacklog.setStartDate(calendar);
		sprintBacklog.setEndDate(calendar);
		
		assertEquals(calendar, sprintBacklog.getStartDate());
		assertEquals(calendar, sprintBacklog.getEndDate());
		
		try {
			sprintBacklog.validate();
		}
		catch (Throwable t)
		{
			fail("Got Exception " + t);
		}
	}

	/**
	 * @TestCriteria Attempt to add a Spring Backlog where start and end dates
	 *               are on same date, but with time elements on the dates that
	 *               will make the date/time invalidly overlap
	 * @ExpectedResults Should allow this, as time should be irrelevant.
	 */
	@Test
	public void testSameDateOverlappingTimes() {
		fail("Not yet implemented");
	}

}
