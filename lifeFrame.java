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

import java.awt.*;
/**
 * Description: Top level window frame for lifeGUI
 *
 */
public class lifeFrame {

    // Declaring the Content Pane
    static java.awt.Container c;


    /**
     * Constructor for the GUI, constructs a JFrame to display window
     */
    public lifeFrame() {
        // Main Window
        // Declaring the Window
        javax.swing.JFrame win = new javax.swing.JFrame("Game of Life");
        // Content Panel
        c = win.getContentPane();
        c.setLayout(new BorderLayout());

        // Assigning default window parameters
        win.setLocation(50, 50);
        win.setSize(500, 500);
        win.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        win.toBack();
        win.setVisible(true);


    }


}
