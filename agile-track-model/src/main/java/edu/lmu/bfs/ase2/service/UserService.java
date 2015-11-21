package edu.lmu.bfs.ase2.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import edu.lmu.bfs.ase2.dao.impl.UserDAOImpl;
import edu.lmu.bfs.ase2.model.TeamMember;
import edu.lmu.bfs.ase2.model.User;

public class UserService extends ServiceHelper {

	/**
	 * Get all Users that are Team Members and return them
	 * 
	 * @return List of TeamMember
	 */
	public List<TeamMember> getAllTeamMembers() {
		this.setUp();

		try {

			TeamMember user = new TeamMember();

			// Get Users by Role
			UserDAOImpl dao = new UserDAOImpl(getSessionFactory());

			@SuppressWarnings("unchecked")
			List<TeamMember> users = (List<TeamMember>) dao.getUsersByRole(user
					.getRole());

			return users;

		} finally {
			this.tearDown();
		}
	}

	/**
	 * Login using the username and password. If either the username or password
	 * are incorrect, an exception is thrown
	 * 
	 * @param username
	 *            Login Username
	 * @param password
	 *            Login Password
	 * @return The User object for the logged in user - may be any concrete User subclass
	 * @throws LoginException
	 *             if either the username or password are incorrect
	 */
	public User login(String username, String password) throws LoginException {
		this.setUp();

		User user = null;

		try {

			// Get User by Username, and then check the password
			UserDAOImpl dao = new UserDAOImpl(getSessionFactory());

			user = dao.getUserByUsername(username);

			// check the password
			if (user != null) {
				if (password != null && !password.equals(user.getPassword())) {
					// null out the user so an exception is raised later
					user = null;
				}
			}

			// Make sure we have logged in OK and got a User object back - if
			// not, throw an exception
			if (user == null) {
				throw new LoginException("Invalid username or password");
			}

			return user;

		} finally {
			this.tearDown();
		}

	}

}