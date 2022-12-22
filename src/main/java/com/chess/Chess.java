/**
 * Chess.java
 * A class that represents a chess game.
 *
 * @author Kurt Matthew Amodia
 * @author Chester Ken Gallego
 * @author Ervene Jhay Gambito
 */

package com.chess;

import com.chess.chessboard.Chessboard;
import com.chess.pieces.King;
import com.chess.pieces.Pawn;
import com.chess.pieces.Piece;
import com.chess.players.Players;
import com.chess.util.ChessPrinter;
import com.chess.util.UserInputHandler;

public class Chess {
    public static void main(String[] args) {
        // Declare and initialize the variables
        Chessboard chessboard = new Chessboard();
        Piece piece;
        Piece[] capturedPieces = new Piece[32];
        String origin;
        String destination;
        String promotion;

        // Print the welcome message
        ChessPrinter.printWelcomeMessage();
        UserInputHandler.waitForEnter();

        // Loop until the game is over
        while (!chessboard.isCheckmate(Players.getCurrentPlayer())
                || !chessboard.isStalemate(Players.getCurrentPlayer())) {
            // Loop until the current player makes a valid move
            do {
                // Print the chessboard, captured pieces, and current player
                ChessPrinter.clearScreen();
                ChessPrinter.printChessboard(chessboard);
                System.out.println();
                ChessPrinter.printCapturedPieces(capturedPieces);
                System.out.println();
                ChessPrinter.printCurrentPlayer(Players.getCurrentPlayer().toString());
                System.out.println();
                // Get the origin of the piece
                do {
                    origin = UserInputHandler.getOrigin(chessboard);
                } while (!UserInputHandler.isValidOrigin(chessboard, origin));
                // Get the piece from the origin
                piece = chessboard.getPiece(origin);
                // Print the valid moves of the piece
                ChessPrinter.clearScreen();
                ChessPrinter.printValidMoves(chessboard, piece);
                System.out.println();
                // Get the destination of the piece
                destination = UserInputHandler.getDestination(chessboard, piece);
                // Check if the piece can move to the destination
                if (!piece.canMove(chessboard.getChessboard(), chessboard.getRank(destination),
                        chessboard.getFile(destination))) {
                    System.out.println("Invalid move! Try again.");
                    UserInputHandler.waitForEnter();
                }
            } while (!piece.canMove(chessboard.getChessboard(), chessboard.getRank(destination),
                    chessboard.getFile(destination)));
            if (!(piece instanceof King) && chessboard.isStillCheck(Players.getCurrentPlayer()) ||
                    chessboard.isStillCheck(Players.getNextPlayer())) {
                // Simulate the move
                chessboard.movePiece(origin, destination);
                if (chessboard.isStillCheck(Players.getCurrentPlayer())
                        || chessboard.isStillCheck(Players.getNextPlayer())) {
                    // Check if the move is a check, if still in check, skips code below and go to
                    // next iteration
                    System.out
                            .println("You must block the check or move your King to an unchecked position! Try again.");
                    UserInputHandler.waitForEnter();
                    // undo move
                    chessboard.movePiece(destination, origin);
                    continue;
                }
                chessboard.movePiece(destination, origin); // undo move
            }
            // Capture the piece at the destination if it is not empty
            if (!chessboard.isEmptySquare(destination)) {
                for (int i = 0; i < capturedPieces.length; i++) {
                    if (capturedPieces[i] == null) {
                        capturedPieces[i] = chessboard.getPiece(destination);
                        break;
                    }
                }
            }
            // Remove the piece if en passant
            if (piece instanceof Pawn && chessboard.getFile(origin) != chessboard.getFile(destination)
                    && chessboard.isEmptySquare(destination)) {
                for (int i = 0; i < capturedPieces.length; i++) {
                    if (capturedPieces[i] == null) {
                        capturedPieces[i] = chessboard.getPiece(chessboard.getRank(origin),
                                chessboard.getFile(destination));
                        chessboard.removePiece(chessboard.getRank(origin),
                                chessboard.getFile(destination));
                        break;
                    }
                }
            }
            // Move the piece to the destination
            chessboard.movePiece(origin, destination);
            // Promote the pawn if it reaches the last rank
            if (piece instanceof Pawn && (chessboard.getRank(destination) == 0
                    || chessboard.getRank(destination) == 7)) {
                promotion = UserInputHandler.getPromotion();
                chessboard.promotePawn(destination, promotion);
            }
            if (piece instanceof King) {
                // Check if the move is a check
                if (chessboard.isCheckAfterMove(piece, destination)) {
                    System.out.println("You cannot move your king into check! Try again.");
                    UserInputHandler.waitForEnter();
                    // Undo move
                    chessboard.movePiece(destination, origin);
                }
            }
            // Check if the move is a check
            if (chessboard.isCheck(Players.getCurrentPlayer()) || chessboard.isCheck(Players.getNextPlayer())) {
                System.out.println("Check!");
                UserInputHandler.waitForEnter();
            }
            // Switch the current player
            Players.switchCurrentPlayer();
        }

        // Print the final chessboard
        ChessPrinter.clearScreen();
        ChessPrinter.printChessboard(chessboard);
        System.out.println();
        // Print the result of the game
        if (chessboard.isCheckmate(Players.getCurrentPlayer())) {
            System.out.println("Checkmate! " + Players.getNextPlayer() + " wins!");
        } else if (chessboard.isStalemate(Players.getCurrentPlayer())) {
            System.out.println("Stalemate!");
        }
        UserInputHandler.waitForEnter();
    }
}
