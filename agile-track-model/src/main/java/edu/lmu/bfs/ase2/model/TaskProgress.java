/**
 * @(#)TaskProgress.java
 * 
 * @version 0.1.0 SNAPSHOT
 *
 * @since November 5, 2013
 * 
 * 
 */
package edu.lmu.bfs.ase2.model;

import java.util.Date;

import edu.lmu.bfs.ase2.dao.IMarkerEntity;

/**
 * @author bamo
 *
 */

public class TaskProgress implements IMarkerEntity{
	
	private Integer taskProgressId;
	private User user;
	private Task task;
	private int timeSpent;
	private int timeRemaining;
	private Date date;
	
	/**
	 * @return the taskProgressId
	 */
	public Integer getTaskProgressId() {
		return taskProgressId;
	}
	/**
	 * @param taskProgressId the taskProgressId to set
	 */
	public void setTaskProgressId(Integer taskProgressId) {
		this.taskProgressId = taskProgressId;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the task
	 */
	public Task getTask() {
		return task;
	}
	/**
	 * @param task the task to set
	 */
	public void setTask(Task task) {
		this.task = task;
	}
	/**
	 * @return the timeSpent
	 */
	public int getTimeSpent() {
		return timeSpent;
	}
	/**
	 * @param timeSpent the timeSpent to set
	 */
	public void setTimeSpent(int timeSpent) {
		this.timeSpent = timeSpent;
	}
	/**
	 * @return the timeRemaining
	 */
	public int getTimeRemaining() {
		return timeRemaining;
	}
	/**
	 * @param timeRemaining the timeRemaining to set
	 */
	public void setTimeRemaining(int timeRemaining) {
		this.timeRemaining = timeRemaining;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
}