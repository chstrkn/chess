/**
 * Bishop.java
 * A class that represents a bishop in a chess game.
 *
 * @author Kurt Matthew Amodia
 * @author Chester Ken Gallego
 * @author Ervene Jhay Gambito
 */

package com.chess.pieces;

import com.chess.util.ChessPrinter;

public class Bishop extends Piece {

    public Bishop(String color, int rank, int file) {
        super("Bishop", color, rank, file);
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
        // Check if the destination is on the same diagonal
        if (Math.abs(this.getRank() - rank) == Math.abs(this.getFile() - file)) {
            if (this.getRank() < rank && this.getFile() < file) {
                for (int i = 1; i < rank - this.getRank(); i++) {
                    if (chessboard[this.getRank() + i][this.getFile() + i] != null) {
                        return false;
                    }
                }
            } else if (this.getRank() < rank && this.getFile() > file) {
                for (int i = 1; i < rank - this.getRank(); i++) {
                    if (chessboard[this.getRank() + i][this.getFile() - i] != null) {
                        return false;
                    }
                }
            } else if (this.getRank() > rank && this.getFile() < file) {
                for (int i = 1; i < this.getRank() - rank; i++) {
                    if (chessboard[this.getRank() - i][this.getFile() + i] != null) {
                        return false;
                    }
                }
            } else if (this.getRank() > rank && this.getFile() > file) {
                for (int i = 1; i < this.getRank() - rank; i++) {
                    if (chessboard[this.getRank() - i][this.getFile() - i] != null) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (this.getColor().equals("White")) {
            return ChessPrinter.ANSI_YELLOW + "B" + ChessPrinter.ANSI_RESET;
        } else {
            return ChessPrinter.ANSI_BLUE + "B" + ChessPrinter.ANSI_RESET;
        }
    }
}
