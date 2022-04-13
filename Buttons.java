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

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class constructs the buttons and displays them on the lifeGui.
 * When the buttons are pressed, it iterates backwards and forwards through &*
 * each generation.
 */
public class Buttons extends lifeGUI {

    // fields for counter
    private int genCount = 0;
    private int length = 0;
    // fields for the buttons
    static javax.swing.JButton startButton = new javax.swing.JButton("Start");
    static javax.swing.JButton resetButton = new javax.swing.JButton("Reset ");
    static javax.swing.JToolBar toolbar = new JToolBar();
    static ArrayList<int[][]> gridList = new ArrayList<int[][]>();
    // field for generator class
    private lifeBoard life = new lifeBoard();
    JLabel generations;

    public Buttons() {
        toolbar.add(resetButton, BorderLayout.WEST);
        toolbar.add(startButton, BorderLayout.EAST);

        c.add(toolbar, BorderLayout.NORTH);

        startButton.addActionListener(new java.awt.event.ActionListener() {
            // inner class for button event
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // call method to set next dot color and update buttons
                timerThread.getState();
                if (timerThread.getState() == State.NEW) {
                    timerThread.start();
                    nextGen();
                    
                } else {
                    timerThread.resume();

                }

            }
        });
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            // inner class for button event
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // call method to set previous dot color and update buttons
                prevGen();

            }
        });
    }

    Runnable runTimer = new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    generations.setText(String.format("generations", genCount));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }
        }
    };

    Thread timerThread = new Thread(runTimer);

    /**
     * method to get the grid
     *
     * @param l the gridlist
     */
    public void retrieveGrid(ArrayList<int[][]> l) {
        gridList = l;
        length = gridList.size() - 1;
    }

    /**
     * method to set next Generation
     */
    public void nextGen() {
        // Advance counter, loop back to zero at last value
        genCount = nextIndex(genCount);

        // update next button text
        startButton.setText("gen:" + String.valueOf(nextIndex(genCount)));
        // update previous button text
        resetButton.setText(" reset");

        // Set next generation
        // System.out.println(gridList.get(genCount));
        super.updateGridLayout(gridList.get(genCount));

    }

    /**
     * method to set previous Generation
     */
    public void prevGen() {
        // Advance counter, loop back to zero at last value
        genCount = prevIndex(genCount);

        // update next button text
        startButton.setText("start " + String.valueOf(nextIndex(genCount)));
        // update previous button text
        resetButton.setText(String.valueOf(genCount) + " reset");

        // Set prev generation
        super.updateGridLayout(gridList.get(genCount));
    }

    /**
     * method to get prev index
     *
     * @param Count input counter integer
     * @return next index integer
     */
    public int prevIndex(int Count) {
        int index;
        // if minimum, set index to end value
        // else, set index one step back
        if (Count == 0) {
            index = length;
        } else {
            index = Count - 1;
        }
        return index;
    }

    /**
     * method to get next index
     *
     * @param Count input counter integer
     * @return next index integer
     */
    public int nextIndex(int Count) {
        // call method to generate next grid if at end of arraylist
        if (Count == length) {
            gridList.add(life.Step(gridList.get(Count)));
            length += 1;
        }
        return Count + 1;
    }

}