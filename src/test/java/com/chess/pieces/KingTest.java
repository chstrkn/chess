/**
 * KingTest.java
 * A class that tests the king class.
 *
 * @author Kurt Matthew Amodia
 * @author Chester Ken Gallego
 * @author Ervene Jhay Gambito
 */

package com.chess.pieces;

import static org.junit.Assert.*;

import org.junit.Test;

public class KingTest {

    @Test
    public void testCanMove() {
        Piece[][] chessboard = new Piece[8][8];
        King king = new King("White", 3, 3);
        chessboard[3][3] = king;

        // Test moving to unoccupied square one square away
        assertTrue(king.canMove(chessboard, 2, 2));
        // Test moving to occupied square one square away with different color piece
        chessboard[2][2] = new King("Black", 2, 2);
        assertTrue(king.canMove(chessboard, 2, 2));
        // Test moving to occupied square one square away with same color piece
        chessboard[2][2] = new King("White", 2, 2);
        assertFalse(king.canMove(chessboard, 2, 2));
        // Test moving to unoccupied square more than one square away
        assertFalse(king.canMove(chessboard, 0, 0));
        // Test moving to same square
        assertFalse(king.canMove(chessboard, 3, 3));
        // Test castle to the right
        chessboard[3][7] = new Rook("White", 3, 7);
        assertTrue(king.canMove(chessboard, 3, 6));
        // Test invalid castle to the right
        chessboard[3][5] = new Bishop("Black", 3, 5);
        assertFalse(king.canMove(chessboard, 3, 6));
        // Test castle to the left
        chessboard[3][0] = new Rook("White", 3, 0);
        assertTrue(king.canMove(chessboard, 3, 2));
        // Test invalid castle to the left
        chessboard[3][1] = new Bishop("Black", 3, 1);
        assertFalse(king.canMove(chessboard, 3, 2));
        // Test castle after king has moved
        king.didMove();
        assertFalse(king.canMove(chessboard, 3, 2));
    }

}
