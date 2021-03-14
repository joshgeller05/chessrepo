package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Board;
import src.Knight;
import src.Pawn;
import src.Piece;
import src.PieceType;
import src.Spot;



class TestKnight {
	
	private Piece knight;
	
	@BeforeEach
	public void setUp()
	{
		knight = new Knight(true);
		knight.setX(0);
		knight.setY(0);
	}
	
	@Test
	public void testType()
	{
		assertEquals(knight.type(), PieceType.KNIGHT);
	}
	
	@Test
	public void testCanMove() throws Exception
	{
		Board b = new Board();
		b.setSpot(new Spot(0,0,knight));
		assertTrue(knight.canMove(new Spot(0,0,knight), new Spot(2,1,null), b));
		
		assertTrue(knight.canMove(new Spot(0,0,knight), new Spot(1,2,null), b));
		
		Pawn p = new Pawn(true);
		p.setX(1);
		p.setY(2);
		
		assertFalse(knight.canMove(new Spot(0,0,knight), new Spot(1,2,p), b));
		
		p = new Pawn(false);
		p.setX(1);
		p.setY(2);
		
		assertTrue(knight.canMove(new Spot(0,0,knight), new Spot(1,2,p), b));
	}
	

}
