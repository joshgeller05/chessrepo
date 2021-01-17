package src;

import java.util.ArrayList;

public class Board { 
    Spot[][] board;
  
    public Board() 
    { 
    	board = new Spot[9][9];
    	this.setSpots();
    } 
    
    public Spot getSpot(int x, int y) throws Exception 
    { 
  
        if (x < 0 || x >= 9 || y < 0 || y >= 9) { 
            throw new Exception("Index out of bound"); 
        } 
  
        return board[x][y]; 
    } 
    
    public Piece getPieceAt(int x, int y) throws Exception
    {
    	Spot s = getSpot(x,y);
    	return s.getPiece();
    }
    
    public ArrayList<Spot> getSpots() throws Exception
    {
    	ArrayList<Spot> spots = new ArrayList<Spot>();
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				Spot spot = this.getSpot(i, j);
				spots.add(spot);

			}
		}
		return spots;
    }
    public void setSpots()
    {
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				board[i][j] = new Spot(i,j,null);

			}
		}
    }
    
    public void setBoard(ArrayList<Piece> white, ArrayList<Piece> black)
    {
    	for(Piece p : white)
    	{
    		int column = p.getColumn();
    		int row = p.getRow()-1;
    		board[row][column] = new Spot(row,column,p);
    	}
    	
    	for(Piece p : black)
    	{
    		int column = p.getColumn();
    		int row = p.getRow()-1;
    		board[row][column] = new Spot(row,column,p);
    	}
    }
  
} 