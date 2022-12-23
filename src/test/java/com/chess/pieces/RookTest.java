/**
 * RookTest.java
 * A class that tests the rook.
 *
 * @author Kurt Matthew Amodia
 * @author Chester Ken Gallego
 * @author Ervene Jhay Gambito
 */

package com.chess.pieces;

import static org.junit.Assert.*;

import org.junit.Test;

public class RookTest {

    @Test
    public void testHasMoved() {
        Rook whiteRook = new Rook("White", 0, 0);
        Rook blackRook = new Rook("Black", 7, 7);

        assertFalse(whiteRook.hasMoved());
        assertFalse(blackRook.hasMoved());

        whiteRook.didMove();
        blackRook.didMove();

        assertTrue(whiteRook.hasMoved());
        assertTrue(blackRook.hasMoved());
    }

    @Test
    public void testCanMove() {
        Rook whiteRook = new Rook("White", 0, 0);
        Rook blackRook = new Rook("Black", 7, 7);

        Piece[][] chessboard = new Piece[8][8];
        chessboard[0][0] = whiteRook;
        chessboard[7][7] = blackRook;

        // Test moving to an occupied square with a piece of the same color
        assertFalse(whiteRook.canMove(chessboard, 7, 7));
        assertFalse(blackRook.canMove(chessboard, 0, 0));

        // Test moving to an occupied square with a piece of a different color
        chessboard[4][4] = new Rook("White", 4, 4);
        assertFalse(blackRook.canMove(chessboard, 4, 4));

        // Test moving to an empty square on the same rank
        assertTrue(whiteRook.canMove(chessboard, 0, 4));
        assertTrue(blackRook.canMove(chessboard, 7, 3));

        // Test moving to an empty square on the same file
        assertTrue(whiteRook.canMove(chessboard, 4, 0));
        assertTrue(blackRook.canMove(chessboard, 3, 7));

        // Test moving to a square that is not on the same rank or file
        assertFalse(whiteRook.canMove(chessboard, 1, 1));
        assertFalse(blackRook.canMove(chessboard, 6, 6));
    }

    @Test
    public void testToString() {
        Rook whiteRook = new Rook("White", 0, 0);
        Rook blackRook = new Rook("Black", 7, 7);

        assertTrue(whiteRook.toString().contains("YELLOW"));
        assertTrue(blackRook.toString().contains("BLUE"));
    }
}
