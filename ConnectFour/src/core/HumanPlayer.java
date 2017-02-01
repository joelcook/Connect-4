/*
 Joel Cook
 ConnectFour
 June 3 2016
 */
package core;

import java.awt.Color;
//import userInterface.Connect4View;

/**
 *
 * @author joel
 */
//extends superclass player
public class HumanPlayer extends Player {
    //calls superclasse's contrusctor passing the parameter as an argument
    public HumanPlayer(String name)
    {
       super(name);
       color = Color.RED;
    }

    /**
     *
     * @param state
     * @param view
     * @return
     */
    
    //method
    @Override
    public int getMove(Connect4State state)
    {
        //get a move for the user
        return 0;
    }
    
}
