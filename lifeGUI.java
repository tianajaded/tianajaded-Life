/*
 * Name: Elisha Phillips
 * Name: Tiana Noll-Walker
 * Date: 4/12/2022
 * Course: CPT_S 132 Section 01, Spring 22
 * Assignment: HW11 - LifeAnimation
 * Description: Calculates John Conway's Game of Life and prints Animated GUI
 * Grade Level: Challenge
 */

package Life;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.BorderLayout;

/**
 * Description: GUI Display Class for the lifeBoard
 *
 */
public class lifeGUI extends lifeFrame {

    static ArrayList<Label> label = new ArrayList<Label>();

    // Background color for the layout, will form the board's gridlines
    private static final Color live = Color.WHITE;
    private static final Color dead = Color.BLACK;

    /**
     * Constructor to that draws the grid layout via an internal JFrame
     *
     * @param gridArr the grid array of cells to be displayed
     */
    public void drawGridLayout(int[][] gridArr) {
        // length of square grid array
        int x = gridArr.length;

        // making an internal frame for grid
        JInternalFrame grid = new JInternalFrame();
        grid.pack();

        // setting background
        grid.setBackground(dead);

        // gb for arranging cells
        grid.setLayout(new GridBagLayout());
        grid.setVisible(true);

        // constraints for board
        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = 1d;
        gc.weighty = 1d;
        gc.insets = new Insets(0, 0, 1, 1);
        gc.fill = GridBagConstraints.BOTH;

        int index = 0;
        // fill the whole panel with labels
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                // label for each cell
                Label l = new Label();
                gc.gridx = i;
                gc.gridy = j;
                grid.add(l, gc);
                // added to arraylist
                label.add(index, l);
                index += 1;
            }
        }
        // call the draw method
        updateGridLayout(gridArr);
        // add to component panel
        c.add(grid, BorderLayout.CENTER);

    }

    /**
     * Constructor to update the grid layout with live or dead cells
     *
     * @param gridArr the grid array of cells to be displayed
     */

    public void updateGridLayout(int[][] gridArr) {
        int x = gridArr.length;
        int index;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                index = (x * j) + i;
                // Check grid cell for live or dead state and update string
                if (gridArr[i][j] == 0) {
                    label.get(index).setBackground(live);
                } else {
                    label.get(index).setBackground(dead);
                }
                index += 1;
            }
        }
    }

}