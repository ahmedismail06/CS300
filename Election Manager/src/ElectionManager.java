
public class ElectionManager {

  /**
   * Checks if a candidate with the specified name and party exists in the list of candidates.
   * 
   * @param candidates - A 2D array where each row represents a candidate with [name, party, votes].
   * @param numCandidates - The number of candidates currently in the array.
   * @param name - The name of the candidate being searched for.
   * @param party - The party of the candidate being searched for.
   * @return true if a candidate with the given name and party is found, otherwise false.
   */
  public static boolean containsCandidate(String[][] candidates, int numCandidates, String name,
      String party) {
    if (numCandidates != 0) { // an if Statment that checks if the number of candidates is not equal
                              // to 0
      // A for loop to iterate through all elements of the 2D array (candidates)
      for (int i = 0; i < numCandidates; i++) {
        // Checks if both the name and party match for the current candidate if yes returns true
        if (candidates[i][1].equals(party) && candidates[i][0].equals(name)) {
          return true;
        }

      }
    }
    return false;
  }

  /**
   * Adds a new candidate to the candidates list, maintaining alphabetical order by name.
   * 
   * @param candidates - A 2D array where each row represents a candidate with [name, party,votes].
   * @param numCandidates - The number of candidates currently in the array.
   * @param name - The name of the candidate being searched for.
   * @param party - The party of the candidate being searched for.
   * @param numVoters - The number of votes the candidate has received.
   * @return The updated number of candidates in the list after the addition, or the original number
   * if no candidate is added.
   */
  public static int addCandidate(String[][] candidates, int numCandidates, String name,
      String party, int numVoters) {

    // Create the new candidate array
    String[] newCandidate = {name, party, String.valueOf(numVoters)};
    // Check if the candidate already exists or if numVoters is invalid
    if (containsCandidate(candidates, numCandidates, name, party) || numVoters < 0) {
      return numCandidates;
    }
    // Check if the array is full
    if (numCandidates >= candidates.length) {
      return numCandidates;
    }
    // Determine the correct index for insertion based on alphabetical order
    int index = numCandidates; // Default insertion point is at the end
    for (int i = 0; i < numCandidates; i++) {
      if (name.compareTo(candidates[i][0]) < 0) {
        index = i; // Set the index where the new candidate should be inserted
        break;
      }
    }
    // Shift elements to the right to make space for the new candidate
    for (int i = numCandidates; i > index; i--) {
      candidates[i] = candidates[i - 1];
    }
    // Insert the new candidate at the determined index
    candidates[index] = newCandidate;
    // Return the new size of the candidates list
    return numCandidates + 1;
  }


  /**
   * Removes a candidate from the list based on the provided name and party, shifting the remaining
   * candidates to maintain the order.
   * 
   * @param candidates- A 2D array where each row represents a candidate with [name, party, votes].
   * @param numCandidates - The number of candidates currently in the array.
   * @param name - The name of the candidate being searched for.
   * @param party - The party of the candidate being searched for.
   * @return The updated number of candidates after removal, or the original number if no candidate
   * was found.
   */
  public static int dropCandidate(String[][] candidates, int numCandidates, String name,
      String party) {
    // Loop through the list to find the candidate and party
    for (int i = 0; i < numCandidates; i++) {
      // Check if the current candidate's name and party match the given inputs
      if (candidates[i][0].equals(name) && candidates[i][1].equals(party)) {
        // Shift the remaining candidates to fill the gap left by the removed candidate
        for (int j = i; j < numCandidates - 1; j++) {
          candidates[j] = candidates[j + 1];
        }
        candidates[numCandidates - 1] = null;
        return numCandidates - 1; // Return updated candidate count
      }
    }
    return numCandidates; // If not found, return original number of candidates
  }


  /**
   * Determines the winner of an election based on vote counts. If one candidate receives more than
   * 50% of the votes, that candidate is declared the winner. If no candidate reaches this
   * threshold, the result is "CONTINGENT". If there is only one candidate, they are automatically
   * the winner.
   * 
   * @param candidates - A 2D array where each row represents a candidate with [name, party, votes].
   * @param numCandidates - The number of candidates currently in the array.
   * @return A string indicating the winning candidate and their percentage of votes, or
   * "CONTINGENT" if no majority is found.
   */
  public static String findWinner(String[][] candidates, int numCandidates) {
    int sum = 0;
    if (numCandidates < 2) {
      // If there is only one candidate, return their name, party with 100% of the votes
      return candidates[0][0] + " (" + candidates[0][1] + ") - " + "100.0%";
    }
    // Loop through all candidates to calculate the total sum of votes
    for (int i = 0; i < numCandidates; i++) {
      sum += Integer.valueOf(candidates[i][2]);
    }
    // Loop through the candidates again to find if any have more than 50% of the total votes
    for (int i = 0; i < numCandidates; i++) {
      if (((double) Integer.valueOf(candidates[i][2]) / sum) * 100 > 50.0) {
        double presentage = (double) Integer.valueOf(candidates[i][2]) / sum * 100.0; // Calculates
                                                                                      // the % of
                                                                                      // votes
        return candidates[i][0] + " (" + candidates[i][1] + ") - "
            + String.format("%,.1f", presentage) + "%"; // Return the winner's name, party,
        // and formatted percentage of votes to the nearest 10th
      }
    }
    return "CONTINGENT";
  }

  /**
   * Identifies the candidate with the lowest number of votes in the election. If there is only one
   * candidate, returns "UNCONTESTED".
   * 
   * @param candidates - A 2D array where each row represents a candidate with [name, party, votes].
   * @param numCandidates The current number of candidates in the array.
   * @return A string representing the lowest polling candidate in the format "name party -votes",
   * or "UNCONTESTED" if there is only one candidate.
   */
  public static String findLowestPollingCandidate(String[][] candidates, int numCandidates) {
    // If there is only one candidate or no contest, return "UNCONTESTED"
    if (numCandidates < 2) {
      return "UNCONTESTED";
    }
    // Initialize index to track the position of the candidate with the lowest votes
    // Set the initial minimum votes to the first candidate's vote count
    int index = 0;
    int min = Integer.valueOf(candidates[0][2]);
    // Loop through the candidate list to find the candidate with the lowest vote count
    // If the current candidate has fewer votes than the current minimum, update min and index
    for (int i = 0; i < numCandidates; i++) {
      if (Integer.valueOf(candidates[i][2]) < min) {
        min = Integer.valueOf(candidates[i][2]);
        index = i; // If the current candidate has fewer votes than the current minimum, update min
                   // and index
      }
    }
    // Return the lowest polling candidate's name, party, and vote count formatted as required
    return candidates[index][0] + " (" + candidates[index][1] + ") - " + candidates[index][2];
  }


}
