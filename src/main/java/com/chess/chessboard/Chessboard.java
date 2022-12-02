/**
 * Chessboard.java
 * A class that represents a chessboard in a chess game.
 *
 * @author Kurt Matthew Amodia
 * @author Chester Ken Gallego
 * @author Ervene Jhay Gambito
 */

package com.chess.chessboard;

import com.chess.pieces.*;

public class Chessboard {
    private Piece[][] chessboard;

    public Chessboard() {
        chessboard = new Piece[8][8];
        this.chessboard[0][0] = new Rook("Black", 0, 0);
        this.chessboard[0][1] = new Knight("Black", 0, 1);
        this.chessboard[0][2] = new Bishop("Black", 0, 2);
        this.chessboard[0][3] = new Queen("Black", 0, 3);
        this.chessboard[0][4] = new King("Black", 0, 4);
        this.chessboard[0][5] = new Bishop("Black", 0, 5);
        this.chessboard[0][6] = new Knight("Black", 0, 6);
        this.chessboard[0][7] = new Rook("Black", 0, 7);
        for (int i = 0; i < 8; i++) {
            this.chessboard[1][i] = new Pawn("Black", 1, i);
        }
        this.chessboard[7][0] = new Rook("White", 7, 0);
        this.chessboard[7][1] = new Knight("White", 7, 1);
        this.chessboard[7][2] = new Bishop("White", 7, 2);
        this.chessboard[7][3] = new Queen("White", 7, 3);
        this.chessboard[7][4] = new King("White", 7, 4);
        this.chessboard[7][5] = new Bishop("White", 7, 5);
        this.chessboard[7][6] = new Knight("White", 7, 6);
        this.chessboard[7][7] = new Rook("White", 7, 7);
        for (int i = 0; i < 8; i++) {
            this.chessboard[6][i] = new Pawn("White", 6, i);
        }
    }

    public Piece[][] getChessboard() {
        return chessboard;
    }

    public boolean isValidSquare(String square) {
        if (square.length() != 2) {
            return false;
        }
        char rank = square.charAt(0);
        char file = square.charAt(1);
        return (rank >= 'a' && rank <= 'h') && (file >= '1' && file <= '8');
    }

    public int getRank(String square) {
        return 8 - Integer.parseInt(square.substring(1));
    }

    public int getFile(String square) {
        return square.charAt(0) - 'a';
    }

    public Piece getPiece(String square) {
        return chessboard[getRank(square)][getFile(square)];

    }

    public boolean isEmptySquare(String square) {
        return chessboard[getRank(square)][getFile(square)] == null;
    }

    public void movePiece(String origin, String destination) {
        chessboard[getRank(destination)][getFile(destination)] = chessboard[getRank(origin)][getFile(origin)];
        chessboard[getRank(origin)][getFile(origin)] = null;
        chessboard[getRank(destination)][getFile(destination)].setRank(getRank(destination));
        chessboard[getRank(destination)][getFile(destination)].setFile(getFile(destination));
    }

    public boolean isCheckmate(String color) {
        return false;
    }

    public boolean isStalemate(String color) {
        return false;
    }
}
