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
		return false;
	} 
  
}