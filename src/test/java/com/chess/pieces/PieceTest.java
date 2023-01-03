/**
 * PieceTest.java
 * A class that tests the piece class.
 *
 * @author Kurt Matthew Amodia
 * @author Chester Ken Gallego
 * @author Ervene Jhay Gambito
 */

package com.chess.pieces;

import static org.junit.Assert.*;

import org.junit.Test;

public class PieceTest {
    @Test
    public void testGetType() {
        Piece pawn = new Pawn("White", 6, 0);
        assertEquals("Pawn", pawn.getType());
    }

    @Test
    public void testGetColor() {
        Piece bishop = new Bishop("Black", 0, 2);
        assertEquals("Black", bishop.getColor());
    }

    @Test
    public void testGetRank() {
        Piece queen = new Queen("White", 3, 3);
        assertEquals(3, queen.getRank());
    }

    @Test
    public void testSetRank() {
        Piece rook = new Rook("Black", 7, 7);
        rook.setRank(0);
        assertEquals(0, rook.getRank());
    }

    @Test
    public void testGetFile() {
        Piece knight = new Knight("White", 2, 4);
        assertEquals(4, knight.getFile());
    }

    @Test
    public void testSetFile() {
        Piece king = new King("Black", 0, 4);
        king.setFile(7);
        assertEquals(7, king.getFile());
    }
}
