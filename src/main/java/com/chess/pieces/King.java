/**
 * King.java
 * A class that represents a king in a chess game.
 *
 * @author Kurt Matthew Amodia
 * @author Chester Ken Gallego
 * @author Ervene Jhay Gambito
 */

package com.chess.pieces;

import com.chess.util.ChessPrinter;

public class King extends Piece {
    private boolean hasMoved;

    public King(String color, int rank, int file) {
        super("King", color, rank, file);
        this.hasMoved = false;
    }

    public boolean hasMoved() {
        return hasMoved;
    }

    public void didMove() {
        this.hasMoved = true;
    }

    @Override
    public boolean canMove(Piece[][] chessboard, int rank, int file) {
        // Check if the piece is not moving
        if (this.getRank() == rank && this.getFile() == file) {
            return false;
        }
        // Check if the destination is occupied by a piece of the same color
        if (chessboard[rank][file] != null && chessboard[rank][file].getColor().equals(this.getColor())) {
            return false;
        }
        // Check if the destination is one square away
        if (Math.abs(this.getRank() - rank) <= 1 && Math.abs(this.getFile() - file) <= 1) {
            return true;
        }
        // Check if the destination is a castle
        if (this.getRank() == rank && this.getFile() == 4 && this.hasMoved == false) {
            if (file == 6 && chessboard[rank][7] != null && chessboard[rank][7].getType().equals("Rook")
                    && ((Rook) chessboard[rank][7]).hasMoved() == false) {
                if (chessboard[rank][5] == null && chessboard[rank][6] == null) {
                    return true;
                }
            } else if (file == 2 && chessboard[rank][0] != null && chessboard[rank][0].getType().equals("Rook")
                    && ((Rook) chessboard[rank][0]).hasMoved() == false) {
                if (chessboard[rank][1] == null && chessboard[rank][2] == null && chessboard[rank][3] == null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (this.getColor().equals("White")) {
            return ChessPrinter.ANSI_YELLOW + "K" + ChessPrinter.ANSI_RESET;
        } else {
            return ChessPrinter.ANSI_BLUE + "K" + ChessPrinter.ANSI_RESET;
        }
    }
}
