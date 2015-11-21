/**
 * @(#)User.java
 * 
 * @version 0.1.0 SNAPSHOT
 *
 * @since November 5, 2013
 * 
 * 
 */
package edu.lmu.bfs.ase2.model;

/**
 * @author Fran
 * 
 */

public abstract class User {

	private Integer id;
	private String username;
	private String password;
	private String name;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return this.getClass().getName();
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		// dummy setter method - role is read only and derived from the concrete class name
	}

}