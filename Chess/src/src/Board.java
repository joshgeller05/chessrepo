package src;

import java.util.ArrayList;

public class Board { 
    Spot[][] board;
  
    public Board() 
    { 
    	board = new Spot[8][8];
    } 
    
    public Spot getSpot(int x, int y) throws Exception 
    { 
  
        if (x < 0 || x > 8 || y < 0 || y > 8) { 
            throw new Exception("Index out of bound"); 
        } 
  
        return board[x][y]; 
    } 
    
    public void setBoard(ArrayList<Piece> white, ArrayList<Piece> black)
    {
    	for(Piece p : white)
    	{
    		int column = this.convertColumn(p.getColumn());
    		int row = p.getRow()-1;
    		board[row][column] = new Spot(row,column,p);
    	}
    	
    	for(Piece p : black)
    	{
    		int column = this.convertColumn(p.getColumn());
    		int row = p.getRow()-1;
    		board[row][column] = new Spot(row,column,p);
    	}
    }
    
    public int convertColumn(String column)
    {
    	char[] x = column.toCharArray();
    	int result = -1;
    	for(char c : x){
    	    int temp = (int)c;
    	    int temp_integer = 96; //for lower case
    	    if(temp<=122 & temp>=97)
    	        result =temp-temp_integer;
    	}
    	return result - 1;
    }
  
} 