import java.util.ArrayList;
// Title: The Library class represents a collection of books. It provides methods to add, remove,
// update,
// and search for books within the collection. The books are stored in a list and are sorted by year
// of publication when added.
// Course: CS 300 Fall 2024
//
// Author: Ahmed Ismail
// Email: ismail9@wisc.edu
// Lecturer: Blerina Gkotse

//////////////////////// ASSISTANCE/HELP CITATIONS ////////////////////////////
//
// Persons:None
////////////////////////
// Online Sources: None
//
///////////////////////////////////////////////////////////////////////////////

public class Library {
  private ArrayList<Book> books; // List to store books in the library

  /**
   * Constructs an empty Library object and initializes the list of books.
   */
  public Library() {
    books = new ArrayList<Book>(); // Initialize the list of books
  }

  /**
   * Adds a book to the library in the correct position based on its year of publication. The books
   * are sorted in ascending order of their publication year.
   * 
   * @param book - The book to be added to the library.
   */
  public void addBook(Book book) {
    // Loop through the list to find the correct position based on the year of publication
    for (int i = 0; i < books.size(); i++) {
      // If the current book's year is greater, insert the new book before it
      if (books.get(i).getYearOfPublication() > book.getYearOfPublication()) {
        books.add(i, book); // Insert the book at the current index
        return; // Exit the method after insertion
      }
    }
    // If no earlier year was found, add the book at the end of the list
    books.add(book);
  }

  /**
   * Removes a book from the library based on its title.
   * 
   * @param title - The title of the book to be removed.
   * @return true - if the book was found and removed, false otherwise.
   */
  public boolean removeBookByTitle(String title) {
    // Loop through the list to find a book by title
    for (int i = 0; i < books.size(); i++) {
      // If the book title matches, remove it from the list
      if (books.get(i).getTitle().equals(title)) {
        books.remove(i); // Remove the book at the current index
        return true; // Return true if the book was found and removed
      }
    }
    return false; // Return false if no book with the given title was found
  }

  /**
   * Finds all books in the library written by a specific author.
   * 
   * @param author - The name of the author whose books are to be found.
   * @return An ArrayList of books written by the specified author.
   */
  public ArrayList<Book> findBooksByAuthor(String author) {
    ArrayList<Book> bookByAuthor = new ArrayList<Book>(); // Create a list to store books by the
                                                          // given author
    // Loop through the list to find books by the given author
    for (int i = 0; i < books.size(); i++) {
      // If the book's author matches, add it to the new list
      if (books.get(i).getAuthor().equals(author)) {
        bookByAuthor.add(books.get(i));
      }
    }
    return bookByAuthor; // Return the list of books by the author
  }

  /**
   * Returns the total number of books in the library.
   * 
   * @return The total number of books in the library.
   */
  public int getTotalBooks() {
    return books.size(); // Return the total number of books in the library
  }

  /**
   * Updates the title of a book in the library based on its current title.
   * 
   * @param oldTitle - The current title of the book.
   * @param newTitle - The new title for the book.
   * @return true if the book was found and the title was updated, false otherwise.
   */
  public boolean updateBookTitle(String oldTitle, String newTitle) {
    // Loop through the list to find the book with the old title
    for (int i = 0; i < books.size(); i++) {
      // If the book title matches the old title, update it to the new title
      if (books.get(i).getTitle().equals(oldTitle)) {
        books.get(i).setTitle(newTitle); // Set the new title
        return true; // Return true if the title was successfully updated
      }
    }
    return false; // Return false if no book with the old title was found
  }

  /**
   * Updates the author of a book in the library based on its title.
   * 
   * @param title     - The title of the book whose author is to be updated.
   * @param newAuthor - The new author for the book.
   * @return true if the book was found and the author was updated, false otherwise.
   */
  public boolean updateBookAuthor(String title, String newAuthor) {
    // Loop through the list to find the book with the given title
    for (int i = 0; i < books.size(); i++) {
      // If the book title matches, update the author
      if (books.get(i).getTitle().equals(title)) {
        books.get(i).setAuthor(newAuthor); // Set the new author
        return true; // Return true if the author was successfully updated
      }
    }
    return false; // Return false if no book with the given title was found
  }

  /**
   * Returns a list of all books in the library.
   * 
   * @return An ArrayList containing all books in the library.
   */
  public ArrayList<Book> getAllBooks() {
    ArrayList<Book> allList = new ArrayList<Book>(); // Create a new list to store all books
    // Loop through the books and add them to the new list
    for (Book book : books) {
      allList.add(book); // Add the current book to the list
    }
    return allList; // Return the list containing all books
  }

  /**
   * Prints the title and author of each book in the library.
   */
  public void printAllBooks() {
    // Loop through the books and print the title and author of each book
    for (int i = 0; i < books.size(); i++) {
      System.out
          .println("Title: " + books.get(i).getTitle() + ", Author: " + books.get(i).getAuthor());
    }
  }
}
