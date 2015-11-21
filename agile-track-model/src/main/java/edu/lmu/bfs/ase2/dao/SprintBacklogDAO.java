/**
 * 
 */
package edu.lmu.bfs.ase2.dao;

import java.util.List;

import edu.lmu.bfs.ase2.model.SprintBacklog;


/**
 * Database Access Object Interface for a SprintBacklog
 * 
 * @author Fran
 *
 */
public interface SprintBacklogDAO {
	
	/** 
	 * Add a Sprint Backlog to the DB
	 * 
	 * @param backlog
	 */
	public void createSprintBacklog(SprintBacklog sprintBacklog);

	/** 
	 * Update a SprintBacklog on the DB
	 * 
	 * @param backlog
	 */
	public void updateSprintBacklog(SprintBacklog sprintBacklog);

	/**
	 * Delete a Sprint Backlog from the DB
	 * 
	 * @param backlog
	 */
	public void deleteSprintBacklog(SprintBacklog sprintBacklog);

	/**
	 * Select a Sprint Backlog by ID
	 * 
	 * @param id ID of the Sprint Backlog to return
	 * @return a single SprintBacklog 
	 */
	public SprintBacklog getSprintBacklogById(Integer id);

	/**
	 * Select a list of Sprint Backlogs by Project ID
	 * 
	 * @param projectId
	 * @return
	 */
	public List<SprintBacklog> getSprintBacklogByProjectID(Integer projectId);

}
