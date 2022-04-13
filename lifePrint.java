package Life;

import java.util.*;

/**
 * lifePrint class contains string formatting and user input methods
 *
 * @author Tiana Noll-Walker
 * @author Elisha Phillips
 */
public class lifePrint {

    // Default characters for cell states
    private char dead = '.';
    private char live = 'O';
    private lifeGUI display = new lifeGUI();
    private Buttons buttons = new Buttons();

    /**
     * Obtains user input value and rejects any input
     * not meeting expected int return > minimum
     *
     * @param minimum integer value for lower limit, user input must be greater than
     *
     * @return num integer value for user input
     */
    public int input(int minimum) {

        // Instantiates scanner object
        Scanner scan = new Scanner(System.in);

        // Stores integer input
        int num;

        // Infinite loop
        while (true) {
            // Catch input exceptions
            try {
                // Trying integer input
                num = scan.nextInt();
                // Also throw exception if it isn't greater than limit
                if (num < minimum) {
                    throw new InputMismatchException();
                } else {
                    break;
                }
            } catch (InputMismatchException exception) {
                // User error message
                System.out.println("\nPlease enter a valid integer greater than " + minimum + ": \n");
                // Begin next input
                scan.next();
            }

        }
        return num;
    }

    /**
     * Overrides toString method, inputs square integer array and
     * generates formatted string with default characters for
     * cell states.
     *
     * @param grid integer array representing game board,
     *             values are either 1 for alive, or 0 for dead
     *
     * @return boardStr formatted string
     */
    public String toString(char[][] grid) {

        // Empty string
        String boardStr = "";

        // Loop through inputted grid
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[i].length - 1; j++) {
                // Check grid cell for live or dead state and update string
                if (grid[i][j] == 0) {
                    boardStr += dead + " ";
                } else {
                    boardStr += live + " ";
                }
            }
            // Next line after row is complete
            boardStr += "\n";
        }
        return boardStr;

    }

    public void GUI(ArrayList<int[][]> gridList) {
        // Draw window
        display.drawGridLayout(gridList.get(0));
        buttons.retrieveGrid(gridList);
        // Loop through inputted grid
        for (int i = 1; i < gridList.size(); i++) {
            display.updateGridLayout(gridList.get(i));
            try {
    
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}