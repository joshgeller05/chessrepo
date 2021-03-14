package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Bishop;
import src.Board;
import src.King;
import src.Pawn;
import src.Piece;
import src.PieceType;
import src.Spot;



class TestKing {
	
	private Piece king;
	
	@BeforeEach
	public void setUp()
	{
		king = new King(true);
		king.setX(0);
		king.setY(0);
	}
	
	@Test
	public void testType()
	{
		assertEquals(king.type(), PieceType.KING);
	}
	
	@Test
	public void testCanMove() throws Exception
	{
		Board b = new Board();
		b.setSpot(new Spot(0,0,king));
		assertTrue(king.canMove(new Spot(0,0,king), new Spot(1,0,null), b));
				
		Pawn p = new Pawn(true);
		p.setX(1);
		p.setY(0);
		
		assertFalse(king.canMove(new Spot(0,0,king), new Spot(1,0,p), b));
		
		p = new Pawn(false);
		p.setX(1);
		p.setY(0);
		
		assertTrue(king.canMove(new Spot(0,0,king), new Spot(1,0,p), b));
		
		b.setSpot(new Spot(1,0,null));
		
		Bishop bishop = new Bishop(false);
		bishop.setX(2);
		bishop.setY(1);
		
		b.setSpot(new Spot(2,1,bishop));
		
		assertFalse(king.canMove(new Spot(0,0,king), new Spot(1,0,null), b));
		
		b.setSpot(new Spot(2,1,p));
		
		assertFalse(king.canMove(new Spot(0,0,king), new Spot(1,0,king), b));
	}
	

}
