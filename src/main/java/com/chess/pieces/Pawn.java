/**
 * Pawn.java
 * A class that represents a pawn in a chess game.
 *
 * @author Kurt Matthew Amodia
 * @author Chester Ken Gallego
 * @author Ervene Jhay Gambito
 */

package com.chess.pieces;

import com.chess.util.ChessPrinter;

public class Pawn extends Piece {
    public Pawn(String color, int rank, int file) {
        super("Pawn", color, rank, file);
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
        if (this.getColor().equals("White")) {
            // Check if the pawn can move forward two squares
            if (this.getRank() == 6) {
                if (rank == 4 && file == this.getFile()) {
                    if (chessboard[rank][file] == null) {
                        return true;
                    }
                }
            }
            // Check if the pawn can move forward
            if (rank == this.getRank() - 1 && file == this.getFile()) {
                if (chessboard[rank][file] == null) {
                    return true;
                }
            }
            // Check if the pawn can capture
            if (rank == this.getRank() - 1 && (file == this.getFile() - 1 || file == this.getFile() + 1)) {
                if (chessboard[rank][file] != null) {
                    return true;
                }
            }
        } else {
            // Check if the pawn can move forward two squares
            if (this.getRank() == 1) {
                if (rank == 3 && file == this.getFile()) {
                    if (chessboard[rank][file] == null) {
                        return true;
                    }
                }
            }
            // Check if the pawn can move forward
            if (rank == this.getRank() + 1 && file == this.getFile()) {
                if (chessboard[rank][file] == null) {
                    return true;
                }
            }
            // Check if the pawn can capture
            if (rank == this.getRank() + 1 && (file == this.getFile() - 1 || file == this.getFile() + 1)) {
                if (chessboard[rank][file] != null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (this.getColor().equals("White")) {
            return ChessPrinter.ANSI_YELLOW + "P" + ChessPrinter.ANSI_RESET;
        } else {
            return ChessPrinter.ANSI_BLUE + "P" + ChessPrinter.ANSI_RESET;
        }
    }

}
