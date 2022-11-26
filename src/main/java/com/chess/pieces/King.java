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
    public King(String color, int rank, int file) {
        super("King", color, rank, file);
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
