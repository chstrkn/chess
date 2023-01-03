/**
 * ChessPrinter.java
 * A class that contains the methods used to print the chess game to the terminal.
 *
 * @author Kurt Matthew Amodia
 * @author Chester Ken Gallego
 * @author Ervene Jhay Gambito
 */

package com.chess.util;

import com.chess.chessboard.Chessboard;
import com.chess.pieces.Piece;

public class ChessPrinter {
    // Initialize the ANSI escape codes
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";

    // Clear the terminal screen
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Print the welcome message
    public static void printWelcomeMessage() {
        System.out.println("Welcome to Chess!");
    }

    // Print the chessboard
    public static void printChessboard(Chessboard chessboard) {
        System.out.println("  a b c d e f g h");
        for (int i = 0; i < chessboard.getChessboard().length; i++) {
            System.out.print(chessboard.getChessboard().length - i + " ");
            for (int j = 0; j < chessboard.getChessboard()[i].length; j++) {
                if (chessboard.getChessboard()[i][j] != null) {
                    System.out.print(chessboard.getChessboard()[i][j] + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println(chessboard.getChessboard().length - i);
        }
        System.out.println("  a b c d e f g h");
    }

    // Print the chessboard with the valid moves of the piece highlighted
    public static void printValidMoves(Chessboard chessboard, Piece piece) {
        System.out.println("  a b c d e f g h");
        for (int i = 0; i < chessboard.getChessboard().length; i++) {
            System.out.print(chessboard.getChessboard().length - i + " ");
            for (int j = 0; j < chessboard.getChessboard()[i].length; j++) {
                if (piece.canMove(chessboard.getChessboard(), i, j)) {
                    if (chessboard.getChessboard()[i][j] != null) {
                        System.out.print(ANSI_GREEN_BACKGROUND + chessboard.getChessboard()[i][j]
                                + ANSI_RESET + " ");
                    } else {
                        System.out.print(
                                ANSI_GREEN_BACKGROUND + "-" + ANSI_RESET + " ");
                    }
                } else {
                    if (chessboard.getChessboard()[i][j] != null) {
                        System.out.print(chessboard.getChessboard()[i][j] + " ");
                    } else {
                        System.out.print("- ");
                    }
                }
            }
            System.out.println(chessboard.getChessboard().length - i);
        }
        System.out.println("  a b c d e f g h");
    }

    // Print the captured pieces
    public static void printCapturedPieces(Piece[] capturedPieces) {
        System.out.print("Captured white pieces: [");
        for (int i = 0; i < capturedPieces.length; i++) {
            if (capturedPieces[i] != null) {
                if (capturedPieces[i].getColor().equals("White")) {
                    System.out.print(capturedPieces[i].toString());
                }
            }
        }
        System.out.println("]");
        System.out.print("Captured black pieces: [");
        for (int i = 0; i < capturedPieces.length; i++) {
            if (capturedPieces[i] != null) {
                if (capturedPieces[i].getColor().equals("Black")) {
                    System.out.print(capturedPieces[i].toString());
                }
            }
        }
        System.out.println("]");
    }

    // Print the current player
    public static void printCurrentPlayer(String currentPlayer) {
        System.out.println("Current player: " + currentPlayer);
    }
}
