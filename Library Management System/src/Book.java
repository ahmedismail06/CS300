
// Title: The Book class represents a book with details such as title, author, year of publication,
// publisher, and the number of pages. It includes validation for year of publication and
// number of pages to ensure the data is correct.
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


public class Book {
  private String title; // The title of the book
  private String author; // The author of the book
  private int yearOfPublication; // The year the book was published
  private String publisher; // The publisher of the book
  private int numberOfPages; // The number of pages in the book

  /**
   * Constructs a new Book object with the specified title, author, year of publication,
   * publisher, and number of pages. The year of publication and number of pages are validated
   * to ensure valid data.
   * 
   * @param title - The title of the book.
   * @param author-  The author of the book.
   * @param yearOfPublication - The year the book was published (must be > 0 and <= 2024).
   * @param publisher - The publisher of the book.
   * @param numberOfPages - The number of pages in the book (must be > 0).
   * @throws IllegalArgumentException if the year of publication is invalid or if the number of pages is <= 0.
   */
  public Book(String title, String author, int yearOfPublication, String publisher,
      int numberOfPages) {
    this.title = title;
    this.author = author;

    // Validate year of publication
    if (yearOfPublication <= 0) {
      throw new IllegalArgumentException("Year of publication cannot be negative or zero.");
    }
    if (yearOfPublication > 2024) {
      throw new IllegalArgumentException("Year of publication cannot be in the future.");
    }
    this.yearOfPublication = yearOfPublication;

    this.publisher = publisher;

    // Validate number of pages
    if (numberOfPages <= 0) {
      throw new IllegalArgumentException("Number of pages must be greater than zero.");
    }
    this.numberOfPages = numberOfPages;
  }

  /**
   * Sets the title of the book.
   * 
   * @param title - The new title of the book.
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Gets the title of the book.
   * 
   * @return The title of the book.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Sets the author of the book.
   * 
   * @param author The new author of the book.
   */
  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   * Gets the author of the book.
   * 
   * @return The author of the book.
   */
  public String getAuthor() {
    return author;
  }

  /**
   * Sets the year of publication of the book, ensuring it is valid.
   * 
   * @param yearOfPublication - The new year of publication.
   * @throws IllegalArgumentException if the year is invalid (<= 0 or > 2024).
   */
  public void setYearOfPublication(int yearOfPublication) {
    if (yearOfPublication <= 0) {
      throw new IllegalArgumentException("Year of publication cannot be negative.");
    }
    if (yearOfPublication > 2024) {
      throw new IllegalArgumentException("Year of publication cannot be in the future.");
    }
    this.yearOfPublication = yearOfPublication;
  }

  /**
   * Gets the year of publication of the book.
   * 
   * @return The year of publication.
   */
  public int getYearOfPublication() {
    return yearOfPublication;
  }

  /**
   * Sets the publisher of the book.
   * 
   * @param publisher - The new publisher of the book.
   */
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  /**
   * Gets the publisher of the book.
   * 
   * @return The publisher of the book.
   */
  public String getPublisher() {
    return publisher;
  }

  /**
   * Sets the number of pages in the book, ensuring it is valid.
   * 
   * @param numberOfPages - The new number of pages.
   * @throws IllegalArgumentException if the number of pages is <= 0.
   */
  public void setNumberOfPages(int numberOfPages) {
    if (numberOfPages <= 0) {
      throw new IllegalArgumentException("Negative number of pages isn't possible.");
    }
    this.numberOfPages = numberOfPages;
  }

  /**
   * Gets the number of pages in the book.
   * 
   * @return The number of pages.
   */
  public int getNumberOfPages() {
    return numberOfPages;
  }
}
