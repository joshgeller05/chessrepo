public class Board { 
    Spot[][] board;
  
    public Board() 
    { 
    	board = new Spot[7][7];
    } 
    
    public Spot getSpot(int x, int y) throws Exception 
    { 
  
        if (x < 0 || x > 7 || y < 0 || y > 7) { 
            throw new Exception("Index out of bound"); 
        } 
  
        return board[x][y]; 
    } 
  
} 