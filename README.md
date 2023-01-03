# Chess

## About

A simple terminal-based two-player chess game in Java that implements the four pillars of OOP: abstraction, encapsulation, inheritance, and polymorphism.

## Manual

1. Initialize the chessboard by placing the pieces of both players in the correct position and set the first player to be white.
2. Display the chessboard in the terminal.
3. Ask the current player to enter the origin square of the piece they want to move (e.g. a1).
4. Validate the origin square input:
    - If the entered square is not in the chessboard, ask again.
    - If the entered square does not contain a piece, ask again.
    - If the entered square contains a piece but of the other player, ask again.
5. If the entered origin square is valid, display the chessboard with the squares for a valid move highlighted.
6. Ask the current player to enter the destination square of the piece (e.g. a1).
7. Validate the destination square input:
    - If the entered square is not one of the highlighted squares, repeat from step 2 and ask the player to enter the origin square again.
8. If the entered destination square is valid, move the piece and switch the current player to the other player.
9. Check for checkmate or stalemate. If either condition is met, end the game and display the result. If not, repeat from step 2.

Note:

- The game will check if a player is in check and will prompt the player to move out of check.
- Castling and en passant are included in the highlighted valid destination squares.
- For promotion, the player must enter the type of piece to promote (e.g. Q for queen).

## Authors

- Amodia, Kurt Matthew
- Gallego, Chester Ken
- Gambito, Ervene Jhay
