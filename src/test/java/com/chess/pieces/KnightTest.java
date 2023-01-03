/**
 * KnightTest.java
 * A class that tests the knight class.
 *
 * @author Kurt Matthew Amodia
 * @author Chester Ken Gallego
 * @author Ervene Jhay Gambito
 */

package com.chess.pieces;

import static org.junit.Assert.*;

import org.junit.Test;

public class KnightTest {

    @Test
    public void testCanMove() {
        Piece[][] chessboard = new Piece[8][8];
        Knight knight = new Knight("White", 3, 3);
        chessboard[3][3] = knight;

        // Test moving to unoccupied square in L shape
        assertTrue(knight.canMove(chessboard, 5, 4));
        // Test moving to occupied square in L shape with different color piece
        chessboard[5][4] = new Knight("Black", 5, 4);
        assertTrue(knight.canMove(chessboard, 5, 4));
        // Test moving to occupied square in L shape with same color piece
        chessboard[5][4] = new Knight("White", 5, 4);
        assertFalse(knight.canMove(chessboard, 5, 4));
        // Test moving to unoccupied square not in L shape
        assertFalse(knight.canMove(chessboard, 4, 4));
        // Test moving to same square
        assertFalse(knight.canMove(chessboard, 3, 3));
    }

}
