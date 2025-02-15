import java.util.NoSuchElementException;
// Title: The Election class models an election process with functionalities to manage candidates
// and voting. It maintains an array of Candidate objects, tracks the number of candidates, and
// allows for adding, removing, and voting for candidates. It also includes methods to find the
// winner based on the votes received and to represent the election as a string.
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

public class Election {
  private Candidate candidates[];
  private int numCandidates;
  public final String SEAT_NAME;

  /**
   * Constructs an Election object with a specified seat name and maximum number of candidates.
   * 
   * @param seatName The name of the seat for the election.
   * @param maxCandidates The maximum number of candidates allowed in the election.
   * @throws IllegalArgumentException if maxCandidates is less than or equal to 0.
   */
  public Election(String seatName, int maxCandidates) {
    if (maxCandidates <= 0) {
      throw new IllegalArgumentException();
    }
    this.SEAT_NAME = seatName;
    this.candidates = new Candidate[maxCandidates];
    this.numCandidates = 0;
  }
  /**
   * Returns the current number of candidates in the election.
   * 
   * @return The number of candidates currently registered in the election.
   */
  public int getNumCandidates() {
    int sum = 0;
    for (int i = 0; i < candidates.length; i++) {
      if (candidates[i] != null) {
        sum++;
      }
    }
    return sum;
  }
  /**
   * Returns the maximum capacity of candidates that can be added to the election.
   * 
   * @return The maximum number of candidates that can be accommodated.
   */
  public int capacity() {
    return candidates.length;
  }
  /**
   * Adds a candidate to the election if not already present.
   * 
   * @param candidate The candidate to be added.
   * @throws IllegalArgumentException if the candidate is null or a duplicate.
   * @throws IllegalStateException if there is no space to add a new candidate.
   */

  public void addCandidate(Candidate candidate) {
    if (candidate == null) {
      throw new IllegalArgumentException("Candidate cannot be null.");
    }

    // Check for duplicates by comparing to each current candidate in the list
    for (int i = 0; i < numCandidates; i++) {
      if (candidates[i] != null && candidates[i].equals(candidate)) {
        throw new IllegalArgumentException("Duplicate candidate.");
      }
    }

    // Ensure there is room to add a new candidate
    if (numCandidates >= candidates.length) {
      throw new IllegalStateException("No space to add new candidate.");
    }

    // Add the new candidate to the array and increment numCandidates
    candidates[numCandidates] = candidate;
    numCandidates++;
  }


  /**
   * Removes a specified candidate from the election.
   * 
   * @param candidate The candidate to be removed.
   * @throws IllegalStateException if there are no candidates to remove.
   * @throws NoSuchElementException if the candidate is not found.
   */

  public void removeCandidate(Candidate candidate) {
    if (numCandidates == 0) {
      throw new IllegalStateException();
    }

    boolean found = false;
    for (int i = 0; i < numCandidates; i++) {
      if (candidates[i] != null && candidates[i].equals(candidate)) {
        found = true;
        // Shift elements to the left
        for (int j = i; j < numCandidates - 1; j++) {
          candidates[j] = candidates[j + 1];
        }
        // Set the last element to null and decrease numCandidates
        candidates[numCandidates - 1] = null;
        numCandidates--;
        break;
      }
    }

    if (!found) {
      throw new NoSuchElementException("Candidate not found.");
    }
  }

  /**
  * Determines the winner of the election based on the number of votes received.
  * 
  * @return The winning candidate if a candidate has received more than 50% of the votes.
  * @throws IllegalStateException if there are no candidates in the election.
  * @throws NoSuchElementException if no candidate received more than 50% of the votes.
  */

  public Candidate findWinner() {
    if (numCandidates == 0) {
      throw new IllegalStateException();
    }
    int sum = 0;
    int max = candidates[0].getNumVotes();
    int index = 0;
    if (numCandidates == 0) {
      throw new IllegalStateException();
    }
    for (int i = 0; i < candidates.length; i++) {
      sum += candidates[i].getNumVotes();
      if (candidates[i].getNumVotes() > max) {
        max = candidates[i].getNumVotes();
        index = i;
      }
    }
    if ((max / sum * 100 > 50)) {
      return candidates[index];
    }
    throw new NoSuchElementException();
  }
  /**
   * Casts a vote for a specified candidate.
   * 
   * @param candidate The candidate to receive the vote.
   * @throws NoSuchElementException if the candidate is not found.
   */
  public void vote(Candidate candidate) {
    boolean voted = false;
    for (int i = 0; i < candidates.length; i++) {
      if (candidates[i] != null && candidates[i].equals(candidate)) {
        candidates[i].addVote();
        voted = true;
        return;
      }
    }
    if (!voted) {
      throw new NoSuchElementException();
    }
  }
  /**
   * Returns a string representation of the election, including the seat name and candidates.
   * 
   * @return A string representation of the election.
   */
  @Override
  public String toString() {
    String full = "";
    for (int i = 0; i < candidates.length; i++) {
      if (i != candidates.length - 1) {
        full += candidates[i].toString() + "/n";
      }
      full += candidates[i].toString();
    }
    return SEAT_NAME + "/n" + full;
  }
  /**
   * Checks if this Election object is equal to another object.
   * 
   * @param anObject The object to compare against.
   * @return true if the objects are equal; false otherwise.
   */
  @Override
  public boolean equals(Object anObject) {
    if (anObject instanceof Election) {
      if (((Election) anObject).SEAT_NAME.equalsIgnoreCase(SEAT_NAME)) {
        return true;
      }
    }
    return false;
  }



}
