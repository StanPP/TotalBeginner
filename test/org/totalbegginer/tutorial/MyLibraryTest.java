package org.totalbegginer.tutorial;

import java.util.ArrayList;

import junit.framework.TestCase;

public class MyLibraryTest extends TestCase {
	
	//Fields needed across library tests
	private Book b1;
	private Book b2;
	private Person p1;
	private Person p2;
	private String strPerson1Name = "Fred";
	private String strPerson2Name = "Sue";
	private MyLibrary ml;
	
	// test constructor
	public void testMyLibrary() {
		ml = new MyLibrary("Test");
		
		assertEquals("Test", ml.name);
		
		assertTrue(ml.books instanceof ArrayList);
		assertTrue(ml.people instanceof ArrayList);
	}

	public void setup() {
		b1 = new Book ("Book1");
		b2 = new Book ("Book2");
		p1 = new Person();
		p2 = new Person();
		p1.setName(strPerson1Name);
		p2.setName(strPerson2Name);

		ml = new MyLibrary("Test");
	}
	
	public void testAddBook(){
		//set up test objects
		setup();
		
		//Initial size of list is zero
		assertEquals(0, ml.getBooks().size());
		
		//add two books
		ml.addBook(b1);
		ml.addBook(b2);
		assertEquals(2, ml.getBooks().size());  	//two books in the list
		assertEquals(0, ml.getBooks().indexOf(b1)); //b1 first
		assertEquals(1, ml.getBooks().indexOf(b2));	//b2 second
		
		//remove b1
		ml.removeBook(b1);
		assertEquals(1, ml.getBooks().size());  	//one book in the list
		assertEquals(0, ml.getBooks().indexOf(b2)); //b2 is now first
		
		//remove b2
		ml.removeBook(b2);
		assertEquals(0, ml.getBooks().size());  	//no books in the list
	}
	
	public void testAddPerson() {
		//set up test objects
		setup();
		
		//Initial size of list is zero
		assertEquals(0, ml.getPeople().size());

		//add two people
		ml.addPerson(p1);
		ml.addPerson(p2);
		assertEquals(2, ml.getPeople().size());  		//two people in the list
		assertEquals(0, ml.getPeople().indexOf(p1));	//p1 first
		assertEquals(1, ml.getPeople().indexOf(p2));	//p2 second
		
		//remove p1
		ml.removePerson(p1);
		assertEquals(1, ml.getPeople().size());  		//one person in the list
		assertEquals(0, ml.getPeople().indexOf(p2));	//p2 is now first
		
		//remove p2
		ml.removePerson(p2);
		assertEquals(0, ml.getPeople().size());  		//no people in the list		
	}
	
	public void testCheckoutBook() {
		//set up test objects
		setup();
		
		// setup books and people in test library
		ml.addBook(b1);
		ml.addBook(b2);
		ml.addPerson(p1);	//Fred - strPerson1Name
		ml.addPerson(p2);	//Sue - strPerson2Name
		
		
		// tests start here
		
		//check out b1 to p1
		assertTrue("Book did not check out correctly", ml.checkout(b1,p1));  //checkout functionality not yet implemented.
		
		assertEquals(strPerson1Name, b1.getPerson().getName());
		
		//try second checkout of book to someone else, this is not allowed
		assertFalse("Book was already checked out", ml.checkout(b1,p2));
		
		//Check in book 1, this is allowed
		assertTrue("Book check in failed", ml.checkIn(b1));
		
		//Attempt to check in the book again
		assertFalse("Book was already checked in", ml.checkIn(b1));
		
		//Attempt to check in a book that was never checked out
		assertFalse("Book was never checked out", ml.checkIn(b2));
		
		
		// Testing max book check out
		
		//set up test objects
		setup ();
		
		p1.setMaximumBooks(1);  //for person 1
		
		// setup books and people in test library
		ml.addBook(b1);
		ml.addBook(b2);
		ml.addPerson(p1);	//Fred - strPerson1Name
		ml.addPerson(p2);	//Sue - strPerson2Name	
		
		assertTrue("First book did not check out", ml.checkout(b2, p1));
		
		assertFalse("Second book should not have checked out", ml.checkout(b1, p1));
		
		
		
	}
	
	public void testCheckInBook() {
		fail ("not implemented");
	}
	
	public void testGetAvailableBooks() {
		fail ("not implemented");
	}
	
	public void testGetCheckedOutBooks() {
		fail ("not implemented");
	}
	
	public void testGetBooksForPerson() {
		fail ("not implemented");
	}
	
}
