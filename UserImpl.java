/**
 * Implementation of the User interface
 * Created by ocouls01 - 14/12/2015
 */
public class UserImpl implements User {
	private String name;
	private int libraryId;
	private Library library;
	
	public UserImpl(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getLibraryId() {
		return libraryId;
	}
	
	public void register(Library library) {
		libraryId = library.getID(getName());
		this.library = library;
	}
	
	public Library getLibrary() {
		return library;
	}
	
}