/**
 * Library interface implementation
 * Created by ocouls01 - 14/12/2015
 */ 

import java.util.List;
import java.util.ArrayList;

public class LibraryImpl implements Library {
	private String name;
	private int maxBooksPerUser = 3;
	private List<UserRecord> userList = new ArrayList<UserRecord>();
	
	private List<Book> bookList = new ArrayList<Book>();
	
	private List<Book> takenList = new ArrayList<Book>();
	
	public LibraryImpl(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getID(String userName) {
		
		if (userList.isEmpty()) {
			UserRecord temp = new UserRecord(1, userName);
			return temp.userId;
		}
		else {
			int lastId = 0;
			for (UserRecord u : userList) {
				lastId = u.userId;
				if (u.userName.equals(userName)) {
					return u.userId;
				}
			}
			userList.add(userList.size(), new UserRecord(lastId + 1, userName));
			return lastId + 1;
			
			
			
		}
		
	
	}
	
	public int getMaxBooksPerUser() {
		return maxBooksPerUser;
	}
	
	public void setMaxBooksPerUser(int newMax) {
		this.maxBooksPerUser = newMax;
	}
	
	public boolean addBook(String title, String author) {
		if (bookList.isEmpty()) {
			bookList.add(new BookImpl(title, author));
			return true;
		} else {
			for (Book b : bookList) {
				if ((b.getTitle().equals(title)) && (b.getAuthor().equals(author))) {
					return false;
				}
			}
			
			bookList.add(new BookImpl(title, author));
			return true;
		}
	}
	
	public Book takeBook(String title) {
		Book temp = null;
		if (bookList.isEmpty()) {
			return null;
		}
		else {
			//The book is found in the list
			for (Book b : bookList) {
				if (b.getTitle().equals(title)) {
					takenList.add(b);
					temp = b;
					bookList.remove(b);
					return temp;
				}
			}
			//The book has been taken already
			for (Book b : takenList) {
				if (b.getTitle().equals(title)) {
					return null;
				}
			}
			
			//The book is not in the library catalogue
			return null;
		}
	}
	
	public boolean returnBook(Book book) {
		if (takenList.isEmpty()) {
			return false;
		} else {
			//Book was taken and is now returned
			for (Book b : takenList) {
				if (b.equals(book)) {
					bookList.add(b);
					takenList.remove(b);
					return true;
				} 
			}
			//Book wasn't marked as Taken
			return false;
		}
	}
	
	public int getReaderCount() {
		return userList.size();
	}
	
}