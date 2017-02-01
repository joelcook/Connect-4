/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import core.Constants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author joelcook1
 */
public class Connect4Panel extends JPanel{
    
    private BoardListener boardListener;
    private RoundButton[][] buttonBoard;
    //contructor with zero parameters call superclass, method-initComonents
    public Connect4Panel()
    {
        super();
        initComponents();
    }
    
    private void initComponents() {
        //call method setLayour,min,perferred,backgroud=nd
        setLayout(new GridLayout(Constants.ROWS,Constants.COLS));
        setMinimumSize(new Dimension(500,500));
        setPreferredSize(new Dimension(500,500));
        setBackground(Color.BLUE);
        //instantiate insatance of boardlistener,buttonBoard
        boardListener = new BoardListener();
        buttonBoard = new RoundButton[Constants.ROWS][Constants.COLS];
        //access 2D array buttonboard
        for(int row = 0; row<Constants.ROWS;row++){
            for(int col = 0; col<Constants.COLS;col++){
                //RoundButton tempButton = new RoundButton();
                
                    //when you click on top row call actionListener
                    //tempButton.addActionListener(boardListener);
                    buttonBoard[row][col] = new RoundButton();
                    getButtonBoard()[row][col].putClientProperty("col", col);
                    getButtonBoard()[row][col].putClientProperty("row", row);
                    getButtonBoard()[row][col].setBackground(Constants.EMPTY);
                    getButtonBoard()[row][col].putClientProperty("color",Constants.EMPTY);
                if(row == 0){
                    getButtonBoard()[row][col].addActionListener(boardListener);
                }
                this.add(getButtonBoard()[row][col]);
                
                /*tempButton.putClientProperty("row", row);
                tempButton.putClientProperty("col", col);               
                tempButton.putClientProperty("color", Color.WHITE);
                
                buttonBoard[row][col] = tempButton;
                this.add(tempButton);*/
            }
        }
         
    }
    
    public Connect4Panel getConnect4Panel(){
        return this;
    }

    public RoundButton[][] getButtonBoard() {
        return buttonBoard;
    }
    
    private class BoardListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            //check if instance of e is of type JButton
            JButton source = (JButton)e.getSource();
            if (source != null)
            {
                int colClick = (int)source.getClientProperty("col");
                Color color = (Color)source.getClientProperty("color");
                //System.out.print("(" + row + "," + col +  ")");
                
                for(int i = Constants.ROWS - 1; i >=0;i--)
                {
                    if(getButtonBoard()[i][colClick].getClientProperty("color") == Constants.EMPTY)
                    {
                        getButtonBoard()[i][colClick].putClientProperty("color", Color.RED);
                        getButtonBoard()[i][colClick].setBackground(Color.RED);
                        //System.out.println("Column: " + colClick + ", Row: " + i);
                        break;
                    }
                    
                }
                
                
            }
            
        }
    }
}
