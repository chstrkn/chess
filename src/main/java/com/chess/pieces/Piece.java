/**
 * Piece.java
 * An abstract class that represents a chess piece in a chess game.
 *
 * @author Kurt Matthew Amodia
 * @author Chester Ken Gallego
 * @author Ervene Jhay Gambito
 */

package com.chess.pieces;

public abstract class Piece {
    private String type;
    private String color;
    private int rank;
    private int file;

    public Piece(String name, String color, int rank, int file) {
        this.type = name;
        this.color = color;
        this.rank = rank;
        this.file = file;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getFile() {
        return file;
    }

    public void setFile(int file) {
        this.file = file;
    }

    public abstract boolean canMove(Piece[][] chessboard, int rank, int file);
}
