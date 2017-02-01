/*
 Joel Cook
 ConnectFour
 June 3 2016
 */
package core;

/**
 *
 * @author joel
 */
public class Connect4Move {
    private int value;
    private int move;
    
    //constructor, set local member variables to respective parameters
    public Connect4Move (int value, int move)
    {
       this.value = value;
       this.move = move;
    }
    //getter
    public int getValue()
    {
        return value;
    } 
    //getter
    public int getMove()
    {
        return move;
    }
    //setter
    public void setValue(int newValue)
    {
        value = newValue;
    }
    //setter
    public void setMove(int newMove)
    {
        move = newMove;
    }
        
}
