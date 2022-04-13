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
 * lifeBoard class contains the methods to generate the grid
 * and perform the rule-based calculations for the next generations.
 *
 * @author Tiana Noll-Walker
 * @author Elisha Phillips
 */
public class lifeBoard {

    // Declares integer values for cell states
    private int dead = 0;
    private int live = 1;

    /**
     * Generates an initial board according to user size param, with
     * all values set to dead cell value
     *
     * @param size integer value determines height and width of square array
     *             shape: (size, size)
     *
     * @return grid[][] returns generated int array
     */
    public int[][] generateEmptyBoard(int size) {
        // create square initial grid per user dimensions
        int grid[][] = new int[size][size];
        // assign default fill with dead cells
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                grid[i][j] = dead;
        // return grid
        return grid;

    }

    /**
     * Generates board with pre-defined starting cells with
     * corresponding values set to live cell value
     *
     * @param size integer value determines height and width of square array
     *             shape: (size, size)
     *
     * @return grid[][] returns generated int array
     */
    public int[][] generateStartingBoard(int size) {

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

        // Call method to create initial grid
        int[][] grid = generateEmptyBoard(size);

        // Iterate through the grid and set the designated cells to live
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                grid[cells[i][j][0]][cells[i][j][1]] = live;

            }
        }

        return grid;
    }

    /**
     * Counts the neighboring cell states for a selected cell
     *
     * @param grid int square array for the present generation grid
     * @param x    integer row value
     * @param y    integer column value
     *
     * @return count returns integer value with the sum of the neighbor states
     */
    public int countAliveNeighbors(int[][] grid, int x, int y) {

        // Counter
        int count = 0;

        // Cell neighbor location modifiers, default at 1

        // Rows: Right, Left
        int xDistanceR = 1;
        int xDistanceL = 1;
        // Columns: Up, Down
        int yDistanceU = 1;
        int yDistanceD = 1;

        // Checks for edge row and column cells and
        // wraps neighbor distance to opposing edge of grid
        // to avoid index errors
        if (x == grid.length) {
            xDistanceR = 1 - grid.length;
        }
        if (x == 0) {
            xDistanceL = 1 - grid.length;
        }
        if (y == grid[0].length) {
            yDistanceD = 1 - grid[0].length;
        }
        if (y == 0) {
            yDistanceU = 1 - grid[0].length;
        }

        // Center of the board is [i][j], count tallies
        // values from all surrounding cells in 3x3 matrix

        // Column to the left of cell
        count += grid[x - xDistanceL][y - yDistanceU];
        count += grid[x - xDistanceL][y];
        count += grid[x - xDistanceL][y + yDistanceD];

        // Column containing cell
        count += grid[x][y - yDistanceU];
        count += grid[x][y + yDistanceD];

        // Column to the right of cell
        count += grid[x + xDistanceR][y - yDistanceU];
        count += grid[x + xDistanceR][y];
        count += grid[x + xDistanceR][y + yDistanceD];

        return count;

    }

    /**
     * Calculates the grid for the next generation
     *
     * @param grid int square array for the present generation grid
     *
     * @return nextGrid returns int square array for the future generation grid
     */
    public int[][] Step(int[][] grid) {
        // Calls method to generate separate initial grid to store future values
        int[][] nextGrid = generateEmptyBoard(grid.length);

        // Integer value for neighboring cell tally
        int liveNeighbors;

        // Loop through the 2D grid
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[i].length - 1; j++) {

                // Count neighbors for current cell and store value in the future grid
                liveNeighbors = countAliveNeighbors(grid, i, j);
                nextGrid[i][j] = liveNeighbors;

                // Calculating cell state based on Game of Life rules:

                // Cell is lonely:
                if ((grid[i][j] == live) && (liveNeighbors < 2)) {
                    nextGrid[i][j] = dead;

                    // Cell is overcrowded:
                } else if ((grid[i][j] == live) && (liveNeighbors > 3)) {
                    nextGrid[i][j] = dead;

                    // Cell birth:
                } else if ((grid[i][j] == dead) && (liveNeighbors == 3)) {
                    nextGrid[i][j] = live;

                    // Cell doesn't change:
                } else {
                    nextGrid[i][j] = grid[i][j];
                }
            }
        }
        return nextGrid;

    }
}