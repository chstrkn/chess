/**
 * BishopTest.java
 * A class that tests the bishop class.
 *
 * @author Kurt Matthew Amodia
 * @author Chester Ken Gallego
 * @author Ervene Jhay Gambito
 */

package com.chess.pieces;

import static org.junit.Assert.*;

import org.junit.Test;

public class BishopTest {

    @Test
    public void testCanMove() {
        Piece[][] chessboard = new Piece[8][8];
        Bishop bishop = new Bishop("White", 3, 3);
        chessboard[3][3] = bishop;

        // Test moving to unoccupied square on same diagonal
        assertTrue(bishop.canMove(chessboard, 5, 5));
        // Test moving to occupied square on same diagonal with different color piece
        chessboard[5][5] = new Bishop("Black", 5, 5);
        assertTrue(bishop.canMove(chessboard, 5, 5));
        // Test moving to occupied square on same diagonal with same color piece
        chessboard[5][5] = new Bishop("White", 5, 5);
        assertFalse(bishop.canMove(chessboard, 5, 5));
        // Test moving to unoccupied square on different diagonal
        assertFalse(bishop.canMove(chessboard, 4, 6));
        // Test moving to same square
        assertFalse(bishop.canMove(chessboard, 3, 3));
    }
}
