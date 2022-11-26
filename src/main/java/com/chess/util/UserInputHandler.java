/**
 * UserInputHandler.java
 * A class that contains the methods used to handle user input.
 *
 * @author Kurt Matthew Amodia
 * @author Chester Ken Gallego
 * @author Ervene Jhay Gambito
 */

package com.chess.util;

import java.util.Scanner;

import com.chess.chessboard.Chessboard;
import com.chess.pieces.Piece;
import com.chess.players.Players;

public class UserInputHandler {
    private static Scanner scanner = new Scanner(System.in);
    private static String origin;
    private static String destination;

    public static void waitForEnter() {
        scanner.nextLine();
    }

    public static boolean isValidSquare(String square) {
        if (square.length() != 2) {
            return false;
        }
        char file = square.charAt(0);
        char rank = square.charAt(1);
        return file >= 'a' && file <= 'h' && rank >= '1' && rank <= '8';
    }

    public static String getOrigin(Chessboard chessboard) {
        do {
            System.out.print("Enter origin (e.g. a1): ");
            origin = scanner.nextLine().toLowerCase();
            if (!isValidSquare(origin)) {
                System.out.println("Invalid square! Try again.");
                System.out.println();
            }
        } while (!isValidSquare(origin));
        return origin;
    }

    public static boolean isValidOrigin(Chessboard chessboard, String origin) {
        if (chessboard.getPiece(origin) == null) {
            System.out.println("No piece at this square! Try again.");
            System.out.println();
        } else if (!chessboard.getPiece(origin).getColor().equals(Players.getCurrentPlayer())) {
            System.out.println("You cannot move your opponent's piece! Try again.");
            System.out.println();
        }
        return chessboard.getPiece(origin) != null
                && chessboard.getPiece(origin).getColor().equals(Players.getCurrentPlayer());
    }

    public static String getDestination(Chessboard chessboard, Piece piece) {
        do {
            System.out.print("Enter destination (e.g. a1): ");
            destination = scanner.nextLine().toLowerCase();
            if (!isValidSquare(destination)) {
                System.out.println("Invalid square! Try again.");
                System.out.println();
            }
        } while (!isValidSquare(destination));
        return destination;
    }

    public static boolean isValidDestination(Chessboard chessboard, Piece piece, String destination) {
        if (!piece.canMove(chessboard.getChessboard(), chessboard.getRank(destination),
                chessboard.getFile(destination))) {
            System.out.println("Invalid move! Try again.");
            System.out.println();
        }
        return piece.canMove(chessboard.getChessboard(), chessboard.getRank(destination),
                chessboard.getFile(destination));
    }
}
