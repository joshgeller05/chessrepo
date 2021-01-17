package src;
import java.util.List;

public class Bishop extends Piece { 
  
    public Bishop(boolean white) 
    { 
        super(white); 
    }

	@Override
	public List<Spot> getMoves(Board board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PieceType type() {
		return PieceType.BISHOP;
	} 
  
}