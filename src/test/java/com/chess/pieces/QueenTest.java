/**
 * QueenTest.java
 * A class that tests the queen class.
 *
 * @author Kurt Matthew Amodia
 * @author Chester Ken Gallego
 * @author Ervene Jhay Gambito
 */

package com.chess.pieces;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueenTest {
    @Test
    public void testCanMove() {
        // Create a Queen object
        Queen queen = new Queen("White", 4, 4);

        // Create a chessboard
        Piece[][] chessboard = new Piece[8][8];

        // Test moving to an empty space on the same rank
        assertTrue(queen.canMove(chessboard, 4, 5));

        // Test moving to an occupied space on the same rank
        chessboard[4][5] = new Pawn("Black", 4, 5);
        assertFalse(queen.canMove(chessboard, 4, 5));

        // Test moving to an empty space on the same file
        assertTrue(queen.canMove(chessboard, 5, 4));

        // Test moving to an occupied space on the same file
        chessboard[5][4] = new Pawn("Black", 5, 4);
        assertFalse(queen.canMove(chessboard, 5, 4));

        // Test moving to an empty space on the same diagonal
        assertTrue(queen.canMove(chessboard, 5, 5));

        // Test moving to an occupied space on the same diagonal
        chessboard[5][5] = new Pawn("Black", 5, 5);
        assertFalse(queen.canMove(chessboard, 5, 5));

        // Test moving to an empty space that is not on the same rank, file, or diagonal
        assertFalse(queen.canMove(chessboard, 6, 6));
    }
}
