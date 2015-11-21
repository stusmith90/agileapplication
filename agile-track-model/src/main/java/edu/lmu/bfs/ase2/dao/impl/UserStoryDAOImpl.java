/**
 * 
 */
package edu.lmu.bfs.ase2.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.apache.log4j.*;

import edu.lmu.bfs.ase2.dao.IMarkerEntity;
import edu.lmu.bfs.ase2.dao.IObjectDAO;
import edu.lmu.bfs.ase2.model.ProductBacklog;
import edu.lmu.bfs.ase2.model.UserStory;

/**
 * Database Access Object Implementation for a userStory
 * 
 * @author Bamo
 * 
 */
public class UserStoryDAOImpl implements IObjectDAO {

	// this would be @Autowired for Spring framework
	private SessionFactory sessionFactory;

	private static final Logger log = Logger.getLogger(UserStoryDAOImpl.class.getName());
	/**
	 * Constructor - Used for passing in the Session Factory from JUnit tests
	 * 
	 * @param sessionFactory
	 *            A Connected SessionFactory
	 */
	public UserStoryDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void createEntity(IMarkerEntity userStory) {
		log.debug("pessisting userStory instance");
		try{
			this.sessionFactory.getCurrentSession().save(userStory);
			log.debug("persist successful");
		}catch(RuntimeException re){
			log.error("persist failed", re);
			throw re;
		}
		
	}

	@Override
	public void updateEntity(IMarkerEntity userStory) {
		this.sessionFactory.getCurrentSession().update(userStory);
	}

	@Override
	public void deleteEntity(IMarkerEntity userStory) {
		this.sessionFactory.getCurrentSession().delete(userStory);
/*        if (this.sessionFactory.getCurrentSession() == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Author attached = Author.findAuthor(this.id);
            this.entityManager.remove(attached);
        }*/
	}

	@Override
	public Object getEntityById(Integer id) {
		if(!(id > 0)){
			log.error("the id should be greater than 0, the supplied id is: "+id);
		}
		Session session = this.sessionFactory.getCurrentSession();
		
		UserStory userStory = (UserStory) session.get(UserStory.class, id);
		if (userStory == null) {
			log.error("Query returned Null Object");
		}
		return userStory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IMarkerEntity> listEntity(IMarkerEntity userStory) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM "+userStory.getClass().getName());
		List<IMarkerEntity> userStories = query.list();
		return userStories;
	}
	
	@SuppressWarnings("unchecked")
	public List<IMarkerEntity> findTaskByUserStory(UserStory userStory) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT t FROM Task t WHERE t.userStory= :userStory");
		query.setParameter("userStory", userStory);
		return (List<IMarkerEntity>) query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<IMarkerEntity> findUserStoryByProductBacklog(IMarkerEntity productBacklog) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT U FROM UserStory U WHERE U.productBacklog = :productBacklog");
		query.setParameter("productBacklog", productBacklog);
		return (List<IMarkerEntity>) query.list();
	}

	public UserStory getUserStoryByBacklog(ProductBacklog productBacklog) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM UserStory WHERE backlogId = :productBacklog");
		query.setInteger("backlogId", productBacklog.getId());
		return null;
	}

}
