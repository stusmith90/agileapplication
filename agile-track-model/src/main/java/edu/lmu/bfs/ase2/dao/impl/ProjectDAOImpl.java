/**
 * 
 */
package edu.lmu.bfs.ase2.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.lmu.bfs.ase2.dao.IMarkerEntity;
import edu.lmu.bfs.ase2.dao.IObjectDAO;
import edu.lmu.bfs.ase2.model.Project;

/**
 * @author Stuart
 *
 */
public class ProjectDAOImpl implements IObjectDAO {
	private SessionFactory sessionFactory;
	public ProjectDAOImpl(SessionFactory sessionFactory2) {
		this.sessionFactory = sessionFactory2;
		
	}

	/* (non-Javadoc)
	 * @see edu.lmu.bfs.ase2.dao.IObjectDAO#createEntity(edu.lmu.bfs.ase2.dao.IMarkerEntity)
	 */
	@Override
	public void createEntity(IMarkerEntity entity) {
		// TODO Auto-generated method stub
		// not required right now

	}

	/* (non-Javadoc)
	 * @see edu.lmu.bfs.ase2.dao.IObjectDAO#updateEntity(edu.lmu.bfs.ase2.dao.IMarkerEntity)
	 */
	@Override
	public void updateEntity(IMarkerEntity entity) {
		// TODO Auto-generated method stub
		// not required right now

	}

	/* (non-Javadoc)
	 * @see edu.lmu.bfs.ase2.dao.IObjectDAO#deleteEntity(edu.lmu.bfs.ase2.dao.IMarkerEntity)
	 */
	@Override
	public void deleteEntity(IMarkerEntity entity) {
		// TODO Auto-generated method stub
		// not required right now

	}

	/* (non-Javadoc)
	 * @see edu.lmu.bfs.ase2.dao.IObjectDAO#getEntityById(java.lang.Integer)
	 */
	@Override
	public Object getEntityById(Integer id) {
			Session session = this.sessionFactory.getCurrentSession();
			return (Project) session.get(Project.class, id);
	}

	/* (non-Javadoc)
	 * @see edu.lmu.bfs.ase2.dao.IObjectDAO#listEntity(edu.lmu.bfs.ase2.dao.IMarkerEntity)
	 */
	@Override
	public List<IMarkerEntity> listEntity(IMarkerEntity entityName) {
		// TODO Auto-generated method stub
		return null;
	}

}
