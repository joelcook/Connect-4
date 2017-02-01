/*
 Joel Cook
 ConnectFour
 June 3 2016
 */
package connectfour;

import core.AiPlayer;
import core.Connect4Game;
import core.Connect4State;
import core.Constants;
import core.HumanPlayer;
import core.Player;
import userInterface.Connect4UI;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import userInterface.Connect4View;

/**
 *
 * @author joel
 */
public class ConnectFour {

    private static ArrayList<Player>players;
    private static Connect4UI frame;
    
    public static void main(String[] args) {
        // TODO code application logic here
       //instantiate instance of connectfourUI
        frame = new Connect4UI(getPlayers());
        makePlayers();
        play();          
    }
    
    private static void makePlayers() {
        players = new ArrayList<Player>();//initialize player variable
        String name = JOptionPane.showInputDialog("Enter name");//prompt for players name
        //instantiate instance off humanplayer, player
        Player humanPlayer = new HumanPlayer(name);  
        Player aiPlayer = new AiPlayer("Computer",5); 
        //add each player to arraylist
        players.add(humanPlayer);
        players.add(aiPlayer);
    }
    
    public static ArrayList getPlayers()
    {
        return players;
    }
    
    private static void play(){
        
        
        Player currentPlayer = players.get(Constants.PLAYER2);
        Connect4Game state = new Connect4Game(0,players,frame.getBoardPanel().getButtonBoard());
        
        while (true){
            if(currentPlayer == players.get(Constants.PLAYER1))
            {
                currentPlayer = players.get(Constants.PLAYER2);
                state.playerToMoveNum = 0;
                
                int move = state.getPlayerToMove().getMove(state);//or gameState idk yet for paramater
                state.makeMove(move);
                
                if(state.connectFourAnywhere() && !state.isFull()){
                    JOptionPane.showMessageDialog(null, "computer wins");
                    break;
                }
                else if (state.isFull())
                {
                    JOptionPane.showMessageDialog(null, "Game is a draw");
                    break;
                }
            }
            else
            {                              
                currentPlayer = players.get(Constants.PLAYER1);
                state.playerToMoveNum = 1;
                
                JOptionPane.showMessageDialog(null, "Human Turn.");
                
                try{
                    Thread.sleep(2000);
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
                if(state.connectFourAnywhere() && !state.isFull())
                {
                    JOptionPane.showMessageDialog(null, currentPlayer.getName() + " wins");
                    break;
                }
                else if(state.isFull())
                {
                    JOptionPane.showMessageDialog(null, "Game is a draw");
                    break;
                }
                
            }
        }
        
    }
        
        /*players.get(playerTurn).getMove(gameState);
        playerTurn++;
        playerTurn%=players.size();
        
        if(gameState.isFull()||gameState.gameIsOver())
        {
            return true;
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ConnectFour.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;*/
    
    
}
