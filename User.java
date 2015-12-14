/**
 * User interface
 * Created by ocouls01 - 14/12/2015
 */ 
public interface User {

	String getName();
	
	int getLibraryId();
	
	void register(Library library);
	
	Library getLibrary();
	
	
}