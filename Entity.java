package com.gamingroom;

public class Entity {

	protected long id;
	protected String name;
	
protected Entity() {}
	
	// Constructor with an identifier and name
	public Entity(long id, String name) {
		this.id = id;
		this.name = name;
	}

	// Method to allow returning the id
	public long getId() {
		return id;
	}
	
	// Method to allow returning the name
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + "]";
	}
}
