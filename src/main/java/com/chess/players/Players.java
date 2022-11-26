/**
 * Players.java
 * A class that represents the players in a chess game.
 *
 * @author Kurt Matthew Amodia
 * @author Chester Ken Gallego
 * @author Ervene Jhay Gambito
 */

package com.chess.players;

public class Players {
    // Set the first player to white
    private static String currentPlayer = "White";

    // Get the current player
    public static String getCurrentPlayer() {
        return currentPlayer;
    }

    // Get the next player
    public static String getNextPlayer() {
        if (currentPlayer.equals("White")) {
            return "Black";
        } else {
            return "White";
        }
    }

    // Switch the current player to the next player
    public static void switchCurrentPlayer() {
        if (currentPlayer.equals("White")) {
            currentPlayer = "Black";
        } else {
            currentPlayer = "White";
        }
    }
}
