/**
 * Implementation of the Book interface
 * Created by ocouls01 - 14/12/2015
 */
public class BookImpl implements Book {
	private String title;
	private String author;
	
	public BookImpl(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	
	public String getTitle() {
		return title;
	}
	
	
	public String getAuthor() {
		return author;
	}
	
}