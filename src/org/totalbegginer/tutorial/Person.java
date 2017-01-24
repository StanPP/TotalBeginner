package org.totalbegginer.tutorial;

public class Person {
	
	// Fields
	private String name; // Person's name
	private int maximumBooks; // Maximum books a person can check out
	
	// constructor
	public Person() {
		
		name = "unknown name";
		maximumBooks = 3;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String anyName) {
		// set the name if it has not already been set
		// otherwise do not change it
		
		//The name being set cannot be zero in length
		if ((name == "unknown name") && (anyName.length()>0))
		{
			name = anyName;
		}
	}

	public int getMaximumBooks() {
		return maximumBooks;
	}

	public void setMaximumBooks(int maximumBooks) {
		this.maximumBooks = maximumBooks;
	}

	public String toString() {
		return getName() + " (" + getMaximumBooks() + " books)";
	}

	public void changeName(String newName) {
		// This is the method to change an existing name
		if ((name != "unknown name") && (newName.length() > 0))
		{
			name = newName;
		}
	}
}
