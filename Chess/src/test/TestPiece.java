package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Board;
import src.Pawn;
import src.Piece;
import src.Rook;
import src.Spot;

class TestPiece {
	
	private Piece p;
	
	@BeforeEach
	public void setUp()
	{
		p = new Pawn(true);
		p.setX(1);
		p.setY(1);
	}
	
	@Test
	public void testGettersAndSetters()
	{
	
		assertEquals(1,p.getX());
		assertEquals(1,p.getY());
		assertEquals(true,p.isWhite());
	}
	
	@Test
	public void testCanMove() throws Exception
	{
		Board b = new Board();
		ArrayList<Spot> moves = new ArrayList<Spot>();
		moves.add(new Spot(2,1,null));
		moves.add(new Spot(3,1,null));
		assertEquals(moves,p.getMoves(b));
		
		p.resetMoves();
		ArrayList<Piece> white = new ArrayList<Piece>();
		ArrayList<Piece> black = new ArrayList<Piece>();
		Pawn pawn = new Pawn(false);
		pawn.setX(3);
		pawn.setY(1);
		black.add(pawn);
		Pawn whitePawn = new Pawn(true);
		whitePawn.setX(2);
		whitePawn.setY(2);
		white.add(whitePawn);
		b.setBoard(white, black);
		moves.clear();
		moves.add(new Spot(2,1,null));
		assertEquals(moves,p.getMoves(b));
	}
	
	@Test
	public void testHashCode()
	{
		assertEquals(32014, p.hashCode());
	}
	
	@Test
	public void testToAlphabetic()
	{
		assertEquals("B", p.toAlphabetic(1));
		assertEquals("-A", p.toAlphabetic(-1));
	}
	
	@Test
	public void testToString()
	{
		assertEquals("PAWN B2", p.toString());
	}
	
	@Test
	public void testEquals()
	{
		assertTrue(p.equals(p));
		
		assertFalse(p.equals(null));
		
		assertFalse(p.equals(new Rook(false)));
		
		Pawn pawn = new Pawn(false);
		
		pawn.setX(2);
		pawn.setY(2);
		
		assertFalse(p.equals(pawn));
		
		pawn.setY(1);
		
		assertFalse(p.equals(pawn));
		
		pawn.setX(1);
		
		assertFalse(p.equals(pawn));
		
		pawn.setWhite(true);
		
		assertTrue(p.equals(pawn));
	}

}
