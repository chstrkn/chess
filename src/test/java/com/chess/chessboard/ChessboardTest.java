/**
 * ChessboardTest.java
 * A class that tests the chessboard class.
 *
 * @author Kurt Matthew Amodia
 * @author Chester Ken Gallego
 * @author Ervene Jhay Gambito
 */

package com.chess.chessboard;

import com.chess.pieces.King;
import com.chess.pieces.Pawn;
import com.chess.pieces.Piece;
import com.chess.pieces.Queen;
import com.chess.pieces.Rook;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChessboardTest {
    Chessboard board;

    @Test
    public void testGetChessboard() {
        board = new Chessboard();
        Piece[][] chessboard = board.getChessboard();
        assertNotNull(chessboard);
        assertEquals(8, chessboard.length);
        assertEquals(8, chessboard[0].length);
    }

    @Test
    public void testIsValidSquare() {
        board = new Chessboard();
        assertTrue(board.isValidSquare("a1"));
        assertTrue(board.isValidSquare("h8"));
        assertFalse(board.isValidSquare("i1"));
        assertFalse(board.isValidSquare("a9"));
        assertFalse(board.isValidSquare("a1a1"));
    }

    @Test
    public void testGetRank() {
        board = new Chessboard();
        assertEquals(7, board.getRank("a1"));
        assertEquals(0, board.getRank("h8"));
    }

    @Test
    public void testGetFile() {
        board = new Chessboard();
        assertEquals(0, board.getFile("a1"));
        assertEquals(7, board.getFile("h8"));
    }

    @Test
    public void testGetPiece() {
        board = new Chessboard();
        assertTrue(board.getPiece("a1") instanceof Rook);
        assertTrue(board.getPiece("e2") instanceof Pawn);
        assertNull(board.getPiece("d5"));
    }

    @Test
    public void testGetPieceIntInt() {
        board = new Chessboard();
        assertTrue(board.getPiece(7, 0) instanceof Rook);
        assertTrue(board.getPiece(1, 4) instanceof Pawn);
        assertNull(board.getPiece(4, 4));
    }

    @Test
    public void testRemovePiece() {
        board = new Chessboard();
        board.removePiece(7, 0);
        assertNull(board.getPiece(7, 0));
    }

    @Test
    public void testGetKingRank() {
        board = new Chessboard();
        assertEquals(7, board.getKingRank("White"));
        assertEquals(0, board.getKingRank("Black"));
        assertEquals(-1, board.getKingRank("Green"));
    }

    @Test
    public void testGetKingFile() {
        board = new Chessboard();
        assertEquals(4, board.getKingFile("White"));
        assertEquals(4, board.getKingFile("Black"));
        assertEquals(-1, board.getKingFile("Green"));
    }

    @Test
    public void testIsEmptySquare() {
        board = new Chessboard();
        assertFalse(board.isEmptySquare("a1"));
        assertFalse(board.isEmptySquare("e2"));
        assertTrue(board.isEmptySquare("d5"));
    }

    @Test
    public void testMovePiece() {
        board = new Chessboard();
        // Test moving a pawn
        Pawn pawn = (Pawn) board.getPiece("a2");
        board.movePiece("a2", "a4");
        assertEquals(board.getPiece("a4"), pawn);
        assertNull(board.getPiece("a2"));
        assertTrue(pawn.hasMoved());
        // Test moving a king
        King king = (King) board.getPiece("e8");
        board.movePiece("e8", "g8");
        assertEquals(board.getPiece("g8"), king);
        assertNull(board.getPiece("e8"));
        assertTrue(king.hasMoved());
        // Test moving a rook
        Piece rook = board.getPiece("a8");
        board.movePiece("a8", "d8");
        assertEquals(board.getPiece("d8"), rook);
        assertNull(board.getPiece("a8"));
        if (rook instanceof Rook) {
            assertTrue(((Rook) rook).hasMoved());
        }
    }

    @Test
    public void testResetDoubleMove() {
        board = new Chessboard();
        // Test resetting the double move of a pawn
        Pawn pawn = (Pawn) board.getPiece("a2");
        pawn.setHasDoubleMoved(true);
        board.resetDoubleMove();
        assertFalse(pawn.hasDoubleMoved());
    }

    @Test
    public void testPromotePawn() {
        board = new Chessboard();
        // Test promoting a pawn to a queen
        Pawn pawn = (Pawn) board.getPiece("a7");
        board.promotePawn("a7", "Queen");
        assertTrue(board.getPiece("a7") instanceof Queen);
        assertNull(board.getPiece("a7") instanceof Pawn);
    }

    @Test
    public void testIsCheck() {
        board = new Chessboard();
        // Test if the white king is in check
        King whiteKing = (King) board.getPiece("e1");
        Rook blackRook = (Rook) board.getPiece("h8");
        board.movePiece("h8", "e8");
        assertTrue(board.isCheck("White"));
        // Test if the black king is not in check
        assertFalse(board.isCheck("Black"));
    }

    @Test
    public void testIsStillCheck() {
        board = new Chessboard();
        // Test if the white king is still in check
        King whiteKing = (King) board.getPiece("e1");
        Rook blackRook = (Rook) board.getPiece("h8");
        board.movePiece("h8", "e8");
        assertTrue(board.isStillCheck("White"));
        // Test if the black king is not in check
        assertFalse(board.isStillCheck("Black"));
    }

    @Test
    public void testIsCheckAfterMove() {
        board = new Chessboard();
        // Test if a move would put the white king in check
        King whiteKing = (King) board.getPiece("e1");
        Rook blackRook = (Rook) board.getPiece("h8");
        assertTrue(board.isCheckAfterMove(whiteKing, "e8"));
        // Test if a move would not put the black king in check
        assertFalse(board.isCheckAfterMove(blackRook, "h7"));
    }

    @Test
    public void testIsCheckmate() {
        board = new Chessboard();
        // Test if the white king is in checkmate
        King whiteKing = (King) board.getPiece("e1");
        Rook blackRook = (Rook) board.getPiece("h8");
        board.movePiece("h8", "e8");
        assertTrue(board.isCheckmate("White"));
        // Test if the black king is not in checkmate
        assertFalse(board.isCheckmate("Black"));
    }

    @Test
    public void testIsStalemate() {
        board = new Chessboard();
        // Test if the white king is in stalemate
        assertTrue(board.isStalemate("White"));
        // Test if the black king is not in stalemate
        assertFalse(board.isStalemate("Black"));
    }
}
