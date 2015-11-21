/**
 * 
 */
package edu.lmu.bfs.ase2.service;

import java.util.List;

import edu.lmu.bfs.ase2.dao.impl.UserStoryDAOImpl;
import edu.lmu.bfs.ase2.model.UserStory;

/**
 * @author bamo
 * Purpose: act as a contract between the model layer and the GUI
 * for {@link UserStory} and GUI
 */
public class UserStoryService extends ServiceHelper {

	UserStory userStory; 
	UserStoryDAOImpl dao;
	/**
	 * starts the database connection
	 * inherits from super class {@link ServiceHelper}
	 */
	public UserStoryService() {
		this.setUp();
		userStory = new UserStory();
		dao = new UserStoryDAOImpl(getSessionFactory());
	}
	
	/**
	 * create a new userstory record in the database
	 */
	public void createUserStory(UserStory userStory){
		dao.createEntity(userStory);
	}

	/**
	 * @return java.util.List list of userstory
	 */
	public List findAll(){
			return dao.listEntity(userStory);
	}
	
	/**
	 * deletes a record of userstory in the database
	 * 
	 * @param userStory instance of userstory 
	 */
	public void delete(UserStory userStory){
		dao.deleteEntity(userStory);
		tearDown();
	}
	
	/**
	 * update userstory record in the database
	 * 
	 * @param userStory instance of {@link UserStory}
	 */
	public void update(UserStory userStory){
		dao.updateEntity(userStory);
	}
	
	public Object getUserStoryById(Integer id){
		UserStory userStory =  (UserStory) dao.getEntityById(id);
		//tearDown();
		return userStory;
	}

	public UserStory getUserStoryByBacklog(BacklogService backlogService) {
		return dao.getUserStoryByBacklog(backlogService.getProductBacklogById(12));
	}
}
