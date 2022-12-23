/**
 * PawnTest.java
 * A class that tests the pawn class.
 *
 * @author Kurt Matthew Amodia
 * @author Chester Ken Gallego
 * @author Ervene Jhay Gambito
 */

package com.chess.pieces;

import static org.junit.Assert.*;

import org.junit.Test;

public class PawnTest {

    @Test
    public void testCanMove() {
        Piece[][] chessboard = new Piece[8][8];
        Pawn pawn = new Pawn("White", 3, 3);
        chessboard[3][3] = pawn;
        // Test moving forward two squares from starting position
        assertTrue(pawn.canMove(chessboard, 1, 3));
        // Test moving forward one square from starting position
        pawn.didMove();
        assertTrue(pawn.canMove(chessboard, 2, 3));
        // Test moving forward one square to occupied square
        chessboard[2][3] = new Pawn("Black", 2, 3);
        assertTrue(pawn.canMove(chessboard, 2, 3));
        // Test moving forward one square to same color square
        chessboard[2][3] = new Pawn("White", 2, 3);
        assertFalse(pawn.canMove(chessboard, 2, 3));
        // Test capturing diagonally
        chessboard[2][3] = new Pawn("Black", 2, 3);
        assertTrue(pawn.canMove(chessboard, 2, 3));
        // Test capturing diagonally to same color square
        chessboard[2][3] = new Pawn("White", 2, 3);
        assertFalse(pawn.canMove(chessboard, 2, 3));
        // Test moving diagonally without capturing
        assertFalse(pawn.canMove(chessboard, 2, 4));
        // Test moving forward to unoccupied square
        assertFalse(pawn.canMove(chessboard, 1, 3));
        // Test moving to same square
        assertFalse(pawn.canMove(chessboard, 3, 3));
        // Test capturing en passant
        chessboard[4][3] = new Pawn("Black", 4, 3);
        ((Pawn) chessboard[4][3]).setHasDoubleMoved(true);
        assertTrue(pawn.canMove(chessboard, 4, 3));
        // Test capturing en passant to same color square
        chessboard[4][3] = new Pawn("White", 4, 3);
        assertFalse(pawn.canMove(chessboard, 4, 3));
        // Test capturing en passant to unoccupied square
        chessboard[4][3] = new Pawn("Black", 4, 3);
        assertFalse(pawn.canMove(chessboard, 4, 2));
    }
}
