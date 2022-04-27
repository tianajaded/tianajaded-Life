/*
 * Name: Elisha Phillips
 * Name: Tiana Noll-Walker
 * Date: 04/13/2022
 * Course: CPT_S 132 Section 01, Spring 22
 * Assignment: HW11 - LifeGUIAnimation
 * Description: Calculates John Conway's Game of Life and prints GUI with animation
 * Grade Level: Challenge
 */

package Life;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.Flow;
import java.io.*;
import java.net.UnknownHostException;

import static javax.swing.BorderFactory.createLineBorder;

/**
 * This class constructs the buttons and displays them on the lifeGui.
 * When the buttons are pressed, it initiates or stops the game.
 */
public class Buttons extends lifeGUI implements Serializable{

    // static flag to store state of start button: 0 - start, 1 - pause
    static int startButtonFlag = 0;
    static int setcellsFlag = 0;
    static int setnextFlag = 0;
    // fields for input
    static tbbuttonStyle inputButton = new tbbuttonStyle();
    static tblabelStyle inputLabela = new tblabelStyle();
    static tblabelStyle inputLabelb = new tblabelStyle();
    static JTextField inputText = new JTextField();
    static JPanel input = new JPanel();
   // static FileChooser jfc = new FileChooser();

    // fields for toolbar
    static tbbuttonStyle setcellsButton = new tbbuttonStyle();
    static tbbuttonStyle startButton = new tbbuttonStyle();
    static tbbuttonStyle prevButton = new tbbuttonStyle();
    static tbbuttonStyle nextButton = new tbbuttonStyle();
    static tblabelStyle genLabel = new tblabelStyle();
    static javax.swing.JToolBar toolbar = new JToolBar();
    static Timer timer;

    // gridList field
    static ArrayList<int[][]> gridList = new ArrayList<int[][]>();

    JLabel generations;

    /**
     * constructor for the buttons. Creates buttons with ActionEvents and Listeners.
     */
    public Buttons() {

        createInput();
        createToolbar();

        // add action listener to input button
        inputButton.addActionListener(new java.awt.event.ActionListener() {
            // inner class for button event
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                int num = lifePrint.input(lifeGen.minSize, inputText.getText());
                // returns 0 if invalid input
                if (num == 0) {
                    inputLabela.setText("The minimum board size is 19 cells wide.");
                    inputLabelb.setText("Please enter a valid integer.");
                    inputLabela.setForeground(Color.RED);
                    inputLabelb.setForeground(Color.RED);
                } else {
                    input.setVisible(false);
                    toolbar.setVisible(true);
                    lifeGen.initiateGame(num);
                }
            }
        });
        // action listener event for animating the board when the button is pressed
        java.awt.event.ActionListener animateBoard = new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextGen();
            }
        };

        // create timer
        timer = new Timer(300, animateBoard);
        // add listener to the startButton
        startButton.addActionListener(new java.awt.event.ActionListener() {
            // inner class for button event
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                switch (startButtonFlag) {
                    case 0: // animation running

                        timer.setRepeats(true);
                        timer.start();

                        startButton.setText("PAUSE");
                        setcellsButton.setEnabled(false);
                        prevButton.setEnabled(false);
                        nextButton.setEnabled(false);
                        startButtonFlag = 1;
                        break;

                    case 1: // animation paused
                        timer.stop();
                        startButton.setText("START");
                        setcellsButton.setEnabled(true);
                        prevButton.setEnabled(true);
                        nextButton.setEnabled(true);
                        startButtonFlag = 0;
                        break;

                    case 2:

                        // set all cells to dead
                        lifeGen.clear(lifeGen.size);

                        break;
                }

            }
        });
        // add action listener to the setcellsButton
        setcellsButton.addActionListener(new java.awt.event.ActionListener() {
            // inner class for button event
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // call method to set previous dot color and update buttons
                switch (setcellsFlag) {
                    case 0: // press to initiate edit state
                        startButton.setText(" CLEAR ");
                        setcellsButton.setText(" ENTER ");
                        prevButton.setEnabled(false);
                        nextButton.setText(" RESTART ");
                        startButtonFlag = 2;
                        setcellsFlag = 1;
                        setnextFlag = 1;
                        break;

                    case 1: // set edits
                        // set inputted grid as starting grid, set gen to 0

                        // reset stuff
                        startButton.setText(" START ");
                        setcellsButton.setText(" INPUT ");
                        nextButton.setText(" NEXT >> ");

                        prevButton.setEnabled(true);
                        startButtonFlag = 0;
                        setcellsFlag = 0;
                        setnextFlag = 0;
                        lifeGen.reset(lifeGUI.updateGrid(lifeGen.size));
                        break;
                }

            }
        });

        prevButton.addActionListener(new java.awt.event.ActionListener() {
            // inner class for button event
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // call method to set previous dot color and update buttons
                prevGen();

            }
        });



        nextButton.addActionListener(new java.awt.event.ActionListener() {
            // inner class for button event
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                switch (setnextFlag) {
                    case 0: // default next button
                        // call method to set previous dot color and update buttons
                        nextGen();
                        break;

                    case 1: // reset
                        lifeFrame.close();
                        Buttons Buttons = new Buttons();
                        lifeGen lifeGen = new lifeGen();
                        break;

                }

            }
        });

    }


    /**
     * method to build toolbar for user interface
     */
    public void createToolbar() {
        setcellsButton.setText(" INPUT ");
        toolbar.add(setcellsButton);

        toolbar.addSeparator();
        startButton.setText(" START ");
        toolbar.add(startButton);

        genLabel.setText(" 0 ");
        toolbar.add(genLabel);

        toolbar.addSeparator(new Dimension(20, 40));

        prevButton.setText(" << PREV ");
        toolbar.add(prevButton);
        nextButton.setText(" NEXT >> ");
        toolbar.add(nextButton);
        toolbar.setVisible(false);
        c.add(toolbar, BorderLayout.NORTH);
    }

    /**
     * method to create and add input
     */
    public void createInput() {

        int x = (c.getWidth() / 2) - 150;
        int y = (c.getHeight() / 2) - 100;

        inputButton.setText("OK");

        inputLabela.setText("Please enter the desired board size.");
        inputLabelb.setText("The minimum board size is 19 cells wide.");

        inputLabela.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        inputLabelb.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        inputLabela.setBounds(x + 25, y, 300, 30);
        inputLabelb.setBounds(x + 25, y + 25, 300, 30);
        inputText.setBounds(x + 50, y + 75, 200, 30);
        inputButton.setBounds(x + 50, y + 125, 200, 30);

        input.add(inputLabela);
        input.add(inputLabelb);
        input.add(inputText);
        input.add(inputButton);

        input.setBackground(Color.WHITE);
        input.setLayout(null);
        input.setVisible(true);

        c.add(input);

    }

    /**
     * method to set next Generation
     */
    public void nextGen() {
        lifeGen.nextGen();
        // update label
        genLabel.setText(String.valueOf(lifeGen.currentgen));
    }

    /**
     * method to set previous Generation
     */
    public void prevGen() {
        lifeGen.prevGen();
        // update label
        genLabel.setText(String.valueOf(lifeGen.currentgen));
    }
}