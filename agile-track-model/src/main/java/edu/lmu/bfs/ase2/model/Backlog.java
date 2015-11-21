/**
 * @(#)Backlog.java
 * 
 * @version 0.1.0 SNAPSHOT
 *
 * @since November 5, 2013
 * 
 * 
 */
package edu.lmu.bfs.ase2.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Backlog is the backlog super class.
 * Known subclasses are SprintBacklog and ProductBacklog.
 * 
 * @author Fran
 *
 */

public abstract class Backlog {
	
	private Integer id;
	private Integer projectId;
	private List<UserStory> userStories = new ArrayList<UserStory>();
	
	/**
	 * @return the userStories
	 */
	public List<UserStory> getUserStories() {
		return userStories;
	}

	/**
	 * @param userStories the userStories to set
	 */
	public void setUserStories(List<UserStory> userStories) {
		this.userStories = userStories;
	}

	/**
	 * @return the projectId
	 */
	public Integer getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	private String name;
	

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
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	

	
	
}