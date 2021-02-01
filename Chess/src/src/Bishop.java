package src;

public class Bishop extends Piece { 
  
    public Bishop(boolean white) 
    { 
        super(white); 
    }
	
	public boolean canMove(Spot start, Spot end, Board board) throws Exception
	{
        if (end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()) {
        	//cant move ontop of piece of the same color
            return false;
        }

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