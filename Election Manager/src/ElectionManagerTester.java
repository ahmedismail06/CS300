

// Be sure to credit the outside help section in the file header

import java.util.Arrays;


public class ElectionManagerTester {

  /**
   * Tests the containsCandidate method to ensure it correctly returns false when searching for a
   * candidate in an empty candidate list. The test passes when the method properly handles the case
   * of a completely empty list with a size of 0.
   * 
   * @return boolean - true if the test passes, false if it fails.
   */
  public static boolean testContainsEmpty() {
    // Candidate list with only null entries, representing an empty list
    String[][] candidateList = {null, null, null, null, null, null};
    int size = 0;
    boolean expected = false;
    // Call the method to check if a candidate exists in the empty list
    boolean actuall = ElectionManager.containsCandidate(candidateList, size, null, null);
    if (actuall != expected) {
      return false;
    }
    return true;
  }

  /**
   * Tests the containsCandidate method to ensure it correctly returns false when the target
   * candidate (specified by name and party) does not exist in the candidate list. The test also
   * checks that the original candidate list remains unchanged after the method call.
   * 
   * @return boolean - true if the test passes, false if it fails.
   */
  public static boolean testDoesNotContain() {
    // Candidate list with name, party, and vote count; includes 3 null entries
    String[][] candidateList = {{"Slowpoke", "Water", "3"}, {"Squirtle", "Water", "127"},
        {"Wooper", "Water", "300"}, null, null, null};
    // Create a copy of the candidateList to check that the original list is not modified
    String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
    int size = 3;
    // Target candidate details (name and party) which do not exist in the list
    String targetName = "Woaper";
    String targetParty = "Wader";
    // Expected result is false, as the target candidate is not in the list
    boolean expected = false;
    // Call the method to check if the candidate exists in the list
    boolean actuall =
        ElectionManager.containsCandidate(candidateList, size, targetName, targetParty);
    if (actuall != expected) {
      return false;
    }
    if (!Arrays.deepEquals(candidateList, candidateCopy)) {
      return false;

    }
    return true; 
  }

  /**
   * PROVIDED TESTER METHOD: example test method for verifying whether a candidate has already been
   * added to the race.
   * 
   * NOTE: This method ONLY tests scenarios where the candidate IS PRESENT in the list; situations
   * where the candidate is not present or the list is empty should be tested in the other contains
   * tester methods.
   * 
   * @return false if any of the scenarios we test have results other than what we expect; true ONLY
   *         if all of our expectations are met by the method we are testing
   */
  public static boolean testDoesContain() {

    // (1a) set up the test variables
    String[][] candidateList = {{"Slowpoke", "Water", "3"}, {"Squirtle", "Water", "127"},
        {"Wooper", "Water", "300"}, null, null, null};
    String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
    int size = 3;
    String targetName = "Wooper";
    String targetParty = "Water";
    boolean expected = true;

    // (1b) call the method we are testing
    boolean actual =
        ElectionManager.containsCandidate(candidateList, size, targetName, targetParty);

    // (2) verify that the expected method return value and the actual return value match
    if (expected != actual)
      return false;

    // (3) since THIS method should not modify the array, check it against a copy we made
    if (!Arrays.deepEquals(candidateList, candidateCopy))
      return false;

    // (4) if we have not yet returned false, we can now return true as all tests have passed!
    return true;

  }

  /**
   * Tests the addCandidate method to ensure that a candidate can be successfully added to an empty
   * candidate list. The test checks if the new candidate is correctly inserted into the list, and
   * that the method returns the updated size of the list. It also verifies that the candidate list
   * has been modified correctly.
   *
   * @return boolean - true if the test passes, false if it fails.
   */
  public static boolean testAddToEmpty() {
    // Candidate list with only null entries, representing an empty list
    String[][] candidateList = {null, null, null};
    // New candidate details (name, party, and vote count)
    String newName = "Goldeen";
    String newParty = "Water";
    int newVotes = 5;
    // Expected list after the new candidate has been added; only two null values should remain
    String[][] expectedList = {{"Goldeen", "Water", "5"}, null, null}; // now only TWO null values
                                                                       // in this length-6 array!
    int size = 0;
    int expected = 1;
    // Call the method to add the new candidate to the list
    int actual = ElectionManager.addCandidate(candidateList, size, newName, newParty, newVotes);
    // If the actual size does not match the expected, the test fails
    if (expected != actual) {
      return false;
    }
    // If the modified list does not match the expected list, the test fails
    if (!Arrays.deepEquals(candidateList, expectedList)) {
      return false;
    }

    return true; 
  }

  /**
   * PROVIDED TESTER METHOD: example test method for verifying whether a new candidate has been
   * added correctly to the race.
   * 
   * @return false if any of the scenarios we test have results other than what we expect; true ONLY
   *         if all of our expectations are met by the method we are testing
   */
  public static boolean testAddToNonEmpty() {

    // (1a) set up the test variables
    String[][] candidateList = {{"Slowpoke", "Water", "3"}, {"Squirtle", "Water", "127"},
        {"Wooper", "Water", "300"}, null, null, null};
    String newName = "Goldeen";
    String newParty = "Water";
    int newVotes = 5;

    String[][] expectedList = {{"Goldeen", "Water", "5"}, // alphabetically first, new candidate
                                                          // will be added here
        {"Slowpoke", "Water", "3"}, {"Squirtle", "Water", "127"}, {"Wooper", "Water", "300"}, null,
        null}; // now only TWO null values in this length-6 array!
    int size = 3;
    int expected = 4;

    // (1b) call the method we are testing
    int actual = ElectionManager.addCandidate(candidateList, size, newName, newParty, newVotes);

    // (2) verify that the expected method return value and the actual return value match
    if (expected != actual)
      return false;

    // (3) this method modifies the input array; verify that it was modified correctly
    if (!Arrays.deepEquals(candidateList, expectedList))
      return false;

    // (4) if we have not yet returned false, we can now return true as all tests have passed!
    return true;
  }

  public static boolean testAddCandidateErrors() {
    String[][] candidateList =
        {{"Slowpoke", "Water", "3"}, {"Squirtle", "Water", "127"}, {"Wooper", "Water", "300"}};
    String newName = "Wooper";
    String newParty = "Water";
    int newVotes = 300;

    String[][] expectedList =
        {{"Slowpoke", "Water", "3"}, {"Squirtle", "Water", "127"}, {"Wooper", "Water", "300"}};
    int size = 3;
    int expected = 3;
    int actual = ElectionManager.addCandidate(candidateList, size, newName, newParty, newVotes);
    if (expected != actual) {
      return false;
    }
    if (!Arrays.deepEquals(candidateList, expectedList)) {
      return false;
    }

    return true; 
  }

  /**
   * Tests the addCandidate method to ensure that a new candidate is not added when the candidate
   * list is already full. The test checks that the list remains unchanged and the size remains the
   * same after attempting to add a new candidate to a full list.
   *
   * @return boolean - true if the test passes, false if it fails.
   */
  public static boolean testAddToFull() {
    // Candidate list with three valid candidates and no null entries for additional candidates
    String[][] candidateList =
        {{"Slowpoke", "Water", "3"}, {"Squirtle", "Water", "127"}, {"Wooper", "Water", "300"}};
    // New candidate details (name, party, and vote count)
    String newName = "Goldeen";
    String newParty = "Water";
    int newVotes = 5;
    // Expected list remains the same because the list is full, so no new candidate is added
    String[][] expectedList =
        {{"Slowpoke", "Water", "3"}, {"Squirtle", "Water", "127"}, {"Wooper", "Water", "300"}}; // now
                                                                                                // only
                                                                                                // TWO
                                                                                                // null
                                                                                                // values
                                                                                                // in
                                                                                                // this
                                                                                                // length-6
                                                                                                // array!
    int size = 3;
    int expected = 3;
    int actual = ElectionManager.addCandidate(candidateList, size, newName, newParty, newVotes);
    if (expected != actual) {
      return false;
    }
    if (!Arrays.deepEquals(candidateList, expectedList)) {
      return false;
    }

    return true; 
  }

  //// DROP CANDIDATE: one provided tester method, two (2) 
  /**
   * Tests the dropCandidate method to ensure it correctly removes the only candidate in the list,
   * leaving the list empty (all null values) and reducing the size to 0. The test verifies both
   * that the candidate is properly removed and that the size is updated accordingly.
   *
   * @return boolean - true if the test passes, false if it fails.
   */
  public static boolean testDropOnlyCandidate() {
    // Arrange: Set up the initial candidate list
    String[][] candidateList = {{"Slowpoke", "Water", "3"}, null, null};
    String[][] expectedList = {null, null, null}; // Expected after removing the only candidate
    String name = "Slowpoke";
    String party = "Water";
    int size = 1;
    int expectedSize = 0;

    // Act: Call the dropCandidate method
    int actualSize = ElectionManager.dropCandidate(candidateList, size, name, party);

    // Assert: Check if the returned size matches the expected size
    if (expectedSize != actualSize) {
      return false;
    }

    // Assert: Check if the array matches the expected outcome (candidate should be removed)
    if (!Arrays.deepEquals(candidateList, expectedList)) {
      return false;
    }

    return true; // If both checks pass, the test is successful
  }

  /**
   * Tests the dropCandidate method to ensure that it does not modify the candidate list or size
   * when attempting to drop a candidate who is not present in the list. The test checks that the
   * original candidate list remains unchanged and the size remains the same.
   *
   * @return boolean - true if the test passes, false if it fails.
   */
  public static boolean testDropFirstCandidate() {
    // Candidate list with three valid candidates and some null entries
    String[][] candidateList = {{"Slowpoke", "Water", "3"}, {"Squirtle", "Water", "127"},
        {"Wooper", "Water", "300"}, null, null, null};
    // Create a copy of the candidateList to ensure the original list is not modified
    String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
    String name = "Goldeen";
    String party = "Water";
    int size = 3;
    int expected = 3;
    // Call the method to drop the candidate from the list
    int actual = ElectionManager.dropCandidate(candidateList, size, name, party);
    if (expected != actual) {
      return false;
    }
    // If the candidate list has been modified, the test fails
    if (!Arrays.deepEquals(candidateList, candidateCopy)) {
      return false;
    }
    return true; 
  }

  /**
   * PROVIDED TESTER METHOD: example test method for verifying whether trying to drop a candidate
   * who is not running in the race correctly has NO effect on the candidate list.
   * 
   * @return false if any of the scenarios we test have results other than what we expect; true ONLY
   *         if all of our expectations are met by the method we are testing
   */
  public static boolean testDropCandidateNotRunning() {

    // (1a) set up the test variables
    String[][] candidateList = {{"Slowpoke", "Water", "3"}, {"Squirtle", "Water", "127"},
        {"Wooper", "Water", "300"}, null, null, null};
    String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
    String name = "Goldeen";
    String party = "Water";
    int size = 3;
    int expected = 3;

    // (1b) call the method we are testing
    int actual = ElectionManager.dropCandidate(candidateList, size, name, party);

    // (2) verify that the expected method return value and the actual return value match
    if (expected != actual)
      return false;

    // (2a) sometimes you may want to REPEAT the process with slightly different variables:
    name = "Slowpoke";
    party = "Fire"; // try with a name that's present but a different PARTY; should still not drop
    actual = ElectionManager.dropCandidate(candidateList, size, name, party);
    if (expected != actual)
      return false;

    // (3) this scenario should NOT modify the input array; check it against a copy we made
    if (!Arrays.deepEquals(candidateList, candidateCopy))
      return false;

    // (4) if we have not yet returned false, we can now return true as all tests have passed!
    return true;

  }

  /**
   * Tests the findWinner method to ensure it correctly identifies the winner in an uncontested
   * election. In this case, there is only one candidate, so the expected result is that candidate
   * with 100% of the votes. The test also ensures that the original candidate list remains
   * unchanged after the method call.
   *
   * @return boolean - true if the test passes, false if it fails.
   */
  public static boolean testUncontestedWinner() {
    // Candidate list with one valid candidate and three null entries
    String[][] candidateList = {{"Slowpoke", "Water", "3"}, null, null, null};
    // Create a copy of the candidateList to ensure the original list is not modified
    String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
    String expected = "Slowpoke (Water) - 100.0%";
    int size = 1;
    // Call the method to find the winner
    String result = ElectionManager.findWinner(candidateList, size);
    if (!result.equals(expected)) {
      return false;
    }
    if (!Arrays.deepEquals(candidateList, candidateCopy)) {
      return false;
    }
    return true; 
  }

  /**
   * PROVIDED TESTER METHOD: example test method for verifying the results of an election where one
   * candidate has received a clear majority of the votes cast.
   * 
   * @return false if any of the scenarios we test have results other than what we expect; true ONLY
   *         if all of our expectations are met by the method we are testing
   */
  public static boolean testClearWinner() {

    // (1a) set up the test variables
    String[][] candidateList = {{"Slowpoke", "Water", "3"}, {"Squirtle", "Water", "97"},
        {"Wooper", "Water", "300"}, null, null, null};
    String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
    String expectedName = "Wooper";
    String expectedParty = "(Water)";
    double expectedVotePct = 300.0 / (300 + 97 + 3) * 100;
    int size = 3;

    // (1b) call the method we are testing
    String result = ElectionManager.findWinner(candidateList, size);
    // (2) verify that the expected method return value and the actual return value match
    // NOTE: for a String, this takes a little more processing to do sensitively.
    // We expect this result to be "Wooper (Water) - 75.0%" but there may be some weirdness
    // especially with that percentage. See how we do it here:
    String[] resultPieces = result.split(" "); // get the space-separated pieces of the string

    if (resultPieces.length != 4)
      return false; // incorrect formatting
    if (!resultPieces[3].endsWith("%"))
      return false; // no % at the end

    if (!resultPieces[0].equals(expectedName) || !resultPieces[1].equals(expectedParty))
      return false; // wrong name or wrong party

    if (!resultPieces[2].equals("-"))
      return false; // forgot the "-" between party and %

    // do a range check on the calculated vote percentage, since it's not always going to come out
    // exactly the same:
    double actualVotePct =
        Double.valueOf(resultPieces[3].substring(0, resultPieces[3].length() - 1));
    if (Math.abs(actualVotePct - expectedVotePct) > 0.01)
      return false;

    // (3) this scenario should NOT modify the input array; check it against a copy we made
    if (!Arrays.deepEquals(candidateList, candidateCopy))
      return false;

    // (4) if we have not yet returned false, we can now return true as all tests have passed!
    return true;


  }

  /**
   * Tests the findWinner method to ensure it correctly identifies a contingent election scenario.
   * In this case, there is no clear winner (the candidate with the majority of votes), so the
   * expected result is "CONTINGENT." The test also verifies that the original candidate list
   * remains unchanged after the method call.
   *
   * @return boolean - true if the test passes, false if it fails.
   */
  public static boolean testContingentElection() {
    // Candidate list with names, party, and vote count; some null entries
    String[][] candidateList = {{"Slowpoke", "Water", "3"}, {"Squirtle", "Water", "5"},
        {"Wooper", "Water", "4"}, null, null, null};
    // Create a copy of the candidateList to ensure the original list is not modified
    String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
    // Expected result is "CONTINGENT" since there is no candidate with a clear majority
    String expected = "CONTINGENT";
    int size = 3;
    // Call the method to find the winner
    String result = ElectionManager.findWinner(candidateList, size);
    if (!result.equals(expected)) {
      return false;
    }
    if (!Arrays.deepEquals(candidateList, candidateCopy)) {
      return false;
    }
    return true; 
  }


  /**
   * Tests the findLowestPollingCandidate method to ensure it correctly identifies an uncontested
   * candidates. In this case, the candidate list has only one valid candidate, so the expected
   * result is "UNCONTESTED." It also verifies that the original candidate list remains unchanged
   * after the method call.
   * 
   * @return boolean - true if the test passes, false if it fails.
   */
  public static boolean testUncontestedLowestPolling() {
    // Candidate list with one valid candidate and two null entries
    String[][] candidateList = {{"Ahmed", "Water", "9"}, null, null};
    // Create a copy of the candidateList to ensure that the method does not modify the original
    // list
    String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
    int size = 1;
    // Expected result for an uncontested candidate
    String expected = "UNCONTESTED";
    // Call the method to find the lowest polling candidate
    String actual = ElectionManager.findLowestPollingCandidate(candidateList, size);
    if (!expected.equals(actual)) {
      return false;
    }
    if (!Arrays.deepEquals(candidateList, candidateCopy)) {
      return false;
    }
    return true; 
  }

  /**
   * Tests the findLowestPollingCandidate method to ensure it correctly identifies the candidate
   * with the lowest unique vote count when the list contains null entries. It also verifies that
   * the original candidate list remains unchanged after the method call.
   *
   * @return boolean - true if the test passes, false if it fails.
   */

  public static boolean testLowestUniqueVoteCount() {
    // Candidate list with name, type, and vote count. One entry is null.
    String[][] candidateList = {{"Slowpoke", "Water", "30"}, {"Wooper", "Water", "10"}, null};
    // Create a copy of the candidateList to check that the method does not modify the original list
    String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
    int size = 2;
    // Expected result is the candidate with the lowest unique vote count
    String expected = "Wooper (Water) - 10";
    // Call the method to find the lowest polling candidate
    String actual = ElectionManager.findLowestPollingCandidate(candidateList, size);
    // If the actual result does not match the expected, the test fails
    if (!expected.equals(actual)) {
      return false;
    }
    // If the original list has been modified, the test fails
    if (!Arrays.deepEquals(candidateList, candidateCopy)) {
      return false;
    }
    return true;
  }

  /**
   * Tests the findLowestPollingCandidate method to make sure that it correctly identifies the
   * candidate with the lowest vote count. In this case, the test checks a scenario where there is a
   * tie between candidates, and it expects the correct candidate with the lowest vote count to be
   * returned.
   * 
   * @return boolean - true if the test passes, false if it fails.
   */
  public static boolean testLowestVoteCountTied() {
    // Candidate list with name, type, and vote count
    String[][] candidateList =
        {{"Slowpoke", "Water", "300"}, {"Squirtle", "Water", "9"}, {"Wooper", "Water", "30"}};
    // Create a copy of the candidateList for comparison purposes

    String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
    int size = 3;
    // Expected result is the candidate with the lowest votes
    String expected = "Squirtle (Water) - 9";
    // Call the method to find the lowest polling candidate
    String actual = ElectionManager.findLowestPollingCandidate(candidateList, size);
    // If the actual result does not match the expected, the test fails

    if (!expected.equals(actual)) {
      return false;
    }
    if (!Arrays.deepEquals(candidateList, candidateCopy)) {
      return false;
    }
    return true; 
  }

  /**
   * PROVIDED MAIN METHOD to manage the tester methods above.
   * 
   * We're getting a little esoteric here to take advantage of loops to keep the code short; each
   * pass through the loop could also be written as follows:
   * 
   * boolean singleTest = testMethodCall(); allPass &= singleTest;
   * System.out.println("testMethodCall : " + singleTest);
   * 
   * @throws NoSuchMethodException                       if you spell a method name incorrectly
   * 
   *                                                     And a couple of other "checked" exceptions
   *                                                     that should never happen with our usage
   *                                                     here:
   * @throws IllegalAccessException
   * @throws java.lang.reflect.InvocationTargetException
   */
  public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException,
      java.lang.reflect.InvocationTargetException {
    boolean allPass = true, singlePass = true;
    String printFormat = "%-29s: %s\n";

    // NOTE TO STUDENTS: If you create any additional tests for any of the methods in
    // ElectionManager, add their names to the appropriate array below!
    String[] containsTests = {"testContainsEmpty", "testDoesNotContain", "testDoesContain"};
    String[] addTests =
        {"testAddToEmpty", "testAddToNonEmpty", "testAddCandidateErrors", "testAddToFull"};
    String[] dropTests =
        {"testDropOnlyCandidate", "testDropFirstCandidate", "testDropCandidateNotRunning"};
    String[] winTests = {"testUncontestedWinner", "testClearWinner", "testContingentElection"};
    String[] lowTests =
        {"testUncontestedLowestPolling", "testLowestUniqueVoteCount", "testLowestVoteCountTied"};

    String[][] testNames = {containsTests, addTests, dropTests, winTests, lowTests};

    // NOTE TO STUDENTS: this for-loop is moving through the method names we've added to the 2D
    // array testNames and attempting to call methods with those names from this tester
    // (specifically line 286 here). See Java's reflection framework for more details!
    for (String[] testSet : testNames) {
      for (String name : testSet) {
        singlePass = (boolean) ElectionManagerTester.class.getDeclaredMethod(name).invoke(null);
        allPass &= singlePass;
        System.out.printf(printFormat, name, singlePass);
      }
      System.out.println();
    }

    System.out.println("ALL TESTS: " + allPass);

  }

}
