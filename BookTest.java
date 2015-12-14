/**
 * Junit tests for book interface implementation
 * Created by ocouls01 - 14/12/2015
 */
 
import org.junit.*;
import static org.junit.Assert.*;

public class BookTest {
	@Test
	public void testConstruction() {
		Book myBook = new BookImpl("Jurassic Park", "Michael Crichton");
		
		assertNotNull(myBook);
		assertEquals("Jurassic Park", myBook.getTitle());
		assertEquals("Michael Crichton", myBook.getAuthor());
	}
}