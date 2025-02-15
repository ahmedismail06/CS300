import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Ballot {

  private static boolean ballotsCreated;
  private static ArrayList<Election> elections;
  private boolean[] hasVoted;

  /**
   * Represents a ballot for voting in elections. Manages the voting process and tracks if a voter has voted in each election.
   */
  public Ballot() {
    if (elections.size() <= 0) {
      throw new IllegalStateException("No Elections found");
    }
    this.hasVoted = new boolean[elections.size()];
    ballotsCreated = true;
  }
  /**
   * Adds a new election to the ballot if no ballots have been created yet.
   * 
   * @param election The election to be added.
   * @throws IllegalStateException if ballots have already been created.
   * @throws IllegalArgumentException if the election already exists.
   */
  public static void addElection(Election election) {
    if (ballotsCreated) {
      throw new IllegalStateException();
    }
    if (elections.contains(election)) {
      throw new IllegalArgumentException();
    }
    elections.add(election);
  }
  /**
   * Casts a vote for a candidate in a specified election by seat name.
   * 
   * @param seatName The name of the election seat.
   * @param candidate The candidate to vote for.
   * @throws IllegalStateException if the voter has already voted in this election.
   * @throws NoSuchElementException if the election or candidate is not found.
   */
  public void vote(String seatName, Candidate candidate) {
    // Step 1: Loop through the elections to find the election by seat name
    for (int i = 0; i < elections.size(); i++) {
      if (elections.get(i).SEAT_NAME.equalsIgnoreCase(seatName)) {

        // Step 2: Check if this ballot has already voted in this election
        if (hasVoted[i]) {
          throw new IllegalStateException();
        }

        // Step 3: If not, cast a vote and mark as voted
        try {
          elections.get(i).vote(candidate);
        }
        catch(NoSuchElementException e)
        {
          throw new NoSuchElementException();
        }
        
        hasVoted[i] = true;
        return; // Exit after voting to avoid unnecessary checks
      }
    }

    // Step 4: If no matching election is found, throw an exception
    throw new NoSuchElementException();
  }
  /**
   * Checks if the voter has already voted in the specified election.
   * 
   * @param seatName The name of the election seat.
   * @return true if the voter has voted; false otherwise.
   * @throws NoSuchElementException if the seat name is not valid.
   */
  public boolean hasVoted(String seatName) {
    for (int i = 0; i < elections.size(); i++) {
      if (elections.get(i).SEAT_NAME.equalsIgnoreCase(seatName)) {
        return hasVoted[i];
      }
    }
    throw new NoSuchElementException("Seat name is not valid");
  }
  /**
   * Returns a string representation of all elections.
   * 
   * @return A string listing all election seat names.
   */

  @Override
  public String toString() {
    String full = "";
    for (int i = 0; i < elections.size(); i++) {
      if (i != elections.size() - 1) {
        full += elections.get(i).SEAT_NAME + "\n";
      }
      full += elections.get(i).SEAT_NAME;
    }
    return full;
  }
  /**
   * Clears all elections and resets the ballot creation status.
   */
  public static void clearElections()
  {
    elections.clear();
    ballotsCreated = false;
  }

}
