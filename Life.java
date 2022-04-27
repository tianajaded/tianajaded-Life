/*
 * Name: Elisha Phillips
 * Name: Tiana Noll-Walker
 * Date: 04/13/2022
 * Course: CPT_S 132 Section 01, Spring 22
 * Assignment: HW11 - LifeGUIAnimation
 * Description: Calculates John Conway's Game of Life and prints GUI Animation
 * Grade Level: standard
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
        // Instantiates Buttons, lifeFrame, and lifeGen
        lifeFrame lifeFrame = new lifeFrame();
        Buttons Buttons = new Buttons();
        lifeGen lifeGen = new lifeGen();
        lifeFile lifeFile = new lifeFile();

    }

}