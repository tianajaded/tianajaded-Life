/*
 * Name: Elisha Phillips
 * Name: Tiana Noll-Walker
 * Date: 02/26/2022
 * Course: CPT_S 132 Section 01, Spring 22
 * Assignment: HW6 - LifeGUI
 * Description: Calculates John Conway's Game of Life and prints GUI
 * Grade Level: Challenge
 */

package Life;

/**
 * Main class to run the Game of Life in the user's terminal. User
 * can input parameters for the size of the grid, and number of generations to
 * display.
 *
 * @author Tiana Noll-Walker
 * @author Elisha Phillips
 */
public class Life {

    public static void main(String[] args) {
        // Instantiates lifeGen and calls method to begin the game sequence
        lifeGen game = new lifeGen();
        game.initiateGame();

    }

}