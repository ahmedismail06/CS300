import java.util.Random;
import java.io.File;
import processing.core.PImage;
//
// Title: This is a Walking Simulation class where group of `Walker` objects moves across
// the screen. The program randomly generates and positions walkers, and users can interact with
// them by either adding new walkers, stopping them from moving, or making them movement when
// clicked on with the mouse.
// The simulation continuously updates the walkers’ positions and positions them back to the start
// when
// they reach the edge of the screen.
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
public class WalkingSim {
  private static Random randGen; // Random generator for random values
  private static int bgColor; // Background color
  private static PImage[] frames; // Array of images (frames) for the walking animation
  private static Walker[] walkers; // Array of Walker objects

  public static void main(String[] args) {
    Utility.runApplication();// runs the simulation
  }

  /**
   * Setup method initializes variables, loads images, and creates walker objects.
   */
  public static void setup() {
    randGen = new Random(); // intializes the random generation
    bgColor = randGen.nextInt();// Set a random background color
    frames = new PImage[Walker.NUM_FRAMES];
    for (int i = 0; i < frames.length; i++) {
      frames[i] = Utility.loadImage("images" + File.separator + "walk-" + i + ".png");
    }
    walkers = new Walker[8]; // set the capacity if walkers to 8
    walkers[0] = new Walker(); // Create the first walker
    // Generate a random number of walkers to add (1 to walkers.length)
    int random = (int) (Math.random() * walkers.length) + 1;
    for (int i = 0; i < random; i++) {
      // Assign walker positions randomly on the screen
      walkers[i] = new Walker((int) (Math.random() * Utility.width()),
          (int) (Math.random() * Utility.height()));
    }
  }

  /**
   * Draw method updates the display, moves the walkers, and renders them on the screen.
   */
  public static void draw() {
    Utility.background(bgColor);// Set the background color
    // Loop through all the walker objects
    for (int i = 0; i < walkers.length; i++) {
      if (walkers[i] != null) { // Ensure the walker exists
        System.out.println("Mouse is over a walker!" + i);
        // If the walker is walking, update its position
        if (walkers[i].isWalking()) {
          walkers[i].update();
          walkers[i].setPositionX(walkers[i].getPositionX() + 3); // Move the walker horizontally
        }
        int frameIndex = walkers[i].getCurrentFrame(); // get the current frame of the walker
        // draws the walker
        Utility.image(frames[frameIndex], walkers[i].getPositionX(), walkers[i].getPositionY());
        if (walkers[i].getPositionX() > 799) { // checks if the walker reaches the edge
          walkers[i].setPositionX(0); // sets walker position to 0 (the other side of the screen
        }
      }
    }
  }


  /**
   * Checks if the mouse is currently over a specified walker.
   * 
   * @param item The Walker object to check against the mouse position.
   * @return true if the mouse is over the walker, false otherwise.
   */
  public static boolean isMouseOver(Walker item) {

    float walkerX = item.getPositionX(); // X position of the walker
    float walkerY = item.getPositionY(); // Y position of the walker
    float frameWidth = frames[0].width; // Width of the walker image
    float frameHeight = frames[0].height; // Height of the walker image
    float mouseX = Utility.mouseX(); // Current X position of the mouse
    float mouseY = Utility.mouseY(); // Current Y position of the mouse

    // Check if the mouse is within the bounding box of the walker image
    if (mouseX > walkerX - frameWidth / 2 && mouseX < walkerX + frameWidth / 2
        && mouseY < walkerY + frameHeight / 2 && mouseY > walkerY - frameHeight / 2) {
      return true;
    }
    return false;
  }

  /**
   * When the mouse is pressed, this method checks if the mouse is over a walker. If so, the walker
   * is set to start walking.
   */
  public static void mousePressed() {
    // Loop through all the walker objects
    for (int i = 0; i < walkers.length; i++) {
      if (walkers[i] != null) { // checks if the walker is null
        if (isMouseOver(walkers[i])) {// Check if the mouse is over the walker
          walkers[i].setWalking(true); // sets walkers[i] to walk
          break; // Only start one walker, so break out of the loop

        }
      }
    }
  }

  /**
   * Checks keyboard inputs 'a' adds a new walker to the simulation. 's' stops all the walkers from
   * walking.
   * 
   * @param one The character of the keyboard that was pressed.
   */
  public static void keyPressed(char one) {
    if (one == 'a') { // checks if the character equals 'a'
      for (int i = 0; i < walkers.length; i++) { // loops through all walkers
        if (walkers[i] == null) { // checks if the walker object is null
          // Create a new walker with a random position
          walkers[i] = new Walker((int) (Math.random() * Utility.width()),
              (int) (Math.random() * Utility.height()));
          // Get the current frame for the new walker
          int frameIndex = walkers[i].getCurrentFrame();
          // Draw the walker
          Utility.image(frames[frameIndex], walkers[i].getPositionX(), walkers[i].getPositionY());
          break; // Stops after one walker is added
        }
      }
    }
    // checks if the character equals 's'
    else if (one == 's') {
      // loops all walkers object
      for (int i = 0; i < walkers.length; i++) {
        if (walkers[i] != null) { // checks if a walkers object is null
          walkers[i].setWalking(false); // stops all walking Walkers
        }
      }

    }
  }

}
