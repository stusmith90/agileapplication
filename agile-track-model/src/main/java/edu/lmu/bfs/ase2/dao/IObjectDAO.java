/**
 * 
 */
package edu.lmu.bfs.ase2.dao;

import java.util.List;

/**
 * Database Access Object Interface for a all objects
 * 
 * @author Bamo
 *
 */
public interface IObjectDAO {
	

	public void createEntity(IMarkerEntity entity);


	public void updateEntity(IMarkerEntity entity);


	public void deleteEntity(IMarkerEntity entity);


	public Object getEntityById(Integer id);


	public List<IMarkerEntity> listEntity(IMarkerEntity entityName);

}
