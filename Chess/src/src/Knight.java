package src;

public class Knight extends Piece { 
  
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
		return false;
	} 
  
}