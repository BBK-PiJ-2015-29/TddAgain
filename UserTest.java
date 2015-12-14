/**
 * Junit tests for User interface implementation
 * Created by ocouls01 - 14/12/2015
 */

import org.junit.*;
import static org.junit.Assert.*;

public class UserTest {
	private User myUser;
	private Library tempLib;
	
	@Before 
	public void setUp() {
		myUser = new UserImpl("Davy Jones");
		tempLib = new LibraryImpl("Temp Lib");
	}
	
	@Test
	public void testConstruction() {
		User newUser = new UserImpl("John Doe");
		
		assertNotNull(newUser);
		assertEquals("John Doe", newUser.getName());
		assertEquals(0, newUser.getLibraryId());
	}
	
	@Test
	public void testRegisterMethod() {
		myUser.register(tempLib);
		assertEquals(2, myUser.getLibraryId());
		
	}
}
