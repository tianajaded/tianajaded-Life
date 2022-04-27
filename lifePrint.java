package Life;

import java.awt.*;
import java.awt.List;
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
     * Generates board with pre-defined starting cells with
     * corresponding values set to live cell value
     *
     * @param size integer value determines height and width of square array
     *             shape: (size, size)
     * @return grid[][] returns generated int array
     */
    public void generateStartingBoard(int size) {

        // Array with coordinates for the beginning live cells
        int[][][] cells = {
                { { 2, 3 }, // Shape a
                        { 3, 3 } },
                { { 2, 12 }, // Shape b
                        { 2, 13 },
                        { 3, 12 },
                        { 3, 13 } },
                { { 7, 6 }, // Shape c
                        { 7, 7 },
                        { 8, 5 },
                        { 8, 8 },
                        { 9, 6 },
                        { 9, 7 } },
                { { 12, 12 }, // Shape d
                        { 12, 13 },
                        { 12, 14 },
                        { 8, 8 },
                        { 9, 6 },
                        { 9, 7 } },
                { { 14, 5 }, // Shape e
                        { 15, 3 },
                        { 15, 5 },
                        { 16, 4 },
                        { 16, 5 } } };

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
    public String toString() {

        // Empty string
        String boardStr = "";
        lifeCell[][] grid = lifeBoard.get(0);
        for (int x = 0; x < grid.length; ++x) {
            for (int y = 0; y < grid[x].length; ++y) {
                boardStr += grid[x][y].getState();
            }
            boardStr += ",";
        }
        return boardStr;
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
    static void fromString(String boardStr) {

        // Creating array of string length
        char[] cells = new char[boardStr.length()];

        // Copy character by character into array
        for (int i = 0; i < boardStr.length(); i++) {
            cells[i] = boardStr.charAt(i);
        }
        // I was trying to use a "lifeCell object" here hence the arraylist but it could
        // be rewritten
        // for the int[][] array for grid instead, using a "#" for a new line on the
        // grid
        // and 1/0 for the dead/alive
        int r = 0;
        int c = 0;
        ArrayList<Integer> row = new ArrayList<Integer>();
        ArrayList<Integer[]> col = new ArrayList<Integer[]>();
        for (char cell : cells) {
            try {
                row.add(Character.getNumericValue(cell));
                r++;
            } catch (Exception e) {
                Integer[] arr = new Integer[row.size()];
                arr = row.toArray(arr);
                row.clear();
                col.add(arr);
                c++;
            }
        }
        lifeBoard lifeBoard = new lifeBoard();
        lifeBoard.initialize(r, c, col);
    }
}