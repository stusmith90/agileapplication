/**
 * 
 */
package edu.lmu.bfs.ase2.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.lmu.bfs.ase2.dao.SprintBacklogDAO;
import edu.lmu.bfs.ase2.model.ProductBacklog;
import edu.lmu.bfs.ase2.model.SprintBacklog;

/**
 * Database Access Object Implementation for a SprintBacklog
 * 
 * @author Fran
 * 
 */
public class SprintBacklogDAOImpl implements SprintBacklogDAO {

	// this would be @Autowired for Spring framework
	private SessionFactory sessionFactory;

	/**
	 * Constructor - Used for passing in the Session Factory from JUnit tests
	 * 
	 * @param sessionFactory
	 *            A Connected SessionFactory
	 */
	public SprintBacklogDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	/** 
	 * Add a Sprint Backlog to the DB
	 * 
	 * @param backlog
	 */
	@Override
	public void createSprintBacklog(SprintBacklog sprintBacklog) {
		this.sessionFactory.getCurrentSession().save(sprintBacklog);
	}

	/** 
	 * Update a SprintBacklog on the DB
	 * 
	 * @param backlog
	 */
	@Override
	public void updateSprintBacklog(SprintBacklog sprintBacklog) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(sprintBacklog);
	}

	/**
	 * Delete a Sprint Backlog from the DB
	 * 
	 * @param backlog
	 */
	@Override
	public void deleteSprintBacklog(SprintBacklog sprintBacklog) {
		this.sessionFactory.getCurrentSession().delete(sprintBacklog);

	}

	/**
	 * Select a Sprint Backlog by ID
	 * 
	 * @param id ID of the Sprint Backlog to return
	 * @return a single SprintBacklog 
	 */
	@Override
	public SprintBacklog getSprintBacklogById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		
		return (SprintBacklog) session.get(SprintBacklog.class, id);
	}

	/**
	 * Select a list of Sprint Backlogs by Project ID
	 * 
	 * @param projectId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SprintBacklog> getSprintBacklogByProjectID(Integer projectId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("getSprintBacklogByProjectID");
		query = query.setInteger("projectId", projectId);
		
		return (List<SprintBacklog>) query.list();
	}

}
