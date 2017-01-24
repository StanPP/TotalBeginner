package org.totalbegginer.tutorial;

import junit.framework.TestCase;

public class PersonTest extends TestCase {

	public void testPerson() {
		Person p1 = new Person();
		
		//ensure initial conditions are set
		assertEquals("unknown name", p1.getName());
		assertEquals(3, p1.getMaximumBooks());
	}

	public void testSetName() {
		Person p1 = new Person();
		
		// Set an ordinary name
		p1.setName("Stanley");
		assertEquals("Stanley", p1.getName());
	}

	public void testSetNameNotZeroLength() {
		Person p1 = new Person();
		
		// Try and set a zero length name
		p1.setName("");
		assertEquals("unknown name", p1.getName());
	}
	
	public void testSetMaximumBooks() {
		Person p1 = new Person();
		
		// Set a value for Max books
		p1.setMaximumBooks(7);
		assertEquals(7, p1.getMaximumBooks());
		
		// test for a large range of values
		for(int i=0; i<100000; i++){
        
			p1.setMaximumBooks(i);
			assertEquals(i, p1.getMaximumBooks());
       }		
	}

	public void testSetNameUnique() {
		Person p1 = new Person();
		
		// Set an ordinary name
		p1.setName("Stanley");
		assertEquals("Stanley", p1.getName());
		
		// Should not be able to change the name once it has been set
		p1.setName("Eric");
		assertEquals("Stanley", p1.getName());
	}
	
	public void testChangeName() {
		Person p1 = new Person();
		
		//Test 1
		// Cannot use changeName until the name is set
		p1.changeName("George");
		assertEquals("unknown name", p1.getName());
		
		// Test 2
		// Should be able to change the name once it has been set
		// Set an ordinary name
		p1.setName("Stanley");
		assertEquals("Stanley", p1.getName());
		// change the name
		p1.changeName("Fred");
		assertEquals("Fred", p1.getName());
		
		// Test 3
		// Should not be able to change to a zero length name
		p1.changeName("");
		assertEquals("Fred", p1.getName());
	}
	
	public void testToString() {
		Person p4 = new Person();
		p4.setName("Fred Flintstone");
		p4.setMaximumBooks(9);
		
		String testString = "Fred Flintstone (9 books)";
		assertEquals(testString, p4.toString());
	}
	
}
