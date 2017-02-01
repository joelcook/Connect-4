/*
 Joel Cook
 ConnectFour
 June 3 2016
 */
package core;

import java.util.ArrayList;
import userInterface.RoundButton;

/**
 *
 * @author joel
 */
public interface Connect4State {
    //beginning of  methods
    public RoundButton[][] getBoard();
    public ArrayList<Player> getPlayers();  
    public int getPlayerNum();  
    public Player getPlayerToMove(); 
    public boolean isValidMove(int col);
    public void makeMove(int col);
    public boolean isFull();
    public boolean gameIsOver();
    //end of methods
}
