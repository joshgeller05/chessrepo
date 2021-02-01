package src;

public class Knight extends Piece { 
	
	 private final int[] movesX = new int[] {-1, -2, -2, -1, +1, +2, +2, +1};
	 private final int[] movesY = new int[] {+2, +1, -1, -2, -2, -1, +1, +2};
  
    public Knight(boolean white) 
    { 
        super(white); 
    }



	@Override
	public PieceType type() {
		return PieceType.KNIGHT;
	}

	@Override
	public boolean canMove(Spot start, Spot end, Board board) throws Exception {
		
	 	 if(end.getX() > 8 || end.getX() < 0 || end.getY() > 8 || end.getY() < 0) {
	 		 //ensure spot is valid
	 	 	 return false;
		 }


	 	 if(end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()) {
	 		 //if the spot has a piece make sure its not the same color
	 	 	 return false;
		 }

	 	 for(int i = 0; i < 8; i++) {
	 		 //loop through the possible moves and see if the row/columns line up
	 	 	 if(start.getY() + movesY[i] == end.getY() && start.getX() + movesX[i] == end.getX()) {
	 	 	 	 return true;
			 }
		 }

	 	 return false;
	} 
  
}