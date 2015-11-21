/**
 * 
 */
package edu.lmu.bfs.ase2.dao;

import java.util.List;

import edu.lmu.bfs.ase2.model.ProductBacklog;

/**
 * @author Fran
 *
 */
public interface ProductBacklogDao extends IObjectDAO {
	
	List<ProductBacklog> getProductBacklogByProjectID(Integer projectId);
}
