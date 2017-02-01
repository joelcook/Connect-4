/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import core.Player;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

/**
 
 * @author joelcook1
 */
public class Connect4UI extends JFrame{
    
    JMenuBar menuBar; 
    JMenu gameMenu;
    JMenuItem playerPlayer;
    JMenuItem playerComputer;
    JMenuItem computerComputer;
    JMenuItem exit;
    GameListener gameListener;
    ExitListener exitListener;
    Connect4Panel boardPanel;
    
    private ArrayList<Player> thePlayers;
    private Player currentPlayer;
    
    //no arguement custom constructor
    public Connect4UI(ArrayList<Player> player)
    {   
        //set local variable to paramater
        thePlayers = player;
        initComponents();
    }
    //getter boardpanel
    public Connect4Panel getBoardPanel() {
        return boardPanel;
    }   
    
    private void initComponents() 
    {
        setMinimumSize(new Dimension(500,500));
        setPreferredSize(new Dimension(500,500));
         //create menubar,menu,submenu, menuitems 
        menuBar = new JMenuBar();
        gameMenu = new JMenu("Game");
        gameMenu.setMnemonic('G');
        menuBar.add(gameMenu);
        //initialize JMenuItems
        playerPlayer = new JMenuItem("Player vs. Player");
        playerComputer = new JMenuItem("Player vs. Computer");
        computerComputer = new JMenuItem("Computer vs. Computer");
        exit = new JMenuItem("Exit");
        //add them to game menu
        gameMenu.add(playerPlayer);
        gameMenu.add(playerComputer);
        gameMenu.add(computerComputer);
        gameMenu.add(exit);
        //disable playerPlayer & computer Computer
        playerPlayer.setEnabled(false);
        computerComputer.setEnabled(false);
        
        //game menu
        gameListener = new GameListener();
        exitListener = new ExitListener();
        //register action listener to JMenuItem
        playerPlayer.addActionListener(gameListener);
        playerComputer.addActionListener(gameListener);
        computerComputer.addActionListener(gameListener);
        
        exit.addActionListener(exitListener);
        //minstantiate the instance of declared object boardpanel by calling no argument constructor
        boardPanel = new Connect4Panel();
        
        //add components to UI
        this.add(menuBar, BorderLayout.NORTH);
        this.add(boardPanel,BorderLayout.CENTER);
        this.setVisible(true);        
    }
    
    //action listener that evaluates game type based off e.getactioncommand()
    private class GameListener implements ActionListener
    {
        @Override
        //register actionlistener to case
        public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand())
            { 
                case "Player vs. Player":
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                case "Player vs. Computer":
                    
                    break;
                case "Computer vs. Computer":
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        } 
    }
    //action listener to exit from game menu
    private class ExitListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if("Exit".equals(e.getActionCommand()))
            {
                //evaluates what option they selected; yes no cancel
                int option;
                option = JOptionPane.showConfirmDialog(null, "Do you want to exit?");
         
                if (option == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        }
    }
}
