package src;

public class Bishop extends Piece { 
  
    public Bishop(boolean white) 
    { 
        super(white); 
    }
	
    /**
     * can move implementation for the bishop
     * return - whether or not the bishop can move to the end spot
     */
	public boolean canMove(Spot start, Spot end, Board board) throws Exception
	{
        if (Math.abs(start.getY() - end.getY()) == Math.abs(start.getX() - end.getX())) {
            int xChange;
            int yChange;

            if(start.getY() < end.getY()) {
                //moving to the right
            	yChange = 1;
            } else {
            	yChange = -1;
            }

            if(start.getX() < end.getX()) {
                //moving up
            	xChange = 1;
            } else {
            	xChange = -1;
            }

            int xIndex = (start.getX() + xChange);
            int yIndex = (start.getY() + yChange);

            while (xIndex != end.getX() && yIndex != end.getY()) {
                if (board.getSpot(xIndex, yIndex).getPiece() != null && xIndex != end.getX() && yIndex != end.getY()) {
                    return false;
                }

                xIndex += xChange;
                yIndex += yChange;            
                
            }
            
        	if(end.getPiece() != null)
        	{
        		if(end.getPiece().isWhite() == this.isWhite())
        		{
        			return false;
        		}
        	}

            return true;
        } else {
            return false;
        }
	}

	@Override
	public PieceType type() {
		return PieceType.BISHOP;
	} 
  
}