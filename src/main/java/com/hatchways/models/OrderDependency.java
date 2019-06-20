/**
 * 
 */
package com.hatchways.models;

/**
 * @author mypc
 *
 */
public class OrderDependency 
{
	public int id;
	public String namel;
	public int parent_id;
	
	
	public OrderDependency(int id, String namel, int parent_id) 
	{
		this.id = id;
		this.namel = namel;
		this.parent_id = parent_id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getNamel() {
		return namel;
	}
	public void setNamel(String namel) {
		this.namel = namel;
	}
	
	

}
