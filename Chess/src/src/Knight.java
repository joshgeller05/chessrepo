package src;
import java.util.List;

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
	public List<Spot> getMoves(Board board) throws Exception {
		return moves;
	} 
  
}