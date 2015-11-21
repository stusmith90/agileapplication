/**
 * @(#)SprintBacklog.java
 * 
 * @version 0.1.0 SNAPSHOT
 *
 * @since November 5, 2013
 * 
 * 
 */
package edu.lmu.bfs.ase2.model;

import java.util.Calendar;


/**
 * SprintBacklog. Direct subclass of the Backlog class. 
 * 
 * @author Fran
 *
 */
public class SprintBacklog extends Backlog {

	private Calendar startDate;
	private Calendar endDate;

	/**
	 * @return
	 */
	public Calendar getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 */
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
		
		// clear the time element so we are just left with a Date at midnight
		if ( this.startDate != null )
		{
			this.startDate.set(Calendar.HOUR_OF_DAY, this.startDate.getActualMinimum(Calendar.HOUR_OF_DAY));
			this.startDate.set(Calendar.MINUTE, this.startDate.getActualMinimum(Calendar.MINUTE));
			this.startDate.set(Calendar.SECOND, this.startDate.getActualMinimum(Calendar.SECOND));
			this.startDate.set(Calendar.MILLISECOND, this.startDate.getActualMinimum(Calendar.MILLISECOND));
		}
	}

	/**
	 * @return
	 */
	public Calendar getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 */
	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
		
		// clear the time element so we are just left with a Date at midnight
		if ( this.endDate != null )
		{
			this.endDate.set(Calendar.HOUR_OF_DAY, this.endDate.getActualMinimum(Calendar.HOUR_OF_DAY));
			this.endDate.set(Calendar.MINUTE, this.endDate.getActualMinimum(Calendar.MINUTE));
			this.endDate.set(Calendar.SECOND, this.endDate.getActualMinimum(Calendar.SECOND));
			this.endDate.set(Calendar.MILLISECOND, this.endDate.getActualMinimum(Calendar.MILLISECOND));
		}
		
	}

	/**
	 * Validate the object - before saving
	 * 
	 * @return true is successful. false otherwise. 
	 */
	public boolean validate() {
		throw new RuntimeException ("Not yet implemented"); // TODO
		
	}

}