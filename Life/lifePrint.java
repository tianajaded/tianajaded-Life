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
    static char dead = '.';
    static char live = 'O';

    /**
     * Obtains user input value and rejects any input
     * not meeting expected int return > minimum
     *
     * @param minimum integer value for lower limit, user input must be greater than
     *
     * @return num integer value for user input
     */
    static int input(int minimum, String input) {

        // Stores integer input
        int num;

        try {
            // Trying integer input
            num = Integer.parseInt(input);

            // Also throw exception if it isn't greater than limit
            if (num < minimum) {
                throw new InputMismatchException();
            }

        } catch (InputMismatchException exception) {
            num = 0;
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
    static String toString(int[][] grid) {

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
}