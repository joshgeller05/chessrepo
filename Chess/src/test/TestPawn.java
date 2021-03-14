package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Board;
import src.Pawn;
import src.Piece;
import src.PieceType;
import src.Spot;

class TestPawn {
	
	private Board b;
	
	private Pawn p;
	
	@BeforeEach
	public void setUp()
	{
		b = new Board();
		p = new Pawn(true);
		p.setX(0);
		p.setY(1);
		
		ArrayList<Piece> white = new ArrayList<Piece>();
		ArrayList<Piece> black = new ArrayList<Piece>();
		Pawn pawn = new Pawn(false);
		pawn.setX(1);
		pawn.setY(1);
		black.add(pawn);
		Pawn whitePawn = new Pawn(true);
		whitePawn.setX(2);
		whitePawn.setY(2);
		white.add(p);
		white.add(whitePawn);
		b.setBoard(white, black);
	}
	
	@Test
	public void testIsMoved()
	{
		assertTrue(p.isMoved());
		
		p.setX(1);
		
		assertFalse(p.isMoved());
		
		p.setWhite(false);
		p.setX(6);
		assertFalse(p.isMoved());
		
		p.setX(5);
		assertTrue(p.isMoved());
	}
	
	@Test
	public void testType()
	{
		assertEquals(p.type(),PieceType.PAWN);
	}
	
	@Test
	public void testCanMove() throws Exception
	{
		assertFalse(p.canMove(b.getSpot(0, 1), b.getSpot(1, 1), b));
		
		assertFalse(p.canMove(b.getSpot(0, 1), b.getSpot(2, 1), b));
		
		p.setX(1);
		p.setY(1);
		assertTrue(p.canMove(b.getSpot(1, 1), b.getSpot(3, 1), b));
		
		b.setSpot(new Spot(1,2,new Pawn(false)));
		
		assertFalse(p.canMove(b.getSpot(1, 1), b.getSpot(1, 2), b));
		
		p.setX(3);
		p.setY(3);
		b.setSpot(new Spot(3,3,p));
		
		assertTrue(p.canMove(b.getSpot(3, 3), b.getSpot(4, 3), b));
		p.setWhite(false);
		b.setSpot(new Spot(3,3,p));
		
		assertFalse(p.canMove(b.getSpot(3, 3), b.getSpot(4, 3), b));
		
		p.setWhite(true);
		b.setSpot(new Spot(3,3,p));
		b.setSpot(new Spot(4,2,new Pawn(false)));
		
		assertTrue(p.canMove(b.getSpot(3, 3), b.getSpot(4, 2), b));

	}
	

}
