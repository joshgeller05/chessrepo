package src;

import java.util.ArrayList;

public class Board { 
    private Spot[][] board;
  
    public Board() 
    { 
    	board = new Spot[8][8];
    	this.resetBoard();
    } 
    
    /**
     * 
     * @param x - of spot
     * @param y - of spot
     * @return - spot at given x&y
     * @throws Exception
     */
    public Spot getSpot(int x, int y) throws Exception 
    { 
  
        try {
            return board[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("Spot out of bounds "+x+" "+y, e);
        }
    } 
    
    /**
     * 
     * @param x - of spot
     * @param y - of spot
     * @return - piece at given spot x&y
     * @throws Exception
     */
    public Piece getPieceAt(int x, int y) throws Exception
    {
    	Spot s = getSpot(x,y);
    	return s.getPiece();
    }
    
    /**
     * 
     * @return all spots on board
     * @throws Exception
     */
    public ArrayList<Spot> getSpots() throws Exception
    {
    	ArrayList<Spot> spots = new ArrayList<Spot>();
    	 for (int row = 0; row < board.length; row++) {
    		    for (int col = 0; col < board.length; col++) {
    		    	Spot s = board[row][col];
    		    	spots.add(s);
    		    }
    		 }
		return spots;
    }
    
    
    /**
     * resets the board 
     */
    public void resetBoard()
    {
        Spot[][] blankBoard = new Spot[8][8];
        for (int i = 0; i < blankBoard.length; i++) {
            for (int j = 0; j < blankBoard.length; j++) {
                blankBoard[i][j] = new Spot(i, j, null);
            }
        }
        this.board = blankBoard;
    }
    
    /**
     * set the board with the given lists of pieces
     * @param white - pieces
     * @param black - pieces
     */
    public void setBoard(ArrayList<Piece> white, ArrayList<Piece> black)
    {
    	for(Piece p : white)
    	{
    		int column = p.getY();
    		int row = p.getX();
    		board[row][column] = new Spot(row,column,p);
    	}
    	
    	for(Piece p : black)
    	{
    		int column = p.getY();
    		int row = p.getX();
    		board[row][column] = new Spot(row,column,p);
    	}
    }
    
    /**
     * set spot on board
     * @param spot
     */
    public void setSpot(Spot spot)
    {
    	board[spot.getX()][spot.getY()] = spot;
    }
    
    /**
     * 
     * @return length of board
     */
    public int getLength()
    {
    	return board.length;
    }
  
} 