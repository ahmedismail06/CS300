import java.util.ArrayList;

/**
 * Tests methods of Book and Library classes.
 */
public class LibraryTester {

  /**
   * TESTER METHOD: example test method for testing the getTitle method.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testGetTitle() {
    // Create a new book object
    Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
    // Test if the title is correctly returned
    return "1984".equals(book.getTitle());
  }

  /**
   * TESTER METHOD: example test method for testing the setTitle method.
   *
   * @return true if the test passes, false otherwise
   */
  public static boolean testSetTitle() {
    // Create a new book object
    Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
    // Set a new title
    book.setTitle("Animal Farm");
    // Check if the title was updated
    return "Animal Farm".equals(book.getTitle());
  }

  /**
   * Test method for the getAuthor method of the Book class.
   * 
   * @return true if the author is correctly returned, false otherwise
   */
  public static boolean testGetAuthor() {
    // Create a new book object
    Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
    // Check if the author is correctly returned
    return "George Orwell".equals(book.getAuthor());
  }

  /**
   * Test method for the setAuthor method of the Book class.
   * 
   * @return true if the author is correctly updated, false otherwise
   */
  public static boolean testSetAuthor() {
    // Create a new book object with a different author
    Book book = new Book("1984", "Ahmed Evan", 1949, "Secker & Warburg", 328);
    // Set a new author
    book.setAuthor("Ahmed Evan");
    // Check if the author was updated
    return "Ahmed Evan".equals(book.getAuthor());
  }

  /**
   * Test method for the getYearOfPublication method of the Book class.
   * 
   * @return true if the year of publication is correctly returned, false otherwise
   */
  public static boolean testGetYearOfPublication() {
    // Create a new book object
    Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
    // Check if the year of publication is correct
    return 1949 == book.getYearOfPublication();
  }

  /**
   * Test method for the setYearOfPublication method of the Book class.
   * 
   * @return true if the year of publication is correctly updated, false otherwise
   */
  public static boolean testSetYearOfPublication() {
    // Create a new book object
    Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
    // Set a new year of publication
    book.setYearOfPublication(2007);
    // Check if the year was updated
    return 2007 == book.getYearOfPublication();
  }

  /**
   * Test method for the getPublisher method of the Book class.
   * 
   * @return true if the publisher is correctly returned, false otherwise
   */
  public static boolean testGetPublisher() {
    // Create a new book object
    Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
    // Check if the publisher is correct
    return "Secker & Warburg".equals(book.getPublisher());
  }

  /**
   * Test method for the setPublisher method of the Book class.
   * 
   * @return true if the publisher is correctly updated, false otherwise
   */
  public static boolean testSetPublisher() {
    // Create a new book object
    Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
    // Set a new publisher
    book.setPublisher("Evan & Soham");
    // Check if the publisher was updated
    return "Evan & Soham".equals(book.getPublisher());
  }

  /**
   * Test method for the getNumberOfPages method of the Book class.
   * 
   * @return true if the number of pages is correct, false otherwise
   */
  public static boolean testGetNumberOfPages() {
    // Create a new book object
    Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
    // Check if the number of pages is correct
    return 328 == book.getNumberOfPages();
  }

  /**
   * Test method for the setNumberOfPages method of the Book class.
   * 
   * @return true if the number of pages is correctly updated, false otherwise
   */
  public static boolean testSetNumberOfPages() {
    // Create a new book object
    Book book = new Book("1984", "George Orwell", 1949, "Secker & Warburg", 328);
    // Set a new number of pages
    book.setNumberOfPages(543);
    // Check if the number of pages was updated
    return 543 == book.getNumberOfPages();
  }

  /**
   * Test method for getting the total number of books in the library.
   * 
   * @return true if the total number of books is correctly returned, false otherwise
   */
  public static boolean testGetTotalBooks() {
    // Create a new library object
    Library library = new Library();
    // Add two books to the library
    library.addBook(new Book("Book 1", "Author A", 2023, "Publisher Y", 200));
    library.addBook(new Book("Book 2", "Author B", 2023, "Publisher Z", 300));

    // Check if the total number of books is correct
    int expected = 2;
    int result = library.getTotalBooks();

    // Create a list of expected books
    ArrayList<Book> expectedA = new ArrayList<>();
    expectedA.add(new Book("Book 1", "Author A", 2023, "Publisher Y", 200));
    expectedA.add(new Book("Book 2", "Author B", 2023, "Publisher Z", 300));

    // Check if the total number of books matches the expected result
    if (expected != result) {
      return false;
    }

    // Output all books in the library for comparison
    System.out.println(library.getAllBooks());

    // Compare the expected books with the actual books in the library
    return compareBooks(expectedA, library.getAllBooks());
  }

  /**
   * Test method for adding a single book to the library.
   * 
   * @return true if the book is correctly added, false otherwise
   */
  public static boolean testAddBook() {
    // Create a new library object
    Library library = new Library();
    // Create a new book object and add it to the library
    Book book = new Book("Test Book", "Test Author", 2023, "Publisher X", 100);
    library.addBook(book);

    // Create a list of expected books with the newly added book
    ArrayList<Book> expected = new ArrayList<>();
    expected.add(new Book("Test Book", "Test Author", 2023, "Publisher X", 100));

    // Check if the book was added to the library correctly
    return compareBooks(expected, library.getAllBooks());
  }

  /**
   * Test method for adding multiple books to the library.
   * 
   * @return true if all books are correctly added, false otherwise
   */
  public static boolean testAddMultipleBooks() {
    // Create a new library object
    Library library = new Library();
    // Create and add two books to the library
    Book book = new Book("Test Book", "Test Author", 2023, "Publisher X", 100);
    Book book1 = new Book("Test1 Book", "Test1 Author", 2000, "Publisher1 X", 120);
    library.addBook(book);
    library.addBook(book1);

    // Create a list of expected books in the library
    ArrayList<Book> expected = new ArrayList<>();
    expected.add(new Book("Test1 Book", "Test1 Author", 2000, "Publisher1 X", 120));
    expected.add(new Book("Test Book", "Test Author", 2023, "Publisher X", 100));

    // Compare the expected and actual books in the library
    return compareBooks(expected, library.getAllBooks());
  }

  /**
   * Test method for removing a book by title from the library.
   * 
   * @return true if the book is correctly removed, false otherwise
   */
  public static boolean testRemoveBookByTitle() {
    // Create a new library object
    Library library = new Library();
    // Add a book to the library
    library.addBook(new Book("Test Book", "Test Author", 2023, "Publisher X", 100));

    // Attempt to remove the book by title
    boolean result = library.removeBookByTitle("Test Book");

    // Check if the book was successfully removed
    if (result != true) {
      return false;
    }

    // Ensure the library is now empty after removing the book
    if (!library.getAllBooks().isEmpty()) {
      return false;
    }

    // Return true if the removal was successful
    return true;
  }

  // Test removing one of many books from the library.
  public static boolean testRemoveOneOfManyBooks() {
    Library library = new Library();
    // Add two books to the library
    library.addBook(new Book("Test Book", "Test Author", 2023, "Publisher X", 100));
    library.addBook(new Book("Test1 Book", "Test1 Author", 2003, "Publisher1 X", 190));

    // Remove one of the books by its title
    boolean result = library.removeBookByTitle("Test1 Book");

    // Check if the removal was successful
    if (result != true) {
      return false;
    }

    // Ensure there is still at least one book left in the library
    if (library.getTotalBooks() == 0) {
      return false;
    }

    // Create the expected result, which contains only one remaining book
    ArrayList<Book> expected = new ArrayList<Book>();
    expected.add(new Book("Test Book", "Test Author", 2023, "Publisher X", 100));

    // Check if the remaining books in the library match the expected result
    if (!compareBooks(expected, library.getAllBooks())) {
      return false;
    }
    return true;
  }

  // Test finding books by a specific author in the library.
  public static boolean testFindBooksByAuthor() {
    Library library = new Library();
    // Add two books, only one of which has the desired author
    library.addBook(new Book("Test Book", "Test Author", 2023, "Publisher X", 100));
    library.addBook(new Book("Test1 Book", "Test1 Author", 2003, "Publisher1 X", 190));

    // Expected result should only include the book by "Test Author"
    ArrayList<Book> expected = new ArrayList<>();
    expected.add(new Book("Test Book", "Test Author", 2023, "Publisher X", 100));

    // Check if the books found by the author's name match the expected result
    if (!compareBooks(expected, library.findBooksByAuthor("Test Author"))) {
      return false;
    }
    return true;
  }

  // Test finding multiple books by the same author in the library.
  public static boolean testFindBooksByMultipleAuthors() {
    Library library = new Library();
    // Add multiple books, some by the same author, others by different authors
    library.addBook(new Book("Test Book", "Test Author", 2023, "Publisher X", 100));
    library.addBook(new Book("Test Book1", "Test Author", 2003, "Publisher1 X", 190));
    library.addBook(new Book("Test Book2", "Test2 Author", 2004, "Publisher2 X", 300));
    library.addBook(new Book("Test1 Book3", "Test3 Author", 2005, "Publisher3 X", 190));

    // Expected result contains only books by "Test Author"
    ArrayList<Book> expected = new ArrayList<>();
    expected.add(new Book("Test Book1", "Test Author", 2003, "Publisher1 X", 190));
    expected.add(new Book("Test Book", "Test Author", 2023, "Publisher X", 100));

    // Check if the books found by the author's name match the expected result
    if (!compareBooks(expected, library.findBooksByAuthor("Test Author"))) {
      return false;
    }
    return true;
  }

  // Test updating the title of a book in the library.
  public static boolean testUpdateBookTitle() {
    Library library = new Library();
    // Add a book to the library
    library.addBook(new Book("Test Book", "Test Author", 2023, "Publisher X", 100));

    // Update the title of the book
    library.updateBookTitle("Test Book", "Test Title");

    // Expected result is the same book with the updated title
    ArrayList<Book> expected = new ArrayList<>();
    expected.add(new Book("Test Title", "Test Author", 2023, "Publisher X", 100));

    // Check if the updated library matches the expected result
    if (!compareBooks(library.getAllBooks(), expected)) {
      return false;
    }
    return true;
  }

  // Test updating the titles of multiple books in the library.
  public static boolean testUpdateMultipleBookTitles() {
    Library library = new Library();
    // Add three books to the library
    library.addBook(new Book("Test Book", "Test Author", 2021, "Publisher X", 100));
    library.addBook(new Book("Test Book1", "Test Author", 2022, "Publisher X", 100));
    library.addBook(new Book("Test Book", "Test Author", 2023, "Publisher X", 100));

    // Update the titles of two of the books
    library.updateBookTitle("Test Book", "Test Title");
    library.updateBookTitle("Test Book1", "Test Title1");

    // Expected result contains the books with updated titles
    ArrayList<Book> expected = new ArrayList<>();
    expected.add(new Book("Test Title", "Test Author", 2021, "Publisher X", 100));
    expected.add(new Book("Test Title1", "Test Author", 2022, "Publisher X", 100));
    expected.add(new Book("Test Book", "Test Author", 2023, "Publisher X", 100));

    // Check if the library matches the expected result
    if (!compareBooks(library.getAllBooks(), expected)) {
      return false;
    }
    return true;
  }

  // Test updating the author of a book in the library.
  public static boolean testUpdateBookAuthor() {
    Library library = new Library();
    // Add a book to the library
    library.addBook(new Book("Test Book", "Test Author", 2023, "Publisher X", 100));

    // Update the author of the book
    library.updateBookAuthor("Test Book", "Ahmed");

    // Expected result contains the same book with an updated author
    ArrayList<Book> expected = new ArrayList<>();
    expected.add(new Book("Test Book", "Ahmed", 2023, "Publisher X", 100));

    // Check if the updated library matches the expected result
    if (!compareBooks(library.getAllBooks(), expected)) {
      return false;
    }
    return true;
  }

  // Test updating the authors of multiple books in the library.
  public static boolean testUpdateMultipleBookAuthors() {
    Library library = new Library();
    // Add two books to the library
    library.addBook(new Book("Test Book", "Test Author", 2023, "Publisher X", 100));
    library.addBook(new Book("Test Book1", "Test Author1", 2021, "Publisher X", 150));

    // Update the authors of both books
    library.updateBookAuthor("Test Book", "Ahmed");
    library.updateBookAuthor("Test Book1", "Evan");

    // Expected result contains the books with updated authors
    ArrayList<Book> expected = new ArrayList<>();
    expected.add(new Book("Test Book1", "Evan", 2021, "Publisher X", 150));
    expected.add(new Book("Test Book", "Ahmed", 2023, "Publisher X", 100));

    // Check if the updated library matches the expected result
    if (!compareBooks(library.getAllBooks(), expected)) {
      return false;
    }
    return true;
  }

  // Test attempting to remove a book that doesn't exist in the library.
  public static boolean testRemoveNonExistentBook() {
    Library library = new Library();
    // Add two books to the library
    library.addBook(new Book("Test Book", "Test Author", 2023, "Publisher X", 100));
    library.addBook(new Book("Test1 Book", "Test1 Author", 2003, "Publisher1 X", 190));

    // Try to remove a book that doesn't exist
    boolean result = library.removeBookByTitle("Test2 Book");

    // Ensure the result is false since the book doesn't exist
    if (result == true) {
      return false;
    }

    // Ensure the number of books remains unchanged
    if (library.getTotalBooks() != 2) {
      return false;
    }

    // Expected result contains the two books initially added
    ArrayList<Book> expected = new ArrayList<Book>();
    expected.add(new Book("Test Book", "Test Author", 2023, "Publisher X", 100));
    expected.add(new Book("Test1 Book", "Test1 Author", 2003, "Publisher1 X", 190));

    // Check if the library matches the expected result
    if (!compareBooks(expected, library.getAllBooks())) {
      return true; // This should be false, indicating failure, since nothing changed
    }
    return false;
  }


  /**
   * Compares two lists of books for equality.
   * 
   * @param expected the expected list of books
   * @param result   the list of books to compare
   * @return true if both lists contain the same books, false otherwise
   */
  private static boolean compareBooks(ArrayList<Book> expected, ArrayList<Book> result) {
    if (expected.size() != result.size()) {
      return false;
    }
    for (int i = 0; i < expected.size(); i++) {
      Book expectedBook = expected.get(i);
      Book resultBook = result.get(i);
      if (!expectedBook.getTitle().equals(resultBook.getTitle())
          || !expectedBook.getAuthor().equals(resultBook.getAuthor())
          || !(expectedBook.getPublisher().equals(resultBook.getPublisher()))
          || !(expectedBook.getNumberOfPages() == resultBook.getNumberOfPages())
          || !(expectedBook.getYearOfPublication() == resultBook.getYearOfPublication())) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    // test two functions in book.class
    System.out.println("Test getTitle: " + testGetTitle());
    System.out.println("Test setTitle: " + testSetTitle());
    System.out.println("Test getAuthor: " + testGetAuthor());
    System.out.println("Test setAuthor: " + testSetAuthor());
    System.out.println("Test getYearOfPublication: " + testGetYearOfPublication());
    System.out.println("Test setYearOfPublication: " + testSetYearOfPublication());
    System.out.println("Test getPublisher: " + testGetPublisher());
    System.out.println("Test setPublisher: " + testSetPublisher());
    System.out.println("Test getNumberOfPages: " + testGetNumberOfPages());
    System.out.println("Test setNumberOfPages: " + testSetNumberOfPages());
    System.out.println("Test addBook: " + testAddBook());
    System.out.println("Test addMultipleBooks: " + testAddMultipleBooks());
    System.out.println("Test removeBookByTitle: " + testRemoveBookByTitle());
    System.out.println("Test removeOneOfManyBooks: " + testRemoveOneOfManyBooks());
    System.out.println("Test findBooksByAuthor: " + testFindBooksByAuthor());
    System.out.println("Test findBooksByMultipleAuthors: " + testFindBooksByMultipleAuthors());
    System.out.println("Test updateBookTitle: " + testUpdateBookTitle());
    System.out.println("Test updateMultipleBookTitles: " + testUpdateMultipleBookTitles());
    System.out.println("Test updateBookAuthor: " + testUpdateBookAuthor());
    System.out.println("Test updateMultipleBookAuthors: " + testUpdateMultipleBookAuthors());
    System.out.println("Test removeNonExistentBook: " + testRemoveNonExistentBook());

  }
}
