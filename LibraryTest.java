/**
 * Junit tests for Library interface implementation
 * Created by ocouls01 - 14/12/2015
 */

import org.junit.*;
import static org.junit.Assert.*;

public class LibraryTest {
	private Library testLibrary;
	private int testID;
	
	@Before
	public void setUp() {
		testLibrary = new LibraryImpl("Test Library");
		testID = testLibrary.getID("Davy Jones");
		testLibrary.addBook("The Hobbit", "JRR Tolkien");
	}
	
	@Test
	public void testConstruction() {
		Library myLibrary = new LibraryImpl("TempLib");
		
		assertNotNull(myLibrary);
		assertEquals("TempLib", myLibrary.getName());
	}
	
	@Test
	public void testMaxBooksPerUser() {
		assertEquals(3, testLibrary.getMaxBooksPerUser());
		
		testLibrary.setMaxBooksPerUser(5);
		assertEquals(5, testLibrary.getMaxBooksPerUser());
	}
	
	@Test
	public void testNewGetIdByUserNameWhenUserDoesntExist() {
		int user1IdAtSet = testLibrary.getID("user1");
		
		int user1IdAfterSet = testLibrary.getID("user1");
		
		assertEquals(user1IdAtSet, user1IdAfterSet);
	}
	
	@Test
	public void testNewGetIdByUserNameWhenUserExists() {
		assertEquals(testID, testLibrary.getID("Davy Jones"));
	}
	
	@Test
	public void testAddBookWhereDoesntExist() {
		boolean test = testLibrary.addBook("Jurassic Park", "Michael Crichton");
		
		assertTrue(test);
	}
	
	@Test
	public void testAddBookWhereAlreadyExists() {
		boolean test = testLibrary.addBook("The Hobbit", "JRR Tolkien");
		
		assertFalse(test);
	}
	
	@Test
	public void testTakeBookWhereExists() {
		Book testBook = testLibrary.takeBook("The Hobbit");
		
		assertNotNull(testBook);
	}
	
	@Test
	public void testTakeBookWhereDoesntExist() {
		Book testBook = testLibrary.takeBook("Crime and Punishment");
		
		assertNull(testBook);
	}
	
	@Test
	public void testTakeBookFromEmptyLibrary() {
		Library emptyLibrary = new LibraryImpl("Empty Library");
		
		Book output = emptyLibrary.takeBook("The Hobbit");
		
		assertNull(output);
	}
	
	@Test
	public void testTakeBookOnTakenBook() {
		testLibrary.takeBook("The Hobbit");
		
		Book output = testLibrary.takeBook("The Hobbit");
		
		assertNull(output);
	}
	
	@Test
	public void testReturnBookOnTakenBook() {
		Book hobbit = testLibrary.takeBook("The Hobbit");
		
			
		boolean test = testLibrary.returnBook(hobbit);
		assertTrue(test);
		assertEquals(hobbit, testLibrary.takeBook("The Hobbit"));
	}
	
	@Test
	public void testReturnBookOnNonTakenBook() {
		testLibrary.addBook("Jurassic Park", "Michael Crichton");	
		Book jP = new BookImpl("Jurassic Park", "Michael Crichton");
		
		boolean test = testLibrary.returnBook(jP);
		assertFalse(test);
	}
	
	@Test
	public void testGetReaderCount() {
		
		assertEquals(1, testLibrary.getReaderCount());
		
		User u1 = new UserImpl("Danny");
		User u2 = new UserImpl("Jane");
		User u3 = new UserImpl("Arthur");
		
		u1.register(testLibrary);
		u2.register(testLibrary);
		u3.register(testLibrary);
		
		assertEquals(4, testLibrary.getReaderCount());
	}

}