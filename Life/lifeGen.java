/*
 * Name: Elisha Phillips
 * Name: Tiana Noll-Walker
 * Date: 04/13/2022
 * Course: CPT_S 132 Section 01, Spring 22
 * Assignment: HW11 
 * Description: Calculates John Conway's Game of Life and animates the gui
 * Grade Level: standard
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
    private lifePrint print = new lifePrint();
    static lifeBoard lifeBoard = new lifeBoard();

    static int size;
    static int currentgen;
    static final int live = 1;
    static final int dead = 0;
    static ArrayList<int[][]> board;

    // Default for minimum grid size
    static final int minSize = 19;

    /**
     * Starts the game, and obtains user params for grid size and
     * number of generations to print
     * 
     * @param dimensions board size
     */
    static void initiateGame(int dimensions) {
        size = dimensions;
        board = new ArrayList<>();
        // Game headers
        System.out.println("Conway's Game of Life");
        System.out.println("\n");

        currentgen = 0;
        board.add(lifeBoard.generateStartingBoard(size));
        lifeGUI.drawGridLayout(board.get(0));
    }

    /**
     * Resets the game board generations
     * 
     * @param dimensions board size
     */
    static void reset(int dimensions) {
        size = dimensions;
        board = new ArrayList<>();
        currentgen = 0;
    }

    /**
     * Resets the game board generations, does not modify current grid
     * 
     * @param grid current board to set to initial state
     */
    static void reset(int[][] grid) {
        size = grid.length;
        board = new ArrayList<>();
        board.add(grid);
        currentgen = 0;
    }

    /**
     * Clears all values on the game board
     * 
     * @param dimensions board size
     */
    static void clear(int dimensions) {
        size = dimensions;
        reset(size);
        board.add(lifeBoard.generateEmptyBoard(size));
        lifeGUI.updateGridLayout(board.get(0));
    }

    /**
     * Advances Game Board Generation by 1
     *
     *
     */
    static void nextGen() {

        // check for board modif, sets gen to zero

        //

        // Returns int for number of calculated gens
        int calculatedGens = board.size() - 1;
        System.out.println("Current Gen" + currentgen + "Calculated Gens (LifeBoard) " + calculatedGens);
        // increment 1
        currentgen++;
        if (currentgen > calculatedGens) {
            board.add(lifeBoard.Step(board.get(calculatedGens)));
        }
        lifeGUI.updateGridLayout(board.get(currentgen));
    }

    /**
     * Moves Game Board Generation back by 1
     *
     */
    static void prevGen() {
        // If at beginning, loops to end calculated state
        if (currentgen == 0) {
            currentgen = board.size() - 1;
        } else {
            currentgen--;
        }
        lifeGUI.updateGridLayout(board.get(currentgen));
    }
}