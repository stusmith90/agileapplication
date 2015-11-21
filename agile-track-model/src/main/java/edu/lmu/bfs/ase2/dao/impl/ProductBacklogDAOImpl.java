/**
 * 
 */
package edu.lmu.bfs.ase2.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.lmu.bfs.ase2.dao.IMarkerEntity;
import edu.lmu.bfs.ase2.dao.IObjectDAO;
import edu.lmu.bfs.ase2.dao.ProductBacklogDao;
import edu.lmu.bfs.ase2.model.ProductBacklog;

/**
 * Database Access Object Implementation for a productBacklog
 * 
 * @author Bamo, Fran
 * 
 */
public class ProductBacklogDAOImpl implements ProductBacklogDao, IObjectDAO {

	private SessionFactory sessionFactory;

	/**
	 * Constructor - Used for passing in the Session Factory from JUnit tests
	 * 
	 * @param sessionFactory
	 *            A Connected SessionFactory
	 */
	public ProductBacklogDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	/** 
	 * Add a Sprint Backlog to the DB
	 * 
	 * @param backlog
	 */
	@Override
	public void createEntity(IMarkerEntity productBacklog) {
		this.sessionFactory.getCurrentSession().save(productBacklog);
	}

	/** 
	 * Update a productback on the DB
	 * 
	 * @param backlog
	 */
	@Override
	public void updateEntity(IMarkerEntity productBacklog) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(productBacklog);
	}

	/**
	 * Delete a product Backlog from the DB
	 * 
	 * @param backlog
	 */
	@Override
	public void deleteEntity(IMarkerEntity productBacklog) {
		this.sessionFactory.getCurrentSession().delete(productBacklog);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IMarkerEntity> listEntity(IMarkerEntity productBacklog) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM "+productBacklog.getClass().getName());
		return (List<IMarkerEntity>) query.list();
	}

	@Override
	public Object getEntityById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (IMarkerEntity) session.get(ProductBacklog.class, id);
	}
	
	/**
	 * Select a list of Product Backlogs by Project ID
	 * 
	 * @param projectId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBacklog> getProductBacklogByProjectID(Integer projectId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("getProductBacklogByProjectID");
		query = query.setInteger("projectId", projectId);
		
		return (List<ProductBacklog>) query.list();
	}


}
