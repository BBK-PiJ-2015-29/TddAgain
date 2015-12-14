/**
 * Library interface
 * Created by ocouls01 - 14/12/2015
 */ 
 
public interface Library {
	
	String getName();
	
	int getID(String userName);
	
	int getMaxBooksPerUser();
	
	void setMaxBooksPerUser(int newMax);
	
	boolean addBook(String title, String author);
	
	Book takeBook(String title);
	
	boolean returnBook(Book book);
	
	int getReaderCount();
	
}