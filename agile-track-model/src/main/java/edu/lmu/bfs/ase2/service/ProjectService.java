package edu.lmu.bfs.ase2.service;

import edu.lmu.bfs.ase2.dao.impl.ProjectDAOImpl;
import edu.lmu.bfs.ase2.model.Project;

public class ProjectService extends ServiceHelper {

	/**
	 * Get a Project by ID
	 * 
	 * @param id
	 * @return the Project associated with the passed in ID
	 */
	public Project getProjectById(Integer id) {
		this.setUp();

		try {

			// Get All Product Backlogs for the given project ID
			ProjectDAOImpl dao = new ProjectDAOImpl(getSessionFactory());

			Project project = (Project) dao.getEntityById(id);

			return project;

		} finally {
			this.tearDown();
		}
	}

}
