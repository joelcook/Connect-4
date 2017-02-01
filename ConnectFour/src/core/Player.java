/*
 Joel Cook
 ConnectFour
 June 3 2016
 */
package core;

import java.awt.Color;


/**
 *
 * @author joel
 */
//abstract class
public abstract class Player{
    
    protected String playerName;
    protected Color color;
    
    //getter for color
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    //constructor, set member variable to parameter
    public Player (String name)
    {
        playerName = name;
    }
    
    /**
     *
     * @return
     */
    //method
    public String getName()
    {
        return playerName;
    }
    
    /**
     *
     * @param state
     * @param view
     * @return
     */
    //method 
    public abstract int getMove(Connect4State state);
}
