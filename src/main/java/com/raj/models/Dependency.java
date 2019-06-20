/**
 * 
 */
package com.raj.models;

/**
 * @author mypc
 *
 */
public class Dependency 
{
	private int id;
	private int dependency_id;
	

	public Dependency(int id, int dependency_id) 
	{
		this.id = id;
		this.dependency_id = dependency_id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDependency_id() {
		return dependency_id;
	}
	public void setDependency_id(int dependency_id) {
		this.dependency_id = dependency_id;
	}

	
	
}
