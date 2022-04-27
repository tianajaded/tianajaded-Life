/*
 * Name: Elisha Phillips
 * Name: Tiana Noll-Walker
 * Date: 04/13/2022
 * Course: CPT_S 132 Section 01, Spring 22
 * Assignment: HW11 - LifeGUIAnimation
 * Description: Calculates John Conway's Game of Life and prints GUI
 * Grade Level: standard
 */

package Life;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Description: Top level window frame for lifeGUI
 *
 */
public class lifeFrame {

    // Declaring the Content Pane
    static java.awt.Container c = new java.awt.Container();
    static javax.swing.JFrame win;

    /**
     * Constructor for the GUI, constructs a JFrame to display window
     */
    public lifeFrame() {
        // Main Window
        // Declaring the Window
        win = new javax.swing.JFrame("Game of Life");

        // Content Panel
        c = win.getContentPane();
        c.setLayout(new BorderLayout());

        win.setBackground(Color.WHITE);
        c.setBackground(Color.WHITE);

        // Assigning default window parameters
        win.setLocation(50, 50);
        win.setSize(500, 500);
        win.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        win.toBack();
        win.setVisible(true);

    }

    /**
     * method to close window
     */
    static void close() {
        win.dispatchEvent(new WindowEvent(win, WindowEvent.WINDOW_CLOSING));

    }


}