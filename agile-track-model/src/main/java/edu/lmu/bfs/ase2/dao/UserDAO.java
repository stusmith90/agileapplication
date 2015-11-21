/**
 * 
 */
package edu.lmu.bfs.ase2.dao;

import java.util.List;

import edu.lmu.bfs.ase2.model.User;


/**
 * Database Access Object Interface for a User
 * 
 * @author Fran
 *
 */
public interface UserDAO {
	
	/** 
	 * Add a User to the DB
	 * 
	 * @param backlog
	 */
	public void createUser(User User);

	/** 
	 * Update a User on the DB
	 * 
	 * @param backlog
	 */
	public void updateUser(User User);

	/**
	 * Delete a User from the DB
	 * 
	 * @param backlog
	 */
	public void deleteUser(User User);

	/**
	 * Select a User by Username. Assumes usernames are unique.
	 * 
	 * @param id Username of the User to return
	 * @return a single User
	 */
	public User getUserByUsername(String username);

	/**
	 * Select a User by Username
	 * 
	 * @param id ID of the User to return
	 * @return a single User 
	 */
	public User getUserById(Integer id);

	/**
	 * Select all Users by Role
	 * 
	 * @return a single User 
	 */
	public List<?> getUsersByRole(String role);

}
