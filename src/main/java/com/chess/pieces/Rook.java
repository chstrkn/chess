/**
 * Rook.java
 * A class that represents a rook in a chess game.
 *
 * @author Kurt Matthew Amodia
 * @author Chester Ken Gallego
 * @author Ervene Jhay Gambito
 */

package com.chess.pieces;

import com.chess.util.ChessPrinter;

public class Rook extends Piece {
    private boolean hasMoved;

    public Rook(String color, int rank, int file) {
        super("Rook", color, rank, file);
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
        // Check if the destination is on the same rank
        if (this.getRank() == rank) {
            if (this.getFile() < file) {
                for (int i = 1; i < file - this.getFile(); i++) {
                    if (chessboard[this.getRank()][this.getFile() + i] != null) {
                        return false;
                    }
                }
            } else if (this.getFile() > file) {
                for (int i = 1; i < this.getFile() - file; i++) {
                    if (chessboard[this.getRank()][this.getFile() - i] != null) {
                        return false;
                    }
                }
            }
            return true;
        }
        // Check if the destination is on the same file
        if (this.getFile() == file) {
            if (this.getRank() < rank) {
                for (int i = 1; i < rank - this.getRank(); i++) {
                    if (chessboard[this.getRank() + i][this.getFile()] != null) {
                        return false;
                    }
                }
            } else if (this.getRank() > rank) {
                for (int i = 1; i < this.getRank() - rank; i++) {
                    if (chessboard[this.getRank() - i][this.getFile()] != null) {
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
            return ChessPrinter.ANSI_YELLOW + "R" + ChessPrinter.ANSI_RESET;
        } else {
            return ChessPrinter.ANSI_BLUE + "R" + ChessPrinter.ANSI_RESET;
        }
    }
}
