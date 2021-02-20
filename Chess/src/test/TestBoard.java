package test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Board;
import src.Pawn;
import src.Piece;
import src.Spot;

class TestBoard {
	
	private Board b;
	
	@BeforeEach
	public void setUp()
	{
		b = new Board();
	}
	
	@Test
	public void testGetLength()
	{
		assertEquals(8, b.getLength());
	}
	
	@Test
	public void testGetSpot() 
	{
		try {
			assertEquals(new Spot(1,1,null),b.getSpot(1, 1));
		} catch (Exception e) {
			fail();
		}
		
		boolean failure = false;
		
		try {
			assertEquals(new Spot(9,9,null),b.getSpot(9, 9));
		} catch (Exception e) {
			failure = true;
		}
		
		assertTrue(failure);
	}
	
	@Test
	public void testGetPieceAt() throws Exception
	{
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
		
		Piece p = b.getPieceAt(3, 1);
		
		assertEquals(pawn,p);
		
		p = b.getPieceAt(5, 1);
		
		assertEquals(null,p);
	}

}
