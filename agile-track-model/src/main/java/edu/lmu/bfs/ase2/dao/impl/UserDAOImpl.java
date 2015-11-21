/**
 * 
 */
package edu.lmu.bfs.ase2.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.lmu.bfs.ase2.dao.UserDAO;
import edu.lmu.bfs.ase2.model.User;

/**
 * Database Access Object Implementation for a User
 * 
 * @author Fran
 * 
 */
public class UserDAOImpl implements UserDAO {

	// this would be @Autowired for Spring framework
	private SessionFactory sessionFactory;

	/**
	 * Constructor - Used for passing in the Session Factory from JUnit tests
	 * 
	 * @param sessionFactory
	 *            A Connected SessionFactory
	 */
	public UserDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	/** 
	 * Add a User to the DB
	 * 
	 * @param backlog
	 */
	@Override
	public void createUser(User User) {
		this.sessionFactory.getCurrentSession().save(User);
	}

	/** 
	 * Update a User on the DB
	 * 
	 * @param backlog
	 */
	@Override
	public void updateUser(User User) {
		this.sessionFactory.getCurrentSession().update(User);
	}

	/**
	 * Delete a User from the DB
	 * 
	 * @param backlog
	 */
	@Override
	public void deleteUser(User User) {
		this.sessionFactory.getCurrentSession().delete(User);

	}

	/**
	 * Select a User by ID
	 * 
	 * @param id ID of the User to return
	 * @return a single User 
	 */
	@Override
	public User getUserById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		
		return (User) session.get(User.class, id);
	}

	@Override
	public User getUserByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("getUserByUsername");
		query = query.setString("username", username);
		
		return (User) query.uniqueResult();

	}

	@Override
	public List<?> getUsersByRole(String role) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("getUsersByRole");
		query = query.setString("role", role);
		
		return (List<?>) query.list();
	}

}
