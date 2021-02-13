package src;

public class King extends Piece { 
  
    public King(boolean white) 
    { 
        super(white); 
    }

	@Override
	public PieceType type() {
		return PieceType.KING;
	}

	@Override
	public boolean canMove(Spot start, Spot end, Board board) throws Exception {
		boolean result = true;
	        if (end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()) {
	            result = false;
	        }
	        

	        if (start.getX() == end.getX()) {
	            result = Math.abs(start.getY() - end.getY()) <= 1;
	        } else if (start.getY() == end.getY()) {
	            result =  Math.abs(start.getX() - end.getX()) <= 1;
	        } else if (Math.abs(start.getX() - end.getX()) + Math.abs(start.getY() - end.getY()) > 2) {
	            result =  false;
	        }

	        if(result)
	        {
		        for(Spot spot : board.getSpots())
		        {
		        	if(spot.getPiece() != null)
		        	{
		        		if(!(spot.getPiece() instanceof King) && (spot.getPiece().isWhite() != this.isWhite()) 
		        			&& spot.getPiece().canMove(spot, end, board))
		        		{
		        			//need to check if any other pieces on the board
		        			//can move to the spot the king is about to move to
		        			result = false;
		        		}
		        	}
		        }	
	        }
	        
	        return result;
	} 
  
}