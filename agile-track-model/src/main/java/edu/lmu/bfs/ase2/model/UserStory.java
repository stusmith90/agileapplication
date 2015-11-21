/**
 * @(#)UserStory.java
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
 * @author Bamo
 *
 */

public class UserStory implements IMarkerEntity{
	
	
	/**
	 * the id of user story in the database
	 */
	private int id;
	
	/**
	 *  instance of {@link ProductBacklog} that this userStory belongs to
	 */
	private Backlog productBacklog;
	
	/**
	 * instance of {@link ProductOwner} that this userStory belongs to
	 */
	private User productOwner;

	/**
	 * The title of the user story
	 */
	private String	title;

	/**
	 * The description of the user story
	 */
	private String	description;

	/**
	 * The acceptance criteria  of the user story
	 */
	private String	acceptanceCriteria;
	
	/**
	 * the estimate point of the user story
	 */
	private int storyPointEstimate;
	
	/**
	 *  the priority of user story
	 */
	private int priority;
	
	/**
	 * set of {@link Task}s associated with this user story
	 */
	Set<Task> taskSet = new HashSet<Task>();
	
	/**
	 * @return the id
	 */
	
	public UserStory(){
	}
	
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	
	/**
	 * @return the {@link User}
	 */
	public User getProductOwner() {
		return productOwner;
	}

	/**
	 * @param productOwner the {@link User} to set
	 */
	public void setProductOwner(User productOwner) {
		this.productOwner = productOwner;
	}

	/**
	 * @return the {@link ProductBacklog}
	 */
	public Backlog getProductBacklog() {
		return productBacklog;
	}

	/**
	 * @param productBacklog the {@link ProductBacklog} to set
	 */
	public void setProductBacklog(Backlog productBacklog) {
		this.productBacklog = productBacklog;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the acceptanceCriteria
	 */
	public String getAcceptanceCriteria() {
		return acceptanceCriteria;
	}

	/**
	 * @param acceptanceCriteria the acceptanceCriteria to set
	 */
	public void setAcceptanceCriteria(String acceptanceCriteria) {
		this.acceptanceCriteria = acceptanceCriteria;
	}

	/**
	 * @return the storyPoint
	 */
	public int getStoryPointEstimate() {
		return storyPointEstimate;
	}

	/**
	 * @param storyPoint the storyPoint to set
	 */
	public void setStoryPointEstimate(int storyPointEstimate) {
		this.storyPointEstimate = storyPointEstimate;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * @return the taskSet
	 */
	public Set<Task> getTaskSet() {
		return taskSet;
	}

	/**
	 * @param taskSet the taskSet to set
	 */
	public void setTaskSet(Set<Task> taskSet) {
		this.taskSet = taskSet;
	}
	/**
	 * adds individual task
	 * @param task
	 */
	public void addTask(Task task){
		task.setUserStory(this);
		getTaskSet().add(task);
	}
	
	public boolean hasTask(){
		return getTaskSet().size() > 0 ? true : false;
	}
}