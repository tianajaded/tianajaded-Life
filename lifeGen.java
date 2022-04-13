/*
 * Name: Elisha Phillips
 * Name: Tiana Noll-Walker
 * Date: 02/16/2022
 * Course: CPT_S 132 Section 01, Spring 22
 * Assignment: HW5 - Life
 * Description: Calculates John Conway's Game of Life and prints the grid in terminal
 * Grade Level: Challenge
 */

package Life;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;



/**
 * lifeGen class is the central game engine, containing the user interface
 * and calls the game methods
 *
 * @author Tiana Noll-Walker
 * @author Elisha Phillips
 */
public class lifeGen {

    // Instantiates game classes
    private lifeBoard life = new lifeBoard();
    private lifePrint print = new lifePrint();
    JButton startB = new JButton();
    JButton nextB = new JButton();
    JPanel p = new JPanel();
    JPanel center = new JPanel();

    

    // Default for minimum grid size
    private int minSize = 19;

    /**
     * Starts the game, and obtains user params for grid size and
     * number of generations to print
     *
     */
    public void initiateGame() {
        // Game headers
        System.out.println("Conway's Game of Life");
        System.out.println("\n");

        // User input request for generations
        System.out.println("\nHow many generations would you like to print?");
        // Method for user input
        int gen = print.input(0);

        // User input request for grid size
        System.out.println("\nWhat size would you like the board to be?");
        System.out.println("Minimum size is " + minSize + ": \n");
        // Method for user input
        int size = print.input(minSize - 1);

        // Method to run game with user-defined parameters
        
        runGame(gen, size);
    }

    /**
     * Calculates and prints successive generations of the game board
     *
     * @param gen  integer value determines number of generations to calculate
     *
     * @param size integer value determines height and width of square array
     *             shape: (size, size)
     *
     */
    public void runGame(int gen, int size) {

        ArrayList<int[][]> gridList = new ArrayList<int[][]>();

        // Method to generate initial grid
        int grid[][] = life.generateStartingBoard(size);

        // Loop through each generation
        for (int i = 0; i < gen; i++) {
            // Header with generation number
            System.out.println("\nCurrent Generation: " + i + "\n");
            // Method to calculate board's next generation
            if (i > 1) {
                
                grid = life.Step(grid);
            }

            gridList.add(grid);

        }

        print.GUI(gridList);
       
    }
    
}