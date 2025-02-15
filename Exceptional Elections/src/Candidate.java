import java.util.NoSuchElementException;
// Title: The Candidate class represents a candidate in an election, encapsulating their name, party
// affiliation, and the number of votes received. It includes methods for incrementing votes,
// retrieving the vote count, and providing a string representation of the candidate. The class also
// overrides the equals method to compare candidates based on their string representations.
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
public class Candidate {
  private String name;
  private int numVotes;
  private String party;

  /**
   * Represents a candidate in an election with a name, party affiliation, and number of votes.
   * 
   * @param name  The name of the candidate.
   * @param party The party affiliation of the candidate.
   * @throws IllegalArgumentException if name or party is null or blank.
   */

  public Candidate(String name, String party) {
    if (name == null || name.isBlank() || party == null || party.isBlank()) {
      throw new IllegalArgumentException();
    } else {
      this.name = name;
      this.party = party;
      this.numVotes = 0;
    }
  }

  /**
   * Returns the number of votes received by the candidate.
   * 
   * @return The number of votes.
   */
  public int getNumVotes() {
    return numVotes;
  }

  /**
   * Increments the number of votes received by the candidate by one.
   */
  public void addVote() {
    this.numVotes++;
  }

  /**
   * Returns a string representation of the candidate, including their name, party, and number of
   * votes.
   * 
   * @return A string representation of the candidate.
   */
  @Override
  public String toString() {
    return this.name + " (" + this.party + "): " + this.numVotes;
  }

  /**
   * Checks if this Candidate object is equal to another object.
   * 
   * @param anObject The object to compare against.
   * @return true if the objects are equal based on their string representations; false otherwise.
   */
  @Override
  public boolean equals(Object anObject) {
    if (anObject instanceof Candidate) {
      if (((Candidate) anObject).toString().equals(this.toString())) {
        return true;
      }
    }
    return false;
  }

}
