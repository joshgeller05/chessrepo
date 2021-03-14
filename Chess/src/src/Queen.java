package src;

public class Queen extends Piece { 
  
    public Queen(boolean white) 
    { 
        super(white); 
    }

	@Override
	public PieceType type() {
		return PieceType.QUEEN;
	}

    /**
     * can move implementation for the queen
     * return - whether or not the queen can move to the end spot
     */
	@Override
	public boolean canMove(Spot start, Spot end, Board board) throws Exception {
		  //checking if it can move up and down
		  if (start.getY() == end.getY()) {
				for (int i = Math.min(start.getX(), end.getX()) + 1; i < Math.max(start.getX(), end.getX()); i++) {
					 if (board.getSpot(i, start.getY()).getPiece() != null) {
						  return false;
					 }
				}
				return true;
		  } else if (start.getX() == end.getX()) {
			  //checking if it can move left and right
				for (int i = Math.min(start.getY(), end.getY()) + 1; i < Math.max(start.getY(), end.getY()); i++) {
					 if (board.getSpot(start.getX(), i).getPiece() != null) {
						  return false;
					 }
				}
				return true;
		  } else if (Math.abs(start.getY() - end.getY()) == Math.abs(start.getX() - end.getX())) {
			  //checking if it can move diagonally
				int minX = Math.min(start.getX(), end.getX());
				int maxX = Math.max(start.getX(), end.getX());

				int minY = Math.min(start.getY(), end.getY());
				int maxY = Math.max(start.getY(), end.getY());

				int xIndex = minX + 1;
				int yIndex = minY + 1;

				while (xIndex < maxX && yIndex < maxY) {
					 if (board.getSpot(xIndex, yIndex).getPiece() != null) {
						  return false;
					 }

					 xIndex++;
					 yIndex++;
				}
				return true;
		  } else {
				return false;
		  }
	} 
  
}