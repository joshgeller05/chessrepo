package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Board;
import src.Pawn;
import src.Piece;
import src.PieceType;
import src.Rook;
import src.Spot;



class TestRook {
	
	private Piece rook;
	
	@BeforeEach
	public void setUp()
	{
		rook = new Rook(true);
		rook.setX(0);
		rook.setY(0);
	}
	
	@Test
	public void testType()
	{
		assertEquals(rook.type(), PieceType.ROOK);
	}
	
	@Test
	public void testCanMove() throws Exception
	{
		//moving up
		Board b = new Board();
		b.setSpot(new Spot(0,0,rook));
		assertTrue(rook.canMove(new Spot(0,0,rook), new Spot(4,0,null), b));
	
		Pawn p = new Pawn(true);
		p.setX(4);
		p.setY(0);
		
		b.setSpot(new Spot(4,0,p));
		
		assertFalse(rook.canMove(new Spot(0,0,rook), new Spot(4,0,p), b));
		
		p = new Pawn(true);
		p.setX(4);
		p.setY(0);
		
		assertFalse(rook.canMove(new Spot(0,0,rook), new Spot(4,0,p), b));
		b.resetBoard();
		
		//moving down
		
		b.setSpot(new Spot(4,0,rook));
		assertTrue(rook.canMove(new Spot(4,0,rook), new Spot(0,0,null), b));
	
		p = new Pawn(true);
		p.setX(0);
		p.setY(0);
		
		b.setSpot(new Spot(0,0,p));
		
		assertFalse(rook.canMove(new Spot(4,0,rook), new Spot(0,0,p), b));
		
		p = new Pawn(true);
		p.setX(0);
		p.setY(0);
		
		assertFalse(rook.canMove(new Spot(4,0,rook), new Spot(0,0,p), b));
		b.resetBoard();
		
		//moving right
		b.setSpot(new Spot(0,0,rook));
		assertTrue(rook.canMove(new Spot(0,0,rook), new Spot(0,4,null), b));
	
		p = new Pawn(true);
		p.setX(0);
		p.setY(4);
		
		b.setSpot(new Spot(0,4,p));
		
		assertFalse(rook.canMove(new Spot(0,0,rook), new Spot(0,4,p), b));
		
		p = new Pawn(true);
		p.setX(0);
		p.setY(4);
		
		assertFalse(rook.canMove(new Spot(0,0,rook), new Spot(0,4,p), b));
		
		//moving left
		b.resetBoard();
		b.setSpot(new Spot(0,4,rook));
		assertTrue(rook.canMove(new Spot(0,4,rook), new Spot(0,0,null), b));
	
		p = new Pawn(true);
		p.setX(0);
		p.setY(0);
		
		b.setSpot(new Spot(0,0,p));
		
		assertFalse(rook.canMove(new Spot(0,4,rook), new Spot(0,0,p), b));
		
		p = new Pawn(true);
		p.setX(0);
		p.setY(0);
		
		assertFalse(rook.canMove(new Spot(0,4,rook), new Spot(0,0,p), b));
	}
	

}
