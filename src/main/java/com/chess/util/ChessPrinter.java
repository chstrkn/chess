/**
 * ChessPrinter.java
 * A class that contains the methods used to print the chess game to the terminal.
 *
 * @author Kurt Matthew Amodia
 * @author Chester Ken Gallego
 * @author Ervene Jhay Gambito
 */

package com.chess.util;

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

    // Print the current player
    public static void printCurrentPlayer(String currentPlayer) {
        System.out.println("Current player: " + currentPlayer);
    }
}
