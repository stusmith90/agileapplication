/**
 * @(#)Task.java
 * 
 * @version 0.1.0 SNAPSHOT
 *
 * @since November 5, 2013
 * 
 * 
 */
package edu.lmu.bfs.ase2.model;

import java.util.HashSet;
import java.util.Set;

import edu.lmu.bfs.ase2.dao.IMarkerEntity;

/**
 * @author bamo
 *
 */

public class Task implements IMarkerEntity{
	

	/**
	 * task id in the database
	 */
	private int taskId;
	
	/**
	 * an instance of {@link UserStory} with which this class associated with
	 * 
	 */
	private UserStory userStory;
	
	/**
	 *  the name of the task
	 */
	private String name;
	
	/**
	 * description of the task
	 */
	private String description;
	
	/**
	 * references the id of the user table in the database.
	 * this variable used to find out who is assigned to this task
	 */
	private ProductOwner productOwner;
	
	/**
	 * the estimated hour allocated to this task
	 * 
	 */
	private int estimate;
	
	/**
	 *  status of the task
	 */
	private String status;
	
	private Set<TaskProgress> taskProgressSet = new HashSet<TaskProgress>();

	/**
	 * check if task assigned to a user
	 * @return Boolean
	 */
	public Boolean isAssigned(){
		return getProductOwner() != null ?  true : false;
	}

	/**
	 * @return the taskId
	 */
	public int getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	/**
	 * @return the {@link UserStory}
	 */
	public UserStory getUserStory() {
		return userStory;
	}

	/**
	 * @param userStory the {@link UserStory} to set
	 */
	public void setUserStory(UserStory userStory) {
		this.userStory = userStory;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the {@link productOnwer}
	 */
	public User getProductOwner() {
		return productOwner;
	}

	/**
	 * @param productOnwerId the {@link productOnwer} to set
	 */
	public void setProductOwner(ProductOwner productOwner) {
		this.productOwner = productOwner;
	}

	/**
	 * @return the estimate
	 */
	public int getEstimate() {
		return estimate;
	}

	/**
	 * @param estimate the estimate to set
	 */
	public void setEstimate(int estimate) {
		this.estimate = estimate;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the set of taskProgresses 
	 */
	public Set<TaskProgress> getTaskProgressSet() {
		return taskProgressSet;
	}

	/**
	 * @param taskProgresses the set of {@link TaskProgress} associated with this task
	 */
	public void setTaskProgressSet(Set<TaskProgress> taskProgressSet) {
		this.taskProgressSet = taskProgressSet;
	}
}