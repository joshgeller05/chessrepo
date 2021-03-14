package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Bishop;
import src.Board;
import src.Pawn;
import src.Piece;
import src.PieceType;
import src.Spot;



class TestBishop {
	
	private Piece bishop;
	
	@BeforeEach
	public void setUp()
	{
		bishop = new Bishop(true);
		bishop.setX(0);
		bishop.setY(0);
	}
	
	@Test
	public void testType()
	{
		assertEquals(bishop.type(), PieceType.BISHOP);
	}
	
	@Test
	public void testCanMove() throws Exception
	{
		Board b = new Board();
		b.setSpot(new Spot(0,0,bishop));
		assertTrue(bishop.canMove(new Spot(0,0,bishop), new Spot(4,4,null), b));
	
		Pawn p = new Pawn(true);
		p.setX(4);
		p.setY(4);
		
		assertFalse(bishop.canMove(new Spot(0,0,bishop), new Spot(4,4,p), b));
		
		p = new Pawn(true);
		p.setX(4);
		p.setY(4);
		
		assertFalse(bishop.canMove(new Spot(0,0,bishop), new Spot(4,4,p), b));
		
		b.resetBoard();
		
		b.setSpot(new Spot(7,0,bishop));
		assertTrue(bishop.canMove(new Spot(7,0,bishop), new Spot(3,4,null), b));
	
		p = new Pawn(true);
		p.setX(3);
		p.setY(4);
		
		assertFalse(bishop.canMove(new Spot(7,0,bishop), new Spot(3,4,p), b));
		
		p = new Pawn(true);
		p.setX(3);
		p.setY(4);
		
		assertFalse(bishop.canMove(new Spot(7,0,bishop), new Spot(3,4,p), b));
	}
	

}
