package edu.lmu.bfs.ase2.service;

import java.util.List;

import edu.lmu.bfs.ase2.dao.impl.ProductBacklogDAOImpl;
import edu.lmu.bfs.ase2.dao.impl.SprintBacklogDAOImpl;
import edu.lmu.bfs.ase2.model.Backlog;
import edu.lmu.bfs.ase2.model.ProductBacklog;
import edu.lmu.bfs.ase2.model.SprintBacklog;

public class BacklogService extends ServiceHelper {

	/**
	 * Get a Backlog by ID
	 * 
	 * @param id
	 * @return the Backlog associated with the passed in ID
	 */
	public ProductBacklog getProductBacklogById(Integer id) {
		this.setUp();

		try {

			// Get All Product Backlogs for the given project ID
			ProductBacklogDAOImpl dao = new ProductBacklogDAOImpl(
					getSessionFactory());

			ProductBacklog backlog = (ProductBacklog) dao.getEntityById(id);

			return backlog;

		} finally {
			this.tearDown();
		}
	}
	
	/**
	 * Get a Sprint Backlog by ID
	 * 
	 * @param id
	 * @return the Backlog associated with the passed in ID
	 */
	public SprintBacklog getSprintBacklogById(Integer id) {
		this.setUp();

		try {

			// Get All Product Backlogs for the given project ID
			SprintBacklogDAOImpl dao = new SprintBacklogDAOImpl(
					getSessionFactory());

			SprintBacklog backlog = (SprintBacklog) dao.getSprintBacklogById(id);

			return backlog;

		} finally {
			this.tearDown();
		}
	}
	
	/**
	 * Get all sprint backlogs for a Project
	 * 
	 * @param projectId
	 * @return the Sprint Backlogs associated with the passed in project ID
	 */
	public List<SprintBacklog> getSprintBacklogByProjectId(Integer projectId) {
		this.setUp();

		try {

			// Get All Sprint Backlogs for the given project ID
			SprintBacklogDAOImpl dao = new SprintBacklogDAOImpl(
					getSessionFactory());

			List<SprintBacklog> backlogs = (List<SprintBacklog>) dao
					.getSprintBacklogByProjectID(projectId);

			return backlogs;

		} finally {
			this.tearDown();
		}
	}

	/**
	 * Get all product backlogs for a Project
	 * 
	 * @param projectId
	 * @return the Product Backlogs associated with the passed in project ID
	 */
	public List<ProductBacklog> getProductBacklogByProjectId(Integer projectId) {
		this.setUp();

		try {

			// Get All Product Backlogs for the given project ID
			ProductBacklogDAOImpl dao = new ProductBacklogDAOImpl(
					getSessionFactory());

			List<ProductBacklog> backlogs = (List<ProductBacklog>) dao
					.getProductBacklogByProjectID(projectId);

			return backlogs;

		} finally {
			this.tearDown();
		}
	}
	
	/**
	 * Insert or Update a Product backlog
	 * 
	 * @param productBacklog
	 */
	public void saveBacklog(ProductBacklog productBacklog)
	{
		this.setUp();

		try {

			// Get All Product Backlogs for the given project ID
			ProductBacklogDAOImpl dao = new ProductBacklogDAOImpl(
					getSessionFactory());

			dao.updateEntity(productBacklog);
			

		} finally {
			this.tearDown();
		}
	}

}
